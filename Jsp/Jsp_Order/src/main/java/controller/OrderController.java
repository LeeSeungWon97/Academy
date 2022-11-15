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
import dto.OrderInfoDto;
import dto.ProductDto;
import service.OrderService;

/**
 * Servlet implementation class OrderController
 */
@WebServlet({"/productList", "/productOrder", "/orderList"})
public class OrderController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public OrderController() {
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

    RequestDispatcher dispatcher;
    HttpSession session = request.getSession();

    OrderService osvc = new OrderService();

    switch (url) {
      case "/productList":
        System.out.println("상품목록 요청");
        ArrayList<ProductDto> productList = osvc.showProductList();

        request.setAttribute("prList", productList);
        dispatcher = request.getRequestDispatcher("/ORDER/ProductList.jsp");
        dispatcher.forward(request, response);
        break;

      case "/productOrder":
        System.out.println("상품 주문 요청");
        String prcode = request.getParameter("prcode");
        String ormid = (String) session.getAttribute("loginId");
        if (ormid == null) {
          response.sendRedirect(contextPath + "/MEMBER/MemberLoginForm.jsp?afterUrl=/productList");
        } else {
          System.out.println("주문한 상품코드: " + prcode + " 주문한 아이디: " + ormid);
          int orderResult = osvc.order(prcode, ormid);
          if (orderResult > 0) {
            response.getWriter().print("<script>");
            response.getWriter().print("alert('주문성공');");
            response.getWriter().print("history.back();");
            response.getWriter().print("</script>");
          } else {
            response.getWriter().print("<script>");
            response.getWriter().print("alert('주문실패');");
            response.getWriter().print("history.back();");
            response.getWriter().print("</script>");
          }
        }
        break;

      case "/orderList":
        System.out.println("주문내역 요청");
        String orderMid = (String) session.getAttribute("loginId");
        ArrayList<OrderInfoDto> orderInfo = osvc.showOrderInfo(orderMid);

        request.setAttribute("orderInfo", orderInfo);
        dispatcher = request.getRequestDispatcher("/ORDER/OrderList.jsp");
        dispatcher.forward(request, response);
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
