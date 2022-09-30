package project_webShop;

public class Main {

  public static void main(String[] args) {

    Manager manager = new Manager();

    boolean run = true;
    boolean flag = false;
    boolean adminCheck = false;
    while (run) {
      int selectMenu;

      // 메뉴 출력
      if (!flag) {
        selectMenu = manager.initialMenu();
      } else {
        selectMenu = manager.loginMenu(adminCheck);
      }


      switch (selectMenu) {
        case 0:
          run = false;
          break;

        case 9:
          if (flag) {
            flag = false;
          }
          break;

        case 1:
          if (!flag) {
            adminCheck = manager.login();
            flag = true;
          }
          break;
        case 2:
          manager.memberJoin();
          break;
      }
    }

    System.out.println("[종료]");

  }

}
