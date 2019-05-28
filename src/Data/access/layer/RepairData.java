package Data.access.layer;

import java.io.File;
import java.util.ArrayList;

import Dormitory.Class.Repair;
import Dormitory.Util.IOutil;

public class RepairData extends IOutil {

	public RepairData(File file) {
		super(file);
		// TODO Auto-generated constructor stub
	}
	public RepairData() {
		this(new File("Repair.txt"));
		// TODO Auto-generated constructor stub
	}
	ArrayList<Repair> arrayList = new ArrayList<Repair>();
	public Repair repairData(Repair repair) {
		arrayList = read();
		Repair repair2 =null;
		for (int i = 0; i < arrayList.size(); i++) {
			if (arrayList.contains(repair)) {
				repair2 = arrayList.get(i);
			}
		}
		return repair2;
	}
	public int getId() {
		arrayList = read();
		if (arrayList.size()==0) {
			return 0;
		}else {
			return arrayList.get(arrayList.size()-1).getId();
		}
	}
	public void add(Repair repair) {
		arrayList = read();
		arrayList.add(repair);
		write(arrayList);
	}
	public ArrayList<Repair> showAll() {
		return arrayList  = read();
	}
}
