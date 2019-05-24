package Business.Logic.Layer;

import Data.access.layer.BedBusiness;
import Data.access.layer.Dormitory;
import Data.access.layer.DormitoryBuild;
import Data.access.layer.DormitoryData;
import Data.access.layer.StudentMain;
import Dormitory.Class.DormitoryAll;
import Dormitory.Class.DormitoryBed;
//学生入住和学生迁出学生换寝室
public class AdminMain {
	StudentMain studentMain = new StudentMain();
	DormitoryBuild dormitoryBuild = new DormitoryBuild();
	Dormitory dormitory = new Dormitory();
	BedBusiness bedBusiness = new BedBusiness();
	DormitoryData data = new DormitoryData();
	public boolean inputStudent(int stuId) {
		if (studentMain.findById(stuId)!=null) {
			return true;
		}else {
			return false;
		}
	}
	public boolean inputBySex(int stuID, int buildId) {//性别冲突
		if (studentMain.findById(stuID).getSex().equals(dormitoryBuild.ById(buildId).getType())){
			return true;
		}else {
			return false;
		}
	}
	public boolean inputBydormitory(int dormitory) {
		if (this.dormitory.findById(dormitory)!=null) {
			return true;
		}else {
			return false;
		}
	}
	public boolean inputByBed(int bedId) {
		DormitoryBed dormitoryBed = bedBusiness.ById(bedId);
		if (dormitoryBed!=null&&dormitoryBed.getStuID()==0) {
			return true;
		}else {
			return false;
		}
	}
	public void input(int stuId,int buildId,int dormitory,int bedId) {
		DormitoryBed dormitoryBed = bedBusiness.ById(bedId);
		dormitoryBed.setStuID(stuId);
		DormitoryAll dormitoryAll = new DormitoryAll(dormitoryBed,this.dormitory.findById(dormitory),dormitoryBuild.ById(buildId));
		data.add(dormitoryAll);
	}
	public boolean output(int stuId) {
		if (data.remove(stuId)) {
			return true;
		}else {
			return false;
		}
	}
	public boolean change(int stuId1,int stuId2) {
		DormitoryAll dormitoryAll = data.findByStuId(stuId1);
		DormitoryAll dormitoryAll2 = data.findByStuId(stuId2);
		if (dormitoryAll!=null&&dormitoryAll2!=null) {
			if (dormitoryAll.getDormitoryBuilding().getType().equals(dormitoryAll2.getDormitoryBuilding().getType())) {
				data.change(dormitoryAll, dormitoryAll2);
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
	public boolean changeAll(int dormitory1,int dormitory2) {
		DormitoryAll dormitoryAll = data.findByDormitory(dormitory1);
		DormitoryAll dormitoryAll2 = data.findByDormitory(dormitory2);
		if (dormitoryAll!=null&&dormitoryAll2!=null) {
			if (dormitoryAll.getDormitoryBuilding().getType().equals(dormitoryAll2.getDormitoryBuilding().getType())) {
				data.change(dormitoryAll, dormitoryAll2);
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
}
