package termProject;

import javax.swing.*;
import java.awt.event.*;

//* 버튼을 누르면 나타나는 창 (비밀번호 재설정창) *//
class PW extends JPanel{
	public PW() {
		setLayout(null);
		
		JLabel PwSetting = new JLabel("PW 설정");
		JLabel PwConfirm = new JLabel("PW 확인");
		JPasswordField Pw1 = new JPasswordField();  // 재설정 비밀번호
		JPasswordField Pw2 = new JPasswordField();  // 재설정 비밀번호 확인
		JButton next = new JButton("비밀번호 재설정");  // 로그인창으로 넘어가는 버튼
		
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
		
		//* 비밀번호 재설정 버튼을 눌렀을 때 재설정 비밀번호와 확인한 비밀번호가 같으면 넘어가고 아니면 틀렸다는 다이얼로그 출력 *//
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
					JOptionPane.showMessageDialog(null, "틀렸습니다.", "비밀번호 비교", JOptionPane.ERROR_MESSAGE);
					Pw1.setText(""); Pw2.setText("");
				}
			}
		});
	}
}
public class find extends JFrame{
	public find() {
		setTitle("비밀번호 재설정");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel Pw = new PW();
		JButton PhoneOk = new JButton("확인");
		PhoneOk.setBounds(290, 160, 60, 20);
		
		setLocation(550 - (getWidth()/2), 160 - getHeight()/2);
		setSize(400, 500);
		setVisible(true);
		//* 이름, 아이디, 전화번호, 인증번호를 입력하는 Panel. 인증번호가 일치하면 다음으로 넘어간다. *//
		JPanel privacy = new JPanel();
		privacy.setLayout(null);
		
		JLabel name = new JLabel("이름");
		JLabel ID = new JLabel("ID");
		JLabel Phone = new JLabel("전화번호");
		JLabel number = new JLabel("인증번호");
		JTextField nameText = new JTextField();  // 이름 입력창
		JTextField IdText = new JTextField();  // 아이디 입력창
		JTextField Phone1 = new JTextField();  // 핸드폰 번호 입력창
		JTextField Phone2 = new JTextField();
		JTextField Phone3 = new JTextField();
		JTextField numberText = new JTextField();  // 인증번호 입력창
		JButton numberOk = new JButton("인증");  // 인증번호 확인
		
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
		
		//* 인증번호 확인 *//
		numberOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String certify = new String(numberText.getText());
				if(certify.equals("1234")) {
					JOptionPane.showMessageDialog(null, "확인되었습니다.", "인증확인", JOptionPane.WARNING_MESSAGE);
					Pw.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "틀렸습니다.", "인증확인", JOptionPane.WARNING_MESSAGE);
					numberText.setText("");
				}
			}
		});
		
		add(PhoneOk);
		add(privacy);
		add(Pw);
		
		//* 인증번호 보내기 *//
		PhoneOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "인증번호는 1234", "인증확인", JOptionPane.WARNING_MESSAGE);
			}
		});
	}
	public static void main(String [] args) {
		new find();
	}
}