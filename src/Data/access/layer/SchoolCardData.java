package Data.access.layer;

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
			if (arrayList.get(i).equals(schoolCard)) {
				schoolCard2 = arrayList.get(i);
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
			id = arrayList.get(arrayList.size()-1).getId();
		}
		arrayList.add(new SchoolCard(id+1, stuId, payId));
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
	public SchoolCard findByStuid(int stuid) {
		arrayList = read();
		SchoolCard schoolCard = null;
		for (int i = 0; i <arrayList.size(); i++) {
			if (arrayList.get(i).getStuid()==stuid) {
				schoolCard = arrayList.get(i);
			}
		}
		return schoolCard;
	}
	public int showMoney(SchoolCard schoolCard) {
		arrayList = read();
		for (int i = 0; i < arrayList.size(); i++) {
			if (arrayList.get(i).equals(schoolCard)) {
				return arrayList.get(i).getBalance();
			}
		}
		return 0;
	}
	public void deductions(SchoolCard schoolCard,int money) {
		arrayList = read();
		for (int i = 0; i <arrayList.size(); i++) {
			if (arrayList.get(i).equals(schoolCard)) {
				arrayList.get(i).setBalance(arrayList.get(i).getBalance()-money);
			}
		}
		write(arrayList);
	}
	public void cahngePayId(int school,int stuid,String newPayId) {
		arrayList = read();
		for (int i = 0; i < arrayList.size(); i++) {
			if (arrayList.get(i).getId()==school&&arrayList.get(i).getStuid()==stuid) {
				arrayList.get(i).setPayid(newPayId);
			}
		}
	}
	public SchoolCard findByid(int schoolCardId) {
		arrayList = read();
		for (int i = 0; i < arrayList.size(); i++) {
			if (arrayList.get(i).getId()==schoolCardId) {
				return arrayList.get(i);
			}
		}
		return null;
	}
	public ArrayList<SchoolCard> showALL() {
		return arrayList = read();
		
	}
}
