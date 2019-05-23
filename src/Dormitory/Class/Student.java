package Dormitory.Class;
//学生/宿舍管理员（ID、姓名、性别、登录密码、手机号、专业、校园卡账号）
//（ID、姓名、登录密码）
public class Student {
	private int id;
	private String name;
	private String sex;
	private String password;
	private String phonenumber;
	private String marjoer;
	private String schoolcard;
	
	
	public Student(int id, String name, String sex, String password, String phonenumber, String marjoer,
			String schoolcard) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.password = password;
		this.phonenumber = phonenumber;
		this.marjoer = marjoer;
		this.schoolcard = schoolcard;
	}
	
	public Student(String name, String sex, String password, String phonenumber, String marjoer, String schoolcard) {
		super();
		this.name = name;
		this.sex = sex;
		this.password = password;
		this.phonenumber = phonenumber;
		this.marjoer = marjoer;
		this.schoolcard = schoolcard;
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
	public String getSchoolcard() {
		return schoolcard;
	}
	public void setSchoolcard(String schoolcard) {
		this.schoolcard = schoolcard;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", sex=" + sex + ", password=" + password + ", phonenumber="
				+ phonenumber + ", marjoer=" + marjoer + ", Schoolcard=" + schoolcard + "]";
	}
	
}
