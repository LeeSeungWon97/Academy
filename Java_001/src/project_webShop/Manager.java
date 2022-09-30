package project_webShop;

import java.util.Scanner;

public class Manager {

  Scanner scan = new Scanner(System.in);

  // 초기화면 출력
  public int initialMenu() {

    System.out.println("============================");
    System.out.println("1.로그인 | 2.회원가입 | 0.종료");
    System.out.println("============================");
    System.out.print("메뉴선택 >> ");
    return scan.nextInt();
  }

  // 로그인 후 메뉴
  public int loginMenu(boolean adminCheck) {
    System.out.println("============================");
    if(adminCheck) {
      System.out.println("1.계좌관리 | 2.상품목록 | 3.상품검색 | 4.주문하기 | 5.장바구니 | 6.내정보 | 9.로그아웃 | 0.종료");
    } else {
      System.out.println("1.상품등록 | 2.상품수정 | 3.회원정보 | 4.회원관리 | 9.로그아웃 | 0.종료");
    }
    System.out.println("============================");
    return scan.nextInt();
  }

  public boolean login() {
    boolean check = false;
    
    System.out.print("아이디: ");
    String id = scan.next();
    
    System.out.print("비밀번호: ");
    String pw = scan.next();
    
    if(id.equals("admin")) {
      check = true;
    }
    
    return check;
  }

  public void memberJoin() {
    System.out.println("회원가입");
  }



}
