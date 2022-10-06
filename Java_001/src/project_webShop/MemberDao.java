package project_webShop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
    String sql =
        "INSERT INTO MEMBERS(MID, MPW, MNAME, MGENDER, MBIRTH, MEMAIL, MCASH, MGRADE, MCHECK) "
            + "VALUES(?,?,?,?,?,?,?,?,?)";

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
      pstmt.setString(8, "B");
      pstmt.setString(9, "N");

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
        mem.setmGrade();
        mem.setmCheck(rs.getString("MCHECK"));
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

  
  // 회원목록
  public ArrayList<MemberDto> memListShow() {

    ArrayList<MemberDto> list = new ArrayList<MemberDto>();

    String sql = "SELECT * FROM MEMBERS";
    try {
      Connection con = getConnection();
      PreparedStatement pstmt = con.prepareStatement(sql);
      ResultSet rs = pstmt.executeQuery();

      while (rs.next()) {
        MemberDto dto = new MemberDto();
        dto.setmId(rs.getString("MID"));
        dto.setmPw(rs.getString("MPW"));
        dto.setmName(rs.getString("MNAME"));
        dto.setmGender(rs.getInt("MGENDER"));
        dto.setmBirth(rs.getString("MBIRTH"));
        dto.setmEmail(rs.getString("MEMAIL"));
        dto.setmCash(rs.getInt("MCASH"));
        dto.setmGrade();
        dto.setmCheck(rs.getString("MCHECK"));

        list.add(dto);
      }

    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return list;
  }

  // 회원조회
  public void searchMem(String mId) {
    String sql = "SELECT * FROM MEMBERS WHERE MID = ?";

    try {
      Connection con = getConnection();
      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setString(1, mId);
      ResultSet rs = pstmt.executeQuery();

      if (rs.next()) {
        System.out.print(rs.getString("MNAME") + " ");
        System.out.print(rs.getInt("MGENDER") + " ");
        System.out.print(rs.getString("MBIRTH") + " ");
        System.out.print(rs.getString("MEMAIL") + " ");
        System.out.print(rs.getInt("MCASH") + " ");
        System.out.println(rs.getString("MGRADE") + " ");
//        System.out.println(rs.getString("MCHECK"));
      }
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }


  }

  
  // 관리자&블랙리스트 부여
  public int changeCheck(int menu, String id) {

    int updateResult = 0;
    String check = "";

    if (menu == 1) {
      check = "Y";
    } else {
      check = "B";
    }

    String sql = "UPDATE MEMBERS SET MCHECK = ? WHERE MID = ?";
    try {
      Connection con = getConnection();
      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setString(1, check);
      pstmt.setString(2, id);

      updateResult = pstmt.executeUpdate();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return updateResult;
  }

  // 금액 충전
  public int charge(int add, MemberDto currentMem) {
    int updateResult = 0;

    String sql = "UPDATE MEMBERS SET MCASH = ? WHERE MID = ?";
    try {
      Connection con = getConnection();
      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setInt(1, currentMem.getmCash() + add);
      pstmt.setString(2, currentMem.getmId());
      updateResult = pstmt.executeUpdate();
   
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return updateResult;
  }
  
//비용 지불
 public int deposit(int price, MemberDto currentMem) {
   int updateResult = 0;

   String sql = "UPDATE MEMBERS SET MCASH = ?, MTOTAL = ? WHERE MID = ?";
   try {
     Connection con = getConnection();
     PreparedStatement pstmt = con.prepareStatement(sql);
     pstmt.setInt(1, currentMem.getmCash() - price);
     pstmt.setInt(2, currentMem.getmTotal() + price);
     pstmt.setString(3, currentMem.getmId());
     updateResult = pstmt.executeUpdate();
  
   } catch (Exception e) {
     // TODO Auto-generated catch block
     e.printStackTrace();
   }
   return updateResult;
 }

  
  // 회원 충전금액 업데이트
  public MemberDto updateMemCash(MemberDto currentMem) {
    String sql = "SELECT * FROM MEMBERS WHERE MID = ?";
    
    try {
      Connection con = getConnection();
      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setString(1, currentMem.getmId());
      ResultSet rs = pstmt.executeQuery();
      
      if(rs.next()) {
        currentMem.setmCash(rs.getInt("MCASH"));
        currentMem.setmGrade();
      }
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    return currentMem;
  }

 
  // 회원 등급 업데이트
  public int gradeUpdate(MemberDto currentMem) {

    int updateResult = 0;
    String sql = "UPDATE MEMBERS SET MGRADE = ? WHERE MID = ?";
    try {
      Connection con = getConnection();
      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setString(1, currentMem.getmGrade());
      pstmt.setString(2, currentMem.getmId());
      updateResult = pstmt.executeUpdate();
   
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
   return updateResult; 
  }
  
  public ArrayList<String> pprize() {
    ArrayList<String> clist = new ArrayList<>();

    String sql = " SELECT PRODUCT.PDNAME, SUM(ODAMOUNT) FROM PRODUCT, ORDERLIST "
            + " WHERE (PRODUCT.PDCODE = ORDERLIST.ODPDCODE) "
            + " GROUP BY PRODUCT.PDNAME "
            + " ORDER BY SUM(ODAMOUNT) DESC ";
    try {
      Connection con = getConnection();
      PreparedStatement pstmt = con.prepareStatement(sql);
      ResultSet rs = pstmt.executeQuery();
      while (rs.next()) {
        clist.add(rs.getString(1));
        clist.add(String.format("%d",rs.getInt(2)));
      }
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return clist;
  }
  
  public ArrayList<String> mprize() {
    ArrayList<String> clist = new ArrayList<>();
        
    String sql = " SELECT MEMBERS.MID , SUM(ODAMOUNT*PDPRICE) FROM PRODUCT, ORDERLIST,MEMBERS "
            + " WHERE (MEMBERS.MID = ORDERLIST.ODMID) AND (PRODUCT.PDCODE = ORDERLIST.ODPDCODE) "
            + " GROUP BY MID "
            + " ORDER BY SUM(ODAMOUNT*PDPRICE) DESC ";
    try {
      Connection con = getConnection();
      PreparedStatement pstmt = con.prepareStatement(sql);
      ResultSet rs = pstmt.executeQuery();
      while (rs.next()) {
        clist.add(rs.getString(1));
        clist.add(String.format("%d",rs.getInt(2)));
      }
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return clist;
  }

}
