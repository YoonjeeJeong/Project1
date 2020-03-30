package ver08;

import java.io.Serializable;

public class PhoneInfo implements Serializable {

	String name;
	String phoneNumber; 
	
	public PhoneInfo(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
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
	@Override
	public int hashCode() {
		int hc1 = name.hashCode();
		int hc2 = phoneNumber.hashCode();
		int result = hc1+hc2;
		return result;		
	}
	@Override
	public String toString(){

		return "이름 :" + name +"전화번호: " + phoneNumber;
	}	
}
