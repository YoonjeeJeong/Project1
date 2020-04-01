package ver03;

public class PhoneInfo {
	
	//멤버변수
	String name;
	String phoneNumber; 
	String birthday;
	
	//생성자
	public PhoneInfo(String name, String phoneNumber, String birthday) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;
	}
	//생년월일 인자가 없는 생성자
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
		if(birthday==null) {
			System.out.println("생년월일 입력되지 않음");
		}
		else {

			System.out.println("생년월일 :" + birthday);
		}
	}	
}
