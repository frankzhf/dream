package net.frank.framework.struts.taglib;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.jsp.JspException;

import net.frank.framework.bo.MenuItem;
import net.frank.framework.bo.Resource;
import net.frank.framework.web.security.AuthenticatorHolder;
import net.frank.framework.web.security.ClientSession;
import net.frank.framework.writer.JspResponseWriter;
import net.frank.framework.xml.Xhtml;

import org.apache.struts.taglib.TagUtils;

public class MenuLinkTag extends CommonTag {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3056669144757188469L;

	public int doStartTag() throws JspException {
		JspResponseWriter out = new JspResponseWriter(false);
		ClientSession cs = AuthenticatorHolder.getClientSession();
		if (menuRepository.getChildren() != null
				&& !menuRepository.getChildren().isEmpty()) {
			for (Iterator<Resource> it = menuRepository.getChildren()
					.iterator(); it.hasNext();) {
				Resource menu = it.next();
				if (checkRunPermission(menu, cs)) {
					String menuName = ((MenuItem) menu.getObject()).getTitle();
					String _menuName = menuName.replaceAll(DOT, UL);
					out.startElement(Xhtml.Tag.TD);
					out.setPrettyPrinting(false);
					out.startElement(Xhtml.Tag.A);
					out.attribute(Xhtml.Attr.ID, PREFFIX + _menuName);
					out.attribute(Xhtml.Attr.HREF, JING);
					String message = TagUtils.getInstance().message(
							pageContext, bundle, localeKey, menuName, null);
					if (message == null || message.length() == 0) {
						out.text(LEFT_BRACKETS);
						out.text(_menuName);
						out.text(RIGHT_BRACKETS);
					} else {
						out.text(message);
					}
					out.endElement(Xhtml.Tag.A);
					out.setPrettyPrinting(true);
					out.endElement(Xhtml.Tag.TD);
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
