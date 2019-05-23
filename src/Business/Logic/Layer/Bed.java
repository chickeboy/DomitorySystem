package Business.Logic.Layer;

import java.util.ArrayList;

import Data.access.layer.BedBusiness;
import Dormitory.Class.DormitoryBed;
import Dormitory.Util.ShowUtil;

public class Bed {
	BedBusiness bedBusiness = new BedBusiness();
	ShowUtil showUtil = new ShowUtil();
	public boolean add(DormitoryBed dormitoryBed) {
		if (bedBusiness.bedBusiness(dormitoryBed)!=null) {
			return false;
		}else {
			bedBusiness.add(dormitoryBed);
			return true;
		}
	}
	public boolean remove(DormitoryBed dormitoryBed) {
		if (bedBusiness.bedBusiness(dormitoryBed)!=null) {
			bedBusiness.remove(dormitoryBed);
			return true;
		}else {
			return false;
		}
	}
	public Boolean updata(DormitoryBed dormitoryBed,int id,int dormitory ) {
		DormitoryBed dormitoryBed2 = new DormitoryBed(id, dormitory);
		if (bedBusiness.bedBusiness(dormitoryBed2)!=null) {
			bedBusiness.updata(dormitoryBed, dormitoryBed2);
			return true;
		}else {
			return false;
		}
	}
	public void show() {
		showUtil.show(bedBusiness.showAll(), "¥≤∆Ã");
	}
	public boolean showByid(int id){
		ArrayList<DormitoryBed> arrayList = bedBusiness.findById(id);
		if (arrayList.size()==0) {
			return false;
		}else {
			showUtil.show(arrayList, id + "∫≈¥≤∆Ã");
			return true;
		}
	}
	public boolean showBydormitory(int dormitory) {
		ArrayList<DormitoryBed> arrayList = bedBusiness.showBydormitory(dormitory);
		if (arrayList.size()==0) {
			return false;
		}else {
			showUtil.show(arrayList, dormitory+"∫≈«ﬁ “¥≤∆Ã");
			return true;
		}
	}
}
