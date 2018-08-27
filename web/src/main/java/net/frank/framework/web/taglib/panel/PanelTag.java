package net.frank.framework.web.taglib.panel;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.frank.framework.writer.JspResponseWriter;
import net.frank.framework.xml.Xhtml;

public final class PanelTag extends SimpleTagSupport {

	private final static transient Logger log = LoggerFactory.getLogger(PanelTag.class);

	private String id;
	private String title;
	private String width = "100%";
	private String height = "100%";
	private boolean restore = true;
	private boolean close = false; // operator
	private boolean closed = false; // status

	private JspResponseWriter out = new JspResponseWriter();

	private static final String PANEL_PREFFIX = "panel_";
	private static final String PANEL_TITLEBAR_PREFFIX = "panel_titlebar_";
	private static final String PANEL_TITLE_PREFFIX = "panel_title_";
	private static final String PANEL_TITLEBAR_ICON_RESTORE_PREFFIX = "panel_titlebar_icon_restore_";
	private static final String PANEL_TITLEBAR_ICON_RESTORE_IMG_PREFFIX = "panel_titlebar_icon_restore_img_";
	private static final String PANEL_TITLEBAR_ICON_CLOSE_IMG_PREFFIX = "panel_titlebar_icon_close_img_";
	private static final String PANEL_TITLEBAR_ICON_CLOSE_PREFFIX = "panel_titlebar_icon_close_";
	private static final String PANEL_CONTENT_PREFFIX = "panel_content_";
	private static final String PANEL_FOOTER_PREFFIX = "panel_footer_";
	private static final String STYLE_DISPLAY_HIDDEN = "display:none;";

	/**
	 * CSS refer panel.css
	 */

	private static final String PANEL_CSS_CLASS_NAME = "ui-panel";
	private static final String PANEL_TITLEBAR_CSS_CLASS_NAME = "ui-panel-titlebar";
	private static final String PANEL_TITLE_CSS_CLASS_NAME = "ui-panel-title";
	private static final String PANEL_TITLEBAR_ICON_RESTORE_CSS_CLASS_NAME = "ui-panel-titlebar-icon";
	private static final String PANEL_TITLEBAR_ICON_CLOSE_CSS_CLASS_NAME = "ui-panel-titlebar-icon";
	private static final String PANEL_CONTENT_CSS_CLASS_NAME = "ui-panel-content";
	private static final String PANEL_FOOTER_CSS_CLASS_NAME = "ui-panel-footer";

	private static final String OPEN_ICON_PATH = "/global/images/expand.gif";
	private static final String RESTORE_ICON_PATH = "/global/images/collapse.gif";
	private static final String CLOSE_ICON_PATH = "/global/images/close.gif";

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isRestore() {
		return restore;
	}

	public void setRestore(boolean restore) {
		this.restore = restore;
	}

	public boolean isClose() {
		return close;
	}

	public void setClose(boolean close) {
		this.close = close;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isClosed() {
		return closed;
	}

	public void setClosed(boolean closed) {
		this.closed = closed;
	}

	public void doTag() throws JspException, IOException {
		log.debug("PanelTag.doTag()");
		PageContext pageContext = (PageContext) getJspContext();
		String webRoot = (String) ((HttpServletRequest) pageContext
				.getRequest()).getContextPath();
		String panelId = PANEL_PREFFIX + getId();
		String panelTitlebarId = PANEL_TITLEBAR_PREFFIX + getId();
		String panelTitleId = PANEL_TITLE_PREFFIX + getId();
		String panelTitlebarIconRestoreId = PANEL_TITLEBAR_ICON_RESTORE_PREFFIX
				+ getId();
		String panelTitlebarIconRestoreImgId = PANEL_TITLEBAR_ICON_RESTORE_IMG_PREFFIX
				+ getId();
		String panelTitlebarIconCloseId = PANEL_TITLEBAR_ICON_CLOSE_PREFFIX
				+ getId();
		String panelTitlebarIconCloseImgId = PANEL_TITLEBAR_ICON_CLOSE_IMG_PREFFIX
				+ getId();
		String panelContentId = PANEL_CONTENT_PREFFIX + getId();
		String panelFooterId = PANEL_FOOTER_PREFFIX + getId();

		String style_width_height = "width:" + width + ";height:" + height
				+ ";";

		out.startElement(Xhtml.Tag.DIV);
		out.attribute(Xhtml.Attr.ID, panelId);
		out.attribute(Xhtml.Attr.CLASS, PANEL_CSS_CLASS_NAME);
		out.attribute(Xhtml.Attr.STYLE, style_width_height);

		out.startElement(Xhtml.Tag.DIV);
		out.attribute(Xhtml.Attr.ID, panelTitleId);
		out.attribute(Xhtml.Attr.CLASS, PANEL_TITLEBAR_CSS_CLASS_NAME);

		out.startElement(Xhtml.Tag.DIV);
		out.attribute(Xhtml.Attr.ID, panelTitlebarId);
		out.attribute(Xhtml.Attr.CLASS, PANEL_TITLE_CSS_CLASS_NAME);
		out.text(getTitle());
		out.endElement(Xhtml.Tag.DIV);

		if (isRestore()) {
			out.startElement(Xhtml.Tag.DIV);
			out.attribute(Xhtml.Attr.ID, panelTitlebarIconRestoreId);
			out.attribute(Xhtml.Attr.CLASS,
					PANEL_TITLEBAR_ICON_RESTORE_CSS_CLASS_NAME);
			out.startElement(Xhtml.Tag.IMG);
			out.attribute(Xhtml.Attr.ID, panelTitlebarIconRestoreImgId);
			out.attribute(Xhtml.Attr.SRC, webRoot
					+ (isClosed() ? OPEN_ICON_PATH : RESTORE_ICON_PATH));
			out.attribute(Xhtml.Attr.ONCLICK, "expandCollapsePanel('" + getId()
					+ "')");
			out.endElement(Xhtml.Tag.IMG);
			out.endElement(Xhtml.Tag.DIV);
		}

		if (isClose()) {
			out.startElement(Xhtml.Tag.DIV);
			out.attribute(Xhtml.Attr.ID, panelTitlebarIconCloseId);
			out.attribute(Xhtml.Attr.CLASS,
					PANEL_TITLEBAR_ICON_CLOSE_CSS_CLASS_NAME);
			out.startElement(Xhtml.Tag.IMG);
			out.attribute(Xhtml.Attr.ID, panelTitlebarIconCloseImgId);
			out.attribute(Xhtml.Attr.SRC, webRoot + CLOSE_ICON_PATH);
			out.attribute(Xhtml.Attr.ONCLICK, "expandCollapsePanel('" + getId()
					+ "')");
			out.endElement(Xhtml.Tag.IMG);
			out.endElement(Xhtml.Tag.DIV);

		}
		out.text(" ");
		// out.text("</div>");
		out.endElement(Xhtml.Tag.DIV);

		// process inside statement
		out.startElement(Xhtml.Tag.DIV);
		out.attribute(Xhtml.Attr.ID, panelContentId);
		if (closed) {
			out.attribute(Xhtml.Attr.STYLE, STYLE_DISPLAY_HIDDEN);
		}
		out.attribute(Xhtml.Attr.CLASS, PANEL_CONTENT_CSS_CLASS_NAME);
		StringWriter evalResult = new StringWriter();
		getJspBody().invoke(evalResult);
		out.text(evalResult.getBuffer().toString());
		out.endElement(Xhtml.Tag.DIV);

		out.startElement(Xhtml.Tag.DIV);
		out.attribute(Xhtml.Attr.ID, panelFooterId);
		out.attribute(Xhtml.Attr.CLASS, PANEL_FOOTER_CSS_CLASS_NAME);
		out.text(" ");
		out.endElement(Xhtml.Tag.DIV);
		out.endElement(Xhtml.Tag.DIV);
		// log.debug(out.getBuffer());
		getJspContext().getOut().print(out.getBuffer());
	}
}
