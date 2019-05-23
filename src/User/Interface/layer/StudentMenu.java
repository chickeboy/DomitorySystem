package User.Interface.layer;

import java.util.Scanner;

public class StudentMenu {
	public void studentMenu() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("=============学生登陆注册界面================");
		System.out.println("1.登陆");
		System.out.println("2.注册");
		System.out.println("3.返回上一级");
		int a = scanner.nextInt();
		switch (a) {
		case 1:
			//登陆的方法
			break;
		case 2:
			//注册的方法
			break;
		case 3:
			//返回上一级的方法
			break;
		default:
			break;
		}
	}
}
