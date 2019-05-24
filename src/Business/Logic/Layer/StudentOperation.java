package Business.Logic.Layer;
import Data.access.layer.StudentMain;
import Dormitory.Class.Student;
import Dormitory.Util.ShowUtil;

public class StudentOperation {
	StudentMain studentMain = new StudentMain();
	ShowUtil showUtil = new ShowUtil();
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
}
