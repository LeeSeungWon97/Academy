/*
	 <접근제한자>
	 
	 1. public
	 	- 적용 대상: 클래스 / 필드 / 생성자 / 메소드
	 	- 접근 가능 대상: 모든 패키지, 모든 클래스
	 	- 접근 불가 대상: 없음.
	 	
	 2. protected
	 	- 적용 대상: 필드 / 생성자 / 메소드 
	 	- 접근 가능 대상: 같은 패키지의 클래스 / 자식 클래스 
	 	- 접근 불가 대상: 자식 클래스가 아닌 다른 패키지의 클래스
	 	
	 3. default
	 	- 적용 대상: 클래스 / 필드 / 생성자 / 메소드
	 	- 접근 가능 대상: 같은 패키지의 클래스
	 	- 접근 불가 대상: 다른 패키지의 클래스
	 	- 접근 제한자가 생략되어있는 경우 기본값으로 설정.
	 	
	 4. private
	 	- 적용 대상: 필드 / 생성자 / 메소드
	 	- 접근 가능 대상: 클래스 내부
	 	- 접근 불가 대상: 클래스 외부
	 	- 데이터를 저장하는 필드는 주로 private를 사용.
	 	 
 */

package day13_1;


public class Access {
	
//	< 필드 >
	
//	1. public
	public int publicValue;
//	2. private
	private int privateValue;
//	3. protected
	protected String protectedValue;
//	4. default
	String defaultValue;

//	< 생성자 >
	public Access() {

	}

//	< 메소드 >
	public void publicMethod() {
		System.out.println("publicMethod() 호출");
	}
	
	private void privateMethod() {
		System.out.println("privateMethod() 호출");
	}
}
