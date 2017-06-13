package View;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Account.Account;
import Account.CreditAccount;
import DataBase.Dao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainView_User extends JFrame {

	private JPanel contentPane;
	private JLabel time1Label;
	private JLabel lblNewLabel_1;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JLabel userInfo;
	private JButton button_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Account a = new Account();
					MainView_User frame = new MainView_User(a);
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainView_User(final Account account) {
		setTitle("Menu");
		Shijian shijian = new Shijian();
		Thread thread = new Thread(shijian);
		thread.start();
		
		String user = account.getId();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		getContentPane().setLayout(null); // 布局方式：绝对布局
		
		time1Label = new JLabel("This is time");
		time1Label.setFont(new Font("Dialog", Font.BOLD, 15));
		time1Label.setBounds(507, 493, 158, 39);
		contentPane.add(time1Label);
		
		JLabel lblNewLabel = new JLabel("\u5F53\u524D\u65F6\u95F4\uFF1A");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel.setBounds(421, 493, 84, 39);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Please      Select       Service");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 30));
		lblNewLabel_1.setBounds(232, 42, 393, 59);
		contentPane.add(lblNewLabel_1);
		
		button = new JButton("\u67E5\u8BE2");
		//查询操作
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String result = Dao.queryBalance(user);
				if(result.equals("")){
					JOptionPane.showMessageDialog(null, "查询出错！");
				}else{
					JOptionPane.showMessageDialog(null, "您当前的账户余额为:  "+result, "余额查询", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		button.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		button.setBounds(139, 154, 150, 50);
		contentPane.add(button);
		
		//取款操作
		button_1 = new JButton("\u53D6\u6B3E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String in = JOptionPane.showInputDialog(null,"请输入取款金额：  ","存款中...",JOptionPane.QUESTION_MESSAGE);
				int result = account.withdraw(user, in);
				if(result==0){
					JOptionPane.showMessageDialog(null, "账户取款出错！");
				}else{
					String result2 = Dao.queryBalance(user);
					JOptionPane.showMessageDialog(null, "您当前的账户余额为:  "+result2, "存款成功", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		button_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		button_1.setBounds(523, 154,  150, 50);
		contentPane.add(button_1);
		
		//账户存款
		button_2 = new JButton("\u5B58\u6B3E");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//deposit
				String out = JOptionPane.showInputDialog(null,"请输入取款金额：  ","存款中...",JOptionPane.QUESTION_MESSAGE);
				int result = Dao.deposit(user, out);
				if(result==0){
					JOptionPane.showMessageDialog(null, "账户存款出错！");
				}else{
					String result2 = Dao.queryBalance(user);
					JOptionPane.showMessageDialog(null, "您当前的账户余额为:  "+result2, "取款成功", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		button_2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		button_2.setBounds(139, 257,  150, 50);
		contentPane.add(button_2);
		
		//转账操作
		button_3 = new JButton("\u8F6C\u8D26");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//transferAccount
				String in = JOptionPane.showInputDialog(null,"请输入对方账户ID：  ","转账中...",JOptionPane.QUESTION_MESSAGE);
				if(!in.equals(null)){
					String out = JOptionPane.showInputDialog(null,"请输入转账金额：  ","转账中...",JOptionPane.QUESTION_MESSAGE);
					
					int result = Dao.transferAccount(user, in, out);
					if(result==0){
						JOptionPane.showMessageDialog(null, "账户转账出错！");
					}else{
						String result2 = Dao.queryBalance(user);
						JOptionPane.showMessageDialog(null, "您当前的账户余额为:  "+result2, "取款成功", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		button_3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		button_3.setBounds(523, 257,  150, 50);
		contentPane.add(button_3);
		
		btnNewButton = new JButton("\u5BC6\u7801\u4FEE\u6539");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String newPass = JOptionPane.showInputDialog(null,"请输入新密码 ","密码修改中...",JOptionPane.QUESTION_MESSAGE);
				if(newPass.equals(null)){
				}else{
					String newPass2 = JOptionPane.showInputDialog(null,"请输入新密码 ","密码修改中...",JOptionPane.QUESTION_MESSAGE);
					if(newPass.equals(newPass2)){
						int result = Dao.modifyPass(user,newPass);
						if(result>0){
							JOptionPane.showMessageDialog(null, "密码修改成功，请重新登录");
							MainView_User.this.dispose();
							LoginView_User lo = new LoginView_User();
						}else{
							JOptionPane.showMessageDialog(null, "密码修改失败，请重试！");
						}
					}else{
						JOptionPane.showMessageDialog(null, "两次密码输入不一致");
					}
				}
			}
		});
		btnNewButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		btnNewButton.setBounds(139, 375,  150, 50);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("\u9000\u51FA");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainView_User.this.dispose();
				LoginView_User lo = new LoginView_User();
			}
		});
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			//退出按钮
			public void mouseClicked(MouseEvent arg0) {
				if(0==JOptionPane.showConfirmDialog(null, "真的要退出吗？","提示", JOptionPane.YES_NO_OPTION)){ 
					//yes ->0
					System.exit(0);				
				}else{  //no ->1
					return;
				}
			}
		});
		btnNewButton_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		btnNewButton_1.setBounds(523, 375,  150, 50);
		contentPane.add(btnNewButton_1);
	
		userInfo = new JLabel("\u7528\u6237\u4FE1\u606F");
		userInfo.setForeground(Color.WHITE);
		userInfo.setFont(new Font("Dialog", Font.BOLD, 15));
		userInfo.setBounds(84, 493, 302, 39);
		String info = "您好，"+Dao.queryReal(user)+"  欢迎来到银行管理系统。";
		userInfo.setText(info);
		contentPane.add(userInfo);
		
		//透支余额
		button_4 = new JButton("\u900F\u652F");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//先查询透支余额
				String Ceiling = Dao.queryCeiling(user);
				JOptionPane.showMessageDialog(null, "您当前可透支的额度为：  " + Ceiling);
				String in = JOptionPane.showInputDialog(null,"请输入需要透支的额度为：  ","透支中...",JOptionPane.QUESTION_MESSAGE);
				if(!in.equals(null)){
					int result = Dao.useCeiling(user,in);
					if(result > 0){
						String result2 = Dao.queryCeiling(user);
						JOptionPane.showMessageDialog(null, "您当前可用的透支额度为:  "+result2, "透支成功", JOptionPane.INFORMATION_MESSAGE);
					}else{
						JOptionPane.showMessageDialog(null, "透支失败，请重试！");
					}
				}
			}
		});
		
		button_4.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		button_4.setBounds(332, 257, 150, 50);
		contentPane.add(button_4);
		button_4.setVisible(false);	
		if(account instanceof CreditAccount){
			button_4.setVisible(true);
		}else{
			button_4.setVisible(false);
		}
		
		JLabel lbl_image = new JLabel();
		lbl_image.setBounds(0, 0, 850, 600);
		lbl_image.setIcon(new ImageIcon("src/Image/蓝色背景图.jpg"));
		contentPane.add(lbl_image);
		
		this.setResizable(false); // 不可拖动或最大化
		this.setSize(850, 600);
		this.setLocationRelativeTo(null); // 居中
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); // 关闭，做什么都不关
		this.setVisible(true); // 界面可视化
	}
	public class Shijian implements Runnable {
		public void run() {
			// 线程，显示当前时间
			while (true) {
				Date date = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss");
				String time = sdf.format(date);
				time1Label.setForeground(Color.white);
				time1Label.setText(time);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
	}
}
