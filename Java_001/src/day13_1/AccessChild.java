/* 
 
 < 같은 패키지 & 상속 O >
 - public: 접근 가능
 - protected: 접근 가능
 - default: 접근 가능
 - private: 접근 불가능
 
 */

package day13_1;

// extends [ClassName] : [ClassName]을 해당 클래스에 상속.
public class AccessChild extends Access {

	public void childMethod() {
		
//		public: 접근 가능.
		System.out.println(publicValue);
		
//		protected & default: 같은 패키지이기 떄문에 접근 가능.
		System.out.println(protectedValue);
		System.out.println(defaultValue);
		
//		private: 접근 불가능.
//		System.out.println(privateVaule);
	}

}
