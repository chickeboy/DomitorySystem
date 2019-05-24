package Data.access.layer;

import java.io.File;
import java.util.ArrayList;

import Dormitory.Class.DormitoryBuilding;
import Dormitory.Util.IOutil;

public class DormitoryBuild extends IOutil {
	public DormitoryBuild(File file) {
		super(file);
		// TODO Auto-generated constructor stub
	}

	public DormitoryBuild() {
		this(new File("DormitoryBuilding.txt"));
		// TODO Auto-generated constructor stub
	}

	ArrayList<DormitoryBuilding> arrayList;

	public DormitoryBuilding dormitoryBuildDind(DormitoryBuilding building) {
		arrayList = read();
		DormitoryBuilding building2 = null;
		for (int i = 0; i < arrayList.size(); i++) {
			if (arrayList.contains(building)) {
				building2 = arrayList.get(i);
				break;
			}
		}
		return building2;
	}

	public void save(DormitoryBuilding building) {
		arrayList = read();
		arrayList.add(building);
		write(arrayList);
	}

	public void remove(DormitoryBuilding building) {
		arrayList = read();
		arrayList.remove(arrayList.get(arrayList.indexOf(building)));
		write(arrayList);
	}

	public Boolean upData(DormitoryBuilding dormitoryBuilding, int id) {
		arrayList = read();
		Boolean bool = false;
		for (DormitoryBuilding dormitoryBuilding2 : arrayList) {
			if (dormitoryBuilding2.getId() == id) {
				dormitoryBuilding2 = dormitoryBuilding;
				bool = true;
				break;
			}
		}
		return bool;
	}

	public ArrayList<DormitoryBuilding> show() {
		return arrayList = read();
	}
	public ArrayList<DormitoryBuilding> findById(int id) {
		ArrayList<DormitoryBuilding> arrayList = read();
		ArrayList<DormitoryBuilding> arrayList2 = new ArrayList<DormitoryBuilding>();
		for (int i = 0; i < arrayList.size(); i++) {
			if (arrayList.get(i).getId() == id) {
				arrayList2.add(arrayList.get(i));
			}
		}
		return arrayList2;
	}

	public ArrayList<DormitoryBuilding> findByType(String type) {
		ArrayList<DormitoryBuilding> arrayList2 = new ArrayList<DormitoryBuilding>();
		for (int i = 0; i < arrayList.size(); i++) {
			if (arrayList.get(i).getType().equals(type)) {
				arrayList2.add(arrayList.get(i));
			}
		}
		return arrayList2;
	}
	public DormitoryBuilding  ById(int buildId) {
		arrayList = read();
		for (int i = 0; i <arrayList.size(); i++) {
			if (arrayList.get(i).getId()==buildId) {
				return arrayList.get(i);
			}
		}
		return null;
		
	}
}
