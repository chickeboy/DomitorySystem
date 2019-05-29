package Business.Logic.Layer;

import java.util.ArrayList;

import Data.access.layer.DormitoryBuild;
import Dormitory.Class.DormitoryBuilding;
import Dormitory.Util.ShowUtil;

public class Build {
	DormitoryBuild dormitoryBuild = new DormitoryBuild();
	ShowUtil showUtil =  new ShowUtil();
	public boolean add(DormitoryBuilding dormitoryBuilding) {
		if (dormitoryBuild.dormitoryBuildDind(dormitoryBuilding) != null) {
			return false;
		} else {
			dormitoryBuild.save(dormitoryBuilding);
			return true;
		}

	}

	public boolean remove(DormitoryBuilding dormitoryBuilding) {
		if (dormitoryBuild.dormitoryBuildDind(dormitoryBuilding) != null) {
			dormitoryBuild.remove(dormitoryBuilding);
			return true;
		} else {
			return false;
		}
	}

	public boolean updata(DormitoryBuilding dormitoryBuilding, int id) {
		if (dormitoryBuild.upData(dormitoryBuilding, id)) {
			return true;
		}else {
			return false;
		}

	}
	
	public boolean findByid(int id) {
		ArrayList<DormitoryBuilding> arrayList = dormitoryBuild.findById(id);
		if (arrayList.size()==0) {
			return false;
		}else {
			showUtil.show(dormitoryBuild.findById(id), id+"ºÅÂ¥");
			return true;
		}
	}
	public boolean findBytype(String type) {
		ArrayList<DormitoryBuilding> arrayList = dormitoryBuild.findByType(type);
		if (arrayList.size()==0) {
			return false;
		}else {
			showUtil.show(arrayList, type+"ÉúÇÞÊÒ");
			return true;
		}
	}
	public boolean showAll() {
		ArrayList<DormitoryBuilding> arrayList = dormitoryBuild.show();
		if (arrayList.size()==0) {
			return false;
		}else {
			showUtil.show(arrayList, "ÇÞÊÒÂ¥");
			return true;
		}
	}
}
