package project_webShop;

import java.util.Scanner;

public class Manager {

  MemberDao memdao = new MemberDao();
  ProductDao pdao = new ProductDao();

  Scanner scan = new Scanner(System.in);

  MemberDto currentMem = new MemberDto();

  // 초기화면 출력
  public int initialMenu() {

    System.out.println("============================");
    System.out.println("1.로그인 | 2.회원가입 | 0.종료");
    System.out.println("============================");
    System.out.print("메뉴선택 >> ");
    return scan.nextInt();
  }

  // 로그인 후 메뉴
  public int loginMenu(boolean adminCheck) {
    System.out.println("============================");
    if (!adminCheck) {
      System.out.println("1.계좌관리 | 2.상품목록 | 3.상품검색 | 4.주문하기 | 5.장바구니 | 6.내정보 | 9.로그아웃 | 0.종료");
    } else {
      System.out.println("1.상품등록 | 2.상품수정 | 3.회원관리 | 9.로그아웃 | 0.종료");
    }
    System.out.println("============================");
    return scan.nextInt();
  }

  // 로그인 메소드
  public boolean login() {

    boolean check = false;

    System.out.print("아이디: ");
    String id = scan.next();

    System.out.print("비밀번호: ");
    String pw = scan.next();

    check = memdao.loginCheck(id, pw);
    if (check) {
      currentMem = memdao.login(id, pw);
    }

    return check;
  }

  // 로그인회원 정보
  public MemberDto loginInfo() {

    return currentMem;
  }

  // 회원가입 메소드
  public void memberJoin() {
    System.out.println("회원가입");

    boolean run = true;
    while (run) {
      // 아이디 입력
      boolean idCheck = false;
      System.out.print("아이디: ");
      String id = scan.next();

      // 아이디 중복확인
      idCheck = memdao.idCheck(id);

      // 중복된 아이디가 없는 경우 회원가입 실행
      if (!idCheck) {
        MemberDto memDto = new MemberDto();

        memDto.setmId(id);

        System.out.print("비밀번호: ");
        String pw = scan.next();
        memDto.setmPw(pw);

        System.out.print("이름: ");
        String name = scan.next();
        memDto.setmName(name);

        System.out.print("생년월일: ");
        String brith = scan.next();
        memDto.setmBirth(brith);

        System.out.print("성별(1:남, 2: 여):");
        int gender = scan.nextInt();
        memDto.setmGender(gender);

        System.out.print("이메일: ");
        String email = scan.next();
        memDto.setmEmail(email);

        int insertResult = memdao.memberJoin(memDto);

        if (insertResult == 1) {
          System.out.println("회원가입 완료");
          run = false;
        } else {
          System.out.println("회원가입 실패");
        }
      } else {
        System.out.println("이미 사용중인 아이디 입니다.");
      }
    }
  }

  // 상품 추가 메소드
  public void addProduct() {
    ProductDto pDto = new ProductDto();

    String pCode = pCodeMenu();
    pDto.setPdCode(pCode);

    System.out.print("상품명: ");
    pDto.setPdName(scan.next());

    System.out.print("상품가격: ");
    pDto.setPdPrice(scan.nextInt());

    System.out.print("상품수량: ");
    pDto.setPdAmount(scan.nextInt());

    pDto.setPdType(pCode);
    
    pdao.addList(pDto);

  }

  // 상품추가 - 코드입력
  private String pCodeMenu() {
    System.out.println("==================");
    System.out.println("1. PO | 2. PT | 3. PP | 4. PS");
    System.out.println("==================");

    boolean run = true;
    String pdCode = null;
    String pdType = null;
    int pdCnt = 0;
    while (run) {
      System.out.print("상품코드(번호): ");
      int selectNum = scan.nextInt();
      switch (selectNum) {
        case 1:
          pdType = "아우터";
          pdCnt = pdao.setCodeNum(pdType);
          pdCode = "PO" + pdCnt;
          run = false;
          break;
        case 2:
          pdType = "상의";
          pdCnt = pdao.setCodeNum(pdType);
          pdCode = "PT" + pdCnt;
          run = false;
          break;
        case 3:
          pdType = "하의";
          pdCnt = pdao.setCodeNum(pdType);
          pdCode = "PP" + pdCnt;
          run = false;
          break;
        case 4:
          pdType = "신발";
          pdCnt = pdao.setCodeNum(pdType);
          pdCode = "PS" + pdCnt;
          run = false;
          break;
        default:
          System.out.println("다시 입력해주세요");
      }

    }

    return pdCode;
  }
}
