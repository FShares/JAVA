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
		int choice1 = scanner.nextInt();
		switch (choice1) {
		case 1:
			break;
		case 2:
			scanner = new Scanner(System.in);
			System.out.print("请输入银行卡号：");
			String ID = scanner.next();
			System.out.print("请输入银行密码：");
			String password = scanner.next();
			System.out.println("ID: "+ID +"\npassword: "+password );
			break;
		default:
			System.out.println("选择输入不合法，请重新选择！");
			break;
		}

		

	}
}

/*
*

System.out.println("******欢迎使用XXX银行模拟ATM系统，请按如下步骤操作******");
System.out.println("           *1.查询账户余额");
System.out.println("           *2.存款");
System.out.println("           *3.取款");
System.out.println("           *4.转账");
System.out.println("           *5.退卡");
Scanner choice2 = new Scanner(System.in);
System.out.print("请选择：");
int choice = choice2.nextInt();
switch (choice) {
case 1:
	System.out.println("您账户的当前余额为：");
	break;

case 2:
	break;
case 3:
	break;
default:
	System.out.println("选择输入不合法，请重新选择！");
	break;
}

*
*/