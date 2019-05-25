package User.Interface.layer;

import java.util.Scanner;

public class MainMenu {
	Scanner scanner = new Scanner(System.in);
	AdminMenu adminMenu = new AdminMenu();
	public void mainMenu() {
		StudentMenu studentMenu = new StudentMenu();
		System.out.println("==========宿舍信息管理系统============");
		System.out.println("1.管理员");
		System.out.println("2.学生");
		System.out.println("3.退出");
		int a = scanner.nextInt();
		switch (a) {
		case 1:
			adminLogin();
			break;
		case 2:
			studentMenu.studentMenu();
			break;
		case 3:
			return;
		default:
			break;
		}
	}
	public void adminLogin() {
		System.out.println("用户名：");
		String username =scanner.next();
		System.out.println("密码");
		String password = scanner.next();
		if (username.equals("admin")&&password.equals("123456")) {
			System.out.println("登陆成功");
			adminMenu.admingMenu();
		}else {
			System.out.println("用户名或者密码错误");
			mainMenu();
		}
		
	}
}
