package jdbc_Bank;

import java.util.ArrayList;
import java.util.Scanner;

public class BankManager {

  private Scanner scan = new Scanner(System.in);
  private BankDao dao = new BankDao();

  // 메뉴 출력 & 선택 메소드
  public int showMenu() {
    System.out.println("========================================================================");
    System.out.println(" [1]계좌생성 | [2]입급 | [3]출금 | [4]잔액조회 | [5] 이체 | [6]고객리스트 | [7]종료 ");
    System.out.println("========================================================================");
    System.out.print("메뉴선택>>");
    return scan.nextInt();
  }

  public void createAccount() {
    /*
     1. 사용자에게 사용할 계좌번호 입력 >> 중복확인
     2. 계좌번호 중복 X >> 이름, 초기금액 입력 >> [계좌번호, 이름, 초기금액]을 DB테이블에 insert
     3. 계좌번호 중복 O >> 계좌번호 다시 입력
     */
    System.out.println("[1]계좌생성");
    String accountNumber = accountCheck();

    System.out.print("이름 입력 >> ");
    String clientName = scan.next();

    System.out.print("초기금액 입력 >> ");
    int balance = scan.nextInt();

    System.out.print("계좌번호: " + accountNumber);
    System.out.print(", 고객이름: " + clientName);
    System.out.println(", 초기입금액: " + balance);

    BankDto bankinfo = new BankDto();

    bankinfo.setAccountNumber(accountNumber);
    bankinfo.setClientName(clientName);
    bankinfo.setBalance(balance);

    int insertResult = dao.insertCreateAccount(bankinfo);

    if (insertResult > 0) {
      System.out.println("신규 계좌가 개설되었습니다.");
    } else {
      System.out.println("계좌 개설에 실패했습니다.");
    }

  }


  // 계좌번호 중복 체크 메소드
  private String accountCheck() {

    String accountNumber;

    while (true) {
      System.out.print("사용할 계좌번호 >>");
      accountNumber = scan.next();

      String accountCheck = dao.selectAccountCheck(accountNumber);

      if (accountCheck == null) {
        break;
      } else {
        System.out.println("이미 사용중인 계좌번호입니다.");
      }
    }
    return accountNumber;
  }

  public void clientList() {
    System.out.println("[6]고객리스트");
    // BANKINFO 테이블에서 데이터를 SELECT >> 화면 출력

    // 1. BANKINFO 테이블에서 데이터를 SELECT

    // 객체 선언
    ArrayList<BankDto> list = dao.selectClientList();

    
    // 2. 고객리스트 출력
    if(list.size() == 0) {
      System.out.println("등록된 고객이 없습니다.");
      return;
    }
    
    for (int i = 0; i < list.size(); i++) {
      System.out.print("[계좌번호] " + list.get(i).getAccountNumber());
      System.out.print(" [고객이름] " + list.get(i).getClientName());
      System.out.println(" [잔액] " + list.get(i).getBalance() + "원");
    }
  }

}
