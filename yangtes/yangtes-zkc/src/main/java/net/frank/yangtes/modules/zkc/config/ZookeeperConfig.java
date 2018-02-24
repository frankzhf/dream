package net.frank.yangtes.modules.zkc.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ZookeeperConfig {
	
	@Value("#{APP_PROP['zookeeper.host']}")
	private String host;
	@Value("#{APP_PROP['zookeeper.timeout']}")
	private int timeout;

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

}