package ver07;

public class PhoneCompanyInfo extends PhoneInfo{

	String company; 
	
	
	public PhoneCompanyInfo(String name, String phoneNumber, String company) {
		super(name, phoneNumber);
		this.company = company;
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
	public String toString() {		
		return "이름: "+name+"전화번호: "+phoneNumber+"회사명: "+company;
	}
	
}
