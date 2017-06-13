package Account;

public class CreditAccount extends Account {
	// 开户
	private long ceiling = 5000;

	// 构造函数
	public CreditAccount() {
		super();
	}

	// 构造函数
	public CreditAccount(String id, String pass, String name, String sex, String phone, String email, String accountType,
						 long balance,long ceiling) {
		super(id,pass,sex,name,phone,email,accountType,balance);
		this.ceiling = ceiling;

	}

	public long getCeiling() {
		return ceiling;
	}

	public void setCeiling(long ceiling) {
		this.ceiling = ceiling;
	}

}