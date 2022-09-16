package ojdbcTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertTest {

  public static void main(String[] args) {
    Connection con = null;
    try {
      con = getConnection();
      System.out.println("DB연결 성공!!");
    } catch (Exception e) {
      System.out.println("DB연결 실패!!");
      e.printStackTrace();
    }

    String sql = "INSERT INTO PRODUCT(PDCODE,PDNAME,PDPRICE,PDAMOUNT,PDTYPE)"
        + "VALUES('PTES1','입력테스트1',2000,100,'TEST')";

    int insertResult = 0;

    try {
      PreparedStatement pstmt = con.prepareStatement(sql);
      insertResult = pstmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    if (insertResult > 0) {
      System.out.println("새 상품이 등록되었습니다.");
    } else {
      System.out.println("새 상품이 등록에 실패했습니다.");
    }

    System.out.println("insertResult: " + insertResult);
  }

  public static Connection getConnection() throws Exception {
    Class.forName("oracle.jdbc.OracleDriver");
    Connection con =
        DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "LSW_DBA", "1111");
    return con;
  }

}
