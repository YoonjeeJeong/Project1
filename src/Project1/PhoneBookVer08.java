package Project1;
import java.util.HashSet;
import java.util.Scanner;
import ver08.MenuSelectException;
import ver08.PhoneBookManager;
import ver08.MenuItem;



public class PhoneBookVer08 {

	public static void main(String[] args) throws MenuSelectException {
		try {
			PhoneBookManager phonemanage = new PhoneBookManager();
			phonemanage.printMenu();
			
		}
		catch(Exception e) {
			
		}
								
	}
}