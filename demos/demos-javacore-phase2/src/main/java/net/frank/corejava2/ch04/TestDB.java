package net.frank.corejava2.ch04;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class TestDB {

    public static void main(String[] args){
        try{
            runTest();
        }catch (SQLException  e){
            for(Throwable t: e){
                t.printStackTrace();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void runTest()throws SQLException, IOException {
        Connection conn = getConnection();
        try{
            Statement stat = conn.createStatement();
            stat.executeUpdate("CREATE TABLE Greetings (Message CHAR(20))");
            stat.executeUpdate("INSERT INTO Greetings VALUES('Hello, World!')");
            ResultSet result = stat.executeQuery("SELECT *  FROM Greetings");
            if(result.next()){
                System.out.println(result.getString(1));
            }
            result.close();
            stat.executeUpdate("DROP TABLE Greetings");
        }finally {
            conn.close();
        }
    }

    public static Connection getConnection()throws SQLException, IOException{
        Properties props = new Properties();
        FileInputStream in = new FileInputStream("/Users/zhaofeng/git/dream/demos/demos-javacore-phase2/src/main/resources/database.properties");
        props.load(in);
        in.close();
        String drivers = props.getProperty("jdbc.drivers");
        if(drivers!=null){
            System.setProperty("jdbc.drivers", drivers);
        }
        String url = props.getProperty("jdbc.url");
        //String username = props.getProperty("jdbc.username");
        //String password = props.getProperty("jdbc.password");
        return DriverManager.getConnection(url);
    }

}
/****
 * java.sql.DriverManager
 * static Connectiion getConnction(String url, String user, String password)
 * 建立一个指定数据库的连接，并返回一个Connection对象
 *
 * java.sql.Connection
 * Statement createStatement()
 * 创建一个Statement对象，用以执行不带参数的SQL查询和更新
 *
 * void close()
 * 用于立即关闭当前连接以及释放由它所创建的jdbc资源
 *
 * java.sql.Statement
 * ResultSet executeQuery(String sqlQuery)
 * 执行给定字符串指定的SQL语句，并返回一个用于查看查询结果的ResultSet对象
 *
 * int executeUpdate(String sqlStatement)
 * 执行字符串中指定的INSERT，UPDATE或DELETE等SQL语句。还可以执行数据定义语言的语句。返回受影响的记录总数，如果是没有更新计数的语句，则返回-1
 *
 * boolean execute(String sqlStatement)
 * 执行字符串中指定的SQL语句。可能会产生多个结果和更新数。如果第一个执行结果是结果集，则返回true;反之，返回false.调用getResultSet或getUpdateCount方法可以得到第一个执行结果。
 *
 * ResultSet getResultSet()
 * 返回前一条查询语句的结果集。如果前一条语句未更产生结果集，则返回null值。对于每一条执行过的语句，该方法只能被调用一次。
 *
 * int getUpdateCount()
 * 返回前一条更新语句影响的行数。如果前一条语句未更新数据库，则返回-1。对于每一条执行的语句，该方法只能被调一次。
 *
 * void close()
 * 关闭statement对象及它所对应的结果集
 *
 * boolean isClosed()
 * 如果语句被关闭，则返回true
 *
 * java.sql.ResultSet
 * boolean next()
 * 将结果集中的当前行向前移动一行。如果已经到达最后一行的后面，则返回false。注意，初始情况下必须调用该方法才能转到第一行。
 *
 * Xxx getXxx(int columnNumber)
 * Xxx getXxx(String columnName)
 * Xxx指数据类型。如 int,double, String,Date
 * 用给定的列序号或标签返回该列的值，并将值转成指定的类型。列标签是SQL的AS子语中指定的标签，在没有使用AS时，它就是列名
 *
 * int findColumn(String columnName)
 * 根据指定的列名，返回该列的序号
 *
 * void close()
 * 立即关闭当前的结果集。
 *
 * boolean isClosed()
 * 如果结果集被关闭时，则返回true
 *
 * java.sql.SQLException
 * SQLException getNextException()
 * 返回链接到该SQL异常的下一个SQL异常，或者在达到链尾时返回null
 *
 * Iterator<Throwable> iterator()
 * 获取迭代器，可以迭代链接的SQL异常和它的成因
 *
 * String getSQLState()
 * 获取SQL状态，即标准化的错误代码
 *
 * int getErrorCode()
 * 获取提供商相关的错误代码
 *
 * java.sql.Warning
 * SQLWarning getNextWarning()
 * 返回链接到该警告的下一个警告，或者在到达链尾时返回null
 *
 * java.sql.Connection
 * java.sql.Statement
 * java.sql.ResultSet
 * SQLWarning getWarnings()
 * 返回未处理警告的第一个，或者在没有未处理警告时返回null
 *
 * java.sql.DataTruncation
 * boolean getParameter()
 * 如果参数上进行了数据截断，则返回true,如果列上进行了数据截断，则返回false
 *
 * int getIndex()
 * 被截断的参数和列的索引
 *
 * int getDataSize()
 * 返回应该被传输的字节数量，或者在该值未知的情况下返回-1
 *
 * int getTransferSize()
 * 返回实际被传输的字节数量，或者在该值未知的情况下返回-1
 *
 **/