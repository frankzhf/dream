package net.frank.dduo.smart.core.engine;

import java.util.Properties;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.frank.dduo.smart.core.entity.Device;
import net.frank.dduo.smart.core.entity.PoolConfig;

public abstract class AbstractEngine {
	protected transient Log log = LogFactory.getLog(getClass());
	
	private Device device;
	
	private PoolConfig poolConfig;
	
	private Properties properties;
	
	private ThreadPoolExecutor pool = null;
	
	public AbstractEngine(Device device,PoolConfig poolConfig,Properties properties){
		this.device = device;
		this.poolConfig = poolConfig;
		this.properties = properties;
		initPool();
		//start(properties);
	}
	
	public void executeJob(AbstractJob job){
		if(!pool.isShutdown()){
			pool.execute(job);
		}
	}
	
	private void initPool(){
		pool = new ThreadPoolExecutor(
				poolConfig.getNumProcessThreads(),
				poolConfig.getLowWaterMark(),
				30, TimeUnit.MINUTES, new LinkedBlockingQueue<Runnable>(),
				new DefaultThreadFactory(device.getName()),
				new DefaultRejectedExecutionHandler());
	}
	
	public abstract void start(Device device,Properties properties);
	
	public abstract void end(Device device,Properties properties);
	
	public void shutdown(){
		if(pool.isShutdown()){
			return;
		}
		pool.shutdown();		
		end(device,properties);
	}
}
