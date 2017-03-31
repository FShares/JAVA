package BAM;

/**
 * 储蓄账户类
 */
public class SaveAccount extends Account {
	// 构造函数
	public SaveAccount() {
		super();
	}

	public SaveAccount(long id, String pass, String name, String personID, String email, int accountType,
			long balance) {
		super(id, pass, name, personID, email, accountType, balance);
	}
}
