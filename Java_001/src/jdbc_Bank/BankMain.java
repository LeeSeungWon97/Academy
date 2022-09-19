package jdbc_Bank;

public class BankMain {

  public static void main(String[] args) {

    // Manager Class(기능) :: 메뉴출력, 입금, 출금...
    BankManager manager = new BankManager();


    boolean run = true;

    while (run) {
      // 메뉴 출력기능 호출 및 원하는 기능 선택
      int selectMenu = manager.showMenu();

      // 기능 실행
      switch (selectMenu) {
        // 1. 계좌생성
        case 1:
          manager.createAccount();
          break;

        // 6. 고객리스트
        case 6:
          manager.clientList();
          break;
          
        // 7. 종료
        case 7:
          run = false;
          System.out.println("[사용 종료]");
          break;
      }

    }

  }

}
