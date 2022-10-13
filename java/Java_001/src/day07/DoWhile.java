/***** do-while문 *****/

/*
 
 do{
 	반복조건이 true일 경우 실행
 } while(반복조건);
 
 */
  
/*
  
 <while vs do-while>
 - while: 조건을 먼저 확인하고 실행.
 - do-while: 먼저 실행문을 돌리고 조건 확인. 어떤 조건이든 최소한 1번은 실행.
 
 */

package day07;

public class DoWhile {

	public static void main(String[] args) {
		
		int num = 10;
		System.out.println("while문 실행");
		while(num <= 5) {
			System.out.println(num);
			num++;
		}
		System.out.println("while문 종료");

		// 구분선
		System.out.println();
		
		int num2 = 10;
		System.out.println("do-while문 실행");
		do {
			System.out.println(num2);
			num2++;
		} while(num2 <= 5);
		System.out.println("do-while문 종료");
	}

}
