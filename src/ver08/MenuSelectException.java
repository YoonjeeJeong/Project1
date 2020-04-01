package ver08;

import java.util.HashSet;

public class MenuSelectException extends Exception{
	
	public MenuSelectException() {
		
		System.out.println("1-5사이 숫자만 입력하세요");
	}
}
