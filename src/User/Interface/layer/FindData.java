package User.Interface.layer;

import java.util.Scanner;

public class FindData {
	Scanner scanner = new Scanner(System.in);

	public void findData() {
		AdminMenu adminMenu = new AdminMenu();
		System.out.println("==========��Ϣ��ѯ����===========");
		System.out.println("1.�鿴����ѧԱ��Ϣ");
		System.out.println("2.�鿴ָ������¥��ѧԱ��Ϣ");
		System.out.println("3.�鿴ָ�������ѧԱ��Ϣ");
		System.out.println("4.�鿴��ס�ʣ�ָ������¥��ָ�����ᣩ");
		System.out.println("5.�鿴ָ��ѧ�ŵ�ѧԱ���ڵ�����");
		System.out.println("6.����");
		int a = scanner.nextInt();
		switch (a) {
		case 1:
			//�鿴����ѧԱ��Ϣ
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
		System.out.println("������Ҫ���ҵ�����¥");
		int buildid = scanner.nextInt();
		
	}
}
