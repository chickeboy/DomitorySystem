package User.Interface.layer;

import java.util.Scanner;

public class StudentMenu {
	public void studentMenu() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("=============ѧ����½ע�����================");
		System.out.println("1.��½");
		System.out.println("2.ע��");
		System.out.println("3.������һ��");
		int a = scanner.nextInt();
		switch (a) {
		case 1:
			//��½�ķ���
			break;
		case 2:
			//ע��ķ���
			break;
		case 3:
			//������һ���ķ���
			break;
		default:
			break;
		}
	}
}
