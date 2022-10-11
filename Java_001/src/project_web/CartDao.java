package project_web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CartDao {

  // DB연결
  public static Connection getConnection() throws Exception {
    Class.forName("oracle.jdbc.OracleDriver");
    Connection con =
//        DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "P_DBA", "1111");
        DriverManager.getConnection("jdbc:oracle:thin:@//106.243.194.229:5757/xe", "PHS_DBA", "1111");
    return con;
  }


  // 장바구니 리스트 검색(id) - SELECT SQL
  public ArrayList<CartDto> cartList(String getmId) {
    ArrayList<CartDto> list = new ArrayList<CartDto>();

    String sql = "SELECT * FROM CART WHERE CID = ?";
    try {
      Connection con = getConnection();
      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setString(1, getmId);
      ResultSet rs = pstmt.executeQuery();

      while (rs.next()) {
        CartDto cdto = new CartDto();

        cdto.setcId(rs.getString("CID"));
        cdto.setcCode(rs.getString("CCODE"));
        cdto.setcName(rs.getString("CNAME"));
        cdto.setcPrice(rs.getInt("CPRICE"));
        cdto.setcAmount(rs.getInt("CAMOUNT"));
        cdto.setpTotal(rs.getInt("PTOTAL"));

        list.add(cdto);
      }
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return list;
  }



  // 장바구니 동일상품 수량 변경 - UPDATE SQL
  public int addAmount(String name, int amount, CartDto cdto) {
    int updateResult = 0;

    String sql = "UPDATE CART SET CAMOUNT = ?, PTOTAL = ? WHERE CNAME = ?";

    try {
      Connection con = getConnection();
      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setInt(1, cdto.getcAmount() + amount);
      pstmt.setInt(2, cdto.getcPrice() * (cdto.getcAmount() + amount));
      pstmt.setString(3, cdto.getcName());

      updateResult = pstmt.executeUpdate();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return updateResult;
  }


  // 장바구니 추가 - INSERT SQL
  public int addList(MemberDto loginInfo, ProductDto pdto, int amount) {
    int insertResult = 0;

    String sql =
        "INSERT INTO CART(CID, CCODE, CNAME, CPRICE, CAMOUNT, PTOTAL) " + "VALUES(?,?,?,?,?,?)";

    try {
      Connection con = getConnection();
      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setString(1, loginInfo.getmId());
      pstmt.setString(2, pdto.getPdCode());
      pstmt.setString(3, pdto.getPdName());
      pstmt.setInt(4, pdto.getPdPrice());
      pstmt.setInt(5, amount);
      pstmt.setInt(6, amount * pdto.getPdPrice());

      insertResult = pstmt.executeUpdate();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return insertResult;
  }


  // 장바구니 삭제 - DELETE SQL
  public int deleteList(String getmId, String pdCode) {
    int deleteResult = 0;

    String sql = "DELETE CART WHERE CID = ? AND CCODE = ?";

    try {
      Connection con = getConnection();
      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setString(1, getmId);
      pstmt.setString(2, pdCode);

      deleteResult = pstmt.executeUpdate();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return deleteResult;
  }



}
