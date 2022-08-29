package day17;

public class Main03 {

  public static void main(String[] args) {
    
    People people01 = new People();
    people01.name = "인천";
    people01.tel = "010-1111-1111";
    people01.age = 20;
    
    System.out.println(people01);
    
    People people02 = new People("일보");
    people02.tel = "010-2222-2222";
    people02.age = 21;
    System.out.println(people02);
    
    System.out.println();
    
    Student student01 = new Student();
    student01.name = "아카";
    student01.tel = "010-1234-1234";
    student01.age = 22;
    student01.stuNum = "201600330";
    student01.major = "JAVA";
    System.out.println(student01);
    
    System.out.println();
    Student student02 = new Student("데미");
    student02.tel = "010-1234-5678";
    student02.age = 23;
    student02.stuNum = "111111111";
    student02.major = "Oracle";
    System.out.println(student02);
  }

}
