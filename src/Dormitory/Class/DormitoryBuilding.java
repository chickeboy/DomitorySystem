package Dormitory.Class;

import java.io.Serializable;

//宿舍楼（区分男、女）（ID、地址）
public class DormitoryBuilding implements Serializable,Comparable<DormitoryBuilding>{
	private String type;
	private int id;
	public DormitoryBuilding(String type, int id) {
		super();
		this.type = type;
		this.id = id;
	}
	
	public DormitoryBuilding(int id) {
		super();
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		DormitoryBuilding other = (DormitoryBuilding) obj;
		if (id != other.id)
			return false;
		return true;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "DormitoryBuilding [type=" + type + ", id=" + id + "]";
	}

	@Override
	public int compareTo(DormitoryBuilding o) {
		// TODO Auto-generated method stub
		return id-o.getId();
	}
	
}
