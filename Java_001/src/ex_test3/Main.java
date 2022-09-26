package ex_test3;

public class Main {

  public static void main(String[] args) {

    Manager manager = new Manager();

    boolean run = true;
    boolean loginFlag = false;

    while (run) {
      int selectMenu = manager.showMenu(loginFlag);
      switch (selectMenu) {
        case 1:
          if (loginFlag == false) {
            manager.memberJoin();
          } else {
            manager.changePw();
          }
          break;

        case 2:
          if (loginFlag == false) {
            loginFlag = manager.login();
          } else {
            loginFlag = manager.logOut();
          }
          break;
        case 3:
          if (loginFlag == false) {
            run = false;
          } else {
            loginFlag = manager.deleteInfo();
          }
          break;

        default:
          System.out.println("다시 선택해주세요");
      }
    }

    System.out.println("종료");
  }

}
