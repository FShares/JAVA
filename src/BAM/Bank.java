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
 
 */
public class Bank {
	int Accountlist[];
	int AccountCount=0;

	Account userCreate(long id, String pass, String name, String personID, String email, double balance) {
		Account A1 = new Account();
		AccountCount++;
		return A1;
	}
}
