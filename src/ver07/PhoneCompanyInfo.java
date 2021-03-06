package ver07;

public class PhoneCompanyInfo extends PhoneInfo{
	
	//멤버변수
	String company; 
	
	//메소드
	public PhoneCompanyInfo(String name, String phoneNumber, String company) {
		super(name, phoneNumber);
		this.company = company;
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
	//회사명 반환하는 메소드
	@Override 
	public String toString() {		
		return "이름: "+name+", 전화번호: "+phoneNumber+", 회사명: "+company;
	}
	
}
