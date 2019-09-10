package net.frank.corejava1.ch10;

import net.frank.corejava1.ch09.CalculatorPanel;

import javax.jnlp.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.beans.EventHandler;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class CalculatorFrameTest {

    public static void main(String[] args){
        EventQueue.invokeLater(()->{
            JFrame frame = new CalculatorFrame();
            frame.setTitle("CalculatorFrame");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class CalculatorFrame extends JFrame{
    private CalculatorPanel panel;

    public CalculatorFrame(){
        setTitle();
        panel = new CalculatorPanel();
        add(panel);

        JMenu fileMenu = new JMenu("File");
        JMenuBar menuBar= new JMenuBar();
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);

        JMenuItem openItem = fileMenu.add("Open");
        openItem.addActionListener(EventHandler.create(ActionListener.class,this,"open"));
        JMenuItem saveItem = fileMenu.add("Save");
        saveItem.addActionListener(EventHandler.create(ActionListener.class,this,"save"));

        pack();

    }

    public void setTitle(){
        try{
            String title = null;
            BasicService basic = (BasicService) ServiceManager.lookup("javax.jnlp.BasicService");
            URL codeBase = basic.getCodeBase();
            PersistenceService service = (PersistenceService)
                    ServiceManager.lookup("javax.jnlp.PersistenceService");

            URL key = new URL(codeBase, "title");
            try{
                FileContents contents = service.get(key);

            }catch(FileNotFoundException e){
                title = JOptionPane.showInputDialog("Please supply a frame title:");
                if(title == null){
                    return;
                }
                service.create(key,100);
                FileContents contents = service.get(key);
                OutputStream out = contents.getOutputStream(true);
                PrintStream printOut = new PrintStream(out);
                printOut.print(title);
            }
            setTitle(title);
        }catch (UnavailableServiceException e){
            JOptionPane.showMessageDialog(this,e);
        }catch(MalformedURLException e) {
            JOptionPane.showMessageDialog(this, e);
        }catch(IOException e){
            JOptionPane.showMessageDialog(this,e);
        }
    }

    public void open(){
        try{
            FileOpenService service = (FileOpenService) ServiceManager
                    .lookup("javax.jnlp.FileOpenService");
            FileContents contents = service.openFileDialog(".",new String[] {"txt"});

            JOptionPane.showMessageDialog(this,contents.getName());
            if(contents!=null){
                InputStream in = contents.getInputStream();
                BufferedReader reader = new BufferedReader((new InputStreamReader(in)));
                String line;
                while((line = reader.readLine()) != null) {
                    //每读到一行，就在计算结果的多行文本框里加一行并回车
                }
            }
        }catch (UnavailableServiceException e){
            JOptionPane.showMessageDialog(this,e);
        }catch(IOException e){
            JOptionPane.showMessageDialog(this,e);
        }
    }

    public void save(){
        try{
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            PrintStream printOut = new PrintStream(out);
            //printOut.print(); 从多行文本框中读取内容
            InputStream data = new ByteArrayInputStream(out.toByteArray());
            FileSaveService service = (FileSaveService) ServiceManager.
                    lookup("javax.jnlp.FileSaveService");
            service.saveFileDialog(".",new String[]{"txt"},data,"calc.txt");
        }catch (UnavailableServiceException e){
            JOptionPane.showMessageDialog(this,e);
        }catch(IOException e){
            JOptionPane.showMessageDialog(this,e);
        }
    }
}
