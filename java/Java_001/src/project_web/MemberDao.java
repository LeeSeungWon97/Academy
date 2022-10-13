package project_web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MemberDao {


  // DB연결
  public static Connection getConnection() throws Exception {
    Class.forName("oracle.jdbc.OracleDriver");
    Connection con =
//        DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "P_DBA", "1111");
        DriverManager.getConnection("jdbc:oracle:thin:@//106.243.194.229:5757/xe", "PHS_DBA", "1111");
    return con;
  }


  // 내정보(로그인ID) 불러오기 - SELECT SQL
  public MemberDto callMyInfo(String id) {
    MemberDto currentInfo = new MemberDto();
    String sql = "SELECT * FROM MEMBERS WHERE MID = ?";
    try {
      Connection con = getConnection();
      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setString(1, id);
      ResultSet rs = pstmt.executeQuery();

      if (rs.next()) {
        currentInfo.setmId(rs.getString("MID"));
        currentInfo.setmPw(rs.getString("MPW"));
        currentInfo.setmName(rs.getString("MNAME"));
        currentInfo.setmGender(rs.getInt("MGENDER"));
        currentInfo.setmBirth(rs.getString("MBIRTH"));
        currentInfo.setmEmail(rs.getString("MEMAIL"));
        currentInfo.setmCash(rs.getInt("MCASH"));
        currentInfo.setmGrade(rs.getString("MGRADE"));
        currentInfo.setmCheck(rs.getString("MCHECK"));
        currentInfo.setmTotal(rs.getInt("MTOTAL"));
      }
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }


    return currentInfo;
  }

  // 내정보(로그인ID) 최신화 - UPDATE SQL
  public int updateMyInfo(MemberDto mdto) {
    int updateResult = 0;
    String sql = "UPDATE MEMBERS SET MCASH = ?, MGRADE = ?, MCHECK = ?, MTOTAL = ? WHERE MID = ?";
    try {
      Connection con = getConnection();
      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setInt(1, mdto.getmCash());
      pstmt.setString(2, mdto.getmGrade());
      pstmt.setString(3, mdto.getmCheck());
      pstmt.setInt(4, mdto.getmTotal());
      pstmt.setString(5, mdto.getmId());
      updateResult = pstmt.executeUpdate();

    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return updateResult;
  }

  // ID&PW확인 - SELECT SQL
  public boolean loginCheck(String id, String pw) {
    boolean check = false;
    String sql = "SELECT * FROM MEMBERS WHERE MID = ? AND MPW = ?";

    try {
      Connection con = getConnection();
      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setString(1, id);
      pstmt.setString(2, pw);

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


  // ID검색 - SELECT SQL
  public boolean searchId(String id) {
    boolean check = false;
    String sql = "SELECT MID FROM MEMBERS WHERE MID = ?";

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


  // 회원가입 - INSERT SQL
  public int join(MemberDto mdto) {
    int insertResult = 0;

    String sql =
        "INSERT INTO MEMBERS(MID, MPW, MNAME, MGENDER, MBIRTH, MEMAIL, MCASH, MGRADE, MCHECK, MTOTAL) "
            + "VALUES(?,?,?,?,?,?,?,?,?,?)";

    try {
      Connection con = getConnection();
      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setString(1, mdto.getmId());
      pstmt.setString(2, mdto.getmPw());
      pstmt.setString(3, mdto.getmName());
      pstmt.setInt(4, mdto.getmGender());
      pstmt.setString(5, mdto.getmBirth());
      pstmt.setString(6, mdto.getmEmail());
      pstmt.setInt(7, mdto.getmCash());
      pstmt.setString(8, mdto.getmGrade());
      pstmt.setString(9, mdto.getmCheck());
      pstmt.setInt(10, mdto.getmTotal());

      insertResult = pstmt.executeUpdate();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return insertResult;
  }


  // MEMBERS 리스트 불러오기 - SELECT SQL
  public void showMembers(String mCheck) {
    ArrayList<MemberDto> memList = new ArrayList<MemberDto>();

    String sql = "SELECT * FROM MEMBERS WHERE MCHECK = ?";

    try {
      Connection con = getConnection();
      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setString(1, mCheck);
      ResultSet rs = pstmt.executeQuery();

      while (rs.next()) {
        MemberDto mdto = new MemberDto();
        mdto.setmId(rs.getString("MID"));
        mdto.setmPw(rs.getString("MPW"));
        mdto.setmName(rs.getString("MNAME"));
        mdto.setmGender(rs.getInt("MGENDER"));
        mdto.setmBirth(rs.getString("MBIRTH"));
        mdto.setmEmail(rs.getString("MEMAIL"));
        mdto.setmCash(rs.getInt("MCASH"));
        mdto.setmGrade(rs.getString("MGRADE"));
        mdto.setmCheck(rs.getString("MCHECK"));
        mdto.setmTotal(rs.getInt("MTOTAL"));

        memList.add(mdto);
      }

      for (int i = 0; i < memList.size(); i++) {
        System.out.println(memList.get(i).toString());
      }

    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }


  // MEMBERS의 MCHECK 변경 - UPDATE SQL
  public int changeMcheck(String mCheck, String id) {
    String sql = "UPDATE MEMBERS SET MCHECK = ? WHERE MID = ?";
    int updateResult = 0;

    try {
      Connection con = getConnection();
      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setString(1, mCheck);
      pstmt.setString(2, id);
      updateResult = pstmt.executeUpdate();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return updateResult;
  }


  // 최고회원리스트 - SELECT SQL
  public ArrayList<String[]> showBestMember() {
    ArrayList<String[]> memList = new ArrayList<String[]>();

    String sql =
        " SELECT MEMBERS.MID AS 회원아이디 , SUM(ODAMOUNT*PDPRICE) AS 총구매가격 FROM PRODUCT, ORDERLIST,MEMBERS "
            + " WHERE (MEMBERS.MID = ORDERLIST.ODMID) AND (PRODUCT.PDCODE = ORDERLIST.ODPDCODE) "
            + " GROUP BY MID " + " ORDER BY SUM(ODAMOUNT*PDPRICE) DESC ";

    try {
      Connection con = getConnection();
      PreparedStatement pstmt = con.prepareStatement(sql);
      ResultSet rs = pstmt.executeQuery();

      while (rs.next()) {
        if (memList.size() > 3) {
          break;
        }

        String[] arr1 = new String[2];
        arr1[0] = rs.getString("회원아이디");
        arr1[1] = String.format("%d", rs.getInt("총구매가격"));

        memList.add(arr1);
      }
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }


    return memList;
  }



  // 소지금 충전 - UPDATE SQL
  public int addCash(int balance, MemberDto mdto) {
    int updateResult = 0;

    String sql = "UPDATE MEMBERS SET MCASH = ? WHERE MID = ?";

    try {
      Connection con = getConnection();
      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setInt(1, mdto.getmCash() + balance);
      pstmt.setString(2, mdto.getmId());
      updateResult = pstmt.executeUpdate();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return updateResult;
  }


  // 회원삭제 - DELETE SQL
  public int deleteMember(String id) {
    int deleteResult = 0;
    String sql = "DELETE MEMBERS WHERE MID = ?";

    try {
      Connection con = getConnection();
      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setString(1, id);

      deleteResult = pstmt.executeUpdate();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return deleteResult;
  }



}
