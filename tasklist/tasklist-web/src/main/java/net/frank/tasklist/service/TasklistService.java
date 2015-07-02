package net.frank.tasklist.service;

import net.frank.framework.bo.Account;
import net.frank.framework.bo.Resource;
import net.frank.framework.bo.Unit;
import net.frank.framework.security.Session;
import net.frank.tasklist.bo.Task;
import net.frank.tasklist.bo.TaskToken;

public interface TasklistService {
	public String DRAFT_SUFFIX = " - Draft";
	
	public Task createDraft(Task task,Session session);
	
	public void openTask(Task task,Session session);
	
	public void closeTask(TaskToken taskToken,Session session);
	
	public void assignTask(TaskToken taskToken,Account next,Session session);
	
	public void forkTask(TaskToken taskToken,Session session);
	
	public void archiveTask(Task task,Session session);
	
	public void analysesTask(Task task,Session session);
	
	public Resource getDefaultGroup(Unit unit);
}
