package net.frank.framework.struts.taglib;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;

import org.apache.struts.taglib.TagUtils;

import net.frank.framework.bo.MenuItem;
import net.frank.framework.bo.Resource;
import net.frank.framework.web.security.AuthenticatorHolder;
import net.frank.framework.web.security.ClientSession;
import net.frank.framework.writer.JspResponseWriter;

public class MenuScriptTag extends CommonTag{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1695843743720240308L;

	public int doStartTag() throws JspException {
		JspResponseWriter out = new JspResponseWriter();
		ClientSession cs = AuthenticatorHolder.getClientSession();
		if (menuRepository.getChildren() != null
				&& !menuRepository.getChildren().isEmpty()) {
			for (Iterator<Resource> it = menuRepository.getChildren().iterator(); it
					.hasNext();) {
				Resource menu = it.next();
				if (checkRunPermission(menu, cs)) {
					String menuName = ((MenuItem) menu.getObject()).getTitle();
					String _menuName = menuName.replaceAll(DOT, UL);
					out.text("\t\t$('#");
					out.text(PREFFIX);
					out.text(_menuName);
					out.text("').menubutton({\n\t\t\t");
					out.text("menu: '#");
					out.text(PREFFIX);
					out.text(_menuName);
					out.text(SUFFIX);
					out.text("'\n\t\t});\n");
					if(menu.getChildren()!=null){
						for (Iterator<Resource> itt = menu.getChildren().iterator(); itt
								.hasNext();) {
							Resource child = itt.next();
							if (checkRunPermission(child, cs)) {
								MenuItem menuItem = (MenuItem) child.getObject();
								String menuItemName = menuItem.getTitle();
								String _menuItemName = menuItemName.replaceAll(DOT, UL);
								String message = TagUtils.getInstance().message(pageContext,
									bundle, localeKey, menuItemName, null);
								out.text("\t\t$('#");
								out.text(PREFFIX);
								out.text(_menuItemName);
								out.text("').click(function(){");
								out.text("\t\t\ttop.openUrl('");
								if(message == null || message.length()==0){
									out.text(LEFT_BRACKETS);
									out.text(menuItemName);
									out.text(RIGHT_BRACKETS);
								}else{
									out.text(message);
								}
								out.text("','");
								out.text(((HttpServletRequest)pageContext.getRequest()).getContextPath());
								out.text(menuItem.getPath());
								out.text("')\n");
								out.text("});\n");
							}
						}
					}
				}
			}
		}
		try {
			pageContext.getOut().print(out.getBuffer());
		} catch (IOException e) {
			throw new JspException(e.getMessage());
		}
		return EVAL_PAGE;
	}
}


/**
$('#btnGrpOthers').menubutton({
			menu: '#btnGrpOthersDetails'
		});
		
		$('#btnMyDocument').click(function(){
			top.openUrl('<bean:message key="common.layout.title.my.files" />','${pageContext.request.contextPath}/repository/myFiles.do');
		});

**/