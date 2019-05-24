package User.Interface.layer;

import java.util.Scanner;

import Business.Logic.Layer.DormitoryAllMain;
import Business.Logic.Layer.StudentOperation;

public class FindData {
	Scanner scanner = new Scanner(System.in);
	DormitoryAllMain dormitoryAllMain = new DormitoryAllMain();
	StudentOperation studentOperation = new StudentOperation();
	public void findData() {
		while (true) {
			
			AdminMenu adminMenu = new AdminMenu();
			System.out.println("==========信息查询界面===========");
			System.out.println("1.查看所有学员信息");
			System.out.println("2.查看指定宿舍楼的学员信息");
			System.out.println("3.查看指定宿舍的学员信息");
			System.out.println("4.查看入住率（指定宿舍楼、指定宿舍）");
			System.out.println("5.查看指定学号的学员所在的宿舍");
			System.out.println("6.返回");
			int a = scanner.nextInt();
			switch (a) {
			case 1:
				findAllStudent();
				break;
			case 2:
				findByBuild();
				break;
			case 3:
				findByDormitory();
				break;
			case 4:
				occupancy();
				break;
			case 5:
				
				break;
			case 6:
				adminMenu.admingMenu();
				break;
				
			default:
				break;
			}
		}
	}

	public void findAllStudent() {
		studentOperation.showAll();
	}

	public void findByBuild() {
		System.out.println("请输入要查找的宿舍楼");
		int buildid = scanner.nextInt();
		int a = dormitoryAllMain.findByBuild(buildid);
		switch (a) {
		case 2:
			System.out.println("这栋类没有寝室");
			break;
		case 3:
			System.out.println("没有这栋楼");
			break;
		default:
			break;
		}
	}
	public void findByDormitory() {
		System.out.println("请输入要查找的寝室id");
		int dormitory = scanner.nextInt();
		dormitoryAllMain.show(dormitoryAllMain.findByDormitory(dormitory), dormitory);
	}
	public void occupancy() {
		System.out.println("请输入寝室楼id");
		int buildid = scanner.nextInt();
		System.out.println("请输入寝室id");
		int dormitory = scanner.nextInt();
		dormitoryAllMain.occupancy(buildid, dormitory);
	}
	public void findByStuId() {
		System.out.println("输入要查找的学生id");
		int stuId = scanner.nextInt();
		
	}
}
