package day05;

import java.util.Scanner;

public class For_input {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.println("시작 숫자입력>>");
		int startNum = scan.nextInt();

		System.out.println("마지막 숫자입력>>");
		int endNum = scan.nextInt();

		scan.close();

		for (int i = startNum; i <= endNum; i++) {
			System.out.println(i);
		}

	}

}
