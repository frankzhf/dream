package net.frank.corejava1.ch10;

import java.awt.EventQueue;
import java.awt.Image;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/***
 * 
 * @author zhaofeng
 *	
 *
 *
 * pack200是一种较通常的ZIP压缩算法，对类文件的压缩率接近90%
 * jar的命令选项
 * 
 * c	创建一个新的或者空的存档文件并加入文件。如果指定的文件名是目录，jar程序会对它们进行递归处理
 * C	暂时改变目录
 * e	在清单文件中创建一个条目
 * f	将jar文件名指定为第二个命令参数。如果没有这个参数，jar命令会把结果写到标准输出上
 * i	建立索引文件
 * m	将一个清单文件添加到jar文件中，清单是对存档内容和来源的说明，每个归档有一个默认的清单文件
 * M	不为条目创建清单文件
 * t	显示内容列表
 * u	更新一个已有的jar文件
 * v	生成详细的输出结果
 * x	解压文件
 * O	存储，不进行zip压缩
 */

public class ResourceTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame frame = new ResourceTestFrame();
				frame.setTitle("ResourceTest");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
			
		});
	}
}

class ResourceTestFrame extends JFrame{
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 300;
	
	public ResourceTestFrame() {
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		URL aboutURL = getClass().getResource("about.gif");
		Image img = new ImageIcon(aboutURL).getImage();
		setIconImage(img);
		
		JTextArea textArea = new JTextArea();
		InputStream stream = getClass().getResourceAsStream("about.txt");
		try(Scanner in = new Scanner(stream)){
			while(in.hasNext()) {
				textArea.append(in.nextLine() + "\n");
			}
			add(textArea);
		}
	}
}