package Project1;
import ver06.MenuSelectException;
import ver06.PhoneBookManager;

public class PhoneBookVer06 {

	public static void main(String[] args) throws MenuSelectException {
		
		//배열크기=100
		PhoneBookManager manager = new PhoneBookManager(100);
			
			//printMenu()에서 예외처리
			try {
				manager.printMenu();
				
			} catch (MenuSelectException e) {
				e.printStackTrace();
			}
	}
}