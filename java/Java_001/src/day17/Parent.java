package day17;

public class Parent {


  public void parentMethod() {
    System.out.println("부모클래스의 parentMethod() 호출");
  }

  private void privateParentMethod() {
    System.out.println("부모클래스의 parentMethod() 호출");
  }


  String parentStr;

  public void setParentStr(String parentStr) {
    this.parentStr = parentStr;
  }


  private int parentInt;

  public int getParentInt() {
    return parentInt;
  }

  public void setParentInt(int parentInt) {
    this.parentInt = parentInt;
  }


}
