package net.frank.framework.web.spring;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import net.frank.framework.bo.BusinessObject;
import net.frank.framework.bo.IForm;
import net.frank.framework.bo.Resource;
import net.frank.framework.bo.Type;
import net.frank.framework.web.security.AuthenticatorHolder;

public class CmsForm implements IForm {

	private Resource resource = new Resource();

	private Map<Long, BusinessObject> contentMap = new HashMap<Long, BusinessObject>();

	private Map<Integer, Boolean> permissionMap = new HashMap<Integer, Boolean>();

	private Map<String, MultipartFile> updateFilesMap = new HashMap<String, MultipartFile>();

	public CmsForm() throws InstantiationException, IllegalAccessException,
			ClassNotFoundException {
		Map<Long, Type> typeContent = AuthenticatorHolder.getClientSession()
				.getUserTypeMap();
		for (Iterator<Long> it = typeContent.keySet().iterator(); it.hasNext();) {
			Long key = it.next();
			Object o = Class.forName(typeContent.get(key).getEntityClassName())
					.newInstance();
			if (o instanceof BusinessObject) {
				BusinessObject bo = (BusinessObject) o;
				bo.setForm(this);
				contentMap.put(key, bo);
			}

		}
		for (int i = 0; i < 9; i++) {
			permissionMap.put(i, new Boolean(false));
		}
	}
	
	public void setContent(String key, BusinessObject obj) {
		Long _key = Long.decode(key);
		contentMap.put(_key, obj);
	}

	public BusinessObject getContent(String key) {
		Long _key = Long.decode(key);
		return contentMap.get(_key);
	}
	
	public void setContentMap(Map<Long, BusinessObject> contentMap){
		this.contentMap = contentMap;
	}
	
	public Map<Long,BusinessObject> getContentMap(){
		return contentMap;
	}
	
	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}
	
	@Override
	public InputStream convertInputStream(String fieldName) throws IOException {
		MultipartFile formFile = getUpdateFile(fieldName);
		if (formFile != null) {
			return formFile.getInputStream();
		}
		return null;
	}

	@Override
	public Map<Integer, Boolean> getPermissionMap() {
		return permissionMap;
	}

	@Override
	public void setPermissionMap(Map<Integer, Boolean> permissionMap) {
		this.permissionMap = permissionMap;
	}

	@Override
	public Boolean getPermission(String key) {
		Integer _key = Integer.decode(key);
		return permissionMap.get(_key);
	}

	@Override
	public void setPermission(String key, Boolean obj) {
		Integer _key = Integer.decode(key);
		permissionMap.put(_key, obj);
	}

	public void setUpdateFilesMap(Map<String, MultipartFile> updateFilesMap) {
		this.updateFilesMap = updateFilesMap;
	}

	public Map<String, MultipartFile> getUpdateFilesMap() {
		return updateFilesMap;
	}

	public void setUpdateFile(String key, MultipartFile obj) {
		updateFilesMap.put(key, obj);
	}

	public MultipartFile getUpdateFile(String key) {
		return updateFilesMap.get(key);
	}
}
