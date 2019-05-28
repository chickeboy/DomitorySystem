package User.Interface.layer;

import java.util.Scanner;

import Business.Logic.Layer.AdminMain;
import Business.Logic.Layer.DormitoryAllMain;
import Business.Logic.Layer.StudentOperation;

public class FindData {
	Scanner scanner = new Scanner(System.in);
	DormitoryAllMain dormitoryAllMain = new DormitoryAllMain();
	StudentOperation studentOperation = new StudentOperation();
	AdminMain adminMain = new AdminMain();
	public void findData() {
			AdminMenu adminMenu = new AdminMenu();
			System.out.println("==========��Ϣ��ѯ����===========");
			System.out.println("1.�鿴����ѧԱ��Ϣ");
			System.out.println("2.�鿴ָ������¥��ѧԱ��Ϣ");
			System.out.println("3.�鿴ָ�������ѧԱ��Ϣ");
			System.out.println("4.�鿴��ס�ʣ�ָ������¥��ָ�����ᣩ");
			System.out.println("5.�鿴ָ��ѧ�ŵ�ѧԱ���ڵ�����");
			System.out.println("6.�鿴���޼�¼");
			System.out.println("7.����");
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
				findByStuId();
				break;
			case 6:
				adminMain.records();
				break;
			case 7:
				adminMenu.admingMenu();
				break;
			default:
				break;
			}
	}

	public void findAllStudent() {
		studentOperation.showAll();
	}

	public void findByBuild() {
		System.out.println("������Ҫ���ҵ�����¥");
		int buildid = scanner.nextInt();
		int a = dormitoryAllMain.findByBuild(buildid);
		switch (a) {
		case 2:
			System.out.println("�ⶰ��û������");
			findData();
			break;
		case 3:
			System.out.println("û���ⶰ¥");
			findData();
			break;
		default:
			break;
		}
	}
	public void findByDormitory() {
		System.out.println("������Ҫ���ҵ�����id");
		int dormitory = scanner.nextInt();
		dormitoryAllMain.show(dormitoryAllMain.findByDormitory(dormitory), dormitory);
		findData();
	}
	public void occupancy() {
		System.out.println("����������¥id");
		int buildid = scanner.nextInt();
		System.out.println("����������id");
		int dormitory = scanner.nextInt();
		System.out.println("��ס��"+dormitoryAllMain.occupancy(buildid, dormitory));
		findData();
	}
	public void findByStuId() {
		System.out.println("����Ҫ���ҵ�ѧ��id");
		int stuId = scanner.nextInt();
		System.out.println(dormitoryAllMain.findByStuId(stuId));
	}
}
