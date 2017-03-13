package net.frank.pig;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import org.apache.log4j.Logger;

import net.frank.commons.util.OsUtil;
import net.frank.commons.util.OsUtil.CommandReturn;
import net.frank.commons.util.OsUtil.RETURN_TYPE;

public class ScreenRecordPlayer extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7768020223389188480L;

	private transient Logger log = Logger.getLogger(ScreenRecordPlayer.class);
	
	private static String WORKSPACE = "";
	
	private static String FF_MPEG_DIR = "";
	
	private static DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
	
	public static final int STATUS_STOP = 0;
	
	public static final int STATUS_RECORDING = 1;
	
	public static final int STATUS_EXIT = 2;
	
	private static File mp4Folder = null;

	private Dimension screenSize;
	
	private JMenuItem startItem;
	
	private JMenuItem stopItem;
	
	private int status = STATUS_STOP;
	
	private Date start;
	
	private int imageIndex = 0;
	private static int frame = 2;
	private static String kbps = "200k";
	
	
	public Dimension getScreenSize(){
		return screenSize;
	}
	
	public int getStatus(){
		return status;
	}
	
	public void tranformImage(BufferedImage image){
		if(mp4Folder!=null){
			File mp3ImageFolder = new File(mp4Folder,"images");
			if(!mp3ImageFolder.exists()){
				mp3ImageFolder.mkdir();
			}
			FileOutputStream fos = null;
			try{
				fos = new FileOutputStream(mp3ImageFolder.getPath()+File.separator + imageIndex++ +".jpeg");
				ImageIO.write(image, "JPEG", fos);
			}catch(IOException e ){
				log.error(e.getMessage(),e);
			}finally{
				try{
					if(fos!=null){
						fos.close();
					}
				}catch(IOException e){
					log.error(e.getMessage(),e);
				}
			}
		}
	}
	


	public ScreenRecordPlayer(){
		super();
		Properties pp = new Properties();
		try{
			pp.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("pig.properties"));
		}catch(IOException e){
			log.error(e.getMessage(),e);
			System.exit(1);
		}
		frame = Integer.parseInt(pp.getProperty("pig.frame.each.second","10"));
		//segment = Integer.parseInt(pp.getProperty("pig.segment.second","500"));
		kbps = pp.getProperty("pig.kbps","200");
		WORKSPACE = pp.getProperty("pig.workspace.dir","d:/");
		FF_MPEG_DIR = pp.getProperty("pig.depend.ffmpeg.command.dir","ffmpeg");
		//images = new ArrayList<BufferedImage>(frame*segment);
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(500,50);
		JMenu fileMenu = new JMenu("File");
		startItem = new JMenuItem("start");
		startItem.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				log.info("Start recorder....");
				start = new Date();
				startItem.setEnabled(false);
				String mp4Name = "desktop_" + df.format(new Date());
				final File mp4WorkFolder = new File(WORKSPACE + File.separator + mp4Name);
				if(!mp4WorkFolder.exists()){
					mp4WorkFolder.mkdir();
				}
				
				final File mp3ImageFolder = new File(mp4WorkFolder,"images");
				if(!mp3ImageFolder.exists()){
					mp3ImageFolder.mkdir();
				}
				mp4Folder = mp4WorkFolder;
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
				log.info("Stop recorder....");
				stopItem.setEnabled(false);
				status = STATUS_STOP;
				processMp4(mp4Folder);
				
				startItem.setEnabled(true);
			}
		});
		fileMenu.add(stopItem);
		
		JMenuItem exitItem = new JMenuItem("Exit");
		exitItem.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				log.info("Stop recorder.... && Exit");
				startItem.setEnabled(false);
				stopItem.setEnabled(false);
				status = STATUS_EXIT;
				//processMp4();
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
		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.execute(new Thread(new ScreenRecorder(this,frame)));
		
	}
	
	public void processMp4(final File folderName){
		if(folderName!=null){
			new Thread(new Runnable(){
				private static final String COMMAND_PARAM_0 = "-f image2 -strict -2 ";
				private static final String COMMAND_PARAM_1 = "-vcodec libx264";
				
				@Override
				public void run() {
					if(!folderName.exists()){
						folderName.mkdir();
					}	
					File mp3ImageFolder = new File(folderName,"images");
					if(!mp3ImageFolder.exists()){
						mp3ImageFolder.mkdir();
					}
					Date endDate = new Date();
					log.debug("Start time : " + start );
					log.debug("End time : " + endDate );
					float secord = ((endDate.getTime() - start.getTime())/1000);
					log.debug("Movie time : " + secord );
					int phoneSize = imageIndex;
					log.debug("Phone size : " + phoneSize );
					float rate = (phoneSize)/secord;
					log.debug("Rate : " + rate);
					String commandLine = null;
					if(OsUtil.isWin()){
						commandLine =  FF_MPEG_DIR +"ffmpeg " + " -r "+ rate  + " " +COMMAND_PARAM_0 + " -i " + mp3ImageFolder.getPath()+"/%d.jpeg " + COMMAND_PARAM_1 +
								 " -b " + kbps + " " + folderName.getPath() + "/screen.mp4" ;
					}else{
						commandLine = "ffmpeg " + " -r "+ rate  + " " + COMMAND_PARAM_0 + " -i " + mp3ImageFolder.getPath()+"/%d.jpeg " + COMMAND_PARAM_1 +
								 " -b " + kbps + " " + folderName.getPath() + "/screen.mp4" ;
					}
					log.debug("Execute command : " + commandLine);
					CommandReturn rt= OsUtil.execute(commandLine);
					log.debug("Execute result : " + rt.getType());
					if(RETURN_TYPE.SUCCESS == rt.getType()){
						log.info("Generate mp4 success!");
					}else{
						log.debug("Generate mp4 failure! check error message :" + rt.getValue());
					}
					imageIndex = 0;
				}
			}).start();
		}
		
		
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
	private BufferedImage mouseIcon = null;
	private int sleepMilSecond = 0;
	
	public ScreenRecorder(ScreenRecordPlayer player,int frame) {
		jframe = player;
		//this.frame = frame;
		this.sleepMilSecond = 1000/frame;
		log.debug("sleepMilSecond:" + sleepMilSecond);
		try{
			mouseIcon = ImageIO.read(Thread.currentThread().
					getContextClassLoader().getResourceAsStream("mouse.jpg"));
		}catch(IOException e){
			log.error(e.getMessage(), e);
		}
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
				System.out.println(new Date());
				BufferedImage image = robot.createScreenCapture(rectangle);// 捕获制定屏幕矩形区域
				Point point = MouseInfo.getPointerInfo().getLocation();
				Graphics graphics = image.createGraphics();
				graphics.drawImage(mouseIcon,
						point.x,point.y
						,10,10,null);
				jframe.tranformImage(image);
			}
			try {
				Thread.sleep(sleepMilSecond);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e);
				log.error(e.getMessage(),e);
			}
		}
	}
	
}

/***
class Screen extends JPanel implements Runnable {

	private static final long serialVersionUID = 8761934049851939543L;

	private transient Logger log = Logger.getLogger(Screen.class);
	
	private ScreenRecordPlayer jframe;
	
	private int sleepMilSecond;

	public Screen(ScreenRecordPlayer player,int frame) {
		super();
		jframe = player;
		this.sleepMilSecond = 1000/frame;
		log.debug("sleepMilSecond:" + sleepMilSecond);
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
				Thread.sleep(sleepMilSecond);
			} catch (Exception e) {
				e.printStackTrace();
				log.error(e.getMessage(), e);
			}
		}
	}

	public void paint(Graphics g) {
		super.paint(g);
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
**/