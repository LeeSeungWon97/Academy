package day17;

public class Main {

  public static void main(String[] args) {

    Parent parent = new Parent();

    // 부모 클래스는 자식 클래스의 필드/메소드를 사용할 수 없음.
    parent.parentMethod();


    System.out.println();

    Child child = new Child();

    // Child 클래스는 Parent 클래스를 상속받았기 때문에
    // 자식 클래스는 부모 클래스의 필드/메소드에 접근 가능.
    // 단 부모 클래스의 private 필드/메소드는 직접접근 불가.
    // getter & setter와 같은 메소드 등을 통해 간접적 접근은 가능.

    child.parentMethod();
    child.childMethod();

    child.setParentStr("자식클래스");
    System.out.println(child.parentStr);

    child.setParentInt(100);
    System.out.println(child.getParentInt());
  }

}
