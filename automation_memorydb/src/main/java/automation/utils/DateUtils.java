package automation.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	public static final String PATTERN_DEFAULT="yyyy-MM-dd HH:mm:ss";
	public static String format(Long time,String pattern) {
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format.format(new Date(time));
	}
	
	public static void main(String[] args) {
		System.out.println(DateUtils.format(System.currentTimeMillis(),DateUtils.PATTERN_DEFAULT));
	}
}
