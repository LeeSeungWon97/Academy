package service;

import java.util.ArrayList;
import dao.BoardDao;
import dto.BoardDto;

public class BoardService {

  BoardDao bdao = new BoardDao();

  public ArrayList<BoardDto> boardList() {
    System.out.println("BoardService boardList() 호출");
    ArrayList<BoardDto> boardList = bdao.selectBoardList();

    return boardList;
  }

  public int boardWrite(BoardDto boardWrite) {
    System.out.println("BoardService boardWrite() 호출");
    
    int bno = bdao.selectMaxBno() + 1;
    System.out.println("bno: " + bno);
    boardWrite.setBno(bno);
    
    int insertResult = bdao.insertBoard(boardWrite);
    
    return insertResult;
  }

  public BoardDto boardView(BoardDto boardView) {
    System.out.println("BoardService boardView() 호출");
    BoardDto board = bdao.boardView(boardView.getBno());
    System.out.println(board.toString());
    int updateResult = bdao.boardUpdate(board);
    
    if(updateResult > 0) {
      System.out.println("최신화 완료");
    } else {
      System.out.println("최신화 실패");
    }
    
    return board;
  }

}
