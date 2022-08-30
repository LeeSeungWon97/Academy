package day18;

public class StudentMain {

  public static void main(String[] args) {
  
    
    Student stu01 = new Student();
    stu01.name = "양기두";
    stu01.tel = "010-4520-3675";
    
    System.out.println();
    
    Student stu02 = new Student();
    
    stu02.name = "황인철";
    stu02.tel = "010-1111-1111";

    Student.academy = "인천일보 아카데미";
    
    System.out.println("stu01 정보");
    System.out.println("교육원: " + Student.academy);
    System.out.println("이름: " + stu01.name);
    System.out.println("전화번호: " + stu01.tel);
    
    System.out.println();
    
    System.out.println("stu02 정보");
    System.out.println("교육원: " + Student.academy);
    System.out.println("이름: " + stu02.name);
    System.out.println("전화번호: " + stu02.tel);

    
    
  }

}
