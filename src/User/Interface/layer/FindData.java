package User.Interface.layer;

import java.util.Scanner;

public class FindData {
	Scanner scanner = new Scanner(System.in);

	public void findData() {
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
			//查看所有学员信息
			break;
		case 2:
			
			break;
		case 3:

			break;
		case 4:

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

	public void findAllStudent() {

	}

	public void findByBuild() {
		System.out.println("请输入要查找的宿舍楼");
		int buildid = scanner.nextInt();
		
	}
}
