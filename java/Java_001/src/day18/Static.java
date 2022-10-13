package day18;

public class Static {
  
  // 기본필드 - 객체끼리 공유하지 않음.
  int num1;

  String str1;

  // static 필드 - 객체끼리 공유.
  static int number1;

  public int getNum1() {
    return num1;
  }

  public void setNum1(int num1) {
    this.num1 = num1;
  }

  public String getStr1() {
    return str1;
  }

  public void setStr1(String str1) {
    this.str1 = str1;
  }



}
