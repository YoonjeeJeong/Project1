package ver07;

public class PhoneSchoolInfo extends PhoneInfo{

	String major;
	String year; 
		
	public PhoneSchoolInfo(String name, String phoneNumber, 
							String major, String year) {
		super(name, phoneNumber);
		this.major = major;
		this.year = year;
	}
	@Override
	public boolean equals(Object obj) {
		PhoneInfo phoneInfo = (PhoneInfo)obj;
		PhoneBookManager phonebmng = (PhoneBookManager)obj;
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
	public String toString() {
		
		return "이름: "+name+"전화번호: "+phoneNumber+"\n전공명: "+major+"학년: "+year;
	}
}
