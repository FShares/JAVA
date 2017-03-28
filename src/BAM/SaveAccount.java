package BAM;

/**
 * 储蓄账户类
 */
public class SaveAccount extends Account {
	// 构造函数
	public SaveAccount() {
		super();
	}

	public SaveAccount(long id, String password, String name, String personId, int accountType, double balance) {
		super(id, password, name, personId, accountType, balance);
	}
}
