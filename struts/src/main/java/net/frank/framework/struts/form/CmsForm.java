package net.frank.framework.struts.form;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.frank.framework.bo.BaseEntity;
import net.frank.framework.bo.IForm;
import net.frank.framework.bo.Resource;
import net.frank.framework.bo.Type;
import net.frank.framework.service.CacheService;
import net.frank.framework.service.ServiceNames;
import net.frank.framework.spring.SpringContextHolder;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

public class CmsForm extends ActionForm implements IForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5114225423747747619L;

	private Resource resource = new Resource();

	private Map<Long, Object> contentMap = new HashMap<Long, Object>();

	private List<Resource> listResource = new ArrayList<Resource>();

	private Map<Integer, Boolean> permissionMap = new HashMap<Integer, Boolean>();

	private Map<String, FormFile> updateFilesMap = new HashMap<String, FormFile>();

	public Map<Integer, Boolean> getPermissionMap() {
		return permissionMap;
	}

	public void setPermissionMap(Map<Integer, Boolean> permissionMap) {
		this.permissionMap = permissionMap;
	}

	public Boolean getPermission(String key) {
		Integer _key = Integer.decode(key);
		return permissionMap.get(_key);
	}

	public void setPermission(String key, Boolean obj) {
		Integer _key = Integer.decode(key);
		permissionMap.put(_key, obj);
	}

	

	public CmsForm() throws InstantiationException, IllegalAccessException,
			ClassNotFoundException {
		CacheService cacheService = (CacheService) SpringContextHolder
				.getApplicationContext().getBean(ServiceNames.CACHE_SERVICE);
		Map<Long, Type> typeContent = cacheService.getTypeContent();
		for (Iterator<Long> it = typeContent.keySet().iterator(); it.hasNext();) {
			Long key = it.next();
			Object o = Class.forName(typeContent.get(key).getEntityClassName())
					.newInstance();
			if (o instanceof BaseEntity) {
				BaseEntity bo = (BaseEntity) o;
				bo.setForm(this);
			}
			contentMap.put(key, o);
		}
		for (int i = 0; i < 9; i++) {
			permissionMap.put(i, new Boolean(false));
		}
	}

	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	public Map<Long, Object> getContentMap() {
		return contentMap;
	}

	public void setContentMap(Map<Long, Object> contentMap) {
		this.contentMap = contentMap;
	}

	public void setContent(String key, Object obj) {
		Long _key = Long.decode(key);
		contentMap.put(_key, obj);
	}

	public Object getContent(String key) {
		Long _key = Long.decode(key);
		return contentMap.get(_key);
	}

	public List<Resource> getListResource() {
		return listResource;
	}

	public void setListResource(List<Resource> listResource) {
		this.listResource = listResource;
	}

	public void setChild(int index, Resource resource) {
		while (listResource.size() <= index) {
			listResource.add(new Resource());
		}
		listResource.set(index, resource);
	}

	public Resource getChild(int index) {
		while (listResource.size() <= index) {
			listResource.add(new Resource());
		}
		return listResource.get(index);
	}

	@Override
	public InputStream convertInputStream(String fieldName) throws IOException {
		FormFile formFile = getUpdateFile(fieldName);
		if (formFile != null) {
			return formFile.getInputStream();
		}
		return null;
	}

	public void setUpdateFile(String key, FormFile obj) {
		updateFilesMap.put(key, obj);
	}

	public FormFile getUpdateFile(String key) {
		return updateFilesMap.get(key);
	}

	public void setUpdateFilesMap(Map<String, FormFile> updateFilesMap) {
		this.updateFilesMap = updateFilesMap;
	}

	public Map<String, FormFile> getUpdateFilesMap() {
		return updateFilesMap;
	}

}
