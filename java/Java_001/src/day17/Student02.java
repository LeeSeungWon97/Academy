package day17;

public class Student02 extends People02 {
  String stuNum; // 학번
  String major; // 전공
  
 public Student02() {
   
 }
  
  
  public Student02(String name , String tel, int age, String stuNum, String major) {
    super(name,tel,age);
    this.stuNum = stuNum;
    this.major = major;
  }
  
}

