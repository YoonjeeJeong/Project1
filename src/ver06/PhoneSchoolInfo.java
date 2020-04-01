package ver06;

public class PhoneSchoolInfo extends PhoneInfo{

	//멤버메소드
	String major;
	String year; 
	
	//생성자 + major + year
	public PhoneSchoolInfo(String name, String phoneNumber, 
							String major, String year) {
		super(name, phoneNumber);
		this.major = major;
		this.year = year;
	}
	//PhoneInfo 오버라이딩한 메소드
	@Override
	public void showPhoneInfo() {
		super.showPhoneInfo();
		System.out.println("전공 :" + major);
		System.out.println("학년: " + year);
	}
	
}
