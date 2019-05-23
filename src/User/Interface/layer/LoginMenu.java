package User.Interface.layer;

import java.util.Scanner;

class LoginMenu {
	Scanner scanner = new Scanner(System.in);
	public void StudentLongin() {

	}

	public void AdminLongin() {
		AdminMenu adminMenu = new AdminMenu();
		System.out.println("账号");
		String username = scanner.next();
		System.out.println("密码");
		String password = scanner.next();
		if (username.equals("admin")&&password.equals("123456")) {
			System.out.println("登陆成功");
			adminMenu.admingMenu();
		}else {
			System.out.println("用户名或者密码错误");
		}
	}
}
