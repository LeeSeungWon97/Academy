package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
        "INSERT INTO TEST_MEMBER(MID,MPW,MNAME,MBIRTH) VALUES(?,?,?,TO_DATE(?,'YYYY-MM-DD'))";
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

  // 회원정보 조회 - SELECT
  public MemberDto selectMemberInfo(String sessionLoginId) {
    String sql =
        "SELECT MID, MPW, MNAME, TO_CHAR(MBIRTH, 'YYYY-MM-DD') AS MBIRTH FROM TEST_MEMBER WHERE MID = ?";
    MemberDto mInfo = new MemberDto();

    try {
      Connection con = getConnection();
      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setString(1, sessionLoginId);
      ResultSet rs = pstmt.executeQuery();
      while (rs.next()) {
        mInfo.setMid(rs.getString("MID"));
        mInfo.setMpw(rs.getString("MPW"));
        mInfo.setMname(rs.getString("MNAME"));
        mInfo.setMbirth(rs.getString("MBIRTH"));
      }
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return mInfo;
  }


  // 회원목록 - SELECT
  public ArrayList<MemberDto> selectMemberList() {
    String sql = "SELECT MID, MPW, MNAME, TO_CHAR(MBIRTH, 'YYYY-MM-DD') AS MBIRTH FROM TEST_MEMBER";
    ArrayList<MemberDto> memberList = new ArrayList<MemberDto>();

    try {
      Connection con = getConnection();
      PreparedStatement pstmt = con.prepareStatement(sql);
      ResultSet rs = pstmt.executeQuery();

      while (rs.next()) {
        MemberDto mInfo = new MemberDto();

        mInfo.setMid(rs.getString("MID"));
        mInfo.setMpw(rs.getString("MPW"));
        mInfo.setMname(rs.getString("MNAME"));
        mInfo.setMbirth(rs.getString("MBIRTH"));

        memberList.add(mInfo);
      }
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return memberList;
  }

  
  // 회원삭제 - DELETE
  public int deleteMemberInfo(String delId) {
    String sql = "DELETE FROM TEST_MEMBER WHERE MID = ?";
    int deleteResult = 0;
    
    try {
      Connection con = getConnection();
      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setString(1, delId);
      deleteResult = pstmt.executeUpdate();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return deleteResult;
  }

  // 회원정보수정 - UPDATE
  public int updateMemberInfo(MemberDto updateMem) {
    String sql = "UPDATE TEST_MEMBER SET MPW=?, MNAME=?, MBIRTH=TO_DATE(?,'YYYY-MM-DD') WHERE MID = ?";
    int updateResult = 0;
    
    try {
      Connection con = getConnection();
      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setString(1, updateMem.getMpw());
      pstmt.setString(2, updateMem.getMname());
      pstmt.setString(3, updateMem.getMbirth());
      pstmt.setString(4, updateMem.getMid());
      
      updateResult = pstmt.executeUpdate();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    return updateResult;
  }
}
