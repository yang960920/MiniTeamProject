package ȭ�鿬��DB;

import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MemberUI5 {

	public static void main(String[] args) {
		// ���α׷� �������ڸ��� db ���� �����͸� ������ �ͼ�
		// ȭ���� ����� �ְ� ����.
		JFrame f = new JFrame();
		f.setSize(500, 700);
		
		
		MemberDAO3 dao = new MemberDAO3();
		ArrayList<MemberVO> list = dao.list();
		String[] header = {"���̵�", "�н�����", "�̸�", "��ȭ��ȣ"};
		Object[][] all = new String[list.size()][4];
		if (list.size() == 0) {
			System.out.println("�˻� ��� ����.");
		}else {
			System.out.println("�˻� ����� ��ü " + list.size());
			for (int i = 0; i < all.length; i++) { // list.size ���� ���� , list.size ���� ��
				all[i][0] = list.get(i).getId();
				all[i][1] = list.get(i).getPw();
				all[i][2] = list.get(i).getName();
				all[i][3] = list.get(i).getTel();
			}
			
//		for (MemberVO bag : list) {
//			System.out.println(bag.getId());
//			System.out.println(bag.getPw());
//			System.out.println(bag.getName());
//			System.out.println(bag.getTel());
//			System.out.println("------------");
		}
		JTable table = new JTable(all,header);
		JScrollPane scroll = new JScrollPane(table);
		f.setLayout(new FlowLayout());
		f.add(scroll);
		
		
		
		
		f.setVisible(true);
		}
		
}



