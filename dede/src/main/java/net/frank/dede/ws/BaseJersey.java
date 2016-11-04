package net.frank.dede.ws;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import net.frank.framework.spring.SpringContextHolder;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;

public abstract class BaseJersey {
	private static final Integer DEFAULT_BUFFER_LENGTH = 4096;
	
	protected transient Log log = LogFactory.getLog(this.getClass());
	
	protected String inputStream2String(InputStream inputStrem)throws IOException{
		byte[] buf = new byte[DEFAULT_BUFFER_LENGTH];
		int flag = -1;
		ByteArrayOutputStream bis = new ByteArrayOutputStream();
		while((flag = inputStrem.read(buf)) !=-1){
			bis.write(buf,0,flag);
		}
		return bis.toString();
	}
	
	public ApplicationContext getContext() {
		return SpringContextHolder.getApplicationContext();
	}
	public Object getBean(String beanId) {
		return getContext().getBean(beanId);
	}
}
