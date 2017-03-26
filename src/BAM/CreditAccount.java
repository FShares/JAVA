package BAM;

class CreditAccount extends Account{
	//开户
	private double ceiling;
	public double getCeiling() {
		return ceiling;
	}
	public void setCeiling(double ceiling) {
		this.ceiling = ceiling;
	}
	public CreditAccount(){
		super();
	}
	
	//构造函数
	public CreditAccount(long id, String password, String name, String personID, int accountType, double balance, double ceiling){
		//super(id,password,name,personID,accountType,balance);
		this.ceiling = ceiling;
	}

}