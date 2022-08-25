package day15;

import java.util.ArrayList;
import java.util.Scanner;

public class BankManager {

  Scanner scan = new Scanner(System.in);

  // 메뉴 출력 & 선택 메소드
  public int showMenu() {
    System.out.println("========================================================================");
    System.out.println(" [1]계좌생성 | [2]입급 | [3]출금 | [4]잔액조회 | [5] 이체 | [6]고객리스트 | [7]종료 ");
    System.out.println("========================================================================");
    System.out.print("메뉴선택>>");
    return scan.nextInt();
  }

  private ArrayList<BankInfo> accountList = new ArrayList<BankInfo>();

  // 계좌번호 중복 체크 메소드
  private String accountCheck() {

    String accountNumber;

    while (true) {
      System.out.print("계좌번호>>");
      accountNumber = scan.next();

      int idx = searchIdx(accountNumber);

      if (idx == -1) {
        break;
      } else {
        System.out.println("등록된 계좌번호입니다.");
      }
    }
    return accountNumber;
  }


  // 계좌 생성 메소드
  public void createAccount() {

    System.out.println("[ 계좌생성 ]");

    BankInfo newAccount = new BankInfo();

    newAccount.setAccountNumber(accountCheck());

    System.out.print("고객이름>>");
    newAccount.setClientName(scan.next());

    System.out.print("입금액>>");
    newAccount.setBalance(scan.nextInt());

    accountList.add(newAccount);

    System.out.println(newAccount);
    System.out.println("신규 계좌가 등록 되었습니다.");
  }

  // 계좌번호 확인 메소드
  private int searchIdx(String accountNumber) {

    int idx = -1;
    for (int i = 0; i < accountList.size(); i++) {
      String account = accountList.get(i).getAccountNumber();

      if (accountNumber.equals(account)) {
        idx = i;
      }
    }

    return idx;
  }

  // 입금 메소드
  public void deposit() {

    System.out.println("[ 입금 ]");
    System.out.print("입금할 계좌번호>>");
    String accountNumber = scan.next();

    int idx = searchIdx(accountNumber);

    if (idx > -1) {
      System.out.print("입금할 금액>>");
      int deposit = scan.nextInt();
      int balance = accountList.get(idx).getBalance();

      accountList.get(idx).setBalance(balance + deposit);

      System.out.println("입금 되었습니다");
      System.out.println("현재 잔액은 " + accountList.get(idx).getBalance() + "원 입니다.");
    } else {
      System.out.println("없는 계좌입니다.");
    }
  }

  // 출금 메소드
  public void withdrawal() {
    System.out.println("[ 출금 ]");
    System.out.print("출금할 계좌번호>>");
    String accountNumber = scan.next();

    int idx = searchIdx(accountNumber);

    if (idx > -1) {
      System.out.print("출금할 금액>>");
      int withdrawal = scan.nextInt();
      int balance = accountList.get(idx).getBalance();

      if (balance >= withdrawal) {
        accountList.get(idx).setBalance(balance - withdrawal);
        System.out.println(withdrawal + "원을 출금되었습니다.");
      } else {
        System.out.println("잔액이 부족합니다.");
      }
      System.out.println("현재 잔액은 " + accountList.get(idx).getBalance() + "원 입니다.");

    } else {
      System.out.println("없는 계좌입니다.");
    }
  }

  // 잔액조회 메소드
  public void balanceCheck() {
    System.out.print("계좌입력>>");
    String accountNumber = scan.next();
    int idx = searchIdx(accountNumber);

    if (idx > -1) {
      System.out.println("현재 잔액: " + accountList.get(idx).getBalance() + "원");
    } else {
      System.out.println("없는 계좌입니다.");
    }
  }

  // 계좌이체 메소드
  public void transferAccount() {
    System.out.print("보내는 사람의 계좌번호 입력하세요>>");
    String accountNumber = scan.next();

    int idx = searchIdx(accountNumber);

    if (idx > -1) {
      System.out.print("이체할 금액을 입력하세요>>");
      int transfer = scan.nextInt();
      int balance = accountList.get(idx).getBalance();

      System.out.print("받는 사람의 계좌번호를 입력하세요>>");
      String accountNumber2 = scan.next();
      int idx2 = searchIdx(accountNumber2);

      if (idx2 > -1) {
        int balance2 = accountList.get(idx2).getBalance();

        if (balance >= transfer) {
          accountList.get(idx).setBalance(balance - transfer);
          accountList.get(idx2).setBalance(balance2 + transfer);
          System.out.println("이체가 완료되었습니다.");
        } else {
          
          System.out.println("잔액이 부족합니다.");
        }

      } else {
        System.out.println("없는 계좌입니다.");
      }

    } else {
      System.out.println("없는 계좌입니다.");
    }
  }


  // 고객리스트 호출 메소드
  public void callList() {
    for (int i = 0; i < accountList.size(); i++) {
      System.out.println(accountList.get(i));
      System.out.println();
    }
  }
}
