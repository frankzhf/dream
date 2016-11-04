package net.frank.framework.thin.tools;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

import net.frank.commons.CommonConstants;
import net.frank.commons.util.StringUtil;
import net.frank.framework.hibernate.dialect.MysqlDialect;
import net.frank.framework.thin.tools.incubator.BeanIncubator;
import net.frank.framework.thin.tools.incubator.RenderIncubator;
import net.frank.framework.thin.tools.incubator.RowmapperIncubator;
import net.frank.framework.thin.tools.model.Column;
import net.frank.framework.thin.tools.model.TableData;

public final class SoaGenerater {
	
	private static final String DEFAULT_BEAN = "bean";
	private static final String DEFAULT_ROWMAPPER = "rowmapper";
	private static final String DEFAULT_RENDER = "render";
	
	public static void main(String[] args) throws Exception{
		String jdbcClassName,jdbcConnectUrl,jdbcUser,jdbcPassword,projectRoot,projectPackage;
		if(args!=null && args.length>0){
			jdbcClassName = args[0];
			jdbcConnectUrl = args[1];
			jdbcUser = args[2];
			jdbcPassword = args[3];
			projectRoot = args[4];
			projectPackage = args[5];
		}else{
			jdbcClassName="com.mysql.jdbc.Driver";
			jdbcConnectUrl = "jdbc:mysql://localhost:3306/dede";
			jdbcUser = "root";
			jdbcPassword = "zhf!@#618825";
			projectRoot = "/Users/zhaofeng/Desktop/thin";
			projectPackage = "net.frank.dede";
		}
		
		File workspace = new File(projectRoot);
		if(!workspace.exists()){
			workspace.mkdirs();
		}else{
			workspace.deleteOnExit();
			workspace.mkdirs();
		}
		
		StringBuffer projectFolderPath = new StringBuffer(CommonConstants.SHORT_STRING_BUFFER_LENGTH);
		projectFolderPath.append(projectRoot);
		StringTokenizer st = new StringTokenizer(projectPackage,CommonConstants.POINT);
		while(st.hasMoreElements()){
			projectFolderPath.append(File.separator).append(st.nextToken());
		}
		
		File projectFolder = new File(projectFolderPath.toString()); 
		projectFolder.mkdirs();
		
		String beanPath = projectFolderPath.toString() + File.separator + DEFAULT_BEAN;
		File beanFolder = new File(beanPath);
		beanFolder.mkdir();
		
		String rowmapperPath = projectFolderPath.toString() + File.separator + DEFAULT_ROWMAPPER;
		File rowmapperFolder = new File(rowmapperPath);
		rowmapperFolder.mkdir();
		
		String renderPath = projectFolderPath.toString() + File.separator + DEFAULT_RENDER;
		File renderFolder = new File(renderPath);
		renderFolder.mkdir();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Map<String,TableData> tableMap = new HashMap<String,TableData>();
		try{
			Class.forName(jdbcClassName);
			conn = DriverManager.getConnection(jdbcConnectUrl,jdbcUser,jdbcPassword);
			rs =conn.getMetaData().getColumns("dede", null, null,null);
			MysqlDialect mysqlDialect = new MysqlDialect();
			while(rs.next()){
				String tableName = rs.getString("TABLE_NAME");
				if(tableMap.get(tableName)==null){
					TableData tableData = new TableData();
					tableData.setTableName(tableName);
					tableData.setJavaClassName(StringUtil.table2class(tableName));
					tableMap.put(tableName, tableData);
				}
				TableData currentTableData = tableMap.get(tableName);
				if(currentTableData.getColumnList() == null){
					currentTableData.setColumnList(new ArrayList<Column>());
				}
				String columnName = rs.getString("COLUMN_NAME");
				int columnSize = rs.getInt("COLUMN_SIZE");
				String columnType = mysqlDialect.getJavaClass(rs.getInt("DATA_TYPE"),columnSize).getName();
				if("[C".equals(columnType)){
					columnType = "char[]";
				}else if("[B".equals(columnType)){
					columnType = "byte[]";
				}
				Column currentColumn = new Column();
				currentColumn.setColumnName(columnName);
				currentColumn.setColumnType(columnType);
				currentTableData.getColumnList().add(currentColumn);
			}
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				if(rs!=null){
					rs.close();
				}
				if(stmt!=null){
					stmt.close();
				}
				if(conn!=null){
					conn.close();
				}
			}catch(SQLException e){
				
			}
		}
		
		StringBuffer spring0 = new StringBuffer();
		StringBuffer spring1 = new StringBuffer();
		
		for(Iterator<String> it=tableMap.keySet().iterator();it.hasNext();){
			String key = it.next();
			TableData tableData = tableMap.get(key);
			String packageName = projectPackage + CommonConstants.POINT +DEFAULT_BEAN;
			new BeanIncubator(beanFolder, packageName, tableData).start();
			packageName = projectPackage + CommonConstants.POINT +DEFAULT_RENDER;
			new RenderIncubator(renderFolder, packageName, tableData).start();
			packageName = projectPackage + CommonConstants.POINT +DEFAULT_ROWMAPPER;
			new RowmapperIncubator(rowmapperFolder, packageName, tableData).start();
			
			spring0.append(CommonConstants.STRING_TAB).append("<bean id=\"").
				append(StringUtil.lowerFirstChar(tableData.getJavaClassName())).
				append("Render\" class=\"").append(projectPackage).append(CommonConstants.POINT).
				append(DEFAULT_RENDER).append(CommonConstants.POINT).append(tableData.getJavaClassName()).append("Render").
				append("\" autowire=\"byName\"/>").append(CommonConstants.STRING_ENTER).
				append(CommonConstants.STRING_ENTER);
			
			/**
			 * <entry key="net.frank.dede.bean.DedeAddonarticle" value-ref="dedeAddonarticleRender" />
			 */
			spring1.append(CommonConstants.STRING_TAB).append(CommonConstants.STRING_TAB).
				append(CommonConstants.STRING_TAB).append(CommonConstants.STRING_TAB).
				append("<entry key=\"").append(projectPackage).append(CommonConstants.POINT).
				append(DEFAULT_BEAN).append(CommonConstants.POINT).append(tableData.getJavaClassName()).
				append("\" value-ref=\"").append(StringUtil.lowerFirstChar(tableData.getJavaClassName())).
				append("Render\" />").append(CommonConstants.STRING_ENTER);
		}
		System.out.println("===================Render Define====================");
		System.out.println(spring0.toString());
		System.out.println("===================Render Map====================");
		System.out.println(spring1.toString());
		
		
	}
	
}
