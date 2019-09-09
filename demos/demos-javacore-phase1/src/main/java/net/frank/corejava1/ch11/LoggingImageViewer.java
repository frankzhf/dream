package net.frank.corejava1.ch11;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.*;

public class LoggingImageViewer {


    public static void main(String[] args){
        if(System.getProperty("java.util.logging.config.class") == null
            && System.getProperty("java.util.logging.config.file") == null){
            try{
                Logger.getLogger("net.frank.corejava1").setLevel(Level.ALL);
                final int LOG_ROTATION_COUNT = 10;
                Handler handler = new FileHandler("%h/LoggingImaveViewer.log",0,LOG_ROTATION_COUNT);
                Logger.getLogger("net.frank.corejava1").addHandler(handler);
            }catch (IOException e){
                Logger.getLogger("net.frank.corejava1").log(Level.SEVERE,
                        "Can't create log file handler",e);
            }
        }

        EventQueue.invokeLater(()->{
            Handler windowHandler = new WindowHandler();
            windowHandler.setLevel(Level.ALL);
            Logger.getLogger("net.frank.corejava1").addHandler(windowHandler);

            JFrame frame = new ImageViewerFrame();
            frame.setTitle("Logging Image Viewer");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            Logger.getLogger("net.frank.corejava1").fine("Showing frame");
            frame.setVisible(true);
        });

    }
}

class ImageViewerFrame extends JFrame{
    private static final int DEFAULT_WIDTH=300;
    private static final int DEFAULT_HEIGHT=400;

    private JLabel label;
    private static Logger logger = Logger.getLogger("net.frank.corejava1");

    public ImageViewerFrame(){
        logger.entering("ImageViewFrame","<init>");
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menu = new JMenu("File");
        menuBar.add(menu);

        JMenuItem openItem =new JMenuItem("Open");
        menu.add(openItem);
        openItem.addActionListener(new FileOpenListener());
        JMenuItem exitItem = new JMenuItem("Exit");
        menu.add(exitItem);

        exitItem.addActionListener((event)->{
            logger.fine("Exiting.");
            System.exit(0);
        });
        label = new JLabel();
        add(label);
        logger.exiting("ImageViewFrame","<init>");
    }


    private class FileOpenListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            logger.entering("ImageViewerFrame.FileOpenListener","actionPerformed",event);
            JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(new File("."));
            chooser.setFileFilter(new FileFilter() {
                @Override
                public boolean accept(File f) {
                    return f.getName().toLowerCase().endsWith(".gif")
                            || f.isDirectory();
                }

                @Override
                public String getDescription() {
                    return "GIF Images";
                }
            });
            int r = chooser.showOpenDialog(ImageViewerFrame.this);
            if(r == JFileChooser.APPROVE_OPTION){
                String name = chooser.getSelectedFile().getPath();
                logger.log(Level.FINE, "Reading file {0}", name);
                label.setIcon(new ImageIcon(name));
            }else{
                logger.fine("File open dialog canceled.");
            }
            logger.exiting("ImageViewerFrame.FileOpenListener",
                    "actionPerformed");
        }
    }


}


class WindowHandler extends StreamHandler {

    private JFrame frame;

    public WindowHandler(){
        frame = new JFrame();
        final JTextArea output = new JTextArea();
        output.setEnabled(false);

        frame.setSize(200,200);
        frame.add(new JScrollPane(output));
        frame.setFocusableWindowState(false);
        frame.setVisible(true);
        setOutputStream(new OutputStream() {
            @Override
            public void write(int b)  {

            }

            public void write(byte bytes[], int off, int len)  {
                output.append(new String(bytes,off,len));
            }
        });
    }

    public void publish(LogRecord record){
        if(!frame.isValid()){
            return;
        }
        super.publish(record);
        flush();
    }

}

/***
 * java.util.logging.Logging
 * Logger getLogger(String loggerName)
 * Logger getLogger(String loggerName, String bundleName)
 * 获取给定名字的日志记录器。如果这个日志记录器不存在，创建一个日志记录器
 *
 * void severe(String message)
 * void warning(String message)
 * void info(String message)
 * void config(String message)
 * void fine(String message)
 * void finer(String message)
 * void finest(String message)
 * 记录一个由方法名和给定消息指示级别的日志记录
 *
 * void entering(String className, String methodName)
 * void entering(String className, String methodName, Object param)
 * void entering(String className, String methodName, Object[] param)
 * void exiting(String className, String methodName)
 * void exiting(String className, String methodName, Object result)
 * 记录一个描述进入/退出方法的日志记录，其中应该包括给定参数和返回值
 *
 * void throwing(String className, String methodName, Throwable t)
 * 记录一个描停抛出给定异常对象的日志记录
 *
 * void log(Level level, String message)
 * void log(Level level, String message, Object obj)
 * void log(Level level, String message, Object[] objs)
 * void log(Level level, String message, Throwable t)
 * 记录一个给定级别和消息的日志记录，其中可以包括对象或者可抛出对象，要想包括对象，消息中必须包含格式化占位符{0}、{1}等
 *
 * void logp(Level level, String className, String methodName, String message)
 * void logp(Level level, String className, String methodName, String message, Object obj)
 * void logp(Level level, String className, String methodName, String message, Object[] objs)
 * void logp(Level level, String className, String methodName, String message, Throwable t)
 * 记录一个给定级别、准确的调用者信息和消息的日志记录，其中可以包括对象或可抛出对象
 *
 * void logrb(Level level, String className, String methodName, String bundleName, String message)
 * void logrb(Level level, String className, String methodName, String bundleName, String message, Object obj)
 * void logrb(Level level, String className, String methodName, String bundleName, String message, Object[] objs)
 * void logrb(Level level, String className, String methodName, String bundleName, String message, Throwable t)
 * 记录一个给定级别、准确的调用者信息、资源包名和消息的日志记录，其中可以包括对象或可抛出对象
 *
 *
 *
 *
 ***/