package User.Interface.layer;

import java.util.Scanner;

public class AdminMenu {
	public void admingMenu() {
		MainMenu mainMenu = new MainMenu();
		Buildmenu buildmenu = new Buildmenu();
		DormitoryMenu dormitoryMenu = new DormitoryMenu();
		BedMenu bedMenu = new BedMenu();
		Scanner scanner = new Scanner(System.in);
		Start start = new Start();
		System.out.println("======管理员界面===========");
		System.out.println("1.操作寝室楼");
		System.out.println("2.操作宿舍房间");
		System.out.println("3.操作床铺");
		System.out.println("4.信息查询");
		System.out.println("5.学生入住");
		System.out.println("6.返回上层");
		
		int a  = scanner.nextInt();
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
			//添加寝室楼的方法
			break;
		case 5:
			//查询信息界面
			break;
		case 6:
			mainMenu.mainMenu();
			break;
		default:
			break;
		}
		
	}
}
