package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDao {

  // DB연결
  public static Connection getConnection() throws Exception {
    Class.forName("oracle.jdbc.OracleDriver");
    Connection con =
        DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "JSP_PROJECT", "1111");
    return con;
  }

  public String selectMemberLogin(String inputId, String inputPw) {
    System.out.println("MemberDao selectLoginCheck() 호출");
    String sql = "SELECT * FROM MEMBERS WHERE MID = ? AND MPW = ?";
    String loginId = null;

    try {
      Connection con = getConnection();
      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setString(1, inputId);
      pstmt.setString(2, inputPw);
      
      ResultSet rs = pstmt.executeQuery();
      
      while(rs.next()) {
        loginId = rs.getString("MID");
      }
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return loginId;
  }

}
