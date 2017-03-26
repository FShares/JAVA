package BAM;

import java.util.Scanner;

/*
 * 项目名称:BankAccount Management System 银行账户管理系统 简称BAM 
 */
/*
 * 百度文库链接地址
https://wenku.baidu.com/view/3fd7b6c026fff705cd170a03.html
 */
public class bam {
	public static void main(String[] args) {
		// System.out.println("Hello");
		System.out.println("欢迎光临银行信用业务");

		System.out.println("******欢迎使用XXX银行模拟ATM系统，请按如下步骤操作******");
		System.out.println("    *1.用已有账户登录");
		System.out.println("    *2.没有账户，开户");
		System.out.println("    *3.退出");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.print("请选择：");
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
			scanner = new Scanner(System.in);
			System.out.println("请输入银行卡号：");
			String ID = scanner.next();
			System.out.println("请输入银行密码：");
			String password = scanner.next();
			System.out.println("ID: "+ID +"\npassword: "+password );
			break;
		case 2:
			//账号id由银行自动提供（从1001递增）
			System.out.println("请输入账户密码：");
			String passwd1 = scanner.next(); 
			System.out.println("输再次输入账户密码：");
			String passwd2 = scanner.next();
			scanner = new Scanner(System.in); 
			System.out.print("请输入户主姓名：");
			String name = scanner.next();
			scanner = new Scanner(System.in);
			System.out.print("请输入户主身份证号码：");
			String personID = scanner.next(); 
			System.out.println("请输入户主邮箱地址：");
			String email = scanner.next();
			scanner = new Scanner(System.in); 
			System.out.print("请输入账户类型（0储蓄，1信用）："); 
			int type = scanner.nextInt();
			Bank.userCreate(passwd1,passwd2, name, personID, email, type);
			break; 
		case 3:
			break;
		default:
			System.out.println("选择输入不合法，请重新选择！");
			break;
		}

	/*
	 * 开户 需要的参数:id,密码,密码确认,姓名,身份证号码,邮箱,账户类型(int),返回新创建的Account对象
	 */

}}

/*
 *
 * 
 * System.out.println("******欢迎使用XXX银行模拟ATM系统，请按如下步骤操作******");
 * System.out.println("           *1.查询账户余额"); System.out.println(
 * "           *2.存款"); System.out.println("           *3.取款");
 * System.out.println("           *4.转账"); System.out.println("           *5.退卡"
 * ); Scanner choice2 = new Scanner(System.in); System.out.print("请选择："); int
 * choice = choice2.nextInt(); switch (choice) { case 1:
 * System.out.println("您账户的当前余额为："); break;
 * 
 * case 2: break; case 3: break; default: System.out.println("选择输入不合法，请重新选择！");
 * break; }
 *
 * 
 */