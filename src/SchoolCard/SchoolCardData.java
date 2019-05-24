package SchoolCard;

import java.io.File;
import java.util.ArrayList;

import Dormitory.Class.SchoolCard;
import Dormitory.Util.IOutil;

public class SchoolCardData  extends IOutil{

	public SchoolCardData(File file) {
		super(file);
		// TODO Auto-generated constructor stub
	}
	public  SchoolCardData() {
		this(new File("SchoolCard.txt"));
		// TODO Auto-generated constructor stub
	}
	ArrayList<SchoolCard> arrayList;
	public SchoolCard  schoolCardData(SchoolCard schoolCard) {
		arrayList = read();
		SchoolCard schoolCard2 = null;
		for (int i = 0; i < arrayList.size(); i++) {
			if (arrayList.contains(schoolCard)) {
				 schoolCard = arrayList.get(i);
			}
		}
		return schoolCard2;
	}
	public void addSchoolCard(int stuId,String payId) {
		int id = 0;
		arrayList = read();
		if (arrayList.size()==0) {
			id = -1;
		}else {
			id = arrayList.get(arrayList.size()).getId();
		}
		arrayList.add(new SchoolCard(id, stuId, payId));
		write(arrayList);
	}
	public void addMoney(SchoolCard schoolCard,int money) {
		arrayList  = read();
		for (int i = 0; i < arrayList.size(); i++) {
			if (arrayList.get(i).equals(schoolCard)) {
				arrayList.get(i).setBalance(money);
			}
		}
		write(arrayList);
	}
	public SchoolCard findByStu(int stuid,String payid) {
		arrayList = read();
		SchoolCard schoolCard = null;
		for (int i = 0; i < arrayList.size(); i++) {
			if (arrayList.get(i).getStuid()==stuid&&arrayList.get(i).getPayid().equals(payid)) {
				return schoolCard = arrayList.get(i);
			}
		}
		return schoolCard;
	}
}
