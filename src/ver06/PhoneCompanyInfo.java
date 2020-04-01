package ver06;

public class PhoneCompanyInfo extends PhoneInfo{

	//멤버변수
	String company; 
	
	//생성자
	public PhoneCompanyInfo(String name, String phoneNumber, String company) {
		super(name, phoneNumber);
		this.company = company;
	}
	//PhoneInfo 오버라이딩한 메소드
	@Override
	public void showPhoneInfo() {
		super.showPhoneInfo();
		System.out.println("회사명 :" + company);
	}	
}
