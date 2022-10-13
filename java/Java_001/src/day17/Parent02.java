package day17;

public class Parent02 {
  String strVal;
  int intVal;

  public void showInfo() {
    System.out.println("부모클래스의 showInfo() 실행");

    System.out.println("strVal: " + this.strVal);
    System.out.println("intVal: " + intVal);
  }

  public void testMethod() {
    System.out.println("부모클래스의 testMethod()");
  }

  // 모든 필드값 출력
  public void printField() {
    System.out.println("strVal: " + this.strVal);
    System.out.println("intVal: " + intVal);
  }
}
