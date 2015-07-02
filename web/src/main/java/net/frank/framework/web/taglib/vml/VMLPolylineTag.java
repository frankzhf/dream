package net.frank.framework.web.taglib.vml;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import net.frank.commons.util.StringUtil;

public class VMLPolylineTag extends TagSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7845075281213038781L;
	private Integer startLeft;
	private Integer startTop;
	private Integer endLeft;
	private Integer endTop;
	private String color;
	private String flag;
	private String title;
	private String position;
	private String weight;

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public VMLPolylineTag() {
		position = "relative";
		color = "black";
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public int doEndTag() throws JspException {
		StringBuffer html = new StringBuffer("<v:PolyLine ");
		html.append(getAttribute());
		html.append(getStyle());
		html.append(">\n");
		
		html.append("\t<v:stroke EndArrow=\"Classic\" dashstyle=\"solid\" />\n");
		
		html.append("</v:PolyLine>\n");
		//html
		try{
			JspWriter out = pageContext.getOut();
			out.write(html.toString());
		}catch(IOException e){}
		return EVAL_PAGE;
	}
	
	private StringBuffer getPoints(){
		StringBuffer points = new StringBuffer("Points=\"");
		points.append(getStartLeft()).append(" ").append(getStartTop()).append(", ");
		points.append(getStartLeft()).append(" ").append(getMidTop()).append(", ");
		points.append(getEndLeft()).append(" ").append(getMidTop()).append(", ");
		points.append(getEndLeft()).append(" ").append(getEndTop()).append("\" ");
		return points;
	}
	
	private StringBuffer getStyle(){
		StringBuffer style = new StringBuffer("style=\"");
		if(StringUtil.isNotEmpty(getPosition())){
			style.append("position:").append(getPosition()).append("; ");
		}
		style.append("\" ");
		return style;
	}
	
	private StringBuffer getAttribute(){
		StringBuffer attribute = new StringBuffer();
		if(StringUtil.isNotEmpty(getTitle())){
			attribute.append("title=\"").append(getTitle()).append("\" ");
		}
		if(StringUtil.isNotEmpty(getColor())){
			attribute.append("StrokeColor=\"").append(getColor()).append("\" ");
		}
		if(StringUtil.isNotEmpty(getWeight())){
			attribute.append("StrokeWeight:\"").append((getWeight())).append("\" ");
		}
		attribute.append(getPoints());
		return attribute;
	}
	
	private Integer getMidTop(){
		return new Integer((getStartTop().intValue() + getEndTop().intValue())/2);
	}
	
	public Integer getEndLeft() {
		return endLeft;
	}

	public void setEndLeft(Integer endLeft) {
		this.endLeft = endLeft;
	}

	public Integer getEndTop() {
		return endTop;
	}

	public void setEndTop(Integer endTop) {
		this.endTop = endTop;
	}

	public Integer getStartLeft() {
		return startLeft;
	}

	public void setStartLeft(Integer startLeft) {
		this.startLeft = startLeft;
	}

	public Integer getStartTop() {
		return startTop;
	}

	public void setStartTop(Integer startTop) {
		this.startTop = startTop;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
