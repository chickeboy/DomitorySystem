package Business.Logic.Layer;

import java.util.ArrayList;

import Data.access.layer.BedBusiness;
import Data.access.layer.Dormitory;
import Data.access.layer.DormitoryBuild;
import Data.access.layer.DormitoryData;
import Dormitory.Class.DormitoryAll;
import Dormitory.Class.DormitoryBed;
import Dormitory.Class.DormitoryBuilding;
import Dormitory.Class.DormitoryDormitory;
import Dormitory.Util.ShowUtil;

public class DormitoryAllMain {
	BedBusiness bedBusiness = new BedBusiness();
	Dormitory dormitory = new Dormitory();
	DormitoryBuild dormitoryBuild = new DormitoryBuild();
	ShowUtil showUtil = new ShowUtil();
	ArrayList<DormitoryBed> arrayListbed = new ArrayList<DormitoryBed>();
	ArrayList<DormitoryDormitory> arrayListdormitory = new ArrayList<DormitoryDormitory>();
	ArrayList<DormitoryBuilding> arrayListbuild = new ArrayList<DormitoryBuilding>();
	ArrayList<DormitoryAll> arrayListAll = new ArrayList<DormitoryAll>();
	DormitoryData data =new DormitoryData();
	public int findByBuild(int buildid) {
		int a = 1;// 输出正常情况下
		arrayListbuild = dormitoryBuild.findById(buildid);
		if (arrayListbuild.size() != 0) {
			arrayListdormitory = dormitory.findByBuildId(buildid);
			if (arrayListdormitory.size() != 0) {
				for (int i = 0; i < arrayListdormitory.size(); i++) {
					arrayListbed.addAll(bedBusiness.showBydormitory(arrayListdormitory.get(i).getId()));
					if (arrayListbed.size() != 0) {
						showUtil.show(arrayListbed, buildid + "号楼床铺");
					}
				}
			} else {
				a = 2;// 这栋类没有寝室
			}
		} else {
			return 3;// 没有这栋楼
		}
		return a;
	}
	public void show(ArrayList<DormitoryAll> alls,int dormitory ) {
		showUtil.show(alls,dormitory+"寝室");
	}
	public double occupancy(int buildid,int dormitory) {
		double b = 0;
		ArrayList<DormitoryBed> arrayList = new ArrayList<DormitoryBed>();
		arrayListbed = bedBusiness.showBydormitory(dormitory);
		arrayListdormitory = this.dormitory.showById(dormitory);
		for (DormitoryDormitory dormitoryDormitory : arrayListdormitory) {
			for (DormitoryBed dormitoryBed : arrayListbed) {
					if (dormitoryDormitory.getBuildid()==buildid&&dormitoryBed.getDormitory()==dormitory) {
						arrayList.add(dormitoryBed);
						b = dormitoryDormitory.getCapacity();
					}
				}
		}
		return arrayList.size()/b;
	}
	public ArrayList<DormitoryAll> findByDormitory(int dormitory) {
		arrayListbed = bedBusiness.showBydormitory(dormitory);
		arrayListdormitory = this.dormitory.showById(dormitory);
		arrayListbuild = dormitoryBuild.show();
		for (DormitoryBuilding dormitoryBuilding : arrayListbuild) {
			for (DormitoryDormitory dormitoryDormitory : arrayListdormitory) {
				for (DormitoryBed dormitoryBed : arrayListbed) {
					if (dormitoryDormitory.getBuildid() == dormitoryBuilding.getId()
							&& dormitoryBed.getDormitory() == dormitoryDormitory.getId()) {
						arrayListAll.add(new DormitoryAll(dormitoryBed, dormitoryDormitory, dormitoryBuilding));
					}
				}
			}
		}
		return arrayListAll;
	}
	public DormitoryAll findByStuId(int stuId) {
		return data.findByStuId(stuId);
			
	}
}
