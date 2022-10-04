package project_webShop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class MemberDao {

  Scanner scan = new Scanner(System.in);

  public static Connection getConnection() throws Exception {
    Class.forName("oracle.jdbc.OracleDriver");
    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//106.243.194.229:5757/xe",
        "PHS_DBA", "1111");
    return con;
  }

  // ID 확인 sql
  public boolean idCheck(String id) {
    String sql = "SELECT * FROM MEMBERS WHERE MID = ?";
    boolean check = false;

    try {
      Connection con = getConnection();
      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setString(1, id);

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

  // 회원가입 sql
  public int memberJoin(MemberDto memDto) {
    String sql = "INSERT INTO MEMBERS(MID, MPW, MNAME, MGENDER, MBIRTH, MEMAIL, MCASH) "
        + "VALUES(?,?,?,?,?,?,?)";

    int insertResult = 0;
    try {
      Connection con = getConnection();
      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setString(1, memDto.getmId());
      pstmt.setString(2, memDto.getmPw());
      pstmt.setString(3, memDto.getmName());
      pstmt.setInt(4, memDto.getmGender());
      pstmt.setString(5, memDto.getmBirth());
      pstmt.setString(6, memDto.getmEmail());
      pstmt.setInt(7, 0);
      insertResult = pstmt.executeUpdate();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }


    return insertResult;
  }

  // 로그인 sql
  public MemberDto login(String id, String pw) {
    MemberDto mem = new MemberDto();

    String sql = "SELECT * FROM MEMBERS WHERE MID = ? AND MPW = ?";

    try {
      Connection con = getConnection();
      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setString(1, id);
      pstmt.setString(2, pw);
      ResultSet rs = pstmt.executeQuery();

      if (rs.next()) {
        mem.setmId(rs.getString("MID"));
        mem.setmPw(rs.getString("MPW"));
        mem.setmName(rs.getString("MNAME"));
        mem.setmGender(rs.getInt("MGENDER"));
        mem.setmBirth(rs.getString("MBIRTH"));
        mem.setmEmail(rs.getString("MEMAIL"));
        mem.setmCash(rs.getInt("MCASH"));
      }
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return mem;
  }

  // 로그인 체크 sql
  public boolean loginCheck(String id, String pw) {
    boolean check = false;
    String sql = "SELECT * FROM MEMBERS WHERE MID = ? AND MPW = ?";
    try {
      Connection con = getConnection();
      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setString(1, id);
      pstmt.setString(2, pw);
      ResultSet rs = pstmt.executeQuery();

      if (!rs.next()) {
        System.out.println("아이디 / 비밀번호가 틀렸습니다.");
      } else {
        System.out.println("로그인 성공!");
        check = true;
      }
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return check;
  }

}
