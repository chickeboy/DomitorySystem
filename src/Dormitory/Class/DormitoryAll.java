package Dormitory.Class;

import java.io.Serializable;

public class DormitoryAll implements Serializable {
	private DormitoryBed dormitoryBed;
	private DormitoryDormitory dormitoryDormitory;
	private DormitoryBuilding dormitoryBuilding;
	public DormitoryAll(DormitoryBed dormitoryBed, DormitoryDormitory dormitoryDormitory,
			DormitoryBuilding dormitoryBuilding) {
		super();
		this.dormitoryBed = dormitoryBed;
		this.dormitoryDormitory = dormitoryDormitory;
		this.dormitoryBuilding = dormitoryBuilding;
	}
	
	public DormitoryAll(DormitoryBed dormitoryBed, DormitoryDormitory dormitoryDormitory) {
		super();
		this.dormitoryBed = dormitoryBed;
		this.dormitoryDormitory = dormitoryDormitory;
	}
	public DormitoryAll(DormitoryDormitory dormitoryDormitory, DormitoryBuilding dormitoryBuilding) {
		super();
		this.dormitoryDormitory = dormitoryDormitory;
		this.dormitoryBuilding = dormitoryBuilding;
	}
	
	public DormitoryAll() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dormitoryBed == null) ? 0 : dormitoryBed.hashCode());
		result = prime * result + ((dormitoryBuilding == null) ? 0 : dormitoryBuilding.hashCode());
		result = prime * result + ((dormitoryDormitory == null) ? 0 : dormitoryDormitory.hashCode());
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
		DormitoryAll other = (DormitoryAll) obj;
		if (dormitoryBed == null) {
			if (other.dormitoryBed != null)
				return false;
		} else if (!dormitoryBed.equals(other.dormitoryBed))
			return false;
		if (dormitoryBuilding == null) {
			if (other.dormitoryBuilding != null)
				return false;
		} else if (!dormitoryBuilding.equals(other.dormitoryBuilding))
			return false;
		if (dormitoryDormitory == null) {
			if (other.dormitoryDormitory != null)
				return false;
		} else if (!dormitoryDormitory.equals(other.dormitoryDormitory))
			return false;
		return true;
	}

	public DormitoryBed getDormitoryBed() {
		return dormitoryBed;
	}
	public void setDormitoryBed(DormitoryBed dormitoryBed) {
		this.dormitoryBed = dormitoryBed;
	}
	public DormitoryDormitory getDormitoryDormitory() {
		return dormitoryDormitory;
	}
	public void setDormitoryDormitory(DormitoryDormitory dormitoryDormitory) {
		this.dormitoryDormitory = dormitoryDormitory;
	}
	public DormitoryBuilding getDormitoryBuilding() {
		return dormitoryBuilding;
	}
	public void setDormitoryBuilding(DormitoryBuilding dormitoryBuilding) {
		this.dormitoryBuilding = dormitoryBuilding;
	}
	@Override
	public String toString() {
		return dormitoryBuilding +" "+dormitoryDormitory+ " "+dormitoryBed ;
	}
	
}	
