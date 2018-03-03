package net.frank.yangtes.quartz.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import net.frank.yangtes.commons.utils.StringUtils;
import net.frank.yangtes.commons.web.BaseController;
import net.frank.yangtes.quartz.QuartzConstant;
import net.frank.yangtes.quartz.util.QuartzManager;
import net.frank.yangtes.quartz.web.entity.Task;
import net.frank.yangtes.quartz.web.form.TaskForm;
import net.frank.yangtes.quartz.web.service.TaskService;

@Controller
@RequestMapping(value = "${adminPath}/quartz")
public class TaskController extends BaseController {
	@Autowired
	private TaskService taskService;
	@RequestMapping(value = {"list", ""})
	public String list(TaskForm form,
			Model model) {
		log.debug("Input Param[form] ->" +form);
		if (form == null) {
			form = new TaskForm();
		}
		form.getCondition().setPage(taskService.findPage(form.getCondition().getPage(),new Task()));
		model.addAttribute("form",form);
		return "modules/sys/taskList";
	}
	
	@RequestMapping(value = "form")
	public String form(TaskForm form, Model model) {
		log.debug("Input Param[form]  -> " + form);
		if(form.getDataEntity()!=null){
			String dateEntityId = form.getDataEntity().getId();
			log.debug("edit entity's Id is " + dateEntityId);
			form.setDataEntity(taskService.get(dateEntityId));
		}else{
			form.setDataEntity(new Task());
		}
		model.addAttribute("form", form);
		return "modules/sys/taskForm";
	}
	
	@RequestMapping(value = "save")
	public String save(TaskForm form, Model model) {
		log.debug("Input Param[form]  -> " + form);
		if (!beanValidator(model, form.getDataEntity())) {
			return form(form, model);
		}
		form.getDataEntity().setStatus(QuartzConstant.TASK_STATUS.RUNNING);
		form.getDataEntity().setBranchId("-1");
		taskService.save(form.getDataEntity());
		String taskName = form.getDataEntity().getClazzName();
		String timeRule  = form.getDataEntity().getTimeRule();
		try {
			if(StringUtils.isNotEmpty(form.getDataEntity().getId())){
				QuartzManager.removeJob(taskName);
				log.info("移除"+taskName+"任务成功");
			}
			taskService.addJob(taskName,timeRule,form.getDataEntity().getId());
			log.info("添加"+taskName+"任务成功");
		} catch (Exception e) {
			log.error("ReflectHelper.getClass(taskName) error "+e.getMessage());
		}
		addMessage(model, "保存成功");
		return list(form,model);
	}
	
	@RequestMapping(value = "status")
	public String changeStatus(TaskForm form, Model model) {
		log.debug("Input Param[form]  -> " + form);
		Task task = taskService.get(form.getDataEntity().getId());
		if(QuartzConstant.TASK_STATUS.RUNNING == task.getStatus()){
			QuartzManager.removeJob(task.getClazzName());//删除任务
			taskService.changeStatus(task.getId(),QuartzConstant.TASK_STATUS.STOP);
		}else{
			String taskName = task.getClazzName();
			String timeRule  = task.getTimeRule();
			try {
				taskService.addJob(taskName,timeRule,task.getId());
				taskService.changeStatus(task.getId(),QuartzConstant.TASK_STATUS.RUNNING);
			} catch (Exception e) {
				log.error("ReflectHelper.getClass(taskName) error "+e.getMessage());
			}
		}
		addMessage(model, "改变状态成功");
		return list(form,model);
	}
}
