package ver07;
import java.awt.ScrollPaneAdjustable;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class PhoneBookManager implements SubMenuItem, MenuItem{
				
		HashSet<PhoneInfo> phoneInfo = new HashSet<PhoneInfo>();

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
					System.out.println("숫자를 입력하세요");
				}
				catch(NullPointerException e) {
					System.out.println("검색결과가 없어요");
				}
			}
		}
		public void dataInput() {
			String name1, phoneNumber1, major1, year1, company1;
			int choice;
			
			Scanner scan = new Scanner(System.in);
			System.out.println("옵션: 1.일반, 2.동창, 3.회사");
			choice = scan.nextInt();
			scan.nextLine();
						
			if(choice==NORMAL) {
				System.out.println("이름: ");
				name1 = scan.nextLine();
				checkName(name1);
				System.out.println("전화번호: ");
				phoneNumber1 = scan.nextLine();
				
				PhoneInfo phoneinfo = new PhoneInfo(name1, phoneNumber1);
				phoneInfo.add(phoneinfo);
			}
			else if(choice==SCHOOLFRIEND) {
				System.out.println("이름: ");
				name1 = scan.nextLine();
				
				System.out.println("전화번호: ");
				phoneNumber1 = scan.nextLine();
				System.out.println("전공: ");
				major1 = scan.nextLine();
				System.out.println("학년: ");
				year1 = scan.nextLine();
				
				PhoneSchoolInfo schoolinfo = 
						new PhoneSchoolInfo(name1, phoneNumber1, major1, year1);
				phoneInfo.add(schoolinfo);
			}
			else if(choice==COWORKER) {
				System.out.println("이름: ");
				name1 = scan.nextLine();
				
				System.out.println("전화번호: ");
				phoneNumber1 = scan.nextLine();
				System.out.println("회사명: ");
				company1 = scan.nextLine();
				
				PhoneCompanyInfo companyinfo = 
						new PhoneCompanyInfo(name1, phoneNumber1, company1);
				phoneInfo.add(companyinfo);
			}
			else {
				System.out.println("숫자만 입력하세요");
			}
		}
		public void dataSearch() {
			boolean b=false;//검색결과 유무확인
			Scanner scan = new Scanner(System.in);
			
			System.out.println("검색할 이름을 입력하세요");
			String name = scan.nextLine();
			
				Iterator<PhoneInfo> itr = phoneInfo.iterator();
				while(itr.hasNext()) {
					PhoneInfo phoneInfo = itr.next();
					if(name.equals(phoneInfo.name)) {
						System.out.println(phoneInfo);
						b = true;
						System.out.println("요청하신 정보를 찾았습니다");
						}
					}
					if(b==false) {
						NullPointerException nullPointerExcept = new NullPointerException();
						throw nullPointerExcept;
			}
		}
		public void dataDelete() {
			 Scanner scan = new Scanner(System.in);
			 System.out.println("삭제할 이름을 입력하세요");
			 String deleteName = scan.nextLine();
			 
			 int deleteIndex = -1;
			 
			 Iterator<PhoneInfo> itr = phoneInfo.iterator();
			 while(itr.hasNext()) {
				 PhoneInfo phoneInfo = itr.next();
				 if(deleteName.equals(phoneInfo.name)) {
					 itr.remove();
					 System.out.println("제거되었습니다");
				 }
				 if(deleteIndex==-1) {
					 System.out.println("삭제된 데이터 없음");
				 }
			 }
		}
		public void dataAllShow() {
			
			for(PhoneInfo st:phoneInfo) {
				System.out.println(phoneInfo.toString());		
			}
		}
		public void checkName(String name1) {
			
			int num = 0;
			Scanner scan = new Scanner(System.in);
			Iterator<PhoneInfo> itr = phoneInfo.iterator();
			while(itr.hasNext()) {
				PhoneInfo phoneinfo = itr.next();
				if(name1.equals(phoneinfo.name)) {
					System.out.println("중복된 이름. 선택: 1.덮어쓰기 2.입력메뉴로 가기");
					num = scan.nextInt();
					if(num==1) {
						itr.remove();
						System.out.println("덮어쓰기 완료");
					}
					else if(num==2){
						dataInput();
				}		
			}
		}			
	}
}
	
