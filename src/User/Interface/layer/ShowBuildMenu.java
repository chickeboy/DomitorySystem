package User.Interface.layer;

import java.util.Scanner;

import Data.access.layer.DormitoryBuild;
import Dormitory.Util.ShowUtil;

public class ShowBuildMenu {
	Scanner scanner = new Scanner(System.in);
	ShowUtil showUtil = new ShowUtil();
	DormitoryBuild dormitoryBuild = new DormitoryBuild();
	public void show() {
		System.out.println("==========寝室楼查询界面============");
		System.out.println("1.根据id查询");
		System.out.println("2.根据type查询");
		System.out.println("3.所有寝室楼信息");
		System.out.println("4.返回");
		int a = scanner.nextInt();
		switch (a) {
		case 1:
			findById();
			break;
		case 2:
			findById();
			break;
		case 3:
			showUtil.show(dormitoryBuild.show(), "所有寝室楼");
			break;

		default:
			break;
		}
	}
	public void findById() {
		System.out.println("id");
		int id = scanner.nextInt();
		String string = id+"号寝室楼";
		showUtil.show(dormitoryBuild.findById(id), string);
	}
	public void findBytype() {
		System.out.println("type");
		String type = scanner.next();
		String string = type+"生寝室楼";
		showUtil.show(dormitoryBuild.findByType(type), string);
	}
}
