package net.frank.titian.util;

import java.util.Properties;

import net.frank.commons.util.PropertiesUtil;

public final class RetailerPropertiesUtil {
	
	private static final String BATCH_PROPERTIES_KEY = "system";
	
	public static final Properties getBatchProperties(){
		return PropertiesUtil.getProperties(BATCH_PROPERTIES_KEY);
	}
	
	public static final Properties getRetailerProperties(String retailerId){
		return PropertiesUtil.getProperties(retailerId);
	}
}
