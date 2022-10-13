/***** while문 중지 시키는 방법 *****/

package day06;

public class While_02 {

	public static void main(String[] args) {

		// 1. false가 나올 수 있는 조건문을 반복 조건에 직접 작성
		int i = 1;

		while (i <= 10) {
			System.out.println("true일 경우 실행: " + i);
			i++;
		}

		// 구분선
		System.out.print("\n");

		// 2. break 사용
		i = 1;
		while (true) {
			System.out.println("true일 경우 실행: " + i);
			i++;
			if (i > 10) {
				break;
			}
		}

		// 구분선
		System.out.print("\n");

		// 3. boolean type의 변수 활용.
		i = 1;
		boolean run = true;

		while (run) {
			System.out.println("true일 경우 실행: " + i);
			i++;

			if (i > 10) {
				run = false;
			}
		}
	}

}
