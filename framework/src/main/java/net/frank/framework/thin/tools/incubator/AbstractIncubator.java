package net.frank.framework.thin.tools.incubator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import net.frank.commons.CommonConstants;
import net.frank.framework.thin.tools.model.TableData;

public abstract class AbstractIncubator extends Thread{
	
	public static final String FILE_EXT = ".java";
	
	private File folder;
	
	private TableData tableData;
	
	private String packageName;
	
	public AbstractIncubator(File folder, String packageName, TableData tableData){
		this.folder = folder;
		this.packageName = packageName;
		this.tableData = tableData;
	}
	
	@Override
	public void run(){
		FileWriter fw = null;
		try{
			String fileName = getFileName(tableData);
			StringBuffer filePath = new StringBuffer(CommonConstants.DEFAULT_STRING_BUFFER_LENGTH);
			filePath.append(folder.getAbsolutePath()).append(File.separator).append(fileName);
			File beanFile = new File(filePath.toString());
			if(!beanFile.exists()){
				beanFile.createNewFile();
			}
			fw = new FileWriter(beanFile);
			String fileContent = getFileContent(packageName, tableData);
			fw.write(fileContent);
			fw.flush();
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try{
				if(fw!=null){
					fw.close();
				}
			}catch(IOException e){
				
			}
		}
	}
	
	public abstract String getFileName(TableData tableData);
	
	public abstract String getFileContent(String packageName, TableData tableData);
	
}
