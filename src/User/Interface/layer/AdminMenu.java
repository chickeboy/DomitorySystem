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

		System.out.println("======����Ա����===========");
		System.out.println("1.��������¥");
		System.out.println("2.�������᷿��");
		System.out.println("3.��������");
		System.out.println("4.��Ϣ��ѯ");
		System.out.println("5.ѧ����ס");
		System.out.println("6.ѧ��Ǩ��");
		System.out.println("7.��������");
		System.out.println("8.�����ϲ�");
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
			// ���ҵ���
			break;
		case 8:
			mainMenu.mainMenu();
			break;
		default:
			break;
		}

	}

	public void inputStudent() {
		System.out.println("������Ҫ������StuId");
		int stuId = scanner.nextInt();
		if (adminMain.inputStudent(stuId)) {
			System.out.println("Ҫ��ס������¥");
			int buildId = scanner.nextInt();
			if (adminMain.inputBySex(stuId, buildId)) {
				System.out.println("Ҫ��ס������");
				int dormitory = scanner.nextInt();
				if (adminMain.inputBydormitory(dormitory)) {
					System.out.println("Ҫ��ס�Ĵ���");
					int bedId = scanner.nextInt();
					if (adminMain.inputByBed(bedId)) {
						adminMain.input(stuId, buildId, dormitory, bedId);
					} else {
						System.out.println("��סʧ��");
					}
				} else {
					System.out.println("�����Ҳ�����");
				}
			} else {
				System.out.println("�Ա��ͻ");
			}
		} else {
			System.out.println("��ѧ��������");
		}

	}

	public void outStudent() {
		System.out.println("������Ҫ������StuId");
		int stuId = scanner.nextInt();
		if (adminMain.output(stuId)) {
			System.out.println("Ǩ���ɹ�");
		} else {
			System.out.println("Ǩ��ʧ��");
		}

	}

	public void changeDormitory() {
		System.out.println("==========�������ҽ���===========");
		System.out.println("1.��������");
		System.out.println("2.������������");
		System.out.println("3.�˳�");
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
		System.out.println("������Ҫ������ѧ��id:");
		System.out.print("ѧ��1��");
		int stuId1 = scanner.nextInt();
		System.out.println();
		System.out.print("ѧ��2��");
		int stuId2 = scanner.nextInt();
		if (adminMain.change(stuId1, stuId2)) {
			System.out.println("�����ɹ�");
		}else {
			System.out.println("����ʧ��");
		}	
	}
	public void changeByAll() {
		System.out.println("������Ҫ��������");
		System.out.print("����1:");
		int dormitory1 = scanner.nextInt();
		System.out.println();
		System.out.print("����2��");
		int dormitory2 = scanner.nextInt();
		adminMain.changeAll(dormitory1, dormitory2);
	}
}
