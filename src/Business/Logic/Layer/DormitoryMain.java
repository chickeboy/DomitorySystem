package Business.Logic.Layer;

import Data.access.layer.Dormitory;
import Dormitory.Class.DormitoryDormitory;
import Dormitory.Util.ShowUtil;

public class DormitoryMain {
	Dormitory dormitory = new Dormitory();
	ShowUtil showUtil = new ShowUtil();
	public boolean add(DormitoryDormitory dormitory) {
		if (this.dormitory.dormitoryDormitory(dormitory)!=null) {
			return false;
		}else {
			this.dormitory.add(dormitory);
			return true;
		}
		
	}
	public boolean remove(DormitoryDormitory dormitory) {
		if (this.dormitory.dormitoryDormitory(dormitory)!=null) {
			this.dormitory.remove(dormitory);
			return true;
		}else {
			return false;
		}
	}
	public boolean updata(DormitoryDormitory dormitory,int id,int buildid) {
		DormitoryDormitory dormitory2 = new DormitoryDormitory(id,buildid);
		if (this.dormitory.dormitoryDormitory(dormitory2)!=null) {
			this.dormitory.updata(dormitory,id);
			return true;
		}else {
			return false;
		}
	}
	public void showd() {
		showUtil.show(dormitory.showAll(), "«ﬁ “");
	}
	public void showById(int id) {
		showUtil.show(dormitory.showById(id), id+"∫≈«ﬁ “");
	}
}
