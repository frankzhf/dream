package net.frank.repository.bo;

import net.frank.framework.bo.BusinessObject;

public final class File extends BusinessObject {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4233985920407437643L;

	private String fileName;
	
	private Integer length;
	
	private String reponsitoryName;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getReponsitoryName() {
		return reponsitoryName;
	}

	public void setReponsitoryName(String reponsitoryName) {
		this.reponsitoryName = reponsitoryName;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}
}