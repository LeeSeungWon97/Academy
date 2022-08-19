package day11_2;

public class PhoneMain {

	public static void main(String[] args) {
		
		Phone ph1 = new Phone();
		ph1.color = "black";
		ph1.telecom = "sk";
		
		Phone lgPhone = new Phone("LG");
		
		Phone myPhone = new Phone("블랙","SK");
		System.out.println("색상 : " + myPhone.color);
		System.out.println("통신사 : " + myPhone.telecom);
	}

}
