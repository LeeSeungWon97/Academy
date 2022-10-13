package day18;

public class Student {

  static String academy = "ICIA"; // 교육원
  String name; // 이름
  String tel; // 전화번호

  // static 메소드
  public static void showInfo01() {
    System.out.println("정보출력01");
    System.out.println("교육원: " + academy);
    // error: static 메소드에서는 static 타입의 필드만 사용 가능.
//    System.out.println("이름: " + name);  
  }


  // 기본 메소드
  public void showInfo02() {
    System.out.println("정보출력02");
    System.out.println("교육원: " + academy);
    System.out.println("이름: " + name);
  }
}
