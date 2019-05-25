package Dormitory.Class;
//学生/宿舍管理员（ID、姓名、性别、登录密码、手机号、专业、校园卡账号）
//（ID、姓名、登录密码）

import java.io.Serializable;

public class Student implements Serializable {
	private int id;
	private String name;
	private String sex;
	private String password;
	private String phonenumber;
	private String marjoer;
	private int schoolcard;
	
	
	public Student(int id, String name, String sex, String password, String phonenumber, String marjoer,
			int schoolcard) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.password = password;
		this.phonenumber = phonenumber;
		this.marjoer = marjoer;
		this.schoolcard = schoolcard;
	}
	
	
	public Student(int id, String name, String sex, String password, String phonenumber, String marjoer) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.password = password;
		this.phonenumber = phonenumber;
		this.marjoer = marjoer;
	}
	
	public Student(String name, String sex, String password, String phonenumber, String marjoer) {
		super();
		this.name = name;
		this.sex = sex;
		this.password = password;
		this.phonenumber = phonenumber;
		this.marjoer = marjoer;
	}


	public Student(int id, String name, String password) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getMarjoer() {
		return marjoer;
	}
	public void setMarjoer(String marjoer) {
		this.marjoer = marjoer;
	}
	
	public int getSchoolcard() {
		return schoolcard;
	}


	public void setSchoolcard(int schoolcard) {
		this.schoolcard = schoolcard;
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", sex=" + sex + ", password=" + password + ", phonenumber="
				+ phonenumber + ", marjoer=" + marjoer + ", Schoolcard=" + schoolcard + "]";
	}
	
}
