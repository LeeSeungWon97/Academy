package project_webShop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class OrderDao {
  
  

  public static Connection getConnection() throws Exception {
    Class.forName("oracle.jdbc.OracleDriver");
    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//106.243.194.229:5757/xe",
        "PHS_DBA", "1111");
    return con;
  }


  // orderlist - 번호부여(odnum)
  private int maxNum() {
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


  // 구매 - insert
  public int purchase(ProductDto pdto, int pAmount, MemberDto currentMem) {
    int insertResult = 0;

    String sql =
        "INSERT INTO ORDERLIST(ODNUM,ODMID,ODDATE,ODPDCODE,ODAMOUNT) " + "VALUES(?,?,SYSDATE,?,?)";

    try {
      Connection con = getConnection();
      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setInt(1, maxNum());
      pstmt.setString(2, currentMem.getmId());
      pstmt.setString(3, pdto.getPdCode());
      pstmt.setInt(4, pAmount);

      insertResult = pstmt.executeUpdate();

    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return insertResult;
  }


  // 장바구니 추가 - insert
  public int addProduct(ProductDto pdto, int pAmount, MemberDto currentMem) {
    int insertResult = 0;

    String sql =
        "INSERT INTO CART(CID,CCODE,CNAME,CPRICE,CAMOUNT, PTOTAL) " + "VALUES(?,?,?,?,?,?)";
    try {
      Connection con = getConnection();
      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setString(1, currentMem.getmId());
      pstmt.setString(2, pdto.getPdCode());
      pstmt.setString(3, pdto.getPdName());
      pstmt.setInt(4, pdto.getPdPrice());
      pstmt.setInt(5, pAmount);
      pstmt.setInt(6, pdto.getPdPrice() * pAmount);
      
      insertResult = pstmt.executeUpdate();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return insertResult;
  }

  
  //  장바구니 리스트
  public ArrayList<OrderCartDto> showCartList(MemberDto currentMem) {
    
    ArrayList<OrderCartDto> memList = new ArrayList<OrderCartDto>();
    String sql = "SELECT * FROM CART WHERE CID = ?";
    try {
      Connection con = getConnection();
      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setString(1, currentMem.getmId());
      ResultSet rs = pstmt.executeQuery();
      
      while(rs.next()) {
        OrderCartDto dto = new OrderCartDto();
        dto.setcId(rs.getString("CID"));
        dto.setcCode(rs.getString("CCODE"));
        dto.setcName(rs.getString("CNAME"));
        dto.setcPrice(rs.getInt("CPRICE"));
        dto.setcAmount(rs.getInt("CAMOUNT"));
        dto.setpTotal(rs.getInt("PTOTAL"));
        
        memList.add(dto);
      }
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    return memList;
  }


  // 구매목록
  public ArrayList<OrderListDto> showBuyList(String getmId) {
    ArrayList<OrderListDto> myBuyList = new ArrayList<OrderListDto>();
    String sql = "SELECT * FROM ORDERLIST WHERE ODMID = ?";
    
    try {
      Connection con = getConnection();
      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setString(1, getmId);
      ResultSet rs = pstmt.executeQuery();
     
      while(rs.next()) {
        OrderListDto dto = new OrderListDto();
        dto.setOdNum(rs.getInt("ODNUM"));
        dto.setOdMid(getmId);
        dto.setOdDate(rs.getString("ODDATE"));
        dto.setOdPdCode(rs.getString("ODPDCODE"));
        dto.setOdAmount(rs.getInt("ODAMOUNT"));
        
        myBuyList.add(dto);
      }
      
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return myBuyList;
  }


  // 상품 취소
  public void buyCancle(int odnum) {
    String sql = "DELETE FROM ORDERLIST WHERE ODNUM = ?";
    try {
      Connection con = getConnection();
      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setInt(1, odnum);
      int deleteResult = pstmt.executeUpdate();
      
      if(deleteResult == 1) {
        
      }
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }


  // 취소상품 찾기
  public String findPdCode(int odnum) {
    String code = "";
    
    String sql = "SELECT * FROM ORDERLIST WHERE ODNUM = ?";
    try {
      Connection con = getConnection();
      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setInt(1, odnum);
      ResultSet rs = pstmt.executeQuery();
      
      if(rs.next()) {
        code = rs.getString("ODPDCODE");
      }
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return code;
  }
  
  // 취소상품 찾기
  public int findPdAmount(int odnum) {
    int amount = 0;
    
    String sql = "SELECT * FROM ORDERLIST WHERE ODNUM = ?";
    try {
      Connection con = getConnection();
      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setInt(1, odnum);
      ResultSet rs = pstmt.executeQuery();
      
      if(rs.next()) {
        amount = rs.getInt("ODAMOUNT");
      }
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return amount;
  }






  
  

}
