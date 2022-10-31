package Controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("/memberLogin")
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
    response.setContentType("text/html; charset=UTF-8");

    // session: 브라우저가 켜져있는동안 유지. 로그인 정보를 담아 두는역할로 사용
    HttpSession session = request.getSession();

    System.out.println("get!");

    // 로그인 페이지의 아이디, 비밀번호
    String inputId = request.getParameter("mid");
    System.out.println("입력한 아이디: " + inputId);
    String inputPw = request.getParameter("mpw");
    System.out.println("입력한 비밀번호: " + inputPw);

    if (inputId.equals("yyyy") && inputPw.equals("1111")) {
      System.out.println("로그인 되었습니다.");
      // MainPage.jsp 이동
      session.setAttribute("loginId", inputId);
      request.setAttribute("reLoginId", inputId);
      RequestDispatcher dispatcher = request.getRequestDispatcher("MainPage.jsp");
      dispatcher.forward(request, response);
//      response.sendRedirect("MainPage.jsp");

    } else {
      System.out.println("아이디 또는 비밀번호가 일치하지 않습니다.");
      // MemberLoginForm.jsp 이동
//      response.sendRedirect("loginFail.jsp");
      response.getWriter().print("<script>");
      response.getWriter().print("alert('아이디 또는 비밀번호가 일치하지 않습니다.');");
      response.getWriter().print("history.back();");
      response.getWriter().print("</script>");
    }

  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    System.out.println("post!");
    doGet(request, response);
  }

}
