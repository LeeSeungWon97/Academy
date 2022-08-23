/*
  
 @ 이런게 있다는 것만 알고 넘어가기
 
 << Singleton 패턴 >>
 - 어떤 클래스가 최초 한번만 메모리를 할당.
 - 그 메모리에 객체를 만들어 사용하는 디자인 패턴.
 - 한번의 객체 생성으로 재사용이 가능.
 	> 메모리 낭비를 방지
 - 전역성을 띄기 때문에 다른 객체와 공유하기 용이.
 
 <문제점>
 - 사이드 이팩트 발생 확률이 생긴다.
 - 멀티쓰래드 환경에서 동기화 처리 문제가 생긴다.
 
 */
package day13_1;

public class Access2 {
	
	int intValue;
	
	private static Access2 access = new Access2();
	
	private Access2() {
		
	}
	
	public static Access2 getInstance() {
		return access;
	}
	
}
