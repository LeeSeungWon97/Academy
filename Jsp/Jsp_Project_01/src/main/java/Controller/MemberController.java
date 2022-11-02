package controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dto.MemberDto;
import service.MemberService;

/**
 * Servlet implementation class MemberController
 */
@WebServlet({"/memberLogin", "/memberJoin", "/memberInfo", "/memberList"})
public class MemberController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public MemberController() {
    super();
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String url = request.getServletPath();
    request.setCharacterEncoding("UTF-8");
    response.setContentType("text/html; charset=UTF-8");

    // session: 브라우저가 켜져있는동안 유지. 로그인 정보를 담아 두는역할로 사용
    HttpSession session = request.getSession();

    MemberService msvc = new MemberService();


    System.out.println("url: " + url);

    RequestDispatcher dispatcher = null;

    switch (url) {
      case "/memberLogin":
        // 1. SERVICE 클래스의 로그인 기능 호출 결과값 반환
        String inputId = request.getParameter("mid");
        String inputPw = request.getParameter("mpw");

        // 2. 결과값 확인
        String loginId = msvc.memberLogin(inputId, inputPw);

        // 3. 로그인 성공
        if (loginId != null) {
          session.setAttribute("loginId", loginId);
          response.sendRedirect("MainPage.jsp");
        } else {
          // 4. 로그인 실패
          response.getWriter().print("<script>");
          response.getWriter().print("alert('아이디 또는 비밀번호가 일치하지 않습니다.');");
          response.getWriter().print("history.back();");
          response.getWriter().print("</script>");
        }

        break;


      case "/memberJoin":
        // 1. SERVICE 클래스의 회원가입 기능 호출
        String joinMId = request.getParameter("mid");
        String joinMpw = request.getParameter("mpw");
        String joinMname = request.getParameter("mname");
        String joinMbirth = request.getParameter("mbirth");

        MemberDto joinMember = new MemberDto();
        joinMember.setMid(joinMId);
        joinMember.setMpw(joinMpw);
        joinMember.setMname(joinMname);
        joinMember.setMbirth(joinMbirth);

        // 2. 결과값 반환 및 확인
        int joinResult = msvc.memberJoin(joinMember);

        // 3. 회원가입 성공
        if (joinResult > 0) {
          response.sendRedirect("MainPage.jsp");

        } else {
          // 4. 회원가입 실패
          response.getWriter().print("<script>");
          response.getWriter().print("alert('회원가입 실패');");
          response.getWriter().print("history.back();");
          response.getWriter().print("</script>");
        }
        break;

      case "/memberInfo":
        System.out.println("회원정보 확인 요청");
        // 1. SERVICE 클래스의 회원정보 조회 기능 호출 & 반환

        // 정보 조회할 회원의 아이디 확인방법

        // (1) session
        String sessionLoginId = (String) session.getAttribute("loginId");
        System.out.println("로그인 아이디(세션): " + sessionLoginId);
        // (2) request
        String requestLoginId = request.getParameter("loginId");
        System.out.println("로그인 아이디_리퀘스트: " + requestLoginId);

        MemberDto mInfo = msvc.memberInfo(sessionLoginId);

        System.out.println(mInfo.toString());

        // 회원정보 출력 페이지 포워딩
        request.setAttribute("memberInfo", mInfo);
        dispatcher = request.getRequestDispatcher("MemberInfo.jsp");
        dispatcher.forward(request, response);

        break;

      case "/memberList":
        System.out.println("memberList 호출");
        // 1. SERVICE 회원목록 조회 기능 호출 & 회원목록 반환
        ArrayList<MemberDto> memberList = msvc.memberList();
        System.out.println(memberList.toString());
        // 2. 회원목록 출력 페이지 포워딩
        request.setAttribute("memberList", memberList);
        dispatcher = request.getRequestDispatcher("MemberList.jsp");
        dispatcher.forward(request, response);
        break;
    }

  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }

}

