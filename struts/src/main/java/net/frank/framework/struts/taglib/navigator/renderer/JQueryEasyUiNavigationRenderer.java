package net.frank.framework.struts.taglib.navigator.renderer;

import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;

import org.apache.struts.Globals;
import org.apache.struts.taglib.TagUtils;



import net.frank.commons.CommonConstants;
import net.frank.framework.navigation.Menu;
import net.frank.framework.navigation.MenuRepository;
import net.frank.framework.web.taglib.navigator.renderer.NavigationRenderer;

public class JQueryEasyUiNavigationRenderer extends NavigationRenderer {
	
	private PageContext pageContext;
	private MenuRepository repository;
	
	protected String localeKey = Globals.LOCALE_KEY;

	@Override
	public String renderMenu(PageContext context, MenuRepository rep) {
		repository = rep;
		setPageContext(context);
		StringBuffer buf = new StringBuffer();
		buildHeader(buf);
		buildBody(buf);
		buildFooter(buf);
		return buf.toString();
	}

	private void buildBody(StringBuffer buf) {
		List<Menu> topMenus = repository.getTopMenus();
		for (Iterator<Menu> iter = topMenus.iterator(); iter.hasNext();) {
			Menu menu = iter.next();
			buf.append("<div title=\"");
			buf.append(processMessage(menu.getTitle()));
			buf.append("\" style=\"overflow:auto;padding:10px;\">");
			for (Iterator<Menu> iterator = menu.getChildren().iterator(); iterator
					.hasNext();) {
				Menu subMenu = iterator.next();
				String title = processMessage(subMenu.getTitle());
				buf.append("<p><a href=\"#\" onclick=\"openUrl('");
				buf.append(title).append("','");
				buf.append(subMenu.getPath()).append("')\">");
				buf.append(title);
				buf.append("</a></p>");
			}
			buf.append("</div>");
		}
	}
	
	private String processMessage(String key) {
		String returnValue = CommonConstants.EMPTY_STRING;
		try {
			returnValue = TagUtils.getInstance().message(pageContext, null,
					localeKey, key);
		} catch (JspException e) {
		}
		return returnValue;
	}
	

	@Override
	public void destroy() {

	}

	protected PageContext getPageContext() {
		return pageContext;
	}

	protected void setPageContext(PageContext context) {
		pageContext = context;
	}

	protected HttpServletRequest getRequest() {
		return (HttpServletRequest) getPageContext().getRequest();
	}

	protected HttpServletResponse getResponse() {
		return (HttpServletResponse) getPageContext().getResponse();
	}

	protected ServletContext getContext() {
		return getPageContext().getServletContext();
	}
/**
	private boolean permissionFilter(String permission) {
		if(ALL_PERMISSION.equals(permission)){
			return true;
		}
		ClientSession cs = AuthenticatorHolder.getClientSession();
		Map<String, Function> currentUserFunctionMap = cs.getFunctionMap();
		if (cs.getAccount().getStaff$17() == null
				&& currentUserFunctionMap.isEmpty()) {
			return true;
		} else {
			return currentUserFunctionMap.get(permission) != null;
		}
	}
**/
	private void buildHeader(StringBuffer buf) {
		buf.append("<div id=\"menu\" class=\"easyui-accordion\">");
	}

	private void buildFooter(StringBuffer buf) {
		buf.append("</div>");
	}

}

/**
 * 
 <div id="menu" class="easyui-accordion"> <div title="Examination System"
 * style="overflow:auto;padding:10px;">
 * <p>
 * <a href="#" onclick=
 * "open1('Create Question','/exam-online//questions/createQuestionForm.do')"
 * >Create Question</a>
 * </p>
 * <p>
 * <a href="#" onclick=
 * "open1('Maintain Question','/exam-online//questions/searchQuestionForm.do')"
 * >Maintain Question</a>
 * </p>
 * <p>
 * <a href="#" onclick=
 * "open1('Create Paper Config','/exam-online//paper/createPaperConfigForm.do')"
 * >Create Paper Config</a>
 * </p>
 * <p>
 * <a href="#" onclick=
 * "open1('Generate Paper Config','/exam-online//temppaper/searchExaminationPaperForm.do')"
 * >Generate Paper Config</a>
 * </p>
 * <p>
 * <a href="#" onclick=
 * "open1('View Examination','/exam-online//exam/viewExaminationForm.do')">View
 * Examination</a>
 * </p>
 * <p>
 * <a href="#" onclick=
 * "open1('Mark Examination','/exam-online//exam/markExaminationForm.do')">Mark
 * Examination</a>
 * </p>
 * <p>
 * <a href="#" onclick=
 * "open1('Upload Question','/exam-online//upload/uploadQuestionForm.do')"
 * >Upload Question</a>
 * </p>
 * </div> </div>
 * 
 * <div id="menu" class="easyui-accordion"> <div title="Maintain System"
 * style="overflow:auto;padding:10px;">
 * <p>
 * <a href="#" onclick=
 * "open1('Maintain Role','/exam-online//authority/maintainRoleForm.do')"
 * >Maintain Role</a>
 * </p>
 * <p>
 * <a href="#" onclick=
 * "open1('Maintain Group','/exam-online//authority/maintainGroupForm.do')"
 * >Maintain Group</a>
 * </p>
 * <p>
 * <a href="#" onclick=
 * "open1('Maintain User','/exam-online//maintainUser/maintainUserForm.do')"
 * >Maintain User</a>
 * </p>
 * <p>
 * <a href="#" onclick=
 * "open1('Maintain Examinate','/exam-online//maintainUser/maintainExaminateForm.do')"
 * >Maintain Examinate</a>
 * </p>
 * <p>
 * <a href="#" onclick=
 * "open1('Create User','/exam-online//maintainUser/createUserForm.do')">Create
 * User</a>
 * </p>
 * <p>
 * <a href="#" onclick=
 * "open1('Create Examinate','/exam-online//maintainUser/createExaminateForm.do')"
 * >Create Examinate</a>
 * </p>
 * <p>
 * <a href="#" onclick=
 * "open1('Create User From LDAP','/exam-online//maintainUser/createUserFromLDAPForm.do')"
 * >Create User From LDAP</a>
 * </p>
 * </div> </div>
 */
