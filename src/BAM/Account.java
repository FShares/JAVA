package BAM;

public class Account {
	private long id;
	private String pass;
	private String name;	//真实姓名 
	private String personID;//身份证号码字符串类型
	private String email;
	private double balance;
	
	protected double deposit(double money){
		//存款方法
		return money;
	}

	protected double withdraw(double money){
		//取款方法
		return money;
	}
	/*
	 * 构造方法: 有参和无参
	 * 有参构造方法用于设置必要的属性  
	 */
	Account(){
		this.id = 0;
		this.pass = "";
		this.name = "";
		this.personID = "";
		this.email = "";
		this.balance = 0;
	}
	Account(long id, String pass, String name, String personID, String email, long balance){

		this.id = id;
		this.pass = pass;
		this.name = name;
		this.personID = personID;
		this.email = email;
		this.balance = balance;
	}

	/*
	 * (封装) 将Account类作成完全封装,注意:要辨别每个属性的set/get方法是否需要公开  
	 */
	public long getId() {
		return id;
	}

	protected void setId(long id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	protected void setPass(String pass) {
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	public String getPersonID() {
		return personID;
	}

	protected void setPersonID(String personID) {
		this.personID = personID;
	}

	public String getEmail() {
		return email;
	}

	protected void setEmail(String email) {
		this.email = email;
	}

	public double getBalance() {
		return balance;
	}

	protected void setBalance(double balance) {
		this.balance = balance;
	}
}
/*
 * 第三部分:(继承,多态)  
 * 银行的客户分为两类,储蓄账户(SavingAccount)和信用账户(CreditAccount),
 * 区别在于储蓄账户不允许透支,而信用账户可以透支,并允许用户设置自己的透支额度.  
 * 注意:CreditAccount需要多一个属性 ceiling 透支额度  
 */
class SavingAccount extends Account{
	
}

class CreditAccount extends Account{
	private double ceiling;

	public double getCeiling() {
		return ceiling;
	}

	public void setCeiling(double ceiling) {
		this.ceiling = ceiling;
	}

}

