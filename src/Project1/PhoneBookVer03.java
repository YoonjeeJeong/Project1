package Project1;
import java.util.Scanner;
import ver03.PhoneBookManager;

public class PhoneBookVer03 {
	
	public static void printMenu() {

		System.out.println("1. 데이터 입력");
		System.out.println("2. 데이터 검색");
		System.out.println("3. 데이터 삭제");
		System.out.println("4. 주소록 출력");
		System.out.println("5. 프로그램 종료");
	}
	public static void main(String[] args) {
		
		//배열에 최대 100개의 정보를 저장할 수 있다 
		PhoneBookManager manager = 
				new PhoneBookManager(100);

			while(true) {
				
				printMenu();
				
				System.out.println("메뉴를 선택하세요");
				Scanner scan = new Scanner(System.in);
				int choice = scan.nextInt();

				switch(choice) {
				case 1://데이터 입력
					manager.dataInput();
					break;
				case 2://테이터 검색
					manager.dataSearch();
					break;
				case 3://데이터 삭제
					manager.dataDelete();
					break;
				case 4://주소록 출력
					manager.dataAllShow();
					break;
				case 5://프로그램 종료
					System.out.println("프로그램 종료");
					return;	
				}
			}			
	}
}