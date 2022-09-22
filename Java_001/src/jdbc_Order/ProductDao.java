package jdbc_Order;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProductDao {

  public static Connection getConnection() throws Exception {
    Class.forName("oracle.jdbc.OracleDriver");
    Connection con =
        DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "LSW_DBA", "1111");
    return con;
  }

  // 상품목록 출력 메소드
  public ArrayList<ProductDto> selectProductList() {
    String sql = "SELECT * FROM PRODUCT";

    ArrayList<ProductDto> productList = new ArrayList<ProductDto>();

    try {
      Connection con = getConnection();

      PreparedStatement pstmt = con.prepareStatement(sql);
      ResultSet rs = pstmt.executeQuery();

      while (rs.next()) {
        ProductDto product = new ProductDto();

        product.setPdCode(rs.getString("PDCODE"));
        product.setPdName(rs.getString("PDNAME"));
        product.setPdPrice(rs.getInt("PDPRICE"));
        product.setPdAmount(rs.getInt("PDAMOUNT"));
        product.setPdType(rs.getString("PDTYPE"));

        productList.add(product);

      }

    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return productList;
  }

  // 주문번호 최대값 찾기 메소드
  public int selectMaxOdnum() {
    String sql = "SELECT NVL(MAX(ODNUM),0) AS max FROM ORDERLIST";
    int maxnum = 0;
    try {
      Connection con = getConnection();
      PreparedStatement pstmt = con.prepareStatement(sql);
      ResultSet rs = pstmt.executeQuery();
      while (rs.next()) {
        maxnum = rs.getInt("max");
      }
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return maxnum;
  }

  // ORDERLIST 테이블에 INSERT 메소드
  public int insertOrder(int odnum, String odmid, String odpdcode, int odqty) {
    String sql =
        "INSERT INTO ORDERLIST(ODNUM, ODMID, ODDATE, ODPDCODE, ODQTY) VALUES(?,?,SYSDATE,?,?)";
    int insertResult = 0;

    try {
      Connection con = getConnection();

      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setInt(1, odnum);
      pstmt.setString(2, odmid);
      pstmt.setString(3, odpdcode);
      pstmt.setInt(4, odqty);

      insertResult = pstmt.executeUpdate();

    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return insertResult;
  }

  public ArrayList<OrderListDto> selectOrderList(String loginId) {

    String sql = "SELECT * FROM ORDERLIST WHERE ODMID = ?";

    ArrayList<OrderListDto> orderList = new ArrayList<OrderListDto>();

    try {
      Connection con = getConnection();

      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setString(1, loginId);
      ResultSet rs = pstmt.executeQuery();

      while (rs.next()) {
        OrderListDto order = new OrderListDto();

        order.setOdnum(rs.getInt("ODNUM"));
        order.setOdmid(rs.getString("ODMID"));
        order.setOddate(rs.getString("ODDATE"));
        order.setOdpdcode(rs.getString("ODPDCODE"));
        order.setOdqty(rs.getInt("ODQTY"));

        orderList.add(order);

      }
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return orderList;
  }


}
