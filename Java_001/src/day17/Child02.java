package day17;

public class Child02 extends Parent02 {
  String childVal;

  // 재정의 (Override)
  // 상속을 받은 클래스에서 부모 클래스에 있는 메소드를 사용할 때 다시 정의를 내림.

  @Override
  public void showInfo() {
    // 부모 클래스의 showInfo()를 호출
    super.showInfo();


    System.out.println("자식 클래스에서 재정의한 showInfo() 실행");

    if (strVal == null) {
      System.out.println("strVal: 널 입니다.");
    } else {
      System.out.println("strVal: " + strVal + "입니다.");
    }

    if (intVal == 0) {
      System.out.println("intVal: 영 입니다.");
    } else {
      System.out.println("intVal: " + intVal + "입니다.");
    }
  }

  @Override
  public void testMethod() {
    super.testMethod();
  }


  @Override
  public void printField() {
    super.printField();
    System.out.println("childVal: " + childVal);
  }
}
