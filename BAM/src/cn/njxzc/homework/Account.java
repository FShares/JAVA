package cn.njxzc.homework;

/*
 *  账户类:包含两种账户类型-->1.储蓄账户 2.信用账户 
 *
 */
public class Account {
	private long id;
	private String pass;
	private String name; 				// 真实姓名
	private String personID;			// 身份证号码字符串类型
	private String email;
	private double balance;
	private int accountType;

	/*	
	 * 构造方法: 有参和无参 有参构造方法用于设置必要的属性
	 */
	Account() {
		super();
	}

	int getAccountType() {
		return accountType;
	}

	protected void setAccountType(int accountType) {
		this.accountType = accountType;
	}

	Account(long id, String pass, String name, String personID, String email, int accountType, long balance) {
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.personID = personID;
		this.email = email;
		this.balance = balance;
	}

	protected double deposit(double money) {
		// 存款方法
		return money;
	}

	protected double withdraw(double money) {
		// 取款方法
		return money;
	}

	/*
	 * (封装) 将Account类作成完全封装,注意:要辨别每个属性的set/get方法是否需要公开
	 */
	long getId() {
		return id;
	}

	protected  void setId(long id) {
		this.id = id;
	}

	protected String getPass() {
		return pass;
	}

	protected void setPass(String pass) {
		this.pass = pass;
	}

	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	protected String getPersonID() {
		return personID;
	}

	protected void setPersonID(String personID) {
		this.personID = personID;
	}

	protected String getEmail() {
		return email;
	}

	protected void setEmail(String email) {
		this.email = email;
	}

	double getBalance() {
		return balance;
	}

	protected void setBalance(double balance) {
		this.balance = balance;
	}
}
