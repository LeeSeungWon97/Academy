package day18;

import java.util.Scanner;

public class TryCatch02 {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    boolean run = true;

    while (true) {
      System.out.println("\n [1]입력 | [2] 출력 | [3] 종료");

      System.out.print("메뉴선택>>");
      int selectMenu = -1;

      try {
        selectMenu = Integer.parseInt(scan.next());
      } catch (Exception e) {
        selectMenu = 0;
      }

      switch (selectMenu) {
        case 1:
          System.out.println("[1]입력");
          break;
        case 2:
          System.out.println("[2]출력");
          break;
        case 3:
          run = false;
          break;
        default:
          System.out.println("잘못 입력하셨습니다.");
      }
    }
  }
}
