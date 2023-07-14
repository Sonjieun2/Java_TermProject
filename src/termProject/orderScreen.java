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
	String helpContents = "===== ���� �ֹ��ϴ� ��� =====\n\n1. ���ϴ� ������ ���ϴ� ������ŭ Ŭ���� �� <���ÿϷ�>��ư�� ������.\n"
			+ "2. ���ݰ� ������ ������ Ȯ���� �� �ٽ� �������� <�ʱ�ȭ> ��ư�� ������.\n"
			+ "3. <����> ��ư�� ���� ����â���� �Ѿ��.\n\n"
			+ "===== �ð� �߰��ϴ� ��� =====\n\n"
			+ "1. ȸ��/��ȸ���� ������ �� ���ϴ� �ð��� ������.\n"
			+ "2. �ڽ��� ������ ������ Ȯ���� �� <�ʱ�ȭ> �Ǵ� <����>  ��ư�� ������.\n"
			+ "*���İ� �Բ� ������ �����ϴ�.";
	
	public orderScreen() {
		setTitle("�޴� �ֹ�");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//* a = ������ �ѱݾ�, �ʱ�ȭ��ư, ������ư�� ��Ÿ���� â (���ÿϷ� ��ư�� ������ ��Ÿ��) *//
		a = new JPanel();
		a.setLayout(null);
		total = new JTextArea();
		total.setEditable(false);
		reset = new JButton("�ʱ�ȭ");
		payment = new JButton("����");
		
		total.setBounds(15, 370, 70, 20);
		reset.setBounds(100, 370, 130, 50);
		payment.setBounds(240, 370, 130, 50);
		
		reset.addActionListener(new MyActionListener());
		payment.addActionListener(new MyActionListener());
		
		a.add(total); a.add(reset); a.add(payment);
		a.setSize(400, 170);
		a.setVisible(false);
		//* �޴� �� ��� ���� ȭ�� *//
		b = new JPanel();
		b.setLayout(null);
		
		ImageIcon noodle1Icon = new ImageIcon("images/�Ҵߺ�����.jpg");
		ImageIcon noodle2Icon = new ImageIcon("images/�Ŷ��.jpg");
		ImageIcon noodle3Icon = new ImageIcon("images/¥�İ�Ƽ.jpg");
		ImageIcon noodle4Icon = new ImageIcon("images/������.jpg");
		ImageIcon noodle5Icon = new ImageIcon("images/����.jpg");
		ImageIcon noodle6Icon = new ImageIcon("images/ġ��.jpg");
		
	    noodle1 = new JCheckBox("�Ҵߺ�����", noodle1Icon); noodle2 = new JCheckBox("�Ŷ��", noodle2Icon);
	    noodle3 = new JCheckBox("¥�İ�Ƽ", noodle3Icon); noodle4 = new JCheckBox("������", noodle4Icon);
	    noodle5 = new JCheckBox("����", noodle5Icon); noodle6 = new JCheckBox("ġ���߰�", noodle6Icon);
	    
	    noodle1.setBounds(15, 0, 120, 100); noodle2.setBounds(135, 0, 120, 100);
	    noodle3.setBounds(255, 0, 120, 100); noodle4.setBounds(15, 120, 120, 100);
	    noodle5.setBounds(135, 120, 120, 100); noodle6.setBounds(255, 120, 120, 100);
	    
	    JLabel Pay1 = new JLabel("1,500��"); JLabel Pay2 = new JLabel("1,000��");
	    JLabel Pay3 = new JLabel("1,000��"); JLabel Pay4 = new JLabel("800��");
	    JLabel Pay5 = new JLabel("1,200��"); JLabel Pay6 = new JLabel("1,000��");
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
	    //* ����� ������ �� ��� �����ߴ��� select â�� ��Ÿ�� *//

	    //* ȸ���� �� �ð� �߰��ϴ� ȭ�� *//
		ButtonGroup group1 = new ButtonGroup();    
	    c = new JPanel();
	    c.setLayout(null);
	    memberOne = new JRadioButton("1�ð� �߰� (1,000��)");
	    memberThree = new JRadioButton("3�ð� �߰� (2,700��)");
	    memberOne.setBounds(15, 10, 360, 110);
	    memberThree.setBounds(15, 130, 360, 110);
	    group1.add(memberOne); group1.add(memberThree);
	    c.add(memberOne); c.add(memberThree);
	    c.setSize(400, 330);
	    memberOne.addItemListener(listener); memberThree.addItemListener(listener);
	    //* ���ϴ� �ð��� �����ϸ� ���ó�� selectâ�� ��Ÿ�� *//

	    //* ��ȸ���� �� �ð� �߰� �����ϴ� ȭ�� *//
	    ButtonGroup group2 = new ButtonGroup();
	    d = new JPanel();
	    d.setLayout(null);
	    nonmemberOne = new JRadioButton("1�ð� �߰� (1,500��)");
	    nonmemberThree = new JRadioButton("3�ð� �߰� (4,000��)");
	    nonmemberOne.setBounds(15, 10, 360, 110);
	    nonmemberThree.setBounds(15, 130, 360, 110);
	    group2.add(nonmemberOne); group2.add(nonmemberThree);
	    d.add(nonmemberOne); d.add(nonmemberThree);
	    d.setSize(400, 330);
	    nonmemberOne.addItemListener(listener); nonmemberThree.addItemListener(listener);
	    //* ������ ������ ���ó�� select�� ǥ�� *//

	    //* ���� �޴��� ������ ��Ÿ���� ȭ�� *//
	    e = new JPanel();
	    e.setLayout(null);
	    JTextArea helpScreen = new JTextArea();
	    helpScreen.setEditable(false);
	    helpScreen.setBounds(0, 10, 400, 230);
	    helpScreen.setText(helpContents);
	    e.add(helpScreen);
	    e.setSize(400, 230);
	    
	    createMenu();  // �޴��� ������ �Լ�
	    
	    choose = new JButton("���ÿϷ�");   // ������ �Ʒ��� a�ǳ��� ��Ÿ��
		select = new JTextArea();  // ����ڰ� ������ ������ ��Ÿ��
		select.setEditable(false);
		select.setLineWrap(true);  // �ڵ����� �� �� ���� ���
	    choose.setBounds(15, 340, 360, 20);;
		select.setBounds(15, 250, 360, 80);
		choose.addActionListener(new MyActionListener());  // ��ư ������ Ȱ��ȭ
	    add(select); 	 add(choose);
	    
	    main_panel = new JPanel();
	    main_panel.setSize(400, 330);
	    main_panel.setLayout(card);
	    main_panel.add("���޴�", b);   // �޴��ٿ��� �ش� �ǳ��� ������ �޴��� �����ϸ� �� �ǳ��� ȭ�鿡 ��Ÿ��
	    main_panel.add("ȸ���ð��߰�", c);
	    main_panel.add("��ȸ���ð��߰�", d);
	    main_panel.add("����", e);
	    add(main_panel);
	    add(a);
	    
	    setLocation(550 - (getWidth()/2), 160 - getHeight()/2);
	    setSize(400, 500);
	    setVisible(true);
	    
	    //* ���������� �� ������ ���� ���θ� �����ϴ� â *//
	    paymentScreen = new JFrame();
	    paymentScreen.setTitle("����â");
	    paymentScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    paymentScreen.setLayout(null);
	    
		JLabel title = new JLabel("���� Ȯ��â");
		pick= new JTextArea();   // ���� �� ������ �����ͼ� ��Ÿ���� â
		money = new JTextArea();
		settle = new JButton("����");   // ���������� ������ Ȯ���ϴ� ��ư
		title.setHorizontalAlignment(JLabel.CENTER);   // �۾� ����� ����
		title.setBounds(15, 10, 360, 50);
		pick.setBounds(15, 70, 360, 330);
		money.setBounds(15, 405, 120, 50);
		settle.setBounds(230, 405, 140, 50);
		pick.setEditable(false);   // �Է� ����
		money.setEditable(false);

		paymentScreen.add(title); paymentScreen.add(pick);
		paymentScreen.add(money); paymentScreen.add(settle);
		settle.addActionListener(new MyActionListener());
		
		paymentScreen.setLocation(750 - (getWidth()/2), 410 - getHeight()/2);
		paymentScreen.setSize(400, 500);
		paymentScreen.setVisible(false);
		
		//* ���������� ī�� ������ ����Ǵ� ������ *//
	    CardPay = new JFrame();
	    CardPay.setTitle("ī�����");
	    CardPay.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    CardPay.setLayout(null);
	    
	    ImageIcon image = new ImageIcon("images/ī��.Png");
	    JLabel CardImg = new JLabel(image);
	    CardImg.setBounds(15, 10, 260, 260);
	    JLabel text = new JLabel("���� �������Դϴ�.");
	    finish = new JButton("���� �Ϸ�");
	    text.setHorizontalAlignment(JLabel.CENTER);    // �۾� ����� ����
	    text.setBounds(15, 280, 260, 20);
	    finish.setBounds(45, 310, 200, 40);
	    finish.addActionListener(new MyActionListener());
	    
	    CardPay.setLocation(800 - (getWidth()/2), 450 - getHeight()/2);
	    CardPay.add(text); CardPay.add(finish);
	    CardPay.add(CardImg);
	    CardPay.setSize(300, 400);
	    CardPay.setVisible(false);
	    
	}
	//* �� ���ǿ� ���� ���� ������ �ڿ� �ѱݾ� �κп� ǥ���ϱ� *//
	class MyItemListener implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			if(e.getStateChange()==ItemEvent.SELECTED) {
				if(e.getItem() == noodle1) {
					select.append("�Ҵߺ����� : 1,500��\n"); sum += 1500;
				}
				else if(e.getItem() == noodle2) {
					select.append("�Ŷ�� : 1,000��\n"); sum += 1000;
				}
				else if(e.getItem() == noodle3) {
					select.append("¥�İ�Ƽ : 1,000��\n"); sum += 1000;
				}
				else if(e.getItem() == noodle4) {
					select.append("������ : 800��\n"); sum += 800;
				}
				else if(e.getItem() == noodle5) {
					select.append("���� : 1,200��\n"); sum += 1200;
				}
				else if(e.getItem() == noodle6) {
					select.append("ġ���߰� : 1,000��\n"); sum += 1000;
				}
				else if(e.getItem() == memberOne) {
					select.append("1�ð� �߰�(ȸ��) : 1,000��\n"); sum += 1000;
				}
				else if(e.getItem() == memberThree) {
					select.append("3�ð� �߰�(ȸ��) : 2,700��\n"); sum += 2700;
				}
				else if(e.getItem() == nonmemberOne) {
					select.append("1�ð� �߰�(��ȸ��) : 1,500��\n"); sum += 1500;
				}
				else if(e.getItem() == nonmemberThree) {
					select.append("3�ð� �߰�(��ȸ��) : 4,000��\n"); sum += 4000;
				}
			}
			else {
				if(e.getItem() == noodle1) {
					select.append("-����- �Ҵߺ����� : 1,500��\n"); sum -= 1500;
				}
				else if(e.getItem() == noodle2) {
					select.append("-����- �Ŷ�� : 1,000��\n"); sum -= 1000;
				}
				else if(e.getItem() == noodle3) {
					select.append("-����- ¥�İ�Ƽ : 1,000��\n"); sum -= 1000;
				}
				else if(e.getItem() == noodle4) {
					select.append("-����- ������ : 800��\n"); sum -= 800;
				}
				else if(e.getItem() == noodle5) {
					select.append("-����- ���� : 1,200��\n"); sum -= 1200;
				}
				else if(e.getItem() == noodle6) {
					select.append("-����- ġ���߰� : 1,000��\n"); sum -= 1000;
				}
				else if(e.getItem() == memberOne) {
					select.append("-����- 1�ð� �߰�(ȸ��) : 1,000��\n"); sum -= 1000;
				}
				else if(e.getItem() == memberThree) {
					select.append("-����- 3�ð� �߰�(ȸ��) : 2,700��\n"); sum -= 2700;
				}
				else if(e.getItem() == nonmemberOne) {
					select.append("-����- 1�ð� �߰�(��ȸ��) : 1,500��\n"); sum -= 1500;
				}
				else if(e.getItem() == nonmemberThree) {
					select.append("-����- 3�ð� �߰�(ȸ��) : 4,000��\n"); sum -= 4000;
				}
			}
			total.setText(sum+" ��");
		}
	}
	//* �޴��ٿ� �޴� �����ϴ� �Լ� *//
	private void createMenu() {
	   JMenuBar mb = new JMenuBar();
	   JMenuItem[] time = new JMenuItem[2];
	   JMenuItem food = new JMenuItem("���");
	   JMenuItem help = new JMenuItem("����");
	   String[] timeItem = {"ȸ��", "��ȸ��"};
	      
	   JMenu foodScreen = new JMenu("����");
	   JMenu timeScreen = new JMenu("�ð��߰�");
	   JMenu helpScreen = new JMenu("����");
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
	//* ��ư Ŭ������ �� �̺�Ʈ *//
	class MyActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton Btn = (JButton)e.getSource();
			if(Btn.getText().equals("���� �Ϸ�")) {   // �����Ϸ� ��ư�� ������ ���� ó�� ���� ȭ������ ���ư���
				paymentScreen.setVisible(false);
				CardPay.setVisible(false);
				new mainMenu();
			}
			else if(Btn.getText().equals("���ÿϷ�")) a.setVisible(true);   // ���ÿϷ� ������ �ؿ� �� �ݾװ� �ʱ�ȭ, �������� �Ѿ�� â ��Ÿ��
			else if(Btn.getText().equals("�ʱ�ȭ")) {  // �� �����̶� �ѱݾ� �ʱ�ȭ
				noodle1.setSelected(false); noodle2.setSelected(false); noodle3.setSelected(false);
				noodle4.setSelected(false); noodle5.setSelected(false); noodle6.setSelected(false);
				memberOne.setSelected(false); memberThree.setSelected(false);
				nonmemberOne.setSelected(false); nonmemberThree.setSelected(false);
				select.setText(""); total.setText("");
				sum = 0;
			}
			else if(Btn.getText().equals("����")) {  // �޴�ȭ�鿡�� �Ѿ�� ���� ���Ŷ� �ѱݾ� Ȯ��â
				paymentScreen.setVisible(true);
				setVisible(false);
				pick.append(select.getText());
				money.setText(sum+"��");
			}
			else if(Btn.getText().equals("����")) {   // ���� ������ ����
				int result = JOptionPane.showConfirmDialog(null, "���� �Ͻðڽ��ϱ�?", "Confirm", JOptionPane.YES_NO_OPTION);
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
	//* �޴��ٿ��� ���ý� �ش� ȭ������ �ٲ�� �ϱ� *//
	class MenuActionListener implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	       String cmd = e.getActionCommand();
	       if(cmd.equals("���")) {
	          card.show(main_panel, "���޴�");
	       }
	       else if(cmd.equals("ȸ��")) {
	          card.show(main_panel, "ȸ���ð��߰�");
	       }
	       else if(cmd.equals("��ȸ��")) {
	    	   card.show(main_panel, "��ȸ���ð��߰�");
	       }
	       else if(cmd.equals("����")) {
	    	   card.show(main_panel, "����");
	       }
	    }
	 }
	public static void main(String [] args) {
		new orderScreen();
	}
}