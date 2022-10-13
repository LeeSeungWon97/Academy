package jdbc_Order;

public class OrderMain {

  public static void main(String[] args) {

    OrderManager manager = new OrderManager();

    boolean run = true;

    while (run) {
      // 1. 메뉴출력 메소드 호출
      int selectMenu = manager.showMenu();

      if (manager.getLoginId() == null) {

        // 로그인이 안되어 있는 경우 switch
        switch (selectMenu) {

          // 회원가입 메소드 호출
          case 1:
            manager.memberJoin();
            break;

          // 로그인 기능 메소드 호출
          case 2:
            manager.memberLogin();
            break;

          case 0:
            run = false;
            break;
        }
      } else {

        // 로그인 되어있는 경우 switch
        switch (selectMenu) {
          // 내 정보 보기 기능 메소드 호출
          case 1:
            manager.memberInfo();
            break;

          // 로그아웃 기능 메소드 호출
          case 2:
            manager.memberLogout();
            break;

          // 상품주문 기능 메소드 호출
          case 3:
            manager.productOrder();
            break;

          // 주문내역 기능 메소드 호출
          case 4:
            manager.myOrderList();
            break;
          case 0:
            run = false;
            break;
        }
      }

    }
    System.out.println("종료");
  }

}
