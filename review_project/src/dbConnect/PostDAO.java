package ȭ�鿬��DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PostDAO {
	
	public void () {
		Class.forName("oracle.jdbc.driver.OralcleDriver");
		// Ư���� ��ġ�� �ִ� ����̹� ������ ���� �о�鿩 ����
		System.out.println("1.����̹� ���� ����.!!");
		
		//2. db ���� mySQL : school, oracle: xe
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "system";
		String password = "oracle";
		Connection con = DriverManager.getConnection(url, user, password); //Connection
		//String data = JOptionPane.showInputDialog("�̸��Է�"); //String, �Ӿƹ��� 
		System.out.println("2. ����Ŭ ���� ����.");
		
		String sql = "delete from hr.POST where id = ? and pw = ?";
		PreparedStatement ps = con.prepareStatement(sql);

		System.out.println("3. sql �� ���� ����!!");
		
		//4. sql ���� db ������ ������ --> ����� ��� �Ǿ����� �ڹ����α׷� �˷���.
		ResultSet rs = ps.executeQuery();
	}
	
}
