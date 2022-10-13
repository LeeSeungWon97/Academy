package project_web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class OrderListDao {

  // DB연결
  public static Connection getConnection() throws Exception {
    Class.forName("oracle.jdbc.OracleDriver");
    Connection con =
        DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "P_DBA", "1111");
    return con;
  }

  // 상품구매 - INSERT SQL
  public int orderProduct(ProductDto pdto, MemberDto loginInfo, int amount) {
    int insertResult = 0;

    String sql = "INSERT INTO ORDERLIST (ODNUM, ODMID, ODDATE, ODPDCODE, ODAMOUNT) "
        + "VALUES(?,?,SYSDATE,?,?)";

    try {
      Connection con = getConnection();
      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setInt(1, odNumMax());
      pstmt.setString(2, loginInfo.getmId());
      pstmt.setString(3, pdto.getPdCode());
      pstmt.setInt(4, amount);

      insertResult = pstmt.executeUpdate();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return insertResult;
  }


  // odnum 최대값 구하기 - SELECT SQL
  private int odNumMax() {
    int max = 0;
    String sql = "SELECT NVL(MAX(ODNUM),0) AS MAX FROM ORDERLIST";

    try {
      Connection con = getConnection();
      PreparedStatement pstmt = con.prepareStatement(sql);
      ResultSet rs = pstmt.executeQuery();

      if (rs.next()) {
        max = rs.getInt("MAX");
      }
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return max + 1;
  }


  // 회원 구매목록 출력 - SELECT SQL
  public ArrayList<OrderListDto> showMyList(String getmId) {
    ArrayList<OrderListDto> list = new ArrayList<OrderListDto>();

    String sql = "SELECT * FROM ORDERLIST WHERE ODMID = ?";

    try {
      Connection con = getConnection();
      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setString(1, getmId);
      ResultSet rs = pstmt.executeQuery();

      while (rs.next()) {
        OrderListDto odto = new OrderListDto();
        odto.setOdNum(rs.getInt("ODNUM"));
        odto.setOdMid(rs.getString("ODMID"));
        odto.setOdDate(rs.getString("ODDATE"));
        odto.setOdPdCode(rs.getString("ODPDCODE"));
        odto.setOdAmount(rs.getInt("ODAMOUNT"));

        list.add(odto);
      }
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return list;
  }


  // 구매내역 삭제 - DELETE SQL
  public int deleteList(int odNum) {
    int deleteResult = 0;

    String sql = "DELETE ORDERLIST WHERE ODNUM = ?";

    try {
      Connection con = getConnection();
      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setInt(1, odNum);

      deleteResult = pstmt.executeUpdate();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return deleteResult;
  }


}
