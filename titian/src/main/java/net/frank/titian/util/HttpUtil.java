package net.frank.titian.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.frank.titian.ssl.TrustSelfSignedStrategy;

public final class HttpUtil {
	
	private static transient Logger log = LoggerFactory.getLogger(HttpUtil.class);
	
	private static Map<Integer,RequestConfig> cache = new HashMap<Integer,RequestConfig>();
	
	private static Object locker = new Object();
	
	public static CloseableHttpClient createHttpClient(int timeout) {
		try {
			if(cache.get(timeout)== null){
				synchronized (locker) {
					RequestConfig globalConfig = RequestConfig.custom()
							.setCookieSpec(CookieSpecs.BROWSER_COMPATIBILITY)
							.setSocketTimeout(timeout).setConnectTimeout(timeout)
							.setConnectionRequestTimeout(timeout).build();
					cache.put(timeout,globalConfig);
				}
			}
			SSLContextBuilder builder = new SSLContextBuilder();
			builder.loadTrustMaterial(null, new TrustSelfSignedStrategy());
			SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
					builder.build());
	
			CloseableHttpClient httpClient = HttpClients.custom()
					.setDefaultRequestConfig(cache.get(timeout))
					.setSSLSocketFactory(sslsf).build();
			
			return httpClient;
		}catch (Exception e){
			log.error(e.getMessage(),e);
		}
		return null;
	}
	
	public static void release() {
		synchronized (locker) {
			if(cache!=null && !cache.isEmpty()){
				cache.clear();
				cache = null;
			}
		}
	}
	
	
}
