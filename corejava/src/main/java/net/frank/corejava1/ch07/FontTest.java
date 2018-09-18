package net.frank.corejava1.ch07;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class FontTest {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				JFrame frame = new FontFrame();
				frame.setTitle("FontTest");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}

}

class FontFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8744486744623624365L;

	public FontFrame() {
		add(new FontComponent());
		pack();
	}
}

class FontComponent extends JComponent{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1486885991026055030L;
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 200;
	
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		String msg = "Hello, World!";
		Font f = new Font("Serif",Font.BOLD,36);
		g2.setFont(f);
		
		FontRenderContext context = g2.getFontRenderContext();
		Rectangle2D bounds = f.getStringBounds(msg, context);
		
		double x =(getWidth() - bounds.getWidth()) /2;
		double y =(getHeight() - bounds.getHeight()) /2;
		
		double ascent = -bounds.getY();
		double baseY = y+ ascent;
		g2.drawString(msg, (int)x, (int)baseY);
		g2.setPaint(Color.LIGHT_GRAY);
		
		g2.draw(new Line2D.Double(x, baseY, x+ bounds.getWidth(),baseY));
		Rectangle2D rect = new Rectangle2D.Double(x,y,bounds.getWidth(),bounds.getHeight());
		
		g2.draw(rect);
		
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT);
	}
	
}

/***
 * java.awt.Font
 * Font(String name,int style,int size)
 * 创建一个新的字体对象
 * 
 * String getFontName()
 * 返回字体名
 * 
 * String getFamily()
 * 返回字体家族名
 * 
 * String getName()
 * 如果采用逻辑字体名创建字体，将返回逻辑字体；否则，返回字体名
 * 
 * Rectangle2D getStringBounds(String s, FontRenderContext context)
 * 返回包围这个字符串的矩形。
 * 
 * LineMetrics getLineMetrics(String s, FontReaderContext context)
 * 返回测定字符串宽度的一个线性度量
 * 
 * Font deriveFont(int style)
 * Font deriveFont(float size)
 * Font deriveFont(int style,float size)
 * 返回一个新字体
 * 
 * java.awt.font.LineMetrics
 * float getAscent()
 * 返加字体上坡度
 * 
 * float getDescent()
 * 返回字体下坡度
 * 
 * float getLeading()
 * 返回行间距
 * 
 * float getHeight()
 * 返回字体总高度
 * 
 * java.awt.Graphics
 * Font getFont()
 * void setFont(Font font)
 * 获取或设置当前字体
 * 
 * void drawString(String str, int x, int y)
 * 采用当前字体和颜色绘制一个字符串
 * 
 * java.awt.Graphics2D
 * FontReaderContext getFontRenderContext()
 * 返加这个图形文本中， 指字字体特征的字体绘制环境
 * 
 * void drawString(String str, float x, float y)
 * 采用当前字体和颜色绘制一个字符串
 * 
 * javax.swing.JComponent
 * FontMetrics getFontMetrics(Font f)
 * 获取给定字体的度量 FontMetrics 是 LineMetrics的早先版
 * 
 * java.awt.FontMetrics
 * FontRenderContext getFontRenderContext()
 * 返回字体的字体绘制环境
 * 
 */

