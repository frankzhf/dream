package net.frank.pig;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import org.apache.log4j.Logger;

public class ScreenRecordPlayer extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7768020223389188480L;

	private transient Logger log = Logger.getLogger(ScreenRecordPlayer.class);
	
	public static final int STATUS_STOP = 0;
	
	public static final int STATUS_RECORDING = 1;
	
	public static final int STATUS_EXIT = 2;

	private Dimension screenSize;
	
	private JMenuItem startItem;
	
	private JMenuItem stopItem;
	
	private int status = STATUS_STOP;
	
	private List<BufferedImage> images;
	
	public Dimension getScreenSize(){
		return screenSize;
	}
	
	public int getStatus(){
		return status;
	}
	
	public void tranformImage(BufferedImage image){
		images.add(image);
	}
	
	public BufferedImage getImage(){
		if(images.size()==0){
			return null;
		}
		return images.get(images.size()-1);
	}
	

	public ScreenRecordPlayer(){
		super();
		images = new ArrayList<BufferedImage>(40960);
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(500,400);
		JMenu fileMenu = new JMenu("File");
		startItem = new JMenuItem("start");
		startItem.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				log.info("Start recorder....");
				startItem.setEnabled(false);
				status = STATUS_RECORDING;
				stopItem.setEnabled(true);
			}
		});
		fileMenu.add(startItem);
		
		stopItem = new JMenuItem("stop");
		stopItem.setEnabled(false);
		stopItem.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				stopItem.setEnabled(false);
				status = STATUS_STOP;
				startItem.setEnabled(true);
			}
		});
		fileMenu.add(stopItem);
		
		JMenuItem exitItem = new JMenuItem("Exit");
		exitItem.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				startItem.setEnabled(false);
				stopItem.setEnabled(false);
				status = STATUS_EXIT;
				try {
					Thread.sleep(1000);
				}catch(InterruptedException ex){
					log.error(ex.getMessage(),ex);
				}
				System.exit(0);
			}
		});
		fileMenu.add(exitItem);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(fileMenu);
		setJMenuBar(menuBar);
		
		setLayout(new BorderLayout());
		Screen p = new Screen(this);
		add(p,BorderLayout.CENTER);
		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.execute(new Thread(new ScreenRecorder(this)));
		executor.execute(new Thread(p));
		
	}
	
	public void processMp4(){
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				JFrame frame = new ScreenRecordPlayer();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}

}


class ScreenRecorder extends Thread {
	private transient Logger log = Logger.getLogger(ScreenRecorder.class);
	private Rectangle rectangle;
	private Robot robot;
	private ScreenRecordPlayer jframe;
	
	public ScreenRecorder(ScreenRecordPlayer player) {
		jframe = player;
		rectangle = new Rectangle(jframe.getScreenSize());
		try {
			robot = new Robot();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}
	
	public void run() {
		while (true) {
			if(ScreenRecordPlayer.STATUS_EXIT == jframe.getStatus()){
				break;
			}
			if(ScreenRecordPlayer.STATUS_RECORDING == jframe.getStatus()){
				BufferedImage image = robot.createScreenCapture(rectangle);// 捕获制定屏幕矩形区域
				jframe.tranformImage(image);
			}
			try {
				Thread.sleep(500);// 每秒10帧
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e);
				log.error(e.getMessage(),e);
			}
		}
	}
	
}


class Screen extends JPanel implements Runnable {

	private static final long serialVersionUID = 8761934049851939543L;

	private transient Logger log = Logger.getLogger(Screen.class);
	
	private ScreenRecordPlayer jframe;

	public Screen(ScreenRecordPlayer player) {
		super();
		jframe = player;
		setLayout(null);
	}

	@Override
	public void run() {
		while (true) {
			if(ScreenRecordPlayer.STATUS_EXIT == jframe.getStatus()){
				break;
			}
			if(ScreenRecordPlayer.STATUS_RECORDING == jframe.getStatus()){
				BufferedImage cimage = jframe.getImage();
				if(cimage!=null){
					MediaTracker mt = new MediaTracker(this);
					mt.addImage(cimage, 0);
					try {
						mt.waitForID(0);
					} catch (InterruptedException e) {
						e.printStackTrace();
						log.error(e.getMessage(), e);
					}
					repaint();
				}
			}
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				e.printStackTrace();
				log.error(e.getMessage(), e);
			}
		}
	}

	public void paint(Graphics g) {
		super.paint(g);
		//Graphics2D g2 = (Graphics2D) g;
		BufferedImage cimage = jframe.getImage();
		if(cimage!=null){
			//int _width = getWidth();
			//int _height = getHeight();
			//log.info("width :" + _width);
			//log.info("height :" + _height);
			g.drawImage(cimage, 0,0,null);
			g.dispose();					
			
		}
	}

	public Image loadImage(BufferedImage image) {
		MediaTracker mt = new MediaTracker(this);
		mt.addImage(image, 0);
		try {
			mt.waitForID(0);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return image;
	}
}


