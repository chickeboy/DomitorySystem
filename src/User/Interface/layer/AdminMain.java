package User.Interface.layer;

import java.util.Scanner;

import Data.access.layer.DormitoryBuild;
import Dormitory.Class.DormitoryBuilding;

public class AdminMain{
	public void addBuild() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("������Ҫ��ӵ�����¥id");
			int id = scanner.nextInt();
			System.out.println("����������������");
			String type = scanner.next();
			DormitoryBuilding building = new DormitoryBuilding(type, id);
			DormitoryBuild dormitoryBuild = new DormitoryBuild();
			if (dormitoryBuild.dormitoryBuildDind(building)!=null) {
				System.out.println("��¥�Ѿ�����");
			}else {
				dormitoryBuild.save(building);
			}
			System.out.println("y/n");
			String string = scanner.next();
			if (string.equals("n")) {
				break;
			}
		}
	}
}
