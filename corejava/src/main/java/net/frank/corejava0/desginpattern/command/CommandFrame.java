package net.frank.corejava0.desginpattern.command;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

import net.frank.corejava0.desginpattern.command.define.Command;
import net.frank.corejava0.desginpattern.command.impl.DrawCanvas;
import net.frank.corejava0.desginpattern.command.impl.DrawCommand;
import net.frank.corejava0.desginpattern.command.impl.MacroCommand;

public class CommandFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 705107203044230909L;
	private MacroCommand history = new MacroCommand();
	private DrawCanvas canvas = new DrawCanvas(400,400,history);
	
	private JButton clearButton = new JButton("Clear");
	
	public CommandFrame(String title) {
		super(title);
		setSize(420,450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		clearButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				history.clear();
				canvas.repaint();
			}
			
		});
		canvas.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent e) {
				Command cmd = new DrawCommand(canvas,e.getPoint());
				history.append(cmd);
				cmd.execute();
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				
			}
			
		});
		
		Box buttonBox = new Box(BoxLayout.X_AXIS);
		buttonBox.add(clearButton);
		
		Box mainBox = new Box(BoxLayout.Y_AXIS);
		mainBox.add(buttonBox);
		mainBox.add(canvas);
		
		getContentPane().add(mainBox);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				JFrame commandFrame = new CommandFrame("Command Pattern Sample");
				commandFrame.setVisible(true);
			}
			
		});
	}
	
}
