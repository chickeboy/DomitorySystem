package User.Interface.layer;

import java.util.HashMap;
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
			System.out.println("=============学生登陆注册界面================");
			System.out.println("1.登陆");
			System.out.println("2.注册");
			System.out.println("3.忘记密码");
			System.out.println("4.返回上一级");
			int a = scanner.nextInt();
			switch (a) {
			case 1:
				longin();
				break;
			case 2:
				registered();
				break;
			case 3:
				forgotpassword();
				break;
			case 4:
				mainMenu.mainMenu();
				break;
			default:
				break;
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
		System.out.println("ques1");
		String str = scanner.next();
		System.out.println("ans1");
		String str2 = scanner.next();
		HashMap<String, String> hashMap = new HashMap<String, String>();
		hashMap.put(str, str2);
		System.out.println("ques2");
		str = scanner.next();
		System.out.println("ans2");
		str2 = scanner.next();
		hashMap.put(str, str2);
		System.out.println("ques3");
		str = scanner.next();
		System.out.println("ans3");
		str2 = scanner.next();
		hashMap.put(str, str2);
		Student student = new Student(name, sex, password, phonenumber, marj,hashMap);
		int stuid = studentOperation.add(student);
		if (stuid!=-1) {
			System.out.println("注册成功");
			System.out.println("你获得的学号是："+stuid);
			studentMainMenu();
		} else {
			System.out.println("注册失败");
			studentMenu();
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
			studentMenu();
		}
	}
	public void forgotpassword() {
		System.out.println("通过密保找回密码");
		System.out.println("stuid");
		int stuid = scanner.nextInt();
		System.out.println(studentOperation.findques(stuid));
		String string = scanner.next();
		if (studentOperation.findans(stuid, string)) {
			System.out.println("验证成功");
			System.out.println("你的密码为："+studentOperation.getPassword(stuid));
			System.out.println("是否去修改密码 y/n");
			string = scanner.next();
			if (string.equals("y")) {
				changePasword();
			}else {
				studentMenu();
			}
		}else {
			System.out.println("验证失败");
			studentMenu();
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
			consumption();
			break;
		case 3:
			repair();
			break;
		case 4:
			rechargeable();
			break;
		case 5:
			findRechargeable();
			break;
		case 6:
			change();
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
		if (schoolCardMain.findcard(stuId)) {
			System.out.println("请输入支付密码：");
			String payid = scanner.next();
			if (schoolCardMain.addSchoolCard(stuId, payid)) {
				System.out.println("注册成功");
				studentMainMenu();
			}else {
				System.out.println("注册失败");
				studentMainMenu();
			}
		}else {
			System.out.println("该学生已经注册过校园卡");
		}
		studentMainMenu();
	}

	public void rechargeable() {
		System.out.println("请输入你的stuid");
		int stuid = scanner.nextInt();
		System.out.println("请输入你的payid");
		String payid = scanner.next();
		if (schoolCardMain.rechargeable(stuid, payid)) {
			int a = (int) Math.floor(Math.random()*1000+1000);
			System.out.println("验证码"+a);
			int b = scanner.nextInt();
			if (b == a) {
				
				System.out.println("要充多少钱");
				int money = scanner.nextInt();
				schoolCardMain.rechargeable(stuid, payid, money);
			}
			studentMainMenu();
		} else {
			System.out.println("该卡不存在");
			studentMainMenu();
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
		studentMainMenu();
	}

	public void consumption() {
		System.out.println("======消费界面========");
		System.out.println("1.洗衣服");
		System.out.println("2.打水");
		System.out.println("3.洗澡");
		System.out.println("4.网费");
		System.out.println("5.返回");
		int a = scanner.nextInt();
		switch (a) {
		case 1:
			clothes();
			break;
		case 2:
			water();
			break;
		case 3:
			shower();
			break;
		case 4:
			internetfee();
			break;
		case 5:
			studentMainMenu();
			break;

		default:
			break;
		}

	}

	public void clothes() {
		System.out.println("请输入你的stuid");
		int stuid = scanner.nextInt();
		System.out.println("请输入你的payid");
		String payid = scanner.next();
		if (schoolCardMain.rechargeable(stuid, payid)) {
			int a = studentOperation.consumption(stuid, 5);
			if (a!=-1) {
				System.out.println("消费成功");
				System.out.println("你的余额："+a);
				consumption();
			} else {
				System.out.println("余额不足");
				consumption();
			}
		} else {
			System.out.println("输入错误");
			consumption();
		}

	}

	public void water() {
		System.out.println("请输入你的stuid");
		int stuid = scanner.nextInt();
		System.out.println("请输入你的payid");
		String payid = scanner.next();
		if (schoolCardMain.rechargeable(stuid, payid)) {
			int a = studentOperation.consumption(stuid, 1);
			if (a!=-1) {
				System.out.println("消费成功");
				System.out.println("你的余额："+a);
				consumption();
			} else {
				System.out.println("余额不足");
				consumption();
			}
		} else {
			System.out.println("输入错误");
			consumption();
		}
	}

	public void shower() {
		System.out.println("请输入你的stuid");
		int stuid = scanner.nextInt();
		System.out.println("请输入你的payid");
		String payid = scanner.next();
		if (schoolCardMain.rechargeable(stuid, payid)) {
			int a = studentOperation.consumption(stuid, 5);
			if (a!=-1) {
				System.out.println("消费成功");
				System.out.println("你的余额："+a);
				consumption();
			} else {
				System.out.println("余额不足");
				consumption();
			}
		} else {
			System.out.println("输入错误");
			consumption();
		}
	}

	public void internetfee() {
		System.out.println("请输入你的stuid");
		int stuid = scanner.nextInt();
		System.out.println("请输入你的payid");
		String payid = scanner.next();
		if (schoolCardMain.rechargeable(stuid, payid)) {
			int a = studentOperation.consumption(stuid, 50);
			if (a!=-1) {
				System.out.println("消费成功");
				System.out.println("你的余额："+a);
				consumption();
			} else {
				System.out.println("余额不足");
				consumption();
			}
		} else {
			System.out.println("输入错误");
			consumption();
		}
	}

	public void repair() {
		System.out.println("你的学生id");
		int stuid = scanner.nextInt();
		System.out.println("报修的寝室");
		int dormitory = scanner.nextInt();
		System.out.println("报修的内容");
		String content = scanner.next();
		studentOperation.repair(stuid, dormitory, content);
		studentMainMenu();
	}

	public void change() {
		System.out.println("=======密码修改界面==========");
		System.out.println("1.修改密码");
		System.out.println("2.修改支付密码");
		System.out.println("3.退出");
		int a = scanner.nextInt();
		switch (a) {
		case 1:
			changePasword();
			break;
		case 2:
			chagePayid();
			break;
		case 3:
			studentMainMenu();
			break;

		default:
			break;
		}
	}

	public void changePasword() {
		System.out.println("输入你的stuid");
		int stuid = scanner.nextInt();
		System.out.println("输入你的name");
		String name =scanner.next();
		System.out.println("输入你的password");
		String password = scanner.next();
		if (studentOperation.longin(stuid, name, password)) {
			System.out.println("新的password:");
			String newpassword = scanner.next();
			studentOperation.changePassword(stuid, newpassword);
			studentMainMenu();
		}else {
			System.out.println("学生不存在");
			studentMainMenu();
		}
	}
	public void chagePayid() {
		System.out.println("请输入你的SchoolCardId");
		int schoolId = scanner.nextInt();
		System.out.println("请输入你的stuid");
		int stuid = scanner.nextInt();
		System.out.println("请输入你的payid");
		String payid = scanner.next();
		if (schoolCardMain.rechargeable(stuid, payid)) {
			System.out.println("请输入newpayid");
			String newPayId =scanner.next();
			schoolCardMain.changePayId(schoolId, stuid, newPayId);
		}
	}
}
