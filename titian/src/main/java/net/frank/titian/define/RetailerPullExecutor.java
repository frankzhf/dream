package net.frank.titian.define;

import java.util.List;
import java.util.Properties;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.log4j.Logger;

public interface RetailerPullExecutor{
	
	void setRetailerProperties(Properties properties);
	
	AntResult home(CloseableHttpClient client,BatchContext context);
	
	List<Ant> getAntActionList();
	
	void setLogger(Logger log);
	
	void setWorkspace(String workspace);
}
