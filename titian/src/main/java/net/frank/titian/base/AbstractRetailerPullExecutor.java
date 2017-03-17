package net.frank.titian.base;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.log4j.Logger;

import net.frank.titian.define.Ant;
import net.frank.titian.define.AntResult;
import net.frank.titian.define.BatchContext;
import net.frank.titian.define.Constants;
import net.frank.titian.define.RetailerPullExecutor;

public abstract class AbstractRetailerPullExecutor implements RetailerPullExecutor {
	
	protected static final String PHASE = Constants.PHASE.CREEP;
	
	protected Logger log;
	
	protected String workspace;
	
	protected Properties retailerProperties;

	private List<Ant> antActionList = new ArrayList<Ant>();

	public void setAntActionList(List<Ant> antActionList) {
		this.antActionList = antActionList;
	}

	@Override
	public AntResult home(CloseableHttpClient client, BatchContext context) {
		AntResult result = new AntResult();
		try {
			HttpGet httpGet = new HttpGet(getHomeUrl());
			CloseableHttpResponse response = client.execute(httpGet);
			if (response.getStatusLine().getStatusCode() == 200) {
				result.setStatus(Constants.ACTION_RESULT.SUCCESS);
			} else {
				result.setStatus(Constants.ACTION_RESULT.FAILURE);
			}
			return result;
		} catch (ClientProtocolException e) {
			log.error(e.getMessage());
			result.setStatus(Constants.ACTION_RESULT.FAILURE);
			result.setContent(e.getMessage());
		} catch (IOException e) {
			log.error(e.getMessage());
			result.setStatus(Constants.ACTION_RESULT.FAILURE);
			result.setContent(e.getMessage());
		}
		return result;
	}

	@Override
	public List<Ant> getAntActionList() {
		return antActionList;
	}

	@Override
	public void setLogger(Logger log){
		this.log = log;
	}
	
	@Override
	public void setRetailerProperties(Properties retailerProperties){
		this.retailerProperties = retailerProperties;
	}
	
	@Override
	public void setWorkspace(String workspace){
		this.workspace = workspace;
	};
	
	
	public abstract String getHomeUrl();

}
