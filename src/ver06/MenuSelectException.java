package ver06;

public class MenuSelectException extends Exception{
	
	public MenuSelectException() {
		
		//배열 선언. 배열 크기=100.
		PhoneBookManager manager = new PhoneBookManager(100);
		
		//printMenu()에서 입력오류시 예외처리 
		System.out.println("1-5사이 숫자만 입력하세요");
		try {
			manager.printMenu();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
