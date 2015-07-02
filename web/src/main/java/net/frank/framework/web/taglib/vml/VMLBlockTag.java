package net.frank.framework.web.taglib.vml;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import net.frank.commons.util.StringUtil;

public class VMLBlockTag extends TagSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3693093354215434548L;
	public static final int DEFAULT_WIDTH = 100;
	public static final int DEFAULT_HEIGHT = 50;
	public static final int DEFAULT_IMAGE_SIZE = 50;
	private String position;		//absolute/relative
	private String strokeColor;		//�߿���ɫ
	private String fillColor;		//���ɫ
	private String text;			//�ı�
	private String textColor;		//
	private String title;			//��ʾ��Ϣ
	private String action;			//�������
	private String image;			//ͼƬ
	private Integer left;			//λ�� :��
	private Integer top;			//    :��
	private Integer width;			//��(100)
	private Integer height;			//��(100)
	//private String shape;			//��״
	

	public VMLBlockTag() {
		//shape = "RoundRect";
		width = new Integer(DEFAULT_WIDTH);
		height = new Integer(DEFAULT_HEIGHT);
		fillColor = "white";
		strokeColor = "black";
	}

	public int doEndTag() throws JspException {
		
		StringBuffer html = new StringBuffer("<v:RoundRect ");
		html.append(getAttribute());
		html.append(getStyle());
		html.append(">\n");
		
		//html.append("\t<v:shadow on=\"T\" type=\"single\" color=\"#b3b3b3\" offset=\"5px,5px\"/>\n");
		if(StringUtil.isNotEmpty(getImage())){
			StringBuffer image = new StringBuffer("\t<img style=\"width:").append(DEFAULT_IMAGE_SIZE)
				.append(";height:").append(DEFAULT_IMAGE_SIZE)
				.append(";top:5;left:5;\" src=\"");
			image.append(getImage());
			image.append("\"/>");
			html.append(image);
		}
		html.append("\t<v:TextBox inset=\"5pt,5pt,5pt,5pt\" style=\"text-align:center;font-size:10.2pt;");
		if(StringUtil.isNotEmpty(getTextColor())){
			html.append("color:").append(getTextColor()).append(";");
		}
		html.append("\">");
		html.append(getText());
		html.append("</v:TextBox>\n");
		html.append("</v:RoundRect>\n");

//		<v:RoundRect style="position:absolute;top:300;left:40;width:150;height:150;z-index:10;" strokecolor="green" strokeweight="2" title="��������ʾ��Ϣ">
//	    <v:shadow on="T" type="single" color="#b3b3b3" offset="5px,5px"/>
//		<v:TextBox inset="5pt,5pt,5pt,5pt" style="text-align:center;font-size:10.2pt;color:green">[��һ�ӽڵ�]</v:TextBox>
//		<img src="file:///C|/Documents and Settings/Jude/My Documents/2F3069A2B386A8595E02C8ECAAC5F942.GIF" style="position:relative;top:30;left:20"/>
//		</v:RoundRect> 

		try{
			JspWriter out = pageContext.getOut();
			out.write(html.toString());
		}catch(IOException e){}
		return EVAL_PAGE;
	}

	private StringBuffer getStyle(){
		StringBuffer style = new StringBuffer(" style=\"");
		if(StringUtil.isNotEmpty(getPosition())){
			style.append("position:").append(getPosition()).append(";");
		}
		if(isNotZero(getTop())){
			style.append("top:").append(getTop()).append(";");
		}
		if(isNotZero(getLeft())){
			style.append("left:").append(getLeft()).append(";");
		}
		style.append("width:");
		if(isNotZero(getWidth())){
			style.append(getWidth());
		}else{
			style.append(DEFAULT_WIDTH);
		}
		style.append(";");
		style.append("height:");
		if(isNotZero(getHeight())){
			style.append(getHeight());
		}else{
			style.append(DEFAULT_HEIGHT);
		}
		style.append(";");
		style.append("\" ");
		return style;
	}
	
	private StringBuffer getAttribute(){
		StringBuffer attribute = new StringBuffer(" ");
		if(StringUtil.isNotEmpty(getStrokeColor())){
			attribute.append("StrokeColor=\"").append(getStrokeColor()).append("\" ");
		}
		if(StringUtil.isNotEmpty(getFillColor())){
			attribute.append("FillColor=\"").append(getFillColor()).append(("\" "));
		}
		if(StringUtil.isNotEmpty(getTitle())){
			attribute.append("title=\"").append(getFillColor()).append("\" ");
		}
		if(StringUtil.isNotEmpty(getAction())){
			attribute.append("onclick=\"").append(getAction()).append("\" ");
		}
		return attribute;
	}
	
	public boolean isZero(Integer i){
		if(i == null || i.intValue() == 0)
			return true;
		return false;
	}
	private boolean isNotZero(Integer i){
		return !isZero(i);
	}


	public String getAction() {
		return action;
	}


	public void setAction(String action) {
		this.action = action;
	}


	public String getFillColor() {
		return fillColor;
	}


	public void setFillColor(String fillColor) {
		this.fillColor = fillColor;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public String getPosition() {
		return position;
	}


	public void setPosition(String position) {
		this.position = position;
	}


	public String getStrokeColor() {
		return strokeColor;
	}


	public void setStrokeColor(String strokeColor) {
		this.strokeColor = strokeColor;
	}


	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getLeft() {
		return left;
	}

	public void setLeft(Integer left) {
		this.left = left;
	}

	public Integer getTop() {
		return top;
	}

	public void setTop(Integer top) {
		this.top = top;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public String getTextColor() {
		return textColor;
	}

	public void setTextColor(String textColor) {
		this.textColor = textColor;
	}
}
