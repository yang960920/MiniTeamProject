package ȭ�鿬��DB;

import java.util.ArrayList;

public class MemberUI4 {

	public static void main(String[] args) {
		// ���α׷� �������ڸ��� db ���� �����͸� ������ �ͼ�
		// ȭ���� ����� �ְ� ����.
		MemberDAO3 dao = new MemberDAO3();
		ArrayList<MemberVO> list = dao.list();
		if (list.size() == 0) {
			System.out.println("�˻� ��� ����.");
		}else {
			System.out.println("�˻� ����� ��ü " + list.size());
			
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
