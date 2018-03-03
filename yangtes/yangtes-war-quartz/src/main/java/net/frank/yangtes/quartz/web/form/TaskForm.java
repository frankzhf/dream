package net.frank.yangtes.quartz.web.form;

import net.frank.yangtes.base.AbstractForm;
import net.frank.yangtes.quartz.web.condition.TaskCondition;
import net.frank.yangtes.quartz.web.entity.Task;

public class TaskForm extends AbstractForm<Task, TaskCondition> {
	public TaskForm() {
		super();
		condition = new TaskCondition();
		this.setCondition(condition);
	}
}
