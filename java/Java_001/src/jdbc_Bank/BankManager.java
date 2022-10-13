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

  // 신규 개좌 생성 메소드
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


  // 고객리스트 출력 메소드
  public void clientList() {
    System.out.println("[6]고객리스트");
    // BANKINFO 테이블에서 데이터를 SELECT >> 화면 출력

    // 1. BANKINFO 테이블에서 데이터를 SELECT

    // 객체 선언
    ArrayList<BankDto> list = dao.selectClientList();


    // 2. 고객리스트 출력
    if (list.size() == 0) {
      System.out.println("등록된 고객이 없습니다.");
      return;
    }

    for (int i = 0; i < list.size(); i++) {
      System.out.print("[계좌번호] " + list.get(i).getAccountNumber());
      System.out.print(" [고객이름] " + list.get(i).getClientName());
      System.out.println(" [잔액] " + list.get(i).getBalance() + "원");
    }
  }


  // 잔액조회 메소드
  public void balanceCheck() {
    // BANKINFO 테이블에서 데이터를 SELECT >> 화면에 출력
    System.out.println("[4]잔액조회");

    // 1. 사용자로부터 계좌번호를 입력 받는다.
    System.out.print("잔액조회할 계좌번호 입력 >> ");
    String accountNumber = scan.next();

    // 2. 입력받은 계좌번호로 DAO를 통해서 SELECT문 실행 >> 결과값 리턴
    BankDto bankInfo = dao.selectAccount(accountNumber);

    // 3. 리턴받은 결과값을 바탕으로 기능 처리
    if (bankInfo == null) {
      System.out.println("계좌를 찾을 수 없습니다.");
    } else {
      System.out.println("잔액: " + bankInfo.getBalance() + "원");
    }

  }

  // 입금 메소드
  public void deposit() {
    System.out.println("[2]입금");
    /* BANKINFO 테이블 - UPDATE */

    // 1. 사용자로부터 계좌번호를 입력
    System.out.print("입금할 계좌번호 입력>>");
    String accountNumber = scan.next();

    // 2. 계좌번호 확인
    BankDto bank = dao.selectAccount(accountNumber);
    if (bank == null) {
      System.out.println("계좌를 찾을 수 없습니다.");
    } else {
      // 3. 입금할 금액을 입력
      System.out.print("입금할 금액 입력 >> ");
      int deposit = scan.nextInt();

      // 4. DAO를 통한 잔액 UPDATE 실행
      int updateResult = dao.updateBalance(accountNumber, deposit);
      if (updateResult == 1) {
        System.out.println("입금처리 되었습니다");
        bank = dao.selectAccount(accountNumber);
        System.out.println("입금 후 잔액: " + bank.getBalance() + "원");
      } else {
        System.out.println("입금처리에 실패하였습니다.");
      }
    }
  }

  public void withdraw() {
    System.out.println("[3] 출금");
    /* BANKINFO 테이블 - UPDATE */

    // 1. 계좌번호를 입력
    System.out.print("출금할 계좌번호 입력 >> ");
    String accountNumber = scan.next();
    // 2. 등록계좌인지 확인
    BankDto bank = dao.selectAccount(accountNumber);
    if (bank == null) {
      System.out.println("없는 계좌입니다.");
    } else {
      // 3. 사용자로부터 출금할 금액 입력 받음
      System.out.print("출금할 금액 입력 >>");
      int withdraw = scan.nextInt();
      // 4. 잔액 > 출금액 확인
      if (bank.getBalance() >= withdraw) {
        // 5. 계좌번호, 출금액 DAO를 통해 UPDATE문 실행
        dao.updateBalance(accountNumber, -withdraw);
        System.out.println("출금처리 되었습니다.");
        bank = dao.selectAccount(accountNumber);
        System.out.println("출금 후 잔액: " + bank.getBalance() + "원");
      } else {
        System.out.println("잔액이 부족합니다.");
      }
    }



  }

  public void transferAccout() {
    System.out.println("[5] 이체 ");

    // 1. 보내는 계좌번호 입력 및 확인
    System.out.print("계좌번호 입력 >> ");
    String sendAccountNumber = scan.next();

    BankDto sendBank = dao.selectAccount(sendAccountNumber);

    if (sendBank == null) {

      System.out.println("없는 계좌입니다.");

    } else {
      // 2. 이체할 금액, 받는 계좌번호 입력
      System.out.print("이체할 금액을 입력 >> ");
      int transPay = scan.nextInt();

      System.out.print("이체할 계좌를 입력 >> ");
      String accpetAccountNumber = scan.next();

      // 3. 받는 계좌 확인
      BankDto acceptBank = dao.selectAccount(accpetAccountNumber);

      if (acceptBank != null) {

        if (sendAccountNumber.equals(accpetAccountNumber)) {

          System.out.println("같은 계좌입니다.");

        } else {
          // 4. 보내는 계좌 잔액확인
          if (sendBank.getBalance() >= transPay) {

            // 5. 이체 실행
            dao.updateBalance(sendAccountNumber, -transPay);
            dao.updateBalance(accpetAccountNumber, transPay);

            System.out.println("이체가 완료되었습니다.");
            sendBank = dao.selectAccount(sendAccountNumber);
            acceptBank = dao.selectAccount(accpetAccountNumber);
            System.out.println(sendAccountNumber + "계좌 잔액: " + sendBank.getBalance());
            System.out.println(accpetAccountNumber + "계좌 잔액: " + acceptBank.getBalance());

          } else {
            System.out.println("잔액이 부족합니다.");
          }

        }

      }

    }

  }

  public void commitTest() {
    System.out.println("[8]커밋");
    int result = dao.commitTest();
    System.out.println("result: " + result);
  }

}
