package net.frank.titian.util;

import java.sql.Connection;

public final class ConnectionHolder {

    private static ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal<Connection>();

    public static Connection getConnection() {
        Connection connection = connectionThreadLocal.get();
        if(connection==null){
            connection = SQLiteUtil.getConnection();
            connectionThreadLocal.set(connection);
        }
        return connection;
    }

    public static  void initConnection() {
        connectionThreadLocal.set(SQLiteUtil.getConnection());
    }
    public static  void removeConnection() {
        Connection connection = getConnection();
        SQLiteUtil.closeConnection(connection);
        connectionThreadLocal.remove();
    }
}
