package User.Interface.layer;

import java.util.Scanner;

class LoginMenu {
	Scanner scanner = new Scanner(System.in);
	public void StudentLongin() {

	}

	public void AdminLongin() {
		AdminMenu adminMenu = new AdminMenu();
		System.out.println("�˺�");
		String username = scanner.next();
		System.out.println("����");
		String password = scanner.next();
		if (username.equals("admin")&&password.equals("123456")) {
			System.out.println("��½�ɹ�");
			adminMenu.admingMenu();
		}else {
			System.out.println("�û��������������");
		}
	}
}
