package controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dto.BoardDto;
import service.BoardService;

/**
 * Servlet implementation class BoardController
 */
@WebServlet({"/boardList"})
public class BoardController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public BoardController() {
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
    
    RequestDispatcher dispatcher;

    
    // BoardService
    BoardService bsvc = new BoardService();
    
    switch (url) {
      case "/boardList":
        System.out.println("게시판 이동 요청");

        // 1. SERVICE에서 글목록 조회 기능 호출 & 글목록 반환
        ArrayList<BoardDto> boardList = bsvc.boardList();
        
        request.setAttribute("boardList", boardList);

        // 2. 글목록 페이지로 포워딩
        dispatcher = request.getRequestDispatcher("BOARD/BoardList.jsp");
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
