package Account;

import DataBase.Dao;

/*
 *  账户类:包含两种账户类型-->1.储蓄账户 2.信用账户 
 *
 */
public class Account {
	private String id;
	private String pass;
	private String name; 				// 真实姓名
	private String sex;
	private String phone;				// 手机
	private String email;
	private long balance;
	private String accountType;

	/*	
	 * 构造方法: 有参和无参 有参构造方法用于设置必要的属性
	 */
	public Account() {
		super();
	}

	public String getAccountType() {
		return accountType;
	}

	public String getSex(){
		return sex;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Account(String id, String pass, String name, String sex, String phone, String email, String accountType, long balance) {
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.sex = sex;
		this.phone = phone;
		this.email = email;
		this.accountType = accountType;
		this.balance = balance;
	}

	public double deposit(double money) {
		// 存款方法
		
		return money;
	}

	public int withdraw(String user,String balance) {
		// 取款方法
		return Dao.withdraw(user, balance);
	}

	/*
	 * (封装) 将Account类作成完全封装,注意:要辨别每个属性的set/get方法是否需要公开
	 */
	public String getId() {
		return id;
	}

	public  void setId(String id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getphone() {
		return phone;
	}

	public void setphone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}
}
