package net.frank.framework.web.taglib.tree;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;

import net.frank.commons.util.StringUtil;

public class TreeTagHtml extends TreeTag {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8979857397678024170L;
	
	
	protected void rendererDynamicTree(JspWriter jspWriter) throws IOException{
		StringBuffer buf = new StringBuffer();
		HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
		String baseUrl = request.getContextPath();

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
		
		buf.append("<script type=\"text/javascript\">\n");
		buf.append("var "+getVar()+" = new WebFXLoadTree('").append(getRootName()).append("',");
		buf.append("'");
		buf.append(baseUrl).append("/buildTree.tree?builder=").append(getBuilder()).append("&callback=").append(getCallback());
		buf.append("');");
		buf.append(getVar()+".write();\n");
		buf.append(getVar()+".expand();\n");
		buf.append("</script>");
		
		if (!StringUtil.isEmpty(getCallback().toString())){
			buf.append("<script type=\"text/javascript\">\n");
			buf.append("var reply0 = function(data){ DWRUtil.setValue('").append(getDisplayId()).append("', DWRUtil.toDescriptiveString(data, 1)); }");
			buf.append("</script>");
		}
		//String content = buf.toString();
		//String htmlContext = content.replaceAll("'", "\\\'");
		//System.out.println(htmlContext);
		jspWriter.write(buf.toString());
	}
	
	protected void rendererStaticTree(JspWriter jspWriter) throws IOException{
		StringBuffer buf = new StringBuffer();
		HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
		String baseUrl = request.getContextPath();
		
		if (request.getAttribute("TREE_TAG_HAS_CONFIG")==null){
			buf.append("<script src=\\\'").append(baseUrl).append("/dwr/interface/").append("TreeAjax.js\\\'></script>");
			buf.append("<script src=\\\'").append(baseUrl).append("/dwr/engine.js\\\'></script>");
			buf.append("<script src=\\\'").append(baseUrl).append("/dwr/util.js\\\'></script>");

			buf.append("<script src=\\\'").append(baseUrl).append("/global/scripts/xloadtree2b/xtree2.js\\\'></script>");
			buf.append("<script src=\\\'").append(baseUrl).append("/global/scripts/xloadtree2b/xmlextras.js\\\'></script>");
			buf.append("<script src=\\\'").append(baseUrl).append("/global/scripts/xloadtree2b/xloadtree2.js\\\'></script>");
			
			buf.append("<link type=\"text/css\" rel=\"stylesheet\" href=\\\'").append(baseUrl).append("/global/css/xloadtree2b/xtree2.css\\\'/>");
			request.setAttribute("TREE_TAG_HAS_CONFIG",Boolean.TRUE);
		}
		
		buf.append("<script type=\\\'text/javascript\\\\'>");
		buf.append("var "+getVar()+" = new WebFXTree(\\\'").append(getRootName()).append("\\\'").append(");");

		TreeBuilder tb;
		try {
			tb = (TreeBuilder)Class.forName(getBuilder()).newInstance();
			tb.setParamMap(getParamMap());
			if (getCallback()!=null){
				tb.setCallback(getCallback().toString());
			}
			TreeNode root = tb.buildTree(request,pageContext.getServletContext());
			String content = tb.printScript2(request,pageContext.getServletContext(),root,getVar());
			
			buf.append(content);
			
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		if (!isShowRoot()){
			buf.append(getVar()+".setShowRootNode(false);");
		}
			
		buf.append(getVar()+".write();");
		buf.append(getVar()+".expand();");
		buf.append("</script>");

		if (getCallback()!=null && !StringUtil.isEmpty(getCallback().toString())){
			buf.append("<script type=\\\'text/javascript\\\'>");
			buf.append("var reply0 = function(data){ DWRUtil.setValue(\\\'").append(getDisplayId()).append("\\\', DWRUtil.toDescriptiveString(data, 1)); }");
			buf.append("</script>");
		}
		//String content = buf.toString();
		//String htmlContext = content.replaceAll("'", "\'");
		//System.out.println(htmlContext);
		jspWriter.write(buf.toString());
	}
}
