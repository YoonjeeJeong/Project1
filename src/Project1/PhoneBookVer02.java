package Project1;
import java.util.Scanner;
import ver02.PhoneInfo;

public class PhoneBookVer02 {
/*
 프로그램 사용자로부터 데이터를 입력받는 형태로 변경하시오.
단 반복문을 이용해서 프로그램의 흐름이 계속 유지되도록 해야한다. 
사용자가 종료를 명령하지 않으면 다음과 같은 과정이 반복적으로 이루어진다.
키보드를 통한 데이터입력 -> 생성자를 통한 인스턴스생성 -> 
showPhoneInfo() 메소드호출
매 실행시 마다 기존 생성된 인스턴스는 유지되지 않아도 된다.(다음단계에서 진행)
실행결과>
선택하세요...
1. 데이터 입력
2. 프로그램 종료
선택: 1
이름: 성낙현
전화번호: 010-7906-3600
생년월일: 75.11.30
 
입력된 정보 출력...
name: 성낙현
phone: 010-7906-3600
birth: 75.11.30
 
선택하세요...
1. 데이터 입력
2. 프로그램 종료
선택: 2
프로그램을 종료합니다.*/

	public static void main(String[] args) {
		
			while(true) {
				try {
					System.out.println("================");
					System.out.println("메뉴를 선택하세요");					
					System.out.println("1. 데이터 입력");
					System.out.println("2. 프로그램 종료");
					
					Scanner scan = new Scanner(System.in);
					int choice = scan.nextInt();
					scan.nextLine();
					
					if(choice==1) {
						System.out.println("선택 1");
						System.out.print("이름을 입력하세요: ");
						String name = scan.nextLine();
						System.out.print("전화번호를 입력하세요: ");
						String phoneNumber = scan.nextLine();
						System.out.println("생일을 입력하세요: ");
						String birthday = scan.nextLine();
							if(birthday==null) {
								System.out.println("생일없음");												
							}
							PhoneInfo person = 
									new PhoneInfo(name, phoneNumber, birthday);
							person.showPhoneInfo();
						}
					else if(choice==2) {
					System.out.println("선택 2");
					System.out.println("프로그램이 종료되었습니다");
					System.out.println("==================");
					}
					else {
						System.out.println("잘못 선택하셨어요");
					}
				}
				catch (NumberFormatException e) {
					System.out.println("숫자를 입력하세요");
					return;
			}
					
		}
		
	}		
}
