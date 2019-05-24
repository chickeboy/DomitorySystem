package User.Interface.layer;

import java.util.Scanner;

import Business.Logic.Layer.SchoolCardMain;
import Business.Logic.Layer.StudentOperation;
import Data.access.layer.StudentMain;
import Dormitory.Class.Student;

public class StudentMenu {
	Scanner scanner = new Scanner(System.in);
	StudentMain studentMain = new StudentMain();
	StudentOperation studentOperation = new StudentOperation();
	MainMenu mainMenu = new MainMenu();
	SchoolCardMain schoolCardMain = new SchoolCardMain();

	public void studentMenu() {
		while (true) {
			System.out.println("=============ѧ����½ע�����================");
			System.out.println("1.��½");
			System.out.println("2.ע��");
			System.out.println("3.������һ��");
			int a = scanner.nextInt();
			switch (a) {
			case 1:
				longin();
				break;
			case 2:
				registered();
				break;
			case 3:
				mainMenu.mainMenu();
				break;
			default:
				break;
			}
		}
	}

	public void registered() {
		System.out.println("name");
		String name = scanner.next();
		System.out.println("sex");
		String sex = scanner.next();
		System.out.println("password");
		String password = scanner.next();
		System.out.println("phonenumber");
		String phonenumber = scanner.next();
		System.out.println("marjore");
		String marj = scanner.next();
		Student student = new Student(name, sex, password, phonenumber, marj);
		if (studentOperation.add(student)) {
			System.out.println("ע��ɹ�");
			studentMainMenu();
		} else {
			System.out.println("ע��ʧ��");
		}
	}

	public void longin() {
		System.out.println("������id");
		int id = scanner.nextInt();
		System.out.println("����������");
		String name = scanner.next();
		System.out.println("����������");
		String password = scanner.next();
		if (studentOperation.longin(id, name, password)) {
			System.out.println("��½�ɹ�");
			studentMainMenu();
		} else {
			System.out.println("��½ʧ��");
		}
	}

	public void studentMainMenu() {
		System.out.println("=========ѧ����������=======");
		System.out.println("1.ע��У԰��");
		System.out.println("2.ģ������");
		System.out.println("3.����");
		System.out.println("4.��ֵ");
		System.out.println("5.�鿴��ֵ��¼");
		System.out.println("6.�޸�����");
		System.out.println("7.�˳�");
		int a = scanner.nextInt();
		switch (a) {
		case 1:
			addSchoolcard();
			break;
		case 2:

			break;
		case 3:

			break;
		case 4:
			rechargeable();
			break;
		case 5:
			findRechargeable();
			break;
		case 6:

			break;
		case 7:
			mainMenu.mainMenu();
			break;

		default:
			break;
		}
	}

	public void addSchoolcard() {
		System.out.println("stuid");
		int stuId = scanner.nextInt();
		System.out.println("������֧�����룺");
		String payid = scanner.next();
		schoolCardMain.addSchoolCard(stuId, payid);
	}

	public void rechargeable() {
		System.out.println("���������stuid");
		int stuid = scanner.nextInt();
		System.out.println("���������payid");
		String payid = scanner.next();
		if (schoolCardMain.rechargeable(stuid, payid)) {
			System.out.println("Ҫ�����Ǯ");
			int money = scanner.nextInt();
			schoolCardMain.rechargeable(stuid, payid, money);
		} else {
			System.out.println("�ÿ�������");
		}
	}
	public void findRechargeable() {
		System.out.println("���������stuid");
		int stuid = scanner.nextInt();
		System.out.println("������payid");
		String payid = scanner.next();
		if (schoolCardMain.rechargeable(stuid, payid)) {
			schoolCardMain.showAll(stuid);
		}
		
		
	}
	public void consumption() {
		System.out.println("======���ѽ���========");
	}
}
