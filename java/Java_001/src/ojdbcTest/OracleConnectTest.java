package ojdbcTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OracleConnectTest {

  public static void main(String[] args) {
    // DB 접속을 위한 객체 선언
    Connection con = null;
    try {
      con = getConnection();
      System.out.println("DB연결 성공!!");
    } catch (Exception e) {
      System.out.println("DB연결 실패!!");
      e.printStackTrace();
    }

    // 쿼리문 작성
    String sql = "SELECT * FROM PRODUCT";

    try {
      // 작성된 쿼리문을 전송하기 위한 용도
      PreparedStatement pstmt = con.prepareStatement(sql);

      // 실행결과를 담아둠 (SELECT문인 경우)
      ResultSet rs = pstmt.executeQuery();
      while (rs.next()) {
        System.out.print(rs.getString(1));
        System.out.print(" " + rs.getString(2));
        System.out.println(" " + rs.getInt("PDPRICE"));
      }
      rs.close();
      pstmt.close();
      con.close();
      
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
        
    }
  }

  public static Connection getConnection() throws Exception {
    Class.forName("oracle.jdbc.OracleDriver");
    Connection con =
        DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "LSW_DBA", "1111");
    return con;
  }

}
