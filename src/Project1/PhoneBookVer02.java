package Project1;
import java.util.Scanner;
import ver02.PhoneInfo;

public class PhoneBookVer02 {

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
					
					//생일을 입력하지 않아도 에러가 나지 않도록 if절로 옵션을 준다.
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
					//프로그램 종료
					else if(choice==2) {
					System.out.println("선택 2");
					System.out.println("프로그램이 종료되었습니다");
					System.out.println("==================");
					break;
					}
					//문자를 입력하거나 숫자를 잘못 입력했을 경우
					else {
						System.out.println("잘못 선택하셨어요");
					}
				}//숫자를 입력하라고 말함
				catch (NumberFormatException e) {
					System.out.println("숫자를 입력하세요");
					return;
			}
					
		}
		
	}		
}
