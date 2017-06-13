package DataBase;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;


import Account.Account;

public class Dao {

	protected static String dbClassName = "com.mysql.jdbc.Driver";// MySQL数据库驱动类的名称
	protected static String dbUrl = "jdbc:mysql://127.0.0.1:3306/Bank_Management_System?characterEncoding=UTF-8";// 访问MySQL数据库的路径
	protected static String dbUser = "root";// 访问MySQL数据库的用户名
	protected static String dbPwd = "";// 访问MySQL数据库的密码
	protected static String dbName = "Bank_Management_System";// 访问MySQL数据库中的实例(Bank_Management_System)
	protected static String second = null;//
	public static Connection conn = null;// MySQL数据库的连接对象

	static {// 静态初始化Dao类
		try {
			if (conn == null) {
				Class.forName(dbClassName).newInstance();// 实例化MySQL数据库的驱动
				conn = DriverManager.getConnection(dbUrl, dbUser, dbPwd);// 连接MySQL数据库
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "请将MySQL的JDBC驱动包复制到lib文件夹中。");// 捕获异常后，弹出提示框
			System.exit(-1);// 系统停止运行
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Dao() {
	}
	//返回查找到的记录集
	public static ResultSet findForResultSet(String sql) {
		if (conn == null)
			return null;
		long time = System.currentTimeMillis();
		ResultSet rs = null;
		try {
			Statement stmt = null;
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery(sql);
			second = ((System.currentTimeMillis() - time) / 1000d) + "";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	// 验证登录
	public static boolean checkLogin(String userStr, String passStr)
			throws SQLException {
		ResultSet rs = findForResultSet("select * from userinfo where userAccount='"
				+ userStr + "' and userPassword='" + passStr + "'");
		if (rs == null)
			return false;
		return rs.next();
	}
	
	//余额查询
	public static String queryBalance(String userStr){
		ResultSet rs = findForResultSet("select userBalance from userinfo where userAccount='"
				+ userStr + "'");
		if (rs == null)
			return null;
		try {
			if (rs.next()) {
				return rs.getString("userBalance").trim();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	//账户类型查询
	public static String queryType(String userStr){
		ResultSet rs = findForResultSet("select accountType from userinfo where userAccount='"
				+ userStr + "'");
		if (rs == null)
			return null;
		try {
			if (rs.next()) {
				return rs.getString("accountType").trim();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}	
	//查询账户透支余额
	public static String queryCeiling(String userStr){
		ResultSet rs = findForResultSet("select userCeiling from userinfo where userAccount='"
				+ userStr + "'");
		if (rs == null)
			return null;
		try {
			if (rs.next()) {
				return rs.getString("userCeiling").trim();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	//查询真实姓名
	public static String queryReal(String userStr){
		ResultSet rs = findForResultSet("select userName from userinfo where userAccount='"
				+ userStr + "'");
		if (rs == null)
			return null;
		try {
			if (rs.next()) {
				return rs.getString("userName").trim();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	//透支余额操作
	public static int useCeiling(String user,String Ceiling){
		String oldCeiling = queryCeiling(user);
		int newCeiling = Integer.parseInt(oldCeiling)-Integer.parseInt(Ceiling);
		String sql = "UPDATE userinfo SET userCeiling = '" + newCeiling +"' WHERE userAccount ='" + user +"'";
		return update(sql);
	}
	//转账操作
	public static int transferAccount(String user,String user2,String balance) {
		System.out.println("user:"+user+"user2"+user2+"balance"+balance);
		String oldBalbance = queryBalance(user);
		String oldBalbance2 = queryBalance(user2);

		int newBalbance =  Integer.parseInt(oldBalbance)- Integer.parseInt(balance);

		int newBalbance2 =  Integer.parseInt(oldBalbance)+ Integer.parseInt(balance);
		String sql = "UPDATE userinfo SET userBalance = '" + newBalbance +"' WHERE userAccount ='" + user +"';";
		update(sql);
		String sql2 = "UPDATE userinfo SET userBalance = '" + newBalbance2 +"' WHERE userAccount ='" + user2 +"'";
		return update(sql2);
	}
	//存款操作
	public static int deposit(String user,String balance){
		String oldBalbance = queryBalance(user);
		int newBalbance =  Integer.parseInt(oldBalbance)+ Integer.parseInt(balance);
		String sql = "UPDATE userinfo SET userBalance = '" + newBalbance +"' WHERE userAccount ='" + user +"'";
		return update(sql);
	}
	//取款操作
	public static int withdraw(String user,String balance){
		String oldBalbance = queryBalance(user);
		int newBalbance = Integer.parseInt(oldBalbance)-Integer.parseInt(balance);
		String sql = "UPDATE userinfo SET userBalance = '" + newBalbance +"' WHERE userAccount ='" + user +"'";
		return update(sql);
	}
	
	
	// 更新数据
	public static int update(String sql) {
		int result = 0;
		try {
			Statement stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	
	// 添加用户信息的方法
	public static boolean addAccount(Account accounts) {
		if (accounts == null)
			return false;
		String sql="";
		if(accounts.getAccountType()=="0"){//Save Account
			sql= "INSERT INTO  userinfo values('"
					+ accounts.getId()+ "','" + accounts.getPass() + "','"
					+ accounts.getphone() + "','" + accounts.getEmail() + "','"
					+ accounts.getName() + "','" + accounts.getSex() + "','"
					+ 0 + "','" + 0 + "','" + 0
					+ "')";
			System.out.println(sql);
			return insert(sql);
		}else{//Credit Account
			sql = "INSERT INTO  userinfo values('"
					+ accounts.getId()+ "','" + accounts.getPass() + "','"
					+ accounts.getphone() + "','" + accounts.getEmail() + "','"
					+ accounts.getName() + "','" + accounts.getSex() + "','"
					+ 1 + "','" + 0 + "','" + 5000
					+ "')";
			System.out.println(sql);
			return insert(sql);
		}
	}
	
	// 添加数据
	public static boolean insert(String sql) {
		boolean result = false;
		try {
			Statement stmt = conn.createStatement();
			//result = stmt.execute(sql);
			return (stmt.executeUpdate(sql)>0?true:false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	//密码修改
	public static int modifyPass(String user,String newPass) {
		String sql = "UPDATE userinfo SET userPassword = '" + newPass +"' WHERE userAccount ='" + user +"'";
		return update(sql);
	}

	//返回用户信息
	public static  Account accountInfo(String user){
		Account a1 = new Account();
		String sql ="SELECT * FROM userinfo where userAccount='"+ user + "'";
		ResultSet rs = findForResultSet(sql);
		if (rs == null)
			return null;
		try {
			if (rs.next()) {
				a1.setAccountType(rs.getString("accountType").trim());
				a1.setId(rs.getString("userAccount").trim());
				a1.setPass(rs.getString("userPassword").trim());
				a1.setName(rs.getString("userName").trim());
				a1.setphone(rs.getString("userPhone").trim());
				a1.setSex(rs.getString("userSex").trim());
				a1.setEmail(rs.getString("userMail").trim());
				a1.setBalance(Long.parseLong(rs.getString("userBalance").trim()));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a1;
//		a1.setAccountType(accountType);
	}
}