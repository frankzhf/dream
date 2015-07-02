package net.frank.framework.web.taglib.tree;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;


public class CheckTreeTag extends TagSupport {
	
	private static final long serialVersionUID = 7131936980129306012L;
	
	private String builder;
	private String var = "tree1";
	private String parameter;
	private String container;
	private String trimorphism = "true";
	
	public String getTrimorphism() {
		return trimorphism;
	}

	public void setTrimorphism(String trimorphism) {
		this.trimorphism = trimorphism;
	}

	public String getContainer() {
		return container;
	}

	public void setContainer(String container) {
		this.container = container;
	}

	public String getParameter() {
		return parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}

	public String getVar() {
		return var;
	}

	public void setVar(String var) {
		this.var = var;
	}

	public String getBuilder() {
		return builder;
	}

	public void setBuilder(String builder) {
		this.builder = builder;
	}

	public int doEndTag() throws JspException {
		JspWriter out = pageContext.getOut();
		try{
			rendererStaticTree(out);
		}catch(IOException e){
			throw new JspException(e);
		}
		return EVAL_PAGE;
	}
	
	
	private void rendererStaticTree(JspWriter jspWriter) throws IOException{
		StringBuffer buf = new StringBuffer();
		HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
		String baseUrl = request.getContextPath();
//		buf.append("\n<link rel=\"StyleSheet\" type=\"text/css\" href=\"").append(baseUrl).append("/global/scripts/checktree/dtreecheck.css\" />\n");
		if("true".equals(trimorphism)){
			buf.append("<script src=\"").append(baseUrl).append("/global/scripts/checktree/dtreecheck.js\"></script>\n");
		}
		else{
			buf.append("<script src=\"").append(baseUrl).append("/global/scripts/checktree/dtreecheck2.js\"></script>\n");	
		}
		
		buf.append("<script src=\"").append(baseUrl).append("/global/scripts/checktree/Validate.js\"></script>\n");
//		buf.append("<link type=\"text/css\" rel=\"stylesheet\" href='").append(baseUrl).append("/global/scripts/checktree.css'/>\n");
		
		buf.append("<script language=\"javascript\" type=\"text/javascript\">\n");
		buf.append("try{\n");
		buf.append("var " + var + " = new dTree(\'"+var+"\', true, \'" + this.container +  "\', 'onChanged');\n");

		CheckTreeBuilder tb;
		try {
			tb = (CheckTreeBuilder)Class.forName(builder).newInstance();
			TreeNode root = tb.buildTree(request,pageContext.getServletContext(), getParameter());
			String content = tb.printScript(root,var);
			
			buf.append(content);
			
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
//		buf.append(var + ".showTree();\n");
		buf.append("}catch(e){};");
		buf.append("</script>\n");
		jspWriter.write(buf.toString());
	}
}
