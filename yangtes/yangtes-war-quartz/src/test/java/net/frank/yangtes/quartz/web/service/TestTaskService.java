package net.frank.yangtes.quartz.web.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import net.frank.yangtes.modules.sys.entity.User;
import net.frank.yangtes.quartz.QuartzConstant;
import net.frank.yangtes.quartz.web.entity.Task;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring-context.xml" })
public class TestTaskService {
	
	private Logger log = LoggerFactory.getLogger(getClass());
	private static User user = new User();
	static {
		user.setId("1");
	}
	
	@Autowired
	private TaskService taskService;
	
	
	@Test
	public void testInit() {
		log.debug("Init success");
	}
	
	@Test
	public void testCurdTask() throws Exception {
		Task task = new Task();
		task.setBranchId("-1");
		task.setClazzName("net.frank.yangtes.quartz.job.demo.SampleOneJob");
		task.setDesc("测试例子1");
		task.setRuleDesc("每五分钟执行一次");
		task.setStatus(QuartzConstant.TASK_STATUS.STOP);
		task.setTimeRule("0 */5 * * * ?");
		task.setCreateBy(user);
		task.setUpdateBy(user);
		
		taskService.save(task);
		log.debug("新增");
		Thread.sleep(5000);
		
		task.setStatus(QuartzConstant.TASK_STATUS.RUNNING);
		taskService.save(task);
		log.debug("更新");
		Thread.sleep(5000);
		taskService.touchJob(task.getId());
		log.debug("touch");
		Thread.sleep(5000);
		taskService.delete(task);
		log.debug("删除");
		
	}
	
}
