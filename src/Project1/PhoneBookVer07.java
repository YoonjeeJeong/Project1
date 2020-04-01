package Project1;
import java.util.HashSet;
import java.util.Scanner;
import ver07.MenuSelectException;
import ver07.PhoneBookManager;
import ver07.MenuItem;



public class PhoneBookVer07 {

	public static void main(String[] args) throws MenuSelectException {
			
		try {
		PhoneBookManager phonemanage = new PhoneBookManager();
			phonemanage.printMenu();
		}	
		catch(MenuSelectException e) {
			
		}
	}
}