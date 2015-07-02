package net.frank.tasklist.web.ajaxs;

import java.util.Iterator;

import net.frank.framework.bo.Account;
import net.frank.framework.bo.Account2Group;
import net.frank.framework.bo.Resource;
import net.frank.framework.bo.Unit;
import net.frank.framework.security.RootSessionHolder;
import net.frank.framework.service.CmsService;
import net.frank.framework.service.QueryService;
import net.frank.framework.web.ajax.BaseAjax;
import net.frank.tasklist.CommonConstants;
import net.frank.tasklist.bo.Task;
import net.frank.tasklist.bo.TaskToken;
import net.frank.tasklist.service.TasklistService;
import net.frank.tasklist.service.ServiceNames;

public class TasklistServiceAjax extends BaseAjax {
	public int openTask(Long resourceId) {
		try {
			QueryService queryService = (QueryService) getBean(ServiceNames.QUERY_SERVICE);
			TasklistService taskAction = (TasklistService) getBean(ServiceNames.TASKLIST_SERVICE);
			Task task = (Task) queryService.getBo(resourceId);
			if (!Task.STATUS_DRAFT.equals(task.getStatus())) {
				return -2;
			}
			taskAction.openTask(task, getClientSession());
		} catch (Exception e) {
			return -1;
		}
		return 0;
	}

	public int assignTask(Long resourceId, Long accountResourceId) {
		try {
			QueryService queryService = (QueryService) getBean(ServiceNames.QUERY_SERVICE);
			TasklistService taskAction = (TasklistService) getBean(ServiceNames.TASKLIST_SERVICE);
			CmsService cmsService = (CmsService) getBean(ServiceNames.CMS_SERVICE);
			TaskToken taskToken = (TaskToken) queryService.getBo(resourceId);
			Account next = (Account) queryService.getBo(accountResourceId);
			Task task = (Task) queryService.getBo(taskToken.getTask$50002()
					.getId());
			if (!Task.STATUS_OPEN.equals(task.getStatus())) {
				return -2;
			}
			Unit unit = (Unit) queryService.getBo(task.getUnit$14().getId());
			Resource group =  taskAction.getDefaultGroup(unit);
			Resource grantFolder = cmsService.getResource(unit.getContext$3(),
					CommonConstants.CONTEXT.UNIT.GRANT,RootSessionHolder.getDefaultRootSession());
			boolean hasGroup = false;
			if(grantFolder !=null 
					&& grantFolder.getChildren()!=null
					&& !grantFolder.getChildren().isEmpty()){
				for (Iterator<Resource> it = grantFolder.getChildren().iterator(); it.hasNext();) {
					Resource curr = it.next();
					curr = queryService.getResource(curr.getId());
					if(CommonConstants.TYPE.ACCOUNT_2_GROUP.equals(curr.getTypeId())){
						Account2Group a2g = (Account2Group)queryService.getBo(curr.getId());
						if(a2g.getGroup$6().getId().equals(group.getId())
								&& a2g.getAccount$5().getId().equals(accountResourceId)){
							hasGroup = true;
							break;
						}
							
					}
				}
			}
			if (!hasGroup) {
				return -3;
			}
			
			taskAction.assignTask(taskToken, next, getClientSession());
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
		return 0;
	}

	public int closeTask(Long resourceId) {
		try {
			QueryService queryService = (QueryService) getBean(ServiceNames.QUERY_SERVICE);
			TasklistService taskAction = (TasklistService) getBean("tasklistService");
			TaskToken taskToken = (TaskToken) queryService.getBo(resourceId);
			Task task = (Task) queryService.getBo(taskToken.getTask$50002()
					.getId());
			if (!Task.STATUS_OPEN.equals(task.getStatus())) {
				return -2;
			}
			taskAction.closeTask(taskToken, getClientSession());
		} catch (Exception e) {
			return -1;
		}
		return 0;
	}

	public int archiveTask(Long resourceId) {
		try {
			QueryService queryService = (QueryService) getBean(ServiceNames.QUERY_SERVICE);
			TasklistService taskAction = (TasklistService) getBean("tasklistService");
			Task task = (Task) queryService.getBo(resourceId);
			if (!Task.STATUS_CLOSE.equals(task.getStatus())) {
				return -2;
			}
			taskAction.archiveTask(task, getClientSession());
		} catch (Exception e) {
			return -1;
		}
		return 0;
	}
}