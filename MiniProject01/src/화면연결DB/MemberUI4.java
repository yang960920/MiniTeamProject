package 화면연결DB;

import java.util.ArrayList;

public class MemberUI4 {

	public static void main(String[] args) {
		// 프로그램 시작하자마자 db 에서 데이터를 가지고 와서
		// 화면을 만들어 주고 싶음.
		MemberDAO3 dao = new MemberDAO3();
		ArrayList<MemberVO> list = dao.list();
		if (list.size() == 0) {
			System.out.println("검색 결과 없음.");
		}else {
			System.out.println("검색 결과는 전체 " + list.size());
			
		for (MemberVO bag : list) {
			System.out.println(bag.getId());
			System.out.println(bag.getPw());
			System.out.println(bag.getName());
			System.out.println(bag.getTel());
			System.out.println("------------");
		}
		}
		
		
	}

}
