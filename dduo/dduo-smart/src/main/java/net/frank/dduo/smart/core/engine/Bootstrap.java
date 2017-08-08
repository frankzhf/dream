package net.frank.dduo.smart.core.engine;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.management.ManagementFactory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.frank.dduo.smart.ProcessStartup;

public final class Bootstrap {
	private transient Log log = LogFactory.getLog(ProcessStartup.class);
	public void startup(){
		String name = ManagementFactory.getRuntimeMXBean().getName();
		String pid = name.split("@")[0];
		File runFolder = new File("run");
		if(!runFolder.exists()){
			runFolder.mkdir();
		}
		File pidFile = new File(runFolder,"daemon.pid");
		RandomAccessFile raf = null;
		try {
			pidFile.createNewFile();
			raf = new RandomAccessFile(pidFile,"rw");
			raf.writeUTF(pid);
			raf.close();
		} catch (IOException e){
			log.error(e.getMessage(),e);
		} finally{
			try{
				if(raf!=null){
					raf.close();
				}
			}catch(IOException e){
			}
		}
	}
}