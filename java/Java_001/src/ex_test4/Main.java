package ex_test4;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);

    System.out.println("초간단 성적 계산기");

    System.out.print("이름: ");
    String name = scan.next();

    System.out.print("국어점수: ");
    int score1 = scan.nextInt();

    System.out.print("수학점수: ");
    int score2 = scan.nextInt();

    System.out.print("영어점수: ");
    int score3 = scan.nextInt();

    int sumScore = score1 + score2 + score3;
    float average = sumScore / (float) 3;


    System.out.println(name + "님");
    System.out.println("총점: " + sumScore + " 평균: " + average);

    String grade;

    if (average >= 90) {
      grade = "A";
    } else if (average >= 80) {
      grade = "B";
    } else if (average >= 70) {
      grade = "C";
    } else if (average >= 60) {
      grade = "D";
    } else {
      grade = "F";
    }
    System.out.println(grade + "학점 입니다");
  }

}
