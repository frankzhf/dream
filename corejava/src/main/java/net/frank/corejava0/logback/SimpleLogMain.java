package net.frank.corejava0.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.frank.corejava0.logback.jobs.MyRunnable;

public class SimpleLogMain {
	static final Logger LOG = LoggerFactory.getLogger(SimpleLogMain.class);
	public static void main(String[] args) {
		LOG.trace("Hello World!");
		LOG.debug("How are you today?");
		LOG.info("I am fine.");
		LOG.warn("I love programming.");
		LOG.error("I am programming.");
		String[] jobName= new String[] {
			"sluRtuSyncJob","lampTimoutoutJob","cctvJob","gatewayCallJob",
			"reloadDataJob","reloadCategroyJob","reloadActiviJob","reloadVipRuleJob",
			"reloadBlogJob","reloadArticleJob"
		};
		Thread[] jobs = new Thread[10];
		for(int i=0;i<jobs.length;i++) {
			Thread job = new Thread(new MyRunnable(jobName[i]));
			jobs[i] = job;
		}
		for(int i=0;i<jobs.length;i++) {
			jobs[i].start();
		}
		
	}

}
