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
		System.out.println("======����Ա����===========");
		System.out.println("1.��������¥");
		System.out.println("2.�������᷿��");
		System.out.println("3.��������");
		System.out.println("4.��Ϣ��ѯ");
		System.out.println("5.ѧ����ס");
		System.out.println("6.�����ϲ�");
		
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
			//�������¥�ķ���
			break;
		case 5:
			//��ѯ��Ϣ����
			break;
		case 6:
			mainMenu.mainMenu();
			break;
		default:
			break;
		}
		
	}
}
