package Project1;
import java.util.Scanner;
import ver05.PhoneBookManager;
import ver05.MenuItem;

public class PhoneBookVer05 implements MenuItem{
	
	public static void printMenu() {

		System.out.println("1. 데이터 입력");
		System.out.println("2. 데이터 검색");
		System.out.println("3. 데이터 삭제");
		System.out.println("4. 주소록 출력");
		System.out.println("5. 프로그램 종료");
	}
	public static void main(String[] args) {
		
		//배열의 크기=100
		PhoneBookManager manager = 
				new PhoneBookManager(100);

			while(true) {
				
				printMenu();
				
				System.out.println("메뉴를 선택하세요");
				Scanner scan = new Scanner(System.in);
				int num = scan.nextInt();
				scan.nextLine();

				switch(num) {
				case INPUT://데이터 입력
					manager.dataInput();
					break;
				case SEARCH://테이터 검색
					manager.dataSearch();
					break;
				case DELETE://데이터 삭제
					manager.dataDelete();
					break;
				case SHOWALL://주소록 출력
					manager.dataAllShow();
					break;
				case EXIT://프로그램 종료
					System.out.println("프로그램 종료");
					return;	
				}
			}			
	}
}