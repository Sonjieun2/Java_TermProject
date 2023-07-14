package termProject;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class mainMenu extends JFrame{
	public mainMenu() {
		setTitle("�Ǿ��� �ֹ�â");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);

		JLabel title = new JLabel("Tree PC");
		JButton btn1 = new JButton("ȸ�� (10%����)");  // ȸ�� �α���â �̵�
		JButton btn2 = new JButton("��ȸ��");  // ��ȸ�� �α���â �̵�
		btn1.addActionListener(new MyActionListener());
		btn2.addActionListener(new MyActionListener());
		
		title.setBounds(15, 60, 360, 50);
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setFont(new Font("�޸����I", Font.BOLD,  50));
		btn1.setBounds(20, 180, 160, 200);
		btn2.setBounds(200, 180, 160, 200);
		btn1.setFont(new Font("�޸ո���I", Font.BOLD, 16));
		btn2.setFont(new Font("�޸ո���I", Font.BOLD, 16));
		
		add(title); add(btn1); add(btn2);
		
		setLocation(550 - (getWidth()/2), 160 - getHeight()/2);
		setSize(400, 500);
		setVisible(true);
	}
	//* ��ư ���ý� �̺�Ʈ *//
	class MyActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton Btn = (JButton)e.getSource();
			if(Btn.getText().equals("ȸ�� (10%����)")) new member();
			else if(Btn.getText().equals("��ȸ��")) new nonMember();
			setVisible(false);
		}
	}
	public static void main(String[] args) {
		new mainMenu();
	}
}