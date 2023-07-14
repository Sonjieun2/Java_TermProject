package termProject;

import javax.swing.*;
import java.awt.event.*;

public class member extends JFrame {
	public member() {
		setTitle("회원");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		JLabel ID = new JLabel("ID");
		JLabel PW = new JLabel("PW");
		JTextField IdField = new JTextField();   // 아이디 입력창
		JPasswordField PwField = new JPasswordField();  // 비밀번호 입력창
		JButton LoginBtn = new JButton("로그인");  // 로그인 후 다음창으로 넘어감
		JButton PWFind = new JButton("비밀번호 찾기");  // 비밀번호 찾기창 띄우기
		JButton newId = new JButton("회원가입");  // 회원가입창 띄우기
		
		LoginBtn.addActionListener(new MyActionListener());
		PWFind.addActionListener(new MyActionListener());
		newId.addActionListener(new MyActionListener());
		
		ID.setBounds(65, 160, 50, 30);
		IdField.setBounds(100, 160, 120, 20);
		PW.setBounds(65, 190, 50, 30);
		PwField.setBounds(100, 190, 120, 20);
		LoginBtn.setBounds(235, 160, 80, 50);
		PWFind.setBounds(70, 230, 120, 30);
		newId.setBounds(205, 230, 100, 30);
		
		add(ID); add(IdField); add(PW); add(PwField);
		add(LoginBtn); add(PWFind); add(newId);
		
		setLocation(550 - (getWidth()/2), 160 - getHeight()/2);
		setSize(400, 500);
		setVisible(true);
	}
	//* 버튼 선택시 이벤트 *//
	class MyActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton Btn = (JButton)e.getSource();
			if(Btn.getText().equals("로그인")) new orderScreen();
			else if(Btn.getText().equals("비밀번호 찾기")) new find();
			else if(Btn.getText().equals("회원가입")) new join();
			setVisible(false);
		}
	}
	public static void main(String [] args) {
		new member();
	}
}