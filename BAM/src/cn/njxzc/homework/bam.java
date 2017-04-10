package cn.njxzc.homework;

import sun.util.resources.cldr.aa.CalendarData_aa_DJ;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

/*
 * 项目名称:BankAccount Management System 银行账户管理系统 简称BAM 
 */
/*
 * 百度文库链接地址
https://wenku.baidu.com/view/3fd7b6c026fff705cd170a03.html
 */
public class bam {
	//属性
	private Bank bank;
	//构造函数
	private bam() {  bank = new Bank(); }
	public static void main(String[] args) throws IOException {
		// System.out.println("Hello");
		bam BAM = new bam();
		//实例化ATM
		Bank bank = BAM.bank;
		boolean firstFlag = true;					// 标号，判断是否退出一级菜单
		while (firstFlag) {
			//一级菜单
			System.out.println("******欢迎使用XXX银行模拟ATM系统，请按如下步骤操作******");
			System.out.println("    *1.用已有账户登录");
			System.out.println("    *2.没有账户，开户");
			System.out.println("    *3.所有账户统计");
			System.out.println("    *4.退出");
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			System.out.print("请选择：");
			int choice = scanner.nextInt();
			switch (choice) {
				case 1:
					scanner = new Scanner(System.in);
					System.out.println("请输入用户名：");
					long ID = scanner.nextLong();
					System.out.println("请输入银行密码：");
					String password = scanner.next();
					Account account = Bank.verifyAccount(ID, password);
					if (account != null) {
						// 标号，判断是否退出二级菜单
						boolean secondFlag = true;
						while (secondFlag) { // 二级菜单
							System.out.println("******欢迎使用XXX银行模拟ATM系统，请按如下步骤操作******");
							System.out.println("           *1.查询账户余额");
							System.out.println("           *2.存款");
							System.out.println("           *3.取款");
							System.out.println("           *4.转账");
							System.out.println("           *5.退卡");

							scanner = new Scanner(System.in);
							System.out.print("请选择：");
							Integer choice2 = scanner.nextInt();
							switch (choice2) {
								case 1:
									System.out.println("您的账户还有" + account.getBalance() + " 元钱");
									break;
								case 2:
									scanner = new Scanner(System.in);
									System.out.print("请输入您的存款金额：");
									double money1 = scanner.nextDouble();
									bank.deposit(account, money1);
									//保存用户数据到文本
									bam.saveAccountDate(account);
									break;
								case 3:
									//取款
									scanner = new Scanner(System.in);
									System.out.print("请输入您的取款金额：");
									double money2 = scanner.nextDouble();
									bank.withdraw(account, money2);
									//保存用户数据到文本
									bam.saveAccountDate(account);
									System.out.println("取款" + money2 + "成功,您的账户还有" + account.getBalance() + " 元钱");
									break;
								case 4:
									//转账
									scanner = new Scanner(System.in);
									System.out.print("请输入您要转入账户的卡号：");
									long id2 = scanner.nextLong();
									Account account2 = Bank.queryAccount(id2);
									if (account2 != null) {
										scanner = new Scanner(System.in);
										System.out.print("请输入您要转入账户的金额：");
										double money = scanner.nextLong();
										if (money <= account.getBalance()) {
											//验证账户余额是否大于转出的额度
											bank.transferAccount(account, account2, money);
											//保存用户数据到文本
											bam.saveAccountDate(account);
											bam.saveAccountDate(account2);
											System.out.println("转账成功,您的余额为：" + account.getBalance());
										} else {
											System.out.println("抱歉，您账户没有足够的金额！请查看后重新选择输入！");
										}
									} else {
										System.out.println("抱歉，没有找到您要转入的账户信息！请核对后重新选择输入！");
									}

									break;
								case 5:
									//退卡
									secondFlag = false;
									break;
								default:
									System.out.println("选择输入不合法，请重新选择！");
									break;
							}
						}
					} else {
						System.out.println("用户名与密码不匹配！");
					}
					break;
				case 2:
					System.out.println("请输入账户名：");
					long userID = scanner.nextLong();
					Account loginAccount = Bank.queryAccount(userID);
					while (loginAccount != null) {
						System.out.println("输入的用户名已存在，请重新输入：");
						userID = scanner.nextLong();
						loginAccount = Bank.queryAccount(userID);
					}
					System.out.println("请输入账户密码：");
					String passwd1 = scanner.next();
					System.out.println("输再次输入账户密码：");
					String passwd2 = scanner.next();
					scanner = new Scanner(System.in);
					//判断两次密码是否匹配
					while (!passwd1.equals(passwd2)) {
						System.out.println("两次密码不匹配！");
						System.out.println("请重新输入密码：");
						passwd1 = scanner.next();
						System.out.println("输再次输入账户密码：");
						passwd2 = scanner.next();
					}
					System.out.println("请输入户主姓名：");
					String name = scanner.next();
					/*
						姓名正则
					 */
					scanner = new Scanner(System.in);
					System.out.println("请输入户主身份证号码：");
					String personID = scanner.next();
					/*
						身份证号码正则
					 */
					System.out.println("请输入户主邮箱地址：");
					scanner = new Scanner(System.in);
					String email = scanner.next();
					/*
						 邮箱正则
					 */
					System.out.println("请输入账户类型（0储蓄，1信用）：");
					int type = scanner.nextInt();
					while (type != 1 && type != 0) {
						System.out.println("类型输入有误,请输入（0储蓄，1信用）：");
						type = scanner.nextInt();
					}
					if (type == 1) {
						//信用账号
						CreditAccount CreAccount = (CreditAccount) Bank.userCreate(userID, passwd1, name, personID, email, type);
						Bank.saveCredit(CreAccount);
						System.out.println("您的信用余额为：" + CreAccount.getCeiling() + "\n");
					} else {
						//储蓄账户
						Account Aaccount = Bank.userCreate(userID, passwd1, name, personID, email, type);
						//保存用户数据到文本
						bam.saveAccountDate(Aaccount);
					}
					break;
				case 3:
					// 标号，判断是否退出二级菜单
					boolean secondFlag = true;
					while (secondFlag) { // 二级菜单
						System.out.println("******欢迎使用XXX银行模拟后台，请按如下步骤操作******");
						System.out.println("           *1.银行所有账户余额总数统计");
						System.out.println("           *2.银行所有信用账户透支额度统计");
						System.out.println("           *3.退出");
						Integer chooice = scanner.nextInt();
						switch (chooice) {
							case 1:
								Bank.allAccountBalance();
								//所有账户的余额 统计
								break;
							case 2:
								//所有信用账户透支额度
								Bank.allAccountCelling();
								break;
							case 3:
								secondFlag = false;
								break;
							default:
								System.out.println("选择输入不合法，请重新选择！");
								break;
						}
					}

					break;
				case 4:
					firstFlag = false;
					break;
				default:
					System.out.println("选择输入不合法，请重新选择！");
					break;
			}
		}
		System.out.println("谢谢使用");
	}


	/**
	 * 保存数据(储蓄账户）
	 *
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	private static void saveAccountDate(Account account) throws IOException {
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
		List<String> list = new ArrayList<>();
		// 一次读一行,直到读到null为文件结束
		while ((tempString = reader.readLine()) != null) {
			// 求每个人的信息
			String[] info = tempString.split(",");
			System.arraycopy(info, 0, str[line], 0, 8);
			for (int i = 0; i < line; i++) {
				//System.out.println("用户名：" + str[line][0]);
				if (Long.toString(account.getId()).equals(str[line][0])) {
					//查找数据中的用户名是否匹配
					//System.out.println("这是第 "+line+" 行");
					//break;
					continue;
				}
				list.add(tempString);
			}
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File(path, "account.txt")));
			for (String aList : list) {
				//System.out.println("list["+i+"]"+list.get(i));
				bw.write(aList);
				bw.newLine();
			}
			bw.flush();
			bw.close();
		}
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
		bufWriter.write(Integer.toString(account.getAccountType()) + ",");
		if (account.getAccountType() == 1) {
			bufWriter.write("5000");
		} else {
			bufWriter.write("0");
		}
		bufWriter.newLine();
		bufWriter.flush();
		bufWriter.close();
	}




	/**
	 * 保存数据(储蓄账户）
	 *
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	private static void saveCredit(CreditAccount account) throws IOException {
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
		String [][] str = new String[10][8];
		int line = 1;
		List<String> list = new ArrayList<>();
		// 一次读一行,直到读到null为文件结束
		while ((tempString = reader.readLine()) != null) {
			// 求每个人的信息
			String[] info = tempString.split(",");
			System.arraycopy(info, 0, str[line], 0, 7);
			for (int i = 0; i < line; i++) {
				//System.out.println("用户名：" + str[line][0]);
				if (Long.toString(account.getId()).equals(str[line][0])) {
					//查找数据中的用户名是否匹配
					//System.out.println("这是第 "+line+" 行");
					//break;
					continue;
				}
				list.add(tempString);
			}
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File(path, "account.txt")));
			for (String aList : list) {
				//System.out.println("list["+i+"]"+list.get(i));
				bw.write(aList);
				bw.newLine();
			}
			bw.flush();
			bw.close();
		}
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
		bufWriter.write(Integer.toString(account.getAccountType())+",");
		bufWriter.write(Double.toString(account.getCeiling()));
		bufWriter.newLine();
		bufWriter.flush();
		bufWriter.close();
	}
}