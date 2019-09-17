package net.frank.corejava1.ch11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuggyButtonTest {

    public static void main(String[] args){
        EventQueue.invokeLater(()->{
            JFrame frame = new BuggyButtonFrame();
            frame.setTitle("BuggyButtonTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class BuggyButtonFrame extends JFrame{
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    public BuggyButtonFrame(){
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
        BuggyButtonPanel panel = new BuggyButtonPanel();
        add(panel);
    }
}

class BuggyButtonPanel extends JPanel{
    public BuggyButtonPanel(){
        ActionListener listener = new ButtonListener();
        JButton yellowButton = new JButton("Yellow");
        yellowButton.addActionListener(listener);

        JButton blueButton = new JButton("Blue");
        blueButton.addActionListener(listener);

        JButton redButton = new JButton("Red");
        redButton.addActionListener(listener);

        add(yellowButton);
        add(blueButton);
        add(redButton);
    }


    private class  ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            String arg = event.getActionCommand();
            if(arg.equals("Yellow")){
                setBackground(Color.YELLOW);
            }else if(arg.equals("Blue")){
                setBackground(Color.BLUE);
            }else if(arg.equals("Red")){
                setBackground(Color.RED);
            }
        }
    }

}
