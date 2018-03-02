package net.frank.yangtes.quartz.job;

import java.util.Map;
import java.util.StringTokenizer;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.frank.yangtes.commons.config.Global;
import net.frank.yangtes.commons.utils.SendMailUtil;
import net.frank.yangtes.commons.utils.SpringContextHolder;
import net.frank.yangtes.commons.utils.StringUtils;
import net.frank.yangtes.quartz.QuartzConstant;
import net.frank.yangtes.quartz.util.QuartzManager;
import net.frank.yangtes.quartz.web.service.TaskService;

public abstract class AbstractBaseJob implements Job  {
	protected transient Logger log = LoggerFactory.getLogger(getClass());
	
	public void shutdownJob(JobExecutionContext context,final String jobId, final String jobName) {
		log.debug("job shutdown");
		try {
			QuartzManager.removeJob(jobName);// 备份异常时关闭任务
			TaskService taskService = SpringContextHolder.getBean(TaskService.class);
			taskService.changeStatus(jobId, QuartzConstant.TASK_STATUS.STOP);
		} catch (Exception e) {
			log.error("shutdownJob error " + e.getMessage());
		}
	}
	
	public void exceptionJob(JobExecutionContext context,final String jobId, final String jobName,final Throwable throwable){
		log.debug("job exception");
		try {
			QuartzManager.removeJob(jobName);// 备份异常时关闭任务
			TaskService taskService = SpringContextHolder.getBean(TaskService.class);
			taskService.changeStatus(jobId, QuartzConstant.TASK_STATUS.EXCEPTION);
		} catch (Exception e) {
			log.error("shutdownJob error " + e.getMessage());
		}
		final String notifications = Global.getConfig("job.failure.notification.email.addresses");
		if(StringUtils.isNotBlank(notifications)) {
			StringTokenizer st = new StringTokenizer(notifications,",");
			while(st.hasMoreElements()) {
				final String address = st.nextToken();
				new Thread(new Runnable() {
					@Override
					public void run() {
						log.debug("Begin mail notify");
						String title = "Job error Notification";
						String content = "Job ID: " + jobId  + "\r\nJob Name: " +  jobName +"\r\nError details : "+ throwable.getMessage();
						SendMailUtil.sendCommonMail(address, 
								title,content);
					}
				}).start();
			}
		}
	}
	
	public void touchJob(final String jobId) {
		TaskService taskService = SpringContextHolder.getBean(TaskService.class);
		taskService.touchJob(jobId);
	}
	
	protected Map<String, Object> getJobParameter(JobExecutionContext context) {
		JobDataMap dataMap = context.getJobDetail().getJobDataMap();
		Map<String, Object> parameter = (Map<String, Object>) dataMap.get("parameterList"); // 获取参数
		return parameter;
	}
	public abstract void processBns(final String jobId, final String jobName, final Map<String,Object> parameterMap);
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		log.debug("Job start");
		Map<String, Object> parameter = getJobParameter(context);
		String jobId = parameter.get("jobId").toString();
		String jobName = parameter.get("jobName").toString();
		try {
			processBns(jobId, jobName, parameter);
		}catch (Exception e) {
			log.error(e.getMessage(),e);
			exceptionJob(context, jobId, jobName,e);
		}finally {
			touchJob(jobId);
			log.debug("Job end");
		}
		
	}
	
}
