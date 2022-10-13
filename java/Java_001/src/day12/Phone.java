package day12;

public class Phone {

	/*
	 1. 필드(field)
	 	- 데이터를 저장하는 공간.
	  	- 메소드의 변수같은 역할.
	  	- 선언 시 메소드의 변수와 색상이 다름.
	*/

	String color; // 색상
	String telecom; // 통신사
	int storage; // 용량

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
	public Phone() {

	}

	// 매개변수가 1인 생성자
	public Phone(String telecom) {
		super(); // 부모 클래스의 기본생성자 호출.

		// this: 이 내용을 호출한 객체 자신
		this.telecom = telecom;
	}

	public Phone(int storage) {
		super();
		this.storage = storage;
	}

	/*
	 3. 메소드(Method)
	 	- 특정한 기능을 정의하는 블럭
	 	- 메소드가 호출되면 정의된 기능을 수행
	 	- 리턴값이 있는 메소드
	 	- 리턴값이 없는 메소드
	*/

	
	// 리턴값이 없는 메소드
	public void printNumber1() {
		System.out.println("printNumber1() 호출");
	}
	
	// 리턴값이 있는 메소드
	// 호출이 되었을 때 기능을 수행하고 호출된 위치에 int 타입 데이터를 되돌려 줍니다.
	public int printNumber2() {
		System.out.println("printNumber2() 호출");
		return 1;	
	}
	
	public String printStr1() {
		System.out.println("printStr1() 호출");
		String re = "ABCD";
		return re;
	}

	// phone 정보를 출력하는 기능
	public void showInfo( /*매개변수*/ ) {
		if (this.color == null) {
			System.out.println("색상값이 저장되지 않았습니다.");
		} else {
			System.out.println("this.색상은 " + this.color + "입니다.");
		}

		if (this.telecom == null) {
			System.out.println("통신사 값이 저장되지 않았습니다.");
		} else {
			System.out.println("통신사는 " + this.telecom + "입니다.");
		}

		if (this.storage == 0) {
			System.out.println("용량 값이 저장되지 않았습니다.");
		} else {
			System.out.println("용량은 " + this.storage + "입니다.");
		}
	}
}
