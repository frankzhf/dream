package net.frank.framework.web.taglib.content.property;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import net.frank.commons.CommonConstants;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public final class PropertiesResourceCacheProvider {
	
	public static final String DEFAULT_COUNTRY_LANGUAGE_CD = "default";
	
	private static final String PROPERTIES_FILE_SUFFIX = ".properties";
	
	private transient Log log = LogFactory.getLog(getClass());

	private static Map<String, Map<String,Properties>> cache = new HashMap<String, Map<String,Properties>>();
	
	private String propertiesPath;
	
	public void setPropertiesPath(String propertiesPath){
		this.propertiesPath = propertiesPath;
	}
	
	public Properties getPropertiesResource(String resourceName){
		return getPropertiesResource(resourceName,DEFAULT_COUNTRY_LANGUAGE_CD);
	}
	
	public Properties getPropertiesResource(String resourceName,String contryLanguageCd) {
		Map<String,Properties> bandle = cache.get(resourceName);
		Properties returnProperties = null;
		if (bandle == null) {
			bandle = new HashMap<String,Properties>();
			Properties defaultPreperties = new Properties();
			try {
				StringBuffer path = new StringBuffer(512);
				path.append(propertiesPath).append(CommonConstants.PATH_SYMBOL).append(resourceName).append(PROPERTIES_FILE_SUFFIX);
				log.debug("Properties file path:"+path.toString());
				defaultPreperties.load(Thread.currentThread()
						.getContextClassLoader()
						.getResourceAsStream(path.toString()));
				bandle.put(DEFAULT_COUNTRY_LANGUAGE_CD, defaultPreperties);
			} catch (IOException e) {
				log.error("Read Properties File errors.");
				e.printStackTrace();
			}
		}
		returnProperties = bandle.get(contryLanguageCd);
		if(returnProperties == null){
			try {
				returnProperties = new Properties();
				returnProperties.load(Thread.currentThread()
						.getContextClassLoader()
						.getResourceAsStream(propertiesPath+resourceName+"_"+contryLanguageCd+".properties"));
				bandle.put(contryLanguageCd, returnProperties);
			} catch (Exception e) {
				log.error("Read Properties File errors.");
				returnProperties = bandle.get(DEFAULT_COUNTRY_LANGUAGE_CD);
			}
		}
		return returnProperties;
	}

}
