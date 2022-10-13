package ex_test6;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test {

  public static void main(String[] args) throws Exception {
    ScoreDaoSql sd = new ScoreDaoSql();

    String sql = "INSERT INTO SCORE(NO,STUNAME,KOREAN,ENGLISH,MATH,TOTAL,AVERAGE,GRADE)"
        + "VALUES(?,?,?,?,?,?,?,?)";

    int insertResult = 0;

    try {
      Connection con = sd.getConnection();
      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setInt(1, 4);
      pstmt.setString(2, "이승원3");
      pstmt.setInt(3, 82);
      pstmt.setInt(4, 61);
      pstmt.setInt(5, 96);
      pstmt.setInt(6, (82+61+96));
      pstmt.setFloat(7, (82+61+96)/(float)3);
      pstmt.setString(8, "B");
      
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


}
