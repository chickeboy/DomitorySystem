package Dormitory.Class;

public class Rechargeable {
	private int id;
	private int stuId;
	private int money;
	private String time;
	public Rechargeable(int id, int stuId, int money, String time) {
		super();
		this.id = id;
		this.stuId = stuId;
		this.money = money;
		this.time = time;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStuId() {
		return stuId;
	}
	public void setStuId(int stuId) {
		this.stuId = stuId;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "Rechargeable [id=" + id + ", stuId=" + stuId + ", money=" + money + ", time=" + time + "]";
	}
	
}
