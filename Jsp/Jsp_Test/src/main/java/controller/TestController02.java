package controller;

import java.io.IOException;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestController02
 */
@WebServlet("/TestController02")
public class TestController02 extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public TestController02() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    System.out.println("TestController02 요청");    
    
    // dispatcher: 요청(request)이 들어오고 응답(response)를 해주어도 요청에 대한 데이터들이 사라지지 않음. 데이터를 사용가능. 
    request.setAttribute("tData01", "testData"); // tData01: 변수명 , testData: 데이터 값
    RequestDispatcher dispatcher = request.getRequestDispatcher("test01.jsp");
    dispatcher.forward(request, response);
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
