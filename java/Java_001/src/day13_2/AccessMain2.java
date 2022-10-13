/* 
 
 < 다른 패키지 & 상속 X >
 - public: 접근 가능
 - protected: 접근 불가능
 - default: 접근 불가능
 - private: 접근 불가능
 
 */

package day13_2;

// import: 다른 패키지의 클래스를 사용할 때 사용
import day13_1.Access;

public class AccessMain2 {

	public static void main(String[] args) {
		
		Access access2 = new Access();
		
//		public: 접근 가능.
		access2.publicValue = 100;
		
//		protected: 접근 불가능.
//		access2.protectedValue = "A";
		
//		default: 접근 불가능.
//		access2.defaultValue = "B";
		
//		private: 접근 불가능.
//		access2.privateValue = 100

		AccessChild2 acChild = new AccessChild2();
		
	}

}
