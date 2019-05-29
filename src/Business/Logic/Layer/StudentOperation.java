package Business.Logic.Layer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

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
	public int add(Student student) {
		int id = -1;
		id = studentMain.findLastId();
		student.setId(id+1);
		student.setSchoolcard(-1);
		if (studentMain.findByStudent(student)!=null) {
			id = -1;
		}else {
			studentMain.add(student);
			id = id +1;
		}
		return id;
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
	public int consumption(int stuid,int money){
		int a = schoolCardData.showMoney(schoolCardData.findByStuid(stuid));
		if (a-money<0) {
			return -1;
		}else {
			schoolCardData.deductions(schoolCardData.findByStuid(stuid),money);
			return a-money;
		}
	}
	public void repair(int stuid,int dormitory,String content) {
		Repair repair = new Repair(repairData.getId()+1,stuid, dormitory, content,timeUtil.time());
		repairData.add(repair);
	}
	public void changePassword(int stuid,String password) {
		studentMain.changePassword(stuid, password);
	}
	public String findques(int stuid) {
		HashMap<String, String> hashMap = studentMain.findPassWord(stuid);
		ArrayList<String> arrayListqes = new ArrayList<String>();
		Set<Entry<String,String>> entrySet = hashMap.entrySet();
		for (Iterator<Entry<String, String>> iterator = entrySet.iterator(); iterator.hasNext();) {
			Entry<String, String> entry = (Entry<String, String>) iterator.next();
			arrayListqes.add(entry.getKey());
		}
		return arrayListqes.get((int)Math.floor(Math.random()*3));
	}
	public boolean findans(int stuid,String string) {
		HashMap<String, String> hashMap = studentMain.findPassWord(stuid);
		ArrayList<String> arrayListans = new ArrayList<String>();
		Set<Entry<String,String>> entrySet = hashMap.entrySet();
		for (Iterator<Entry<String, String>> iterator = entrySet.iterator(); iterator.hasNext();) {
			Entry<String, String> entry = (Entry<String, String>) iterator.next();
			if (entry.getValue().equals(string)) {
				return true;
			}
		}
		return false;
	}
	public String getPassword(int stuid) {
		return studentMain.findById(stuid).getPassword();
	}
	public boolean findSchoolCard(int stuid) {
		if (schoolCardData.findByStuid(stuid)!=null) {
			return false;
		}else {
			return true;
		}
	}
}
