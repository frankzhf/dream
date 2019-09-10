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
}
