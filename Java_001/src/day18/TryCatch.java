/*
   < try - catch >
   
   [ 형식 ]
   
   try{
     실행할 코드
    } catch(예외){
      처리코드
    {

 */


package day18;

public class TryCatch {

  public static void main(String[] args) {

    // try - catch: 예외처리

    int number = 10;
    int[] nums = new int[2];


    try {
      // 실행 할 코드


      System.out.println(number / 2);

      // 예외가 발생할 코드.
      System.out.println(number / 0); // ArithmeticException
      System.out.println(number / 5); // 예외가 발생한 순간 catch로 넘어가기 때문에 실행 X

      nums[3] = 10; // ArrayIndexOutOfBoundsException
    }

    // catch는 여러개를 만들 수 있음.
    catch (ArithmeticException e) {
      System.out.println("0으로 나눈 경우 예외 발생");
    }

    catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("배열의 인덱스 범위를 벗어난 경우 예외 발생");
    }

    catch (Exception e) { // Exception: 모든 예외
      // 예외가 발생하면 실행시켜줄 코드
      System.out.println("예외발생");
      System.out.println("catch 실행");
    }

    System.out.println(number + 10);

  }

}
