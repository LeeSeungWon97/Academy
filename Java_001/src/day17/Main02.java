package day17;

public class Main02 {

  public static void main(String[] args) {
    Parent02 parent = new Parent02();
    
    parent.showInfo();
    parent.printField();
    
    System.out.println();
    
    Child02 child = new Child02();
    child.showInfo();

    System.out.println();
    
    child.testMethod();
    
    System.out.println();
    
    child.printField();
  }

}
