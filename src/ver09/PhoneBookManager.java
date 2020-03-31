package ver09;

import java.util.Scanner;
import java.sql.SQLException;

public class PhoneBookManager extends IConnectimpl{
	
	public PhoneBookManager() {
		super("kosmo", "1234");
	}
		
	public void printMenu() {
		int selectMenu;
		Scanner scan = new Scanner(System.in);
		
		while(true) {

			System.out.println("1. 데이터 입력");
			System.out.println("2. 데이터 검색");
			System.out.println("3. 데이터 삭제");
			System.out.println("4. 주소록 출력");
			System.out.println("5. 프로그램 종료");
			System.out.println("선택하시오");
			int selectMenu1 = scan.nextInt();

				switch(selectMenu1) {
				case 1://데이터 입력
					dataInput();
					break;
				case 2://테이터 검색
					dataSearch();
					break;
				case 3://데이터 삭제
					dataDelete();
					break;
				case 4://주소록 출력
					dataAllShow();
					break;
				case 5://프로그램 종료
					System.out.println("프로그램 종료");
					return;	
				}
			}
		}
		public void dataInput() {			
			String name, phoneNumber, birthday;
			
			Scanner scan = new Scanner(System.in);
			
			//IConnectimpl iconnect = new IConnectimpl("kosmo", "1234");
			//iconnect.connect("kosmo", "1234");
			//System.out.println("연결");
			
			try {
				String query = "INSERT INTO phonebook_tb VALUES (?, ?, ?)";
				psmt = con.prepareStatement(query);
				
				System.out.println("이름: ");
				name = scan.nextLine();
		
				System.out.println("전화번호: ");
				phoneNumber = scan.nextLine();
		
				System.out.println("생년월일: ");		
				birthday = scan.nextLine();
				
				psmt.setString(1, name);
				psmt.setString(2, phoneNumber);
				psmt.setString(3, birthday);
				
				int affected = psmt.executeUpdate();
				System.out.println(affected + "행이 입력되었습니다");					
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
//			finally {
//				close();
//			}			
		}
		public void dataSearch() {
			
			Scanner scan = new Scanner(System.in);
			
//			IConnectimpl iconnect = new IConnectimpl();
//			iconnect.connect("kosmo", "1234");
			String name1;
			System.out.println("검색할 이름: ");
			name1 = scan.nextLine();
				
			try {
			stmt = con.createStatement();
			String query = "SELECT * from phonebook_tb" 
					+" where name like '"+name1+"'";
			
			rs = stmt.executeQuery(query);
				while(rs.next()){					
					psmt = con.prepareStatement(query);
					
					String name = rs.getString(1);
					String phoneNumber = rs.getString(2);
					String birthday = rs.getString(3);
					
					System.out.printf("이름:%s ", name);
					System.out.printf("전화번호:%s ", phoneNumber);
					System.out.printf("생일:%s\n", birthday);
				}
				psmt.executeUpdate();
			}
			catch(SQLException e){
				System.out.println("쿼리오류!");
				e.printStackTrace();
			}
//			finally {
//				close();
//			}
		}
		public void dataDelete() {
			
			Scanner scan = new Scanner(System.in);
			
//			IConnectimpl iconnect = new IConnectimpl();
//			iconnect.connect("kosmo", "1234");
//			connect("kosmo", "1234");
			String name;
			
			
			try{			
				
				String query = "DELETE from phonebook_tb" 
						+" where name=?";
				psmt = con.prepareStatement(query);	
				System.out.println("삭제할 이름을 입력하세요");
				name = scan.nextLine();
				psmt.setString(1, name);
				psmt.executeUpdate();
				}
				catch(SQLException e) {
					System.out.println("쿼리오류!");
					e.printStackTrace();
				}
				finally {
					close();
			}
		}
		public void dataAllShow() {
//			IConnectimpl iconnect = new IConnectimpl();
//			iconnect.connect("kosmo", "1234");
			
			try {
				String query = "SELECT * from phonebook_tb";
				psmt = con.prepareStatement(query);
				rs = psmt.executeQuery();
				
				while(rs.next()) {
					String name = rs.getString(1);
					String phoneNumber = rs.getString(2);
					String birthday = rs.getString(3);
					
					System.out.printf("이름:%s ", name);
					System.out.printf("전화번호:%s ", phoneNumber);
					System.out.printf("생일:%s\n", birthday);
				}
				psmt.executeUpdate();
			}
			catch (SQLException e) {
				System.out.println("쿼리오류!");
				e.printStackTrace();
			}
//			finally {
//				close();
//		}			
	}
}
	
