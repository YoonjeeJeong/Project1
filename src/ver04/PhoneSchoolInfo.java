package ver04;

import java.util.Scanner;

public class PhoneSchoolInfo extends PhoneInfo{

	String major;
	int year; 
	
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
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
				System.out.println("전공: ");
				major = scan.nextLine();

				System.out.println("학년: ");
				year = scan.nextInt();
				}
			}	
		}
	public void showPhoneInfo() {
		System.out.println("전공 :" + major);
		System.out.println("학년: " + year);
	}	
}
