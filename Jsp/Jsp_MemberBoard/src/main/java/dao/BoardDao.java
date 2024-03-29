package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import dto.BoardDto;

public class BoardDao {

  // DB연결
  public static Connection getConnection() throws Exception {
    Class.forName("oracle.jdbc.OracleDriver");
    Connection con =
        DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "JSP_PROJECT", "1111");
    return con;
  }


  // Board 테이블 SELECT
  public ArrayList<BoardDto> selectBoardList() {
    System.out.println("BoardDao selectBoardList()");
    String sql = "SELECT * FROM BOARDS WHERE BSTATE=0 ORDER BY BNO DESC";
    ArrayList<BoardDto> boardList = new ArrayList<BoardDto>();

    try {
      Connection con = getConnection();
      PreparedStatement pstmt = con.prepareStatement(sql);
      ResultSet rs = pstmt.executeQuery();

      while (rs.next()) {
        BoardDto bdto = new BoardDto();
        bdto.setBno(rs.getInt(1));
        bdto.setBtitle(rs.getString(2));
        bdto.setBwriter(rs.getString(3));
        bdto.setBcontent(rs.getString(4));
        bdto.setBdate(rs.getString(5));
        bdto.setBhits(rs.getInt(6));
        bdto.setBfilename(rs.getString(7));
        bdto.setBstate(rs.getString(8));

        boardList.add(bdto);
      }
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }


    return boardList;
  }


  // BNO 최대값 찾기 - SELECT
  public int selectMaxBno() {
    String slq = "SELECT NVL(MAX(BNO),0) FROM BOARDS";
    int selectResult = 0;

    try {
      Connection con = getConnection();
      PreparedStatement pstmt = con.prepareStatement(slq);
      ResultSet rs = pstmt.executeQuery();

      while (rs.next()) {
        selectResult = rs.getInt(1);
      }

    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return selectResult;
  }


  // 글목록 추가
  public int insertBoard(BoardDto boardWrite) {
    System.out.println("BoardDao insertBoard() 호출");

    String sql =
        "INSERT INTO BOARDS(BNO, BTITLE, BWRITER, BCONTENT, BDATE, BHITS, BFILENAME, BSTATE) "
            + "VALUES(?,?,?,?, SYSDATE, 0, '', '0')";
    int insertResult = 0;

    try {
      Connection con = getConnection();
      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setInt(1, boardWrite.getBno());
      pstmt.setString(2, boardWrite.getBtitle());
      pstmt.setString(3, boardWrite.getBwriter());
      pstmt.setString(4, boardWrite.getBcontent());

      insertResult = pstmt.executeUpdate();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return insertResult;
  }


  public BoardDto selectBoardView(int bno) {
    System.out.println("BoardDao boardView() 호출");

    String sql = "SELECT * FROM BOARDS WHERE BNO = ?";

    BoardDto boardView = new BoardDto();
    try {
      Connection con = getConnection();
      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setInt(1, bno);

      ResultSet rs = pstmt.executeQuery();

      while (rs.next()) {
        boardView.setBno(rs.getInt("BNO"));
        boardView.setBtitle(rs.getString("BTITLE"));
        boardView.setBwriter(rs.getString("BWRITER"));
        boardView.setBcontent(rs.getString("BCONTENT"));
        boardView.setBdate(rs.getString("BDATE"));
        boardView.setBhits(rs.getInt("BHITS") + 1);
        boardView.setBfilename(rs.getString("BFILENAME"));
        boardView.setBstate(rs.getString("BSTATE"));
      }
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return boardView;
  }


  public int updateBoardHits(BoardDto board) {
    System.out.println("BoardDao boardUpdate() 호출");

    String sql = "UPDATE BOARDS SET BHITS = ? WHERE BNO = ?";
    int updateResult = 0;

    try {
      Connection con = getConnection();
      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setInt(1, board.getBhits());
      pstmt.setInt(2, board.getBno());


      updateResult = pstmt.executeUpdate();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return updateResult;
  }


  public int updateBoardModify(int modBno, String modBtitle, String modBcontent) {
    System.out.println("BoardDao updateBoardModify 호출()");
    String sql = "UPDATE BOARDS SET BTITLE = ? , BCONTENT = ? WHERE BNO = ?";
    int updateResult = 0;

    try {
      Connection con = getConnection();
      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setString(1, modBtitle);
      pstmt.setString(2, modBcontent);
      pstmt.setInt(3, modBno);

      updateResult = pstmt.executeUpdate();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return updateResult;
  }


  public int updateBoardState(int deleteBno) {
    System.out.println("BoardDao updateBoardState() 호출");
    String sql = "UPDATE BOARDS SET BSTATE = 1 WHERE BNO=?";
    int updateResult = 0;

    try {
      Connection con = getConnection();
      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setInt(1, deleteBno);

      updateResult = pstmt.executeUpdate();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return updateResult;
  }


  public ArrayList<BoardDto> selectBoardSearch(String searchType, String searchText) {
    System.out.println("BoardDao selectBoardSearch()");
    String sql = "SELECT * FROM BOARDS WHERE BSTATE = '0'";

    switch (searchType) {
      case "title":
        sql += " AND BTITLE LIKE '%" + searchText + "%'";
        break;

      case "content":
        sql += " AND BCONTENT LIKE '%" + searchText + "%'";
        break;

      case "titleContent":
        sql += " AND (BTITLE LIKE '%" + searchText + "%' OR BCONTENT LIKE '%" + searchText + "%')";
        break;

      case "writer":
        sql += " AND BWRITER LIKE '%" + searchText + "%'";
        break;
    }

    System.out.println(sql);
    ArrayList<BoardDto> boardList = new ArrayList<BoardDto>();

    try {
      Connection con = getConnection();
      PreparedStatement pstmt = con.prepareStatement(sql);
      ResultSet rs = pstmt.executeQuery();

      while (rs.next()) {
        BoardDto bdto = new BoardDto();
        bdto.setBno(rs.getInt(1));
        bdto.setBtitle(rs.getString(2));
        bdto.setBwriter(rs.getString(3));
        bdto.setBcontent(rs.getString(4));
        bdto.setBdate(rs.getString(5));
        bdto.setBhits(rs.getInt(6));
        bdto.setBfilename(rs.getString(7));
        bdto.setBstate(rs.getString(8));

        boardList.add(bdto);
      }
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return boardList;
  }


  public int selectBoardCount(String infoId) {
    System.out.println("BoardDao selectBoardCount() 호출");
    String sql = "SELECT COUNT(*) FROM BOARDS WHERE BWRITER=?";
    int count = 0;

    try {
      Connection con = getConnection();
      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setString(1, infoId);

      ResultSet rs = pstmt.executeQuery();

      while (rs.next()) {
        count = rs.getInt(1);
      }
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return count;
  }


  public int selectBoardDeleteCount(String infoId) {
    System.out.println("BoardDao selectBoardCount() 호출");
    String sql = "SELECT COUNT(*) FROM BOARDS WHERE BWRITER=? AND BSTATE=1";
    int count = 0;

    try {
      Connection con = getConnection();
      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setString(1, infoId);
      ResultSet rs = pstmt.executeQuery();

      while (rs.next()) {
        count = rs.getInt(1);
        
      }
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return count;
  }

}
