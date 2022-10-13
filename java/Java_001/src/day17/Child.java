package day17;


// Child Class는 Parent Class의 상속을 받음

public class Child extends Parent {

  public void childMethod() {
    parentMethod();
    System.out.println("자식클래스의 childMethod() 호출");
  }
}
