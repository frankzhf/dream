package net.frank.repository.service;

import java.io.InputStream;
import java.io.OutputStream;

import net.frank.repository.bo.File;
import net.frank.framework.bo.Resource;
import net.frank.framework.security.Session;

public interface FileRepositoryService {

	public Integer mkdir(Resource parent, String name, Session cs);

	public Integer remove(Resource parent, String name, Session cs);

	public Integer rename(Resource parent, String oldName, String newName,
			Session cs);
	
	public Integer createFile(Resource parent, String fileName, Integer length,
			InputStream content, Session cs );
	
	public Integer createFile(Resource parent, String fileName, Integer length,
			InputStream content, Session cs , boolean checkFileSize);

	public Integer updateFile(Resource parent, String fileName,
			InputStream content, Session cs);

	public Integer moveFile(Resource oldParent, String fileName,
			Resource newParent, Session cs, boolean clone);

	public Integer deleteFile(File file, Session cs);

	public Integer getFileContent(File file, OutputStream context, Session cs);

	public Integer shareFileWithUnit(Resource file, Resource Unit, String desc, boolean clone, Session cs);
}