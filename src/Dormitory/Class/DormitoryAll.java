package Dormitory.Class;

public class DormitoryAll {
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
	
	public DormitoryAll(DormitoryDormitory dormitoryDormitory, DormitoryBuilding dormitoryBuilding) {
		super();
		this.dormitoryDormitory = dormitoryDormitory;
		this.dormitoryBuilding = dormitoryBuilding;
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
		return "DormitoryAll [dormitoryBed=" + dormitoryBed + ", dormitoryDormitory=" + dormitoryDormitory
				+ ", dormitoryBuilding=" + dormitoryBuilding + "]";
	}
	
}	
