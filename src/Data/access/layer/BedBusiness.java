package Data.access.layer;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

import Dormitory.Class.DormitoryBed;
import Dormitory.Util.IOutil;

public class BedBusiness extends IOutil {
	ArrayList<DormitoryBed> arrayList = new ArrayList<DormitoryBed>();

	public BedBusiness(File file) {
		super(file);
		// TODO Auto-generated constructor stub
	}

	public BedBusiness() {
		this(new File("DormitoryBed.txt"));
		// TODO Auto-generated constructor stub
	}

	public DormitoryBed bedBusiness(DormitoryBed dormitory) {
		arrayList = read();
		DormitoryBed dormitory2 = null;
		for (int i = 0; i < arrayList.size(); i++) {
			if (arrayList.contains(dormitory)) {
				dormitory2 = arrayList.get(i);
				break;
			}
		}
		return dormitory2;
	}

	public void add(DormitoryBed dormitoryBed) {
		arrayList = read();
		arrayList.add(dormitoryBed);
		write(arrayList);
	}

	public void remove(DormitoryBed dormitoryBed) {
		arrayList = read();
		for (Iterator iterator = arrayList.iterator(); iterator.hasNext();) {
			DormitoryBed dormitoryBed2 = (DormitoryBed) iterator.next();
			if (dormitoryBed2.equals(dormitoryBed)) {
				iterator.remove();
			}
		}
		write(arrayList);
	}

	public void updata(DormitoryBed dormitoryBed, DormitoryBed dormitoryBed2) {
		arrayList = read();
		for (int i = 0; i < arrayList.size(); i++) {
			if (arrayList.get(i).equals(dormitoryBed2)) {
				arrayList.set(i, dormitoryBed);
			}
		}
		write(arrayList);
	}
	public ArrayList<DormitoryBed> showAll() {
		return arrayList = read();
	}
	public ArrayList<DormitoryBed> findById(int id) {
		ArrayList<DormitoryBed> arrayList2 = new ArrayList<DormitoryBed>();
		arrayList = read();
		for (int i = 0; i <arrayList.size(); i++) {
			if (arrayList.get(i).getId()==id) {
				arrayList2.add(arrayList.get(i));
			}
		}
		return arrayList2;
	}
	public ArrayList<DormitoryBed> showBydormitory(int dormitory) {
		ArrayList<DormitoryBed> arrayList2  = new ArrayList<DormitoryBed>();
		arrayList = read();
		for (int i = 0; i < arrayList.size(); i++) {
			if (arrayList.get(i).getDormitory()==dormitory) {
				arrayList2.add(arrayList.get(i));
			}
		}
		return arrayList2;
	}
}
