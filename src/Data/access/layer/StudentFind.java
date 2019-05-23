package Data.access.layer;

import java.io.File;
import java.util.ArrayList;

import Dormitory.Class.Student;
import Dormitory.Util.IOutil;

public class StudentFind extends IOutil {
    ArrayList<Student> arrayList;
	public StudentFind(File file) {
		super(file);
	}
	public StudentFind() {
		this(new File("Student.txt"));
	}
	public Student  findByStudent(Student student) {
		arrayList = read();
		Student student2 = null;
		for (int i = 0; i < arrayList.size(); i++) {
			if (arrayList.contains(student)) {
				student2 = arrayList.get(i);
				break;
			}
		}
		return student2;
	}
}
