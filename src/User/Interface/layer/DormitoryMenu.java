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
			System.out.println("=========���᷿��������============");
			System.out.println("1.��ӷ���");
			System.out.println("2.ɾ������");
			System.out.println("3.�޸ķ���");
			System.out.println("4.��ѯ����");
			System.out.println("5.�˳�");
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
			System.out.println("����¥id");
			int buildid = scanner.nextInt();
			System.out.println("����id");
			int id = scanner.nextInt();
			System.out.println("�����������");
			int capacity = scanner.nextInt();
			DormitoryDormitory dormitory = new DormitoryDormitory(id, buildid, capacity);
			if (dormitoryMain.add(dormitory)) {
				System.out.println("��ӳɹ�");
			}else {
				System.out.println("�������Ѿ�����");
			}
			System.out.println("y/n");
			String string =scanner.next();
			if (string.equals("n")) {
				break;
			}
		}
	}
	public void remove() {
		System.out.println("����¥id");
		int bulidid = scanner.nextInt();
		System.out.println("Ҫɾ��������id");
		int id = scanner.nextInt();
		DormitoryDormitory dormitory = new DormitoryDormitory(id,bulidid);
		if (dormitoryMain.remove(dormitory)) {
			System.out.println("ɾ���ɹ�");
		}else {
			System.out.println("ɾ��ʧ��");
		}
	}
	public void updata() {
		System.out.println("Ҫ�޸ĵ�������������¥��");
		int buildId = scanner.nextInt();
		System.out.println("Ҫ�޸ĵ�����id");
		int id = scanner.nextInt();
		System.out.println("�޸ĺ������¥id");
		int newbuildid = scanner.nextInt();
		System.out.println("�޸ĺ������id");
		int newid = scanner.nextInt();
		System.out.println("�޸ĺ�������������");
		int newcapacity = scanner.nextInt();
		DormitoryDormitory dormitory = new DormitoryDormitory(newid, newbuildid, newcapacity);
		if (dormitoryMain.updata(dormitory, id,buildId)) {
			System.out.println("�޸ĳɹ�");
		}else {
			System.out.println("�޸�ʧ��");
		}
	}
	public void showdata() {
		System.out.println("=======��ѯ��ʽ==========");
		System.out.println("1.��������id��ѯ");
		System.out.println("2.��ʾ��������");
		System.out.println("3.�˳�");
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
		System.out.println("Ҫ��ѯ�����Һ�");
		int id = scanner.nextInt();
		dormitoryMain.showById(id);
	}
}
