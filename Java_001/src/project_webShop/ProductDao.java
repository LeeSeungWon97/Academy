package project_webShop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class ProductDao {

  ProductDto pdto = new ProductDto();
  Scanner scan = new Scanner(System.in);


  public static Connection getConnection() throws Exception {
    Class.forName("oracle.jdbc.OracleDriver");
    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//106.243.194.229:5757/xe",
        "PHS_DBA", "1111");
    return con;
  }


  // 상품추가 sql
  public int addList(ProductDto pDto) {
    String sql =
        "INSERT INTO PRODUCT(PDCODE, PDNAME, PDPRICE, PDAMOUNT, PDTYPE) " + "VALUES(?,?,?,?,?)";

    int insertResult = 0;

    try {
      Connection con = getConnection();
      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setString(1, pDto.getPdCode());
      pstmt.setString(2, pDto.getPdName());
      pstmt.setInt(3, pDto.getPdPrice());
      pstmt.setInt(4, pDto.getPdAmount());
      pstmt.setString(5, pDto.getPdType());

      insertResult = pstmt.executeUpdate();

    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return insertResult;
  }


  // 상품추가 - pdCode 구하기
  public int setCodeNum(String pdType) {
    int codeNum = 0;
    
    String sql = "SELECT COUNT(*) FROM PRODUCT WHERE PDTYPE = ?";
    
    try {
      Connection con = getConnection();
      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setString(1, pdType);
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    return codeNum + 1;
  }
  
  
}
