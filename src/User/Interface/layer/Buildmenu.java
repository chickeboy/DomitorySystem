package User.Interface.layer;

import java.util.Scanner;

import Business.Logic.Layer.Build;
import Dormitory.Class.DormitoryBuilding;

public class Buildmenu {
	Scanner scanner = new Scanner(System.in);
	Build build = new Build();

	public void buildMenu() {
		AdminMenu adminMenu = new AdminMenu();
			System.out.println("=========宿舍楼管理界面===========");
			System.out.println("1.添加宿舍楼");
			System.out.println("2.删除宿舍楼");
			System.out.println("3.修改宿舍楼");
			System.out.println("4.查询宿舍楼");// 根据类型查找或者根据id查找
			System.out.println("5.退出");
			int a = scanner.nextInt();
			switch (a) {
			case 1:
				addBuild();
				break;
			case 2:
				removeBuild();
				break;
			case 3:
				updata();
				break;
			case 4:
				show();
				break;
			case 5:
				adminMenu.admingMenu();
				break;
			default:
				break;
			}
		}
	public void addBuild() {
		while (true) {
			System.out.println("请输入要添加的寝室楼id");
			int id = scanner.nextInt();
			System.out.println("请输入寝室楼类型");
			String type = scanner.next();
			DormitoryBuilding building = new DormitoryBuilding(type, id);
			if (build.add(building)) {
				System.out.println("添加成功");
			} else {
				System.out.println("添加失败");
			}
			System.out.println("y/n");
			String string = scanner.next();
			if (string.equals("n")) {
				break;
			}
		}
		buildMenu();
	}

	public void removeBuild() {
		System.out.println("请输入要删除的寝室楼id");
		int id = scanner.nextInt();
		System.out.println("请输入要删除的寝室楼类型");
		String type = scanner.next();
		DormitoryBuilding dormitoryBuilding = new DormitoryBuilding(type, id);
		if (build.remove(dormitoryBuilding)) {
			System.out.println("删除成功");
		} else {
			System.out.println("删除失败");
		}
	}

	public void updata() {
		System.out.println("请输入要修改的寝室楼id");
		int id = scanner.nextInt();
		System.out.println("请输入修改后的寝室楼id");
		int newid = scanner.nextInt();
		System.out.println("请输入修改后寝室楼类型");
		String newtype = scanner.next();
		DormitoryBuilding dormitoryBuilding = new DormitoryBuilding(newtype, newid);
		if (build.updata(dormitoryBuilding, id)) {
			System.out.println("修改成功");
		} else {
			System.out.println("修改失败");
		}
	}

	public void show() {
			System.out.println("======查询寝室楼信息界面========");
			System.out.println("1.根据id查询");
			System.out.println("2.根据类型查询");
			System.out.println("3.显示所有");
			System.out.println("4.返回");
			int a = scanner.nextInt();
			switch (a) {
			case 1:
				showByid();
				break;
			case 2:
				showByType();
				break;
			case 3:
				showAll();
				break;
			case 4:
				buildMenu();
				break;
			default:
				break;
			}
	}
	public void showByid() {
		System.out.println("请输入id");
		int id = scanner.nextInt();
		if (!build.findByid(id)) {
			System.out.println("没有数据");
		}
	}
	public void showByType() {
		System.out.println("请输入type");
		String type = scanner.next();
		if (!build.findBytype(type)) {
			System.out.println("没有数据");
		}
	}
	public void showAll() {
		if (!build.showAll()) {
			System.out.println("没有数据");
		}
		buildMenu();
	}
	
}
