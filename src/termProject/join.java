package termProject;

import javax.swing.*;
import java.awt.event.*;

class JoinPrivacy extends JPanel {
	//* ������� �� �⵵ ���ý� ������ *//
	private String [] Year = {"1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002"};
	//* �̸��� �� �̸��� �ּ� ������ *//
	private String [] emailType = {"naver.com", "daum.net", "nate.com", "yahoo.co.kr", "gmail.com"};
	
	public JoinPrivacy() {
		setLayout(null);
		ButtonGroup g = new ButtonGroup();  // ���� ��ư ���� �����ֱ� (�ߺ� ���� �ȵ�)
		
		JLabel name = new JLabel("�̸�");
		JLabel phone = new JLabel("��ȭ��ȣ");
		JLabel birth = new JLabel("�������");
		JLabel email = new JLabel("�̸���");
		JLabel sex = new JLabel("����");
		JLabel ID = new JLabel("ID");
		JLabel PW = new JLabel("PW");
		JLabel hyphen1 = new JLabel("  -");
		JLabel hyphen2 = new JLabel("  -");
		JLabel snail = new JLabel(" @");
		
		JTextField nameText = new JTextField();  // �̸� �Է�â
		JTextField phoneNum1 = new JTextField();  // �ڵ��� ��ȣ �Է�â
		JTextField phoneNum2 = new JTextField();
		JTextField phoneNum3 = new JTextField();
		JTextField month = new JTextField();  // ������� �� �� �Է�â
		JTextField day = new JTextField();  // ������� �� �� �Է�â
		JTextField mail = new JTextField();  // �̸��� �պκ� �Է�â(���̵�?)
		JTextField IdText = new JTextField();  // ���̵� �Է�â
		JPasswordField pw = new JPasswordField();  // ��й�ȣ �Է�â
		JComboBox<String> birthYear = new JComboBox<String>(Year);  // ���� �⵵ ����â
		JComboBox<String> emailCombo = new JComboBox<String>(emailType);  // �̸��� �ּ� ����â
		JRadioButton girl = new JRadioButton("��");
		JRadioButton boy = new JRadioButton("��");
		
		name.setBounds(60, 60, 50, 20);
		nameText.setBounds(130, 60, 180, 20);
		phone.setBounds(60, 100, 50, 20);
		phoneNum1.setBounds(130, 100, 45, 20);
		hyphen1.setBounds(175, 100, 20, 20);
		phoneNum2.setBounds(195, 100, 45, 20);
		hyphen2.setBounds(240, 100, 20, 20);
		phoneNum3.setBounds(265, 100, 45, 20);
		birth.setBounds(60, 140, 50, 20);
		birthYear.setBounds(130, 140, 60, 20);
		month.setBounds(200, 140, 50, 20);
		day.setBounds(260, 140, 50, 20);
		email.setBounds(60, 180, 50, 20);
		mail.setBounds(130, 180, 80, 20);
		snail.setBounds(210, 180, 20, 20);
		emailCombo.setBounds(230, 180, 80, 20);
		sex.setBounds(60, 220, 50, 20);
		girl.setBounds(130, 220, 60, 20);
		boy.setBounds(210, 220, 60, 20);
		ID.setBounds(60, 260, 50, 20);
		IdText.setBounds(130, 260, 80, 20);
		PW.setBounds(60, 300, 50, 20);
		pw.setBounds(130, 300, 180, 20);
		//* ��ư �׷� ����ſ� ���� ��ư �־��ֱ� *//
		g.add(girl);
		g.add(boy);
		
		add(name); add(nameText);
		add(phone); add(phoneNum1); add(hyphen1); add(phoneNum2);
		add(hyphen2); add(phoneNum3);
		add(birth); add(birthYear); add(month); add(day);
		add(email); add(mail); add(snail); add(emailCombo);
		add(sex); add(girl); add(boy);
		add(ID); add(IdText);
		add(PW); add(pw);
		
		setSize(400, 350);
	}
}
public class join extends JFrame {
	public join() {
		setTitle("ȸ�� ����");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		JButton IDSave = new JButton("�ߺ�Ȯ��");   // ���̵� �ߺ�Ȯ�� ���̾�α� ��Ÿ��
		JButton next = new JButton("ȸ�� ����");  // �α���â���� �̵� ������ ��ư
		IDSave.setBounds(220, 260, 90, 20);
		next.setBounds(90, 380, 200, 50);
		next.addActionListener(new MyActionListener());
		
		add(new JoinPrivacy());
		add(IDSave); add(next);
		
		setLocation(550 - (getWidth()/2), 160 - getHeight()/2);
		setSize(400, 500);
		setVisible(true);
		
		//* �ߺ�Ȯ�� ���̾�α� *//
		IDSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "��� ������ ���̵��Դϴ�.", "�ߺ� Ȯ��", JOptionPane.WARNING_MESSAGE);
			}
		});
	}
	//* ��ư ���ý� �̺�Ʈ *//
	class MyActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton Btn = (JButton)e.getSource();
			if(Btn.getText().equals("ȸ�� ����")) new member();
			setVisible(false);
		}
	}
	public static void main(String [] args) {
		new join();
	}
}