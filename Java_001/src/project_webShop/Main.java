package project_webShop;

public class Main {

  public static void main(String[] args) {

    MemberDto loginMem = new MemberDto();
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
        // 0. 종료
        case 0:
          run = false;
          break;

        // 9. 로그아웃
        case 9:
          if (flag) {
            flag = false;
            adminCheck = false;
          }
          break;

        case 1:
          // 로그인
          if (!flag) {
            if (manager.login()) {
              loginMem = manager.currentMem;
              if (loginMem.getmId().equals("admin")) {
                adminCheck = true;
              }
              flag = true;
            }
          } else {
            // 관리자 - 상품등록
            if (adminCheck) {
              manager.addProduct();
            } else {
              // 고객 - 계좌관리
            }
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
