package day16;

public class ProductMain {

  public static void main(String[] args) {

    ProductManager manager = new ProductManager();

    boolean run = true;

    while (run) {

      // Step1. 메뉴 출력 & 기능 선택 메소드 호출
      int selectMenu = manager.showMenu();

      switch (selectMenu) {
        case 1:
          manager.productRegister();
          break;
        case 2:
          manager.productSearch();
          break;
        case 3:
          manager.infoChange();
          break;
        case 4:
          manager.showList();
          break;
        default:
          run = false;
          System.out.println("[ 종료 ]");

      }


    }
  }

}
