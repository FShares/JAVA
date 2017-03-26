package BAM;

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
	private Account[] accounts = new Account[20];
	private static int AccountCount; // 账户数目
	private static int id = 1001;// 确定银行账号从1001开始生成，即第一个账户的账号是1001
	// 构造函数

	public Bank() {
		accounts = new Account[20];// 以后不足时扩容。
		int number = 0;
	}
	public static Account userCreate(String pass1,String pass2, String name, String personID, String email,int type) {
	// 1.用户开户,需要的参数:id,密码,密码确认,姓名,身份证号码,邮箱,账户类型(int),返回新创建的Account对象 
		//创建一个新账户 
		Account account = null;
		if(pass1.equals(pass2)){
			//若一致，再判断账户类型（根据type的值） 
			if(type==1){
				//可令开始余额为10,信用额度为5000 
				account = new CreditAccount();
//				account = new CreditAccount(id, pass1, name, personID, type, 10, 5000); 
			}else{
				
			}
			AccountCount++;
		}
		return account;
	}
}
