package ex_test6;

import java.util.ArrayList;
import java.util.Scanner;

public class ScoreDao {
  Scanner scan = new Scanner(System.in);
  
  private ArrayList<Score> stuList = new ArrayList<Score>();

  // 데이터 insert
  public void insert(Score stuScore) {
    
    stuList.add(stuScore);
  }

  // 리스트 출력
  public void showList() {
    System.out.println("[이름]\t[국어]\t[영어]\t[수학]\t[총점]\t[평균]\t[학점]");
    System.out.println("-------------------------------------------------------------");

    for (int i = 0; i < stuList.size(); i++) {
      System.out.println(stuList.get(i).toString());
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
