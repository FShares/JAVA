package BAM;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/*
 * 同时要求编写Bank类,属性:
 1.当前所有的账户对象的集合,存放在数组中
 2.当前账户数量
  方法:
 1.用户开户,需要的参数:id,密码,密码确认,姓名,身份证号码,邮箱,账户类型(int),返回新创建的Account对象 
 2.用户登录,参数:id,密码 返回Account对象,提示 用s1.equals(s2)判断s1和s2两个 字符串内容是否相等
 3.用户存款,参数:id,存款数额,返回修改过的Account对象
 4.用户取款,参数:id,取款数额,返回修改过的Account对象
 5.设置透支额度 参数:id,新的额度  ,返回修改过的Account对象.这个方法需要验证账户是否是信用账户 
 
 用户会通过调用Bank对象以上的方法来操作自己的账户,请分析各个方法需要的参数 另外,请为Bank类添加几个统计方法
1.统计银行所有账户余额总数
2.统计所有信用账户透支额度总数

写个主方法测试你写的类

 */
public class Bank {
	private static Account[] accounts = new Account[20];
	private static int AccountCount; // 账户数目
	// private static int id = 1001;// 确定银行账号从1001开始生成，即第一个账户的账号是1001
	// 构造函数

	public Bank() {
		accounts = new Account[20];// 以后不足时扩容。
		AccountCount = 0;
	}

	public static Account userCreate(long id, String pass1, String pass2, String name, String personID, String email,
			int type) {
		// System.out.println(pass1 + pass2 + name + personID + email + type);
		// 1.用户开户,需要的参数:id,密码,密码确认,姓名,身份证号码,邮箱,账户类型(int),返回新创建的Account对象
		// 创建一个新账户
		Account account = null;
		if (pass1.equals(pass2)) {
			// 若一致，再判断账户类型（根据type的值）
			if (type == 1) {
				// 可令开始余额为0,信用额度为5000
				account = new CreditAccount();
				// account = new CreditAccount(id, pass1, name, personID, type,
				// 10, 5000);
			} else {
				// account = new SaveAccount(id,pass1,name,personID,email,type);
				account = new SaveAccount(id, pass1, name, personID, email, type, 0);
				// account = new SaveAccount(id, pass1, name, personID,
				// type,10);
			}
			// 判断是否超出存储空间
			if (AccountCount >= accounts.length) {
				// 扩容

			} else {
				// 将账户存入账户数组accounts[]中
				accounts[AccountCount] = account;
				// System.out.println(accounts.length);
			}
			AccountCount++;
			System.out.println("开户成功, 账户信息见下: ");
			System.out.println("您的卡号为：" + id + "\n" + "您的密码为：" + pass1 + "\n" + "您的名字为：" + name + "\n" + "您的身份证号为："
					+ personID + "\n" + "您的邮箱为：" + email + "\n" + "您的余额为：0" + "您的账户类型为：" + type + "\n");
			return account;
		} else {
			System.out.println("对不起！您两次密码输入不匹配，开户失败！！！");
			return null;// 此时开户失败
		}
	}

	/**
	 * 保存数据
	 * 
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	public static void saveAccountDate() throws IOException {
		BufferedWriter bufWriter = null;
		// 获取当前目录路径
		Properties props = System.getProperties();
		String path = props.getProperty("user.dir");
		System.out.println("文本path: " + path);
		// 追加写入文件account.txt
		bufWriter = new BufferedWriter(new FileWriter(new File(path, "account.txt"), true));
		for (int i = 0; i < AccountCount; i++) {
			// 若存在账户
			if (accounts[i] != null) {
				// 写入账户信息到account.txt
				bufWriter.write(accounts[i].getId() + ",");
				bufWriter.write(accounts[i].getPass() + ",");
				bufWriter.write(accounts[i].getName() + ",");
				bufWriter.write(accounts[i].getPersonID() + ",");
				bufWriter.write(accounts[i].getEmail() + ",");
				bufWriter.write(Double.toString(accounts[i].getBalance()) + ",");
				bufWriter.write(accounts[i].getAccountType());
				bufWriter.newLine();
				bufWriter.flush();
			} else {
				break;
			}
		}
	}

	/*
	 * 登录验证
	 */

	public static Account verifyAccount(long id, String password) throws IOException {
		Account account = null;
		// 获取当前目录路径
		String path = System.getProperties().getProperty("user.dir");
		System.out.println("path: " + path);
		// 按行读取文件
		File file = new File(path, "account.txt");
		BufferedReader reader = null;
		reader = new BufferedReader(new FileReader(file));
		String tempString = null;
		String[][] str = { {}, { "id", "pass", "name", "personID", "email", "balance", "accountType" } };
		int line = 1;
		// 一次读一行,直到读到null为文件结束
		while ((tempString = reader.readLine()) != null) {
			System.out.println("line" + line + "-->" + tempString);
			// 求每个人的信息
			String[] info = tempString.split(",");
			System.out.println("第" + line + " ");
			System.out.println("info_length" + info.length);
			for (int i = 0; i < info.length; i++) {
				str[line][i] = info[i];
				System.out.println(info[i]);
			}

			for (int i = 0; i < line; i++) {
				System.out.println(str[line][i]);
			}
			line++;
		}

		reader.close();
		// for (int i = 0; i < accounts.length; i++) {
		// // 若存在账户
		// if (accounts[i] != null) {
		// System.out.println("account not NULL");
		// // 验证id号和password
		// if (id == accounts[i].getId() &&
		// password.equals(accounts[i].getPass())) {
		// account = accounts[i];
		// break;
		// }
		// } else {
		// break;
		// }
		// }
		return account;
	}
}
