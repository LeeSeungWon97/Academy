package jdbc_Bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

// DAO : Data Access Object
public class BankDao {

  private Connection con = null;

  // DB연결, SQL문 전송 및 실행

  public static Connection getConnection() throws Exception {
    Class.forName("oracle.jdbc.OracleDriver");
    Connection con =
        DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "LSW_DBA", "1111");
    return con;
  }


  public BankDao() {

    try {
      con = getConnection();
      System.out.println("DB연결 성공!");
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("DB연결 실패!");
    }

  }

  // 계좌번호 중복 확인
  public String selectAccountCheck(String accountNumber) {

    String sql = "SELECT ACCOUNTNUMBER" + " FROM BANKINFO " + "WHERE ACCOUNTNUMBER = ?";
    String checkResult = null;

    try {
      PreparedStatement pstmt = con.prepareStatement(sql);

      pstmt.setString(1, accountNumber);

      ResultSet rs = pstmt.executeQuery();

      while (rs.next()) {
        checkResult = rs.getString(1);
      }

    } catch (SQLException e) {

      e.printStackTrace();
    }

    return checkResult;
  }

  // 계좌 입력 메소드 - insert
  public int insertCreateAccount(BankDto bankInfo) {
    String sql = "INSERT INTO BANKINFO(ACCOUNTNUMBER, CLIENTNAME, BALANCE) " + "VALUES(?, ?, ?)";

    int insertResult = 0;

    try {
      PreparedStatement pstmt = con.prepareStatement(sql);

      pstmt.setString(1, bankInfo.getAccountNumber());
      pstmt.setString(2, bankInfo.getClientName());
      pstmt.setInt(3, bankInfo.getBalance());

      insertResult = pstmt.executeUpdate();

    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return insertResult;
  }

  public ArrayList<BankDto> selectClientList() {
    String sql = "SELECT * FROM BANKINFO";
    ArrayList<BankDto> list = new ArrayList<BankDto>();

    try {
      PreparedStatement pstmt = con.prepareStatement(sql);
      ResultSet rs = pstmt.executeQuery();

      while (rs.next()) {
        BankDto bank = new BankDto();

        bank.setAccountNumber(rs.getString("ACCOUNTNUMBER"));
        bank.setClientName(rs.getString("CLIENTNAME"));
        bank.setBalance(rs.getInt("BALANCE"));

        list.add(bank);
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }

    return list;
  }


  // DAO - 계좌 확인 메소드
  public BankDto selectAccount(String accountNumber) {
    // 1. 실행할 쿼리문 작성
    String sql = "SELECT * FROM BANKINFO WHERE ACCOUNTNUMBER = ?";

    // 2. 리턴 변수 선언
    BankDto bank = null;

    try {
      // 3. 쿼리문 전송 준비
      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setString(1, accountNumber);

      // 4. 쿼리문 실행 결과값 리턴
      ResultSet rs = pstmt.executeQuery();

      // 5. 리턴받은 결과값을 변환
      while (rs.next()) {
        bank = new BankDto();

        bank.setAccountNumber(rs.getString(1));
        bank.setClientName(rs.getString(2));
        bank.setBalance(rs.getInt(3));
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
    return bank;
  }


  public int updateBalance(String accountNumber, int deposit) {
    // 1. 실행할 쿼리문 작성
    String sql = "UPDATE BANKINFO SET BALANCE = BALANCE + ? WHERE ACCOUNTNUMBER = ?";
    // 2. 리턴 변수 선언
    int updateResult = 0;

    // 3. 쿼리문 전송 준비
    try {
      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setInt(1, deposit);
      pstmt.setString(2, accountNumber);

      updateResult = pstmt.executeUpdate();
    } catch (Exception e) {
      // TODO: handle exception
    }
    // 4. 쿼리문 실행 결과값 리턴
    return updateResult;
  }

  public int commitTest() {
    String sql = "INSERT INTO BANKINFO VALUES('TEST0001', '테스트01', 10000')";

    int insertResult = 0;

    try {
      PreparedStatement pstmt = con.prepareStatement(sql);
      insertResult = pstmt.executeUpdate();
      if(insertResult == 1) {
        con.commit();
      } else {
        con.rollback();
      }
      con.setAutoCommit(true);
      
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return insertResult;
  }
}
