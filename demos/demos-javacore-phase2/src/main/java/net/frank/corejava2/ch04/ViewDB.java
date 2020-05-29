package net.frank.corejava2.ch04;

import com.sun.rowset.CachedRowSetImpl;

import javax.sql.RowSet;
import javax.sql.RowSetEvent;
import javax.sql.RowSetListener;
import javax.sql.RowSetMetaData;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetWarning;
import javax.sql.rowset.spi.SyncProvider;
import javax.sql.rowset.spi.SyncProviderException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.sql.Date;
import java.util.*;
import java.util.List;

public class ViewDB {

    public static void main(String[] args){
        EventQueue.invokeLater(()->{
            JFrame frame = new ViewDBFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class ViewDBFrame extends JFrame{

    public static final int DEFAULT_WIDTH = 400;
    public static final int DEFAULT_HEIGHT = 200;

    private JButton previousButton;
    private JButton nextButton;
    private JButton deleteButton;
    private JButton saveButton;
    private DataPanel dataPanel;
    private Component scrollPane;
    private JComboBox<String> tableNames;
    private Properties props;
    private CachedRowSet crs;

    public ViewDBFrame(){
        setTitle("ViewDB");
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
        tableNames = new JComboBox<>();
        tableNames.addActionListener(event ->
                showTable(((String)tableNames.getSelectedItem())));
        add(tableNames,BorderLayout.NORTH);
        try{
            readDatabaseProperties();
            Connection conn = getConnection();
            try{
                DatabaseMetaData meta = conn.getMetaData();
                ResultSet mrs = meta.getTables(null,null,
                        null, new String[]{"TABLE"});
                while(mrs.next()){
                    tableNames.addItem(mrs.getString(3));
                }
            }finally {
                conn.close();
            }
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(this,e);
        }catch (IOException e) {
            JOptionPane.showMessageDialog(this,e);
        }

        JPanel buttonPanel = new JPanel();
        add(buttonPanel,BorderLayout.SOUTH);

        previousButton = new JButton("Previous");
        previousButton.addActionListener(event-> showPreviousRow());
        buttonPanel.add(previousButton);

        nextButton = new JButton("Next");
        nextButton.addActionListener(event-> showNextRow());
        buttonPanel.add(nextButton);

        deleteButton = new JButton("Delete");
        deleteButton.addActionListener(event-> deleteRow());
        buttonPanel.add(deleteButton);

        saveButton = new JButton("Save");
        saveButton.addActionListener(event-> saveChanges());
        buttonPanel.add(saveButton);
    }


    private void showTable(String tableName){
        try{
            Connection conn = getConnection();
            try{
                Statement stat = conn.createStatement();
                ResultSet result = stat.executeQuery("SELECT * FROM " + tableName);
                crs = new CachedRowSetImpl();
                crs.setTableName(tableName);
                crs.populate(result);
            }finally {
                conn.close();
            }

            if(scrollPane!=null){
                remove(scrollPane);
            }
            dataPanel = new DataPanel(crs);
            scrollPane = new JScrollPane(dataPanel);
            add(scrollPane,BorderLayout.CENTER);
            validate();
            showNextRow();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(this,e);
        }






    }

    private void showPreviousRow(){
        try{
            if(crs==null || crs.isFirst()){
                return;
            }
            crs.previous();
            dataPanel.showRow(crs);

        }catch (SQLException e){
            for(Throwable t: e){
                t.printStackTrace();
            }
        }
    }

    private void showNextRow(){
        try{
            if(crs == null || crs.isLast()){
                return;
            }
            crs.next();
            dataPanel.showRow(crs);
        }catch (SQLException e){
            for(Throwable t:e){
                t.printStackTrace();
            }
        }
    }

    private void deleteRow(){
        try{
            Connection conn = getConnection();
            try{
                crs.deleteRow();
                crs.acceptChanges(conn);
                if(!crs.isLast()){
                    crs.next();
                }else if(!crs.isFirst()){
                    crs.previous();
                }else{
                    crs = null;
                }
                dataPanel.showRow(crs);
            }finally {
                conn.close();
            }

        }catch (SQLException e){
            JOptionPane.showMessageDialog(this,e);
        }
    }

    private void saveChanges(){
        try{
            Connection conn = getConnection();
            try{
                dataPanel.setRow(crs);
                crs.acceptChanges(conn);
            }finally {
                conn.close();
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(this,e);
        }
    }

    private void readDatabaseProperties()throws IOException{
        props = new Properties();
        InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("database.properties");
        props.load(in);
        in.close();
        String drivers = props.getProperty("jdbc.drivers");
        if(drivers!=null){
            System.setProperty("jdbc.drivers",drivers);
        }
    }

    private Connection getConnection()throws SQLException{
        String url = props.getProperty("jdbc.url");
        return DriverManager.getConnection(url);
    }

}

class DataPanel extends JPanel{
    private List<JTextField> fields;

    public DataPanel(RowSet rs) throws SQLException{
        fields = new ArrayList<>();
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = 1;
        gbc.gridheight = 1;

        ResultSetMetaData rsMetaData = rs.getMetaData();
        for(int i=1;i <= rsMetaData.getColumnCount();i++){
            gbc.gridy = i-1;
            String columnName = rsMetaData.getColumnName(i);
            gbc.gridx = 0;
            gbc.anchor = GridBagConstraints.EAST;
            add(new Label(columnName), gbc);
            int columnWidth = rsMetaData.getColumnDisplaySize(i);
            JTextField tb = new JTextField(columnWidth);
            if(!rsMetaData.getColumnClassName(i).equals("java.lang.String")){
                tb.setEditable(false);
            }
            fields.add(tb);
            gbc.gridx = 1;
            gbc.anchor = GridBagConstraints.WEST;
            add(tb,gbc);
        }
    }

    public void showRow(ResultSet rs)throws SQLException{
        for(int i=1;i<=fields.size();i++){
            String field = rs.getString(i);
            JTextField tb = fields.get(i-1);
            tb.setText(field);
        }
    }

    public void setRow(RowSet rs) throws SQLException{
        for(int i=1;i<=fields.size();i++){
            String field = rs.getString(i);
            JTextField tb = fields.get(i-1);
            if(!field.equals(tb.getText())){
                rs.updateString(i,tb.getText());
            }
            rs.updateRow();
        }
    }

    /**
     * java.sql.Connection
     * DatabaseMetaData getMetaData()
     * 返加一个DatabaseMetaData，该对象封装了有关数据库连接的元数据
     *
     * java.sql.DatabaseMetaData
     * ResultSet getTables(String catalog, String schemaPattern, String tableNamePattern, String type[])
     * 返回描述记录集
     *
     * int getJDBCMajorVersion()
     * int getJDBCMinorVersion()
     * 返回JDBC主版本和次版本号
     *
     * int getMaxConnections()
     * 返回可同时连接到数据库的最大连接数
     *
     * int getMaxStatements()
     * 返回单个数据库连接允许同时打开的最大语句数。0表示没有限制或不可知
     *
     * java.sql.ResultSet
     * ResultSetMetaData getMetaData()
     * 返回与当前记录集对象中的列相关的元数据
     *
     * java.sql.ResultSetMetaData
     * int getColumnCount()
     * 返回列数
     *
     * int getColumnDisplaySize(int column)
     * 返回给定列序号的列的最大宽度
     *
     * String getColumnLabel(int column)
     * 返回该列的别名
     *
     * String getColumnName(int column)
     * 返回指定的列序号所对应的列名
     *
     */
}