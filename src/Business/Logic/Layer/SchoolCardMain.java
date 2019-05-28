package Business.Logic.Layer;

import java.util.ArrayList;

import Data.access.layer.RechargeableData;
import Data.access.layer.SchoolCardData;
import Data.access.layer.StudentMain;
import Dormitory.Class.Rechargeable;
import Dormitory.Class.SchoolCard;
import Dormitory.Util.ShowUtil;
import Dormitory.Util.TimeUtil;

public class SchoolCardMain {
	ShowUtil showUtil = new ShowUtil();
	StudentMain studentMain = new StudentMain();
	SchoolCardData schoolCardData = new SchoolCardData();
	TimeUtil timeUtil = new TimeUtil();
	RechargeableData rechargeableData = new RechargeableData();
	public boolean addSchoolCard(int stuId, String payId) {
		if (studentMain.findById(stuId) != null) {
			schoolCardData.addSchoolCard(stuId, payId);
			return true;
		} else {
			return false;
		}
	}

	public boolean rechargeable(int stuid, String payId) {
		SchoolCard schoolCard = new SchoolCard(stuid, payId);
		if (schoolCardData.schoolCardData(schoolCard) != null) {
			return true;
		} else {
			return false;
		}
	}
	public void rechargeable(int stuid, String payId,int money) {
		SchoolCard schoolCard = new SchoolCard(stuid, payId);
		schoolCardData.addMoney(schoolCard, money);	
		String time = timeUtil.time();
		rechargeableData.add(schoolCard, money, time);
	}
	public void showAll(int stuId) {
		ArrayList<Rechargeable> arrayList2 = new ArrayList<Rechargeable>();
		ArrayList<Rechargeable> arrayList  = rechargeableData.showAll();
		for (int i = 0; i < arrayList.size(); i++) {
			if (arrayList.get(i).getStuId()==stuId) {
				arrayList2.add(arrayList.get(i));
			}
		}
		showUtil.show(arrayList, stuId+"号学生的充值记录");
	}
	public void changePayId(int school,int stuid,String newPayId) {
		schoolCardData.cahngePayId(school, stuid, newPayId);
	}
	public void showAll() {
		showUtil.show(schoolCardData.showALL(), "校园卡");
	}
}
