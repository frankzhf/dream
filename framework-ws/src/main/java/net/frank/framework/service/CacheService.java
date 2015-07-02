package net.frank.framework.service;

import java.util.Map;

import net.frank.framework.bo.Type;

public interface CacheService {
	
	public static final String TYPE_CACHE_NAME = "typeCache";
	
	public static final String BASE_TYPE_INFO = "1#3#RESOURCE#net.frank.framework.bo.Resource# ##2#4#TYPE#net.frank.framework.bo.Type# ";
	
	public Map<Long,Type>getTypeContent();
}
