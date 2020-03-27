package ver04;

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
	public void showPhoneInfo() {
		System.out.println("-----------------");
		super.showPhoneInfo();
		System.out.println("전공 :" + major);
		System.out.println("학년: " + year);
	}
	
}
