package Dormitory.Class;
//¥≤∆Ã£®Àﬁ…·ID°¢¥≤∫≈°¢StuID£©
public class DormitoryBed {
	private int id;
	private int dormitory;
	private int StuID;
	public DormitoryBed(int id, int dormitory, int stuID) {
		super();
		this.id = id;
		this.dormitory = dormitory;
		StuID = stuID;
	}
	
	public DormitoryBed(int id, int dormitory) {
		super();
		this.id = id;
		this.dormitory = dormitory;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dormitory;
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
		DormitoryBed other = (DormitoryBed) obj;
		if (dormitory != other.dormitory)
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
	public int getDormitory() {
		return dormitory;
	}
	public void setDormitory(int dormitory) {
		this.dormitory = dormitory;
	}
	public int getStuID() {
		return StuID;
	}
	public void setStuID(int stuID) {
		StuID = stuID;
	}
	@Override
	public String toString() {
		return "«ﬁ “∫≈£∫"+dormitory+"¥≤∫≈"+id+"—ß…˙—ß∫≈"+StuID;
	}
	
}
