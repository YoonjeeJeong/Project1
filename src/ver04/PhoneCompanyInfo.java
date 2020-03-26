package ver04;

import java.util.Scanner;

public class PhoneCompanyInfo extends PhoneInfo{

	String company; 
	
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public void addPhone() {
				
		Scanner scan = new Scanner(System.in);			
				
		while(true) {
			
			System.out.println("메뉴를 선택하세요");
			System.out.println("1.데이터 입력");
			System.out.println("2.프로그램 종료");
			System.out.println("메뉴선택>>");
			int choice = scan.nextInt();
			scan.nextLine();//버퍼 날림. 엔터도 숫자로 인식된다.
			
			if(choice==1) {
				System.out.println("회사: ");
				company = scan.nextLine();
			}
		}	
	}
	public void showPhoneInfo() {
		System.out.println("회사명 :" + company);
	}	
}
