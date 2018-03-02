package net.frank.yangtes.quartz.job.demo;

import java.util.Map;

import net.frank.yangtes.quartz.job.AbstractBaseJob;

public class SampleOneJob extends AbstractBaseJob {

	@Override
	public void processBns(String jobId, String jobName, Map<String, Object> parameterMap) {
		log.debug("Process Demo .....");
	}


}
