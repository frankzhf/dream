package net.frank.framework.ws.service.impl;

import java.util.Map;

import net.frank.framework.bo.Type;

public class TypeContextSetHolder {
	public static void setTypeContent(Map<Long,Type> content){
		CacheServiceImpl.setTypeContent(content);
	}
}
