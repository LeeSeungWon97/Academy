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


}
