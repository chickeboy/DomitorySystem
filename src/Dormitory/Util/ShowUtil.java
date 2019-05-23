package Dormitory.Util;

import java.util.ArrayList;

public class ShowUtil {
	public <T>void show(ArrayList<T> arrayList,String str) {
		System.out.println("=========所有"+str+"信息===========");
		for (T t : arrayList) {
			System.out.println(t);
		}
	}
}
