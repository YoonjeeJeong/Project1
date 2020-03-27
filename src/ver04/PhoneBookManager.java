package ver04;
import java.util.Scanner;

public class PhoneBookManager{
		
		private PhoneInfo[] phoneInfoArray;
		private int numofInfo;
		
		public PhoneBookManager(int num) {
			phoneInfoArray = new PhoneInfo[num]; 
			numofInfo = 0;
		}

		public void dataInput() {
			Scanner scan = new Scanner(System.in);
			System.out.println("옵션: 1.일반, 2.동창, 3.회사");
			int choice = scan.nextInt();
			scan.nextLine();
			String name, phoneNumber, major, year, company;
			
			if(choice==1) {
				System.out.println("이름: ");
				name = scan.nextLine();
				System.out.println("전화번호: ");
				phoneNumber = scan.nextLine();
				PhoneInfo phoneinfo = new PhoneInfo(name, phoneNumber); 												
				phoneInfoArray[numofInfo++] = phoneinfo;
			}
			else if(choice==2) {
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
			else if(choice==3) {
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
		}
		public void dataSearch() {
			Scanner scan = new Scanner(System.in);
			System.out.println("검색할 이름을 입력하세요");
			String name = scan.nextLine();
			
			for(int i=0 ; i<numofInfo ; i++) {
				System.out.println("검색중인 이름: "+phoneInfoArray[i].name);
				if(phoneInfoArray[i].name.equals(name)) {
					System.out.println("요청하신 정보를 찾았습니다");
					phoneInfoArray[i].showPhoneInfo();
				}
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
	
