package net.frank.framework.struts.taglib;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.jsp.JspException;

import net.frank.framework.bo.Resource;
import net.frank.framework.bo.MenuItem;
import net.frank.framework.web.security.AuthenticatorHolder;
import net.frank.framework.web.security.ClientSession;
import net.frank.framework.writer.JspResponseWriter;
import net.frank.framework.xml.Xhtml;
import org.apache.struts.taglib.TagUtils;

public class MenuTag extends CommonTag {

	/**
	 * 
	 */
	private static final long serialVersionUID = -772254084272116763L;

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
					String _menuName = menuName.replaceAll(DOT, _);
					out.startElement(Xhtml.Tag.DIV);
					out.attribute(Xhtml.Attr.ID, PREFFIX + _menuName + SUFFIX);
					out.attribute(Xhtml.Attr.STYLE, DEFAULT_MENU_WIDTH);
					for (Iterator<Resource> itt = menu.getChildren().iterator(); itt
							.hasNext();) {
						Resource child = itt.next();
						if (checkRunPermission(child, cs)) {
							String menuItemName = ((MenuItem) child.getObject())
									.getTitle();
							String _menuItemName = menuItemName.replaceAll(DOT, _);
							out.setPrettyPrinting(false);
							out.startElement(Xhtml.Tag.DIV);
							out.attribute(Xhtml.Attr.ID, PREFFIX + _menuItemName);
							String message = TagUtils.getInstance().message(
									pageContext, bundle, localeKey, menuItemName,
									null);
							if (message == null || message.length() == 0) {
								out.text(LEFT_BRACKETS);
								out.text(menuItemName);
								out.text(RIGHT_BRACKETS);
							} else {
								out.text(message);
							}
							out.endElement(Xhtml.Tag.DIV);
							out.setPrettyPrinting(true);
						}
					}
					out.endElement(Xhtml.Tag.DIV);
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

	/**
	 * 
	 * 
	 <div id="btnGrpOthersDetails" style="width:80px"> <div
	 * id="btnLogout"><bean:message key='common.header.logout' /></div> <div
	 * id="btnAbout"><bean:message key='common.header.about' /></div> </div>
	 * 
	 * @param args
	 */

}
