package ver04;
import java.util.Scanner;

class Friend {
	String name;
	String phoneNumber; 
	String major;
	int year;
	String company;	
	
	public Friend(String name, String phoneNumber, 
			String major, int year, String company) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.major = major;
		this.year = year;
		this.company = company;
	}
	public void dataAllShow() {
		System.out.println("이름: " + name);
		System.out.println("전화번호: " + phoneNumber);
		System.out.println("전공: " + major);
		System.out.println("학년: "+ year);
		System.out.println("회사명: "+company);				
	}
}
public class PhoneBookManager  {
	
	public static void printMenu() {
		System.out.println("1. 데이터 입력");
		System.out.println("2. 데이터 검색");
		System.out.println("3. 데이터 삭제");
		System.out.println("4. 주소록 출력");
		System.out.println("5. 프로그램 종료");
		System.out.println("메뉴선택>>>");
	}	
	public static void main(String[] args) {
		PhoneManager manager = new PhoneManager(100); 
		
		while(true) {
		printMenu();		
		Scanner scan = new Scanner(System.in);
		int choice = scan.nextInt();
		
		switch(choice) {
		case 1://데이터 입력
			manager.dataInput(choice);
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
class PhoneManager {
	private Friend[] myFriends;
	private int numOfFriends;
	
	public PhoneManager(int num) {
		myFriends = new Friend[num];
		numOfFriends = 0;
	}
	public void dataInput(int choice) {
		Scanner scan = new Scanner(System.in);
		String name, phoneNumber, major, company;
		int year;
		
		System.out.println("이름: ");
		name = scan.nextLine();

		System.out.println("전화번호: ");
		phoneNumber = scan.nextLine();

		System.out.println("전공: ");		
		major = scan.nextLine();
		
		System.out.println("학년: ");		
		year = scan.nextInt();
		scan.nextLine();//버퍼 날리기
		
		System.out.println("회사명: ");		
		company = scan.nextLine();
		
		if(choice==1) {
			Friend friends = new Friend(name, phoneNumber, major, year, company);					
			myFriends[numOfFriends++] = friends;
		}
		else if(choice!=1) {
			return;
		}
		System.out.println("친구정보 입력 완료!");
	}
	public void dataAllShow() {
		for(int i=0; i<numOfFriends ; i++) {
			myFriends[i].dataAllShow();
		}
		System.out.println("전체정보가 출력되었어요");
	}
	public void dataSearch() {
		Scanner scan = new Scanner(System.in);
		System.out.println("검색할 이름을 입력하세요");
		String searchName = scan.nextLine();
		
		for(int i=0 ; i<numOfFriends ; i++) {
			System.out.println("검색중인 이름: "+myFriends[i].name);
			if(searchName.compareTo(myFriends[i].name)==0) {
				myFriends[i].dataAllShow();
				System.out.println("요청하신 정보를 찾았니다");
			}
		}	
	}
	public void dataDelete() {
		 Scanner scan = new Scanner(System.in);
		 System.out.println("삭제할 이름을 입력하세요");
		 String deleteName = scan.nextLine();
		 int deleteIndex = -1;
		 for(int i=0 ; i<numOfFriends ; i++) {
			 if(deleteName.compareTo(myFriends[i].name)==0) {
				 myFriends[i] = null;			 
				 deleteIndex =i;
				 numOfFriends--;
			 }
		}
		if(deleteIndex==- 1) {
			System.out.println("삭제된 데이터가  없어요");
		}
		else {
			for(int i=deleteIndex ; i<numOfFriends; i++) {
				myFriends[i] = myFriends[i+1];
			}
		System.out.println("데이터 "+deleteIndex+" 번이 삭제되었습니다");
		}
	}		
}
