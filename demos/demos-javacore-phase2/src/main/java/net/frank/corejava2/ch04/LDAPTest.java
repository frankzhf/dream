package net.frank.corejava2.ch04;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;
import java.util.Properties;

public class LDAPTest {

    public static void main(String[] args){
        EventQueue.invokeLater(()->{
            JFrame frame = new LDAPFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }

}


class LDAPFrame extends JFrame{

    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    private JButton findButton;

    private JButton saveButton;

    private JButton deleteButton;

    private JTextField uidField;

    private LdapDataPanel dataPanel;

    private Component scrollPane;

    private DirContext context;

    private String uid;

    private Attributes attrs;

    public LDAPFrame(){
        setTitle("LDAPTest");
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(1,2,3,1));
        northPanel.add(new JLabel("uid", SwingConstants.RIGHT));
        uidField = new JTextField();
        northPanel.add(uidField);
        add(northPanel,BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        add(buttonPanel, BorderLayout.SOUTH);

        findButton = new JButton("Find");
        findButton.addActionListener(event -> findEntry());
        buttonPanel.add(findButton);

        saveButton = new JButton("Save");
        saveButton.addActionListener(event -> saveEntry());
        buttonPanel.add(saveButton);

        deleteButton = new JButton("Delete");
        deleteButton.addActionListener(event -> deleteEntry());
        buttonPanel.add(deleteButton);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent event) {
                try{
                    if(context!=null){
                        context.close();
                    }
                }catch (NamingException e){
                    JOptionPane.showMessageDialog(event.getComponent(), e.getMessage());
                }
            }
        });

    }

    private void findEntry(){
        try{
            if(scrollPane!=null){
                remove(scrollPane);
            }
            String dn = "uid=" + uidField.getText() + ",ou=people,dc=mycompany,dc=com";
            if(context == null){
                context = getContext();
            }
            attrs = context.getAttributes(dn);
            dataPanel = new LdapDataPanel(attrs);
            scrollPane = new JScrollPane(dataPanel);
            add(scrollPane, BorderLayout.CENTER);
            validate();
            uid = uidField.getText();
        }catch(NamingException | IOException e){
            JOptionPane.showMessageDialog(this,e);
        }
    }

    private void saveEntry(){
        try{
            if(dataPanel == null){
                return;
            }
            if(context == null){
                context = getContext();
            }
            if(uidField.getText().equals(uid)){
                String dn = "uid=" +uid + ",ou=people,dc=mycompany,dc=com";
                Attributes editedAttrs = dataPanel.getEditedAttributes();
                NamingEnumeration<? extends Attribute> attrEnum = attrs.getAll();
                while (attrEnum.hasMore()){
                    Attribute attr = attrEnum.next();
                    String id = attr.getID();
                    Attribute editedAttr = editedAttrs.get(id);
                    if(editedAttr!=null
                            && !attr.get().equals(editedAttr.get())){
                        context.modifyAttributes(dn, DirContext.ADD_ATTRIBUTE,
                                new BasicAttributes(id,editedAttr.get()));
                    }
                }
            }else{
                String dn = "uid=" + uidField.getText() + ",ou=people,dc=mycompany,dc=com";
                attrs = dataPanel.getEditedAttributes();
                Attribute objClass = new BasicAttribute("objectClass");
                objClass.add("uidObject");
                objClass.add("person");
                attrs.put(objClass);
                attrs.put("uid",uidField.getText());
                context.createSubcontext(dn,attrs);
            }

        }catch (NamingException | IOException e){
            JOptionPane.showMessageDialog(this,e);
        }
        findEntry();
    }

    private void deleteEntry(){
        try{
            String dn = "uid" + uidField.getText() + ",ou=people,dc=mycompany,dc=com";
            if(context == null){
                context= getContext();
            }
            context.destroySubcontext(dn);
            uidField.setText("");
            remove(scrollPane);
            scrollPane = null;
            repaint();
        }catch (NamingException | IOException e){
            JOptionPane.showMessageDialog(this,e);
        }
    }

    private DirContext getContext()throws NamingException, IOException {
        Properties props = new Properties();
        InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("ldap.properties");
        props.load(in);
        in.close();

        String url = props.getProperty("ldap.url");
        String username = props.getProperty("ldap.username");
        String password = props.getProperty("ldap.password");

        Hashtable<String,String> env = new Hashtable<>();
        env.put(Context.SECURITY_PRINCIPAL,username);
        env.put(Context.SECURITY_CREDENTIALS,password);
        DirContext initial =  new InitialDirContext(env);
        DirContext context = (DirContext)initial.lookup(url);
        return context;
    }


}

class LdapDataPanel extends JPanel{

    public LdapDataPanel(Attributes attrs)throws NamingException{
        setLayout(new GridLayout(0,2,3,1));
        NamingEnumeration<? extends Attribute> attrEnum = attrs.getAll();
        while (attrEnum.hasMore()){
            Attribute attr = attrEnum.next();
            String id = attr.getID();
            NamingEnumeration<?> valueEnum = attr.getAll();
            while(valueEnum.hasMore()){
                Object value = valueEnum.next();
                if(id.equals("userPassword")){
                    value = new String((byte[]) value);
                }
                JLabel idLabel = new JLabel(id, SwingConstants.RIGHT);
                JTextField valueField = new JTextField(""+value);
                if(id.equals("objectClass")){
                    valueField.setEditable(false);
                }
                if(!id.equals("uid")){
                    add(idLabel);
                    add(valueField);
                }
            }
        }
    }

    public Attributes getEditedAttributes(){
        Attributes attrs = new BasicAttributes();
        for(int i=0;i<getComponentCount();i+=2){
            JLabel idLabel = (JLabel) getComponent(i);
            JTextField valueField = (JTextField) getComponent(i+1);
            String id = idLabel.getText();
            String value = valueField.getText();
            if(id.equals("userPassword")){
                attrs.put("userPassword",value.getBytes());
            }else if(!id.equals("") && !id.equals("objectClass")){
                attrs.put(id,value);
            }
        }
        return attrs;
    }

    /***
     * javax.naming.directory.InitialDirContext
     * InitialDirContext(Hashtable env)
     * 使用给定的环境设置创建一个目录上下文。
     *
     * javax.naming.Context
     * Object lookup(String name)
     * 使用给定的名称查找对象，返回值通常为一棵子树或一个叶对象
     *
     * Context createSubcontext(String name)
     * 使用给定的名称创建一个子上下文。它将成为该上下文的孩子。所有名称的路径构件，除了最一个之外都必须存在。
     *
     * void destroySubcontext(String name)
     * 根据给定的名称删除其对应上下文。
     *
     * void close()
     * 关闭该上下文
     *
     * javax.naming.directory.DirContext
     * Attributes getAttributes(String name)
     * 根据给定的名称，得到其对应条目的属性
     *
     * void modifyAttributes(String name, int flag, Attribute attr)
     * 根据给定的名称，修改其对应条目的属性
     *
     * javax.naming.directory.Attributes
     * Attribute get(String id)
     * 根据给定的ID，得到其对应的属性
     *
     * NamingEnumeration<? extends Attribute> getAll()
     * 返回一个枚举对象，用于迭代遍历属性的所有值
     *
     * Attribute put(Attribute attr)
     * Attribute put(String id, Object value)
     * 将属性添加到属性集合中
     *
     * javax.naming.directory.BasicAttributes
     * BasicAttributes(String id, Object value)
     * 使用给定的ID和值，构造一个属性集合，该集合只包括了单个属性
     *
     * javax.naming.directory.Attribute
     * String getID()
     * 获取该属性的ID
     *
     * Object get()
     * 如果值已经排好序，则获取该属性的第一个值。如果未排序，则返回其中任意一个值
     *
     * NamingEnumeration<?> getAll()
     * 返回一个枚举对象，用于迭代遍历该属性的所有值
     *
     * javax.naming.NamingEnumeration<T>
     * boolean hasMore()
     * 判断该对象还包含其他元素，则返回true
     *
     * T next()
     * 返回下一个元素
     *
     */


}
