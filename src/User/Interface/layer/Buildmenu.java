package User.Interface.layer;

import java.util.Scanner;

import Business.Logic.Layer.Build;
import Dormitory.Class.DormitoryBuilding;

public class Buildmenu {
	Scanner scanner = new Scanner(System.in);
	Build build = new Build();

	public void buildMenu() {
		AdminMenu adminMenu = new AdminMenu();
			System.out.println("=========����¥�������===========");
			System.out.println("1.�������¥");
			System.out.println("2.ɾ������¥");
			System.out.println("3.�޸�����¥");
			System.out.println("4.��ѯ����¥");// �������Ͳ��һ��߸���id����
			System.out.println("5.�˳�");
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
			System.out.println("������Ҫ��ӵ�����¥id");
			int id = scanner.nextInt();
			System.out.println("����������¥����");
			String type = scanner.next();
			DormitoryBuilding building = new DormitoryBuilding(type, id);
			if (build.add(building)) {
				System.out.println("��ӳɹ�");
			} else {
				System.out.println("���ʧ��");
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
		System.out.println("������Ҫɾ��������¥id");
		int id = scanner.nextInt();
		System.out.println("������Ҫɾ��������¥����");
		String type = scanner.next();
		DormitoryBuilding dormitoryBuilding = new DormitoryBuilding(type, id);
		if (build.remove(dormitoryBuilding)) {
			System.out.println("ɾ���ɹ�");
		} else {
			System.out.println("ɾ��ʧ��");
		}
	}

	public void updata() {
		System.out.println("������Ҫ�޸ĵ�����¥id");
		int id = scanner.nextInt();
		System.out.println("�������޸ĺ������¥id");
		int newid = scanner.nextInt();
		System.out.println("�������޸ĺ�����¥����");
		String newtype = scanner.next();
		DormitoryBuilding dormitoryBuilding = new DormitoryBuilding(newtype, newid);
		if (build.updata(dormitoryBuilding, id)) {
			System.out.println("�޸ĳɹ�");
		} else {
			System.out.println("�޸�ʧ��");
		}
	}

	public void show() {
			System.out.println("======��ѯ����¥��Ϣ����========");
			System.out.println("1.����id��ѯ");
			System.out.println("2.�������Ͳ�ѯ");
			System.out.println("3.��ʾ����");
			System.out.println("4.����");
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
		System.out.println("������id");
		int id = scanner.nextInt();
		if (!build.findByid(id)) {
			System.out.println("û������");
		}
	}
	public void showByType() {
		System.out.println("������type");
		String type = scanner.next();
		if (!build.findBytype(type)) {
			System.out.println("û������");
		}
	}
	public void showAll() {
		if (!build.showAll()) {
			System.out.println("û������");
		}
		buildMenu();
	}
	
}
