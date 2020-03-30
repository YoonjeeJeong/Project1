package ver06;

import java.util.InputMismatchException;
import java.util.Scanner;
import ver07.MenuSelectException;

public class PhoneBookManager implements SubMenuItem, MenuItem{
		
		private PhoneInfo[] phoneInfoArray;
		private int numofInfo;
		
		public PhoneBookManager(int num) {
			phoneInfoArray = new PhoneInfo[num]; 
			numofInfo = 0;
		}
		public void printMenu() throws MenuSelectException{
			
			int num;
			Scanner scan = new Scanner(System.in);
			
			while(true) {
				try {
			
					System.out.println("1. 데이터 입력");
					System.out.println("2. 데이터 검색");
					System.out.println("3. 데이터 삭제");
					System.out.println("4. 주소록 출력");
					System.out.println("5. 프로그램 종료");
					
					num = scan.nextInt();
					if(num>5 || num<1) {
						MenuSelectException MenuSE = new MenuSelectException();
						throw MenuSE;
					}
					
					switch(num) {
					case MenuItem.INPUT://데이터 입력
						dataInput();
						break;
					case MenuItem.SEARCH://테이터 검색
						dataSearch();
						break;
					case MenuItem.DELETE://데이터 삭제
						dataDelete();
						break;
					case MenuItem.SHOWALL://주소록 출력
						dataAllShow();
						break;
					case MenuItem.EXIT://프로그램 종료
						System.out.println("프로그램 종료");
						return;	
					}					
				}
				catch(InputMismatchException e){
					System.out.println("1-5사이의 숫자를 입력하세요");
				}
				catch(NullPointerException e) {
					System.out.println("검색결과가 없어요");
				}
			}
		}
		public void dataInput() {
			
			String name, phoneNumber, major, year, company;
			int choice;
			
			Scanner scan = new Scanner(System.in);
			System.out.println("옵션: 1.일반, 2.동창, 3.회사");
			choice = scan.nextInt();
			scan.nextLine();
			
			
			if(choice==NORMAL) {
				System.out.println("이름: ");
				name = scan.nextLine();
				System.out.println("전화번호: ");
				phoneNumber = scan.nextLine();
				PhoneInfo phoneinfo = new PhoneInfo(name, phoneNumber); 												
				phoneInfoArray[numofInfo++] = phoneinfo;
			}
			else if(choice==SCHOOLFRIEND) {
				System.out.println("이름: ");
				name = scan.nextLine();
				System.out.println("전화번호: ");
				phoneNumber = scan.nextLine();
				System.out.println("전공: ");
				major = scan.nextLine();
				System.out.println("학년: ");
				year = scan.nextLine();
				PhoneSchoolInfo schoolinfo = 
						new PhoneSchoolInfo(name, phoneNumber, major, year);
				phoneInfoArray[numofInfo++] = schoolinfo;
			}
			else if(choice==COWORKER) {
				System.out.println("이름: ");
				name = scan.nextLine();
				System.out.println("전화번호: ");
				phoneNumber = scan.nextLine();
				System.out.println("회사명: ");
				company = scan.nextLine();
				PhoneCompanyInfo companyinfo = 
						new PhoneCompanyInfo(name, phoneNumber, company);
				phoneInfoArray[numofInfo++] = companyinfo;
			}
			else {
				System.out.println("숫자만 입력하세요");
			}
		}
		public void dataSearch() {
			Scanner scan = new Scanner(System.in);
			System.out.println("검색할 이름을 입력하세요");
			String name = scan.nextLine();
			boolean b=false;
			
			for(int i=0 ; i<numofInfo ; i++) {
				System.out.println("검색중인 이름: "+phoneInfoArray[i].name);
				if(phoneInfoArray[i].name.equals(name)) {
					phoneInfoArray[i].showPhoneInfo();
					b=true;
				}
			}
			if(b==false) {
				NullPointerException nullPException = new NullPointerException();
				throw nullPException;
			}
		}
		public void dataDelete() {
			 Scanner scan = new Scanner(System.in);
			 System.out.println("삭제할 이름을 입력하세요");
			 String deleteName = scan.nextLine();
			 int deleteIndex = -1;
			 for(int i=0 ; i<numofInfo ; i++) {
				 if(deleteName.compareTo(phoneInfoArray[i].name)==0) {
					 phoneInfoArray[i] = null;			 
					 deleteIndex =i;
					 numofInfo--;
				 }
			}
			if(deleteIndex==- 1) {
				System.out.println("삭제된 데이터가  없어요");
			}
			else {
				for(int i=deleteIndex ; i<numofInfo; i++) {
					phoneInfoArray[i] = phoneInfoArray[i+1];
				}
			System.out.println("데이터 "+deleteIndex+" 번이 삭제되었습니다");
			}
		}
		public void dataAllShow() {
			for(int i=0; i<numofInfo ;i++) {
				phoneInfoArray[i].showPhoneInfo();		
		}
	}
}
	
