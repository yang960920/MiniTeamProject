package �ڹٿ���DB;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import ȭ�鿬��DB.PostDAO;
import ȭ�鿬��DB.PostVO;

public class PostUI {

	public static void main(String[] args) {
		
		JFrame f = new JFrame();
		f.setSize(600, 600);
		f.setLayout(new FlowLayout());
		Font font = new Font("����" , Font.ROMAN_BASELINE, 20);
		Font font2 = new Font("����",Font.BOLD , 40);
		
		JLabel top = new JLabel("-------------------------------------------------------");
		JLabel n1 = new JLabel("1",JLabel.LEFT);
		JLabel n2 = new JLabel("2",JLabel.LEFT);
		JLabel n3 = new JLabel("3",JLabel.LEFT);
		JLabel n4 = new JLabel("4",JLabel.LEFT);
		JLabel n5 = new JLabel("5",JLabel.LEFT);
		JLabel t1 = new JLabel("yang",JLabel.RIGHT);
		JLabel t2 = new JLabel("park",JLabel.RIGHT);
		JLabel t3 = new JLabel("Noh",JLabel.RIGHT);
		JLabel t4 = new JLabel("Hyun",JLabel.RIGHT);
		JLabel t5 = new JLabel("Ahn",JLabel.RIGHT);
		JLabel top1 = new JLabel("��ȣ"+"      "+"����"+"     "+"�ۼ���");
		 
		
		 
		f.getContentPane().setBackground(Color.green);
		
		JLabel but = new JLabel("-------------------------------------------------------");
		
		JButton b1 = new JButton("�����̳� ��� �ı�");
		JButton b2 = new JButton("������ ���� ��ī��");
		JButton b3 = new JButton("�Ե����� �ٳ�Ծ��!");
		JButton b4 = new JButton("���Ѱ��� �ñ״Ͽ�");
		JButton b5 = new JButton("�����쵿 ���� ���� �ձ�");
		
		
		
		
		
		
		
		b1.setBorderPainted(false);
		b2.setBorderPainted(false);
		b3.setBorderPainted(false);
		b4.setBorderPainted(false);
		b5.setBorderPainted(false);
		
		
		
		top.setFont(font);
		but.setFont(font);
		b1.setFont(font2);
		b2.setFont(font2);
		b3.setFont(font2);
		b4.setFont(font2);
		b5.setFont(font2);
		t1.setFont(font);
		t2.setFont(font);
		t3.setFont(font);
		t4.setFont(font);
		t5.setFont(font);
		n1.setFont(font2);
		n2.setFont(font2);
		n3.setFont(font2);
		n4.setFont(font2);
		n5.setFont(font2);
		top1.setFont(font2);
		
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		
		
		
		
		
		f.add(top);
		f.add(top1);
		
		f.add(n1);
		f.add(b1);
		f.add(t1);
		f.add(n2);
		f.add(b2);
		f.add(t2);
		f.add(n3);
		f.add(b3);
		f.add(t3);
		f.add(n4);
		f.add(b4);
		f.add(t4);
		f.add(n5);
		f.add(b5);
		f.add(t5);
		f.add(but);
		f.setVisible(true);
	}

}
