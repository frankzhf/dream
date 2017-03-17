package net.frank.titian.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public final class PropertiesUtil {
	
	private static Object locker = new Object();
	
	private static Map<String,Properties> cache =  new HashMap<String,Properties>();
	
	private static final String BATCH_PROPERTIES_KEY = "system";
	
	public static final Properties getBatchProperties(){
		return getRetailerProperties(BATCH_PROPERTIES_KEY);
	}
	
	public static final Properties getRetailerProperties(String retailerId){
		synchronized (locker) {
			if(cache.get(retailerId)==null){
				Properties p = new Properties();
				try {
					p.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(retailerId +".properties"));
					cache.put(retailerId, p);
				} catch (IOException e) {
					throw new RuntimeException(e.getMessage(),e);
				};
			}
			return cache.get(retailerId);
		}	
	}
	
	public static void clear(){
		synchronized (locker) {
			cache.clear();
		}
	}
	
	public static void main(String[] args){
		String value = "同学们，我向你们介绍一种水果，那就是草莓。草莓，又叫红莓，地莓等，它的外型呈心形，鲜美红嫩，果肉多汁，酸甜可口，香味浓郁，不仅有色彩还有一般水果所没有的宜人芳香，是水果中难得的色，香，味俱佳者，因此常被人们誉为“果中皇后”。草莓中所含的葫萝卜素是合成纤维A的重要质，它具有明目养肝的作用。它还含有果胶和丰富的膳食纤维，可以帮助消化。草莓对肠胃道和贫血均有一定的滋补调理作用。草莓除可以预防坏血病外，对防治动脉硬化，冠心病也有较好的功效同学们，我向你们介绍一种水果，那就是草莓。草莓，又叫红莓，地莓等，它的外型呈心形，鲜美红嫩，果肉多汁，酸甜可口，香味浓郁，不仅有色彩还有一般水果所没有的宜人芳香，是水果中难得的色，香，味俱佳者，因此常被人们誉为“果中皇后”。草莓中所含的葫萝卜素是合成纤维A的重要质，它具有明目养肝的作用。它还含有果胶和丰富的膳食纤维，可以帮助消化。草莓对肠胃道和贫血均有一定的滋补调理作用。草莓除可以预防坏血病外，对防治动脉硬化，冠心病也有较好的功效。草莓除可以预防坏血病外，草莓除可以预防坏血病外，草莓除可以预防坏血病外，草莓除可以预防坏血病外，是一种红12345678911";
		System.out.println(value.length());
		
	}
}
