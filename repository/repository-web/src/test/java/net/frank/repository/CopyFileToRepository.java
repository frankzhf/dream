package net.frank.repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import net.frank.repository.CommonConstants;
import net.frank.repository.service.FileRepositoryService;
import net.frank.framework.TestInitCase;
import net.frank.framework.bo.Resource;
import net.frank.repository.service.ServiceNames;


public class CopyFileToRepository extends TestInitCase {
	
	private static final String SRC = "D:/projects/newstars/documents/SR";
	
	private static final String REPOSITORY_IMPORT = "/import";
	
	private FileRepositoryService fileRepositoryService;
	
	@Override
	public String[] getSpringConfig() {
		return new String[] {
				"classpath:applicationContext-datasource.xml",
				"classpath:applicationContext-base.xml",
				"classpath:applicationContext-dao.xml",
				"classpath:applicationContext-service.xml",
				"classpath:applicationContext-repository.xml"};
	}

	public void testInitProject(){
		fileRepositoryService = (FileRepositoryService) getBean(ServiceNames.REPOSITORY_FILE_SERVICE);
		File file = new File(SRC);
		if(!file.exists()){
			logger.info("Path is invalid");
			return;
		}
		Resource parent = queryService.getResourceAsPath(REPOSITORY_IMPORT);
		if(file.isFile()){
			processFile(file,parent);
		}else{
			processfolder(file,parent);
		}
	}

	private void processfolder(File file,Resource parent) {
		Resource folder = new Resource();
		folder.setActive(Boolean.TRUE);
		folder.setSystemNode(Boolean.FALSE);
		folder.setTypeId(CommonConstants.TYPE.RESOURCE);
		folder.setParentId(parent.getId());
		folder.setAlias(file.getName());
		folder.setOwnResourceId(cs.getAccount().getResource().getId());
		folder.setOwnGroupResourceId(cs.getCurrentGroup().getResource().getId());
		folder.setCurrentAccountPermission(CommonConstants.PERMISSION_GROUP.PRIVATE.CURRENT_ACCOUNT);
		folder.setCurrentGroupPermission(CommonConstants.PERMISSION_GROUP.PRIVATE.CURRENT_GROUP);
		folder.setOthersPermission(CommonConstants.PERMISSION_GROUP.PRIVATE.OTHERS);
		resourceService.saveOrUpdateResource(folder, cs);
		File[] children = file.listFiles();
		if(children!=null && children.length>0){
			for(int i=0;i<children.length;i++){
				File child = children[i];
				if(child.isFile()){
					processFile(child,folder);
				}else{
					processfolder(child,folder);
				}
			}
		}
	}

	private void processFile(File file,Resource parent) {
		FileInputStream fis = null;
		try{
			fis = new FileInputStream(file);
			fileRepositoryService.createFile(parent, file.getName(), fis.available(), fis, cs,false);
		}catch(IOException ioe){
			ioe.printStackTrace();
		}finally{
			try{
				if(fis!=null){
					fis.close();
					fis = null;
				}
			}catch(IOException ioe){
				ioe.printStackTrace();
			}
		}
	}
	
	
	
}