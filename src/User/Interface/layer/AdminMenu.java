package User.Interface.layer;

import java.util.Scanner;

import Business.Logic.Layer.AdminMain;
import Business.Logic.Layer.DormitoryAllMain;

public class AdminMenu {
	Scanner scanner = new Scanner(System.in);
	AdminMain adminMain = new AdminMain();
	DormitoryAllMain dormitoryAllMain = new DormitoryAllMain();

	public void admingMenu() {
		MainMenu mainMenu = new MainMenu();
		FindData findData = new FindData();
		Buildmenu buildmenu = new Buildmenu();
		DormitoryMenu dormitoryMenu = new DormitoryMenu();
		BedMenu bedMenu = new BedMenu();

		System.out.println("======管理员界面===========");
		System.out.println("1.操作寝室楼");
		System.out.println("2.操作宿舍房间");
		System.out.println("3.操作床铺");
		System.out.println("4.信息查询");
		System.out.println("5.学生入住");
		System.out.println("6.学生迁出");
		System.out.println("7.调换寝室");
		System.out.println("8.返回上层");
		int a = scanner.nextInt();
		switch (a) {
		case 1:
			buildmenu.buildMenu();
			break;
		case 2:
			dormitoryMenu.dormitoryMenu();
			break;
		case 3:
			bedMenu.bedMenu();
			break;
		case 4:
			findData.findData();
			break;
		case 5:
			inputStudent();
			break;
		case 6:
			outStudent();
			break;
		case 7:
			// 寝室调换
			break;
		case 8:
			mainMenu.mainMenu();
			break;
		default:
			break;
		}

	}

	public void inputStudent() {
		System.out.println("请输入要操作的StuId");
		int stuId = scanner.nextInt();
		if (adminMain.inputStudent(stuId)) {
			System.out.println("要入住的寝室楼");
			int buildId = scanner.nextInt();
			if (adminMain.inputBySex(stuId, buildId)) {
				System.out.println("要入住的寝室");
				int dormitory = scanner.nextInt();
				if (adminMain.inputBydormitory(dormitory)) {
					System.out.println("要入住的床铺");
					int bedId = scanner.nextInt();
					if (adminMain.inputByBed(bedId)) {
						adminMain.input(stuId, buildId, dormitory, bedId);
					} else {
						System.out.println("入住失败");
					}
				} else {
					System.out.println("该寝室不存在");
				}
			} else {
				System.out.println("性别冲突");
			}
		} else {
			System.out.println("该学生不存在");
		}

	}

	public void outStudent() {
		System.out.println("请输入要操作的StuId");
		int stuId = scanner.nextInt();
		if (adminMain.output(stuId)) {
			System.out.println("迁出成功");
		} else {
			System.out.println("迁出失败");
		}

	}

	public void changeDormitory() {
		System.out.println("==========调换寝室界面===========");
		System.out.println("1.调换个人");
		System.out.println("2.调换整个寝室");
		System.out.println("3.退出");
		int a = scanner.nextInt();
		switch (a) {
		case 1:
			changebyOne();
			break;
		case 2:

			break;
		case 3:
			admingMenu();
			break;

		default:
			break;
		}
	}
	public void changebyOne() {
		System.out.println("请输入要交换的学生id:");
		System.out.print("学生1：");
		int stuId1 = scanner.nextInt();
		System.out.println();
		System.out.print("学生2：");
		int stuId2 = scanner.nextInt();
		if (adminMain.change(stuId1, stuId2)) {
			System.out.println("交换成功");
		}else {
			System.out.println("交换失败");
		}	
	}
	public void changeByAll() {
		System.out.println("请输入要换的寝室");
		System.out.print("寝室1:");
		int dormitory1 = scanner.nextInt();
		System.out.println();
		System.out.print("寝室2：");
		int dormitory2 = scanner.nextInt();
		adminMain.changeAll(dormitory1, dormitory2);
	}
}
