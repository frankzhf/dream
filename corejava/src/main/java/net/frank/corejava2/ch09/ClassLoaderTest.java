package net.frank.corejava2.ch09;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import net.frank.corejava2.GBC;

public class ClassLoaderTest {
	public static void main(String[] args) {
		
	}
}

class ClassLoaderFrame extends JFrame{
	
	private JTextField keyField = new JTextField("3",4);
	private JTextField nameField = new JTextField("Calculator",30);
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 200;
	
	
	public ClassLoaderFrame(){
		setTitle("ClassLoaderTest");
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		setLayout(new GridBagLayout());
		add(new JLabel("Class"),new GBC(0,0).setAnchor(GBC.EAST));
		add(nameField,new GBC(1,0).setWeight(100,0).setAnchor(GBC.WEST));
		add(new JLabel("Key"),new GBC(1,0).setAnchor(GBC.EAST));
		add(keyField,new GBC(1,1).setWeight(100,0).setAnchor(GBC.WEST));
		JButton loadButton = new JButton("Load");
		add(loadButton, new GBC(0,2,2,1));
		loadButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				runClass(nameField.getText(),keyField.getText());
			}	
		});
		pack();
	}
	
	private void runClass(String name,String key){
		try{
			ClassLoader loader = new CryptoClassLoader(Integer.parseInt(key));
			Class<?> c = loader.loadClass(name);
			Method m = c.getMethod("main", String[].class);
			m.invoke(null, (Object) new String[]{});
		}catch(Throwable e){
			JOptionPane.showMessageDialog(this, e);
		}
	}
}

class CryptoClassLoader extends ClassLoader{
	
	private int key;
	
	public CryptoClassLoader(int key){
		this.key = key;
	}
	
	protected Class<?> findClass(String name)throws ClassNotFoundException{
		byte[] classBytes = null;
		try{
			classBytes = loadClassBytes(name);
		}catch(IOException e){
			
		}
		return null;
	}
	
	private byte[] loadClassBytes(String name) throws IOException{
		String cname = name.replace(".", "/") + ".caesar";
		FileInputStream in = null;
		ByteArrayOutputStream buffer = null;
		try{
			in = new FileInputStream(cname);
			buffer = new ByteArrayOutputStream();
			int ch;
			while((ch=in.read())!=-1){
				byte b = (byte) (ch - key);
				buffer.write(b);
			}
			return buffer.toByteArray();
		}finally{
			buffer.close();
			in.close();
		}
	}
	
}


