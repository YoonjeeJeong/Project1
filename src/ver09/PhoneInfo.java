package ver09;

import Project1.PhoneBookVer03;

public class PhoneInfo {

	String name;
	String phoneNumber; 
	String birthday;
	PhoneBookVer03 bookV3 = new PhoneBookVer03();
	
	public PhoneInfo(String name, String phoneNumber, String birthday) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;		
	}
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
