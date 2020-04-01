package ver09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class IConnectimpl implements IConnect{

	//동적쿼리 처리를 위한 객체
	public PreparedStatement psmt;
	public Connection con;
	public Statement stmt;
	public ResultSet rs;
	
	public IConnectimpl() {
		System.out.println("IConnectimpl 기본생성자 호출");
	}
	public IConnectimpl(String user, String pass) {
		System.out.println("IConnectimpl 인자생성자 호출");
		try {
			//드라이버로드
			Class.forName(ORACLE_DRIVER);
			//DB연결
			connect(user, pass);
		}
		catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		}
	}
	//오라클 DB에 실제 접속
	@Override
	public void connect(String user, String pass) {
		try {
			con = DriverManager.getConnection(ORACLE_URL, user, pass);
		}
		catch(SQLException e) {
			System.out.println("데이터베이스 연결오류");
			e.printStackTrace();
		}
	}
	@Override
	public void close() {
		try {
			if(con!=null) con.close();//Statement객체 자원반납
			if(psmt!=null) psmt.close();//Connection객체 자원반납
			if(rs!=null) rs.close();
			
		}
		catch(Exception e) {
			System.out.println("자원반납시 오류가 발생");
			e.printStackTrace();
		}	
	}
	//사용자로부터 입력값을 받기위한 메소드
	@Override
	public String scanValue(String title) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print(title +"을 입력(exit->종료)");
		String inputStr = scan.nextLine();
		if("EXIT".equalsIgnoreCase(inputStr)) {
			System.out.println("프로그램을 종료합니다");
			close();
			//프로그램 자체가 즉시 종료된다
			System.exit(0);
		}
		return inputStr;
	}

}
