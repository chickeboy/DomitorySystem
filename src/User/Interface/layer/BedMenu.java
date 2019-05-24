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
			System.out.println("=======���̹������============");
			System.out.println("1.��Ӵ���");
			System.out.println("2.ɾ������");
			System.out.println("3.�޸Ĵ���");
			System.out.println("4.�鿴����");
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
			
			System.out.println("����id");
			int dormitory = scanner.nextInt();
			System.out.println("����");
			int id = scanner.nextInt();
			DormitoryBed dormitoryBed = new DormitoryBed(id, dormitory);
			if (bed.add(dormitoryBed)) {
				System.out.println("��ӳɹ�");
			}else {
				System.out.println("���ʧ��");
			}
			System.out.println("y/n");
			String string = scanner.next();
			if (string.equals("n")) {
				break;
			}
		}
	}
	public void remove() {
		System.out.println("Ҫɾ��������������id");
		int dormitory = scanner.nextInt();
		System.out.println("Ҫɾ���Ĵ���");
		int id = scanner.nextInt();
		DormitoryBed dormitoryBed = new DormitoryBed(id, dormitory);
		if (bed.remove(dormitoryBed)) {
			System.out.println("ɾ���ɹ�");
		}else {
			System.out.println("ɾ��ʧ��");
		}
		
	}
	public void updata() {
		System.out.println("Ҫ�޸Ĵ�����������id");
		int dormitory = scanner.nextInt();
		System.out.println("Ҫ�޸ĵĴ���");
		int id = scanner.nextInt();
		System.out.println("�޸ĺ�Ĵ�����������");//��������ֻ��Ҫ�޸Ķ�Ӧ�����ҺžͿ���
		int newdormitory = scanner.nextInt();
		System.out.println("�޸ĺ�Ĵ���id");
		int newid = scanner.nextInt();
		DormitoryBed dormitoryBed =new DormitoryBed(newid, newdormitory);
		if (bed.updata(dormitoryBed, id, dormitory)) {
			System.out.println("�޸ĳɹ�");
		}else {
			System.out.println("�޸�ʧ��");
		}	
	}
	public void show() {
		while(true) {
			System.out.println("============���̲�ѯ����===========");
			System.out.println("1.�������Ҳ�ѯ");
			System.out.println("2.���ݴ��Ų�ѯ");
			System.out.println("3.�˳�");
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
		System.out.println("�����봲��");
		int id = scanner.nextInt();
		if (!bed.showByid(id)) {
			System.out.println("û������");
		}
	}
	public void showBydormitory() {
		System.out.println("���������Һ�");
		int dormitory = scanner.nextInt();
		if (!bed.showBydormitory(dormitory)) {
			bed.showBydormitory(dormitory);
		}
	}
}
