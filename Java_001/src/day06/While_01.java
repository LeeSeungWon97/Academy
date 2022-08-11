/***** while *****/
// 조건이 true일 경우 계속 실행. 반복조건이 false가 되기 전까지 계속 실행.
// 횟수 제한없이 원하는 조건을 만족할 때 까지 반복해야 할 때 많이 사용.

/*
 * 
 <기본 구조>
 while(반복조건){
 	실행문
 }
 
 */

package day06;

public class While_01 {

	public static void main(String[] args) {
		// 1. 1 ~ 10까지 출력

		int i = 1;
		System.out.println("Start");

		while (i <= 10) {
			System.out.println(i);
			i++;
		}

		System.out.println("Finish");

		// 구분선
		System.out.print("\n");

		// 2. 1부터 n까지의 총합이 100을 넘어가는 최소 값 n 구하기.
		int number = 1;
		int sum = 0;

		while (sum <= 100) {
			sum += number;
			number++;
		}

		System.out.println(sum + "은 1부터 " + (number - 1) + "까지 더한 총합입니다.");
	}

}
