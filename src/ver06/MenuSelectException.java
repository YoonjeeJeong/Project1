package ver06;

public class MenuSelectException extends Exception{
	
	public MenuSelectException() {
		
		PhoneBookManager manager = new PhoneBookManager(100);
		System.out.println("1-5사이 숫자만 입력하세요");
		try {
			manager.printMenu();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
