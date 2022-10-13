package ex_test3;

import java.util.ArrayList;
import java.util.Scanner;

public class Manager {

  ArrayList<MemberInfo> member = new ArrayList<MemberInfo>();

  MemberInfo currentInfo = new MemberInfo();

  Scanner scan = new Scanner(System.in);

  // 메뉴출력 메소드
  public int showMenu(boolean loginFlag) {

    // 로그인X
    if (loginFlag == false) {
      System.out.println("\n1.회원가입 | 2.로그인 | 3.종료");
      System.out.print("메뉴선택 >> ");
      return scan.nextInt();
    } else {
      System.out.println("\n1.비밀번호수정 | 2.로그아웃 | 3.계정삭제");
      System.out.print("메뉴선택 >> ");
      return scan.nextInt();
    }

  }


  // 회원가입 메소드
  public void memberJoin() {
    MemberInfo mem = new MemberInfo();
    System.out.println("회원 가입");

    System.out.print("이름: ");
    String name = scan.next();


    boolean run = true;
    
    while (run) {
      System.out.print("id: ");
      String id = scan.next();

      // check == true: 회원가입 가능
      boolean check = idCheck(id);
      if (check == true) {
        mem.setmName(name);
        mem.setmId(id);
        System.out.println("사용가능한 아이디입니다.");
        run = false;
      } else {
        System.out.println("중복된 아이디입니다.");
      }
    }

    System.out.print("pw: ");
    String pw = scan.next();
    mem.setmPw(pw);
    
    member.add(mem);
    
    System.out.println("회원가입 완료");




  }

  // id 중복체크
  private boolean idCheck(String id) {
    boolean check = true;

    for (int i = 0; i < member.size(); i++) {
      if (member.get(i).getmId().equals(id)) {
        check = false;
      }
    }

    return check;
  }


  // 로그인 메소드
  public boolean login() {

    boolean loginFlag = false;

    System.out.print("id: ");
    String id = scan.next();

    System.out.print("pw: ");
    String pw = scan.next();

    // memberIdx == -1: 일치아이디 없음.
    int memberIdx = indexIdCheck(id);

    if (memberIdx != -1) {
      String loginName = member.get(memberIdx).getmName();
      String loginId = member.get(memberIdx).getmId();
      String loginPw = member.get(memberIdx).getmPw();

      if (id.equals(loginId) && pw.equals(loginPw)) {

        currentInfo.setmName(loginName);
        currentInfo.setmId(id);
        currentInfo.setmPw(pw);

        loginFlag = true;

        System.out.println("로그인 완료");
        System.out.println("\n" + loginName + "님 환영합니다.");
      } else {
        System.out.println("아이디 / 비밀번호가 잘못되었습니다.");
      }
    } else {
      System.out.println("아이디 / 비밀번호가 잘못되었습니다.");
    }

    return loginFlag;
  }


  // 회원 인덱스 불러오기
  private int indexIdCheck(String id) {
    int idx = -1;

    for (int i = 0; i < member.size(); i++) {
      if (member.get(i).getmId().equals(id)) {
        idx = i;
      }
    }
    return idx;
  }

  // 비밀번호 변경
  public void changePw() {
    System.out.print("현재 비밀번호: ");
    String pw = scan.next();

    int memberIdx = indexPwCheck(pw);

    if (memberIdx != -1) {
      System.out.print("바꾸는 비밀번호: ");
      String newPw = scan.next();

      member.get(memberIdx).setmPw(newPw);

      System.out.println("비밀번호 변경 완료");
    } else {
      System.out.println("비밀번호가 틀렸습니다.");
    }

  }

//회원 인덱스 불러오기
  private int indexPwCheck(String pw) {
    int idx = -1;

    for (int i = 0; i < member.size(); i++) {
      if (member.get(i).getmPw().equals(pw)) {
        idx = i;
      }
    }
    return idx;
  }


  // 로그아웃 메소드
  public boolean logOut() {
    currentInfo.setmName(null);
    currentInfo.setmId(null);
    currentInfo.setmPw(null);
    return false;
  }


  // 계정 삭제
  public boolean deleteInfo() {
    boolean loginFlag = true;

    System.out.print("정말 계정을 삭제하시겠습니까? (Y: 1, N: 2) >> ");
    int select = scan.nextInt();
    if (select == 1) {
      String id = currentInfo.getmId();
      int idx = indexIdCheck(id);
      member.remove(idx);
      System.out.println("계정삭제 완료");
      loginFlag = false;
    } else if (select == 2) {
      System.out.println("계정삭제 취소");
    }
    return loginFlag;
  }

}
