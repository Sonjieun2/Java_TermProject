package termProject;

import javax.swing.*;
import java.awt.event.*;

//* ��ư�� ������ ��Ÿ���� â (��й�ȣ �缳��â) *//
class PW extends JPanel{
	public PW() {
		setLayout(null);
		
		JLabel PwSetting = new JLabel("PW ����");
		JLabel PwConfirm = new JLabel("PW Ȯ��");
		JPasswordField Pw1 = new JPasswordField();  // �缳�� ��й�ȣ
		JPasswordField Pw2 = new JPasswordField();  // �缳�� ��й�ȣ Ȯ��
		JButton next = new JButton("��й�ȣ �缳��");  // �α���â���� �Ѿ�� ��ư
		
		PwSetting.setBounds(70, 270, 50, 20);
		Pw1.setBounds(150, 270, 150, 20);
		PwConfirm.setBounds(70, 300, 50, 20);
		Pw2.setBounds(150, 300, 150, 20);
		next.setBounds(90, 330, 200, 40);
	
		add(PwSetting); add(Pw1);
		add(PwConfirm); add(Pw2);
		add(next);
		
		setLocation(550 - (getWidth()/2), 160 - getHeight()/2);
		setSize(400, 100);
		setVisible(false);
		
		//* ��й�ȣ �缳�� ��ư�� ������ �� �缳�� ��й�ȣ�� Ȯ���� ��й�ȣ�� ������ �Ѿ�� �ƴϸ� Ʋ�ȴٴ� ���̾�α� ��� *//
		next.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String pass = new String(Pw1.getPassword());
				String passre = new String(Pw2.getPassword());
				if(pass.equals(passre)) {
					setVisible(false);
					new member();
				}
				else {
					JOptionPane.showMessageDialog(null, "Ʋ�Ƚ��ϴ�.", "��й�ȣ ��", JOptionPane.ERROR_MESSAGE);
					Pw1.setText(""); Pw2.setText("");
				}
			}
		});
	}
}
public class find extends JFrame{
	public find() {
		setTitle("��й�ȣ �缳��");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel Pw = new PW();
		JButton PhoneOk = new JButton("Ȯ��");
		PhoneOk.setBounds(290, 160, 60, 20);
		
		setLocation(550 - (getWidth()/2), 160 - getHeight()/2);
		setSize(400, 500);
		setVisible(true);
		//* �̸�, ���̵�, ��ȭ��ȣ, ������ȣ�� �Է��ϴ� Panel. ������ȣ�� ��ġ�ϸ� �������� �Ѿ��. *//
		JPanel privacy = new JPanel();
		privacy.setLayout(null);
		
		JLabel name = new JLabel("�̸�");
		JLabel ID = new JLabel("ID");
		JLabel Phone = new JLabel("��ȭ��ȣ");
		JLabel number = new JLabel("������ȣ");
		JTextField nameText = new JTextField();  // �̸� �Է�â
		JTextField IdText = new JTextField();  // ���̵� �Է�â
		JTextField Phone1 = new JTextField();  // �ڵ��� ��ȣ �Է�â
		JTextField Phone2 = new JTextField();
		JTextField Phone3 = new JTextField();
		JTextField numberText = new JTextField();  // ������ȣ �Է�â
		JButton numberOk = new JButton("����");  // ������ȣ Ȯ��
		
		name.setBounds(60, 80, 50, 20);
		nameText.setBounds(130, 80, 150, 20);
		ID.setBounds(60, 120, 50, 20);
		IdText.setBounds(130, 120, 150, 20);
		Phone.setBounds(60, 160, 50, 20);
		Phone1.setBounds(130, 160, 40, 20);
		Phone2.setBounds(185, 160, 40, 20);
		Phone3.setBounds(240, 160, 40, 20);
		number.setBounds(60, 200, 50, 20);
		numberText.setBounds(130, 200, 150, 20);
		numberOk.setBounds(290, 200, 60, 20);
		
		privacy.add(name); privacy.add(nameText);
		privacy.add(ID); privacy.add(IdText);
		privacy.add(Phone); privacy.add(Phone1); privacy.add(Phone2); privacy.add(Phone3);;
		privacy.add(number); privacy.add(numberText); privacy.add(numberOk);
		
		privacy.setSize(400, 250);
		
		//* ������ȣ Ȯ�� *//
		numberOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String certify = new String(numberText.getText());
				if(certify.equals("1234")) {
					JOptionPane.showMessageDialog(null, "Ȯ�εǾ����ϴ�.", "����Ȯ��", JOptionPane.WARNING_MESSAGE);
					Pw.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Ʋ�Ƚ��ϴ�.", "����Ȯ��", JOptionPane.WARNING_MESSAGE);
					numberText.setText("");
				}
			}
		});
		
		add(PhoneOk);
		add(privacy);
		add(Pw);
		
		//* ������ȣ ������ *//
		PhoneOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "������ȣ�� 1234", "����Ȯ��", JOptionPane.WARNING_MESSAGE);
			}
		});
	}
	public static void main(String [] args) {
		new find();
	}
}