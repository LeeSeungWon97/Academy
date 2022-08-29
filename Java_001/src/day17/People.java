package day17;

public class People {
  String name; // 나이
  String tel; // 전화번호
  int age; // 나이



  public People() {

  }


  public People(String name) {
    this.name = name;
  }


  @Override
  public String toString() {
    return "People [name=" + name + ", tel=" + tel + ", age=" + age + "]";
  }
}
