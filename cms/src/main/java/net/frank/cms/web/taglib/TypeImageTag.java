package net.frank.cms.web.taglib;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import net.frank.framework.bo.BaseEntity;
import net.frank.framework.bo.Resource;
import net.frank.framework.service.CacheService;
import net.frank.framework.service.ServiceNames;
import net.frank.framework.spring.SpringContextUtil;
import net.frank.framework.writer.JspResponseWriter;
import net.frank.framework.xml.Xhtml;

public class TypeImageTag extends SimpleTagSupport {
	private static final String DEFAULT_TYPE_IMAGE = "/global/images/xloadtree2b/file.png";
	
	private Long typeId;

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public Long getTypeId() {
		return typeId;
	}

	private JspResponseWriter out = new JspResponseWriter();

	public void doTag() throws JspException, IOException {
		CacheService cacheService = (CacheService) SpringContextUtil
				.getBean(ServiceNames.CACHE_SERVICE);
		PageContext pageContext = (PageContext) getJspContext();
		String contextPath = ((HttpServletRequest) pageContext.getRequest()).getContextPath();
		if (getTypeId() != null
				&& cacheService.getTypeContent().get(getTypeId()) != null) {
			String className = cacheService.getTypeContent().get(getTypeId()).getEntityClassName();
			BaseEntity be = null;
			try{
				be = (BaseEntity)Class.forName(className).newInstance();
			}catch(Exception e ){
				be = new Resource();
			}
			out.startElement(Xhtml.Tag.IMG);
			out.attribute(
					Xhtml.Attr.SRC,contextPath
					 + be.getNodeIcon());
			out.endElement(Xhtml.Tag.IMG);
		} else {
			out.startElement(Xhtml.Tag.IMG);
			out.attribute(Xhtml.Attr.SRC, contextPath+DEFAULT_TYPE_IMAGE);
			out.endElement(Xhtml.Tag.IMG);
		}
		getJspContext().getOut().print(out.getBuffer());
	}
}
