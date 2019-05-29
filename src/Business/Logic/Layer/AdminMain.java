package Business.Logic.Layer;

import Data.access.layer.BedBusiness;
import Data.access.layer.Dormitory;
import Data.access.layer.DormitoryBuild;
import Data.access.layer.DormitoryData;
import Data.access.layer.InputData;
import Data.access.layer.OutputData;
import Data.access.layer.RepairData;
import Data.access.layer.SchoolCardData;
import Data.access.layer.StudentMain;
import Dormitory.Class.DormitoryAll;
import Dormitory.Class.DormitoryBed;
import Dormitory.Class.DormitoryDormitory;
import Dormitory.Class.InPutOutPut;
import Dormitory.Class.SchoolCard;
import Dormitory.Util.ShowUtil;

//学生入住和学生迁出学生换寝室
public class AdminMain {
	SchoolCardData schoolCardData = new SchoolCardData();
	StudentMain studentMain = new StudentMain();
	DormitoryBuild dormitoryBuild = new DormitoryBuild();
	Dormitory dormitory = new Dormitory();
	BedBusiness bedBusiness = new BedBusiness();
	DormitoryData data = new DormitoryData();
	InputData inputData = new InputData();
	OutputData outputData = new OutputData();
	ShowUtil showUtil = new ShowUtil();
	RepairData repairData = new RepairData();

	public boolean inputStudent(int stuId) {
		if (studentMain.findById(stuId) != null && data.Stuid(stuId)) {
			return true;
		} else {
			return false;
		}
	}
	public boolean inputBySex(int stuID, int buildId) {// 性别冲突
		if (studentMain.findById(stuID).getSex().equals(dormitoryBuild.ById(buildId).getType())) {
			return true;
		} else {
			return false;
		}
	}

	public boolean inputBydormitory(int dormitory) {
		if (this.dormitory.findById(dormitory) != null) {
			return true;
		} else {
			return false;
		}
	}

	public boolean inputByBed(int bedId) {
		DormitoryBed dormitoryBed = bedBusiness.ById(bedId);
		if (dormitoryBed != null && dormitoryBed.getStuID() == 0) {
			return true;
		} else {
			return false;
		}
	}

	public void input(int stuId, int buildId, int dormitory, int bedId) {
		DormitoryBed dormitoryBed = bedBusiness.ById(bedId);
		dormitoryBed.setStuID(stuId);
		DormitoryDormitory dormitory2 = this.dormitory.findById(dormitory);
		DormitoryAll dormitoryAll = new DormitoryAll(dormitoryBed, dormitory2, dormitoryBuild.ById(buildId));
		InPutOutPut inPutOutPut = new InPutOutPut(studentMain.findById(stuId).getName(), dormitoryAll);
		inputData.add(inPutOutPut);
		data.add(dormitoryAll);
	}

	public boolean output(int stuId) {
		DormitoryAll dormitoryAll = data.remove(stuId);
		if (dormitoryAll != null) {
			int a = studentMain.findById(stuId).getSchoolcard();
			SchoolCard schoolCard = schoolCardData.findByid(a);
			schoolCardData.addMoney(schoolCard, schoolCard.getBalance() + 100);
			InPutOutPut inPutOutPut  = inputData.findById(stuId);
			outputData.add(inPutOutPut);
			return true;
		} else {
			return false;
		}
	}

	public boolean change(int stuId1, int stuId2) {
		DormitoryAll dormitoryAll = data.findByStuId(stuId1);
		DormitoryAll dormitoryAll2 = data.findByStuId(stuId2);
		if (dormitoryAll != null && dormitoryAll2 != null) {
			if (dormitoryAll.getDormitoryBuilding().getType().equals(dormitoryAll2.getDormitoryBuilding().getType())) {
				data.change(dormitoryAll, dormitoryAll2);
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public boolean changeAll(int dormitory1, int dormitory2) {
		DormitoryAll dormitoryAll = data.findByDormitory(dormitory1);
		DormitoryAll dormitoryAll2 = data.findByDormitory(dormitory2);
		if (dormitoryAll != null && dormitoryAll2 != null) {
			if (dormitoryAll.getDormitoryBuilding().getType().equals(dormitoryAll2.getDormitoryBuilding().getType())) {
				data.changeAll(dormitoryAll, dormitoryAll2);
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public int deposit(int stuid) {
		SchoolCard schoolCard = schoolCardData.findByStuid(stuid);
		int money = schoolCardData.showMoney(schoolCard);
		if (money - 100 >= 0) {
			schoolCardData.deductions(schoolCard, 100);
			return money - 100;
		} else {
			return -1;
		}
	}

	public void inputrecord(int stuid, int buildId, int dormitory, int bedId) {
		DormitoryBed dormitoryBed = bedBusiness.ById(bedId);
		dormitoryBed.setStuID(stuid);
		DormitoryAll dormitoryAll = new DormitoryAll(dormitoryBed, this.dormitory.findById(dormitory),
				dormitoryBuild.ById(buildId));
		InPutOutPut inPutOutPut = new InPutOutPut(inputData.getlastId() + 1, studentMain.findById(stuid).getName(),
				dormitoryAll);
		inputData.add(inPutOutPut);
		System.out.println(inPutOutPut);
	}

	public void outputrecord(int stuid) {
		InPutOutPut inPutOutPut = new InPutOutPut(outputData.getlastId() + 1, studentMain.findById(stuid).getName(),
				data.remove(stuid));
		outputData.add(inPutOutPut);
	}

	public void records() {
		showUtil.show(repairData.showAll(), "报修记录");
	}
	public void inputdata() {
		showUtil.show(inputData.showAll(), "入住");
	}

	public void outputdata() {
		showUtil.show(outputData.showAll(), "迁出");
	}
	
}
