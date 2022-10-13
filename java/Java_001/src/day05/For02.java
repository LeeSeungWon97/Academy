package day05;

public class For02 {

	public static void main(String[] args) {

		for (int i = 0; i <= 10; i++) {
			System.out.println("i = " + i);
		}
//		System.out.println("i = " + i);		// i는 for문에서 선언한 변수이기 때문에 for문에서 나오면 사용할 수 없음.

		System.out.println("\n");

		int j;

		System.out.println("for문 시작");

		for (j = 1; j <= 5; j++) {
			System.out.println("j = " + j);
		}

		System.out.println("for문 종료");

		// j는 main 블록 안에서 선언한 변수이기 때문에 for문에서 증감된 값을 그대로 사용 가능.
		System.out.println("j = " + j); // j = 6이 되어 for문을 빠져나왔기 때문에 "j = 6"이 출력 됨.
	}
}
