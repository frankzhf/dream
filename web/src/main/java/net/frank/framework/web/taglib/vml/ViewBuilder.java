package net.frank.framework.web.taglib.vml;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import net.frank.commons.util.StringUtil;

public abstract class ViewBuilder implements ViewBuilderInterface {
	public final long DEFAULT_BLOCK_WIDTH = 100;
	public final long DEFAULT_BLOCK_HEIGHT = 40;
	public final long DEFAULT_IMAGE_WIDTH = 32;
	public final long DEFAULT_IMAGE_HEIGHT = 32;
	public final static String DEFAULT_STROKE_COLOR = "black";
	public final static String DEFAULT_TEXT_COLOR = "black";
	public final static String DEFAULT_FILL_COLOR = "white";
	public final static String DEFAULT_FONTSIZE = "8.2pt";
	public final static String DEFAULT_STATE_RUN_WITH_PROBLEM_COLOR = "yellow";
	public final static String DEFAULT_STATE_STOPPED = "red";
	public final long OFFSET = 20;
	public final String DEFAULT_LINE_COLOR = "green";
	public final long DEFAULT_LINE_WEIGHT = 1;
	
	protected String shape = "RoundRect";
	protected long left = 0;
	protected long top = 0;
	protected long width = 600;
//	protected long height = 400;
	protected String parameter;
//	protected String type;

	public abstract StringBuffer builder(HttpServletRequest request,ServletContext context,
			String parameter, String shape, String type, 
			long left, long top, long width, long height);

	public StringBuffer getNodeVml(VmlNode node){
		StringBuffer vml = new StringBuffer();
		vml.append("<v:").append(shape).append(" class='tooltip' ");
		vml.append(getNodeStyle(node));
		vml.append(getNodeAttribute(node));
		vml.append(">\n");
		
		if(StringUtil.isNotEmpty(node.getAction())){
			vml.append("<a style=\"text-decoration:none;\" href=\"").append(node.getAction()).append("\">");
		}
//		if(StringUtil.isNotEmpty(node.getTitle())){
//			vml.append("<span title=\"").append(node.getTitle()).append("\">");
//		}
		vml.append("<center>");
		if(StringUtil.isNotEmpty(getNodeImage(node))){
			StringBuffer image = new StringBuffer("\n\t<img border=\"0\" style=\"width:").append(DEFAULT_IMAGE_WIDTH)
				.append(";height:").append(DEFAULT_IMAGE_HEIGHT)
				.append(";margin-top:3;\" src=\"");
			image.append(getNodeImage(node));
			image.append("\"/><br>\n");
			vml.append(image);
		}
		vml.append("\n\t<v:TextBox style=\"text-align:center;font-size:")
			.append(DEFAULT_FONTSIZE).append(";");
		if(StringUtil.isNotEmpty(node.getTextColor())){
			vml.append("color:").append(node.getTextColor()).append(";");
		}
		vml.append("\">");
		vml.append(node.getText());
		vml.append("</v:TextBox>\n");
		vml.append("</center>");
//		if(StringUtil.isNotEmpty(node.getTitle())){
//			vml.append("</span>");
//		}
		if(StringUtil.isNotEmpty(node.getAction())){
			vml.append("</a>");
		}
		vml.append("</v:").append(shape).append(">\n");
		return vml;
	}

	public StringBuffer getConnectionVml(VmlNode from, VmlNode to, int flag){
		/** flag:
		 * 	0 : �����
		 *  1 : �����
		 *  2 : ��� (1/2λ��)
		 *  3 : ��� (1/3λ��)
		 *  4 : ����
		 * */
		if(from == null || to == null)
			return null;
		StringBuffer vml = new StringBuffer("<v:PolyLine ");
		vml.append(getConnectionAttribute());
		vml.append(getConnectionPoints(from, to, flag));
		vml.append(">\n");
		
		vml.append("\t<v:stroke EndArrow=\"Classic\" dashstyle=\"solid\" />\n");
		vml.append("</v:PolyLine>\n");
		return vml;
	}

	private StringBuffer getNodeStyle(VmlNode node){
		StringBuffer style = new StringBuffer("style=\"z-index:3;position:absolute;");
		style.append("width:").append(node.getWidth()).append(";");
		style.append("height:").append(node.getHeight()).append(";");
		style.append("left:").append(node.getLeft()).append(";");
		style.append("top:").append(node.getTop()).append(";");
		style.append("\" ");
		return style;
	}

	public String getNodeImage(VmlNode node){
		return node.getImage();
		//return null;
	}

	private StringBuffer getNodeAttribute(VmlNode node){
		StringBuffer attribute = new StringBuffer();
		if(StringUtil.isNotEmpty(node.getStrokeColor()))
			attribute.append("StrokeColor=\"").append(node.getStrokeColor()).append("\" ");
		if(node.getStrokeWeight() != 0)
			attribute.append("StrokeWeight=\"").append(node.getStrokeWeight()).append("\" ");
		if(StringUtil.isNotEmpty(node.getTitle())){
			attribute.append("title=\"").append(node.getTitle()).append("\" ");
		}
		return attribute;
	}
	
	private StringBuffer getConnectionAttribute(){
		StringBuffer attribute = new StringBuffer("style=\"z-index:2;position:absolute;\" ");
		attribute.append("StrokeColor=\"").append(DEFAULT_LINE_COLOR).append("\" ");
		attribute.append("StrokeWeight=\"").append(DEFAULT_LINE_WEIGHT).append("\" ");
		return attribute;
	}
	
	public StringBuffer getPolilinePoints(long startLeft, long startTop, long endLeft, long endTop, int flag){
		StringBuffer points = new StringBuffer();
		points.append(startLeft).append(" ");
		points.append(startTop).append(", ");
		if(startLeft != endLeft && startTop != endTop){
			switch(flag){
			case 0:	//�����
				points.append(startLeft).append(" ");
				points.append((startTop + endTop) / 2).append(", ");
				
				points.append(endLeft).append(" ");
				points.append((startTop + endTop) / 2).append(", ");
				break;
			case 1:	//�����
				points.append((startLeft + endLeft) / 2).append(" ");
				points.append(startTop).append(", ");
				
				points.append((startLeft + endLeft) / 2).append(" ");
				points.append(endTop).append(", ");
				break;
			case 2:	//���	1/2
			case 3:	//		1/3
				points.append(startLeft).append(" ");
				points.append(endTop).append(", ");
				break;
			case 4:	//����
				points.append(endLeft).append(" ");
				points.append(startTop).append(", ");
				break;
			}
		}
		points.append(endLeft).append(" ");
		points.append(endTop);
		return points;
	}
	
	public StringBuffer getConnectionPoints(VmlNode from, VmlNode to, int flag){
		StringBuffer points = new StringBuffer("Points=\"");
		long startLeft = 0;
		long startTop = 0;
		long endLeft = 0;
		long endTop = 0;
		long blockWidth = from.getWidth();
		long blockHeight = from.getHeight();

		if(from.getTop() == to.getTop()){
			startTop = endTop = from.getTop() + blockHeight / 2;
			startLeft = from.getLeft() + (from.getLeft() < to.getLeft() ? blockWidth : 0);
			endLeft = to.getLeft() + (from.getLeft() > to.getLeft() ? blockWidth : 0);
		}else if(from.getLeft() == to.getLeft()){
			startLeft = endLeft = from.getLeft() + blockWidth / 2;
			startTop = from.getTop() + (from.getTop() < to.getTop() ? blockHeight : 0);
			endTop = to.getTop() + (from.getTop() > to.getTop() ? blockHeight : 0);
		}else{
			switch (flag){
			case 0:	//�����
				startLeft = from.getLeft() + blockWidth / 2;
				startTop = from.getTop() + (from.getTop() < to.getTop() ? blockHeight : 0);
				endLeft = to.getLeft() + blockWidth / 2;
				endTop = to.getTop() + (from.getTop() > to.getTop() ? blockHeight : 0);
				break;
			case 1:	//�����
				startLeft = from.getLeft() + (from.getLeft() < to.getLeft() ? blockWidth : 0);
				startTop = from.getTop() + blockHeight / 2;
				endLeft = to.getLeft() + (from.getLeft() > to.getLeft() ? blockWidth : 0);
				endLeft = to.getTop() + blockHeight / 2;
				break;
			case 2:	//���	1/2
			case 3:	//		1/3
				startLeft = from.getLeft() + DEFAULT_BLOCK_WIDTH / flag;
				endTop = to.getTop() + DEFAULT_BLOCK_HEIGHT / 2;
				startTop = from.getTop() + (from.getTop() < to.getTop() ? DEFAULT_BLOCK_HEIGHT : 0);
				endLeft = to.getLeft() + (from.getLeft() < to.getLeft() ? 0 : DEFAULT_BLOCK_WIDTH);
				break;
			case 4:	//����
				startTop = from.getTop() + DEFAULT_BLOCK_HEIGHT / 2;
				endLeft = to.getLeft() + DEFAULT_BLOCK_WIDTH / 2;
				startLeft = from.getLeft() + (from.getLeft() < to.getLeft() ? DEFAULT_BLOCK_WIDTH : 0);
				endTop = to.getTop() + (from.getTop() < to.getTop() ? 0 : DEFAULT_BLOCK_HEIGHT);
				break;
			default:
			}
		}
		points.append(getPolilinePoints(startLeft, startTop, endLeft, endTop, flag));
		points.append("\" ");
		return points;
	}
	
	public VmlNode getDefaultNode(){
		VmlNode node = new VmlNode();
		node.setHeight(DEFAULT_BLOCK_HEIGHT + DEFAULT_IMAGE_HEIGHT);
		node.setWidth(DEFAULT_BLOCK_WIDTH);
		node.setImageHeight(DEFAULT_IMAGE_HEIGHT);
		node.setImageWidth(DEFAULT_IMAGE_WIDTH);
		node.setStrokeColor(DEFAULT_STROKE_COLOR);
		node.setTextColor(DEFAULT_TEXT_COLOR);
		node.setStrokeWeight(1);
		return node;
	}

}
