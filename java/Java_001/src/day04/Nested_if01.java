/*
 * 학점 기준: 95 ~ 100: A+ 
 * 90 ~ 94: A0 
 * 85 ~ 89: B+ 
 * 80 ~ 84: B0
 */

package day04;

import java.util.Scanner;

public class Nested_if01 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("점수입력>>");
		
		int score = scan.nextInt();
		scan.close();

		if (score >= 90) {
			// score가 95 ~ 100 사이인지 확인.
			if (score >= 95) {
				
				System.out.println("A+ 학점 입니다.");
			} 
			else {
				System.out.println("A0 학점 입니다.");
			}
			
		} 
		else if (score >= 80) {
			
			if (score >= 85) {
				System.out.println("B+ 학점 입니다.");
			}
			else {
				System.out.println("B0 학점 입니다.");
			}
			
		}
		else if (score >= 70) {
			
			if (score >= 75) {
				System.out.println("C+ 학점 입니다.");
			}
			else {
				System.out.println("C0 학점 입니다.");
			}
			
		}
		else {
			System.out.println("재수강 대상입니다.");
		}

	}

}
