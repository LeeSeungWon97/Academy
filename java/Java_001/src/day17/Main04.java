package day17;

public class Main04 {

  public static void main(String[] args) {

    People02 people = new People02("인천", "010-1111-1111", 20);
    System.out.println(people.name + ", " + people.tel + ", " + people.age);


    Student02 student = new Student02("일보", "010-2222-2222", 21, "2022", "JAVA");
    System.out.println(student.name + ", " + student.tel + ", " + student.age + ", "
        + student.stuNum + ", " + student.major);
    
    
    Student02 student2 = new Student02();
    
    student2.name = "데미";
    student2.tel = "010-3333-4444";
    student2.age = 23;
    student2.stuNum = "2016000000";
    student2.major = "Oracle";
    
    
  }

}
