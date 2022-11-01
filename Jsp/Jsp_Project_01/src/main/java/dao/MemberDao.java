package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import dto.MemberDto;

public class MemberDao {

  // DB연결
  public static Connection getConnection() throws Exception {
    Class.forName("oracle.jdbc.OracleDriver");
    Connection con =
        DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "LSW_DBA", "1111");
    return con;
  }

  // 아이디 검색 - SELECT
  private boolean checkId(String inputId) {
    String sql = "SELECT MID FROM TEST_MEMBER WHERE MID = ?";
    boolean check = false;

    try {
      Connection con = getConnection();
      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setString(1, inputId);
      ResultSet rs = pstmt.executeQuery();
      while (rs.next()) {
        check = true;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return check;
  }

  // 회원가입 - INSERT
  public int insertMember(MemberDto joinMember) {
    String sql =
        "INSERT INTO TEST_MEMBER(MID,MPW,MNAME,MBIRTH) VALUES(?,?,?,TO_DATE(?,'YYYY-MM-DD')";
    int insertResult = 0;

    boolean checkId = checkId(joinMember.getMid());
    if (!checkId) {
      try {
        Connection con = getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, joinMember.getMid());
        pstmt.setString(2, joinMember.getMpw());
        pstmt.setString(3, joinMember.getMname());
        pstmt.setString(4, joinMember.getMbirth());

        insertResult = pstmt.executeUpdate();
      } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
    return insertResult;
  }


  // 로그인 - SELECT
  public String login(String inputId, String inputPw) {
    String sql = "SELECT * FROM TEST_MEMBER WHERE MID = ? AND MPW = ?";
    String loginId = null;

    boolean check = checkId(inputId);

    if (check) {
      try {
        Connection con = getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, inputId);
        pstmt.setString(2, inputPw);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
          loginId = rs.getString("MID");
        }
      } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
    return loginId;
  }


}
