package ȭ�鿬��DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PostDAO {
	
	public PostVO one(int post_no) {
		
	
	
	ResultSet rs = null; // �׸�(=�ʵ� ,�÷�,�Ӽ�)�� + ��������͸� ��� �ִ� ���̺�
	//�⺻�� ����/�Ǽ�/����/���� ��(0)���� �ʱ�ȭ
	//������ ��������(������) �ּҰ�! ������ (null) �� �ʱ�ȭ
	
	// MemberVO bag �� �����Ⱚ �ʱ�ȭ (null)
	PostVO bag = null;
	try {
		// 1.����Ŭ 11g�� ������ ��ǰ ����
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("1. ����Ŭ�� �ڹ� ������ ��ǰ ���� ����.");
//		Locale.setDefault(Locale.US); //�� locale�������� �е鸸!!!
		
		// 2.����Ŭ 11g�� �����غ���.(java --- oracle) 
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "system";
		String password = "oracle";
		Connection con = DriverManager.getConnection(url, user, password); //Connection
		//String data = JOptionPane.showInputDialog("�̸��Է�"); //String, �Ӿƹ��� 
		System.out.println("2. ����Ŭ ���� ����.");
		
		//ipaddress ==> InetAddress
		//String url = "http://wwww.naver.com";
		//URL u = new URL(url);
		//�ڹٴ� ��ǰ�������̿���,String�� ���� ���ڿ��� Ư���� ��ǰ���� �ν����� ����.
		//Ư���� ��ǰ���� �ν��Ϸ��� �� ��ǰ���� ������־�� �Ѵ�.
		//SQL��ǰ���� ������־�� ��.
		//PreparedStatement�� SQL��ǰ!!
		
		String sql = "select*from hr.POST where POST_NO = ? ";
		PreparedStatement ps = con.prepareStatement(sql); //PreparedStatement
		ps.setInt(1, post_no);
		//con��ǰ���� sql��Ʈ���� �ִ� �� SQL��ǰ���� ������ּ���.
		System.out.println("3. SQL�� ��ǰ(��ü)���� ������ֱ� ����.");
		
		rs = ps.executeQuery();  //insert, update, delete����!! sql�� �������� int
		System.out.println("4. SQL�� ����Ŭ�� ������ ����.");
		if(rs.next()) { // �˻� ����� �ִ� �� ���δ� rs.next() �� �Ѵ�
			// true �̸� �ִ� ��� �ǹ� , false �̸� ���� ��� �ǹ�.
			System.out.println("�˻� ��� ����.");
			int post_no1 = rs.getInt(1); 
			String title = rs.getString(2);
			String content = rs.getString(3);
			String writer = rs.getString(4);			
			int score = rs.getInt(5);
			String write_date = rs.getString(6);
			String place_code = rs.getString(7);
			System.out.println(post_no1 + " "+ title + " "+ content + " "+ writer + " "
					+ score + " " + write_date + " " + place_code);
			bag = new PostVO();
			bag.setPost_no(post_no1);
			bag.setTitle(title);
			bag.setContent(content);
			bag.setWriter(writer);
			bag.setScore(score);
			bag.setPlace_code(place_code);
			// �˻������ �˻�ȭ�� UI �κ����� �־���Ѵ�.
			
		}else {
			System.out.println("�˻� ��� ����");
		}
		
		//System.out.println(result);
	} catch (Exception e) {
		e.printStackTrace();
	}
	//return id, pw,name,tel �� XXXXXX!
	//return �ڿ��� �ݵ�� ���� �����͸� ��� �������־����
	//�˻������ �������� bag�� �����Ͱ� �������.
	//�˻���� ���� ���� bag�� ������ ����ֳ�?? Null!!
	return bag; // bag Ÿ���� public MemberVO ������(�˻� ���ϴ� ��������) ���� �����������!!
}
	}

