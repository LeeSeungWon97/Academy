/***** continue *****/
// 반복문의 끝으로 이동하여 다음 반복문으로 넘어간다.
// break와 같이 반복문 전체를 벗어나지 않음.

package day05;

public class For_continue {

	public static void main(String[] args) {

		for (int i = 1; i < 11; i++) {

			if (i == 5) {
				continue; // i == 5일때 continue를 만나 System.out.println(5)가 실행 되지 않음.
			}

			System.out.println(i);

		}

		// 구분선
		System.out.println("\n");

		// 조건: 5이상의 숫자만 출력. continue를 사용.
		for (int i = 1; i <= 10; i++) {

			if (i < 5) {
				continue;
			}
			System.out.println(i);
		}
	}

}
