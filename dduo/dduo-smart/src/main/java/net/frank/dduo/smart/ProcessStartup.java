package net.frank.dduo.smart;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.frank.dduo.smart.core.engine.AbstractEngine;
import net.frank.dduo.smart.core.engine.Bootstrap;
import net.frank.dduo.smart.core.entity.Device;
import net.frank.dduo.smart.core.entity.PoolConfig;
import net.frank.dduo.smart.core.exception.DsBizExpt;
import net.frank.dduo.smart.core.util.JsonUtil;

public class ProcessStartup {
	private static transient Log log = LogFactory.getLog(ProcessStartup.class);
	public static void main(String[] args) {
		Bootstrap bootstrap = new Bootstrap();
		bootstrap.startup();
		Properties p = new Properties();
		try{
			p.load(Thread.currentThread()
					.getContextClassLoader()
					.getResourceAsStream("gateway.properties"));
		}catch(IOException e){
			log.error(e.getMessage(),e);
			System.exit(1);
		}
		
		String gatewayIds = p.getProperty("device.gateway.id.list");
		
		String[] gatewayArr = gatewayIds.split(",");
		String gatewayId = null;
		for (int i = 0; i < gatewayArr.length; i++) {
			gatewayId = gatewayArr[i].trim();
			if(StringUtils.isNotBlank(gatewayId)) {			
				structureDaemon(gatewayId,p);
			}
			else{
				throw new DsBizExpt("gatewayId is blank");
			}
		}
		log.debug("dduo smart startup end <<<<<<<<<<<<<<<<<<");
	}
	
	/**
	 * 
	 * @param gatewayId
	 * @param properties
	 */
	
	private static void structureDaemon(String gatewayId,Properties properties){
		String deviceJsonStr = properties.getProperty(gatewayId+".device");
		String poolJsonStr = properties.getProperty(gatewayId+".pool");
		String engineClazz = properties.getProperty(gatewayId+".engine.class");
		
		PoolConfig poolConfig = JsonUtil.fromJson(poolJsonStr, PoolConfig.class);
		Device device = JsonUtil.fromJson(deviceJsonStr, Device.class);
		device.setGatewayId(gatewayId);
		if(StringUtils.isNotBlank(engineClazz)){
			try{
				AbstractEngine engine = (AbstractEngine)
						Class.forName(engineClazz).
							getConstructor(Device.class,PoolConfig.class,Properties.class).
								newInstance(device,poolConfig,properties);
				engine.start(device,properties);
			}catch(ClassNotFoundException e){
				throw new DsBizExpt(e.getMessage());
			}catch(NoSuchMethodException e){
				throw new DsBizExpt(e.getMessage());
			}catch(SecurityException e){
				throw new DsBizExpt(e.getMessage());
			}catch(InstantiationException e){
				throw new DsBizExpt(e.getMessage());
			}catch(IllegalAccessException e){
				throw new DsBizExpt(e.getMessage());
			}catch(IllegalArgumentException e){
				throw new DsBizExpt(e.getMessage());
			}catch(InvocationTargetException e){
				throw new DsBizExpt(e.getMessage());
			}
		}else{
			throw new DsBizExpt("engine.class is blank");
		}
	}
	
}
