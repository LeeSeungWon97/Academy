package ex_test2;

import java.util.ArrayList;
import java.util.Scanner;

public class Manager {

  Scanner scan = new Scanner(System.in);
  ArrayList<MemberInfo> memberlist = new ArrayList<MemberInfo>();

  // 메뉴 출력
  public int showMenu() {
    System.out.println("================================");
    System.out.println("회원관리");
    System.out.println("1.등록 | 2.리스트 | 3. 종료: ");
    System.out.println("================================");
    System.out.print("메뉴선택 >> ");
    int selectMenu = scan.nextInt();
    return selectMenu;
  }

  // 회원등록 메소드
  public void memberJoin() {
    MemberInfo member = new MemberInfo();

    System.out.print("이름을 입력하세요: ");
    String name = scan.next();
    
    System.out.print("나이를 입력하세요: ");
    int age = scan.nextInt();
    
    boolean check = checkName(name, age);

    // 중복된 회원정보가 아니면 회원 등록
    if (check == true) {
      member.setName(name);
      member.setAge(age);

      memberlist.add(member);
    } else { // 중복된 회원정보가 있으면 회원등록 X
      System.out.println("이미 등록된 회원입니다.");
    }
  }

  // 회원리스트 출력 메소드
  public void showList() {
    System.out.println("이름\t\t나이");
    System.out.println("-------------------------");

    for (int i = 0; i < memberlist.size(); i++) {
      System.out.print(memberlist.get(i).getName() + "\t\t");
      System.out.println(memberlist.get(i).getAge());
    }

  }

  // 중복체크 메소드
  public boolean checkName(String mname, int mage) {

    boolean check = true;

    for (int i = 0; i < memberlist.size(); i++) {
      String name = memberlist.get(i).getName();
      int age = memberlist.get(i).getAge();
      
      if (name.equals(mname) && age == mage) {
        check = false;
      }
      
    }

    return check;
  }

}
