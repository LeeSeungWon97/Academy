package day11_2;

public class Phone {
	String color;	// 색상
	String telecom;	// 통신사
	
	public Phone() {

	}

	public Phone(String telecom) {
		this.telecom = telecom;
	}
	
	public Phone(String color, String telecom) {
		if(color.equals("블랙")) {
			color = "검정";
		}
		this.color = color;
		this.telecom = telecom;
		
		
	}

	
	
	
	
	
	
}
