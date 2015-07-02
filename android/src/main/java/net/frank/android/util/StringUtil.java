package net.frank.android.util;

public abstract class StringUtil {
	public static final String BLANK = "";
	
	public static boolean isEmpty(String value){
		if(value==null || BLANK.equals(value)){
			return true;
		}else{
			return false;
		}
	}
	
	public static boolean isNotEmpty(String value){
		return !isEmpty(value);
	}
	
}
