package net.frank.corejava1.ch07;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class ImageTest {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				JFrame frame = new ImageFrame();
				frame.setTitle("ImageTest");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}

}

class ImageFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5641558642918144369L;

	public ImageFrame() {
		add(new ImageComponent());
		pack();
	}
}

class ImageComponent extends JComponent{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6659977509649110308L;
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 200;
	
	private Image image;
	
	public ImageComponent() {
		URL url = getClass().getClassLoader().getResource("apple.jpg");
		image = new ImageIcon(url).getImage();
	}
	
	public void paintComponent(Graphics g) {
		if(image == null) {
			return;
		}
		int imageWidth = image.getWidth(this);
		int imageHeight = image.getHeight(this);
		
		g.drawImage(image,0,0,null);
		for(int i=0;i*imageWidth <= getWidth();i++) {
			for(int j=0;j*imageHeight <= getHeight();j++) {
				if(i+j >0) {
					g.copyArea(0, 0, imageWidth, imageHeight,
							i*imageWidth , j*imageHeight);
				}
			}
		}
	}
	public Dimension getPreferredSize() {
		return new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT);
	}
}

/***
 * java.awt.Graphics
 * boolean drawImage(Image img, int x, int y, ImageObserver observer)
 * 绘制一幅非比例图像。
 * 
 * boolean drawImage(Image img, int x, int y, int width, int height, ImageObserver observer)
 * 绘制一幅比例图像
 * 
 * void copyArea(int x, int y, int width, int height, int dx, int dy);
 * 拷贝屏幕的一块区域
 **/ 
