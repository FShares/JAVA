import java.io.*;
import java.util.ArrayList;
import java.util.List;
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
	//private static Account[] accounts;
	private static int AccountCount; // 账户数目
	// private static int id = 1001;// 确定银行账号从1001开始生成，即第一个账户的账号是1001
	// 构造函数

	public Bank() {
		//accounts = new Account[20];// 以后不足时扩容。
		AccountCount = 0;
	}
    /*
    开户
     */
	public static Account userCreate(long id, String pass1, String name, String personID, String email,
			int type) {
		// System.out.println(pass1 + pass2 + name + personID + email + type);
		// 1.用户开户,需要的参数:id,密码,密码确认,姓名,身份证号码,邮箱,账户类型(int),返回新创建的Account对象
		// 创建一个新账户
		Account account = null;
		// 判断账户类型（根据type的值）
		if (type == 1) {
			// 令开始余额为0,信用额度为5000
			account = new CreditAccount(id,pass1,name,personID,email,type,0,5000);
		} else {
			account = new SaveAccount(id, pass1, name, personID, email, type, 0);
		}
		/*
		// 判断是否超出存储空间
		if (AccountCount >= accounts.length) {
			// 扩容
		} else {
			// 将账户存入账户数组accounts[]中
			accounts[AccountCount] = account;
			// System.out.println(accounts.length);
		}
		*/
		AccountCount++;
		System.out.println("开户成功, 账户信息见下: ");
		System.out.println("您的卡号为：" + id + "\n" + "您的密码为：" + pass1 + "\n" + "您的名字为：" + name + "\n" + "您的身份证号为："
				+ personID + "\n" + "您的邮箱为：" + email + "\n" + "您的余额为：0\n" + "您的账户类型为：" + type);
        return account;

	}

	/*
	 * 登录验证
	 *
	 */

	public static Account verifyAccount(long id, String password) throws IOException {
		Account account = new Account();
		// 获取当前目录路径
		String path = System.getProperties().getProperty("user.dir");
//		System.out.println("path: " + path);
		// 按行读取文件
		File file = new File(path, "account.txt");
		BufferedReader reader = null;
		reader = new BufferedReader(new FileReader(file));
		String tempString = null;
		//String[][] str = { {"0","1"}, { "id", "pass", "name", "personID", "email", "balance", "accountType" } };
	    String [][] str = new String[10][8];
        int line = 1;
		// 一次读一行,直到读到null为文件结束
		while ((tempString = reader.readLine()) != null) {
//			System.out.println("line" + line + "-->" + tempString);
			// 求每个人的信息
			String[] info = tempString.split(",");
            //System.out.println(info.length+" length");
            System.arraycopy(info, 0, str[line], 0, 8);
			for (int i = 0; i < line; i++) {
				//System.out.println("用户名：" + str[line][0]);
				if (Long.toString(id).equals(str[line][0])) {
                    //判断数据中的密码是否匹配
                    //System.out.println("密码为：" + str[line][1]);
                    if (password.equals(str[line][1])) {
                        account.setId(id);
                        account.setPass(password);
                        account.setName(str[line][2]);
                        account.setPersonID(str[line][3]);
                        account.setEmail(str[line][4]);
                        account.setBalance(Double.parseDouble(str[line][5]));
                        account.setAccountType(Integer.parseInt(str[line][6]));
                        System.out.println("用户名与密码匹配正确!");
                        break;
                    } else {
                        return null;
                    }
                }
			}
			line++;
		}
		reader.close();
		return account;
	}

	/*
	 * 查询用户是否存在
	 *
	 */

    public static Account queryAccount(long id) throws IOException {
        Account account = new Account();
        // 获取当前目录路径
        String path = System.getProperties().getProperty("user.dir");
        // 按行读取文件
        File file = new File(path, "account.txt");
        BufferedReader reader = null;
        reader = new BufferedReader(new FileReader(file));
        String tempString = null;
        //String[][] str = { {"0","1"}, { "id", "pass", "name", "personID", "email", "balance", "accountType" } };
        String[][] str = new String[10][8];
        int line = 0;
        // 一次读一行,直到读到null为文件结束
        while ((tempString = reader.readLine()) != null) {
            line++;
            // 求每个人的信息
            String[] info = tempString.split(",");
            //读到用户并数据赋值
            System.arraycopy(info, 0, str[line], 0, 8);
            //System.out.println("用户名：" + str[line][0]);
            for (int i = 0; i < line; i++) {
                if (Long.toString(id).equals(str[line][0])) {
                    //找到用户
                    account.setId(id);
                    account.setPass(str[line][1]);
                    account.setName(str[line][2]);
                    account.setPersonID(str[line][3]);
                    account.setEmail(str[line][4]);
                    account.setBalance(Double.parseDouble(str[line][5]));
                    account.setAccountType(Integer.parseInt(str[line][6]));
                    System.out.println("找到该用户!");
                    return account;
                }
            }
        }
        reader.close();
        return null;

    }


    /*
	 * 存款
	 */
    public void deposit(Account account,double money) {
        double balance = account.getBalance();
        balance += money;
        account.setBalance(balance);
    }

    /*
     * 取款
     */
    public void withdraw(Account account,double money) {
        double balance = account.getBalance();
        balance -= money;
        if(balance<0){
            System.out.println("您的余额不足"+money+"元钱"+"请重试");
            return;
        }
        account.setBalance(balance);
    }

    /**
     * 取款（取款方式由账户类型决定，所以设为抽象方法，相应的Account类应设为抽象类）
     *
     * public void withdraw(double money){}
    */

    /*
        转账
        将用户account转到account2
     */
    public void transferAccount(Account account,Account account2,double money) throws IOException {
        System.out.println("转账金额："+money);
        System.out.println("原账号余额："+account.getBalance());
        System.out.println("现账号余额："+account2.getBalance());
        account.setBalance(account.getBalance()-money);
        account2.setBalance(account2.getBalance()+money);
    }

    /*
        1.统计银行所有账户余额总数
     */
    protected static void allAccountBalance() throws IOException {
        BufferedWriter bufWriter = null;
        // 获取当前目录路径
        Properties props = System.getProperties();
        String path = props.getProperty("user.dir");
        // 按行读取文件
        File file = new File(path, "account.txt");
        BufferedReader reader = null;
        reader = new BufferedReader(new FileReader(file));
        String tempString = null;
        //String[][] str = { {}, { "id", "pass", "name", "personID", "email", "balance", "accountType" } };
        String[][] str = new String[10][8];
        int line = 1;
        Double allBalance=0.0;
        System.out.println("id,\tpass,\tname,\tpersonID,\temail,\tbalance,\taccountType,\tcelling");
        System.out.println("-------------------------------------------------------------");
        // 一次读一行,直到读到null为文件结束
        while ((tempString = reader.readLine()) != null) {
            System.out.println(tempString);
            // 求每个人的信息
            String[] info = tempString.split(",");
            System.arraycopy(info, 0, str[line], 0, 8);
            // System.out.println( str[line][0]+"\t"+str[line][1]+"\t"+str[line][2]+"\t"+str[line][3]+"\t"+str[line][4]+"\t"+str[line][5]+"\t"+str[line][6]+"\t"+str[line][7]);
            allBalance+=Double.parseDouble(str[line][5]);
        }
        System.out.println("-------------------------------------------------------------");
        System.out.println("所有账户的总额为："+allBalance);
    }
    /*
        2.统计所有信用账户透支额度总数
     */
    protected static void allAccountCelling() throws IOException {
        BufferedWriter bufWriter = null;
        // 获取当前目录路径
        Properties props = System.getProperties();
        String path = props.getProperty("user.dir");
        // 按行读取文件
        File file = new File(path, "account.txt");
        BufferedReader reader = null;
        reader = new BufferedReader(new FileReader(file));
        String tempString = null;
        //String[][] str = { {}, { "id", "pass", "name", "personID", "email", "balance", "accountType" } };
        String[][] str = new String[10][8];
        int line = 1;
        Double allBalance=0.0;
        System.out.println("id,\tpass,\tname,\tpersonID,\temail,\tbalance,\taccountType,\tcelling");
        System.out.println("-------------------------------------------------------------");
        // 一次读一行,直到读到null为文件结束
        while ((tempString = reader.readLine()) != null) {
            System.out.println(tempString);
            // 求每个人的信息
            String[] info = tempString.split(",");
            System.arraycopy(info, 0, str[line], 0, 8);
            // System.out.println( str[line][0]+"\t"+str[line][1]+"\t"+str[line][2]+"\t"+str[line][3]+"\t"+str[line][4]+"\t"+str[line][5]+"\t"+str[line][6]+"\t"+str[line][7]);
            allBalance+=Double.parseDouble(str[line][7]);
        }
        System.out.println("-------------------------------------------------------------");
        System.out.println("所有信用账户的透支额度为："+allBalance);

    }


    /*
    保存信用户数据
     */
    protected static void saveCredit(CreditAccount account) throws IOException {
        BufferedWriter bufWriter = null;
        // 获取当前目录路径
        Properties props = System.getProperties();
        String path = props.getProperty("user.dir");
		/*
			将新加的数据装入account.txt
		 */
        // 追加写入文件account.txt
        bufWriter = new BufferedWriter(new FileWriter(new File(path, "account.txt"), true));
        // 写入账户信息到account.txt
        bufWriter.write(account.getId() + ",");
        bufWriter.write(account.getPass() + ",");
        bufWriter.write(account.getName() + ",");
        bufWriter.write(account.getPersonID() + ",");
        bufWriter.write(account.getEmail() + ",");
        bufWriter.write(Double.toString(account.getBalance()) + ",");
        bufWriter.write("1,");
        bufWriter.write(Double.toString(account.getCeiling()));
        bufWriter.newLine();
        bufWriter.flush();
        bufWriter.close();
    }
}
