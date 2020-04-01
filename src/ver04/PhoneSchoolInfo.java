package ver04;

public class PhoneSchoolInfo extends PhoneInfo{
	//멤버변수
	String major;
	String year; 
	
	//PhoneInfo에서 상속받은 생성자 + major + year
	public PhoneSchoolInfo(String name, String phoneNumber, 
							String major, String year) {
		super(name, phoneNumber);
		this.major = major;
		this.year = year;
	}
	//메소드(PhoneInfo에서 오버라이딩)
	@Override
	public void showPhoneInfo() {
		System.out.println("-----------------");
		super.showPhoneInfo();
		System.out.println("전공 :" + major);
		System.out.println("학년: " + year);
	}	
}
