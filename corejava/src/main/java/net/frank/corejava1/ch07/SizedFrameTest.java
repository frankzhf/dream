package net.frank.corejava1.ch07;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class SizedFrameTest {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){
			@Override
			public void run() {
				JFrame frame = new SizedFrame();
				frame.setTitle("SizedFrame");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}		
		});
	}
}

class SizedFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2943128115647994301L;

	public SizedFrame(){
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setSize(screenWidth/2,screenHeight/2);
		setLocationByPlatform(true);
		Image img = new ImageIcon("icon.gif").getImage();
		setIconImage(img);
		getContentPane().setBackground(Color.blue);
		setUndecorated(true); //设置透明度，必须设置Undecorated为true
		setOpacity(0.5f);
	}
}
/***
 * java.awt.Component
 * boolean is Visiable()
 * 获取或设置visiable属性。组件最初是可见的，但JFrame这样的顶层组件例外
 * 
 * void setSize(int width, int height)
 * 使用给定的宽度和高度，重新设置组件的大小
 * 
 * void setLocation(int x, int y)
 * 将组件移动到新的位置上。如果这个组件不是顶层组件，x和y坐标是容器坐标，否则是屏幕坐标
 * 
 * void setBounds(int x, int y, int width, int height)
 * 移动并重新设置组件的大小
 * 
 * Dimension getSize()
 * void setSize(Dimension d)
 * 获取或设置当前组件的size属性
 * 
 * java.awt.Window
 * void toFront()
 * 将这个窗口显示在其他窗口前面
 * 
 * void toBack()
 * 将这个窗口移到桌面窗口栈的后面，并重新排列所有的可见窗口
 * 
 * boolean isLocationByPlatform
 * void setLocationByPlatofrm(boolean b)
 * 获取或设置locationByPlatform属性。这个属性在窗口显示之前被设置，由平台选择一个合适的位置
 * 
 * java.awt.Frame
 * boolean isResizable()
 * void setResizable(boolean b)
 * 获取或设置resizable属性，这个属性设置后，用户可重新设置框架大小
 * 
 * String getTitle()
 * void setTitle(String s)
 * 获取或设置标题栏中的文字
 * 
 * Image getIconImage()
 * void setIconImage(Image image)
 * 获取或设置iconImage属性，这个属性确定框架的图标
 * 
 * boolean isUndecorated()
 * void setUndecorated(boolean b)
 * 获取或设置undecorated属性，这个属性设置以后，框架显示中将没有标题或关闭按钮这样的装饰。在框架显示前，必须调用这个方法
 * 
 * int getExtendedStatus()
 * void setExtendedStatus(int state)
 * 获取或设置窗口状态。状态是下列值之一
 * Frame.NORMAL
 * Frame.ICONIFIED
 * Frame.MAXMIZED_HORIZ
 * Frame.MAXMIZED_VERT
 * Frame.MAXMIZED_BOTH
 * 
 * java.awt.Toolkit
 * static Toolkit getDefaultToolkit()
 * 返回默认的工具箱
 * 
 * Dimension getScreenSize()
 * 返回用户屏幕尺寸
 * 
 * javax.swing.ImageIcon
 * ImageIcon(String filename)
 * 构造一个图标，其图像存储在一个文件中
 * 
 * Image getImage()
 * 获取该图标的图像
 * 
 */
