package net.frank.cms.web.common.forms;

import net.frank.framework.bo.Resource;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

public class UpdateImageForm extends ActionForm {
	
	private static final long serialVersionUID = -4097741905067875270L;
	
	private int firstPointX;
	
	private int firstPointY;
	
	private int secondPointX;
	
	private int secondPointY;
	
	private Resource resource = new Resource();
	
	private Boolean chkSplit = Boolean.FALSE;
	
	private FormFile updatedFile;

	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	public FormFile getUpdatedFile() {
		return updatedFile;
	}

	public void setUpdatedFile(FormFile updatedFile) {
		this.updatedFile = updatedFile;
	}

	public int getFirstPointX() {
		return firstPointX;
	}

	public void setFirstPointX(int firstPointX) {
		this.firstPointX = firstPointX;
	}

	public int getFirstPointY() {
		return firstPointY;
	}

	public void setFirstPointY(int firstPointY) {
		this.firstPointY = firstPointY;
	}

	public int getSecondPointX() {
		return secondPointX;
	}

	public void setSecondPointX(int secondPointX) {
		this.secondPointX = secondPointX;
	}

	public int getSecondPointY() {
		return secondPointY;
	}

	public void setSecondPointY(int secondPointY) {
		this.secondPointY = secondPointY;
	}

	public Boolean getChkSplit() {
		return chkSplit;
	}

	public void setChkSplit(Boolean chkSplit) {
		this.chkSplit = chkSplit;
	}
	
}
