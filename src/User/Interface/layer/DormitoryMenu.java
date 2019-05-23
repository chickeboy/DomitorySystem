package User.Interface.layer;

import java.util.Scanner;

import Business.Logic.Layer.DormitoryMain;
import Dormitory.Class.DormitoryDormitory;

public class DormitoryMenu {
	Scanner scanner = new Scanner(System.in);
	AdminMenu adminMenu = new AdminMenu();
	DormitoryMain dormitoryMain = new DormitoryMain();
	public void dormitoryMenu() {
		while (true) {	
			System.out.println("=========宿舍房间管理界面============");
			System.out.println("1.添加房间");
			System.out.println("2.删除房间");
			System.out.println("3.修改房间");
			System.out.println("4.查询房间");
			System.out.println("5.退出");
			int a = scanner.nextInt();
			switch (a) {
			case 1:
				add();
				break;
			case 2:
				remove();
				break;
			case 3:
				updata();
				break;
			case 4:
				showdata();
				break;
			case 5:
				adminMenu.admingMenu();
				break;
				
			default:
				break;
			}
		}
	}
	public void add() {
		while (true) {
			System.out.println("宿舍楼id");
			int buildid = scanner.nextInt();
			System.out.println("寝室id");
			int id = scanner.nextInt();
			System.out.println("寝室最大容量");
			int capacity = scanner.nextInt();
			DormitoryDormitory dormitory = new DormitoryDormitory(id, buildid, capacity);
			if (dormitoryMain.add(dormitory)) {
				System.out.println("添加成功");
			}else {
				System.out.println("该数据已经存在");
			}
			System.out.println("y/n");
			String string =scanner.next();
			if (string.equals("n")) {
				break;
			}
		}
	}
	public void remove() {
		System.out.println("寝室楼id");
		int bulidid = scanner.nextInt();
		System.out.println("要删除的寝室id");
		int id = scanner.nextInt();
		DormitoryDormitory dormitory = new DormitoryDormitory(id,bulidid);
		if (dormitoryMain.remove(dormitory)) {
			System.out.println("删除成功");
		}else {
			System.out.println("删除失败");
		}
	}
	public void updata() {
		System.out.println("要修改的寝室所在寝室楼号");
		int buildId = scanner.nextInt();
		System.out.println("要修改的寝室id");
		int id = scanner.nextInt();
		System.out.println("修改后的寝室楼id");
		int newbuildid = scanner.nextInt();
		System.out.println("修改后的寝室id");
		int newid = scanner.nextInt();
		System.out.println("修改后的寝室最大人数");
		int newcapacity = scanner.nextInt();
		DormitoryDormitory dormitory = new DormitoryDormitory(newid, newbuildid, newcapacity);
		if (dormitoryMain.updata(dormitory, id,buildId)) {
			System.out.println("修改成功");
		}else {
			System.out.println("修改失败");
		}
	}
	public void showdata() {
		System.out.println("=======查询方式==========");
		System.out.println("1.根据寝室id查询");
		System.out.println("2.显示所有数据");
		System.out.println("3.退出");
		int a = scanner.nextInt();
		switch (a) {
		case 1:
			showById();
			break;
		case 2:
			dormitoryMain.showd();
			break;
		case 3:
			dormitoryMenu();
			break;
		default:
			break;
		}
	}
	public void showById() {
		System.out.println("要查询的寝室号");
		int id = scanner.nextInt();
		dormitoryMain.showById(id);
	}
}
