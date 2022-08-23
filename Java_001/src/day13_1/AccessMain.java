/* 
 
 < 같은 패키지 & 상속 X >
 - public: 접근 가능
 - protected: 접근 가능
 - default: 접근 가능
 - private: 접근 불가능
 
 */

package day13_1;


public class AccessMain {

	public static void main(String[] args) {
		
		Access access = new Access();
		
//		public: 접근 가능.
		access.publicValue = 10;
		
//		private: 접근 불가능.
		// access.privateVaule = 20; 
		
		// publicMethod() 호출
		access.publicMethod();
		
		// privateMethod() 호출
		// access.privateMethod(); 
		
//		protected: 같은 패키지이기 떄문에 접근 가능.
		access.protectedValue = "protected";
		System.out.println(access.protectedValue);
		
//		default: 같은 패키지이기 떄문에 접근 가능.
		access.defaultValue = "default";
		System.out.println(access.defaultValue);
		
		System.out.println("=====================");
		
		
//		access2, access3: 같은 클래스를 사용하여 서로 다른 객체 생성.
		
//		Access2 access2 = new Access2();
//		access2.intValue = 100;
//		System.out.println(access2.intValue);
//		
//		Access2 access3 = new Access2();
//		System.out.println(access3.intValue);
		
		/* Singleton 패턴 */
		
		Access2 acc = Access2.getInstance();
		System.out.println(acc.intValue);
		acc.intValue = 1000;
		System.out.println(acc.intValue);
		
		Access2 acc2 = Access2.getInstance();
		System.out.println(acc2.intValue);
		acc2.intValue = 200;
		System.out.println(acc.intValue);
		
		
	}

}