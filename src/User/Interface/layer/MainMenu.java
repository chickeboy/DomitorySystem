package User.Interface.layer;

import java.util.Scanner;

public class MainMenu {
	Scanner scanner = new Scanner(System.in);
	AdminMenu adminMenu = new AdminMenu();
	public void mainMenu() {
		StudentMenu studentMenu = new StudentMenu();
		System.out.println("==========������Ϣ����ϵͳ============");
		System.out.println("1.����Ա");
		System.out.println("2.ѧ��");
		System.out.println("3.�˳�");
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
		System.out.println("�û�����");
		String username =scanner.next();
		System.out.println("����");
		String password = scanner.next();
		if (username.equals("admin")&&password.equals("123456")) {
			System.out.println("��½�ɹ�");
			adminMenu.admingMenu();
		}else {
			System.out.println("�û��������������");
			mainMenu();
		}
		
	}
}
