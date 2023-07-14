package termProject;

import java.awt.*;
import javax.swing.*;

import java.awt.event.*;

public class orderScreen extends JFrame {
	JFrame paymentScreen, CardPay;  
	JPanel main_panel, a, b, c, d, e;
	CardLayout card = new CardLayout();
	JButton choose, reset, payment, finish, settle;
	JRadioButton memberOne, memberThree, nonmemberOne, nonmemberThree;
	JCheckBox noodle1, noodle2, noodle3, noodle4, noodle5, noodle6;
	JTextArea total, select, pick, money;
	int sum = 0;
	String helpContents = "===== 음식 주문하는 방법 =====\n\n1. 원하는 음식을 원하는 개수만큼 클릭한 뒤 <선택완료>버튼을 누른다.\n"
			+ "2. 가격과 선택한 내용을 확인한 뒤 다시 담으려면 <초기화> 버튼을 누른다.\n"
			+ "3. <결제> 버튼을 눌러 결제창으로 넘어간다.\n\n"
			+ "===== 시간 추가하는 방법 =====\n\n"
			+ "1. 회원/비회원을 선택한 뒤 원하는 시간을 누른다.\n"
			+ "2. 자신이 선택한 내용을 확인한 후 <초기화> 또는 <결제>  버튼을 누른다.\n"
			+ "*음식과 함께 결제가 가능하다.";
	
	public orderScreen() {
		setTitle("메뉴 주문");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//* a = 고른내역 총금액, 초기화버튼, 결제버튼이 나타나는 창 (선택완료 버튼을 누르면 나타남) *//
		a = new JPanel();
		a.setLayout(null);
		total = new JTextArea();
		total.setEditable(false);
		reset = new JButton("초기화");
		payment = new JButton("다음");
		
		total.setBounds(15, 370, 70, 20);
		reset.setBounds(100, 370, 130, 50);
		payment.setBounds(240, 370, 130, 50);
		
		reset.addActionListener(new MyActionListener());
		payment.addActionListener(new MyActionListener());
		
		a.add(total); a.add(reset); a.add(payment);
		a.setSize(400, 170);
		a.setVisible(false);
		//* 메뉴 중 라면 고르는 화면 *//
		b = new JPanel();
		b.setLayout(null);
		
		ImageIcon noodle1Icon = new ImageIcon("images/불닭볶음면.jpg");
		ImageIcon noodle2Icon = new ImageIcon("images/신라면.jpg");
		ImageIcon noodle3Icon = new ImageIcon("images/짜파게티.jpg");
		ImageIcon noodle4Icon = new ImageIcon("images/육개장.jpg");
		ImageIcon noodle5Icon = new ImageIcon("images/라볶이.jpg");
		ImageIcon noodle6Icon = new ImageIcon("images/치즈.jpg");
		
	    noodle1 = new JCheckBox("불닭볶음면", noodle1Icon); noodle2 = new JCheckBox("신라면", noodle2Icon);
	    noodle3 = new JCheckBox("짜파게티", noodle3Icon); noodle4 = new JCheckBox("육개장", noodle4Icon);
	    noodle5 = new JCheckBox("라볶이", noodle5Icon); noodle6 = new JCheckBox("치즈추가", noodle6Icon);
	    
	    noodle1.setBounds(15, 0, 120, 100); noodle2.setBounds(135, 0, 120, 100);
	    noodle3.setBounds(255, 0, 120, 100); noodle4.setBounds(15, 120, 120, 100);
	    noodle5.setBounds(135, 120, 120, 100); noodle6.setBounds(255, 120, 120, 100);
	    
	    JLabel Pay1 = new JLabel("1,500원"); JLabel Pay2 = new JLabel("1,000원");
	    JLabel Pay3 = new JLabel("1,000원"); JLabel Pay4 = new JLabel("800원");
	    JLabel Pay5 = new JLabel("1,200원"); JLabel Pay6 = new JLabel("1,000원");
	    Pay1.setHorizontalAlignment(JLabel.CENTER); Pay2.setHorizontalAlignment(JLabel.CENTER);
	    Pay3.setHorizontalAlignment(JLabel.CENTER); Pay4.setHorizontalAlignment(JLabel.CENTER);
	    Pay5.setHorizontalAlignment(JLabel.CENTER); Pay6.setHorizontalAlignment(JLabel.CENTER);
	      
	    Pay1.setBounds(15, 105, 120, 10); Pay2.setBounds(135, 105, 120, 10);
	    Pay3.setBounds(255, 105, 120, 10); Pay4.setBounds(15, 230, 120, 10);
	    Pay5.setBounds(135, 230, 120, 10); Pay6.setBounds(255, 230, 120, 10);
	    
	    b.add(noodle1); b.add(noodle2); b.add(noodle3);
	    b.add(noodle4); b.add(noodle5); b.add(noodle6);
	    b.add(Pay1); b.add(Pay2); b.add(Pay3); b.add(Pay4); b.add(Pay5); b.add(Pay6); 
	    
	    b.setSize(400, 330);
	    MyItemListener listener = new MyItemListener();
	    noodle1.addItemListener(listener); noodle2.addItemListener(listener);
	    noodle3.addItemListener(listener); noodle4.addItemListener(listener);
	    noodle5.addItemListener(listener); noodle6.addItemListener(listener);
	    //* 라면을 눌렀을 때 어떤걸 선택했는지 select 창에 나타남 *//

	    //* 회원일 때 시간 추가하는 화면 *//
		ButtonGroup group1 = new ButtonGroup();    
	    c = new JPanel();
	    c.setLayout(null);
	    memberOne = new JRadioButton("1시간 추가 (1,000원)");
	    memberThree = new JRadioButton("3시간 추가 (2,700원)");
	    memberOne.setBounds(15, 10, 360, 110);
	    memberThree.setBounds(15, 130, 360, 110);
	    group1.add(memberOne); group1.add(memberThree);
	    c.add(memberOne); c.add(memberThree);
	    c.setSize(400, 330);
	    memberOne.addItemListener(listener); memberThree.addItemListener(listener);
	    //* 원하는 시간을 선택하면 라면처럼 select창에 나타남 *//

	    //* 비회원일 때 시간 추가 선택하는 화면 *//
	    ButtonGroup group2 = new ButtonGroup();
	    d = new JPanel();
	    d.setLayout(null);
	    nonmemberOne = new JRadioButton("1시간 추가 (1,500원)");
	    nonmemberThree = new JRadioButton("3시간 추가 (4,000원)");
	    nonmemberOne.setBounds(15, 10, 360, 110);
	    nonmemberThree.setBounds(15, 130, 360, 110);
	    group2.add(nonmemberOne); group2.add(nonmemberThree);
	    d.add(nonmemberOne); d.add(nonmemberThree);
	    d.setSize(400, 330);
	    nonmemberOne.addItemListener(listener); nonmemberThree.addItemListener(listener);
	    //* 선택한 내역을 라면처럼 select에 표시 *//

	    //* 도움말 메뉴를 누르면 나타나는 화면 *//
	    e = new JPanel();
	    e.setLayout(null);
	    JTextArea helpScreen = new JTextArea();
	    helpScreen.setEditable(false);
	    helpScreen.setBounds(0, 10, 400, 230);
	    helpScreen.setText(helpContents);
	    e.add(helpScreen);
	    e.setSize(400, 230);
	    
	    createMenu();  // 메뉴를 만들어내는 함수
	    
	    choose = new JButton("선택완료");   // 누르면 아래에 a판넬이 나타남
		select = new JTextArea();  // 사용자가 선택한 내역이 나타남
		select.setEditable(false);
		select.setLineWrap(true);  // 자동으로 한 줄 띄우는 기능
	    choose.setBounds(15, 340, 360, 20);;
		select.setBounds(15, 250, 360, 80);
		choose.addActionListener(new MyActionListener());  // 버튼 누르기 활성화
	    add(select); 	 add(choose);
	    
	    main_panel = new JPanel();
	    main_panel.setSize(400, 330);
	    main_panel.setLayout(card);
	    main_panel.add("라면메뉴", b);   // 메뉴바에서 해당 판넬을 저장한 메뉴를 선택하면 그 판넬이 화면에 나타남
	    main_panel.add("회원시간추가", c);
	    main_panel.add("비회원시간추가", d);
	    main_panel.add("도움말", e);
	    add(main_panel);
	    add(a);
	    
	    setLocation(550 - (getWidth()/2), 160 - getHeight()/2);
	    setSize(400, 500);
	    setVisible(true);
	    
	    //* 마지막으로 고른 내역과 결제 여부를 결정하는 창 *//
	    paymentScreen = new JFrame();
	    paymentScreen.setTitle("결제창");
	    paymentScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    paymentScreen.setLayout(null);
	    
		JLabel title = new JLabel("결제 확인창");
		pick= new JTextArea();   // 전에 고른 내역들 가져와서 나타내는 창
		money = new JTextArea();
		settle = new JButton("결제");   // 최종적으로 결제를 확인하는 버튼
		title.setHorizontalAlignment(JLabel.CENTER);   // 글씨 가운데로 정렬
		title.setBounds(15, 10, 360, 50);
		pick.setBounds(15, 70, 360, 330);
		money.setBounds(15, 405, 120, 50);
		settle.setBounds(230, 405, 140, 50);
		pick.setEditable(false);   // 입력 방지
		money.setEditable(false);

		paymentScreen.add(title); paymentScreen.add(pick);
		paymentScreen.add(money); paymentScreen.add(settle);
		settle.addActionListener(new MyActionListener());
		
		paymentScreen.setLocation(750 - (getWidth()/2), 410 - getHeight()/2);
		paymentScreen.setSize(400, 500);
		paymentScreen.setVisible(false);
		
		//* 마지막으로 카드 결제가 진행되는 프레임 *//
	    CardPay = new JFrame();
	    CardPay.setTitle("카드결제");
	    CardPay.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    CardPay.setLayout(null);
	    
	    ImageIcon image = new ImageIcon("images/카드.Png");
	    JLabel CardImg = new JLabel(image);
	    CardImg.setBounds(15, 10, 260, 260);
	    JLabel text = new JLabel("결제 진행중입니다.");
	    finish = new JButton("결제 완료");
	    text.setHorizontalAlignment(JLabel.CENTER);    // 글씨 가운데로 정렬
	    text.setBounds(15, 280, 260, 20);
	    finish.setBounds(45, 310, 200, 40);
	    finish.addActionListener(new MyActionListener());
	    
	    CardPay.setLocation(800 - (getWidth()/2), 450 - getHeight()/2);
	    CardPay.add(text); CardPay.add(finish);
	    CardPay.add(CardImg);
	    CardPay.setSize(300, 400);
	    CardPay.setVisible(false);
	    
	}
	//* 고른 물건에 따라 가격 저장한 뒤에 총금액 부분에 표시하기 *//
	class MyItemListener implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			if(e.getStateChange()==ItemEvent.SELECTED) {
				if(e.getItem() == noodle1) {
					select.append("불닭볶음면 : 1,500원\n"); sum += 1500;
				}
				else if(e.getItem() == noodle2) {
					select.append("신라면 : 1,000원\n"); sum += 1000;
				}
				else if(e.getItem() == noodle3) {
					select.append("짜파게티 : 1,000원\n"); sum += 1000;
				}
				else if(e.getItem() == noodle4) {
					select.append("육개장 : 800원\n"); sum += 800;
				}
				else if(e.getItem() == noodle5) {
					select.append("라볶이 : 1,200원\n"); sum += 1200;
				}
				else if(e.getItem() == noodle6) {
					select.append("치즈추가 : 1,000원\n"); sum += 1000;
				}
				else if(e.getItem() == memberOne) {
					select.append("1시간 추가(회원) : 1,000원\n"); sum += 1000;
				}
				else if(e.getItem() == memberThree) {
					select.append("3시간 추가(회원) : 2,700원\n"); sum += 2700;
				}
				else if(e.getItem() == nonmemberOne) {
					select.append("1시간 추가(비회원) : 1,500원\n"); sum += 1500;
				}
				else if(e.getItem() == nonmemberThree) {
					select.append("3시간 추가(비회원) : 4,000원\n"); sum += 4000;
				}
			}
			else {
				if(e.getItem() == noodle1) {
					select.append("-삭제- 불닭볶음면 : 1,500원\n"); sum -= 1500;
				}
				else if(e.getItem() == noodle2) {
					select.append("-삭제- 신라면 : 1,000원\n"); sum -= 1000;
				}
				else if(e.getItem() == noodle3) {
					select.append("-삭제- 짜파게티 : 1,000원\n"); sum -= 1000;
				}
				else if(e.getItem() == noodle4) {
					select.append("-삭제- 육개장 : 800원\n"); sum -= 800;
				}
				else if(e.getItem() == noodle5) {
					select.append("-삭제- 라볶이 : 1,200원\n"); sum -= 1200;
				}
				else if(e.getItem() == noodle6) {
					select.append("-삭제- 치즈추가 : 1,000원\n"); sum -= 1000;
				}
				else if(e.getItem() == memberOne) {
					select.append("-삭제- 1시간 추가(회원) : 1,000원\n"); sum -= 1000;
				}
				else if(e.getItem() == memberThree) {
					select.append("-삭제- 3시간 추가(회원) : 2,700원\n"); sum -= 2700;
				}
				else if(e.getItem() == nonmemberOne) {
					select.append("-삭제- 1시간 추가(비회원) : 1,500원\n"); sum -= 1500;
				}
				else if(e.getItem() == nonmemberThree) {
					select.append("-삭제- 3시간 추가(회원) : 4,000원\n"); sum -= 4000;
				}
			}
			total.setText(sum+" 원");
		}
	}
	//* 메뉴바와 메뉴 구성하는 함수 *//
	private void createMenu() {
	   JMenuBar mb = new JMenuBar();
	   JMenuItem[] time = new JMenuItem[2];
	   JMenuItem food = new JMenuItem("라면");
	   JMenuItem help = new JMenuItem("도움말");
	   String[] timeItem = {"회원", "비회원"};
	      
	   JMenu foodScreen = new JMenu("음식");
	   JMenu timeScreen = new JMenu("시간추가");
	   JMenu helpScreen = new JMenu("도움말");
	   foodScreen.add(food);
	   helpScreen.add(help);
	   food.addActionListener(new MenuActionListener());
	   help.addActionListener(new MenuActionListener());
	      
	   for(int i=0 ; i<2 ; i++) {
	      time[i] = new JMenuItem(timeItem[i]);
	      timeScreen.add(time[i]);
	      timeScreen.addSeparator();
	      time[i].addActionListener(new MenuActionListener());
	   }
	   mb.add(foodScreen); mb.add(timeScreen); mb.add(helpScreen);
	   setJMenuBar(mb);
	}
	//* 버튼 클릭했을 때 이벤트 *//
	class MyActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton Btn = (JButton)e.getSource();
			if(Btn.getText().equals("결제 완료")) {   // 결제완료 버튼을 누르면 가장 처음 메인 화면으로 돌아가기
				paymentScreen.setVisible(false);
				CardPay.setVisible(false);
				new mainMenu();
			}
			else if(Btn.getText().equals("선택완료")) a.setVisible(true);   // 선택완료 누르면 밑에 총 금액과 초기화, 다음으로 넘어가는 창 나타남
			else if(Btn.getText().equals("초기화")) {  // 고른 내역이랑 총금액 초기화
				noodle1.setSelected(false); noodle2.setSelected(false); noodle3.setSelected(false);
				noodle4.setSelected(false); noodle5.setSelected(false); noodle6.setSelected(false);
				memberOne.setSelected(false); memberThree.setSelected(false);
				nonmemberOne.setSelected(false); nonmemberThree.setSelected(false);
				select.setText(""); total.setText("");
				sum = 0;
			}
			else if(Btn.getText().equals("다음")) {  // 메뉴화면에서 넘어가서 내가 고른거랑 총금액 확인창
				paymentScreen.setVisible(true);
				setVisible(false);
				pick.append(select.getText());
				money.setText(sum+"원");
			}
			else if(Btn.getText().equals("결제")) {   // 결제 마지막 물음
				int result = JOptionPane.showConfirmDialog(null, "결제 하시겠습니까?", "Confirm", JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.CLOSED_OPTION) {
					new mainMenu();
					paymentScreen.setVisible(false);
				}
				else if(result == JOptionPane.YES_OPTION) CardPay.setVisible(true);
				else {
					paymentScreen.setVisible(false);
					setVisible(true);
				}
			}
		}
	}
	//* 메뉴바에서 선택시 해당 화면으로 바뀌게 하기 *//
	class MenuActionListener implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	       String cmd = e.getActionCommand();
	       if(cmd.equals("라면")) {
	          card.show(main_panel, "라면메뉴");
	       }
	       else if(cmd.equals("회원")) {
	          card.show(main_panel, "회원시간추가");
	       }
	       else if(cmd.equals("비회원")) {
	    	   card.show(main_panel, "비회원시간추가");
	       }
	       else if(cmd.equals("도움말")) {
	    	   card.show(main_panel, "도움말");
	       }
	    }
	 }
	public static void main(String [] args) {
		new orderScreen();
	}
}