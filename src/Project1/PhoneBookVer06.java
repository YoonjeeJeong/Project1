package Project1;

import ver06.MenuSelectException;
import ver06.PhoneBookManager;



public class PhoneBookVer06 {

	public static void main(String[] args) throws MenuSelectException {
		
		PhoneBookManager manager = new PhoneBookManager(100);
				
			try {
				manager.printMenu();
			} catch (ver07.MenuSelectException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}