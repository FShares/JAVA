package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Account.Account;
import Account.CreditAccount;
import Account.SaveAccount;
import DataBase.Dao;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class LoginView_User extends JFrame {

	private JPanel contentPane;
	private JTextField nameField;
	private JPasswordField passField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView_User frame = new LoginView_User();
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
	public LoginView_User() {
		// 添加监听事件  窗体监听事件    关闭窗口
		this.addWindowListener(new WindowAdapter(){    // WindowAdapter 是抽象类，不可实例化，这类是调用匿名内部类
			//重写 override
			public void windowClosing(WindowEvent e){
				if(0==JOptionPane.showConfirmDialog(LoginView_User.this, "真的要退出吗？","提示", JOptionPane.YES_NO_OPTION)){ 
					//yes ->0
					System.exit(0);				
				}else{  //no ->1
					return;
				}
			}
		});
		
		setTitle("Bank Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 303, 190);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);		 //绝对布局
		
		JButton btnLogin = new JButton("\u767B\u5F55");
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			//鼠标单击事件 登录按钮
			public void mouseClicked(MouseEvent arg0) {
				//登录事件
//				//从文本框中获取输入值
				String user = nameField.getText();
				String pass = new String(passField.getPassword());
				
//				Pass = MD5Util.getMD5(MD5Util.getMD5(Pass));
				if("".equals(user)||user==null){
					JOptionPane.showConfirmDialog(null, "输入账号不能为空！"+"请重新操作！");
					nameField.setText("");
					passField.setText("");
					return;
				}
				if("".equals(pass)||pass==null){
					JOptionPane.showMessageDialog(null, "输入密码不能为空！"+"请重新操作！");
					nameField.setText("");
					passField.setText("");
					return;
				}
				try {
					if(Dao.checkLogin(user, pass)){
						// 登录成功
						String type = Dao.queryType(user);
						long ceiling = Long.parseLong(Dao.queryCeiling(user));
						Account a1 = Dao.accountInfo(user);
						if(type.equals("1")){
							//CreditAccount
							CreditAccount a2 = new CreditAccount();
							a2.setAccountType(a1.getAccountType());
							a2.setBalance(a1.getBalance());
							a2.setEmail(a1.getEmail());
							a2.setId(a1.getId());
							a2.setName(a1.getName());
							a2.setPass(a1.getPass());
							a2.setSex(a1.getSex());
							a2.setphone(a1.getphone());
							a2.setCeiling(ceiling);
							a2.setBalance(a1.getBalance());
							LoginView_User.this.dispose();
							MainView_User m = new MainView_User(a2);
						}else{
							//SaveAccount
							SaveAccount SA = new SaveAccount();
							SA.setAccountType(a1.getAccountType());
							SA.setBalance(a1.getBalance());
							SA.setEmail(a1.getEmail());
							SA.setId(a1.getId());
							SA.setName(a1.getName());
							SA.setPass(a1.getPass());
							SA.setSex(a1.getSex());
							SA.setphone(a1.getphone());
							SA.setBalance(a1.getBalance());
							LoginView_User.this.dispose();
							MainView_User m = new MainView_User(a1);
						}
					}else{
						JOptionPane.showMessageDialog(LoginView_User.this, 
								"用户名与密码无法登录","登录失败",JOptionPane.ERROR_MESSAGE);
						return;
					}
				} catch (HeadlessException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnLogin.setBounds(76, 118, 60, 23);
		contentPane.add(btnLogin);
		
		JButton button_1 = new JButton("\u53D6\u6D88");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			//鼠标单击事件 取消按钮
			public void mouseClicked(MouseEvent arg0) {
//				if(0==JOptionPane.showConfirmDialog(LoginView_User.this, "真的要退出吗？","提示", JOptionPane.YES_NO_OPTION)){ 
//					//ok ->0
//					System.exit(0);				
//				}else{  //cancel ->1
//					return;
//				}
				System.exit(0);		
			}
		});
		button_1.setBounds(215, 118, 60, 23);
		contentPane.add(button_1);
		
		JLabel label = new JLabel("\u5BC6\u7801");
		label.setFont(new Font("Microsoft YaHei", Font.PLAIN, 15));
		label.setBounds(93, 75, 31, 23);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u8D26\u53F7");
		label_1.setFont(new Font("Microsoft YaHei", Font.PLAIN, 15));
		label_1.setBounds(93, 42, 31, 20);
		contentPane.add(label_1);
		
		nameField = new JTextField();
		nameField.setBounds(145, 42, 130, 20);
		contentPane.add(nameField);
		nameField.setColumns(10);
		
		JLabel lblWelcomeToBank = new JLabel("Welcome To Bank Management System");
		lblWelcomeToBank.setFont(new Font("Gill Sans MT", Font.PLAIN, 16));
		lblWelcomeToBank.setForeground(Color.BLUE);
		lblWelcomeToBank.setBounds(10, 11, 328, 14);
		contentPane.add(lblWelcomeToBank);
		
		passField = new JPasswordField();
		passField.setBounds(145, 75, 130, 20);
		contentPane.add(passField);
		
		JButton btnRegister = new JButton("\u6CE8\u518C");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RegisterView_User reg = new RegisterView_User();
				LoginView_User.this.dispose();			//关闭当前窗体
			}
		});
		btnRegister.setBounds(145, 118, 60, 23);
		contentPane.add(btnRegister);

		JLabel lbl_image = new JLabel();
		lbl_image.setBounds(0, 0, 300, 160);
		lbl_image.setIcon(new ImageIcon("src/Image/login.jpg"));
		contentPane.add(lbl_image);
		
		this.setResizable(false);   //不可拖动或最大化
		this.setLocationRelativeTo(null);   //居中
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);    //关闭，做什么都不关
		this.setVisible(true);   //界面可视化
		
	}
}
