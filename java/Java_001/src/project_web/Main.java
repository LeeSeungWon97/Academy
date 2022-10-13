package project_web;

public class Main {

  public static void main(String[] args) {

    Manager manager = new Manager();

    boolean run = true;
    boolean loginFlag = false; // 로그인 상태 확인
    int memberFlag = 0; // 회원종류 구분 (1.일반회원 2.관리자 3.블랙리스트)

    while (run) {


      // 로그인이 안된경우
      if (!loginFlag) {
        int selectNum = manager.initalMenu();

        switch (selectNum) {
          // 0.종료
          case 0:
            run = false;
            break;

          // 1.로그인
          case 1:
            // 로그인 상태 확인
            loginFlag = manager.login();

            if (loginFlag) {
              memberFlag = manager.mCheck();

              if (memberFlag == 3) { // 블랙리스트 회원인 경우 - 로그아웃

                loginFlag = false;
                System.out.println("이용할 수 없는 아이디입니다.");

              } else {
                System.out.println("로그인 성공");
              }

            } else {
              System.out.println("아이디/비밀번호가 틀렸습니다.");
            }
            break;

          // 2. 회원가입
          case 2:
            manager.memberJoin();
            break;
        }
      } else { // 로그인 된경우

        // 일반회원인 경우
        if (memberFlag == 1) {
          int selectNum = manager.memberMenu();

          switch (selectNum) {

            // 0.종료
            case 0:
              run = false;
              break;

            // 9.로그아웃
            case 9:
              loginFlag = false;
              break;

            // 1. 충전
            case 1:
              manager.chargeCash();
              break;

            // 2. 상품목록
            case 2:
              manager.showProductList();
              break;

            // 3. 상품검색
            case 3:
              manager.searchProduct();
              break;

            // 4. 주문하기
            case 4:
              manager.order();
              break;

            // 5. 장바구니내역
            case 5:
              manager.showCart();
              break;

            // 6. 내정보
            case 6:
              manager.showMyInfo();
              break;

          }

        } else { // 관리자인 경우
          int selectNum = manager.adminMenu();

          switch (selectNum) {

            // 0.종료
            case 0:
              run = false;
              break;

            // 9.로그아웃
            case 9:
              loginFlag = false;
              break;

            // 1.상품등록
            case 1:
              manager.addProduct();
              break;

            // 2. 상품정보수정
            case 2:
              manager.reviseProduct();
              break;

            // 3. 회원관리
            case 3:
              manager.memberManagement();
              break;

            // 4.인기상품
            case 4:
              manager.bestProduct();
              break;

            // 5.최고회원
            case 5:
              manager.bestMember();
              break;
          }

        }

      }
    }
    System.out.println("\n종료");

  }

}
