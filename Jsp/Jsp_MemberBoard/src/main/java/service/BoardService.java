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

  public BoardDto boardView(int bno, boolean check) {
    System.out.println("BoardService boardView() 호출");
    BoardDto board = bdao.selectBoardView(bno);
    System.out.println(board.toString());
    
    if(check) {
      int updateResult = bdao.updateBoardHits(board);
      
      if(updateResult > 0) {
        System.out.println("최신화 완료");
      } else {
        System.out.println("최신화 실패");
      }      
      String bcontent = board.getBcontent();
      System.out.println("변환전: " + bcontent);
      
      bcontent = bcontent.replace(" ", "&nbsp;");
      
      bcontent = bcontent.replace("\r\n", "<br>");
      
      System.out.println("변환후: " + bcontent);
      
      board.setBcontent(bcontent);
    }
    return board;
  }

  
  
  public int boardModify(int modBno, String modBtitle, String modBcontent) {
    System.out.println("BoardService boardModify 호출()");
    int updateResult = bdao.updateBoardModify(modBno,modBtitle,modBcontent);
    return updateResult;
  }

  public int boardDelete(int deleteBno) {
    System.out.println("BoardServic boardDelete 호출()");
    int updateResult = bdao.updateBoardState(deleteBno);
    return updateResult;
  }

}
