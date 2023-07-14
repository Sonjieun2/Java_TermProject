package termProject;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class mainMenu extends JFrame{
	public mainMenu() {
		setTitle("피씨방 주문창");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);

		JLabel title = new JLabel("Tree PC");
		JButton btn1 = new JButton("회원 (10%할인)");  // 회원 로그인창 이동
		JButton btn2 = new JButton("비회원");  // 비회원 로그인창 이동
		btn1.addActionListener(new MyActionListener());
		btn2.addActionListener(new MyActionListener());
		
		title.setBounds(15, 60, 360, 50);
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setFont(new Font("휴면모음I", Font.BOLD,  50));
		btn1.setBounds(20, 180, 160, 200);
		btn2.setBounds(200, 180, 160, 200);
		btn1.setFont(new Font("휴먼모음I", Font.BOLD, 16));
		btn2.setFont(new Font("휴먼모음I", Font.BOLD, 16));
		
		add(title); add(btn1); add(btn2);
		
		setLocation(550 - (getWidth()/2), 160 - getHeight()/2);
		setSize(400, 500);
		setVisible(true);
	}
	//* 버튼 선택시 이벤트 *//
	class MyActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton Btn = (JButton)e.getSource();
			if(Btn.getText().equals("회원 (10%할인)")) new member();
			else if(Btn.getText().equals("비회원")) new nonMember();
			setVisible(false);
		}
	}
	public static void main(String[] args) {
		new mainMenu();
	}
}