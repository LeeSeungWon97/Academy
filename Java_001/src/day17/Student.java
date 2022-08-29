package day17;

public class Student extends People {

  // String name, String tel, int age

  String stuNum; // 학번
  String major; // 전공

  
  // 부모클래스의 객체가 먼저 만들어지고
  // 자식클래스에 해당하는 객체가 추가되는 형식.
  
  // 생성자를 따로 만들지 않으면 기본생성자가 생성
  // 부모클래스의 기본생성자가 없으면 오류 발생
  // 부모클래스의 생성자와 동일한 필드를 사용한 생성자는 사용 가능.
  public Student() {

  }


  /*
  public Student(String name) {
      this.name = name;
  }
  */
  
  
  // 생성자도 상속을 받아서 사용 가능.
  public Student(String name) {
    super(name);
  }


  @Override
  public String toString() {
    return "Student[name=" + name + ", tel=" + tel + ", age=" + age + "] [stuNum=" + stuNum
        + ", major=" + major + "]";
  }


}
