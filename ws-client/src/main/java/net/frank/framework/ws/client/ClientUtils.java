package net.frank.framework.ws.client;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.impl.client.DefaultHttpClient;

import net.frank.framework.ws.WsRenderProvider;
import net.frank.framework.ws.define.WsRender;
import net.frank.framework.ws.process.BoXmlUtil;
import net.frank.framework.ws.render.DefaultWsRender;
import net.frank.framework.ws.render.type.BigDecimalTypeRender;
import net.frank.framework.ws.render.type.BlobTypeRender;
import net.frank.framework.ws.render.type.BoTypeRender;
import net.frank.framework.ws.render.type.BooleanTypeRender;
import net.frank.framework.ws.render.type.ByteTypeRender;
import net.frank.framework.ws.render.type.ClobTypeRender;
import net.frank.framework.ws.render.type.IntegerTypeRender;
import net.frank.framework.ws.render.type.LongTypeRender;
import net.frank.framework.ws.render.type.ResourceRefRender;
import net.frank.framework.ws.render.type.ResourceTypeRender;
import net.frank.framework.ws.render.type.TimestameTypeRender;
import net.frank.framework.ws.render.type.WsAaInfoTypeRender;
import net.frank.framework.ws.render.type.WsRequestTypeRender;
import net.frank.framework.ws.render.type.WsResponseTypeRender;
import net.frank.framework.ws.service.impl.CacheServiceImpl;

public final class ClientUtils {
	
	private static ClientUtils instance = null;
	private static Map<String,Object> contentMap; 
	private static DefaultHttpClient httpClient;
	
	private ClientUtils(ExtendClientUtils extendClientUtils){
		contentMap = new HashMap<String,Object>();
		try{
			WsRenderProvider wsRenderProvider = new WsRenderProvider();
			Map<String,WsRender> wsRenderMap = new HashMap<String,WsRender>();
			wsRenderProvider.setWsRenderMap(wsRenderMap);
			contentMap.put("wsRenderProvider", wsRenderProvider);
			
			BoXmlUtil boXmlUtil = new BoXmlUtil();
			boXmlUtil.setWsRenderProvider(wsRenderProvider);
			contentMap.put("boXmlUtil", boXmlUtil);
			
			DefaultWsRender defaultWsRender = new DefaultWsRender();
			defaultWsRender.setWsRenderProvider(wsRenderProvider);
			contentMap.put("defaultWsRender", defaultWsRender);
			
			IntegerTypeRender integerWsRender = new IntegerTypeRender();
			integerWsRender.setWsRenderProvider(wsRenderProvider);
			contentMap.put("integerWsRender", integerWsRender);
			
			BigDecimalTypeRender bigDecimalWsRender = new BigDecimalTypeRender();
			bigDecimalWsRender.setWsRenderProvider(wsRenderProvider);
			contentMap.put("bigDecimalWsRender", bigDecimalWsRender);
			
			BooleanTypeRender booleanWsRender = new BooleanTypeRender();
			booleanWsRender.setWsRenderProvider(wsRenderProvider);
			contentMap.put("booleanWsRender", booleanWsRender);
			
			TimestameTypeRender timeWsRender = new TimestameTypeRender();
			timeWsRender.setWsRenderProvider(wsRenderProvider);
			contentMap.put("timeWsRender", timeWsRender);
			
			LongTypeRender longWsRender = new LongTypeRender();
			longWsRender.setWsRenderProvider(wsRenderProvider);
			contentMap.put("longWsRender", longWsRender);
			
			ClobTypeRender clobWsRender = new ClobTypeRender();
			clobWsRender.setWsRenderProvider(wsRenderProvider);
			contentMap.put("clobWsRender", clobWsRender);
			
			BlobTypeRender blobWsRender = new BlobTypeRender();
			blobWsRender.setWsRenderProvider(wsRenderProvider);
			contentMap.put("blobWsRender", clobWsRender);
			
			ResourceTypeRender resourceWsRender = new ResourceTypeRender();
			resourceWsRender.setWsRenderProvider(wsRenderProvider);
			contentMap.put("resourceWsRender", resourceWsRender);
			
			ResourceRefRender defaultResourceRefRender = new ResourceRefRender();
			defaultResourceRefRender.setWsRenderProvider(wsRenderProvider);
			contentMap.put("defaultResourceRefRender", defaultResourceRefRender);
			
			BoTypeRender boWsRender = new BoTypeRender();
			boWsRender.setWsRenderProvider(wsRenderProvider);
			contentMap.put("boWsRender", boWsRender);
			
			WsAaInfoTypeRender wsAaInfoRender = new WsAaInfoTypeRender();
			wsAaInfoRender.setWsRenderProvider(wsRenderProvider);
			contentMap.put("wsAaInfoRender", wsAaInfoRender);
			
			WsRequestTypeRender wsRequestRender = new WsRequestTypeRender();
			wsRequestRender.setWsRenderProvider(wsRenderProvider);
			contentMap.put("wsRequestRender", wsRequestRender);
			
			WsResponseTypeRender wsResponseRender = new WsResponseTypeRender();
			wsResponseRender.setWsRenderProvider(wsRenderProvider);
			contentMap.put("wsResponseRender", wsResponseRender);
			
			CacheServiceImpl cacheService = new CacheServiceImpl();
			resourceWsRender.setCacheService(cacheService);
			contentMap.put("cacheService", cacheService);
			
			
			ByteTypeRender byteWsRender = new ByteTypeRender();
			byteWsRender.setWsRenderProvider(wsRenderProvider);
			contentMap.put("byteWsRender", byteWsRender);
			
			wsRenderMap.put("default", defaultWsRender);
			wsRenderMap.put("java.lang.String", defaultWsRender);
			wsRenderMap.put("java.lang.Integer", integerWsRender);
			wsRenderMap.put("java.math.BigDecimal", bigDecimalWsRender);
			wsRenderMap.put("java.lang.Boolean", booleanWsRender);
			wsRenderMap.put("java.util.Date", timeWsRender);
			wsRenderMap.put("java.lang.Long", longWsRender);
			wsRenderMap.put("java.lang.Byte",byteWsRender);
			wsRenderMap.put("[C", clobWsRender);
			wsRenderMap.put("[B", blobWsRender);
			wsRenderMap.put("net.frank.framework.bo.Resource", resourceWsRender);
			wsRenderMap.put("defaultResourceRef", defaultResourceRefRender);
			wsRenderMap.put("net.frank.framework.bo.BusinessObject", boWsRender);
			wsRenderMap.put("net.frank.framework.ws.define.WsAaInfo", wsAaInfoRender);
			wsRenderMap.put("net.frank.framework.ws.define.WsRequest", wsRequestRender);
			wsRenderMap.put("net.frank.framework.ws.define.WsResponse", wsResponseRender);
			try{
				if(extendClientUtils!=null){
					extendClientUtils.loadContentMap(contentMap);
				}
			}catch(Exception ee){
				
			}
			
			httpClient = new DefaultHttpClient();
		}catch(RuntimeException e){
			
		}
	}
	
	public static ClientUtils getInstance(){
		if(instance == null){
			instance = new ClientUtils(null);
		}
		return instance;
	}
	
	public static ClientUtils getInstance(ExtendClientUtils extendClientUtils){
		if(instance == null){
			instance = new ClientUtils(extendClientUtils);
		}
		return instance;
	}
	
	public Object getBean(String beanId) {
		return contentMap.get(beanId);
	}
	
	public DefaultHttpClient getClient(){
		return httpClient;
	}

	public static void close() {
		contentMap.clear();
		contentMap = null;
		httpClient = null;
	}
}
