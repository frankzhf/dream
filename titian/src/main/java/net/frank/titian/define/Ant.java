package net.frank.titian.define;

import java.util.Properties;

import org.apache.http.impl.client.CloseableHttpClient;
import org.slf4j.Logger;

public interface Ant {
	public String getOperateId();
	public boolean check();
	
	public AntResult process(CloseableHttpClient client,AccountInfo accountInfo,Properties retailerProperties,BatchContext Context);
	
	public void setLog(Logger log);
	
	public void setWorkspace(String workspace);
	
}
