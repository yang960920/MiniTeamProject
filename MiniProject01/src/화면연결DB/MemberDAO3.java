package ȭ�鿬��DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import ȭ�鿬��DB.MemberVO;

public class MemberDAO3 {
	
	public ArrayList<MemberVO> list() {
		ResultSet rs = null; //�׸�� + ��� �����͸� ��� �ִ� ���̺� 
		
		//����� �־��� ū �����̳� ������ ��ǰ�� �ʿ�!
		//ArrayList<MemberVO> ==> MemberVO�� �� arraylist��� �ǹ�
		ArrayList<MemberVO> list = new ArrayList<>();
		
		MemberVO bag = null;
		try {
			// 1.����Ŭ 11g�� ������ ��ǰ ����
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. ����Ŭ�� �ڹ� ������ ��ǰ ���� ����.");
//			Locale.setDefault(Locale.US); //�� locale�������� �е鸸!!!
			
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
			
			String sql = "select * from hr.MEMBER";
			PreparedStatement ps = con.prepareStatement(sql); //PreparedStatement
			//����!!!! ps.setString(1, id);
			System.out.println("3. SQL�� ��ǰ(��ü)���� ������ֱ� ����.");
			
			rs = ps.executeQuery(); //select�� ���۽�  
			System.out.println("4. SQL�� ����Ŭ�� ������ ����.");
			while(rs.next()) { //�˻������ �ִ��� ���δ� rs.next() 
				//true�̸� �ִٶ�� �ǹ�, false�̸� ���ٶ�� �ǹ� 
				//1. �˻��ܷΰ��� ������, 
//				System.out.println("�˻���� ����. ����.");
				//2. �� �÷����� ������ ��������. 
				String id2 = rs.getString(1); //id
				String pw = rs.getString("pw"); //pw
				String name = rs.getString(3); //name
				String tel = rs.getString(4); //tel
//				System.out.println(	id2 + " " 
//									+ pw + " " 
//									+ name + " " 
//									+ tel);
				//�˻������ �˻�ȭ�� UI�κ��� �־�� ��.
				//3. ������ ������.
				bag = new MemberVO();
				bag.setId(id2);
				bag.setPw(pw);
				bag.setName(name);
				bag.setTel(tel);
				
				//4. list�� bag�� �߰�������.
				list.add(bag);
			}
			ps.close();
			rs.close();
			con.close();
			//System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//return id, pw, name, tel�� XXXXX!
		//return �ڿ��� �ݵ�� ���� �����͸� ��� �������־�� ��.
		//�˻������ ���� ���� bag�� �����Ͱ� �������. 
		//�˻������ ���� ���� bag�� ������ ����ֳ�? null
		return list;
		
	}
	
	
	public int login(MemberVO bag) {
		int result =0;
		try {
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
			
			String sql = "delete from hr.MEMBER where id = ? and pw = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, bag.getId());
			ps.setString(2, bag.getPw());
			System.out.println("3. sql �� ���� ����!!");
			
			//4. sql ���� db ������ ������ --> ����� ��� �Ǿ����� �ڹ����α׷� �˷���.
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				System.out.println("�α��� ����");
				result = 1;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		return result;
	}
	
	
	public MemberVO one(String id) {
		
		ResultSet rs = null; // �׸�(=�ʵ� ,�÷�,�Ӽ�)�� + ��������͸� ��� �ִ� ���̺�
		//�⺻�� ����/�Ǽ�/����/���� ��(0)���� �ʱ�ȭ
		//������ ��������(������) �ּҰ�! ������ (null) �� �ʱ�ȭ
		
		// MemberVO bag �� �����Ⱚ �ʱ�ȭ (null)
		MemberVO bag = null;
		try {
			// 1.����Ŭ 11g�� ������ ��ǰ ����
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. ����Ŭ�� �ڹ� ������ ��ǰ ���� ����.");
//			Locale.setDefault(Locale.US); //�� locale�������� �е鸸!!!
			
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
			
			String sql = "select*from hr.MEMBER where id = ? ";
			PreparedStatement ps = con.prepareStatement(sql); //PreparedStatement
			ps.setString(1, id);
			//con��ǰ���� sql��Ʈ���� �ִ� �� SQL��ǰ���� ������ּ���.
			System.out.println("3. SQL�� ��ǰ(��ü)���� ������ֱ� ����.");
			
			rs = ps.executeQuery();  //insert, update, delete����!! sql�� �������� int
			System.out.println("4. SQL�� ����Ŭ�� ������ ����.");
			if(rs.next()) { // �˻� ����� �ִ� �� ���δ� rs.next() �� �Ѵ�
				// true �̸� �ִ� ��� �ǹ� , false �̸� ���� ��� �ǹ�.
				System.out.println("�˻� ��� ����.");
				String id2 = rs.getString(1); //id
				String pw = rs.getString(2); // pw
				String name = rs.getString(3); // name
				String tel = rs.getString(4);// tel
				System.out.println(id2 + " "+ pw + " "+name + " "+tel + " ");
				bag = new MemberVO();
				bag.setId(id2);
				bag.setPw(pw);
				bag.setName(name);
				bag.setTel(tel);
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
	

	public int delete(String id) {
		
		int result = 0;
		
		try {
			// 1.����Ŭ 11g�� ������ ��ǰ ����
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. ����Ŭ�� �ڹ� ������ ��ǰ ���� ����.");
//			Locale.setDefault(Locale.US); //�� locale�������� �е鸸!!!
			
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
			
			String sql = "delete from hr.MEMBER where id = ? ";
			PreparedStatement ps = con.prepareStatement(sql); //PreparedStatement
			ps.setString(1, id);
			//con��ǰ���� sql��Ʈ���� �ִ� �� SQL��ǰ���� ������ּ���.
			System.out.println("3. SQL�� ��ǰ(��ü)���� ������ֱ� ����.");
			
			result = ps.executeUpdate();  //insert, update, delete����!! sql�� �������� int
			System.out.println("4. SQL�� ����Ŭ�� ������ ����.");
			if(result == 1) {
				System.out.println("Ż�� ����.");
			}
			
			//System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int update(MemberVO bag) {
		
		int result = 0;
		
		try {
			// 1.����Ŭ 11g�� ������ ��ǰ ����
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. ����Ŭ�� �ڹ� ������ ��ǰ ���� ����.");
//			Locale.setDefault(Locale.US); //�� locale�������� �е鸸!!!
			
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
			
			String sql = "update hr.MEMBER set tel = ? where id = ?";
			PreparedStatement ps = con.prepareStatement(sql); //PreparedStatement
			ps.setString(1, bag.getTel());
			ps.setString(2, bag.getId());
			//con��ǰ���� sql��Ʈ���� �ִ� �� SQL��ǰ���� ������ּ���.
			System.out.println("3. SQL�� ��ǰ(��ü)���� ������ֱ� ����.");
			
			result = ps.executeUpdate();  //insert, update, delete����!! sql�� �������� int
			System.out.println("4. SQL�� ����Ŭ�� ������ ����.");
			if (result == 1) {
				System.out.println("ȸ�� ���� ����!");
			}
			//System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	public int insert(MemberVO bag) {
		// 1. ������ �޾Ƽ� ������ �־��ּ���. MemberVO bag
		int result = 0;
		
		try {
			// 1. ����Ŭ 11g �� ������ ��ǰ ����
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. ����Ŭ�� �ڹ� ������ ��ǰ ���� ����.");
			
			// 2. ����Ŭ 11g �� �����غ��� (java --- oracle)
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system";
			String password = "oracle";
			Connection con = DriverManager.getConnection(url, user, password);//Connection
			//String data = JOptionPane.showInputDialog("�̸��Է�"); //String, �Ӿƹ��� 
			System.out.println("2.����Ŭ ���� ����.");
			
			//ipaddress ==> InetAddress
			//String url = "http://wwww.naver.com";
			//URL u = new URL(url);
			//�ڹٴ� ��ǰ�������̿���,String�� ���� ���ڿ��� Ư���� ��ǰ���� �ν����� ����.
			//Ư���� ��ǰ���� �ν��Ϸ��� �� ��ǰ���� ������־�� �Ѵ�.
			//SQL��ǰ���� ������־�� ��.
			//PreparedStatement�� SQL��ǰ!!
			
			String sql = "insert into hr.MEMBER values (?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			//con ��ǰ���� sql ��Ʈ���� �ִ°� SQL ��ǰ���� ������ּ���
			//R ����, �ε��� 0���� ����!!
			//�����ϰ� db�� �ε����� 1���� ����
			
			//2. ���濡�� ������ �ϳ��� ����������
			
			ps.setString(1, bag.getId()); // ps.setInt(1,no);
			ps.setString(2, bag.getPw()); 
			ps.setString(3, bag.getName()); 
			ps.setString(4, bag.getTel()); 
			//==> insert into hr.MEMBER values ('a','a','a','a');
			
			System.out.println("3.SQL �� ��ǰ(��ü)���� ������ֱ�");
			
			result = ps.executeUpdate();
			System.out.println("4.SQL�� ����Ŭ�� ������ ����!");
			if(result == 1){
				System.out.println("ȸ�����Լ���!!");
			}
//			System.out.println(result);
		} catch (Exception e) {
			// insert �� ����� ������ �ȵ� ���, ������ ��Ȳ�̶� �Ǵ�!
			// catch�� ����ȴ�.
			result = 0;
			e.printStackTrace();
		}
		System.out.println(result);
		return result;
		
	}
	
}