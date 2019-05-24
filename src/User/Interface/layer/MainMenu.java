package User.Interface.layer;

import java.util.Scanner;

public class MainMenu {
	public void mainMenu() {
		Scanner scanner = new Scanner(System.in);
		AdminMenu adminMenu = new AdminMenu();
		StudentMenu studentMenu = new StudentMenu();
		System.out.println("==========宿舍信息管理系统============");
		System.out.println("1.管理员");
		System.out.println("2.学生");
		System.out.println("3.退出");
		int a = scanner.nextInt();
		switch (a) {
		case 1:
			adminMenu.admingMenu();
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
}
