package User.Interface.layer;

import java.util.Scanner;

public class MainMenu {
	public void mainMenu() {
		Scanner scanner = new Scanner(System.in);
		AdminMenu adminMenu = new AdminMenu();
		StudentMenu studentMenu = new StudentMenu();
		System.out.println("==========������Ϣ����ϵͳ============");
		System.out.println("1.����Ա");
		System.out.println("2.ѧ��");
		System.out.println("3.�˳�");
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
