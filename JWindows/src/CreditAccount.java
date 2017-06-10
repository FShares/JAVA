class CreditAccount extends Account {
	// 开户
	private double ceiling;

	// 构造函数
	public CreditAccount() {
		super();
	}

	// 构造函数
	public CreditAccount(long id, String pass, String name, String personID, String email, int accountType,
						 long balance,double ceiling) {
		super(id,pass,name,personID,email,accountType,balance);
		this.ceiling = ceiling;

	}

	public double getCeiling() {
		return ceiling;
	}

	public void setCeiling(double ceiling) {
		this.ceiling = ceiling;
	}

}