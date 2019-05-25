package Dormitory.Class;

import java.io.Serializable;

public class Repair implements Serializable {
	private int id;
	private int stuid;
	private int dormitory;
	private String content;
	private String time;
	public Repair(int id, int stuid, int dormitory, String content, String time) {
		super();
		this.id = id;
		this.stuid = stuid;
		this.dormitory = dormitory;
		this.content = content;
		this.time = time;
	}
	
	public Repair(int stuid, int dormitory, String content, String time) {
		super();
		this.stuid = stuid;
		this.dormitory = dormitory;
		this.content = content;
		this.time = time;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStuid() {
		return stuid;
	}
	public void setStuid(int stuid) {
		this.stuid = stuid;
	}
	public int getDormitory() {
		return dormitory;
	}
	public void setDormitory(int dormitory) {
		this.dormitory = dormitory;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "Repair [id=" + id + ", stuid=" + stuid + ", dormitory=" + dormitory + ", content=" + content + ", time="
				+ time + "]";
	}
	
}
