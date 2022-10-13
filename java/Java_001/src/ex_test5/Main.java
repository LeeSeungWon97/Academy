package ex_test5;

public class Main {

  public static void main(String[] args) {

    Manager manager = new Manager();

    boolean run = true;
    boolean flag = false;

    while (run) {
      int selectMenu = manager.showMenu(flag);

      switch (selectMenu) {
        case 0:
          run = false;
          break;

        case 1:
          if (!flag) {
            manager.insertScore();
          } else {
            manager.searchStu();
          }
          break;

        case 2:
          if (!flag) {
            manager.showList();
          } else {
            manager.changeScore();
          }
          break;

        case 3:
          if (!flag) {
            flag = true;
          } else {
            manager.delete();
          }
          break;
        case 4:
          if (!flag) {
            continue;
          } else {
            flag = false;
            break;
          }

        default:
          System.out.println("없는 메뉴입니다. 다시 입력해주세요");
      }
    }

    System.out.println("[ 종료 ]");

  }

}
