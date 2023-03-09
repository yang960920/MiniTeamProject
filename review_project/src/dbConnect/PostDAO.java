package 화면연결DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PostDAO {
	
	public void () {
		Class.forName("oracle.jdbc.driver.OralcleDriver");
		// 특정한 위치에 있는 드라이버 파일을 램에 읽어들여 설정
		System.out.println("1.드라이버 설정 성공.!!");
		
		//2. db 연결 mySQL : school, oracle: xe
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "system";
		String password = "oracle";
		Connection con = DriverManager.getConnection(url, user, password); //Connection
		//String data = JOptionPane.showInputDialog("이름입력"); //String, 임아무개 
		System.out.println("2. 오라클 연결 성공.");
		
		String sql = "delete from hr.POST where id = ? and pw = ?";
		PreparedStatement ps = con.prepareStatement(sql);

		System.out.println("3. sql 문 생성 성공!!");
		
		//4. sql 문을 db 서버에 보낸다 --> 결과가 어떻게 되었는지 자바프로그램 알려줌.
		ResultSet rs = ps.executeQuery();
	}
	
}
