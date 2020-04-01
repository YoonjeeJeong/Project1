package ver03;
import java.util.Scanner;

public class PhoneBookManager{
		
		//정보를 저장하는 전화번호부 배열
		private PhoneInfo[] phoneInfoArray;
		private int numofInfo;
		
		public PhoneBookManager(int num) {
			phoneInfoArray = new PhoneInfo[num]; 
			numofInfo = 0;
		}
		
		//정보입력
		public void dataInput() {
			Scanner scan = new Scanner(System.in);
			String name, phoneNumber, birthday;
			
			System.out.println("이름: ");
			name = scan.nextLine();
	
			System.out.println("전화번호: ");
			phoneNumber = scan.nextLine();
	
			System.out.println("생년월일: ");		
			birthday = scan.nextLine();
			if(birthday==null) {
				System.out.println("생년월일 입력되지 않음");
			}
			
			PhoneInfo phoneinfo = new PhoneInfo(name, phoneNumber, 
												birthday);
			phoneInfoArray[numofInfo++] = phoneinfo;
		}
		//데이터 검색
		public void dataSearch() {
			Scanner scan = new Scanner(System.in);
			System.out.println("검색할 이름을 입력하세요");
			String name = scan.nextLine();
			
			for(int i=0 ; i<numofInfo ; i++) {
				if(phoneInfoArray[i].name.equals(name)) {
					System.out.println("요청하신 정보를 찾았습니다");
					phoneInfoArray[i].showPhoneInfo();
				}
			}	
		}
		//데이터 삭제
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
			 //삭제된 데이터가 없는 경우
			if(deleteIndex==- 1) {
				System.out.println("삭제된 데이터가  없어요");
			}
			//배열에서 삭제되고 한칸 앞으로 이동
			else {
				for(int i=deleteIndex ; i<numofInfo; i++) {
					phoneInfoArray[i] = phoneInfoArray[i+1];
				}
			System.out.println("데이터 "+deleteIndex+" 번이 삭제되었습니다");
			}
		}
		//전체정보 출력
		public void dataAllShow() {
			for(int i=0; i<numofInfo ;i++) {
				phoneInfoArray[i].showPhoneInfo();
		
		}
	}
}
	
