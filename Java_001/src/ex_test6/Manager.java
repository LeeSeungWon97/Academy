package ex_test6;

import java.util.Scanner;

public class Manager {

  ScoreDaoSql sql = new ScoreDaoSql();
//  ScoreDao dao = new ScoreDao();
  Scanner scan = new Scanner(System.in);

  // 메뉴 출력 메소드
  public int showMenu(boolean flag) {

    while (true) {
      System.out.println();
      if (!flag) {
        System.out.println("1. 성적등록 | 2.리스트 | 3.검색 | 0.종료");
      } else {
        System.out.println("1.조회 | 2.수정 | 3.삭제 | 4.뒤로가기 | 0.종료");
      }
      System.out.print("메뉴선택: ");

      if (!scan.hasNextInt()) {
        System.out.println("숫자를 입력해주세요.");
        scan.nextLine();
      } else {
        return scan.nextInt();
      }
    }

  }

  // 성적등록 메소드
  public void insertScore() throws Exception {
    Score stuScore = new Score();

    String name = sql.enterName();

    int score1 = sql.enterScore("국어");
    int score2 = sql.enterScore("영어");
    int score3 = sql.enterScore("수학");

    stuScore.setStuName(name);
    stuScore.setKorean(score1);
    stuScore.setEnglish(score2);
    stuScore.setMath(score3);
    stuScore.cal();

    sql.insert(stuScore);

    System.out.println("등록완료");
  }

  // 리스트출력 메소드
  public void showList() {
    sql.showList();
  }

  // 조회 메소드
  public void searchStu() {

    System.out.print("조회할 학생이름: ");
    String name = scan.next();

    int check = studentCheck(name);

    if (check != -1) {
      sql.showList(check);
    }
  }

  // 학생찾기 메소드
  private int studentCheck(String name) {

    int idx = sql.findIdx(name);

    if (idx == -1) {
      System.out.println("등록되지 않은 학생입니다.");
    }

    return idx;
  }

  // 점수 수정 메소드
  public void changeScore() {

    System.out.print("학생이름: ");
    String name = scan.next();

    int check = studentCheck(name);

    if (check != -1) {
      sql.updateScore(check);
      System.out.println("수정완료");

    }

  }

  // 학생 점수정보 삭제 메소드
  public void delete() {
    System.out.print("삭제시킬 학생이름: ");
    String name = scan.next();
    int check = studentCheck(name);

    if (check != -1) {
      sql.removeScore(check);
      System.out.println(name + "님 삭제완료");
    }

  }

}
