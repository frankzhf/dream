package net.frank.tasklist.service.impl;

import java.util.Date;
import java.util.UUID;

import net.frank.commons.util.DateUtil;
import net.frank.framework.bo.Account;
import net.frank.framework.bo.Group;
import net.frank.framework.bo.Resource;
import net.frank.framework.bo.Unit;
import net.frank.framework.security.RootSessionHolder;
//import net.frank.framework.dao.BaseJdbcDao;
import net.frank.framework.security.Session;
import net.frank.framework.service.CmsService;
import net.frank.framework.service.QueryService;
import net.frank.framework.service.ResourceFilter;
import net.frank.framework.service.ResourceService;
import net.frank.framework.service.impl.BaseServiceImpl;
import net.frank.tasklist.CommonConstants;
import net.frank.tasklist.bo.Task;
import net.frank.tasklist.bo.TaskToken;
import net.frank.tasklist.service.TasklistService;

public class TasklistServiceImpl extends BaseServiceImpl implements
		TasklistService {
	private static final String ROOT_UNIT_CODE = "3410";

	private static final String DEFAULT_GROUP_PATH_ROOT_UNIT = "/unit/.3410/group/Staff";

	private static final String DEFAULT_USER_GROUP_SUFFEX = "-User";

	private static final String TASK_TEMPLATE_PATH = "/contextTemplate/task";

	private static final String TASK_TOKEN_TEMPLATE_PATH = "/contextTemplate/taskToken";

	private static final String TASK_CONTEXT_SUFFIX = "_CONTEXT";

	private static final String DEFAULT_DATE_FORMAT = "_yyyyMMdd_HHmmss";

	private ResourceService resourceService;

	private QueryService queryService;

	private CmsService cmsService;

	public void setQueryService(QueryService queryService) {
		this.queryService = queryService;
	}

	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	public void setCmsService(CmsService cmsService) {
		this.cmsService = cmsService;
	}

	@Override
	public Task createDraft(Task task, Session session) {
		Group currentGroup = session.getCurrentGroup();
		log.debug("Current Group:" + currentGroup.getGroupName());
		Unit currentUnit = (Unit) queryService.getBo(task.getUnit$14().getId());
		log.debug("Current Unit:" + currentUnit.getUnitName());
		final Resource projectGroup = getDefaultGroup(currentUnit);
		//session.setCurrentGroup(projectGroup);
		StringBuffer myDraftFolder = new StringBuffer(
				CommonConstants.SHORT_STRING_BUFFER_LENGTH);
		myDraftFolder.append(CommonConstants.PATH.HOME)
				.append(CommonConstants.PATH_SYMBOL)
				.append(CommonConstants.POINT).append(session.getLoginName())
				.append(CommonConstants.PATH_SYMBOL)
				.append(CommonConstants.USER_WORKSPACE_ROOT_ALIAS)
				.append(CommonConstants.PATH_SYMBOL)
				.append(CommonConstants.USER_WORKSPACE_DRAFT);
		Resource src = queryService.getResourceAsPath(TASK_TEMPLATE_PATH);
		Resource target = queryService.getResourceAsPath(myDraftFolder
				.toString());
		resourceService.cloneResourceWithRecursive(src, target, session, new ResourceFilter() {
			@Override
			public boolean filter(Resource resource) {
				resource.setOwnGroupResourceId(projectGroup.getId());
				resource.setCurrentGroupPermission(CommonConstants.PERMISSION.READ);
				return true;
			}
		} ,
				task.getTaskSummary() + TASK_CONTEXT_SUFFIX);
		String currentTaskContextPath = myDraftFolder
				.append(CommonConstants.PATH_SYMBOL)
				.append(task.getTaskSummary() + TASK_CONTEXT_SUFFIX).toString();
		Resource currentTaskContext = queryService
				.getResourceAsPath(currentTaskContextPath);
		task.setStatus(Task.STATUS_DRAFT);
		task.setContext$3(currentTaskContext);
		task.setReOpen(Boolean.FALSE);
		task.setRefTask$50002(null);
		task.setParentTask$50002(null);
		StringBuffer sb = new StringBuffer(
				CommonConstants.SHORT_STRING_BUFFER_LENGTH);
		sb.append(task.getTaskSummary()).append(DRAFT_SUFFIX);
		task.getResource().setAlias(sb.toString());
		resourceService.saveOrUpdateBo(task, session);
		//session.setCurrentGroup(currentGroup);
		return task;
	}

	@Override
	public void openTask(Task task, Session session) {
		// get group
		//Group currentGroup = session.getCurrentGroup();
		// get Unit
		Unit currentUnit = (Unit) queryService.getBo(task.getUnit$14().getId());
		log.debug("Current Unit:" + currentUnit.getUnitName());
		final Resource projectGroup = getDefaultGroup(currentUnit);
		// move task from draft to ownTask
		StringBuffer ownTaskFolerPath = new StringBuffer(
				CommonConstants.SHORT_STRING_BUFFER_LENGTH);
		ownTaskFolerPath.append(CommonConstants.PATH.HOME)
				.append(CommonConstants.PATH_SYMBOL)
				.append(CommonConstants.POINT).append(session.getLoginName())
				.append(CommonConstants.PATH_SYMBOL)
				.append(CommonConstants.USER_WORKSPACE_ROOT_ALIAS)
				.append(CommonConstants.PATH_SYMBOL)
				.append(CommonConstants.USER_WORKSPACE_MY_TASK);
		Resource ownTaskFoler = queryService.getResourceAsPath(ownTaskFolerPath
				.toString());
		String uuid = UUID.randomUUID().toString();
		String taskId = currentUnit.getUnitCode() + "-"
				+ uuid.substring(uuid.length() - 5);
		task.setTaskId(taskId);
		task.setStartDate(new Date());
		task.setStatus(Task.STATUS_OPEN);
		task.getResource().setParentId(ownTaskFoler.getId());
		task.getResource().setAlias(taskId);
		if (projectGroup != null) {
			task.getResource().setOwnGroupResourceId(projectGroup.getId());
			task.getResource().setCurrentGroupPermission(
					CommonConstants.PERMISSION.READ);
		}
		resourceService.saveOrUpdateBo(task, session);
		Resource taskContext = queryService.getResource(task.getContext$3()
				.getId());
		taskContext.setParentId(ownTaskFoler.getId());
		taskContext.setAlias(taskId + TASK_CONTEXT_SUFFIX);
		resourceService.saveOrUpdateResource(taskContext, session);
		// Create TaskToken
		Resource src = queryService.getResourceAsPath(TASK_TOKEN_TEMPLATE_PATH);
		StringBuffer parentPath = new StringBuffer(
				CommonConstants.SHORT_STRING_BUFFER_LENGTH);
		parentPath.append(CommonConstants.PATH.HOME)
				.append(CommonConstants.PATH_SYMBOL)
				.append(CommonConstants.POINT).append(session.getLoginName())
				.append(CommonConstants.PATH_SYMBOL)
				.append(CommonConstants.USER_WORKSPACE_ROOT_ALIAS)
				.append(CommonConstants.PATH_SYMBOL)
				.append(CommonConstants.USER_WORKSPACE_PENDING_TASK);
		Resource target = queryService.getResourceAsPath(parentPath.toString());
		resourceService.cloneResourceWithRecursive(src, target, session,
				new ResourceFilter() {
					@Override
					public boolean filter(Resource resource) {
						resource.setOwnGroupResourceId(projectGroup.getId());
						resource.setCurrentGroupPermission(CommonConstants.PERMISSION.READ);
						return true;
					}
				}, taskId + TASK_CONTEXT_SUFFIX);
		parentPath.append(CommonConstants.PATH_SYMBOL).append(taskId)
				.append(TASK_CONTEXT_SUFFIX);
		Resource taskTokenContextRes = queryService
				.getResourceAsPath(parentPath.toString());
		taskTokenContextRes.setAlias(taskId
				+ TASK_CONTEXT_SUFFIX
				+ DateUtil.toString(taskTokenContextRes.getCreatedDt(),
						DEFAULT_DATE_FORMAT));
		resourceService.saveOrUpdateResource(taskTokenContextRes, session);
		Resource taskTokenRes = new Resource();
		taskTokenRes.setAlias(taskId
				+ DateUtil.toString(taskTokenContextRes.getCreatedDt(),
						DEFAULT_DATE_FORMAT));
		taskTokenRes.setParentId(target.getId());
		taskTokenRes.setTypeId(CommonConstants.TYPE.TASKTOKEN);
		taskTokenRes.setChildren(null);
		taskTokenRes
				.setCurrentAccountPermission(CommonConstants.PERMISSION.ALL);
		taskTokenRes.setCurrentGroupPermission(CommonConstants.PERMISSION.READ);
		taskTokenRes.setOthersPermission(CommonConstants.PERMISSION.NONE);
		taskTokenRes.setOwnResourceId(session.getAccount().getResource()
				.getId());
		taskTokenRes.setOwnGroupResourceId(session.getCurrentGroup()
				.getResource().getId());
		taskTokenRes.setActive(Boolean.TRUE);
		TaskToken taskToken = new TaskToken();
		taskToken.setResource(taskTokenRes);
		taskToken.setParent$50003(null);
		taskToken.setTask$50002(task.getResource());
		taskToken.setAction(TaskToken.ACTION_OPEN);
		taskToken.setAccount$5(session.getAccount().getResource());
		taskToken.setContext$3(taskTokenContextRes);
		resourceService.saveOrUpdateBo(taskToken, session);
		//session.setCurrentGroup(currentGroup);
	}

	@Override
	public void closeTask(TaskToken taskToken, Session session) {
		// get group
		Group currentGroup = session.getCurrentGroup();
		Task task = (Task) queryService.getBo(taskToken.getTask$50002().getId());
		// get Unit
		Unit currentUnit = (Unit) queryService.getBo(task.getUnit$14().getId());
		log.debug("Current Unit:" + currentUnit.getUnitName());
		Group projectGroup = (Group) queryService.getBo(currentUnit
				.getGroup$6().getId());
		session.setCurrentGroup(projectGroup);
		Resource taskContext = task.getContext$3();
		Resource tokens = queryService.getResourceAsPath(taskContext,
				CommonConstants.CONTEXT.TASK.TOKEN);
		Resource taskTokenResource = taskToken.getResource();
		Resource taskTokenContextResource = taskToken.getContext$3();
		taskTokenResource.setParentId(tokens.getId());
		taskTokenContextResource.setParentId(tokens.getId());
		resourceService.saveOrUpdateResource(taskTokenResource, session);
		resourceService.saveOrUpdateResource(taskTokenContextResource, session);
		task.setStatus(Task.STATUS_CLOSE);
		task.setEndDate(new Date());
		resourceService.saveOrUpdateBo(task, session);
		session.setCurrentGroup(currentGroup);
	}

	@Override
	public void assignTask(TaskToken taskToken, Account next, Session session) {
		// get group
		Group currentGroup = session.getCurrentGroup();
		Task task = (Task) queryService.getBo(taskToken.getTask$50002().getId());
		// get Unit
		Unit currentUnit = (Unit) queryService.getBo(task.getUnit$14().getId());
		log.debug("Current Unit:" + currentUnit.getUnitName());
		Group projectGroup = (Group) queryService.getBo(currentUnit
				.getGroup$6().getId());
		session.setCurrentGroup(projectGroup);
		Resource taskContext = task.getContext$3();
		Resource tokens = queryService.getResourceAsPath(taskContext,
				CommonConstants.CONTEXT.TASK.TOKEN);
		Resource taskTokenResource = taskToken.getResource();
		Resource taskTokenContextResource = taskToken.getContext$3();
		taskTokenResource.setParentId(tokens.getId());
		taskTokenContextResource.setParentId(tokens.getId());
		resourceService.saveOrUpdateResource(taskTokenResource, session);
		resourceService.saveOrUpdateResource(taskTokenContextResource, session);
		Resource accountContext = next.getHome$3();
		Resource tasklistFolder = queryService.getResourceAsPath(accountContext,
				CommonConstants.USER_WORKSPACE_ROOT_ALIAS);
		Resource myTask = queryService.getResourceAsPath(tasklistFolder,
				CommonConstants.USER_WORKSPACE_PENDING_TASK);
		// Create TaskToken context
		Resource src = queryService.getResourceAsPath(TASK_TOKEN_TEMPLATE_PATH);
		Account currentAccount = session.getAccount();
		session.setAccount(next);
		resourceService.cloneResourceWithRecursive(src, myTask, session, null,
				task.getTaskId() + TASK_CONTEXT_SUFFIX);
		Resource nextTaskTokenContext = queryService.getResourceAsPath(myTask,
				task.getTaskId() + TASK_CONTEXT_SUFFIX);
		nextTaskTokenContext.setAlias(task.getTaskId()
				+ TASK_CONTEXT_SUFFIX
				+ DateUtil.toString(nextTaskTokenContext.getCreatedDt(),
						DEFAULT_DATE_FORMAT));
		resourceService.saveOrUpdateResource(nextTaskTokenContext, session);
		// Create TaskToken
		Resource taskTokenNextRes = new Resource();
		taskTokenNextRes.setAlias(task.getTaskId()
				+ DateUtil.toString(nextTaskTokenContext.getCreatedDt(),
						DEFAULT_DATE_FORMAT));
		taskTokenNextRes.setParentId(myTask.getId());
		taskTokenNextRes.setTypeId(CommonConstants.TYPE.TASKTOKEN);
		taskTokenNextRes.setChildren(null);
		taskTokenNextRes
				.setCurrentAccountPermission(CommonConstants.PERMISSION.ALL);
		taskTokenNextRes
				.setCurrentGroupPermission(CommonConstants.PERMISSION.READ);
		taskTokenNextRes.setOthersPermission(CommonConstants.PERMISSION.NONE);
		taskTokenNextRes.setOwnResourceId(session.getAccount().getResource()
				.getId());
		taskTokenNextRes.setOwnGroupResourceId(session.getCurrentGroup()
				.getResource().getId());
		taskTokenNextRes.setActive(Boolean.TRUE);
		TaskToken taskTokenNext = new TaskToken();
		taskTokenNext.setResource(taskTokenNextRes);
		taskTokenNext.setParent$50003(null);
		taskTokenNext.setTask$50002(task.getResource());
		taskTokenNext.setAction(TaskToken.ACTION_ASSIGN);
		taskTokenNext.setAccount$5(next.getResource());
		taskTokenNext.setContext$3(nextTaskTokenContext);
		resourceService.saveOrUpdateBo(taskTokenNext, session);
		session.setAccount(currentAccount);
		session.setCurrentGroup(currentGroup);
	}

	@Override
	public void forkTask(TaskToken taskToken, Session session) {
		// TODO Auto-generated method stub

	}

	@Override
	public void archiveTask(Task task, Session session) {
		// get group
		Group currentGroup = session.getCurrentGroup();
		// get Unit
		Unit currentUnit = (Unit) queryService.getBo(task.getUnit$14().getId());
		log.debug("Current Unit:" + currentUnit.getUnitName());
		Group projectGroup = (Group) queryService.getBo(currentUnit
				.getGroup$6().getId());
		session.setCurrentGroup(projectGroup);
		Resource taskResource = task.getResource();
		Resource taskContextResource = task.getContext$3();
		Resource unitContextRes = currentUnit.getContext$3();
		Resource tasks = queryService.getResourceAsPath(unitContextRes,
				CommonConstants.CONTEXT.UNIT.TASKLIST);
		taskResource.setParentId(tasks.getId());
		taskContextResource.setParentId(tasks.getId());
		resourceService.saveOrUpdateResource(taskResource, session);
		resourceService.saveOrUpdateResource(taskContextResource, session);
		session.setCurrentGroup(currentGroup);
	}

	@Override
	public void analysesTask(Task task, Session session) {
		// TODO Auto-generated method stub

	}

	@Override
	public Resource getDefaultGroup(Unit unit) {
		if (ROOT_UNIT_CODE.equals(unit.getUnitCode())) {
			return queryService.getResourceAsPath(DEFAULT_GROUP_PATH_ROOT_UNIT);
		} else {
			Resource groupFolder = cmsService.getResource(unit.getContext$3(),
					CommonConstants.CONTEXT.UNIT.GROUP,
					RootSessionHolder.getDefaultRootSession());
			if (groupFolder != null && groupFolder.getChildren() != null
					&& !groupFolder.getChildren().isEmpty()) {
				Resource groupResource = null;
				for (int i = 0; i < groupFolder.getChildren().size(); i++) {
					groupResource = queryService.getResource(groupFolder
							.getChildren().get(i).getId());
					if (groupResource.getAlias().endsWith(
							DEFAULT_USER_GROUP_SUFFEX)) {
						return groupResource;
					}
				}
				groupResource = queryService.getResource(groupFolder
						.getChildren().get(0).getId());
				return groupResource;

			}
			return null;
		}
	}

}
