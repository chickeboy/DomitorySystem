package Data.access.layer;

import java.io.File;
import java.util.ArrayList;

import Dormitory.Class.DormitoryAll;
import Dormitory.Util.IOutil;

public class DormitoryData extends IOutil {
	public DormitoryData(File file) {
		super(file);
		// TODO Auto-generated constructor stub
	}

	public DormitoryData() {
		this(new File("DormitoryAll.txt"));
	}

	ArrayList<DormitoryAll> arrayList;

	public DormitoryAll dormitoryAll(DormitoryAll dormitoryAll) {
		arrayList = read();
		DormitoryAll dormitoryAll2 = null;
		for (int i = 0; i < arrayList.size(); i++) {
			if (arrayList.contains(dormitoryAll)) {
				dormitoryAll2 = arrayList.get(i);
				break;
			}
		}
		return dormitoryAll2;
	}

	public void add(DormitoryAll dormitoryAll) {
		arrayList = read();
		arrayList.add(dormitoryAll);
		write(arrayList);
	}

	public boolean remove(int stuId) {
		arrayList = read();
		for (int i = 0; i < arrayList.size(); i++) {
			if (arrayList.get(i).getDormitoryBed().getStuID() == stuId) {
				arrayList.remove(i);
				return true;
			}
		}
		return false;
	}

	public DormitoryAll findByStuId(int stuId) {
		arrayList = read();
		for (int i = 0; i < arrayList.size(); i++) {
			if (arrayList.get(i).getDormitoryBed().getStuID() == stuId) {
				return arrayList.get(i);
			}
		}
		return null;
	}
	public DormitoryAll findByDormitory(int dormitory) {
		arrayList = read();
		for (int i = 0; i <arrayList.size(); i++) {
			if (arrayList.get(i).getDormitoryDormitory().getId()==dormitory) {
				return arrayList.get(i);
			}
		}
		return null;
	}
	public void change(DormitoryAll dormitoryAll, DormitoryAll dormitoryAll2) {
		arrayList = read();
		int buildId = 0;
		int dormitory = 0;
		int bedId = 0;
		for (int i = 0; i < arrayList.size(); i++) {
			if (arrayList.get(i).equals(dormitoryAll)) {
				buildId = arrayList.get(i).getDormitoryBuilding().getId();
				dormitory = arrayList.get(i).getDormitoryDormitory().getId();
				bedId = arrayList.get(i).getDormitoryBed().getId();
				arrayList.get(i).getDormitoryBuilding().setId(dormitoryAll2.getDormitoryBuilding().getId());
				arrayList.get(i).getDormitoryDormitory().setId(dormitoryAll2.getDormitoryDormitory().getId());
				arrayList.get(i).getDormitoryBed().setId(dormitoryAll2.getDormitoryBed().getId());
			}
		}
		for (int i = 0; i <arrayList.size(); i++) {
			if (arrayList.get(i).equals(dormitoryAll2)) {
				arrayList.get(i).getDormitoryBuilding().setId(buildId);
				arrayList.get(i).getDormitoryDormitory().setId(dormitory);
				arrayList.get(i).getDormitoryBed().setId(bedId);
			}
		}
		write(arrayList);
	}
	public void changeAll(DormitoryAll dormitoryAll, DormitoryAll dormitoryAll2) {
		int buildId = 0;
		int dormitory = 0;
		for (int i = 0; i < arrayList.size(); i++) {
			if (arrayList.get(i).equals(dormitoryAll)) {
				buildId = arrayList.get(i).getDormitoryBuilding().getId();
				dormitory = arrayList.get(i).getDormitoryDormitory().getId();
				arrayList.get(i).getDormitoryBuilding().setId(dormitoryAll2.getDormitoryBuilding().getId());
				arrayList.get(i).getDormitoryDormitory().setId(dormitoryAll2.getDormitoryDormitory().getId());
			}
		}
		for (int i = 0; i <arrayList.size(); i++) {
			if (arrayList.get(i).equals(dormitoryAll2)) {
				arrayList.get(i).getDormitoryBuilding().setId(buildId);
				arrayList.get(i).getDormitoryDormitory().setId(dormitory);
			}
		}
		write(arrayList);
	}
}
