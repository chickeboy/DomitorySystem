package Data.access.layer;

import java.io.File;
import java.util.ArrayList;

import Dormitory.Class.Rechargeable;
import Dormitory.Class.SchoolCard;
import Dormitory.Util.IOutil;

public class RechargeableData extends IOutil {

	public RechargeableData(File file) {
		super(file);
		// TODO Auto-generated constructor stub
	}

	public RechargeableData() {
		this(new File("Rechargeable.txt"));
		// TODO Auto-generated constructor stub
	}
	ArrayList<Rechargeable> arrayList;
	public Rechargeable addRechargeable(Rechargeable rechargeable) {
		arrayList = read();
		Rechargeable rechargeable2 = null;
		for (int i = 0; i <arrayList.size(); i++) {
			if (arrayList.equals(rechargeable)) {
				return rechargeable2 = arrayList.get(i);
			}
		}
		return rechargeable2;
	}
	public void add(SchoolCard schoolCard,int Money,String time) {
		arrayList = read();
		Rechargeable rechargeable = new Rechargeable(schoolCard.getId(), schoolCard.getStuid(), Money, time);
		arrayList.add(rechargeable);
		write(arrayList);
	}
	public ArrayList<Rechargeable> showAll() {
		return arrayList = read();
	}
}
