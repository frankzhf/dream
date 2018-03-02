package net.frank.yangtes.quartz.spring;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;

import net.frank.yangtes.quartz.util.QuartzManager;
import net.frank.yangtes.quartz.web.entity.Task;
import net.frank.yangtes.quartz.web.service.TaskService;

public class QuartzContextLoaderListener extends ContextLoaderListener {
	private transient Logger log = LoggerFactory.getLogger(getClass());
	@Override
	public WebApplicationContext initWebApplicationContext(ServletContext servletContext) {
		WebApplicationContext context =  super.initWebApplicationContext(servletContext);
		log.debug("##########QuartzContextLoaderListener initWebApplicationContext############");
		TaskService taskService = context.getBean(TaskService.class);
		List<Task> taskList = taskService.findRunningJobs();
		if(taskList!=null && taskList.size()>0){
			for(Task task:taskList){
				QuartzManager.removeJob(task.getClazzName());//删除任务
				log.debug("#######创建"+task.getClazzName()+"#########任务");
				taskService.addJob(task.getClazzName(),task.getTimeRule(),task.getId());
			}
		}
		return context;
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		log.debug("##########QuartzContextLoaderListener contextDestroyed############");
		WebApplicationContext context = 
				(WebApplicationContext) event.getServletContext().
				getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		TaskService taskService = context.getBean(TaskService.class);
		List<Task> taskList = taskService.findRunningJobs();
		if(taskList!=null && taskList.size()>0){
			for(Task task:taskList){
				log.debug("#######清除"+task.getClazzName()+"#########任务");
				QuartzManager.removeJob(task.getClazzName());//删除任务
			}
		}
		super.contextDestroyed(event);
	}
}
