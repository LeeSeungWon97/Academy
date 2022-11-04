package controller;

import java.io.IOException;
import java.net.URLEncoder;
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
@WebServlet({"/memberJoin", "/memberLogin"})
public class MemberController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public MemberController() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // TODO Auto-generated method stub
    String url = request.getServletPath();
    System.out.println("요청 URL: " + url);
    request.setCharacterEncoding("UTF-8");
    response.setContentType("text/html; charset=UTF-8");

    String contextPath = request.getContextPath();
    
    MemberService msvc = new MemberService();
    
    HttpSession session = request.getSession();

    switch (url) {
      case "/memberJoin":
        System.out.println("회원가입 요청");

        MemberDto joinMember = new MemberDto();

        String joinMid = request.getParameter("mid");
        joinMember.setMid(joinMid);
        String joinMpw = request.getParameter("mpw");
        joinMember.setMpw(joinMpw);
        String joinMname = request.getParameter("mname");
        joinMember.setMname(joinMname);
        String joinMbirth = request.getParameter("mbirth");
        joinMember.setMbirth(joinMbirth);
        String joinMaddr = request.getParameter("maddr");
        joinMember.setMaddr(joinMaddr);
        String joinEmailId = request.getParameter("emailId");
        String joinDomain = request.getParameter("emailDomain");
        joinMember.setMemail(joinEmailId + "@" + joinDomain);

        System.out.println(joinMember);

        int insertResult = msvc.memberJoin(joinMember);

        System.out.println("insertResult: " + insertResult);

        if (insertResult > 0) {
          response.getWriter().print("<script>");
          response.getWriter().print("alert('회원가입 성공');");
          response.getWriter().print("location.href = 'Main.jsp'");
          response.getWriter().print("</script>");

        } else {
          // 4. 회원가입 실패
          response.getWriter().print("<script>");
          response.getWriter().print("alert('회원가입 실패');");
          response.getWriter().print("history.back();");
          response.getWriter().print("</script>");
        }
        break;
        
      case "/memberLogin":
        System.out.println("로그인 요청");
        String inputId = request.getParameter("mid");
        String inputPw = request.getParameter("mpw");
        System.out.println("inputId: " + inputId + "  inputPw: " + inputPw);
        String loginId = msvc.memberLogin(inputId, inputPw);
        if(loginId != null) {
          session.setAttribute("loginId", loginId);
          response.sendRedirect(contextPath+"/Main.jsp?msg="+URLEncoder.encode("로그인 되었습니다.","UTF-8"));
        } else {
          response.getWriter().print("<script>");
          response.getWriter().print("alert('아이디 또는 비밀번호가 틀렸습니다.');");
          response.getWriter().print("history.back();");
          response.getWriter().print("</script>");
        }
        break;
    }
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // TODO Auto-generated method stub
    doGet(request, response);
  }

}
