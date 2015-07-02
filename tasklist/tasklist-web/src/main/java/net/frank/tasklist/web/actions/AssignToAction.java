package net.frank.tasklist.web.actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import net.frank.cms.common.CmsCommonConstants;
import net.frank.framework.bo.Account;
import net.frank.framework.bo.Account2Group;
import net.frank.framework.bo.Group;
import net.frank.framework.bo.Resource;
import net.frank.framework.bo.Unit;
import net.frank.framework.security.RootSessionHolder;
import net.frank.framework.security.Session;
import net.frank.framework.service.CmsService;
import net.frank.framework.service.QueryService;
import net.frank.framework.struts.action.BaseAction;
import net.frank.tasklist.CommonConstants;
import net.frank.tasklist.bo.Task;
import net.frank.tasklist.bo.TaskToken;
import net.frank.tasklist.service.ServiceNames;
import net.frank.tasklist.web.forms.AssignToForm;
import net.frank.tasklist.web.vo.AccountView;
import net.frank.tasklist.web.vo.GroupView;

public class AssignToAction extends BaseAction {
	
	private static final String UNIT_GRANT_FOLDER = "grant";
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		AssignToForm _form = (AssignToForm) form;
		QueryService queryService = (QueryService) getBean(ServiceNames.QUERY_SERVICE);
		CmsService cmsService = (CmsService) getBean(ServiceNames.CMS_SERVICE);
		TaskToken currentTaskToken = (TaskToken) queryService.getBo(_form.getResourceId());
		Task currentTask = (Task)queryService.getBo(currentTaskToken.getTask$50002().getId());
		Long accountResId = _form.getAccountResId();
		Unit currentUnit = (Unit) queryService.getBo(currentTask.getUnit$14());
		Session rootSession = RootSessionHolder.getDefaultRootSession();
		Resource unitGrantFolder = cmsService.getResource(
				currentUnit.getContext$3(), UNIT_GRANT_FOLDER,
				rootSession);
		List<AccountView> list = new ArrayList<AccountView>();
		Map<Long,AccountView> accountMap = new HashMap<Long,AccountView>();
		if(unitGrantFolder!=null 
				&& unitGrantFolder.getChildren()!=null 
				&& !unitGrantFolder.getChildren().isEmpty()){
			AccountView av = null;
			for(Iterator<Resource> it=unitGrantFolder.getChildren().iterator();it.hasNext();){
				Resource currRes = it.next();
				currRes = cmsService.getResource(currRes, rootSession);
				if(CommonConstants.TYPE.ACCOUNT_2_GROUP.equals(currRes.getTypeId())){
					Account2Group a2g = (Account2Group)currRes.getObject();
					if(!a2g.getAccount$5().getId().equals(accountResId)){
						if(accountMap.get(a2g.getAccount$5().getId()) == null){
							av = new AccountView();
							av.setAccountResId(a2g.getAccount$5().getId());
							Account ac = (Account)queryService.getBo(a2g.getAccount$5().getId());
							av.setLoginName(ac.getLoginName());
							accountMap.put(a2g.getAccount$5().getId(), av);
							list.add(av);
						}else{
							av = accountMap.get(a2g.getAccount$5().getId());
						}
						Group group = (Group)queryService.getBo(a2g.getGroup$6().getId());
						GroupView gv= new GroupView();
						gv.setGroupName(group.getGroupName());
						av.getGroupList().add(gv);
					}
				}
			}
		}
		request.setAttribute("accountList", list);
		return mapping.findForward(CmsCommonConstants.FORWARD.SUCCESS);
	}
}
