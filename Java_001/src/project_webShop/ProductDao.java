package project_webShop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;
import oracle.jdbc.proxy.annotation.Pre;

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


  // 상품검색 - 키워드
  public ArrayList<ProductDto> searchName(String pName) {

    ArrayList<ProductDto> searchResult = new ArrayList<ProductDto>();

    String sql = "SELECT * FROM PRODUCT WHERE PDNAME LIKE ?";

    try {
      Connection con = getConnection();
      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setString(1, "%" + pName + "%");
      ResultSet rs = pstmt.executeQuery();

      while (rs.next()) {
        ProductDto dto = new ProductDto();
        dto.setPdCode(rs.getString("PDCODE"));
        dto.setPdName(rs.getString("PDNAME"));
        dto.setPdPrice(rs.getInt("PDPRICE"));
        dto.setPdAmount(rs.getInt("PDAMOUNT"));
        dto.setPdType(rs.getString("PDTYPE"));

        searchResult.add(dto);
      }

    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return searchResult;
  }

  // 상품검색 - 정확한 이름
  public ProductDto searchProduct(String pName) {

    ProductDto dto = new ProductDto();
    String sql = "SELECT * FROM PRODUCT WHERE PDNAME = ?";

    try {
      Connection con = getConnection();
      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setString(1, pName);
      ResultSet rs = pstmt.executeQuery();

      if (rs.next()) {
        dto.setPdCode(rs.getString("PDCODE"));
        dto.setPdName(rs.getString("PDNAME"));
        dto.setPdPrice(rs.getInt("PDPRICE"));
        dto.setPdAmount(rs.getInt("PDAMOUNT"));
        dto.setPdType(rs.getString("PDTYPE"));
      }

    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return dto;
  }
  
  public boolean ProductCheck(String pName) {

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

//상품검색 - 상품코드
  public ProductDto searchPdName(String pdCode) {

    ProductDto dto = new ProductDto();
    String sql = "SELECT * FROM PRODUCT WHERE PDCODE = ?";

    try {
      Connection con = getConnection();
      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setString(1, pdCode);
      ResultSet rs = pstmt.executeQuery();

      if (rs.next()) {
        dto.setPdCode(rs.getString("PDCODE"));
        dto.setPdName(rs.getString("PDNAME"));
        dto.setPdPrice(rs.getInt("PDPRICE"));
        dto.setPdAmount(rs.getInt("PDAMOUNT"));
        dto.setPdType(rs.getString("PDTYPE"));
      }

    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return dto;
  }


  // 상품수정
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


  // 상품목록
  public ArrayList<ProductDto> pdList(int selectNum) {

    ArrayList<ProductDto> list = new ArrayList<ProductDto>();

    String pdType = "";

    switch (selectNum) {
      case 1:
        pdType = "아우터";
        break;
      case 2:
        pdType = "상의";
        break;
      case 3:
        pdType = "하의";
        break;
      case 4:
        pdType = "신발";
        break;
    }

    String sql = "SELECT * FROM PRODUCT WHERE PDTYPE = ?";

    try {
      Connection con = getConnection();
      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setString(1, pdType);
      ResultSet rs = pstmt.executeQuery();

      while (rs.next()) {
        ProductDto dto = new ProductDto();

        dto.setPdCode(rs.getString("PDCODE"));
        dto.setPdName(rs.getString("PDNAME"));
        dto.setPdPrice(rs.getInt("PDPRICE"));
        dto.setPdAmount(rs.getInt("PDAMOUNT"));
        dto.setPdType(rs.getString("PDTYPE"));

        list.add(dto);
      }
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return list;
  }


  // 상품판매
  public void sellProduct(ProductDto pdto, int pAmount) {
    String sql = "UPDATE PRODUCT SET PDAMOUNT = ? WHERE PDCODE = ?";
    try {
      Connection con = getConnection();
      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setInt(1, pdto.getPdAmount() - pAmount);
      pstmt.setString(2, pdto.getPdCode());
      int updateResult = pstmt.executeUpdate();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }


  public int buyCancle(ProductDto pdto, int pdamount) {
    int updateResult = 0;


    String sql = "UPDATE PRODUCT SET PDAMOUNT = ? WHERE PDCODE = ?";

    try {
      Connection con = getConnection();
      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setInt(1, pdto.getPdAmount() + pdamount);
      pstmt.setString(2, pdto.getPdCode());
      updateResult = pstmt.executeUpdate();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return updateResult;
  }



}
