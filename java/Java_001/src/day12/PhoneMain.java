package day12;

public class PhoneMain {

	public static void main(String[] args) {

		Phone ph1 = new Phone();
		System.out.println("ph1.color: " + ph1.color);
		System.out.println("ph1.telecom: " + ph1.telecom);
		System.out.println("ph1.storage: " + ph1.storage);
		System.out.println();
		
		Phone Sk_phone = new Phone("SK");
		System.out.println("Sk_phone.telecom: " + Sk_phone.telecom);
		System.out.println("Sk_phone.storage: " + Sk_phone.storage);
		Sk_phone.color = "blue";
		Sk_phone.storage = 512;
		System.out.println();
		
		Phone ph_256 = new Phone(256);
		System.out.println("ph_256.telecom: " + ph_256.telecom);
		System.out.println("ph_256.storage: " + ph_256.storage);
		
		System.out.println("====================================");
		System.out.println("ph1.showInfo()");
		ph1.showInfo();
		System.out.println();
		
		
		System.out.println("Sk_phone.showInfo()");
		Sk_phone.showInfo();
		
		System.out.println("====================================");
		Sk_phone.printNumber1();	// 남는것이 없음
		int result2 = Sk_phone.printNumber2();	// 숫자 1이 남아 있음.
		System.out.println(result2);
	}

}