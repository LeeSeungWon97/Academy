/***** break *****/
// 자신이 포함된 가장 가까운 반복문을 벗어난다.

package day05;

public class For_Break {

	public static void main(String[] args) {

		// 1 ~ 10까지 출력
		for (int i = 1; i < 11; i++) {
			System.out.println("i = " + i);

		}

		// 구분선
		System.out.println("\n");

		// 조건: i = 5일때 중지.
		for (int i = 1; i < 11; i++) {
			System.out.println("i = " + i);

			if (i == 5) {
				break;
			}
		}

		// 구분선
		System.out.println("\n");

		// 조건: 짝수일 경우만 출력.
		for (int i = 1; i < 11; i++) {

			// 짝수: 숫자를 2로 나누었을 때 나머지 값은 0.
			if (i % 2 == 0) {
				System.out.println("i = " + i);
			}

		}

	}

}
