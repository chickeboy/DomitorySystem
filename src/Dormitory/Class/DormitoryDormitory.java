package Dormitory.Class;

import java.io.Serializable;

//ËŞÉá£¨ËŞÉáID/±àºÅ¡¢ËŞÉáÂ¥ID¡¢×î´óÈİÁ¿£©
public class DormitoryDormitory implements Serializable {
	private int id;
	private int buildid;
	private int capacity;

	public DormitoryDormitory(int id, int buildid, int capacity) {
		super();
		this.id = id;
		this.buildid = buildid;
		this.capacity = capacity;
	}

	public DormitoryDormitory(int id, int buildid) {
		super();
		this.id = id;
		this.buildid = buildid;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + buildid;
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
		DormitoryDormitory other = (DormitoryDormitory) obj;
		if (buildid != other.buildid)
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBuildid() {
		return buildid;
	}

	public void setBuildid(int buildid) {
		this.buildid = buildid;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return "ËŞÉáÂ¥ºÅ£º" + buildid + "ËŞÉáºÅ£º" + id + "ÇŞÊÒ×î´óÈËÊı£º" + capacity;
	}

}
