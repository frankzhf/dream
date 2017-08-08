package net.frank.dduo.smart.core.engine;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class AbstractJob implements Runnable {
	protected transient Log log = LogFactory.getLog(getClass()); 
	
}
