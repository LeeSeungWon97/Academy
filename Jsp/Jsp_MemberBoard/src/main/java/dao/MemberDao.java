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
        DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "JSP_PROJECT", "1111");
    return con;
  }


  // 회원가입 - SELECT
  public int insertMemberJoin(MemberDto joinMember) {
    String sql =
        "INSERT INTO MEMBERS(MID,MPW,MNAME,MBIRTH,MADDR,MEMAIL,MSTATE) VALUES(?,?,?,TO_DATE(?,'YYYY-MM-DD'),?,?,'0')";
    int insertResult = 0;

    try {
      Connection con = getConnection();
      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setString(1, joinMember.getMid());
      pstmt.setString(2, joinMember.getMpw());
      pstmt.setString(3, joinMember.getMname());
      pstmt.setString(4, joinMember.getMbirth());
      pstmt.setString(5, joinMember.getMaddr());
      pstmt.setString(6, joinMember.getMemail());

      insertResult = pstmt.executeUpdate();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return insertResult;
  }


  // 로그인 정보 확인 - SELECT
  public String selectMemberLogin(String inputId, String inputPw) {
    System.out.println("MemberDao selectMemberLogin()호출");
    String sql = "SELECT MID FROM MEMBERS WHERE MID = ? AND MPW = ?";
    String loginId = null;

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
    return loginId;
  }



  // 아이디 중복확인 - SELECT
  public MemberDto selectMemberInfo(String inputId) {
    String sql =
        "SELECT MID, MPW, MNAME, TO_CHAR(MBIRTH,'YYYY-MM-DD') AS MBIRTH, MADDR, MEMAIL, MSTATE FROM MEMBERS WHERE MID = ?";
    MemberDto memInfo = null;

    try {
      Connection con = getConnection();
      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setString(1, inputId);

      ResultSet rs = pstmt.executeQuery();

      while (rs.next()) {
        memInfo = new MemberDto();
        memInfo.setMid(rs.getString("MID"));
        memInfo.setMpw(rs.getString("MPW"));
        memInfo.setMname(rs.getString("MNAME"));
        memInfo.setMbirth(rs.getString("MBIRTH"));
        memInfo.setMaddr(rs.getString("MADDR"));
        memInfo.setMemail(rs.getString("MEMAIL"));
        memInfo.setMstate(rs.getString("MSTATE"));
      }
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return memInfo;
  }
}
