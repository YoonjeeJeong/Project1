package ver08;

import java.io.Serializable;

public class PhoneInfo implements Serializable {
	
	//멤버변수
	String name;
	String phoneNumber; 
	
	//생성자
	public PhoneInfo(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	//이름과 이름 비교
	@Override
	public boolean equals(Object obj) {
		PhoneInfo phoneInfo = (PhoneInfo)obj;
		if(phoneInfo.name.equals(this.name)) {
			return true;
		}
		else {
			return false;
		}
	}
	//객체가 가진 고유 값(참조값)을 int형으로 반환하는 메소드
	@Override
	public int hashCode() {
		int hc1 = name.hashCode();
		int hc2 = phoneNumber.hashCode();
		int result = hc1+hc2;
		return result;		
	}
	//정보 반환 메소드
	@Override
	public String toString(){

		return "이름 :" + name +", 전화번호: " + phoneNumber;
	}	
}
