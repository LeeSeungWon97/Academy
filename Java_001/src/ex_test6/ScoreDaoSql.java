package ex_test6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class ScoreDaoSql {
  Scanner scan = new Scanner(System.in);

  private Connection con = null;

  // DB연결, SQL문 전송 및 실행
  public static Connection getConnection() throws Exception {
    Class.forName("oracle.jdbc.OracleDriver");
    Connection con =
        DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "LSW_DBA", "1111");
    return con;
  }


  public ScoreDaoSql() {
    try {
      con = getConnection();
      System.out.println("DB연결 성공!");
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("DB연결 실패!");
    }
  }

  public int selectMaxNo() {
    String sql = "SELECT NVL(MAX(NO),0) AS max FROM SCORE";
    int maxnum = 0;
    try {
      Connection con = getConnection();
      PreparedStatement pstmt = con.prepareStatement(sql);
      ResultSet rs = pstmt.executeQuery();
      while (rs.next()) {
        maxnum = rs.getInt("max");
      }
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return maxnum;
  }

  // 데이터 insert
  public void insert(Score stuScore) throws Exception {
    String sql = "INSERT INTO SCORE(NO,STUNAME,KOREAN,ENGLISH,MATH,TOTAL,AVERAGE,GRADE)"
        + "VALUES(?,?,?,?,?,?,?,?)";

    int insertResult = 0;

    try {
      Connection con = getConnection();
      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setInt(1, stuScore.getNo());
      pstmt.setString(2, stuScore.getStuName());
      pstmt.setInt(3, stuScore.getKorean());
      pstmt.setInt(4, stuScore.getEnglish());
      pstmt.setInt(5, stuScore.getMath());
      pstmt.setInt(6, stuScore.getTotal());
      pstmt.setDouble(7, stuScore.getAverage());
      pstmt.setString(8, stuScore.getGrade());

      insertResult = pstmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    if (insertResult > 0) {
      System.out.println("입력 성공");
    } else {
      System.out.println("입력 실패");
    }
  }

  // 리스트 출력
  public ArrayList<Score> showList() {
    System.out.println("[No]\t[이름]\t[국어]\t[영어]\t[수학]\t[총점]\t[평균]\t[학점]");
    System.out.println("---------------------------------------------------");
    String sql = "SELECT * FROM SCORE ORDER BY NO";

    ArrayList<Score> sList = new ArrayList<Score>();
    try {
      // 작성된 쿼리문을 전송하기 위한 용도
      PreparedStatement pstmt = con.prepareStatement(sql);

      // 실행결과를 담아둠 (SELECT문인 경우)
      ResultSet rs = pstmt.executeQuery();
      while (rs.next()) {
        Score s = new Score();
        s.setNo(rs.getInt(1));
        s.setStuName(rs.getString(2));
        s.setKorean(rs.getInt(3));
        s.setEnglish(rs.getInt(4));
        s.setMath(rs.getInt(5));
        s.cal();
        
        sList.add(s);
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return sList;
  }

  public Score showList(String name) {
    System.out.println("[No]\t[이름]\t[국어]\t[영어]\t[수학]\t[총점]\t[평균]\t[학점]");
    System.out.println("---------------------------------------------------");

    String sql = "SELECT * FROM SCORE WHERE STUNAME = ?";

    Score s = null;

    try {
      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setString(1, name);
      ResultSet rs = pstmt.executeQuery();
      while (rs.next()) {
        s = new Score();
        
        s.setNo(rs.getInt(1));
        s.setStuName(rs.getString(2));
        s.setKorean(rs.getInt(3));
        s.setEnglish(rs.getInt(4));
        s.setMath(rs.getInt(5));
        
        s.cal();
      }

    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return s;
  }


  public int updateScore(int num) {

    String sql =
        "UPDATE SCORE SET KOREAN = ?, ENGLISH = ?, MATH = ?, TOTAL = ?, AVERAGE = ?, GRADE = ? WHERE NO = ?";


    int updateResult = 0;

    try {
      Score s = searchNo(num);

      s.setKorean(enterScore("국어"));
      s.setEnglish(enterScore("영어"));
      s.setMath(enterScore("수학"));
      s.cal();

      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setInt(1, s.getKorean());
      pstmt.setInt(2, s.getEnglish());
      pstmt.setInt(3, s.getMath());
      pstmt.setInt(4, s.getTotal());
      pstmt.setDouble(5, s.getAverage());
      pstmt.setString(6, s.getGrade());
      pstmt.setInt(7, num);

      updateResult = pstmt.executeUpdate();

    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return updateResult;
  }



  private Score searchNo(int num) throws SQLException {
    String sql = "SELECT * FROM SCORE WHERE NO = ?";
    Score s = null;

    PreparedStatement pstmt = con.prepareStatement(sql);
    pstmt.setInt(1, num);
    ResultSet rs = pstmt.executeQuery();
    while (rs.next()) {
      s = new Score();
      s.setNo(rs.getInt("NO"));
      s.setStuName(rs.getString(2));
      s.setKorean(rs.getInt(3));
      s.setEnglish(rs.getInt(4));
      s.setMath(rs.getInt(5));
      s.cal();
    }
    return s;
  }


  // 학생 리스트 삭제 메소드
  public int removeScore(int idx) {
    String sql = "DELETE FROM SCORE WHERE NO = ?";

    int deleteResult = 0;

    try {
      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setInt(1, idx);
      deleteResult = pstmt.executeUpdate();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return deleteResult;
  }

  // 이름입력 메소드
  public String enterName() {

    while (true) {
      System.out.print("이름: ");
      String name = scan.next();

      if (name.length() < 2) {
        System.out.println("이름은 2글자 이상입니다.");
      } else {
        return name;
      }
    }
  }

  // 점수입력 메소드
  public int enterScore(String subject) {

    while (true) {
      System.out.print(subject + "점수: ");

      if (!scan.hasNextInt()) {
        System.out.println("숫자를 입력해주세요");
        scan.next();
      } else {
        int score = scan.nextInt();

        if (score > 100 || score < 0) {
          System.out.println("점수를 확인해주세요");
        } else {
          return score;
        }
      }
    }
  }

}
