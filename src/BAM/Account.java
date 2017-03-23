package BAM;

public class Account {
	private long id;
	private String pass;
	private String name;	//��ʵ���� 
	private String personID;//���֤�����ַ�������
	private String email;
	private double balance;
	
	protected double deposit(double money){
		//����
		return money;
	}

	protected double withdraw(double money){
		//ȡ���
		return money;
	}
	/*
	 * ���췽��: �вκ��޲�
	 * �вι��췽���������ñ�Ҫ������  
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
	 * (��װ) ��Account��������ȫ��װ,ע��:Ҫ���ÿ�����Ե�set/get�����Ƿ���Ҫ����  
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
 * ��������:(�̳�,��̬)  
 * ���еĿͻ���Ϊ����,�����˻�(SavingAccount)�������˻�(CreditAccount),
 * �������ڴ����˻�������͸֧,�������˻�����͸֧,�������û������Լ���͸֧���.  
 * ע��:CreditAccount��Ҫ��һ������ ceiling ͸֧���  
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

