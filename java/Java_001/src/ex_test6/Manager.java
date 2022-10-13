package ex_test6;

import java.util.ArrayList;
import java.util.Scanner;

public class Manager {

  ScoreDaoSql sql = new ScoreDaoSql();

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
        scan.next();
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

    stuScore.setNo(sql.selectMaxNo() + 1);
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
    ArrayList<Score> slist = new ArrayList<Score>();
    
    slist = sql.showList();
    for(int i = 0; i < slist.size();i++) {
      System.out.println(slist.get(i).toString());
    }
  }

  // 조회 메소드
  public void searchStu() {
    System.out.print("조회할 학생이름: ");
    String name = scan.next();
    Score s = sql.showList(name);

    if (s == null) {
      System.out.println("등록된 학생이 아닙니다");
    } else {
      System.out.println(s.toString());
    }
  }

  // 점수 수정 메소드
  public void changeScore() {
    showList();
    System.out.print("수정번호: ");
    int num = scan.nextInt();
    int updateResult = sql.updateScore(num);
    if (updateResult == 1) {
      System.out.println("업데이트 완료");
    } else {
      System.out.println("업데이트 실패");
    }

  }

  // 학생 점수정보 삭제 메소드
  public void delete() {
    showList();
    System.out.print("삭제시킬 학생번호: ");
    int num = scan.nextInt();

    int check = sql.removeScore(num);

    if (check == 1) {
      System.out.println("삭제 완료");
    } else {
      System.out.println("삭제 실패");
    }
  }

}
