package net.frank.repository.web.forms;

import net.frank.framework.bo.Resource;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

public class RepositoryForm extends ActionForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7435319100558007051L;

	private Resource folder;
	
	private Resource file;
	
	private Resource unit;
	
	private Resource staff;
	
	private FormFile uploadFile;

	public Resource getFolder() {
		if(folder == null){
			folder = new Resource();
		}
		return folder;
	}

	public void setFolder(Resource folder) {
		this.folder = folder;
	}

	public FormFile getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(FormFile uploadFile) {
		this.uploadFile = uploadFile;
	}

	public Resource getFile() {
		if(file==null){
			file = new Resource();
		}
		return file;
	}

	public void setFile(Resource file) {
		this.file = file;
	}

	public Resource getStaff() {
		if(staff == null){
			staff = new Resource();
		}
		return staff;
	}

	public void setStaff(Resource staff) {
		this.staff = staff;
	}

	public Resource getUnit() {
		if(unit == null){
			unit = new Resource();
		}
		return unit;
	}

	public void setUnit(Resource unit) {
		this.unit = unit;
	}
}
