package project_web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProductDao {

  // DB연결
  public static Connection getConnection() throws Exception {
    Class.forName("oracle.jdbc.OracleDriver");
    Connection con =
        DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "P_DBA", "1111");
    return con;
  }

  // 상품이름 조회 - SELECT SQL
  public boolean productCheck(String pName) {
    boolean check = false;

    String sql = "SELECT * FROM PRODUCT WHERE PDNAME = ?";
    try {
      Connection con = getConnection();
      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setString(1, pName);
      ResultSet rs = pstmt.executeQuery();

      if (rs.next()) {
        check = true;
      }

    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return check;
  }
  
  
  // 상품정보 가져오기(PDCODE) - SELECT SQL
  public ProductDto searchPdto(String odPdCode) {
    ProductDto pdto = new ProductDto();

    String sql = "SELECT * FROM PRODUCT WHERE PDCODE = ?";
    try {
      Connection con = getConnection();
      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setString(1, odPdCode);
      ResultSet rs = pstmt.executeQuery();

      if (rs.next()) {
        pdto.setPdCode(rs.getString("PDCODE"));
        pdto.setPdName(rs.getString("PDNAME"));
        pdto.setPdPrice(rs.getInt("PDPRICE"));
        pdto.setPdAmount(rs.getInt("PDAMOUNT"));
        pdto.setPdType(rs.getString("PDTYPE"));
      }

    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return pdto;
  }

  // 상품정보 가져오기(PDNAME) - SELECT SQL
  public ProductDto recievePdto(String pName) {
    ProductDto pdto = new ProductDto();

    String sql = "SELECT * FROM PRODUCT WHERE PDNAME = ?";
    try {
      Connection con = getConnection();
      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setString(1, pName);
      ResultSet rs = pstmt.executeQuery();

      if (rs.next()) {
        pdto.setPdCode(rs.getString("PDCODE"));
        pdto.setPdName(rs.getString("PDNAME"));
        pdto.setPdPrice(rs.getInt("PDPRICE"));
        pdto.setPdAmount(rs.getInt("PDAMOUNT"));
        pdto.setPdType(rs.getString("PDTYPE"));
      }

    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return pdto;
  }

  // PDCODE 구하기 - SELECT SQL
  public int setCodeNum(String pdType) {
    int count = 0;

    String sql = "SELECT COUNT(*) FROM PRODUCT WHERE PDTYPE = ?";

    try {
      Connection con = getConnection();
      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setString(1, pdType);

      ResultSet rs = pstmt.executeQuery();

      while (rs.next()) {
        count += rs.getInt("COUNT(*)");
      }
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return count + 1;
  }

  // PRODUCT 테이블에 상품추가 - INSERT SQL
  public int addProduct(ProductDto pdto) {
    String sql =
        "INSERT INTO PRODUCT(PDCODE, PDNAME, PDPRICE, PDAMOUNT, PDTYPE) " + "VALUES(?,?,?,?,?)";

    int insertResult = 0;

    try {
      Connection con = getConnection();
      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setString(1, pdto.getPdCode());
      pstmt.setString(2, pdto.getPdName());
      pstmt.setInt(3, pdto.getPdPrice());
      pstmt.setInt(4, pdto.getPdAmount());
      pstmt.setString(5, pdto.getPdType());

      insertResult = pstmt.executeUpdate();

    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return insertResult;
  }

  // 상품 가격&수량 수정 - UPDATE SQL
  public int pdUpdate(String pName, int selectNum, int change) {
    String sql;
    int updateResult = 0;

    if (selectNum == 1) {
      sql = "UPDATE PRODUCT SET PDPRICE = ? WHERE PDNAME = ?";
    } else {
      sql = "UPDATE PRODUCT SET PDAMOUNT = ? WHERE PDNAME = ?";
    }

    try {
      Connection con = getConnection();
      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setInt(1, change);
      pstmt.setString(2, pName);

      updateResult = pstmt.executeUpdate();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return updateResult;
  }


  // 인기상품 출력 - SELECT SQL
  public ArrayList<String[]> showBestProduct() {
    ArrayList<String[]> bestList = new ArrayList<String[]>();

    String sql = " SELECT PRODUCT.PDNAME AS 상품명, SUM(ODAMOUNT) AS 판매수량 FROM PRODUCT, ORDERLIST "
        + " WHERE (PRODUCT.PDCODE = ORDERLIST.ODPDCODE) " + " GROUP BY PRODUCT.PDNAME "
        + " ORDER BY SUM(ODAMOUNT) DESC ";

    try {
      Connection con = getConnection();
      PreparedStatement pstmt = con.prepareStatement(sql);
      ResultSet rs = pstmt.executeQuery();

      while (rs.next()) {
        if (bestList.size() > 3) {
          break;
        }

        String[] arr1 = new String[2];
        arr1[0] = rs.getString("상품명");
        arr1[1] = String.format("%d", rs.getInt("판매수량"));

        bestList.add(arr1);
      }
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return bestList;
  }

  // PRODUCT TABLE 출력 - SELECT SQL
  public ArrayList<ProductDto> showList(String pdType) {

    ArrayList<ProductDto> list = new ArrayList<ProductDto>();

    String sql = "SELECT * FROM PRODUCT WHERE PDTYPE = ?";

    try {
      Connection con = getConnection();
      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setString(1, pdType);
      ResultSet rs = pstmt.executeQuery();

      while (rs.next()) {
        ProductDto pdto = new ProductDto();

        pdto.setPdCode(rs.getString("PDCODE"));
        pdto.setPdName(rs.getString("PDNAME"));
        pdto.setPdPrice(rs.getInt("PDPRICE"));
        pdto.setPdAmount(rs.getInt("PDAMOUNT"));
        pdto.setPdType(rs.getString("PDTYPE"));

        list.add(pdto);
      }
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return list;
  }



  // 상품검색 - SELECT SQL
  public ArrayList<ProductDto> searchList(String name) {
    ArrayList<ProductDto> list = new ArrayList<ProductDto>();

    String sql = "SELECT * FROM PRODUCT WHERE PDNAME LIKE ?";

    try {
      Connection con = getConnection();
      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setString(1, "%" + name + "%");
      ResultSet rs = pstmt.executeQuery();

      while (rs.next()) {
        ProductDto pdto = new ProductDto();

        pdto.setPdCode(rs.getString("PDCODE"));
        pdto.setPdName(rs.getString("PDNAME"));
        pdto.setPdPrice(rs.getInt("PDPRICE"));
        pdto.setPdAmount(rs.getInt("PDAMOUNT"));
        pdto.setPdType(rs.getString("PDTYPE"));

        list.add(pdto);
      }
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return list;
  }

  



}
