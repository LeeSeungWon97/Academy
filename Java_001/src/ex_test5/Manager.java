package ex_test5;

import java.util.ArrayList;
import java.util.Scanner;

public class Manager {

  ArrayList<Score> stu = new ArrayList<Score>();
  Scanner scan = new Scanner(System.in);
  
  public static void abc() { 
    System.out.println("static");
  }

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
  public void insertScore() {
    Score stuScore = new Score();

    System.out.print("이름: ");
    String name = scan.next();

    int score1 = enterScore("국어");
    int score2 = enterScore("영어");
    int score3 = enterScore("수학");

    stuScore.setStuName(name);
    stuScore.setKorean(score1);
    stuScore.setEnglish(score2);
    stuScore.setMath(score3);
    stuScore.setTotal();
    stuScore.setAverage();
    stuScore.setGrade();

    stu.add(stuScore);

    System.out.println("등록완료");
  }

  // 리스트출력 메소드
  public void showList() {

    System.out.println("[이름]\t[국어]\t[영어]\t[수학]\t[총점]\t[평균]\t[학점]");
    System.out.println("-------------------------------------------------------------");

    for (int i = 0; i < stu.size(); i++) {
      System.out.println(stu.get(i).toString());
    }

  }


  // 조회 메소드
  public void searchStu() {

    System.out.print("조회할 학생이름: ");
    String name = scan.next();

    int check = studentCheck(name);

    if (check != -1) {
      System.out.println("[이름]\t[국어]\t[영어]\t[수학]\t[총점]\t[평균]\t[학점]");
      System.out.println("---------------------------------------------------");
      System.out.print(stu.get(check).getStuName() + "\t");
      System.out.print(stu.get(check).getKorean() + "\t");
      System.out.print(stu.get(check).getEnglish() + "\t");
      System.out.print(stu.get(check).getMath() + "\t");
      System.out.print(stu.get(check).getTotal() + "\t");
      System.out.print(stu.get(check).getAverage() + "\t");
      System.out.println(stu.get(check).getGrade());
    }
  }

  // 학생찾기 메소드
  private int studentCheck(String name) {

    int stuIdx = -1;

    for (int i = 0; i < stu.size(); i++) {
      if (stu.get(i).getStuName().equals(name)) {
        stuIdx = i;
      }
    }

    if (stuIdx == -1) {
      System.out.println("등록되지 않은 학생입니다.");
    }

    return stuIdx;
  }

  // 점수수정 메소드
  public void changeScore() {

    System.out.print("학생이름: ");
    String name = scan.next();

    int check = studentCheck(name);

    if (check != -1) {
      int score1 = enterScore("국어");
      stu.get(check).setKorean(score1);
      int score2 = enterScore("영어");
      stu.get(check).setEnglish(score2);
      int score3 = enterScore("수학");
      stu.get(check).setMath(score3);

      stu.get(check).setTotal();
      stu.get(check).setAverage();
      stu.get(check).setGrade();

      System.out.println("수정완료");

    }

  }

  public void delete() {
    System.out.print("삭제시킬 학생이름: ");
    String name = scan.next();
    int check = studentCheck(name);

    if (check != -1) {
      stu.remove(check);
      System.out.println(name + "님 삭제완료");
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
