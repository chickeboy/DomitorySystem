package Data.access.layer;

import java.io.File;
import java.util.ArrayList;

import Dormitory.Class.InPutOutPut;
import Dormitory.Util.IOutil;

public class InputData extends IOutil{
	public InputData(File file) {
		super(file);
		// TODO Auto-generated constructor stub
	}
	public InputData() {
		this(new File("Input.txt"));
		// TODO Auto-generated constructor stub
	}
	ArrayList<InPutOutPut> arrayList;
	public void add(InPutOutPut inPutOutPut) {
		arrayList = read();
		arrayList.add(inPutOutPut);
		write(arrayList);
	}
	public int getlastId() {
		arrayList = read();
		if (arrayList.size()==0) {
			return -1;
		}else {
			return arrayList.get(arrayList.size()-1).getId();
		}
	}
}
