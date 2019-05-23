package User.Interface.layer;

import java.util.Scanner;

import Data.access.layer.DormitoryBuild;
import Dormitory.Util.ShowUtil;

public class ShowBuildMenu {
	Scanner scanner = new Scanner(System.in);
	ShowUtil showUtil = new ShowUtil();
	DormitoryBuild dormitoryBuild = new DormitoryBuild();
	public void show() {
		System.out.println("==========����¥��ѯ����============");
		System.out.println("1.����id��ѯ");
		System.out.println("2.����type��ѯ");
		System.out.println("3.��������¥��Ϣ");
		System.out.println("4.����");
		int a = scanner.nextInt();
		switch (a) {
		case 1:
			findById();
			break;
		case 2:
			findById();
			break;
		case 3:
			showUtil.show(dormitoryBuild.show(), "��������¥");
			break;

		default:
			break;
		}
	}
	public void findById() {
		System.out.println("id");
		int id = scanner.nextInt();
		String string = id+"������¥";
		showUtil.show(dormitoryBuild.findById(id), string);
	}
	public void findBytype() {
		System.out.println("type");
		String type = scanner.next();
		String string = type+"������¥";
		showUtil.show(dormitoryBuild.findByType(type), string);
	}
}
