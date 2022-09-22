/*
 
 <Class 구성 멤버>
 
 1. 필드(field)
 	  
 2. 생성자(Constructor)
 
 3. 메소드(Method)
 
*/

package day11_2;

public class Class {

	/*
	 1. 필드(field)
	 	- 데이터를 저장하는 공간.
	  	- 메소드의 변수같은 역할.
	  	- 선언 시 메소드의 변수와 색상이 다름.
	*/

	// 타입 필드 [= 초기값]
	int num; // int type의 data를 저장할 수 있는 "num"이라는 필드 생성.
	String str1; // String type의 data 저장 가능.
	String day = "금요일"; // 필드에 데이터를 저장하면서 선언 가능.

	/*
	 2. 생성자(Constructor)
	 	- 객체를 만들 때 따라야 하는 규칙. 초기화 역할 담당.
	 	- 생성자의 이름은 클래스의 이름과 동일.
	 	- 아무것도 없을 때 기본생성자를 자동으로 만듬.
	 	- 매개변수가 있는 생성자가 있으면 기본생성자를 자동으로 만들지 않음.
	 	- 매개변수가 있는 생성자를 사용할 때 매개변수의 순서를 확인.
	 	- 생성자의 이름, 매개변수의 개수, 매개변수의 타입이 모두 같으면 더이상 생성 불가.
	*/

	// 기본생성자
	public Class() {

	}

	// 매개변수가 1개 있는 생성자
	public Class(String str1) {
		this.str1 = str1;
	}

}
