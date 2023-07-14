package termProject;

import javax.swing.*;
import java.awt.event.*;

class JoinPrivacy extends JPanel {
	//* 생년월일 중 년도 선택시 선택지 *//
	private String [] Year = {"1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002"};
	//* 이메일 중 이메일 주소 선택지 *//
	private String [] emailType = {"naver.com", "daum.net", "nate.com", "yahoo.co.kr", "gmail.com"};
	
	public JoinPrivacy() {
		setLayout(null);
		ButtonGroup g = new ButtonGroup();  // 라디오 버튼 사용시 묶어주기 (중복 선택 안됨)
		
		JLabel name = new JLabel("이름");
		JLabel phone = new JLabel("전화번호");
		JLabel birth = new JLabel("생년월일");
		JLabel email = new JLabel("이메일");
		JLabel sex = new JLabel("성별");
		JLabel ID = new JLabel("ID");
		JLabel PW = new JLabel("PW");
		JLabel hyphen1 = new JLabel("  -");
		JLabel hyphen2 = new JLabel("  -");
		JLabel snail = new JLabel(" @");
		
		JTextField nameText = new JTextField();  // 이름 입력창
		JTextField phoneNum1 = new JTextField();  // 핸드폰 번호 입력창
		JTextField phoneNum2 = new JTextField();
		JTextField phoneNum3 = new JTextField();
		JTextField month = new JTextField();  // 생년월일 중 월 입력창
		JTextField day = new JTextField();  // 생년월일 중 일 입력창
		JTextField mail = new JTextField();  // 이메일 앞부분 입력창(아이디?)
		JTextField IdText = new JTextField();  // 아이디 입력창
		JPasswordField pw = new JPasswordField();  // 비밀번호 입력창
		JComboBox<String> birthYear = new JComboBox<String>(Year);  // 생일 년도 선택창
		JComboBox<String> emailCombo = new JComboBox<String>(emailType);  // 이메일 주소 선택창
		JRadioButton girl = new JRadioButton("여");
		JRadioButton boy = new JRadioButton("남");
		
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
		//* 버튼 그룹 만든거에 라디오 버튼 넣어주기 *//
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
		setTitle("회원 가입");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		JButton IDSave = new JButton("중복확인");   // 아이디 중복확인 다이얼로그 나타남
		JButton next = new JButton("회원 가입");  // 로그인창으로 이동 가능한 버튼
		IDSave.setBounds(220, 260, 90, 20);
		next.setBounds(90, 380, 200, 50);
		next.addActionListener(new MyActionListener());
		
		add(new JoinPrivacy());
		add(IDSave); add(next);
		
		setLocation(550 - (getWidth()/2), 160 - getHeight()/2);
		setSize(400, 500);
		setVisible(true);
		
		//* 중복확인 다이얼로그 *//
		IDSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "사용 가능한 아이디입니다.", "중복 확인", JOptionPane.WARNING_MESSAGE);
			}
		});
	}
	//* 버튼 선택시 이벤트 *//
	class MyActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton Btn = (JButton)e.getSource();
			if(Btn.getText().equals("회원 가입")) new member();
			setVisible(false);
		}
	}
	public static void main(String [] args) {
		new join();
	}
}