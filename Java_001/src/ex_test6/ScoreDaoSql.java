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
  private ArrayList<Score> stuList = new ArrayList<Score>();

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
    
  public int selectMaxOdnum() {
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
      pstmt.setInt(1, selectMaxOdnum()+1);
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
  public void showList() {
    System.out.println("[이름]\t[국어]\t[영어]\t[수학]\t[총점]\t[평균]\t[학점]");
    System.out.println("---------------------------------------------------");
    String sql = "SELECT * FROM SCORE";

    try {
      // 작성된 쿼리문을 전송하기 위한 용도
      PreparedStatement pstmt = con.prepareStatement(sql);

      // 실행결과를 담아둠 (SELECT문인 경우)
      ResultSet rs = pstmt.executeQuery();
      while (rs.next()) {
        System.out.print(rs.getString(2));
        System.out.print("\t" + rs.getInt(3));
        System.out.print("\t" + rs.getInt(4));
        System.out.print("\t" + rs.getInt(5));
        System.out.print("\t" + rs.getInt(6));
        System.out.print("\t" + rs.getInt(7));
        System.out.println("\t" + rs.getString(8));
      }
      
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void showList(int check) {
    System.out.println("[이름]\t[국어]\t[영어]\t[수학]\t[총점]\t[평균]\t[학점]");
    System.out.println("---------------------------------------------------");
    System.out.print(stuList.get(check).getStuName() + "\t");
    System.out.print(stuList.get(check).getKorean() + "\t");
    System.out.print(stuList.get(check).getEnglish() + "\t");
    System.out.print(stuList.get(check).getMath() + "\t");
    System.out.print(stuList.get(check).getTotal() + "\t");
    System.out.print(stuList.get(check).getAverage() + "\t");
    System.out.println(stuList.get(check).getGrade());
  }

  public int findIdx(String name) {
    int stuIdx = -1;

    for (int i = 0; i < stuList.size(); i++) {
      if (stuList.get(i).getStuName().equals(name)) {
        stuIdx = i;
      }
    }

    return stuIdx;
  }

  public void updateScore(int check) {
    int score1 = enterScore("국어");
    int score2 = enterScore("영어");
    int score3 = enterScore("수학");
    stuList.get(check).setKorean(score1);
    stuList.get(check).setEnglish(score2);
    stuList.get(check).setMath(score3);

    stuList.get(check).cal();


  }

  // 학생 리스트 삭제 메소드
  public void removeScore(int idx) {
    stuList.remove(idx);
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
