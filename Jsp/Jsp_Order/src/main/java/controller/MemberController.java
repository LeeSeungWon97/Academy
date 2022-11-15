package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.MemberService;

/**
 * Servlet implementation class MemberController
 */
@WebServlet({"/memberLogin", "/memberLogout"})
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
    String url = request.getServletPath();
    System.out.println("요청 URL: " + url);

    String contextPath = request.getContextPath();

    request.setCharacterEncoding("UTF-8");
    response.setContentType("text/html; charset=UTF-8");

    HttpSession session = request.getSession();

    MemberService msvc = new MemberService();

    switch (url) {
      case "/memberLogin":
        System.out.println("로그인 요청");
        String inputId = request.getParameter("mid");
        String inputPw = request.getParameter("mpw");
        String sendUrl = request.getParameter("afterUrl");
        System.out.println("받은 URL: " + sendUrl);
        String loginId = msvc.loginCheck(inputId, inputPw);

        if (loginId != null) {
          session.setAttribute("loginId", loginId);
          if (sendUrl != "") {
            response.sendRedirect(contextPath + sendUrl);
          } else {
            response.sendRedirect(contextPath + "/Main.jsp");
          }
        } else {
          response.getWriter().print("<script>");
          response.getWriter().print("alert('아이디 또는 비밀번호가 틀렸습니다.');");
          response.getWriter().print("history.back();");
          response.getWriter().print("</script>");
        }
        break;

      case "/memberLogout":
        System.out.println("로그아웃 요청");
        session.invalidate();
        response.sendRedirect(contextPath + "/Main.jsp");
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
