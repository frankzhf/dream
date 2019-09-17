package net.frank.corejava1.ch11;

import net.frank.corejava1.ch08.ButtonFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class RobotTest {


    public static void main(String[] args){
        EventQueue.invokeLater(()->{
            ButtonFrame frame = new ButtonFrame();
            frame.setTitle("ButtonTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });

        GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice screen = environment.getDefaultScreenDevice();

        try{
            final Robot robot = new Robot(screen);
            robot.waitForIdle();
            new Thread(()->{
                runTest(robot);
            }).start();


        }catch(AWTException e){

        }

    }

    public static void runTest(Robot robot){
        robot.keyPress(' ');
        robot.keyRelease(' ');

        robot.delay(2000);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);

        robot.keyPress(' ');
        robot.keyRelease(' ');

        robot.delay(2000);
        robot.mouseMove(200,40);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);

        robot.delay(2000);
        BufferedImage image = robot.createScreenCapture(new Rectangle(0,0,400,300));

        ImageFrame frame = new ImageFrame(image);
        frame.setVisible(true);
    }

    static class ImageFrame extends JFrame{
        private static final int DEFAULT_WIDTH = 450;
        private static final int DEFAULT_HEIGHT = 350;

        public ImageFrame(Image image){
            setTitle("Capture");
            setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
            JLabel label = new JLabel(new ImageIcon(image));
            add(label);
        }
    }

    /***
     *  java.awt.GraphicsEnvironment
     *  static GraphicsEnvironment getLocalGraphicsEnvironment()
     *  返回本地图形环境
     *
     *  GraphicsDevice getDefaultScreenDevice()
     *  返回默认的屏幕设备。通过getScreenDevices方法可以得到一个保存所有屏幕设备的数组
     *
     *  java.awt.Robot
     *  Robot(GraphicsDevice device)
     *  构造一个能够与给定设备交互的机器人
     *
     *  void keyPress(int key)
     *  void keyRelease(int key)
     *  模拟按键与释放
     *
     *  void mouseMove(int x, int y)
     *  模拟移动鼠标到指定的x,y座标
     *
     *  void mousePress(int eventMask)
     *  void mouseRelease(int eventMask)
     *  模拟鼠标按键与释放
     *
     *  void delay(milliseconds)
     *  模拟迟延
     *
     *  BufferedImage createScreenCapture(Rectangle rect)
     *  截取屏幕一部分
     *
     */


}
