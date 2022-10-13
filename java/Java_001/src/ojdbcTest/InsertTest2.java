package ojdbcTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertTest2 {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    
    // 상품등록 새상품에 대한 정보를 전송
    String pdcode = "P4231";

    System.out.println("상품이름 입력>>");
    String pdname = scan.next();
    System.out.println("상품가격 입력>>");
    int pdprice = scan.nextInt();
    System.out.println("상품재고 입력>>");
    int pdamount = scan.nextInt();
    System.out.println("상품종류 입력>>");
    String pdtype = scan.next();
    
    
    // DB 접속을 위한 객체 선언
    Connection con = null;

    try {
      con = getConnection();
      System.out.println("DB연결 성공!!");
    } catch (Exception e) {
      System.out.println("DB연결 실패!!");
      e.printStackTrace();
    }

    String sql = "INSERT INTO PRODUCT(PDCODE,PDNAME,PDPRICE,PDAMOUNT,PDTYPE)"
        + "VALUES(?, ?, ?, ?, ?)";

    int insertResult = 0;

    try {
      PreparedStatement pstmt = con.prepareStatement(sql);
     
      pstmt.setString(1, pdcode);
      pstmt.setString(2, pdname);
      pstmt.setInt(3, pdprice);
      pstmt.setInt(4, pdamount);
      pstmt.setString(5, pdtype);
      
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
