package Dormitory.Class;

import java.io.Serializable;

public class SchoolCard implements Serializable{
	private int id;
	private int stuid;
	private String payid;
	private int balance;
	public SchoolCard(int id, int stuid, String payid, int balance) {
		super();
		this.id = id;
		this.stuid = stuid;
		this.payid = payid;
		this.balance = balance;
	}
	
	public SchoolCard(int id, int stuid, String payid) {
		super();
		this.id = id;
		this.stuid = stuid;
		this.payid = payid;
	}

	public SchoolCard(int stuid, String payid) {
		super();
		this.stuid = stuid;
		this.payid = payid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((payid == null) ? 0 : payid.hashCode());
		result = prime * result + stuid;
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
		SchoolCard other = (SchoolCard) obj;
		if (payid == null) {
			if (other.payid != null)
				return false;
		} else if (!payid.equals(other.payid))
			return false;
		if (stuid != other.stuid)
			return false;
		return true;
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
	public String getPayid() {
		return payid;
	}
	public void setPayid(String payid) {
		this.payid = payid;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "SchoolCard [id=" + id + ", stuid=" + stuid + ", payid=" + payid + ", balance=" + balance + "]";
	}
	
}
