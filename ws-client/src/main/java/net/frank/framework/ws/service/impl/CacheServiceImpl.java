package net.frank.framework.ws.service.impl;

import java.util.HashMap;
import java.util.Map;

import net.frank.commons.CommonConstants;
import net.frank.framework.bo.Resource;
import net.frank.framework.bo.Type;
import net.frank.framework.service.CacheService;

public class CacheServiceImpl implements CacheService{
	
	private static Map<Long,Type> CACHE_TYPE=new HashMap<Long,Type>();
	
	@Override
	public Map<Long, Type> getTypeContent() {
		synchronized (CACHE_TYPE) {
			if(CACHE_TYPE.isEmpty()){
				CACHE_TYPE = new HashMap<Long,Type>();
				String [] typeRecords = BASE_TYPE_INFO.split(CommonConstants.ARRAY_SPLIT);
				for(int i=0;i<typeRecords.length;i++){
					String record = typeRecords[i];
					String[] fields = record.split(CommonConstants.ARRAY_SPLIT_SEC);
					Type type = new Type();
					type.setId(Long.decode(fields[0]));
					type.setTypeKey(fields[2]);
					type.setEntityClassName(fields[3]);
					Resource resource = new Resource();
					resource.setId(Long.decode(fields[1]));
					type.setResource(resource);
					CACHE_TYPE.put(type.getResource().getId(), type);
				}
			}
			return CACHE_TYPE;
		}
	}

	protected static void setTypeContent(Map<Long,Type> content) {
		synchronized (CACHE_TYPE) {
			if( !CACHE_TYPE.isEmpty()){
				CACHE_TYPE.clear();
				CACHE_TYPE = null;
			}
			CACHE_TYPE = content;
		}
	}

}
