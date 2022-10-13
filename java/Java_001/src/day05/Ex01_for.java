/*
 * 시작 숫자입력 >> 5
 * 마지막 숫자입력 >> 12
 * 제외할 x배수 입력 >> 3
 * 
 * 결과
 * 5, 7, 8, 10, 11
 */

package day05;

import java.util.Scanner;

public class Ex01_for {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.println("시작 숫자입력>>");
		int startNum = scan.nextInt();

		System.out.println("마지막 숫자입력>>");
		int endNum = scan.nextInt();

		System.out.println("제외할 x배수 입력>>");
		int excludeNum = scan.nextInt();

		scan.close();

		for (int i = startNum; i <= endNum; i++) {

			// continue 사용. //
			
			if (i % excludeNum == 0) {
				continue;
			}
			System.out.println(i);

			// != 사용. //
			
//			if (i % excludeNum != 0) {
//				System.out.println(i);
//			}
			
		}

	}

}
