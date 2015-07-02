package net.frank.android.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class CurrenyUtil {
	
	static NumberFormat nf = new DecimalFormat("#0.00");
	
	public static Integer processCurreny(String value) {
		BigDecimal bd = new BigDecimal(value);
		bd.setScale(2, BigDecimal.ROUND_HALF_UP);
		bd = bd.multiply(new BigDecimal(100));
		return bd.intValue();
	}
	public static double convertDouble(Integer value){
		BigDecimal bd = new BigDecimal(value);
		bd.setScale(2, BigDecimal.ROUND_HALF_UP);
		bd = bd.divide(new BigDecimal(100));
		return bd.doubleValue();
	}
	
	public static String convertString(Integer value){
		return nf.format(convertDouble(value));
	}
}
