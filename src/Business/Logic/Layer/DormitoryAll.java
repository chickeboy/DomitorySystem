package Business.Logic.Layer;

import Data.access.layer.BedBusiness;
import Data.access.layer.Dormitory;
import Data.access.layer.DormitoryBuild;
import Dormitory.Class.DormitoryBuilding;

public class DormitoryAll {
	BedBusiness bedBusiness = new BedBusiness();
	Dormitory dormitory = new Dormitory();
	DormitoryBuild dormitoryBuild = new DormitoryBuild();
	public boolean findByBuild(int buildid) {
		DormitoryBuilding building = new DormitoryBuilding(buildid);
		if (condition) {
			
		}dormitoryBuild.dormitoryBuildDind(building);
	}
}
