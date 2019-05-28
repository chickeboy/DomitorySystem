package Data.access.layer;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import Dormitory.Class.Student;
import Dormitory.Util.IOutil;

public class StudentMain extends IOutil {
	ArrayList<Student> arrayList;
	public StudentMain(File file) {
		super(file);
	}
	public StudentMain() {
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
	public void add(Student student) {
		arrayList = read();
		arrayList.add(student);
		write(arrayList);
	}
	public ArrayList<Student> showAll() {
		return arrayList = read();
	}
	public int findLastId() {
		arrayList = read();
		if (arrayList.size()==0) {
			return -1;
		}else {
			return arrayList.get(arrayList.size()-1).getId();
		}
	}
	public Student findById(int stuId) {
		arrayList = read();
		for (int i = 0; i <arrayList.size(); i++) {
			if (arrayList.get(i).getId()==stuId) {
				return arrayList.get(i);
			}
		}
		return null;
	}
	public void changePassword(int stuid,String password) {
		arrayList = read();
		for (int i = 0; i <arrayList.size(); i++) {
			if (arrayList.get(i).getId()==stuid) {
				arrayList.get(i).setPassword(password);
			}
		}
		write(arrayList);
	}
	public HashMap<String, String> findPassWord(int stuid) {
		arrayList =  read();
		HashMap<String, String> hashMap = null;
		for (int i = 0; i <arrayList.size(); i++) {
			if (arrayList.get(i).getId()==stuid) {
				hashMap = arrayList.get(i).getHashMap();
			}
		}
		return hashMap;
	}
}
