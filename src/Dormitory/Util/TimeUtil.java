package Dormitory.Util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
	public String time() {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		return dateFormat.format(date);
//		Date now = new Date(); 
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//可以方便地修改日期格式
//
//		String hehe = dateFormat.format( now ); 
	}
}
