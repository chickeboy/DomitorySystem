package Data.access.layer;

import java.io.File;
import java.util.ArrayList;

import Dormitory.Class.DormitoryBed;
import Dormitory.Class.DormitoryDormitory;
import Dormitory.Util.IOutil;
import Dormitory.Util.ShowUtil;

public class Dormitory extends IOutil {
	ShowUtil showUtil = new ShowUtil();
	ArrayList<DormitoryDormitory> arrayList;
	public Dormitory(File file) {
		super(file);
		// TODO Auto-generated constructor stub
	}
	public Dormitory() {
		this(new File("DormitoryDormitory.txt"));
		// TODO Auto-generated constructor stub
	}
	public DormitoryDormitory dormitoryDormitory(DormitoryDormitory dormitory) {
		arrayList = read();
		DormitoryDormitory dormitory2 = null;
		for (int i = 0; i < arrayList.size(); i++) {
			if (arrayList.contains(dormitory)) {
				dormitory2 = arrayList.get(i);
				break;
			}
		}
		return dormitory2;
	}
	public void add(DormitoryDormitory dormitory) {
		arrayList.add(dormitory);
		write(arrayList);
	}
	public void remove(DormitoryDormitory dormitory) {
		arrayList = read();
		for (int i = 0; i < arrayList.size(); i++) {
			if (arrayList.get(i).getId()==dormitory.getId()) {
				arrayList.remove(arrayList.get(i));
			}
		}
		write(arrayList);
	}
	public void updata(DormitoryDormitory dormitory,int id) {
		arrayList = read();
		for (int i = 0; i < arrayList.size(); i++) {
			if (arrayList.get(i).getId()==id) {
				arrayList.set(i, dormitory);
			}
		}
		for (DormitoryDormitory dormitoryDormitory : arrayList) {
			System.out.println(dormitoryDormitory);
		}
		write(arrayList);
	}
	public ArrayList<DormitoryDormitory> showAll() {
		return arrayList = read();
	}
	public ArrayList<DormitoryDormitory> showById(int id) {
		ArrayList<DormitoryDormitory> arrayList2 = new ArrayList<DormitoryDormitory>();
		arrayList = read();
		for (int i = 0; i < arrayList.size(); i++) {
			if (arrayList.get(i).getId()==id) {
				arrayList2.add(arrayList.get(i));
			}
		}
		return arrayList2;
	}
	public ArrayList<DormitoryDormitory> findByBuildId(int buildId) {
		arrayList = read();
		ArrayList<DormitoryDormitory> arrayList2 = new ArrayList<DormitoryDormitory>();
		for (int i = 0; i < arrayList.size(); i++) {
		if (arrayList.get(i).getBuildid()==buildId) {
			arrayList2.add(arrayList.get(i));
		}	
		}
		return arrayList2;
	}
	public DormitoryDormitory findById(int dormitory) {
		arrayList = read();
		for (int i = 0; i <arrayList.size(); i++) {
			if (arrayList.get(i).getId()==dormitory) {
				return arrayList.get(i);
			}
		}
		return null;
	}
	public int getbed(DormitoryBed dormitoryBed) {
		arrayList = read();
		int a = 0;
		for (int i = 0; i < arrayList.size(); i++) {
			if (arrayList.get(i).getId()==dormitoryBed.getDormitory()) {
				a = arrayList.get(i).getCapacity();
			}
		}
		return a;
	}
	public void cahngeCapacity(DormitoryBed dormitoryBed,int a) {
		arrayList = read();
		for (int i = 0; i < arrayList.size(); i++) {
			if (arrayList.get(i).getId()==dormitoryBed.getDormitory()) {
				arrayList.get(i).setCapacity(a-1);
			}
		}
	}
}
