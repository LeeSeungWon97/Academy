package jdbc_Order;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDao {

  public static Connection getConnection() throws Exception {
    Class.forName("oracle.jdbc.OracleDriver");
    Connection con =
        DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "LSW_DBA", "1111");
    return con;
  }

  // MEMBERS 테이블 회원정보 INSERT
  public int insertMemberJoin(MemberDto member) {
    String sql = "INSERT INTO MEMBERS(MID, MPW, MNAME, MGENDER, MBIRTH, MEMAIL) "
        + "VALUES(?, ?, ?, ?, TO_DATE(?,'YYYY-MM-DD'), ?)";

    int insertResult = 0;

    try {
      // 1. DB접속
      Connection con = getConnection();

      // 2. 접속된 DB에 쿼리문 전송 준비
      PreparedStatement pstmt = con.prepareStatement(sql);

      pstmt.setString(1, member.getMid());
      pstmt.setString(2, member.getMpw());
      pstmt.setString(3, member.getMname());
      pstmt.setInt(4, member.getMgender());
      pstmt.setString(5, member.getMbirth());
      pstmt.setString(6, member.getMemail());

      // 3. 쿼리문 실행
      insertResult = pstmt.executeUpdate();
      pstmt.close();
      con.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    // DB
    return insertResult;
  }

  // Members 테이블 SELECT
  public MemberDto selectMemberLogin(String inputId, String inputPw) {

    String sql = "SELECT * FROM MEMBERS WHERE MID = ? AND MPW = ?";

    MemberDto member = null;

    try {
      Connection con = getConnection();

      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setString(1, inputId);
      pstmt.setString(2, inputPw);

      ResultSet rs = pstmt.executeQuery();

      while (rs.next()) {
        member = new MemberDto();

        member.setMid(rs.getString("MID"));
        member.setMpw(rs.getString("MPW"));
        member.setMname(rs.getString("MNAME"));
        member.setMgender(rs.getInt("MGENDER"));
        member.setMbirth(rs.getString("MBIRTH"));
        member.setMemail(rs.getString("MEMAIL"));
      }

    } catch (Exception e) {
      // TODO: handle exception
    }


    return member;
  }

  // 회원정보 조회
  public MemberDto selectMemberInfo(String loginId) {
    String sql = "SELECT MID,MPW,MNAME,MGENDER,TO_CHAR(MBIRTH,'YYYY-MM-DD') AS MBIRTH, MEMAIL "
        + "FROM MEMBERS " 
        + "WHERE MID = ?";
    
    MemberDto memberInfo = null;

    try {
      Connection con = getConnection();
      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setString(1, loginId);
      ResultSet rs = pstmt.executeQuery();
      while (rs.next()) {
        memberInfo = new MemberDto();

        memberInfo.setMid(rs.getString("MID"));
        memberInfo.setMpw(rs.getString("MPW"));
        memberInfo.setMname(rs.getString("MNAME"));
        memberInfo.setMgender(rs.getInt("MGENDER"));
        memberInfo.setMbirth(rs.getString("MBIRTH"));
        memberInfo.setMemail(rs.getString("MEMAIL"));
      }
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return memberInfo;
  }
}
