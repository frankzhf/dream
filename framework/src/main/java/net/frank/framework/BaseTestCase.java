package net.frank.framework;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import net.frank.commons.CommonConstants;
import net.frank.framework.bo.Resource;
import net.frank.framework.spring.SpringContextHolder;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.TestCase;

public abstract class BaseTestCase extends TestCase {
	protected Log logger = LogFactory.getLog(getClass());
	private ApplicationContext context = null;
	protected Map<String, Resource> resMap = new HashMap<String, Resource>();

	protected static Byte ACCOUNT_PERMISSION = 7;

	protected static Byte GROUP_PERMISSION = 4;

	protected static Byte OTHERS_PERMISSION = 4;

	public abstract String[] getSpringConfig();

	public Object getBean(String beanId) {
		return context.getBean(beanId);
	}

	@Override
	public void setUp() {
		context = new ClassPathXmlApplicationContext(getSpringConfig());
		SpringContextHolder.setApplicationContext(context);
	}

	@Override
	public void tearDown() throws Exception {
	}

	protected String getCurrentWorkSpackPath() {
		File currentFolder = new File(CommonConstants.EMPTY_STRING);
		return currentFolder.getAbsolutePath();
	}

	protected String getSqlClientCommand(String dbDialect, String username,
			String password, String databaseName, String sqlFile) {
		// mysql -u${username} -p${password} -D${databaseName}<${sqlFile}
		String commandLine = null;
		FileReader fr = null;
		BufferedReader br = null;
		try{
			String aliasUsername = "${username}";
			String aliasPassword = "${password}";
			String aliasDatabaseName = "${databaseName}";
			String aliasSqlFile = "${sqlFile}";
	
			String workspacePath = getCurrentWorkSpackPath();
			String commandPath = workspacePath + File.separator
					+ "src/main/init-sql/" + dbDialect + "/command";
			
			try{
				fr = new FileReader(commandPath);
				br = new BufferedReader(fr);
				commandLine = br.readLine();
				commandLine = commandLine.replace(aliasUsername, username);
				commandLine = commandLine.replace(aliasPassword, password);
				commandLine = commandLine.replace(aliasDatabaseName, databaseName);
				commandLine = commandLine.replace(aliasSqlFile, sqlFile);
			}catch(FileNotFoundException e){
				
			}catch(IOException e){
				
			}
			logger.info("commandLine = "+commandLine);
		}finally{
			try{
				if(fr!=null)
					fr.close();
			}catch(IOException e){
				
			}
		}
		return commandLine;
	}
	
	
	
}