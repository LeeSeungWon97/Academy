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

}
