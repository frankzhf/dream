package net.frank.framework.web.taglib.content;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import net.frank.framework.spring.SpringContextHolder;
import net.frank.framework.writer.JspResponseWriter;
import net.frank.framework.bo.Resource;
import net.frank.framework.service.QueryService;
import net.frank.framework.service.ServiceNames;

public class ContentPathTag extends SimpleTagSupport {
	
	private JspResponseWriter out = new JspResponseWriter();
	
	private Long resourceId;
	
	private Resource root;
	
	public Long getResourceId() {
		return resourceId;
	}

	public void setResourceId(Long resourceId) {
		this.resourceId = resourceId;
	}
	
	public Resource getRoot(){
		return root;
	}
	
	public void setRoot(Resource root){
		this.root = root;
	}

	public void doTag() throws JspException, IOException {
		QueryService queryService = (QueryService) SpringContextHolder
				.getApplicationContext().getBean(ServiceNames.QUERY_SERVICE);
		Resource resource = queryService.getResource(resourceId);
		String path = queryService.getResourcePath(resource);
		if(getRoot()!=null){
			String path2 = queryService.getResourcePath(getRoot());
			if(path.indexOf(path2) == 0){
				path = path.substring(path2.length());
			}
		}
		out.text(path);
		getJspContext().getOut().print(out.getBuffer());
	}
}