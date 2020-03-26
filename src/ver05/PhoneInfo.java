package ver05;

import java.util.Scanner;

public class PhoneInfo {

	String name;
	String phoneNumber; 
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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
				System.out.println("이름: ");
				name = scan.nextLine();

				System.out.println("전화번호: ");
				phoneNumber = scan.nextLine();
				}
			}	
		}
	public void showPhoneInfo() {
		System.out.println("이름 :" + name);
		System.out.println("전화번호: " + phoneNumber);
	}	
}
