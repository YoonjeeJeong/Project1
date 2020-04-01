package ver05;

public class PhoneInfo {
	
	//멤버변수
	String name;
	String phoneNumber; 
	
	//생성자
	public PhoneInfo(String name, String phoneNumber) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	//메소드
	public void showPhoneInfo() {
		System.out.println("-----------------");
		System.out.println("이름 :" + name);
		System.out.println("전화번호: " + phoneNumber);

	}	
}
