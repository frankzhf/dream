package net.frank.titian.util;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDataFormatter;

public final class PoiUtil {
	
	
	public static String getCellValue(HSSFCell cell){
		HSSFDataFormatter format = new HSSFDataFormatter();
		return format.formatCellValue(cell).trim();
	}
	
}
