package net.frank.titian.base;

import java.io.File;
import java.sql.Connection;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;

import net.frank.titian.define.Batch;
import net.frank.titian.define.BatchContext;
import net.frank.titian.util.ConnectionHolder;
import net.frank.titian.util.SQLiteUtil;

public abstract class AbstractSQLiteBatch implements Batch{
	
	protected transient Logger log = Logger.getLogger(getClass());

	protected abstract BatchContext prepare(String retailerId);

	public void pull(BatchContext context){
		for (int num = 0; num <= context.getRetryNum()
				&& context.getAccountInfoList()!=null 
				&& !context.getAccountInfoList().isEmpty() ; num++) {
			if(num == 0){
				log.debug("First pull");
			}else{
				log.debug("Retry pull " + (num+1) + " time(s).");
			}
			final CountDownLatch mDoneSignal = new CountDownLatch(context.getThreadNum());
			ExecutorService exec = Executors.newFixedThreadPool(context.getThreadNum());
			for (int i = 0; i < context.getThreadNum(); i++) {
				try{
					Thread.sleep(3000);
					exec.execute(new Job(context,mDoneSignal));
				}catch(InterruptedException e){
					log.error(e.getMessage(),e);
				}
			}
			exec.shutdown();
			try{
				mDoneSignal.await(); 
			}catch(InterruptedException e){
				log.error(e.getMessage(),e);
			}
			if(context.needRetry()){
				context.prepareRetry();
			}
		}
		log.debug("pull end");
	}

	public void conversion(BatchContext context){
		log.debug("Execute conversion");
	}

	protected abstract void hook(BatchContext context);
	
	@Override
	public void mainFlow(String retailerId) {
		
		log.info("SQLiteBatch start!");
		log.debug("Input Param [retailerId] -> " + retailerId);
		try {
			BatchContext context = prepare(retailerId);
			File workspace = new File(context.getStorage());
			if(!workspace.exists()){
				workspace.mkdirs();
			}
			Connection conn = ConnectionHolder.getConnection();
			SQLiteUtil.createUserStoreMappingTable(conn);
			pull(context);
			conversion(context);
			hook(context);
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage(), e);
		} finally {
			
			ConnectionHolder.removeConnection();

		}
		log.info("SQLiteBatch end!");
	}
}
