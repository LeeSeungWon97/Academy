package day13_1;

public class PhoneBook {
	private int number; // 단축번호
	private String name; // 이름
	private String tel; // 전화번호

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
	public PhoneBook() {
		
	}
	
	public PhoneBook(int number,String name, String tel) {
		this.number = number;
		this.name = name;
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "PhoneBook [단축번호: " + number + ", 이름: " + name + ", 전화번호: " + tel + "]";
	}

}
