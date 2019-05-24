package User.Interface.layer;

import java.util.Scanner;

import Business.Logic.Layer.Bed;
import Dormitory.Class.DormitoryBed;

public class BedMenu {
	Bed bed = new Bed();
	Scanner scanner = new Scanner(System.in);
	public void bedMenu() {
		AdminMenu adminMenu = new AdminMenu();
		while (true) {	
			System.out.println("=======床铺管理界面============");
			System.out.println("1.添加床铺");
			System.out.println("2.删除床铺");
			System.out.println("3.修改床铺");
			System.out.println("4.查看床铺");
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
				show();
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
			
			System.out.println("宿舍id");
			int dormitory = scanner.nextInt();
			System.out.println("床号");
			int id = scanner.nextInt();
			DormitoryBed dormitoryBed = new DormitoryBed(id, dormitory);
			if (bed.add(dormitoryBed)) {
				System.out.println("添加成功");
			}else {
				System.out.println("添加失败");
			}
			System.out.println("y/n");
			String string = scanner.next();
			if (string.equals("n")) {
				break;
			}
		}
	}
	public void remove() {
		System.out.println("要删除床铺所属宿舍id");
		int dormitory = scanner.nextInt();
		System.out.println("要删除的床铺");
		int id = scanner.nextInt();
		DormitoryBed dormitoryBed = new DormitoryBed(id, dormitory);
		if (bed.remove(dormitoryBed)) {
			System.out.println("删除成功");
		}else {
			System.out.println("删除失败");
		}
		
	}
	public void updata() {
		System.out.println("要修改床铺所属宿舍id");
		int dormitory = scanner.nextInt();
		System.out.println("要修改的床铺");
		int id = scanner.nextInt();
		System.out.println("修改后的床铺所属寝室");//互换寝室只需要修改对应的寝室号就可以
		int newdormitory = scanner.nextInt();
		System.out.println("修改后的床铺id");
		int newid = scanner.nextInt();
		DormitoryBed dormitoryBed =new DormitoryBed(newid, newdormitory);
		if (bed.updata(dormitoryBed, id, dormitory)) {
			System.out.println("修改成功");
		}else {
			System.out.println("修改失败");
		}	
	}
	public void show() {
		while(true) {
			System.out.println("============床铺查询界面===========");
			System.out.println("1.根据寝室查询");
			System.out.println("2.根据床号查询");
			System.out.println("3.退出");
			int a  = scanner.nextInt();
			switch (a) {
			case 1:
				showByid();
				break;
			case 2:
				showBydormitory();
				break;

			case 3:
				bedMenu();
				break;


			default:
				break;
			}
		}
	}
	public void showByid() {
		System.out.println("请输入床号");
		int id = scanner.nextInt();
		if (!bed.showByid(id)) {
			System.out.println("没有数据");
		}
	}
	public void showBydormitory() {
		System.out.println("请输入寝室号");
		int dormitory = scanner.nextInt();
		if (!bed.showBydormitory(dormitory)) {
			bed.showBydormitory(dormitory);
		}
	}
}
