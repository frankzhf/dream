package net.frank.corejava1.ch07;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class DrawTest {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				JFrame frame = new DrawFrame();
				frame.setTitle("DrawTest");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}

class DrawFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7743254968117145831L;

	public DrawFrame() {
		add(new DrawComponent());
		pack();
	}
}

class DrawComponent extends JComponent{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6131832392137400782L;
	private static final int DEFAULT_WIDTH = 400;
	private static final int DEFAULT_HEIGHT = 400;
	
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		double leftX=100;
		double topY=100;
		double width = 200;
		double height = 150;
		Rectangle2D rect = new Rectangle2D.Double(leftX,topY,width,height);
		g2.draw(rect);
		Ellipse2D ellipse = new Ellipse2D.Double();
		ellipse.setFrame(rect);
		g2.draw(ellipse);
		
		g2.draw(new Line2D.Double(leftX, topY, leftX+width, topY+height ));
		
		double centerX=rect.getCenterX();
		double centerY=rect.getCenterY();
		double radius = 150;
		
		Ellipse2D circle = new Ellipse2D.Double();
		circle.setFrameFromCenter(centerX, centerY,centerX + radius,centerY + radius);
		g2.draw(circle);
		
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT);
	}
}
/***
 * java.awt.geom.RectangularShap
 * double getCenterX()
 * double getCenterY()
 * double getMinX()
 * double getMinY()
 * double getMaxX()
 * double getMaxY()
 * 返回闭合矩形的中心，以有最小、最大x和y坐标值
 * 
 * double getWidth()
 * double getHeight()
 * 返回闭合矩形的宽和高
 * 
 * double getX()
 * double getY()
 * 返回闭合矩形左上角的x和y坐标
 * 
 * java.awt.geom.Rectangle2D.Double
 * Rectangle2D.Double(double x, double y, double w, double h)
 * 利用给定的左上角，宽和高，构造一个矩形
 * 
 * java.awt.geom.Rectangle2D.Float
 * Rectangle2D.Float(float x, float y, float w, float h)
 * 利用给定的左上角，宽和高，构造一个矩形
 * 
 * java.awt.geom.Ellipse2D.Double
 * Ellipse2D.Double(double x, double y, double w, double h)
 * 利用给定的左上角，宽和高的外接矩形，构造一个椭圆
 * 
 * java.awt.geom.Point2D.Double
 * Point2D.Double(double x, double y)
 * 利用给定坐标构造一个点
 * 
 * java.awt.geom.Line2D.Double
 * Line2D.Double(Point2D start, Point2D end)
 * Line2D.Double(double startX, double startY, double endX, double endY);
 * 使用给定的起点和终点，构造一条直线
 * 
 * java.awt.Color
 * Color(int r, int g, int b)
 * 构造一个颜色
 * 
 * java.awt.Graphics
 * Color getColor()
 * void setColor(Color c)
 * 获取或改变当前颜色。所有后续的绘图操作都使用这个颜色
 * 
 * java.awt.Graphics2D
 * Paint getPaint()
 * void setPaint(Paint p)
 * 获取或设置这个图形环境的绘制属性。Color类实现了Paint接口。可以使用这个方法将绘制属性设置为纯色
 * 
 * void fill(Shape s)
 * 用当前颜料填充该图形
 * 
 * java.awt.Component
 * Color getBackground()
 * void setBackground(Color c)
 * 获取设置背景颜色
 * 
 * Color getForeground()
 * void setForeground(Color c)
 * 获取设置前景颜色
 * 
**/