package 화면연결DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import 화면연결DB.MemberVO;

public class MemberDAO3 {
	
	public ArrayList<MemberVO> list() {
		ResultSet rs = null; //항목명 + 결과 데이터를 담고 있는 테이블 
		
		//가방들 넣어줄 큰 컨테이너 역할을 부품이 필요!
		//ArrayList<MemberVO> ==> MemberVO만 들어간 arraylist라는 의미
		ArrayList<MemberVO> list = new ArrayList<>();
		
		MemberVO bag = null;
		try {
			// 1.오라클 11g와 연결한 부품 설정
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. 오라클과 자바 연결할 부품 설정 성공.");
//			Locale.setDefault(Locale.US); //맥 locale에러나신 분들만!!!
			
			// 2.오라클 11g에 연결해보자.(java --- oracle) 
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system";
			String password = "oracle";
			Connection con = DriverManager.getConnection(url, user, password); //Connection
			//String data = JOptionPane.showInputDialog("이름입력"); //String, 임아무개 
			System.out.println("2. 오라클 연결 성공.");
			
			//ipaddress ==> InetAddress
			//String url = "http://wwww.naver.com";
			//URL u = new URL(url);
			//자바는 부품조립식이여서,String에 넣은 문자열을 특정한 부품으로 인식하지 못함.
			//특정한 부품으로 인식하려면 그 부품으로 만들어주어야 한다.
			//SQL부품으로 만들어주어야 함.
			//PreparedStatement가 SQL부품!!
			
			String sql = "select * from hr.MEMBER";
			PreparedStatement ps = con.prepareStatement(sql); //PreparedStatement
			//삭제!!!! ps.setString(1, id);
			System.out.println("3. SQL문 부품(객체)으로 만들어주기 성공.");
			
			rs = ps.executeQuery(); //select문 전송시  
			System.out.println("4. SQL문 오라클로 보내기 성공.");
			while(rs.next()) { //검색결과가 있는지 여부는 rs.next() 
				//true이면 있다라는 의미, false이면 없다라는 의미 
				//1. 검색겨로가가 있으면, 
//				System.out.println("검색결과 있음. 성공.");
				//2. 각 컬럼에서 값들을 꺼내오자. 
				String id2 = rs.getString(1); //id
				String pw = rs.getString("pw"); //pw
				String name = rs.getString(3); //name
				String tel = rs.getString(4); //tel
//				System.out.println(	id2 + " " 
//									+ pw + " " 
//									+ name + " " 
//									+ tel);
				//검색결과를 검색화면 UI부분을 주어야 함.
				//3. 가방을 만들자.
				bag = new MemberVO();
				bag.setId(id2);
				bag.setPw(pw);
				bag.setName(name);
				bag.setTel(tel);
				
				//4. list에 bag을 추가해주자.
				list.add(bag);
			}
			ps.close();
			rs.close();
			con.close();
			//System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//return id, pw, name, tel은 XXXXX!
		//return 뒤에는 반드시 여러 데이터를 묶어서 리턴해주어야 함.
		//검색결과가 있을 때는 bag에 데이터가 들어있음. 
		//검색결과가 없을 때는 bag에 무엇이 들어있나? null
		return list;
		
	}
	
	
	public int login(MemberVO bag) {
		int result =0;
		try {
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
			
			String sql = "delete from hr.MEMBER where id = ? and pw = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, bag.getId());
			ps.setString(2, bag.getPw());
			System.out.println("3. sql 문 생성 성공!!");
			
			//4. sql 문을 db 서버에 보낸다 --> 결과가 어떻게 되었는지 자바프로그램 알려줌.
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				System.out.println("로그인 성공");
				result = 1;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		return result;
	}
	
	
	public MemberVO one(String id) {
		
		ResultSet rs = null; // 항목(=필드 ,컬럼,속성)명 + 결과데이터를 담고 있는 테이블
		//기본형 정수/실수/문자/논리만 값(0)으로 초기화
		//나머지 데이터형(참조형) 주소가! 들어가있음 (null) 로 초기화
		
		// MemberVO bag 의 쓰레기값 초기화 (null)
		MemberVO bag = null;
		try {
			// 1.오라클 11g와 연결한 부품 설정
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. 오라클과 자바 연결할 부품 설정 성공.");
//			Locale.setDefault(Locale.US); //맥 locale에러나신 분들만!!!
			
			// 2.오라클 11g에 연결해보자.(java --- oracle) 
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system";
			String password = "oracle";
			Connection con = DriverManager.getConnection(url, user, password); //Connection
			//String data = JOptionPane.showInputDialog("이름입력"); //String, 임아무개 
			System.out.println("2. 오라클 연결 성공.");
			
			//ipaddress ==> InetAddress
			//String url = "http://wwww.naver.com";
			//URL u = new URL(url);
			//자바는 부품조립식이여서,String에 넣은 문자열을 특정한 부품으로 인식하지 못함.
			//특정한 부품으로 인식하려면 그 부품으로 만들어주어야 한다.
			//SQL부품으로 만들어주어야 함.
			//PreparedStatement가 SQL부품!!
			
			String sql = "select*from hr.MEMBER where id = ? ";
			PreparedStatement ps = con.prepareStatement(sql); //PreparedStatement
			ps.setString(1, id);
			//con부품으로 sql스트링에 있는 것 SQL부품으로 만들어주세요.
			System.out.println("3. SQL문 부품(객체)으로 만들어주기 성공.");
			
			rs = ps.executeQuery();  //insert, update, delete문만!! sql문 실행결과가 int
			System.out.println("4. SQL문 오라클로 보내기 성공.");
			if(rs.next()) { // 검색 결과가 있는 지 여부는 rs.next() 로 한다
				// true 이면 있다 라는 의미 , false 이면 없다 라는 의미.
				System.out.println("검색 결과 존재.");
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
				// 검색결과를 검색화면 UI 부분으로 주어야한다.
				
			}else {
				System.out.println("검색 결과 없음");
			}
			
			//System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//return id, pw,name,tel 은 XXXXXX!
		//return 뒤에는 반드시 여러 데이터를 묶어서 리턴해주어야함
		//검색결과가 있을때는 bag에 데이터가 들어있음.
		//검색결과 없을 때는 bag에 무엇이 들어있나?? Null!!
		return bag; // bag 타입을 public MemberVO 변수명(검색 원하는 변수선언) 으로 설정해줘야함!!
	}
	

	public int delete(String id) {
		
		int result = 0;
		
		try {
			// 1.오라클 11g와 연결한 부품 설정
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. 오라클과 자바 연결할 부품 설정 성공.");
//			Locale.setDefault(Locale.US); //맥 locale에러나신 분들만!!!
			
			// 2.오라클 11g에 연결해보자.(java --- oracle) 
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system";
			String password = "oracle";
			Connection con = DriverManager.getConnection(url, user, password); //Connection
			//String data = JOptionPane.showInputDialog("이름입력"); //String, 임아무개 
			System.out.println("2. 오라클 연결 성공.");
			
			//ipaddress ==> InetAddress
			//String url = "http://wwww.naver.com";
			//URL u = new URL(url);
			//자바는 부품조립식이여서,String에 넣은 문자열을 특정한 부품으로 인식하지 못함.
			//특정한 부품으로 인식하려면 그 부품으로 만들어주어야 한다.
			//SQL부품으로 만들어주어야 함.
			//PreparedStatement가 SQL부품!!
			
			String sql = "delete from hr.MEMBER where id = ? ";
			PreparedStatement ps = con.prepareStatement(sql); //PreparedStatement
			ps.setString(1, id);
			//con부품으로 sql스트링에 있는 것 SQL부품으로 만들어주세요.
			System.out.println("3. SQL문 부품(객체)으로 만들어주기 성공.");
			
			result = ps.executeUpdate();  //insert, update, delete문만!! sql문 실행결과가 int
			System.out.println("4. SQL문 오라클로 보내기 성공.");
			if(result == 1) {
				System.out.println("탈퇴 성공.");
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
			// 1.오라클 11g와 연결한 부품 설정
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. 오라클과 자바 연결할 부품 설정 성공.");
//			Locale.setDefault(Locale.US); //맥 locale에러나신 분들만!!!
			
			// 2.오라클 11g에 연결해보자.(java --- oracle) 
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system";
			String password = "oracle";
			Connection con = DriverManager.getConnection(url, user, password); //Connection
			//String data = JOptionPane.showInputDialog("이름입력"); //String, 임아무개 
			System.out.println("2. 오라클 연결 성공.");
			
			//ipaddress ==> InetAddress
			//String url = "http://wwww.naver.com";
			//URL u = new URL(url);
			//자바는 부품조립식이여서,String에 넣은 문자열을 특정한 부품으로 인식하지 못함.
			//특정한 부품으로 인식하려면 그 부품으로 만들어주어야 한다.
			//SQL부품으로 만들어주어야 함.
			//PreparedStatement가 SQL부품!!
			
			String sql = "update hr.MEMBER set tel = ? where id = ?";
			PreparedStatement ps = con.prepareStatement(sql); //PreparedStatement
			ps.setString(1, bag.getTel());
			ps.setString(2, bag.getId());
			//con부품으로 sql스트링에 있는 것 SQL부품으로 만들어주세요.
			System.out.println("3. SQL문 부품(객체)으로 만들어주기 성공.");
			
			result = ps.executeUpdate();  //insert, update, delete문만!! sql문 실행결과가 int
			System.out.println("4. SQL문 오라클로 보내기 성공.");
			if (result == 1) {
				System.out.println("회원 수정 성공!");
			}
			//System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	public int insert(MemberVO bag) {
		// 1. 가방을 받아서 변수에 넣어주세요. MemberVO bag
		int result = 0;
		
		try {
			// 1. 오라클 11g 와 연결한 부품 설정
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. 오라클과 자바 연결할 부품 설정 성공.");
			
			// 2. 오라클 11g 에 연결해보자 (java --- oracle)
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system";
			String password = "oracle";
			Connection con = DriverManager.getConnection(url, user, password);//Connection
			//String data = JOptionPane.showInputDialog("이름입력"); //String, 임아무개 
			System.out.println("2.오라클 연결 성공.");
			
			//ipaddress ==> InetAddress
			//String url = "http://wwww.naver.com";
			//URL u = new URL(url);
			//자바는 부품조립식이여서,String에 넣은 문자열을 특정한 부품으로 인식하지 못함.
			//특정한 부품으로 인식하려면 그 부품으로 만들어주어야 한다.
			//SQL부품으로 만들어주어야 함.
			//PreparedStatement가 SQL부품!!
			
			String sql = "insert into hr.MEMBER values (?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			//con 부품으로 sql 스트링에 있는것 SQL 부품으로 만들어주세요
			//R 빼고, 인덱스 0부터 시작!!
			//유일하게 db는 인덱스가 1부터 시작
			
			//2. 가방에서 값들을 하나씩 꺼내쓰세요
			
			ps.setString(1, bag.getId()); // ps.setInt(1,no);
			ps.setString(2, bag.getPw()); 
			ps.setString(3, bag.getName()); 
			ps.setString(4, bag.getTel()); 
			//==> insert into hr.MEMBER values ('a','a','a','a');
			
			System.out.println("3.SQL 문 부품(객체)으로 만들어주기");
			
			result = ps.executeUpdate();
			System.out.println("4.SQL문 오라클로 보내기 성공!");
			if(result == 1){
				System.out.println("회원가입성공!!");
			}
//			System.out.println(result);
		} catch (Exception e) {
			// insert 가 제대로 실행이 안된 경우, 위험한 상황이라 판단!
			// catch가 실행된다.
			result = 0;
			e.printStackTrace();
		}
		System.out.println(result);
		return result;
		
	}
	
}