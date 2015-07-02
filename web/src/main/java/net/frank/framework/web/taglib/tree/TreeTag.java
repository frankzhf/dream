package net.frank.framework.web.taglib.tree;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import net.frank.commons.util.StringUtil;

public class TreeTag extends TagSupport {
	
	private static final long serialVersionUID = 7131936980129306012L;
	
	private String var = "tree";
	private boolean dynamic = false;   
	private String rootName;
	private String rootIcon;
	private String builder;
	private String callback;
	private String displayId;
	private boolean showRoot;
	private Map<String,Object> paramMap;
	
	
	public Map<String,Object> getParamMap() {
		return paramMap;
	}

	public void setParamMap(Map<String,Object> paramMap) {
		this.paramMap = paramMap;
	}

	public boolean isShowRoot() {
		return showRoot;
	}

	public void setShowRoot(boolean showRoot) {
		this.showRoot = showRoot;
	}
	
	public boolean isDynamic() {
		return dynamic;
	}

	public void setDynamic(boolean dynamic) {
		this.dynamic = dynamic;
	}

	public String getVar() {
		return var;
	}

	public void setVar(String var) {
		this.var = var;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getBuilder() {
		return builder;
	}

	public void setBuilder(String builder) {
		this.builder = builder;
	}

	public String getCallback() {
		return callback;
	}

	public void setCallback(String callback) throws JspException{
		this.callback = callback; 
	}

	public String getDisplayId() {
		return displayId;
	}

	public void setDisplayId(String displayId) {
		this.displayId = displayId;
	}

	public String getRootIcon() {
		return rootIcon;
	}

	public void setRootIcon(String rootIcon) {
		this.rootIcon = rootIcon;
	}

	public String getRootName() {
		return rootName;
	}

	public void setRootName(String rootName) {
		this.rootName = rootName;
	}

	public int doEndTag() throws JspException {
		JspWriter out = pageContext.getOut();
		try{
			if (dynamic){
				rendererDynamicTree(out);
			}else {
				rendererStaticTree(out);
			}
		}catch(IOException e){
			throw new JspException(e);
		}
		return EVAL_PAGE;
	}
	
	protected void rendererDynamicTree(JspWriter jspWriter) throws IOException{
		StringBuffer buf = new StringBuffer();
		HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
		String baseUrl = request.getContextPath();
		/**
		if (request.getAttribute("TREE_TAG_HAS_CONFIG")==null){
			buf.append("<script src='").append(baseUrl).append("/dwr/interface/").append("TreeAjax.js'></script>\n");
			buf.append("<script src='").append(baseUrl).append("/dwr/engine.js'></script>\n");
			buf.append("<script src='").append(baseUrl).append("/dwr/util.js'></script>\n");

			buf.append("<script src='").append(baseUrl).append("/global/scripts/xloadtree2b/xtree2.js'></script>\n");
			buf.append("<script src='").append(baseUrl).append("/global/scripts/xloadtree2b/xmlextras.js'></script>\n");
			buf.append("<script src='").append(baseUrl).append("/global/scripts/xloadtree2b/xloadtree2.js'></script>\n");
			
			buf.append("<link type=\"text/css\" rel=\"stylesheet\" href='").append(baseUrl).append("/global/css/xloadtree2b/xtree2.css'/>\n");
			request.setAttribute("TREE_TAG_HAS_CONFIG",Boolean.TRUE);
		}
		**/
		buf.append("<script type=\"text/javascript\">\n");
		buf.append("var "+var+" = new WebFXLoadTree('").append(getRootName()).append("',");
		buf.append("'");
		buf.append(baseUrl).append("/buildTree.tree?builder=").append(getBuilder()).append("&callback=").append(getCallback());
		buf.append("');");
		buf.append(var+".write();\n");
		buf.append(var+".expand();\n");
		buf.append("</script>");
		
		if (!StringUtil.isEmpty(getCallback().toString())){
			buf.append("<script type=\"text/javascript\">\n");
			buf.append("var reply0 = function(data){ DWRUtil.setValue('").append(getDisplayId()).append("', DWRUtil.toDescriptiveString(data, 1)); }");
			buf.append("</script>");
		}

		
		jspWriter.write(buf.toString());
	}
	
	protected void rendererStaticTree(JspWriter jspWriter) throws IOException{
		StringBuffer buf = new StringBuffer();
		HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
		//String baseUrl = request.getContextPath();
		/**
		if (request.getAttribute("TREE_TAG_HAS_CONFIG")==null){
			buf.append("<script src='").append(baseUrl).append("/dwr/interface/").append("TreeAjax.js'></script>\n");
			buf.append("<script src='").append(baseUrl).append("/dwr/engine.js'></script>\n");
			buf.append("<script src='").append(baseUrl).append("/dwr/util.js'></script>\n");

			buf.append("<script src='").append(baseUrl).append("/global/scripts/xloadtree2b/xtree2.js'></script>\n");
			buf.append("<script src='").append(baseUrl).append("/global/scripts/xloadtree2b/xmlextras.js'></script>\n");
			buf.append("<script src='").append(baseUrl).append("/global/scripts/xloadtree2b/xloadtree2.js'></script>\n");
			
			buf.append("<link type=\"text/css\" rel=\"stylesheet\" href='").append(baseUrl).append("/global/css/xloadtree2b/xtree2.css'/>\n");
			request.setAttribute("TREE_TAG_HAS_CONFIG",Boolean.TRUE);
		}
		*/
		buf.append("<script type=\"text/javascript\">\n");
		buf.append("var "+var+" = new WebFXTree('").append(getRootName()).append("'").append(");\n");

		TreeBuilder tb;
		try {
			tb = (TreeBuilder)Class.forName(builder).newInstance();
			tb.setParamMap(getParamMap());
			if (callback!=null){
				tb.setCallback(getCallback().toString());
			}
			TreeNode root = tb.buildTree(request,pageContext.getServletContext());
			String content = tb.printScript(request,pageContext.getServletContext(),root,var);
			
			buf.append(content);
			
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		if (!isShowRoot()){
			buf.append(var+".setShowRootNode(false);\n");
		}
			
		buf.append(var+".write();\n");
		buf.append(var+".setExpanded(true);\n");
		buf.append("</script>\n");

		if (getCallback()!=null && !StringUtil.isEmpty(getCallback().toString())){
			buf.append("<script type=\"text/javascript\">\n");
			buf.append("var reply0 = function(data){ DWRUtil.setValue('").append(getDisplayId()).append("', DWRUtil.toDescriptiveString(data, 1)); }");
			buf.append("</script>");
		}

		
		jspWriter.write(buf.toString());
	}


}
