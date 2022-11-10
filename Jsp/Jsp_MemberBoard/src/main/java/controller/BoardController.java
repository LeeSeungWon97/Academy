package controller;

import java.io.IOException;
import java.net.URLEncoder;
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
@WebServlet({"/boardList", "/boardWrite", "/boardView", "/boardModifyPage", "/boardModify",
    "/boardDelete", "/boardSearch"})
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
    String contextPath = request.getContextPath();
    String url = request.getServletPath();
    System.out.println("요청 URL: " + url);
    request.setCharacterEncoding("UTF-8");
    response.setContentType("text/html; charset=UTF-8");

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

      case "/boardWrite":
        System.out.println("글등록 요청");

        String btitle = request.getParameter("btitle");
        String bcontent = request.getParameter("bcontent");
        String bwriter = request.getParameter("bwriter");

        BoardDto boardWrite = new BoardDto();
        boardWrite.setBtitle(btitle);
        boardWrite.setBcontent(bcontent);
        boardWrite.setBwriter(bwriter);

        int writeResult = bsvc.boardWrite(boardWrite);
        if (writeResult > 0) {
          System.out.println("게시판 추가 성공");
          response.sendRedirect(
              contextPath + "/boardList?msg=" + URLEncoder.encode("새 글이 등록되었습니다", "UTF-8"));
        } else {
          response.getWriter().print("<script>");
          response.getWriter().print("alert('게시판 추가 실패')");
          response.getWriter().print("history.back()");
          response.getWriter().print("</script>");
        }
        break;

      case "/boardView":
        System.out.println("글 상세보기 요청");
        int viewBno = Integer.parseInt(request.getParameter("viewBno"));
        System.out.println("viewBno: " + viewBno);

        BoardDto boardView = bsvc.boardView(viewBno, true);

        request.setAttribute("boardView", boardView);

        dispatcher = request.getRequestDispatcher("BOARD/BoardView.jsp");
        dispatcher.forward(request, response);
        break;

      case "/boardModifyPage":
        System.out.println("글 수정페이지 이동 요청");
        int modPageBno = Integer.parseInt(request.getParameter("bno"));
        System.out.println("수정페이지 글번호: " + modPageBno);
        BoardDto modPageBoard = bsvc.boardView(modPageBno, false);

        request.setAttribute("boardView", modPageBoard);
        dispatcher = request.getRequestDispatcher("BOARD/BoardModify.jsp");
        dispatcher.forward(request, response);
        break;

      case "/boardModify":
        System.out.println("글 수정하기 요청");
        int modBno = Integer.parseInt(request.getParameter("bno"));
        String modBtitle = request.getParameter("btitle");
        String modBcontent = request.getParameter("bcontent");

        int ModifyResult = bsvc.boardModify(modBno, modBtitle, modBcontent);
        System.out.println(ModifyResult);
        if (ModifyResult > 0) {
          response.sendRedirect("boardView?viewBno=" + modBno);
        } else {
          response.getWriter().print("<script>");
          response.getWriter().print("alert('게시판 수정 실패')");
          response.getWriter().print("history.back()");
          response.getWriter().print("</script>");
        }
        break;

      case "/boardDelete":
        System.out.println("글 삭제 요청");
        int deleteBno = Integer.parseInt(request.getParameter("bno"));
        System.out.println("삭제 요청 번호: " + deleteBno);

        int deleteResult = bsvc.boardDelete(deleteBno);

        if (deleteResult > 0) {
          response.getWriter().print("<script>");
          response.getWriter().print("alert('게시판 삭제 완료')");
          response.getWriter().print("</script>");
          response.sendRedirect("boardList");
        } else {
          response.getWriter().print("<script>");
          response.getWriter().print("alert('게시판 삭제 실패')");
          response.getWriter().print("history.back()");
          response.getWriter().print("</script>");
        }
        break;

      case "/boardSearch":
        System.out.println("게시글 검색 요청");
        String searchType = request.getParameter("searchType");
        String searchText = request.getParameter("searchText");

        ArrayList<BoardDto> boardSearchList = bsvc.boardSearchList(searchType, searchText);

        request.setAttribute("boardList", boardSearchList);
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
