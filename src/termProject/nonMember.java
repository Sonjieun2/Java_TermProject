package termProject;

import javax.swing.*;
import java.awt.event.*;

public class nonMember extends JFrame{
	public nonMember() {
		setTitle("��ȸ��");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		JLabel name = new JLabel("�̸�");
		JLabel phone = new JLabel("��ȭ��ȣ");
		JTextField nameText = new JTextField();
		JTextField num1 = new JTextField();
		JTextField num2 = new JTextField();
		JTextField num3 = new JTextField();
		JLabel self = new JLabel("��й�ȣ");
		JPasswordField selfnumber = new JPasswordField();
		JButton next = new JButton("��ȸ�� ����");
		
		name.setBounds(50, 110, 50, 30);
		nameText.setBounds(130, 110, 200, 30);
		phone.setBounds(50, 160, 50, 30);
		num1.setBounds(130, 160, 50, 30);
		num2.setBounds(205, 160, 50, 30);
		num3.setBounds(280, 160, 50, 30);
		self.setBounds(50, 210, 50, 30);
		selfnumber.setBounds(130, 210, 200, 30);
		next.setBounds(130, 280, 130, 30);
		
		add(name); add(nameText);
		add(phone); add(num1); add(num2); add(num3);
		add(self); add(selfnumber);
		add(next);
		
		setLocation(550 - (getWidth()/2), 160 - getHeight()/2);
		setSize(400, 500);
		setVisible(true);
		
		next.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new orderScreen();
				setVisible(false);
			}
		});
	}
	public static void main(String[] args) {
		new nonMember();
	}
}
