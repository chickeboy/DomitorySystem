package Business.Logic.Layer;
import Data.access.layer.RepairData;
import Data.access.layer.SchoolCardData;
import Data.access.layer.StudentMain;
import Dormitory.Class.Repair;
import Dormitory.Class.Student;
import Dormitory.Util.ShowUtil;
import Dormitory.Util.TimeUtil;

public class StudentOperation {
	StudentMain studentMain = new StudentMain();
	ShowUtil showUtil = new ShowUtil();
	TimeUtil timeUtil = new TimeUtil();
	SchoolCardData schoolCardData = new SchoolCardData();
	RepairData repairData = new RepairData();
	public boolean add(Student student) {
		int id = studentMain.findLastId();
		student.setId(id+1);
		if (studentMain.findByStudent(student)!=null) {
			return false;
		}else {
			studentMain.add(student);
			return true;
		}
	}
	public boolean longin(int id,String name,String password) {
		Student student = new Student(id, name, password);
		if (studentMain.findByStudent(student)!=null) {
			return true;
		}else {
			return false;
		}
	}
	public void showAll() {
		showUtil.show(studentMain.showAll(), "Ñ§Éú");
	}
	public boolean consumption(int stuid,int money){	
		int a = schoolCardData.showMoney(schoolCardData.findByStuid(stuid));
		if (a-money<0) {
			return false;
		}else {
			schoolCardData.deductions(schoolCardData.findByStuid(stuid),money);
			return true;
		}
	}
	public void repair(int stuid,int dormitory,String content) {
		Repair repair = new Repair(repairData.getId(),stuid, dormitory, content,timeUtil.time());
		repairData.add(repair);
	}
	public void changePassword(int stuid,String password) {
		studentMain.changePassword(stuid, password);
	}
}
