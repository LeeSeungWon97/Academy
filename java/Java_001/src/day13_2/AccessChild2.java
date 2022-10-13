/* 
 
 < 다른 패키지 & 상속 O >
 - public: 접근 가능
 - protected: 접근 가능
 - default: 접근 불가능
 - private: 접근 불가능
 
 */

package day13_2;

import day13_1.Access;

public class AccessChild2 extends Access{
	public void childMethod() {

//		public: 접근 가능.
		System.out.println(publicValue);
		
//		protected: 상속을 받아 다른 패키지의 클래스지만 접근가능.
		System.out.println(protectedValue);

//		default: 다른 패키지이기 떄문에 접근 불가능.
//		System.out.println(defaultValue);
		
//		private: 접근 불가능.
//		System.out.println(privateVaule);
	}
}
