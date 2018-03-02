package net.frank.yangtes.quartz.web.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.quartz.Job;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.frank.yangtes.commons.service.CrudService;
import net.frank.yangtes.quartz.util.QuartzManager;
import net.frank.yangtes.quartz.web.dao.TaskDao;
import net.frank.yangtes.quartz.web.entity.Task;

@Service
@Transactional(readOnly = true)
public class TaskService extends CrudService<TaskDao, Task> {
	
	@Transactional(readOnly = false)
	public void changeStatus(String id, Byte status) {
		dao.changeStatus(id, status);
	}

	public List<Task> findRunningJobs() {
		return dao.findRunningJobs();
	}
	
	@Transactional(readOnly = false)
	public void touchJob(String id) {
		dao.touch(id);
	}
	

	@SuppressWarnings("unchecked")
	public void addJob(String clazzName, String ruleTime, String jobId) {
		Map<String, Object> parameter = new HashMap<String, Object>();
		parameter.put("jobId", jobId);
		parameter.put("jobName", clazzName);
		Class<Job> clazz = null;
		try {
			clazz =(Class<Job>) Class.forName(clazzName);
		}catch(ClassNotFoundException e) {
			log.error(e.getMessage(),e);
		}
		QuartzManager.addJob(clazzName, clazz, ruleTime, parameter);
	}
}
