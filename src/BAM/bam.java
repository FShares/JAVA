package BAM;

import java.io.IOException;
import java.util.Scanner;

/*
 * 项目名称:BankAccount Management System 银行账户管理系统 简称BAM 
 */
/*
 * 百度文库链接地址
https://wenku.baidu.com/view/3fd7b6c026fff705cd170a03.html
 */
public class bam {
	public static void main(String[] args) throws IOException {
		// System.out.println("Hello");
		boolean firstFlag = true;					// 标号，判断是否退出一级菜单
		while (firstFlag) {
			//一级菜单
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
				long ID = scanner.nextLong();
				System.out.println("请输入银行密码：");
				String password = scanner.next();
				Account account = Bank.verifyAccount(ID, password);
				if (account != null) { // 标号，判断是否退出二级菜单
//					boolean secondFlag = true;
//					while (secondFlag) { // 二级菜单
						System.out.println("******欢迎使用XXX银行模拟ATM系统，请按如下步骤操作******");
						System.out.println("           *1.查询账户余额");
						System.out.println("           *2.存款");
						System.out.println("           *3.取款");
						System.out.println("           *4.转账");
						System.out.println("           *5.退卡");
						scanner = new Scanner(System.in);
						System.out.print("请选择：");
//					}
				}
				break;
			case 2:
				System.out.println("请输入账户名：");
				long userID = scanner.nextLong();
				System.out.println("请输入账户密码：");
				String passwd1 = scanner.next();
				System.out.println("输再次输入账户密码：");
				String passwd2 = scanner.next();
				scanner = new Scanner(System.in);
				System.out.println("请输入户主姓名：");
				String name = scanner.next();
				scanner = new Scanner(System.in);
				System.out.println("请输入户主身份证号码：");
				String personID = scanner.next();
				System.out.println("请输入户主邮箱地址：");
				String email = scanner.next();
				scanner = new Scanner(System.in);
				System.out.println("请输入账户类型（0储蓄，1信用）：");
				int type = scanner.nextInt();
				Bank.userCreate(userID, passwd1, passwd2, name, personID, email, type);
				//保存用户数据到文本
				Bank.saveAccountDate();
				break;
			case 3:
				firstFlag = false;
				break;
			default:
				System.out.println("选择输入不合法，请重新选择！");
				break;
			}
		}
		System.out.println("谢谢使用");
	}
}

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