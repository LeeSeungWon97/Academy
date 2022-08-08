/***** Else if문 연습 *****/

/*
 * 이번달 출석일수 : 사용자로 부터 입력받아서 사용
 * 출석일수가 20일 이상이면 "훈련지원금 20만원을 받는다." 출력
 * 출석일수가 20일 미만 19일 이상이면 "훈련지원금 19만원을 받는다." 출력
 * 출석일수가 19일 미만 18일 이상이면 "훈련지원금 18만원을 받는다." 출력
 * 출석일수가 18일 미만이면 "훈련지원금을 받지못한다." 출력
 */


package day03;

//Scanner Class 호출
import java.util.Scanner;


public class Ex01_elseif {

	public static void main(String[] args) {
		
		// 출석일수 입력값 받기.
		Scanner scan = new Scanner(System.in);
		
		System.out.println("이번달 출석일수 : ");
		
		int attendance = scan.nextInt();
		scan.close();
		
		// 출석일수에 따른 훈련지원금 금액
		if(attendance >= 20) {
			System.out.println("훈련지원금 20만원을 받는다.");
		} else if(attendance >= 19) {
			System.out.println("훈련지원금 19만원을 받는다.");
		} else if(attendance >= 18) {
			System.out.println("훈련지원금 18만원을 받는다.");
		} else {
			System.out.println("훈련지원금을 받지 못한다.");
		}
		

	}

}
