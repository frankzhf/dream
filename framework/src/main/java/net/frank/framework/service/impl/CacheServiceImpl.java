package net.frank.framework.service.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.frank.framework.bo.Type;
import net.frank.framework.dao.TypeDao;
import net.frank.framework.service.CacheService;

//import net.sf.ehcache.CacheManager;
//import net.sf.ehcache.Element;


public final class CacheServiceImpl implements CacheService {
	
	private static Map<Long,Type> CACHE_TYPE=null;
	
	//private CacheManager ehCacheManager;
	
	private TypeDao typeDao;
	
	//public void setEhCacheManager(CacheManager ehCacheManager){
	//	this.ehCacheManager = ehCacheManager;
	//}
	
	public void setTypeDao(TypeDao typeDao){
		this.typeDao=typeDao;
	}
	
	
	@Override
	public Map<Long, Type> getTypeContent() {
		if(CACHE_TYPE==null){
		//if(ehCacheManager.getEhcache(TYPE_CACHE_NAME).getSize() == 0){
			CACHE_TYPE = new HashMap<Long,Type>();
			List<Type> typeList = typeDao.retriveTypeList();
			for(Iterator<Type> it=typeList.iterator();it.hasNext();){
				Type type = it.next();
				CACHE_TYPE.put(type.getResource().getId(), type);
		//		Element e = new Element(type.getResource().getId(),type);
		//		ehCacheManager.getEhcache(TYPE_CACHE_NAME).put(e);
			}
		}
		return CACHE_TYPE;
	}

}
