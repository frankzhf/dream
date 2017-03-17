package net.frank.titian.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.frank.titian.entity.UserStoreEntity;

public final class SQLiteUtil {
	private static Log log = LogFactory.getLog(SQLiteUtil.class);
	

	public static void main(String[] args) {
		Connection conn = getConnection();
		createUserStoreMappingTable(conn);
		insertRecord(conn, "retailer1", "user1", "store1", "order");
		isUserStoreMapExist(conn, "retailer1", "user1", "store1", "order");
	}

	private static boolean isUserStoreMapExist(Connection conn,
			String retailerID, String userID, String storeID, String dataType) {
		boolean isExist = false;
		try {
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt
					.executeQuery("select * from user_store where retailer_id='"
							+ retailerID
							+ "' and  user_id='"
							+ userID
							+ "' and  data_type='"
							+ dataType
							+ "' and store_id = '" + storeID + "'");
			if (rs.next()) {
				isExist = true;
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			log.error(e.getMessage(),e);
		}
		return isExist;
	}

	public static List<UserStoreEntity> getAllUserStoreMappingTO(
			Connection conn) {
		List<UserStoreEntity> userStoreMappingTOList = new ArrayList<UserStoreEntity>();
		try {
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery("select * from user_store;");
			while (rs.next()) {
				UserStoreEntity userStoreMappingTO = new UserStoreEntity();
				userStoreMappingTO.setRetailerId(rs.getString(1));
				userStoreMappingTO.setUserId(rs.getString(2));
				userStoreMappingTO.setStoreId(rs.getString(3));
				userStoreMappingTO.setDataType(rs.getString(4));
				if (rs.getString(5) != null) {
					userStoreMappingTO.setUrl(rs.getString(5));
				}
				userStoreMappingTOList.add(userStoreMappingTO);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			log.error(e.getMessage(),e);
		}
		return userStoreMappingTOList;
	}

	public static Connection getConnection(){
		try {
			Class.forName("org.sqlite.JDBC");
			return DriverManager.getConnection("jdbc:sqlite:" + PropertiesUtil.getBatchProperties().getProperty("local.sqlite.path"));
		} catch (ClassNotFoundException e) {
			log.error(e.getMessage(),e);
		} catch (SQLException e) {
			log.error(e.getMessage(),e);
		}
		return null;

	}

	public static void closeConnection(Connection connection) {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			log.error(e.getMessage(),e);
		}

	}

	public static void createUserStoreMappingTable(Connection conn) {
		try {
			dropTable(conn, "user_store");
		} catch (Exception e) {
			log.error("Table is not exist.");
		}
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("create table user_store(retailer_id varchar(20), user_id varchar(20), store_id varchar(20), data_type varchar(20),url varchar(50));"); // 创建一个表，两列
			stmt.close();
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		}
	}

	public static void insertRecord(Connection conn, String retailerID,
			String userID, String storeID, String dataType){

		try {
			if (isUserStoreMapExist(conn, retailerID, userID, storeID, dataType)) {
				return;
			}
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("insert into user_store values('" + retailerID
					+ "','" + userID + "','" + storeID + "','" + dataType
					+ "','');");// 插入数据
			stmt.close();
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		}
	}

	public static void insertRecordForHualian(Connection conn,
			String retailerID, String userID, String storeID, String dataType,
			String url)  {
		try {
			if (isUserStoreMapExist(conn, retailerID, userID, storeID, dataType)) {
				return;
			}
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("insert into user_store values('" + retailerID
					+ "','" + userID + "','" + storeID + "','" + dataType
					+ "','" + url + "');");// 插入数据
			stmt.close();
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		}
	}
	
	public static void dropTable(Connection conn, String tableName) {
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("drop table " + tableName + ";"); // 创建一个表，两列
			stmt.close();
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		}
	}

}
