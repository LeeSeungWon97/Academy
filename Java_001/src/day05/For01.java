// for문 : 특정 횟수를 반복할 때 주로 사용.

/***** for문 기본 형식 *****/
/*
  
 for(초기화식; 조건식; 증감식) {
 	반복 실행 되는 부분
 }
 
 조건식 == true : 코드 실행 / false : 코드 실행x
 
 초기화식 / 조건식 / 증감식 을 잘 조절하여 반복 횟수를 제어 가능.
 
*/

package day05;

public class For01 {

	public static void main(String[] args) {
		System.out.println("for문 시작");
		System.out.println("========");

		for (int i = 0; i <= 3; i++) {
			System.out.println("반복실행코드 : " + i);
		}

		/***** for문 실행 순서 *****/
		// 1. 변수 i = 0 선언 :: 0 <= 4 (true)
		// 2. "반복실행코드 : 0" 출력
		// 3. i++ (i = 1)
		// 4. 1 <= 4(true)
		// 5. "반복실행코드 : 1" 출력
		// 6. i++ (i = 2)
		// .
		// .
		// .
		// 7. "반복실행코드 : 4" 출력
		// 8. i = 5
		// 9. 5 <= 4 (false)
		// 10. for문 탈출.

		System.out.println("========");
		System.out.println("for문 종료");

		// 구분선
		System.out.println("========");

		// 3 ~ 8 숫자를 출력
		for (int num = 3; num <= 8; num++) {
			System.out.println(num);
		}

	}
}
