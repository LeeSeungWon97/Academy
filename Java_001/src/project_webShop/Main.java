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

              if (loginMem.getmCheck().equals("Y")) {
                adminCheck = true;
                flag = true;
              } else if(loginMem.getmCheck().equals("B")) {
                System.out.println("사용할 수 없는 계정입니다.");
                break;
              } else {
                flag = true;
              }

            }

          } else {
            // 관리자 - 상품등록
            if (adminCheck) {
              manager.addProduct();
            } else {
              // 고객 - 충전
              manager.chargeCash();
            }
          }
          break;

        case 2:
          // 회원가입
          if (!flag) {
            manager.memberJoin();
          } else {
            // 관리자 - 상품수정
            if (adminCheck) {
              manager.updateProduct();
            } else {
              // 회원 - 상품목록
              manager.showPdList();
            }
          }
          break;

        case 3:
          if (flag) {
            // 관리자 - 회원관리
            if (adminCheck) {
              manager.management();
            } else {
              // 회원 - 상품검색
              manager.productsearch();
            }
          }
          break;

        case 4:
          if (flag) {
            if (!adminCheck) {
              // 주문하기
              int select = manager.selectPurchase();
              if (select == 1) {
                manager.order();
              } else {
                manager.cart();
              }
            } else {
              // 인기상품
              manager.pprize();
            }
          }
          break;

        // 장바구니
        case 5:
          if (flag) {
            if (!adminCheck) {
              // 장바구니 리스트
              manager.showMyCart();
            } else {
              // 최고 회원
              manager.mprize();
            }
          }
          break;

        // 6. 내정보
        case 6:
          if (flag && !adminCheck) {
            manager.showMyInfo();
          }
          break;
      }
    }

    System.out.println("[종료]");

  }

}
