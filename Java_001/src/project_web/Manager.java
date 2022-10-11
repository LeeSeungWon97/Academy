package project_web;

import java.util.ArrayList;
import java.util.Scanner;

public class Manager {
  Scanner scan = new Scanner(System.in);

  /***** DAO & DTO *****/
  MemberDao mdao = new MemberDao();
  ProductDao pdao = new ProductDao();
  OrderListDao odao = new OrderListDao();
  CartDao cdao = new CartDao();

  MemberDto loginInfo = new MemberDto(); // 현재 로그인된 회원의 정보

  // 초기화면
  public int initalMenu() {
    System.out.println("========================");
    System.out.println("1.로그인 | 2.회원가입 | 0.종료");
    System.out.println("========================");
    System.out.print("메뉴선택: ");
    return scan.nextInt();
  }

  // 로그인한 회원정보 받기
  public void reciveInfo() {
    loginInfo = mdao.callMyInfo(loginInfo.getmId());
  }

  // 로그인한 회원정보 내보내기
  public void sendInfo() {
    mdao.updateMyInfo(loginInfo);
  }

  /***** loginFlag: false *****/

  /* 로그인메소드 */
  public boolean login() {
    System.out.print("아이디: ");
    String id = scan.next();
    System.out.print("비밀번호: ");
    String pw = scan.next();
    boolean check = mdao.loginCheck(id, pw);

    if (check) {
      loginInfo = mdao.callMyInfo(id);
    }

    return check;
  }

  /* 관리자,블랙,일반회원 확인 메소드 */
  public int mCheck() {
    String mcheck = loginInfo.getmCheck();
    int type = 0;
    switch (mcheck) {
      case "N":
        type = 1;
        break;
      case "Y":
        type = 2;
        break;
      case "B":
        type = 3;
        break;
    }
    return type;
  }

  /* 회원가입 메소드 */
  public void memberJoin() {
    MemberDto mdto = new MemberDto();

    boolean run = true;

    while (run) {
      // 가입할 아이디 입력
      System.out.print("아이디: ");
      String id = scan.next();

      // 아이디 중복 확인
      boolean idCheck = mdao.searchId(id);

      if (idCheck) {
        System.out.println("이미 사용중인 아이디입니다.");
      } else {
        // 비밀번호 입력
        System.out.print("비밀번호: ");
        String pw = scan.next();

        // 이름 입력
        System.out.print("이름: ");
        String name = scan.next();

        // 성별 입력
        System.out.print("성별(1.남 / 2.여): ");
        int gender = scan.nextInt();

        // 생년월일 입력
        System.out.print("생년월일(YYYYMMDD): ");
        String birth = scan.next();

        // 이메일 입력
        System.out.print("이메일: ");
        String email = scan.next();

        mdto.setmId(id);
        mdto.setmPw(pw);
        mdto.setmName(name);
        mdto.setmGender(gender);
        mdto.setmBirth(birth);
        mdto.setmEmail(email);

        // 소지금,등급,회원구분,총소비금 초기값
        mdto.setmCash(0);
        mdto.setmGrade("B");
        mdto.setmCheck("N");
        mdto.setmTotal(0);


        // MEMBERS에 회원가입 정보 INSERT
        int joinResult = mdao.join(mdto);

        if (joinResult == 1) {
          System.out.println("회원가입 완료");
          run = false;
        } else {
          System.out.println("회원가입 실패");
        }
      }
    }

  }


  /***** 관리자 로그인 *****/
  public int adminMenu() {
    System.out.println("=================================================================");
    System.out.println("1.상품등록 | 2.상품수정 | 3.회원관리 | 4.인기상품 | 5.최고구매회원 | 9.로그아웃 | 0.종료");
    System.out.println("=================================================================");
    System.out.print("메뉴선택: ");
    return scan.nextInt();
  }


  /*** 1.상품등록 메소드 ***/
  public void addProduct() {

    // 상품명 입력
    System.out.print("상품명: ");
    String pName = scan.next();

    // 동일상품 체크
    boolean check = pdao.productCheck(pName);
    if (!check) {
      ProductDto pdto = new ProductDto();

      String code = pCodeMenu();

      System.out.print("상품가격: ");
      int price = scan.nextInt();

      System.out.print("상품수량: ");
      int amount = scan.nextInt();

      pdto.setPdCode(code);
      pdto.setPdName(pName);
      pdto.setPdPrice(price);
      pdto.setPdAmount(amount);
      pdto.setPdType(code);

      // PRODUCT 테이블에 INSERT
      int insertResult = pdao.addProduct(pdto);

      if (insertResult == 1) {
        System.out.println("상품이 등록되었습니다.");
      } else {
        System.out.println("상품등록이 취소되었습니다.");
      }
    } else {
      System.out.println("이미 등록된 상품입니다.");
    }


  }

  // 등록상품 Code
  private String pCodeMenu() {
    System.out.println("=============================");
    System.out.println("1. PO | 2. PT | 3. PP | 4. PS | 0.뒤로가기");
    System.out.println("=============================");

    boolean run = true;
    String pdCode = null;
    String pdType = null;
    int pdCnt = 0;
    while (run) {
      System.out.print("상품코드(번호): ");
      int selectNum = scan.nextInt();
      switch (selectNum) {
        case 0:
          pdCode = "종료";
          break;
        case 1:
          pdType = "아우터";
          pdCnt = pdao.setCodeNum(pdType);
          pdCode = "PO" + String.format("%03d", pdCnt);
          run = false;
          break;
        case 2:
          pdType = "상의";
          pdCnt = pdao.setCodeNum(pdType);
          pdCode = "PT" + String.format("%03d", pdCnt);
          run = false;
          break;
        case 3:
          pdType = "하의";
          pdCnt = pdao.setCodeNum(pdType);
          pdCode = "PP" + String.format("%03d", pdCnt);
          run = false;
          break;
        case 4:
          pdType = "신발";
          pdCnt = pdao.setCodeNum(pdType);
          pdCode = "PS" + String.format("%03d", pdCnt);
          run = false;
          break;
        default:
          System.out.println("다시 입력해주세요");
      }

    }

    return pdCode;
  }


  /*** 2.상품수정 메소드 ***/
  public void reviseProduct() {
    // 수정할 상품이름 입력
    System.out.print("수정할 상품이름: ");
    String pName = scan.next();

    // 해당상품이 있는경우
    if (pdao.productCheck(pName)) {
      ProductDto pdto = new ProductDto();
      // 해당상품 정보 출력
      pdto = pdao.recievePdto(pName);
      System.out.println(pdto.toString());

      System.out.println("============");
      System.out.println("1.가격 | 2.수량");
      System.out.println("============");

      // 수정할 정보 선택
      System.out.print("수정할 내용: ");
      int selectNum = scan.nextInt();

      if (selectNum == 1) {
        System.out.print("변경 가격: ");
      } else {
        System.out.print("변경 수량: ");
      }

      int change = scan.nextInt();

      //
      int updateResult = pdao.pdUpdate(pName, selectNum, change);

      if (updateResult > 0) {
        System.out.println("업데이트 성공");
      } else {
        System.out.println("업데이트 실패");
      }
    } else {
      System.out.println("등록되지 않은 상품입니다.");
    }

  }

  /*** 3. 회원관리 메소드 ***/
  public void memberManagement() {
    boolean run = true;
    while (run) {
      System.out.println("==============================================");
      System.out.println("1.회원목록 | 2.회원검색 | 3.회원권한 | 4.회원삭제 | 0.뒤로가기");
      System.out.println("==============================================");
      System.out.print("메뉴선택: ");
      int selectNum = scan.nextInt();

      switch (selectNum) {

        // 회원목록
        case 1:
          System.out.println("==============================");
          System.out.println("1.일반 | 2.관리자 | 3.블랙 | 0.뒤로가기");
          System.out.println("==============================");
          System.out.print("메뉴선택: ");
          int selectCheck = scan.nextInt();

          if (selectCheck == 1) {
            mdao.showMembers("N");
          } else if (selectCheck == 2) {
            mdao.showMembers("Y");
          } else if (selectCheck == 3) {
            mdao.showMembers("B");
          } else {
            break;
          }

          break;

        // 회원검색
        case 2:
          System.out.print("검색할 회원 아이디: ");
          String id = scan.next();

          boolean check = mdao.searchId(id);

          if (check) {
            MemberDto mdto = mdao.callMyInfo(id);
            System.out.println(mdto.toString());
          } else {
            System.out.println("등록되지 않은 회원입니다.");
          }
          break;

        // 회원권한
        case 3:
          System.out.print("권한을 바꿀 회원 아이디: ");
          id = scan.next();

          check = mdao.searchId(id);

          if (check) {
            System.out.print("변경할 권한(관리자: Y, 일반회원: N, 블랙리스트: B): ");
            String mCheck = scan.next();

            // mCheck 변경
            int updateResult = mdao.changeMcheck(mCheck, id);

            if (updateResult == 1) {
              // 업데이트 성공시
              System.out.println("변경완료");
              MemberDto mdto = mdao.callMyInfo(id);
              System.out.println(mdto.toString());
            } else {
              System.out.println("변경실패");
            }
          } else {
            System.out.println("등록되지 않은 아이디입니다.");
          }
          break;

        // 회원삭제
        case 4:
          System.out.print("삭제할 회원 아이디: ");
          id = scan.next();

          MemberDto mdto = mdao.callMyInfo(id);
          System.out.println("[회원정보]");
          System.out.println(mdto.toString());

          System.out.print("삭제하시겠습니까?([1]Y [2]N): ");
          int select = scan.nextInt();

          if (select == 1) {
            int deleteResult = mdao.deleteMember(id);
            if (deleteResult == 1) {
              System.out.println("삭제완료");
            } else {
              System.out.println("삭제실패");
            }
          }
          break;

        // 뒤로가기
        case 0:
          run = false;
          break;

      }
    }

  }

  // 인기상품 출력 메소드
  public void bestProduct() {
    ArrayList<String[]> bestList = pdao.showBestProduct();

    if (bestList.size() != 0) {
      for (int i = 0; i < bestList.size(); i++) {
        System.out.println("=================================");
        System.out.println(i + 1 + "위");
        System.out.println(bestList.get(i)[0] + "\t\t" + bestList.get(i)[1]);
        System.out.println("=================================");
      }
    } else {
      System.out.println("통계 데이터가 부족합니다.");
    }
  }

  // 최고회원 출력 메소드
  public void bestMember() {
    ArrayList<String[]> bestList = mdao.showBestMember();

    if (bestList.size() != 0) {
      for (int i = 0; i < bestList.size(); i++) {
        System.out.println("=================================");
        System.out.println(i + 1 + "위");
        System.out.println(bestList.get(i)[0] + "\t\t" + bestList.get(i)[1]);
        System.out.println("=================================");
      }
    } else {
      System.out.println("통계 데이터가 부족합니다.");
    }
  }


  /***** 일반회원 로그인 *****/

  // 일반회원메뉴 출력 메소드
  public int memberMenu() {
    System.out.println("========================================================================");
    System.out.println("1.충전 | 2.상품목록 | 3.상품검색 | 4.주문하기 | 5.장바구니내역 | 6.내정보 | 9.로그아웃 | 0.종료");
    System.out.println("========================================================================");
    System.out.print("메뉴선택: ");
    return scan.nextInt();
  }

  /*** 1.충전 메소드 ***/

  public void chargeCash() {
    // 로그인한 회원의 정보 받기
    MemberDto mdto = mdao.callMyInfo(loginInfo.getmId());

    // 충전할 금액 입력받기
    System.out.print("충전할 금액 입력: ");
    int balance = scan.nextInt();

    // 충전할 금액 확인 및 의사 결정
    System.out.println("충전할 금액: " + balance);
    System.out.print("충전하시겠습니까? ([1]예 [2]아니요): ");
    int selectNum = scan.nextInt();

    // 충전을 한다고 입력받으면
    if (selectNum == 1) {
      int updateResult = mdao.addCash(balance, mdto);

      // 업데이트 성공시
      if (updateResult == 1) {
        // 로그인 회원정보 다시 불러오기
        loginInfo = mdao.callMyInfo(loginInfo.getmId());
        System.out.println(loginInfo.toString());
        System.out.println("중전이 완료되었습니다.");
      } else {
        System.out.println("충전 오류발생");
      }
    } else {
      System.out.println("충전을 취소하셨습니다.");
    }
  }


  /*** 2.상품목록 ***/
  public void showProductList() {
    boolean run = true;
    while (run) {
      ArrayList<ProductDto> productList = new ArrayList<ProductDto>();

      System.out.println("======================================");
      System.out.println("1.아우터 | 2.상의 | 3.하의 | 4.신발 | 0.뒤로가기");
      System.out.println("======================================");
      System.out.print("메뉴선택: ");
      int selectNum = scan.nextInt();

      switch (selectNum) {
        // 종료
        case 0:
          System.out.println();
          run = false;
          break;

        // 아우터
        case 1:
          productList = pdao.showList("아우터");
          break;

        // 상의
        case 2:
          productList = pdao.showList("상의");
          break;

        // 하의
        case 3:
          productList = pdao.showList("하의");
          break;

        // 신발
        case 4:
          productList = pdao.showList("신발");
          break;
      }

      for (int i = 0; i < productList.size(); i++) {
        System.out.println(productList.get(i).toString());
      }
    }


  }


  /*** 3.상품검색 ***/
  public void searchProduct() {
    System.out.print("[검색]: ");
    String name = scan.next();

    ArrayList<ProductDto> searchList = pdao.searchList(name);

    if (searchList.size() != 0) {
      for (int i = 0; i < searchList.size(); i++) {
        System.out.println(searchList.get(i).toString());
      }
    } else {
      System.out.println("상품이 없습니다.");
    }

  }

  /*** 4.주문하기 ***/
  public void order() {
    // 구매상품 & 수량
    System.out.print("구매할 상품명: ");
    String name = scan.next();

    ProductDto pdto = pdao.recievePdto(name);

    if (pdao.productCheck(name)) {

      System.out.print("구매 수량: ");
      int amount = scan.nextInt();

      System.out.println("===============================");
      System.out.println("1.구매하기 | 2.장바구니 담기 | 0. 뒤로가기");
      System.out.println("===============================");
      System.out.print("메뉴선택: ");
      int selectNum = scan.nextInt();

      switch (selectNum) {

        // 1.구매하기
        case 1:
          // 구매상품 총 금액
          int pay = pdto.getPdPrice() * amount;

          if (loginInfo.getmCash() < pay) {
            System.out.println("소지금이 부족합니다.");
          } else if (pdto.getPdAmount() < amount) {
            System.out.println("상품이 부족합니다.");
          } else {
            int insertResult = odao.orderProduct(pdto, loginInfo, amount);

            if (insertResult == 1) {

              // MEMBERS
              loginInfo.setmCash(loginInfo.getmCash() - pay);
              loginInfo.setmTotal(loginInfo.getmTotal() + pay);
              loginInfo.setmGrade(changeGrade(loginInfo.getmTotal()));

              int mUpdateResult = mdao.updateMyInfo(loginInfo);

              // loginInfo 최신화
              mdao.callMyInfo(loginInfo.getmId());

              // PRODUCT
              int pUpdateResult = pdao.pdUpdate(name, 2, pdto.getPdAmount() - amount);

              if (mUpdateResult == 1 && pUpdateResult == 1) {
                System.out.println("구매완료");
              }
            } else {
              System.out.println("구매실패");
            }
          }
          break;

        // 2.장바구니 담기
        case 2:
          // 로그인 회원 장바구니 리스트 가져오기
          ArrayList<CartDto> cList = cdao.cartList(loginInfo.getmId());

          boolean check = false;
          int idx = -1;

          for (int i = 0; i < cList.size(); i++) {
            if (cList.get(i).getcName().equals(name)) {
              idx = i;
              check = true;
            }
          }

          // 해당 상품이 장바구니에 있을시 수량 증가
          if (check) {
            CartDto cdto = cList.get(idx);
            int updateResult = cdao.addAmount(name, amount, cdto);
            if (updateResult == 1) {
              System.out.println("장바구니 등록완료");
            } else {
              System.out.println("장바구니 등록실패");
            }
          } else {
            // 해당상품이 장바구니에 없는 경우
            int insultResult = cdao.addList(loginInfo, pdto, amount);

            if (insultResult == 1) {
              System.out.println("장바구니 등록완료");
            } else {
              System.out.println("장바구니 등록실패");
            }
          }

          break;

        // 0. 뒤로가기
        case 0:
          break;
      }
    } else {
      System.out.println("존재하지 않는 상품입니다.");
    }
  }


  // 회원등급 변경 메소드
  private String changeGrade(int mTotal) {
    String grade = "";

    if (mTotal > 1000000) {
      grade = "D";
    } else if (mTotal > 500000) {
      grade = "P";
    } else if (mTotal > 250000) {
      grade = "G";
    } else if (mTotal > 170000) {
      grade = "S";
    } else {
      grade = "B";
    }
    return grade;
  }


  /*** 5.장바구니 내역 ***/
  public void showCart() {

    boolean run = true;

    while (run) {
      ArrayList<CartDto> cList = cdao.cartList(loginInfo.getmId());

      // 장바구니 내역 출력
      System.out.println(loginInfo.getmId() + "님 장바구니");

      if (cList.size() != 0) {
        for (int i = 0; i < cList.size(); i++) {
          System.out.println((i + 1) + "번: " + cList.get(i).toString());
        }

        System.out.println("==============================");
        System.out.println("1. 구매결정 | 2.장바구니삭제 | 0.뒤로가기");
        System.out.println("==============================");
        System.out.print("메뉴선택: ");
        int selectNum = scan.nextInt();

        switch (selectNum) {
          case 1:
            // 소지금 출력
            System.out.println("[" + loginInfo.getmId() + "] [" + loginInfo.getmCash() + "]");

            // 구매할 상품 입력
            System.out.print("구매할 상품 번호: ");
            int idx = scan.nextInt();

            // 장바구니번호보다 큰번호 입력시 탈출
            if (idx >= cList.size()) {
              break;
            }

            // 해당 상품 정보 불러오기
            ProductDto pdto = new ProductDto();
            pdto = pdao.recievePdto(cList.get(idx - 1).getcName());

            // 지불할 금액 & 구매수량
            int pay = cList.get(idx - 1).getpTotal();
            int amount = cList.get(idx - 1).getcAmount();

            // 소지금이 부족할 경우
            if (loginInfo.getmCash() < pay) {
              System.out.println("소지금이 부족합니다.");
            } else if (pdto.getPdAmount() < amount) {
              // 상품수량이 부족할 경우
              System.out.println("상품수량이 부족합니다.");
            } else {

              // ORDERLIST - INSERT
              int insultResult = odao.orderProduct(pdto, loginInfo, amount);

              if (insultResult == 1) {
                // MEMBERS - UPDATE
                loginInfo.setmCash(loginInfo.getmCash() - pay);
                loginInfo.setmTotal(loginInfo.getmTotal() + pay);
                loginInfo.setmGrade(changeGrade(loginInfo.getmTotal()));

                int mUpdateResult = mdao.updateMyInfo(loginInfo);

                // loginInfo 최신화
                mdao.callMyInfo(loginInfo.getmId());

                // PRODUCT - UPDATE
                int pUpdateResult = pdao.pdUpdate(pdto.getPdName(), 2, pdto.getPdAmount() - amount);

                // CART - DELETE
                int deleteResult = cdao.deleteList(loginInfo.getmId(), pdto.getPdCode());

                if (mUpdateResult == 1 && pUpdateResult == 1 && deleteResult == 1) {
                  System.out.println("구매완료");
                } else {
                  System.out.println("오류");
                }

              } else {
                System.out.println("구매실패");
              }
            }
            break;

          // 2.장바구니삭제
          case 2:

            // 삭제할 상품 번호 입력
            System.out.print("삭제할 장바구니 삭제 번호: ");
            idx = scan.nextInt();

            // 장바구니번호보다 큰번호 입력시 탈출
            if (idx >= cList.size()) {
              break;
            }
            // 해당 상품 불러오기
            pdto = pdao.recievePdto(cList.get(idx - 1).getcName());

            // 해당번호 상품 장바구니 삭제
            int deleteResult = cdao.deleteList(loginInfo.getmId(), pdto.getPdCode());

            // 장바구니 삭제
            if (deleteResult == 1) {
              System.out.println("삭제완료");
            } else {
              System.out.println("삭제실패");
            }
            break;

          case 0:
            run = false;
            break;

        }

        // 장바구니 최신화
        cList = cdao.cartList(loginInfo.getmId());

      } else {
        run = false;
        System.out.println("상품이 없습니다.");
      }
    }


  }

  /*** 6.내정보 ***/
  public void showMyInfo() {
    boolean run = true;
    while (run) {
      System.out.println("=============================");
      System.out.println("1.내정보 보기 | 2.구매취소 | 0.뒤로가기");
      System.out.println("=============================");
      System.out.print("메뉴선택: ");
      int selectMenu = scan.nextInt();

      switch (selectMenu) {
        // 뒤로가기
        case 0:
          run = false;
          break;

        // 내정보 보기
        case 1:
          System.out.println(loginInfo.toString());
          break;

        // 구매취소
        case 2:

          // 구매목록 리스트 받기
          ArrayList<OrderListDto> list = odao.showMyList(loginInfo.getmId());

          // 구매목록이 있으면
          if (list.size() != 0) {
            // 구매목록 출력
            for (int i = 0; i < list.size(); i++) {
              ProductDto pdto = pdao.searchPdto(list.get(i).getOdPdCode());
              System.out.println("[" + (i + 1) + "] [" + list.get(i).getOdDate() + "] ["
                  + pdto.getPdName() + "] [" + list.get(i).getOdAmount() + "] ["
                  + pdto.getPdPrice() * list.get(i).getOdAmount() + "]");
            }

            // 취소할 상품번호 입력
            System.out.print("구매취소할 번호: ");
            int idx = scan.nextInt();

            // 취소할 구매리스트 정보 가져오기
            OrderListDto odto = list.get(idx - 1);
            ProductDto pdto = pdao.searchPdto(odto.getOdPdCode());

            int pay = odto.getOdAmount() * pdto.getPdPrice();

            // 구매리스트 삭제
            int deleteResult = odao.deleteList(odto.getOdNum());

            // 삭제 성공시
            if (deleteResult == 1) {

              // MEMBERS - UPDATE
              loginInfo.setmCash(loginInfo.getmCash() + pay);
              loginInfo.setmTotal(loginInfo.getmTotal() - pay);
              loginInfo.setmGrade(changeGrade(loginInfo.getmTotal()));

              int mUpdateResult = mdao.updateMyInfo(loginInfo);

              // loginInfo 최신화
              mdao.callMyInfo(loginInfo.getmId());

              // PRODUCT - UPDATE
              int pUpdateResult =
                  pdao.pdUpdate(pdto.getPdName(), 2, pdto.getPdAmount() + odto.getOdAmount());


              if (mUpdateResult == 1 && pUpdateResult == 1) {
                System.out.println("구매취소 완료");
              } else {
                System.out.println("구매취소 실패");
              }
            }

          } else {
            System.out.println("구매하신 상품이 없습니다.");
          }

      }

    }


  }

}
