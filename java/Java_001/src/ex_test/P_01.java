package ex_test;

import java.util.Scanner;

public class P_01 {

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);

    System.out.print("이름을 입력하세요: ");
    String name = scan.next();

    System.out.print("id를 입력하세요: ");
    String id = scan.next();

    System.out.print("pw를 입력하세요: ");
    String pw = scan.next();

    System.out.print("\n회원가입 성공");
    System.out.println("이름: " + name);
    System.out.println("Id: " + id);
    System.out.println("Pw: " + pw);

    System.out.print("id를 입력하세요: ");
    String inputId = scan.next();

    System.out.print("pw를 입력하세요: ");
    String inputPw = scan.next();

    if (inputId.equals(id) && inputPw.equals(pw)) {
      System.out.println("성공: 반가워요(" + id + "님)");
    } else {
      System.out.println("실패: 해당정보가 없습니다.");
    }


  }

}
