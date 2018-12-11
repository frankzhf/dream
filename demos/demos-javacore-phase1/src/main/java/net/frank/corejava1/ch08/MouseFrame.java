package net.frank.corejava1.ch08;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class MouseFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8958460600506762872L;

	public MouseFrame() {
		add(new MouseComponent());
		pack();
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame frame = new MouseFrame();
				frame.setTitle("MouseFrame");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}

		});
	}
}

class MouseComponent extends JComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7695060594230789006L;
	private static final int DEFAULT_WIDTH = 400;
	private static final int DEFAULT_HEIGHT = 300;

	private static final int SIDE_LENGTH = 10;
	private ArrayList<Rectangle2D> squares;
	private Rectangle2D current;

	public MouseComponent() {
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		squares = new ArrayList<Rectangle2D>();
		current = null;
		MouseHandler handler = new MouseHandler();
		addMouseListener(handler);
		addMouseMotionListener(handler);//如果要启用 moved,dragged,wheelMoved,必须增加 MouseMotionListener
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		for (Rectangle2D r : squares) {
			g2.draw(r);
		}
	}

	public Rectangle2D find(Point2D p) {
		for (Rectangle2D r : squares) {
			if (r.contains(p)) {
				return r;
			}
		}
		return null;
	}

	public void add(Point2D p) {
		double x = p.getX();
		double y = p.getY();
		current = new Rectangle2D.Double(x - SIDE_LENGTH / 2, y - SIDE_LENGTH / 2, SIDE_LENGTH, SIDE_LENGTH);
		squares.add(current);
		repaint();
	}

	public void remove(Rectangle2D s) {
		if (s == null) {
			return;
		}
		if (s == current) {
			current = null;
		}
		squares.remove(s);
		repaint();
	}

	private class MouseHandler extends MouseAdapter {

		public void mousePressed(MouseEvent event) {
			current = find(event.getPoint());
			if (current == null) {
				add(event.getPoint());
			}
		}

		public void mouseClicked(MouseEvent event) {
			current = find(event.getPoint());
			if (current != null && event.getClickCount() >= 2) {
				remove(current);
			}
		}

		public void mouseMoved(MouseEvent event) {
			if(find(event.getPoint()) ==null ) {
				setCursor(Cursor.getDefaultCursor());
			}else {
				setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
			}
		}

		public void mouseDragged(MouseEvent event) {
			if(current != null) {
				int x= event.getX();
				int y= event.getY();
				current.setFrame(x-SIDE_LENGTH/2,y-SIDE_LENGTH/2,SIDE_LENGTH,SIDE_LENGTH);
				repaint();
			}
		}
	}
}
/***
 * java.awt.event.MouseEvent
 * int getX()
 * int getY()
 * Point getPoint()
 * 返回事件发生时，事件源组件左上角的坐标X（水平）和Y（竖直），或点信息
 * 
 * int getClickCount()
 * 返回与事件关联的鼠标连击次数
 * 
 * java.awt.event.InputEvent
 * int getModifiersEx()
 * 返回事件扩展的或“按下”的修饰符
 * BUTTON1_DOWN_MASK
 * BUTTON2_DOWN_MASK
 * BUTTON3_DOWN_MASK
 * SHIFT_DOWN_MASK
 * CTRL_DOWN_MASK
 * ALT_DOWN_MASK
 * ALT_GRAPH_DOWN_MASK
 * META_DOWN_MASK
 * 
 * static String getModifiersExText(int modifiers)
 * 返回用给定的标志集描述的扩展或按下的修饰符字符串
 * 
 * java.awt.Toolkit
 * Cursor createCustomCursor(Image image, Point hotSpot, String name)
 * 创建一个新的定制光标对象
 * 
 * java.awt.Component
 * void setCursor(Cursor cursor)
 * 用光标图像设置给定光标
 * 
 * 语义事件
 * ActionEvent
 * AdjustmentEvent
 * ItemEvent
 * 
 * 低级事件
 * KeyEvent
 * MouseEvent
 * MouseWheelEvent
 * FocusEvent
 * WindowEvent
 * 
 * 事件处理总结
 * 接口					方法						参数/访问方法					事件源
 * ActionListener		actionPerformed			ActionEvent					AbstractButton
 * 													getActionCommand		JComboBox JTextField
 * 													getModifiers			Timer
 * 
 * AdjustmentListener	adjustmentValueChanged	AdjustmentEvent				JScrollbar
 * 													getAdjustable
 * 													getAdjustmentType
 * 													getValue
 * 
 * ItemListener			itemStateChanged		ItemEvent					AbstractButton
 * 													getItem					JComboBox
 * 													getItemSelectable
 * 													getStateChange
 * 
 * FocusListener		focusGained				FocusEvent					Component
 * 						focusLost					isTemporary
 * 
 * KeyListener			keyPressed				KeyEvent					Component
 * 						keyReleased					getKeyChar
 * 						keyTyped					getKeyCode
 * 													getKeyModifiersText
 * 													getKeyText
 * 													isActionKey
 * 
 * MouseListener		mousePressed			MouseEvent					Component
 * 						mouseReleased				getClickCount
 * 						mouseEntered				getX
 * 						mouseExited					getY
 * 						mouseChicked				getPoint
 * 													translatePoint
 * 
 * MouseMotionListener	mouseDragged			MouseEvent					Component
 * 						mouseMoved
 * 
 * MouseWheelListener	mouseWheelMoved			MouseWheelEvent				Component
 * 													getWheelRotation
 * 													getScrollAmount
 * 
 * WindowListener		windowClosing			WindowEvent					Window
 * 						windowOpened				getWindow
 * 						windowIconified
 * 						windowDeiconified
 * 						windowClosed
 * 						windowActivated
 * 						windowDeactivated
 * 
 * WindowFocusListener	windowGainedFocus		WindowEvent					Window
 * 						windowLostFocus				getOppositeWindow
 * 
 * WindowStateListener	windowStateChanged		WindowEvent					Window
 * 													getOldState
 * 													getNewState
 * 
 */	