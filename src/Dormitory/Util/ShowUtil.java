package Dormitory.Util;

import java.util.ArrayList;

public class ShowUtil {
	public <T>void show(ArrayList<T> arrayList,String str) {
		System.out.println("=========����"+str+"��Ϣ===========");
		for (T t : arrayList) {
			System.out.println(t);
		}
	}
}
