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
    String sql = "SELECT * FROM BOARDS";
    ArrayList<BoardDto> boardList = new ArrayList<BoardDto>();
    
    try {
      Connection con = getConnection();
      PreparedStatement pstmt = con.prepareStatement(sql);
      ResultSet rs = pstmt.executeQuery();
      
      while(rs.next()) {
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

}
