package ver07;
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
				catch(MenuSelectException e) {
					System.out.println("1-5사이를 입력하세요!");
				}
				catch(InputMismatchException e){
					System.out.println("숫자를 입력하세요");
					scan.nextLine();
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
				phoneInfo.add(phoneinfo);//데이터 입력됨
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
				phoneInfo.add(schoolinfo);//데이터 입력됨
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
				phoneInfo.add(companyinfo);//데이터 입력됨
			}
			else {
				System.out.println("숫자만 입력하세요");
			}
		}
		//데이터 검색
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
						b = true;//검색결과 있음
						System.out.println("요청하신 정보를 찾았습니다");
						}
					}
					if(b==false) {//검색결과 없음
						NullPointerException nullPointerExcept = new NullPointerException();
						throw nullPointerExcept;
			}
		}
		//데이터 삭제
		public void dataDelete() {
			 Scanner scan = new Scanner(System.in);
			 System.out.println("삭제할 이름을 입력하세요");
			 String deleteName = scan.nextLine();
			 
			 int deleteIndex = -1;
			 
			 Iterator<PhoneInfo> itr = phoneInfo.iterator();
			 while(itr.hasNext()) {
				 PhoneInfo phoneInfo = itr.next();
				 if(deleteName.equals(phoneInfo.name)) {
					 itr.remove();//검색한 이름이 존재할 경우 삭제
					 System.out.println("제거되었습니다");
				 }
				 else if(deleteIndex==-1) {
				 }
			 }
		}
		//전체 데이터 출력
		public void dataAllShow() {
			
			for(PhoneInfo st : phoneInfo) {
				System.out.println(st.toString());
				System.out.println("");
			}
		}
		//중복체크 
		public void checkName(String name1) {
			
			int num = 0;
			Scanner scan = new Scanner(System.in);
			Iterator<PhoneInfo> itr = phoneInfo.iterator();
			while(itr.hasNext()) {
				PhoneInfo phoneinfo = itr.next();
				if(name1.equals(phoneinfo.name)) {
					//중복 덮어쓰기 옵션
					System.out.println("중복된 이름. 선택: 1.덮어쓰기 2.입력메뉴로 가기");
					num = scan.nextInt();
					if(num==1) {
						itr.remove();//덮어쓰기
						System.out.println("덮어쓰기 완료");
					}
					else if(num==2){
						dataInput();//덮어쓰기 안 할 경우 입력으로 돌아감
				}		
			}
		}			
	}
}
	
