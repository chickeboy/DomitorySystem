package Dormitory.Class;

import java.io.Serializable;

public class InPutOutPut implements Serializable{
	private int id;
	private String stuname;
	private DormitoryAll dormitoryAll;
	public InPutOutPut(int id, String stuname, DormitoryAll dormitoryAll) {
		super();
		this.id = id;
		this.stuname = stuname;
		this.dormitoryAll = dormitoryAll;
	}
	public InPutOutPut(String stuname, DormitoryAll dormitoryAll) {
		super();
		this.stuname = stuname;
		this.dormitoryAll = dormitoryAll;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStuname() {
		return stuname;
	}
	public void setStuname(String stuname) {
		this.stuname = stuname;
	}
	public DormitoryAll getDormitoryAll() {
		return dormitoryAll;
	}
	public void setDormitoryAll(DormitoryAll dormitoryAll) {
		this.dormitoryAll = dormitoryAll;
	}
	@Override
	public String toString() {
		return "InPutOutPut [id=" + id + ", stuname=" + stuname + ", dormitoryAll=" + dormitoryAll + "]";
	}
	
}
