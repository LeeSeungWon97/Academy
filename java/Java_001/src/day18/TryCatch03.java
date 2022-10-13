package day18;

public class TryCatch03 {

  public static void main(String[] args) {

    String[] strList = new String[5];

    strList[0] = "A1";
    strList[1] = "B12";
//    strList[2] = "C123";
    strList[3] = "D1234";
    strList[4] = "E12345";

    for (int i = 0; i < strList.length; i++) {
      
      try {
        System.out.println(strList[i].length());
      } catch (NullPointerException e) {
          System.out.println("NULL");
      }
      
    }
  }

}
