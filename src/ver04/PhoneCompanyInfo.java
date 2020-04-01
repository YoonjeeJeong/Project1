package ver04;

public class PhoneCompanyInfo extends PhoneInfo{
	//멤버메소드
	String company; 
	
	//PhoneInfo에서 상속받은 인자name, phoneNumber와 company
	public PhoneCompanyInfo(String name, String phoneNumber, String company) {
		super(name, phoneNumber);
		this.company = company;
	}
	//메소드
	@Override
	public void showPhoneInfo() {
		System.out.println("-----------------");
		super.showPhoneInfo();
		System.out.println("회사명 :" + company);
	}	
}
