package termProject;

import javax.swing.*;
import java.awt.event.*;

public class member extends JFrame {
	public member() {
		setTitle("ȸ��");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		JLabel ID = new JLabel("ID");
		JLabel PW = new JLabel("PW");
		JTextField IdField = new JTextField();   // ���̵� �Է�â
		JPasswordField PwField = new JPasswordField();  // ��й�ȣ �Է�â
		JButton LoginBtn = new JButton("�α���");  // �α��� �� ����â���� �Ѿ
		JButton PWFind = new JButton("��й�ȣ ã��");  // ��й�ȣ ã��â ����
		JButton newId = new JButton("ȸ������");  // ȸ������â ����
		
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
	//* ��ư ���ý� �̺�Ʈ *//
	class MyActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton Btn = (JButton)e.getSource();
			if(Btn.getText().equals("�α���")) new orderScreen();
			else if(Btn.getText().equals("��й�ȣ ã��")) new find();
			else if(Btn.getText().equals("ȸ������")) new join();
			setVisible(false);
		}
	}
	public static void main(String [] args) {
		new member();
	}
}