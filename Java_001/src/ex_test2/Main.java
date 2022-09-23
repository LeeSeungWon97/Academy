package ex_test2;

public class Main {

  public static void main(String[] args) {
    Manager manager = new Manager();

    boolean run = true;

    while (run) {
      int selectMenu = manager.showMenu();

      switch (selectMenu) {
        case 1:
          manager.memberJoin();
          break;

        case 2:
          manager.showList();
          break;

        case 3:
          run = false;
          break;
      }
    }
    System.out.println("종료");
  }

}
