package View;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Account.Account;
import DataBase.Dao;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class RegisterView_User extends JFrame {

	private JPanel contentPane;
	private JTextField txtUser;
	private JPasswordField txtPass;
	private JPasswordField txtPass2;
	private JTextField txtRealname;
	private JTextField txtPhone;
	private JTextField txtEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterView_User frame = new RegisterView_User();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RegisterView_User() {
		setTitle("Register");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 340, 449);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_6 = new JLabel("用户账户");
		lblNewLabel_6.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(42, 52, 69, 20);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel = new JLabel("用户密码");
		lblNewLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		lblNewLabel.setBounds(41, 123, 70, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("确认密码");
		lblNewLabel_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(42, 165, 70, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("真实姓名");
		lblNewLabel_2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(41, 205, 70, 19);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("性别");
		lblNewLabel_3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(68, 245, 35, 17);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("手机");
		lblNewLabel_4.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(68, 287, 35, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("邮箱");
		lblNewLabel_5.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(68, 330, 35, 14);
		contentPane.add(lblNewLabel_5);
		
		txtUser = new JTextField();
		txtUser.setBounds(121, 53, 136, 20);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("\u7528\u6237\u6CE8\u518C");
		lblNewLabel_7.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
		lblNewLabel_7.setBounds(120, 11, 92, 31);
		contentPane.add(lblNewLabel_7);
		
		txtPass = new JPasswordField();
		txtPass.setBounds(121, 123, 136, 20);
		contentPane.add(txtPass);
		
		txtPass2 = new JPasswordField();
		txtPass2.setBounds(121, 164, 136, 20);
		contentPane.add(txtPass2);
		
		txtRealname = new JTextField();
		txtRealname.setColumns(10);
		txtRealname.setBounds(121, 206, 136, 20);
		contentPane.add(txtRealname);
		
		txtPhone = new JTextField();
		txtPhone.setColumns(10);
		txtPhone.setBounds(121, 284, 136, 20);
		contentPane.add(txtPhone);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(121, 328, 136, 20);
		contentPane.add(txtEmail);
		
		JLabel lblNewLabel_8 = new JLabel("\u94F6\u884C\u5361\u7C7B\u578B");
		lblNewLabel_8.setFont(new Font("Microsoft YaHei", Font.PLAIN, 15));
		lblNewLabel_8.setBounds(27, 87, 88, 20);
		contentPane.add(lblNewLabel_8);
		
		JRadioButton radioCredit = new JRadioButton("\u501F\u8BB0\u5361");
		radioCredit.setBounds(198, 87, 79, 23);
		radioCredit.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		contentPane.add(radioCredit);
		
		JRadioButton radioSave = new JRadioButton("\u50A8\u84C4\u5361");
		radioSave.setHorizontalAlignment(SwingConstants.LEFT);
		radioSave.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		radioSave.setSelected(true);
		radioSave.setBounds(121, 87, 76, 23);
		contentPane.add(radioSave);
		
		//把两个radioButton放在同个Group中
		ButtonGroup typeGroup = new ButtonGroup();
		typeGroup.add(radioSave);
		typeGroup.add(radioCredit);
				
		JRadioButton sexM = new JRadioButton("\u7537");
		sexM.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		sexM.setSelected(true);
		sexM.setBounds(121, 243, 46, 23);
		contentPane.add(sexM);
		
		JRadioButton sexW = new JRadioButton("\u5973");
		sexW.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		sexW.setBounds(198, 243, 59, 23);
		contentPane.add(sexW);
		
		//把两个radioButton放在同个Group中
		ButtonGroup sexGroup = new ButtonGroup();
		sexGroup.add(sexW);
		sexGroup.add(sexM);
		
		JButton btnOk = new JButton("\u63D0\u4EA4");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String id = txtUser.getText();
				String typeAccount="1";
				if(radioSave.isSelected()==true) typeAccount="0";
				else typeAccount="1";
				String Pass = txtPass.getText();
				String Pass2 = txtPass2.getText();
				String Real = txtRealname.getText();
				String Sex = "1";
				if(sexM.isSelected()==true) Sex = "1";
				else Sex = "0";
				
				String Phone = txtPhone.getText();
				String Email = txtEmail.getText();

				/*
				 * 正则 邮箱
				 */
				//◆验证是否为邮箱地址
//				String str="ceponline@yahoo.com.cn";
//				Pattern pattern = Pattern.compile("[\\w\\.\\-]+@([\\w\\-]+\\.)+[\\w\\-]+",Pattern.CASE_INSENSITIVE);
//				Matcher matcher = pattern.matcher(Email);
//				System.out.println(matcher.matches());
				
				if(id.equals("")) JOptionPane.showMessageDialog(null, "请输入账户！", "系统提示", JOptionPane.OK_OPTION);
				else if(Pass.equals("")) JOptionPane.showMessageDialog(null, "请输入密码！", "系统提示", JOptionPane.OK_OPTION);
				else if(!Pass.equals(Pass2)) JOptionPane.showMessageDialog(null, "两次密码输入不一致！", "系统提示", JOptionPane.OK_OPTION);
				else if(Real.equals("")) JOptionPane.showMessageDialog(null, "请输入真实姓名", "系统提示", JOptionPane.OK_OPTION);
				else if(Phone.equals("")) JOptionPane.showMessageDialog(null, "请输入手机号码", "系统提示", JOptionPane.OK_OPTION);
				else if(Email.equals("")) JOptionPane.showMessageDialog(null, "请输入邮箱地址", "系统提示", JOptionPane.OK_OPTION);
				else{ 
					Account accounts = new Account(id,Pass,Real,Sex,Phone,Email,typeAccount,0);
					if(Dao.addAccount(accounts)==true){
						JOptionPane.showMessageDialog(RegisterView_User.this, "用户注册成功！");
					}else{
						JOptionPane.showMessageDialog(RegisterView_User.this, "用户注册失败！");
					}
				}
			}
		});
		btnOk.setFont(new Font("Microsoft YaHei", Font.PLAIN, 15));
		btnOk.setBounds(68, 368, 69, 31);
		contentPane.add(btnOk);
		
		JButton btnBack = new JButton("\u8FD4\u56DE");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RegisterView_User.this.dispose();			//关闭当前窗体
				LoginView_User lo = new LoginView_User();	//新建登录窗体
			}
		});
		btnBack.setFont(new Font("Microsoft YaHei", Font.PLAIN, 15));
		btnBack.setBounds(173, 368, 69, 31);
		contentPane.add(btnBack);

		this.setResizable(false);   //不可拖动或最大化
		this.setLocationRelativeTo(null);   //居中
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);    //关闭，做什么都不关
		this.setVisible(true);   //界面可视化
	}
}
