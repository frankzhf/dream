package net.frank.cms.web.core.forms;

import java.util.ArrayList;
import java.util.List;

import net.frank.cms.web.core.forms.vo.SessionView;

import org.apache.struts.action.ActionForm;

public class ListSessionForm extends ActionForm {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7505877228292493648L;
	private List<SessionView> sessionViewList = new ArrayList<SessionView>();

	public List<SessionView> getSessionViewList() {
		return sessionViewList;
	}

	public void setSessionViewList(List<SessionView> sessionViewList) {
		this.sessionViewList = sessionViewList;
	}
	
	public SessionView getSessionView(int index){
		while(sessionViewList.size()<=index){
			sessionViewList.add(new SessionView());
		}
		return sessionViewList.get(index);
	}
	
	public void setSessionView(int index,SessionView sessionView){
		while(sessionViewList.size()<=index){
			sessionViewList.add(new SessionView());
		}
		sessionViewList.set(index, sessionView);
	}
}
