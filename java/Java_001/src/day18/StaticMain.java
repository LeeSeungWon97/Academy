/* 
  << static >>
  - 정적 멤버(정적 필드, 정적 메소드)
    >> 객체에 소속되어있는 것이 아닌 클래스에 고정되어 있는 멤버.
    >> 클래스의 로딩이 끝나는 즉시 사용가능.
    >> Heap영역이 아닌 Static영역에 할당.
      >> 모든 객체가 메모리를 공유.
      >> 프로그램 종료시까지 메모리가 할당된 상태 유지.
    >> 접근방법: 객체가 아닌 클래스를 통한 접근이 정석. (객체를 통해 접근이 가능하긴 함.)

 
  << final >>
  - 변수
    >> 변수를 수정할 수 없다는 의미
      >> 초기화 값이 필수
    >> 수정할 수 없다는 의미로 변수명을 모두 대문자로 작성  
    
  - 메소드
    >> override를 제한
      >> 상속받은 클래스에서 해당 메소드를 수정해서 사용 불가.
  
  - 클래스
    >> 상속 불가 클래스로 변경
    
 */



package day18;

public class StaticMain {

  public static void main(String[] args) {
    
    Static ex01 = new Static();
    ex01.setNum1(100);
    ex01.setStr1("A");

    System.out.println("ex01.num1: " + ex01.getNum1());

    Static.number1 = 2000;
    System.out.println("ex01.number1: " + Static.number1);

    System.out.println();
    
    Static ex02 = new Static();

    System.out.println("ex02.num1: " + ex02.getNum1());
    
    System.out.println("ex02.number1: " + Static.number1);

    ex02.setNum1(200);
    ex02.setStr1("B");
    System.out.println("ex02.num1: " + ex02.getNum1());

    Static.number1 = 20;
    System.out.println();
    System.out.println("ex01.number1: " + Static.number1);
    System.out.println("ex02.number1: " + Static.number1);

  }

}
