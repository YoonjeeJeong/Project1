package ver07;
import ver07.PhoneBookManager;

public class MenuSelectException extends Exception{
	
	public MenuSelectException() {
		
		try {
			PhoneBookManager manager = new PhoneBookManager();
			System.out.println("1-5사이 숫자만 입력하세요");
			manager.printMenu();
			
			}
			catch(Exception e) {
				
		}
		
	}
}
