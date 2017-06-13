package Account;

/**
 * 储蓄账户类
 */
public class SaveAccount extends Account {
	// 构造函数
	public SaveAccount() {
		super();
	}

	public SaveAccount(String id, String pass, String name, String sex, String phone, String email, String accountType,
			long balance) {
		super(id, pass, sex, name, phone, email, accountType, balance);
	}
}
