package day15;

public class BankMain {

  public static void main(String[] args) {

    BankManager manager = new BankManager();

    boolean run = true;

    while (run) {
      // 메뉴 출력 & 선택 메소드 호출
      int selectMenu = manager.showMenu();

      switch (selectMenu) {
        // 계좌 생성
        case 1:
          manager.createAccount();
          break;

        // 입금
        case 2:
          manager.deposit();
          break;

        // 출금
        case 3:
          manager.withdrawal();
          break;

        // 잔액조회
        case 4:
          manager.balanceCheck();
          break;

        // 이체
        case 5:
          manager.transferAccount();
          break;

        // 고객리스트
        case 6:
            manager.callList();
          break;

        // 종료
        default:
          run = false;

      }
    }

  }

}
