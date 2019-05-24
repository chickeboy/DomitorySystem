package User.Interface.layer;

import java.util.Scanner;

import Business.Logic.Layer.SchoolCardMain;
import Business.Logic.Layer.StudentOperation;
import Data.access.layer.StudentMain;
import Dormitory.Class.Student;

public class StudentMenu {
	Scanner scanner = new Scanner(System.in);
	StudentMain studentMain = new StudentMain();
	StudentOperation studentOperation = new StudentOperation();
	MainMenu mainMenu = new MainMenu();
	SchoolCardMain schoolCardMain = new SchoolCardMain();

	public void studentMenu() {
		while (true) {
			System.out.println("=============学生登陆注册界面================");
			System.out.println("1.登陆");
			System.out.println("2.注册");
			System.out.println("3.返回上一级");
			int a = scanner.nextInt();
			switch (a) {
			case 1:
				longin();
				break;
			case 2:
				registered();
				break;
			case 3:
				mainMenu.mainMenu();
				break;
			default:
				break;
			}
		}
	}

	public void registered() {
		System.out.println("name");
		String name = scanner.next();
		System.out.println("sex");
		String sex = scanner.next();
		System.out.println("password");
		String password = scanner.next();
		System.out.println("phonenumber");
		String phonenumber = scanner.next();
		System.out.println("marjore");
		String marj = scanner.next();
		Student student = new Student(name, sex, password, phonenumber, marj);
		if (studentOperation.add(student)) {
			System.out.println("注册成功");
			studentMainMenu();
		} else {
			System.out.println("注册失败");
		}
	}

	public void longin() {
		System.out.println("请输入id");
		int id = scanner.nextInt();
		System.out.println("请输入姓名");
		String name = scanner.next();
		System.out.println("请输入密码");
		String password = scanner.next();
		if (studentOperation.longin(id, name, password)) {
			System.out.println("登陆成功");
			studentMainMenu();
		} else {
			System.out.println("登陆失败");
		}
	}

	public void studentMainMenu() {
		System.out.println("=========学生操作界面=======");
		System.out.println("1.注册校园卡");
		System.out.println("2.模拟消费");
		System.out.println("3.报修");
		System.out.println("4.充值");
		System.out.println("5.查看充值记录");
		System.out.println("6.修改密码");
		System.out.println("7.退出");
		int a = scanner.nextInt();
		switch (a) {
		case 1:
			addSchoolcard();
			break;
		case 2:

			break;
		case 3:

			break;
		case 4:
			rechargeable();
			break;
		case 5:
			findRechargeable();
			break;
		case 6:

			break;
		case 7:
			mainMenu.mainMenu();
			break;

		default:
			break;
		}
	}

	public void addSchoolcard() {
		System.out.println("stuid");
		int stuId = scanner.nextInt();
		System.out.println("请输入支付密码：");
		String payid = scanner.next();
		schoolCardMain.addSchoolCard(stuId, payid);
	}

	public void rechargeable() {
		System.out.println("请输入你的stuid");
		int stuid = scanner.nextInt();
		System.out.println("请输入你的payid");
		String payid = scanner.next();
		if (schoolCardMain.rechargeable(stuid, payid)) {
			System.out.println("要充多少钱");
			int money = scanner.nextInt();
			schoolCardMain.rechargeable(stuid, payid, money);
		} else {
			System.out.println("该卡不存在");
		}
	}
	public void findRechargeable() {
		System.out.println("请输入你的stuid");
		int stuid = scanner.nextInt();
		System.out.println("请输入payid");
		String payid = scanner.next();
		if (schoolCardMain.rechargeable(stuid, payid)) {
			schoolCardMain.showAll(stuid);
		}
		
		
	}
	public void consumption() {
		System.out.println("======消费界面========");
	}
}
