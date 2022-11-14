package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import dto.ProductDto;

public class OrderDao {

  // DB연결
  public static Connection getConnection() throws Exception {
    Class.forName("oracle.jdbc.OracleDriver");
    Connection con =
        DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "JSP_PROJECT", "1111");
    return con;
  }

  public int insertProduct(ProductDto prInfo) {
    System.out.println("OrderDao insertProduct");
    String sql =
        "INSERT INTO PRODUCTS(PRCODE, PRBRAND, PRNAME, PRPRICE, PRIMG) " + "VALUES(?,?,?,?,?)";
    int insertResult = 0;

    try {
      Connection con = getConnection();
      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setString(1, prInfo.getPrcode());
      pstmt.setString(2, prInfo.getPrbrand());
      pstmt.setString(3, prInfo.getPrname());
      pstmt.setInt(4, prInfo.getPrprice());
      pstmt.setString(5, prInfo.getPrimg());

      insertResult = pstmt.executeUpdate();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return insertResult;
  }


  public int selectMaxNum() {
    System.out.println("OrderDao selectMaxNum");
    String sql = "SELECT COUNT(*) FROM PRODUCTS";
    int maxNum = 0;

    try {
      Connection con = getConnection();
      PreparedStatement pstmt = con.prepareStatement(sql);

      ResultSet rs = pstmt.executeQuery();
      while (rs.next()) {
        maxNum = rs.getInt(1);
      }
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return maxNum;
  }

  public ProductDto searchProduct(String productName) {
    System.out.println("OrderDao searchProduct");
    String sql = "SELECT * FROM PRODUCTS WHERE PRNAME = ?";
    ProductDto prInfo = new ProductDto();

    try {
      Connection con = getConnection();
      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setString(1, productName);

      ResultSet rs = pstmt.executeQuery();

      while (rs.next()) {
        prInfo.setPrcode(rs.getString(1));
        prInfo.setPrbrand(rs.getString(2));
        prInfo.setPrname(rs.getString(3));
        prInfo.setPrprice(rs.getInt(4));
        prInfo.setPrimg(rs.getString(5));
      }
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return prInfo;
  }

  public ArrayList<ProductDto> selectProductList() {
    System.out.println("OrderDao selectProductList()");
    String sql = "SELECT * FROM PRODUCTS ORDER BY PRCODE ASC";
    ArrayList<ProductDto> list = new ArrayList<ProductDto>();
    
    try {
      Connection con = getConnection();
      PreparedStatement pstmt = con.prepareStatement(sql);
      ResultSet rs = pstmt.executeQuery();
      
      while(rs.next()) {
        ProductDto pdto = new ProductDto();
        pdto.setPrcode(rs.getString(1));
        pdto.setPrbrand(rs.getString(2));
        pdto.setPrname(rs.getString(3));
        pdto.setPrprice(rs.getInt(4));
        pdto.setPrimg(rs.getString(5));
        
        list.add(pdto);
      }
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return list;
  }

}
