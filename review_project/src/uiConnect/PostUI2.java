package 자바연결DB;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import 화면연결DB.PostDAO;
import 화면연결DB.PostDAO2;
import 화면연결DB.PostVO;
import 화면연결DB.PostVO2;

public class PostUI2 {

	public void open() {
		JFrame f = new JFrame();
		f.setTitle("나의 게시판 화면");
		f.setSize(1150, 900);

		JLabel l2 = new JLabel("게시판 번호");
		JLabel l3 = new JLabel("게시판 제목");
		JLabel l4 = new JLabel("게시판 내용");
		JLabel l5 = new JLabel("게시판 작성자");
		JLabel l6 = new JLabel("별점");

		JTextField t1 = new JTextField(5);
		JTextField t2 = new JTextField(10);
		JTextArea t3 = new JTextArea("", 10, 20);
		JTextField t4 = new JTextField(10);
		JTextField t5 = new JTextField(10);

		JButton b1 = new JButton("게시판 글쓰기 처리");
		JButton b2 = new JButton("게시판 지우기 처리");
		JButton b3 = new JButton("게시판 수정 처리");
		JButton b4 = new JButton("게시판 검색 처리");
		JButton b5 = new JButton("댓글 보기");

		// f에 위에 있는 요소들을 add로 붙여주어야하는데,
		// 붙이는 순서대로 물흐르듯이 붙여주고 싶음.
		// 물흐르듯이 붙여주는 부품이 필요
		FlowLayout flow = new FlowLayout();

		// 폰트를 설정하기 위해 font부품 필요
		Font font = new Font("궁서", Font.BOLD, 40);

		// 게시판 글쓰기 처리

		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("회원가입처리");
				String no = t1.getText();
				String title = t2.getText();
				String content = t3.getText();
				String writer = t4.getText();
				String score = t5.getText();// ""
				int no2 = Integer.parseInt(no);
				int score2 = Integer.parseInt(score);
				
				if (title.equals("")) { // 기본형 4가지만 == 연산자를 사용가능하다~
					JOptionPane.showMessageDialog(f, "게시물 제목은 필수입력 항목입니다");
				}

				PostDAO2 dao = new PostDAO2();
				PostVO2 bag = new PostVO2();
				bag.setPost_no(no2);
				bag.setTitle(title);
				bag.setContent(content);
				bag.setWriter(writer);
				bag.setScore(score2);
				bag.setPlace_code("1111");
				int result = dao.insert(bag);
				if (result == 1) {
					JOptionPane.showMessageDialog(f, "글쓰기 성공!!");
				} else {
					JOptionPane.showMessageDialog(f, "글쓰기 실패!! 재입력해주세요.");
					t1.setText("");
					t2.setText("");
					t3.setText("");
					t4.setText("");
				}
			}// action
		});// b1

		b2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String id = t1.getText();
				
				int id2 = Integer.parseInt(id);
				PostDAO2 dao = new PostDAO2();
				int result = dao.delete(id2);
				if (result == 1) {
					JOptionPane.showMessageDialog(f, "지우기 성공");
					t1.setText("");
				} else {
					JOptionPane.showMessageDialog(f, "지우기 실패!!, 게시판 번호 를 확인해주세요");
					t1.setText("");
				}
			}// action
		});// b1

		// 게시판 수정기능
		b3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("회원가입처리");
				String no = t1.getText();
				String title = t4.getText(); // ""
				
				int no2 = Integer.parseInt(no);
				PostDAO2 dao = new PostDAO2();
				PostVO2 bag = new PostVO2();
				bag.setPost_no(no2);
				bag.setTitle(title);
				int result = dao.update(bag);
				;
				if (result == 1) {
					JOptionPane.showMessageDialog(f, "수정성공");
				} else {
					JOptionPane.showMessageDialog(f, "수정 실패!!, 게시물번호 를 확인해주세요");
				}
			}// action
		});// b1

		// 글쓰기 검색 처리

		b4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("회원검색처리");
				String no = t1.getText();
				int no2 = Integer.parseInt(no);
				PostDAO dao = new PostDAO();
				PostVO bag = dao.one(no2);
				if (bag != null) {
					t2.setText(bag.getTitle());
					t3.setText(bag.getContent());
					t4.setText(bag.getWriter());
					t2.setBackground(Color.pink);
					t3.setBackground(Color.pink);
					t4.setBackground(Color.pink);
				} else {
					t2.setText("");
					t3.setText("");
					t4.setText("");
					JOptionPane.showMessageDialog(f, "검색결과 없음");
				}

			}// action
		});// b4
		
		b5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// Comment 연결
				
			}
		});

		//////////// 필요한 부품(객체)를 ram에 가져다 놓고, 준비 끝 ///////
		/// 조립을 시작해보자. ///
		f.setLayout(flow);

//		f.add(l1);
		f.add(l2);
		f.add(t1);
		f.add(l3);
		f.add(t2);
		f.add(l4);
		f.add(t3);
		f.add(l5);
		f.add(t4);
		f.add(l6);
		f.add(t5);		
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(b4);
		f.add(b5);

//		l1.setFont(font);
		l2.setFont(font);
		l3.setFont(font);
		l4.setFont(font);
		l5.setFont(font);
		l6.setFont(font);
		t1.setFont(font);
		t2.setFont(font);
		t3.setFont(font);
		t4.setFont(font);
		t5.setFont(font);
		b1.setFont(font);
		b2.setFont(font);
		b3.setFont(font);
		b4.setFont(font);
		b5.setFont(font);

		t1.setBackground(Color.yellow);
		t1.setForeground(Color.red);
		t2.setBackground(Color.yellow);
		t2.setForeground(Color.red);
		t3.setBackground(Color.yellow);
		t3.setForeground(Color.red);
		t4.setBackground(Color.yellow);
		t4.setForeground(Color.red);
		t5.setBackground(Color.yellow);
		t5.setForeground(Color.red);

		b1.setBackground(Color.pink); // 배경색
		b1.setForeground(Color.blue); // 글자색
		b2.setBackground(Color.pink);
		b2.setForeground(Color.blue);
		b3.setBackground(Color.pink);
		b3.setForeground(Color.blue);
		b4.setBackground(Color.pink);
		b4.setForeground(Color.blue);
		b5.setBackground(Color.pink);
		b5.setForeground(Color.blue);

		f.getContentPane().setBackground(Color.pink);
		// 맨 끝으로~~~~~
		f.setVisible(true);

	}

}