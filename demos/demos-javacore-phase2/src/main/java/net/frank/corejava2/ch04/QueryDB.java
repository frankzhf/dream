package net.frank.corejava2.ch04;

import net.frank.corejava2.GBC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class QueryDB {

    public static void main(String[] args){
        EventQueue.invokeLater(()->{
            JFrame frame = new QueryDBFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }


}




class QueryDBFrame extends JFrame {

    private static final int DEFAULT_WIDTH = 400;
    private static final int DEFAULT_HEIGHT = 400;

    private static final String authorPublisherQuery = "SELECT Books.Price, Books.Title From Books, BooksAuthors, Authors, Publishers"
            + " WHERE Authors.Author_Id = BooksAuthors.Author_Id AND BooksAuthors.ISBN = Books.ISBN"
            + " AND Books.Publisher_Id = Publishers.Publisher_Id AND Authors.Name = ?"
            + " AND Publishers.Name = ?";

    private static final String authorQuery = "SELECT Books.Price, Books.Title FROM Books, BooksAuthors, Authors"
            + " WHERE Authors.Author_Id = BooksAuthors.Author_Id AND BooksAuthors.ISBN = Books.ISBN"
            + " AND Authors.Name = ?";

    private static final String publisherQuery = "SELECT Books.Price, Books.Title FROM Books, Publishers"
            + " WHERE Books.Publisher_Id = Publishers.Publisher_Id"
            + " And Publishers.Name = ?";

    private static final String allQuery = "SELECT Books.Price, Books.Title FROM Books";

    private static final String priceUpdate = "UPDATE Books "
            + "SET Price = Price +?"
            + " WHERE Books.Publisher_Id = (SELECT Publisher_Id FROM Publishers WHERE Name=?)";

    private JComboBox<String> authors;
    private JComboBox<String> publishers;
    private JTextField priceChange;
    private JTextArea result;
    private Connection conn;

    private PreparedStatement authorQueryStmt;
    private PreparedStatement authorPublisherQueryStmt;
    private PreparedStatement publisherQueryStmt;
    private PreparedStatement allQueryStmt;
    private PreparedStatement priceUpdateStmt;

    private static final String ANY = "Any";

    public QueryDBFrame(){
        setTitle("QueryDB");
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
        setLayout(new GridBagLayout());

        authors = new JComboBox<>();
        authors.setEditable(false);
        authors.addItem(ANY);

        publishers= new JComboBox();
        publishers.setEditable(false);
        publishers.addItem(ANY);

        result = new JTextArea(4,50);
        result.setEditable(false);

        priceChange = new JTextField(8);
        priceChange.setText("-5.00");

        try{
            conn = getConnection();
            Statement stat = conn.createStatement();
            String query = "SELECT Name FROM Authors";
            ResultSet rs = stat.executeQuery(query);
            while (rs.next()){
                authors.addItem(rs.getString(1));
            }

            query = "SELECT Name FROM Publishers";
            rs = stat.executeQuery(query);
            while (rs.next()){
                publishers.addItem(rs.getString(1));
            }
            rs.close();
            stat.close();
        }catch (SQLException e){
            for(Throwable t : e){
                result.append(t.getMessage());
            }
        }catch (IOException e){
            result.setText("" + e);
        }

        add(authors,new GBC(0,0,2,1));

        add(publishers,new GBC(2,0,2,1));

        JButton queryButton = new JButton("Query");

        queryButton.addActionListener(event->{
            executeQuery();
        });
        add(queryButton,new GBC(0,1,1,1).setInsets(3));

        JButton changeButton = new JButton("Change prices");
        changeButton.addActionListener(event->{
            changePrices();
        });
        add(changeButton,new GBC(2,1,1,1).setInsets(3));
        add(priceChange,new GBC(3,1,1,1).setFill(GBC.HORIZONTAL));

        add(new JScrollPane(result),new GBC(0,2,4,1).setFill(GBC.BOTH).setWeight(100,100));

        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent event){
                try{
                    if(conn!=null){
                        conn.close();
                    }
                }catch (SQLException e){
                    for(Throwable t : e){
                        t.printStackTrace();
                    }
                }
            }
        });
    }

    private void changePrices() {
        String publsher = (String) publishers.getSelectedItem();
        if(publsher.equals(ANY)){
            result.setText("I am sorry, but I cannot do that.");
            return;
        }
        try{
            if(priceUpdateStmt == null){
                priceUpdateStmt =conn.prepareStatement(priceUpdate);
            }
            priceUpdateStmt.setString(1,priceChange.getText());
            priceUpdateStmt.setString(2,publsher);
            int r = priceUpdateStmt.executeUpdate();
            result.setText(r + " records updated.");
        }catch (SQLException e){
            for(Throwable t : e){
                result.append(t.getMessage());
            }
        }
    }

    private void executeQuery(){
        ResultSet rs;
        try {
            String author = (String) authors.getSelectedItem();
            String publisher = (String) publishers.getSelectedItem();
            if (!author.equals(ANY) && !publisher.equals(ANY)) {
                if (authorPublisherQueryStmt == null) {
                    authorPublisherQueryStmt = conn.prepareStatement(authorPublisherQuery);
                }
                authorPublisherQueryStmt.setString(1,author);
                authorPublisherQueryStmt.setString(2,publisher);
                rs = authorPublisherQueryStmt.executeQuery();
            } else if (!author.equals(ANY) && publisher.equals(ANY)) {
                if(authorQueryStmt == null){
                    authorQueryStmt = conn.prepareStatement(authorQuery);
                }
                authorQueryStmt.setString(1,author);
                rs = authorQueryStmt.executeQuery();

            } else if (author.equals(ANY) && !publisher.equals(ANY)) {
                if(publisherQueryStmt == null){
                    publisherQueryStmt = conn.prepareStatement(publisherQuery);
                }
                publisherQueryStmt.setString(1,publisher);
                rs = publisherQueryStmt.executeQuery();
            } else {
                if(allQueryStmt == null){
                    allQueryStmt = conn.prepareStatement(allQuery);
                }
                rs = allQueryStmt.executeQuery();
            }
            result.setText("");
            while(rs.next()){
                result.append(rs.getString(1));
                result.append(",");
                result.append(rs.getString(2));
                result.append("\n");
            }
            rs.close();
        }catch(SQLException e){
            for(Throwable t: e){
                result.append(t.getMessage());
            }
        }

    }

    public static Connection getConnection()throws SQLException, IOException{
        Properties props = new Properties();
        InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("database.properties");
        props.load(in);
        in.close();
        String drivers = props.getProperty("jdbc.drivers");
        if(drivers!=null){
            System.setProperty("jdbc.drivers",drivers);
        }
        String url = props.getProperty("jdbc.url");
        return DriverManager.getConnection(url);
    }

    /***
     * java.sql.connection
     * PreparedStatement prepareStatement(String sql)
     * 返回一个含预编译语句的PreparedStatement对象。字符串sql代表一个SQL语句，该语句可以包含一个或多个由？字符指明的参数占位符
     *
     *
     * java.sql.PreparedStatement
     * void setXxx(int n, Xxx x)
     * 设置第n个参数值为x
     *
     * void clearParameters()
     * 清空预备语句中的所有当前参数
     *
     * ResultSet executeQuery()
     * 执行预备SQL查询，并返回一个ResultSet对象
     *
     * int executeUpdate()
     * 执行预备SQL语句INSERT、UPDATE、DELETE，返回在执行语句过程中所有受影响的记录总数。如果执行DD，返回0
     *
     *
     * java.sql.ResultSet
     * Blob getBlob(int columnIndex)
     * Blob getBlob(String columnLabel)
     * Clob getClob(int columnIndex)
     * Clob getClob(String cloumnLabel)
     * 获取给定列的BLOB或CLOB
     *
     * java.sql.Blob
     * long length()
     * 获取Blob的长度
     *
     * byte[] getBytes(long startPosition, long length)
     * 获取Blob给定范围的数据
     *
     * InputStream getBinaryStream()
     * InputStream getBinaryStream(long startPosition, long length)
     * 返回一个输入流，用于读取BLOB中的全部或给定范围的数据
     *
     * OutputStream setBinaryStream(long startPosition)
     * 返加一个输出流，用于从给定范围位置开始写入
     *
     *
     * java.sql.Clob
     * long length()
     * 获取Clob的长度
     *
     * String getSubString(long startPosition, long length)
     * 获取Clob给定范围的字符
     *
     * Reader getCharacterStream()
     * Reader getCharacterStream(long startPosition, long length)
     * 返回一个读入器，用于读取CLOB中全部或给定范围的数据
     *
     * Writer setCharacterStream()
     * 返回一个写出器，用于从给定位置开始写入
     *
     * java.sql.Connection
     * Blob createBlob()
     * Clob createClob()
     * 创建一个空的BLOB或CLOB
     *
     * java.sql.Statement
     * boolean getMoreResult()
     * 获取该语句的下一个结果集，如果存在下一个结果集，并且它确实是一个结果集，则返回true
     *
     *
     * java.sql.Statement
     * boolean execute(String statement, int autogenerated)
     * int executeUpdate(String statement, int autogenerated)
     * 如果autogenerated 被设置为Statement.RETURN_GENERATED_KEYS,并且该语句是一条INSERT语句，那么第一列就是自动生成的键
     *
     * java.sql.connection
     * Statement createStatement(int type, int concurrency)
     * PreparedStatement preparedStatement(String command, int type, int Concurrency)
     *
     *
     * java.sql.ResultSet
     * int getType()
     * 返回结果集类型。
     *
     * int getConcurrency()
     * 返回结果集并发设置
     *
     * boolean previous()
     * 移到前一行，如果位于某一行，则返回true,如果到头了，则返回false
     *
     * int getRow()
     * 得到当前行的序号，所有行从1开始
     *
     * boolean absolute(int r)
     * 移到到指定行，如果存在那一行，则返回true
     *
     * boolean relative(int d)
     * 以当前行为准备移动到d行，如果d为负数，则向后移动，存在，则返回true
     *
     *
     * boolean first()
     * boolean last()
     * 移动到第一行或最后一行
     *
     * void beforeFirst()
     * void afterLast()
     * 移动到第一行之前或最后一行之后
     *
     * boolean isFirst()
     * boolean isLast()
     * 判断是不是第一行或最后一行
     *
     * boolean isBeforeFirst()
     * boolean isAfterLast()
     * 判断是不是在第一行之前或最后一行之后
     *
     * void moveToInsertRow()
     * 在当前行插入一行
     *
     * void moveToCurrentRow()
     * 从插入行回到当前行
     *
     * void insertRow()
     * 将插入行上的内容插入到数据库和结果集
     *
     * void deleteRow()
     * 从数据库和结果集中删除当前行
     *
     * void UpdateXxx(int column, Xxx data)
     * void UpdateXxx(String columnName, Xxx data)
     * 更新某个字段的值
     *
     * void updateRow()
     * 将当前行的更新信息发送到数据库
     *
     * void cancelRowUpdates()
     * 撤销对当前的行的更新
     *
     * java.sql.DatabaseMetaData
     * boolean supportsResultSetType(int type)
     * 判断数据库是否支持给定的结果集，type是常量 TYPE_SCROLL_INSENSITIVE或 TYPE_SCROLL_SENSITIVE
     *                                       结果集可以滚动，但对数据库变化不敏感   结果集可以滚动，但对数据库变化敏感
     *
     * boolean supportsResultSetConcurrency(int type, int concurrency)
     * 判断数据库是否支持类型及并发模式
     * type         是常量 TYPE_SCROLL_INSENSITIVE或 TYPE_SCROLL_SENSITIVE
     * concurrency  是常量 CONCUR_READ_ONLY   CONCUR_UPDATABLE
     *
     *
     * javax.sql.RowSet
     * String getURL()
     * void setURL(String url)
     * 获取或设置数据库的url
     *
     * String getUsername()
     * void setUsername(String username)
     * 获取或设置连接数据库所需的用户名
     *
     * String getPassword()
     * void setPassword(String password)
     * 获取或设置连接数据库所需的密码
     *
     * String getCommand()
     * void setCommand(String command)
     * 获取或设置向行集中填充数据时所需要执行的命令
     *
     * void execute()
     * 执行命令来填充行集
     *
     * javax.sql.rowset.CacheRowSet
     * void execute(Connection conn)
     * 通过执行使用的setCommand方法设置的命令集来填充行集。该方法使用给定的连接，并负责关闭它
     *
     * void populate(ResultSet result)
     * 指定的结果集数据填充到被缓存的行集中
     *
     * String getTableName()
     * void setTableName(String tableName)
     * 获取或设置表名称
     *
     * int getPageSize()
     * void setPageSize(int pageSize)
     * 获取和设置页面的尺寸
     *
     * boolean nextPage()
     * boolean previousPage()
     * 加载下一页或上一页，如果页面存在，则返回true
     *
     * void acceptChanges()
     * void acceptChanges(Connection conn)
     * 重新连接数据库，并写回行集中修改过的数据
     *
     *
     */

}