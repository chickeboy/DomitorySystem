package User.Interface.layer;

import java.util.HashMap;
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
			System.out.println("=============ѧ����½ע�����================");
			System.out.println("1.��½");
			System.out.println("2.ע��");
			System.out.println("3.��������");
			System.out.println("4.������һ��");
			int a = scanner.nextInt();
			switch (a) {
			case 1:
				longin();
				break;
			case 2:
				registered();
				break;
			case 3:
				forgotpassword();
				break;
			case 4:
				mainMenu.mainMenu();
				break;
			default:
				break;
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
		System.out.println("ques1");
		String str = scanner.next();
		System.out.println("ans1");
		String str2 = scanner.next();
		HashMap<String, String> hashMap = new HashMap<String, String>();
		hashMap.put(str, str2);
		System.out.println("ques2");
		str = scanner.next();
		System.out.println("ans2");
		str2 = scanner.next();
		hashMap.put(str, str2);
		System.out.println("ques3");
		str = scanner.next();
		System.out.println("ans3");
		str2 = scanner.next();
		hashMap.put(str, str2);
		Student student = new Student(name, sex, password, phonenumber, marj,hashMap);
		int stuid = studentOperation.add(student);
		if (stuid!=-1) {
			System.out.println("ע��ɹ�");
			System.out.println("���õ�ѧ���ǣ�"+stuid);
			studentMainMenu();
		} else {
			System.out.println("ע��ʧ��");
			studentMenu();
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
			studentMenu();
		}
	}
	public void forgotpassword() {
		System.out.println("ͨ���ܱ��һ�����");
		System.out.println("stuid");
		int stuid = scanner.nextInt();
		System.out.println(studentOperation.findques(stuid));
		String string = scanner.next();
		if (studentOperation.findans(stuid, string)) {
			System.out.println("��֤�ɹ�");
			System.out.println("�������Ϊ��"+studentOperation.getPassword(stuid));
			System.out.println("�Ƿ�ȥ�޸����� y/n");
			string = scanner.next();
			if (string.equals("y")) {
				changePasword();
			}else {
				studentMenu();
			}
		}else {
			System.out.println("��֤ʧ��");
			studentMenu();
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
			consumption();
			break;
		case 3:
			repair();
			break;
		case 4:
			rechargeable();
			break;
		case 5:
			findRechargeable();
			break;
		case 6:
			change();
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
		if (schoolCardMain.findcard(stuId)) {
			System.out.println("������֧�����룺");
			String payid = scanner.next();
			if (schoolCardMain.addSchoolCard(stuId, payid)) {
				System.out.println("ע��ɹ�");
				studentMainMenu();
			}else {
				System.out.println("ע��ʧ��");
				studentMainMenu();
			}
		}else {
			System.out.println("��ѧ���Ѿ�ע���У԰��");
		}
		studentMainMenu();
	}

	public void rechargeable() {
		System.out.println("���������stuid");
		int stuid = scanner.nextInt();
		System.out.println("���������payid");
		String payid = scanner.next();
		if (schoolCardMain.rechargeable(stuid, payid)) {
			int a = (int) Math.floor(Math.random()*1000+1000);
			System.out.println("��֤��"+a);
			int b = scanner.nextInt();
			if (b == a) {
				
				System.out.println("Ҫ�����Ǯ");
				int money = scanner.nextInt();
				schoolCardMain.rechargeable(stuid, payid, money);
			}
			studentMainMenu();
		} else {
			System.out.println("�ÿ�������");
			studentMainMenu();
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
		studentMainMenu();
	}

	public void consumption() {
		System.out.println("======���ѽ���========");
		System.out.println("1.ϴ�·�");
		System.out.println("2.��ˮ");
		System.out.println("3.ϴ��");
		System.out.println("4.����");
		System.out.println("5.����");
		int a = scanner.nextInt();
		switch (a) {
		case 1:
			clothes();
			break;
		case 2:
			water();
			break;
		case 3:
			shower();
			break;
		case 4:
			internetfee();
			break;
		case 5:
			studentMainMenu();
			break;

		default:
			break;
		}

	}

	public void clothes() {
		System.out.println("���������stuid");
		int stuid = scanner.nextInt();
		System.out.println("���������payid");
		String payid = scanner.next();
		if (schoolCardMain.rechargeable(stuid, payid)) {
			int a = studentOperation.consumption(stuid, 5);
			if (a!=-1) {
				System.out.println("���ѳɹ�");
				System.out.println("�����"+a);
				consumption();
			} else {
				System.out.println("����");
				consumption();
			}
		} else {
			System.out.println("�������");
			consumption();
		}

	}

	public void water() {
		System.out.println("���������stuid");
		int stuid = scanner.nextInt();
		System.out.println("���������payid");
		String payid = scanner.next();
		if (schoolCardMain.rechargeable(stuid, payid)) {
			int a = studentOperation.consumption(stuid, 1);
			if (a!=-1) {
				System.out.println("���ѳɹ�");
				System.out.println("�����"+a);
				consumption();
			} else {
				System.out.println("����");
				consumption();
			}
		} else {
			System.out.println("�������");
			consumption();
		}
	}

	public void shower() {
		System.out.println("���������stuid");
		int stuid = scanner.nextInt();
		System.out.println("���������payid");
		String payid = scanner.next();
		if (schoolCardMain.rechargeable(stuid, payid)) {
			int a = studentOperation.consumption(stuid, 5);
			if (a!=-1) {
				System.out.println("���ѳɹ�");
				System.out.println("�����"+a);
				consumption();
			} else {
				System.out.println("����");
				consumption();
			}
		} else {
			System.out.println("�������");
			consumption();
		}
	}

	public void internetfee() {
		System.out.println("���������stuid");
		int stuid = scanner.nextInt();
		System.out.println("���������payid");
		String payid = scanner.next();
		if (schoolCardMain.rechargeable(stuid, payid)) {
			int a = studentOperation.consumption(stuid, 50);
			if (a!=-1) {
				System.out.println("���ѳɹ�");
				System.out.println("�����"+a);
				consumption();
			} else {
				System.out.println("����");
				consumption();
			}
		} else {
			System.out.println("�������");
			consumption();
		}
	}

	public void repair() {
		System.out.println("���ѧ��id");
		int stuid = scanner.nextInt();
		System.out.println("���޵�����");
		int dormitory = scanner.nextInt();
		System.out.println("���޵�����");
		String content = scanner.next();
		studentOperation.repair(stuid, dormitory, content);
		studentMainMenu();
	}

	public void change() {
		System.out.println("=======�����޸Ľ���==========");
		System.out.println("1.�޸�����");
		System.out.println("2.�޸�֧������");
		System.out.println("3.�˳�");
		int a = scanner.nextInt();
		switch (a) {
		case 1:
			changePasword();
			break;
		case 2:
			chagePayid();
			break;
		case 3:
			studentMainMenu();
			break;

		default:
			break;
		}
	}

	public void changePasword() {
		System.out.println("�������stuid");
		int stuid = scanner.nextInt();
		System.out.println("�������name");
		String name =scanner.next();
		System.out.println("�������password");
		String password = scanner.next();
		if (studentOperation.longin(stuid, name, password)) {
			System.out.println("�µ�password:");
			String newpassword = scanner.next();
			studentOperation.changePassword(stuid, newpassword);
			studentMainMenu();
		}else {
			System.out.println("ѧ��������");
			studentMainMenu();
		}
	}
	public void chagePayid() {
		System.out.println("���������SchoolCardId");
		int schoolId = scanner.nextInt();
		System.out.println("���������stuid");
		int stuid = scanner.nextInt();
		System.out.println("���������payid");
		String payid = scanner.next();
		if (schoolCardMain.rechargeable(stuid, payid)) {
			System.out.println("������newpayid");
			String newPayId =scanner.next();
			schoolCardMain.changePayId(schoolId, stuid, newPayId);
		}
	}
}
