package net.frank.framework.web.taglib.vml;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import net.frank.commons.util.StringUtil;

public class ViewTag extends TagSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8715101017578679832L;
	private String builder;
	private String type;
	private String parameter;
	private String shape = "RoundRect";
	private long baseLeft;
	private long baseTop;
	private long width;
	private long height;

	public int doEndTag() throws JspException {
		ViewBuilder builder = getBuilder(getBuilder());
		if(builder != null){
			HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
			StringBuffer vml = builder.builder(request, pageContext.getServletContext(),
					parameter, shape, type, baseLeft, baseTop, width, height);
			if(vml != null && vml.length() != 0){
				JspWriter out = pageContext.getOut();
				try {
					out.print(vml.toString());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return EVAL_PAGE;
	}

	public ViewBuilder getBuilder(String builder){
		ViewBuilder viewBuilder = null;
		try{
			if(StringUtil.isNotEmpty(builder))
				viewBuilder = (ViewBuilder)Class.forName(builder).newInstance();
		}catch (ClassNotFoundException e) {
		}catch (Exception e) {
		}
		return viewBuilder;
	}
	
	public long getHeight() {
		return height;
	}

	public void setHeight(long height) {
		this.height = height;
	}

	public long getWidth() {
		return width;
	}

	public void setWidth(long width) {
		this.width = width;
	}
	
	public String getBuilder() {
		return builder;
	}
	public void setBuilder(String builder) {
		this.builder = builder;
	}
	public String getParameter() {
		return parameter;
	}
	public void setParameter(String parameter) {
		this.parameter = parameter;
	}
	public String getShape() {
		return shape;
	}
	public void setShape(String shape) {
		this.shape = shape;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public long getBaseLeft() {
		return baseLeft;
	}
	public void setBaseLeft(long baseLeft) {
		this.baseLeft = baseLeft;
	}
	public long getBaseTop() {
		return baseTop;
	}
	public void setBaseTop(long baseTop) {
		this.baseTop = baseTop;
	}

}
