package jdbc_Order;

import java.util.ArrayList;
import java.util.Scanner;

public class OrderManager {

  private Scanner scan = new Scanner(System.in);
  private MemberDao mdao = new MemberDao();
  private ProductDao pdao = new ProductDao();
  private String loginId = null;

  public String getLoginId() {
    return loginId;
  }

  // 메뉴 출력 메소드
  public int showMenu() {
    if (loginId == null) {
      System.out.println("\n============================");
      System.out.println("[1]회원가입 | [2]로그인 | [0]종료");
      System.out.println("============================");
    } else {
      System.out.println("\n[로그인한 아이디: " + loginId + "]");
      System.out.println("\n=======================================================");
      System.out.println("[1]내정보확인 | [2]로그아웃 | [3]상품주문 | [4]주문내역 | [0]종료");
      System.out.println("=======================================================");
    }
    System.out.print("메뉴선택>>");

    return scan.nextInt();
  }

  // 회원가입 기능 메소드 - MEMBERS 테이블에 INSERT
  public void memberJoin() {
    System.out.println("[1]회원가입");

    // 아이디 ~ 이메일 데이터 수집
    System.out.print("아이디 입력 >> ");
    String mid = scan.next();

    System.out.print("비밀번호 입력 >> ");
    String mpw = scan.next();

    System.out.print("이름 입력 >> ");
    String mname = scan.next();

    System.out.print("성별 입력 >> ");
    int mgender = scan.nextInt();

    System.out.print("생년월일 입력(YYYY-MM-DD) >> ");
    String mbirth = scan.next();

    System.out.print("이메일 입력 >> ");
    String memail = scan.next();

    MemberDto member = new MemberDto();

    member.setMid(mid);
    member.setMpw(mpw);
    member.setMname(mname);
    member.setMgender(mgender);
    member.setMbirth(mbirth);
    member.setMemail(memail);

    // DAO 회원가입 메소드 호출 >> insert문 실행
    int insertResult = mdao.insertMemberJoin(member);
    if (insertResult > 0) {
      System.out.println("회원가입 성공");
    } else {
      System.out.println("회원가입 실패");
    }
  }


  // 로그인 기능 메소드
  public void memberLogin() {
    System.out.println("[2]로그인");
    // 1. 아이디, 비밀번호 입력
    System.out.print("아이디 >> ");
    String inputId = scan.next();
    System.out.print("비밀번호 >> ");
    String inputPw = scan.next();

    // 2. 아이디, 비밀번호 일치여부 확인
    MemberDto loginMember = mdao.selectMemberLogin(inputId, inputPw);

    // 3. 로그인 처리
    if (loginMember != null) {
      loginId = loginMember.getMid();
      System.out.println("로그인 성공");
    } else {
      System.out.println("아이디 / 비밀번호가 일치하지 않습니다.");
    }

  }

  // 로그아웃 기능 메소드
  public void memberLogout() {
    System.out.println("[2]로그아웃");
    loginId = null;
    System.out.println("로그아웃 완료");
  }

  // 내정보확인 기능 메소드
  public void memberInfo() {
    System.out.println("[1]내정보확인");

    MemberDto memberInfo = mdao.selectMemberInfo(loginId);

    System.out.println("[아이디]" + memberInfo.getMid());
    System.out.println("[비밀번호]" + memberInfo.getMpw());
    System.out.println("[이름]" + memberInfo.getMname());
    System.out.println("[성별]" + memberInfo.getMgender());
    System.out.println("[생년월일]" + memberInfo.getMbirth());
    System.out.println("[이메일]" + memberInfo.getMemail());


  }

  // 상품주문 기능 메소드
  public void productOrder() {
    System.out.println("[3]상품주문");
    System.out.println("\n--------------------[상품목록]--------------------");

    // 1. 상품목록 출력 - PRODUCT 테이블
    ArrayList<ProductDto> productList = pdao.selectProductList();

    if (productList.size() == 0) {
      System.out.println("등록된 상품이 없습니다.");
      return;
    }

    for (int i = 0; i < productList.size(); i++) {
      System.out.print("[" + i + "]" + productList.get(i).getPdName());
      System.out.println(" " + productList.get(i).getPdPrice() + "원");
    }

    // 2. 주문할 상품번호 입력
    System.out.print("\n상품선택 >> ");
    int selectProduct = scan.nextInt();

    if (selectProduct >= 0 && selectProduct < productList.size()) {
      System.out.println("[" + productList.get(selectProduct).getPdName() + " "
          + productList.get(selectProduct).getPdPrice() + "원] 선택");
      System.out.print("주문수량 >> ");
      int odqty = scan.nextInt();


      // 3. 주문번호 생성

      // (1) ORDERLIST 테이블의 주문번호(ODNUM) 컬럼의 최대값 조회
      int maxOrderNum = pdao.selectMaxOdnum();
      // (2) 새 주문번호 생성: 최대값 + 1
      int odnum = maxOrderNum + 1;

      String odmid = loginId;
      String odpdcode = productList.get(selectProduct).getPdCode();

      // 4. ORDERLIST 테이블에 INSERT
      int insertResult = pdao.insertOrder(odnum, odmid, odpdcode, odqty);

      if (insertResult > 0) {
        System.out.println("\n주문 성공");
      } else {
        System.out.println("\n주문 실패");
      }


    }
  }

  // 주문내역 조회 기능 메소드
  public void myOrderList() {
    System.out.println("[4]주문내역");
    ArrayList<OrderListDto> orderList = pdao.selectOrderList(loginId);

    if (orderList.size() == 0) {
      System.out.println("주문내역이 없습니다.");
      return;
    }

    for (int i = 0; i < orderList.size(); i++) {
      System.out.print("\n[" + i + "]");
      System.out.print(" [주문자]" + orderList.get(i).getOdmid());
      System.out.print(" [주문 날짜]" + orderList.get(i).getOddate());
      System.out.println(" [주문 수량]" + orderList.get(i).getOdqty());
    }

  }



}
