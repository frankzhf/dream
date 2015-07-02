package net.frank.framework.struts.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.frank.framework.app.DefaultApp;
import net.frank.framework.bo.BaseEntity;
import net.frank.framework.bo.Type;
import net.frank.framework.struts.StrutsConstants;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class CommonTreeAction extends BaseAction {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DefaultApp defaultApp = (DefaultApp)getBean("defaultApp");
		Map<Long, Type> typeContent = defaultApp.getTypeMap();
		Map<Long, BaseEntity> typeClassMap = new HashMap<Long, BaseEntity>();
		List<Type> typeContentList = new ArrayList<Type>();
		for (Iterator<Long> it = typeContent.keySet().iterator(); it.hasNext();) {
			Long resourceId = it.next();
			typeContentList.add(typeContent.get(resourceId));
			typeClassMap.put(
					resourceId,
					(BaseEntity) Class.forName(
							typeContent.get(resourceId).getEntityClassName())
							.newInstance());
		}
		request.setAttribute("typeContentList", typeContentList);
		request.setAttribute("typeClassMap", typeClassMap); 
		return mapping.findForward(StrutsConstants.FORWARD.SUCCESS);
	}
}
