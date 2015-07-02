package net.frank.framework.bo;

import java.util.Date;

public final class Staff extends BusinessObject{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8055409876951080250L;

	private static final String ICON_PATH = "/global/images/xloadtree2b/staff_icon.jpg";
	
	private String staffId;
	
	private Date startDate;
	
	private Date effectiveDate;
	
	private Boolean inProbation;
	
	private Date probationEnd;
	
	private String sitePhone;
	
	private String email;
	
	private Date terminationDate;
	
	private Boolean serviceAgency;
	
	private Boolean temperary;
	
	private Boolean expatriate;
	
	private String passportNumber;
	
	private Date visaExpire;
	
	private String nationality;
	
	private Resource person$15=new Resource();
	
	private Resource context$3=new Resource();

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public Boolean getInProbation() {
		return inProbation;
	}

	public void setInProbation(Boolean inProbation) {
		this.inProbation = inProbation;
	}

	public Date getProbationEnd() {
		return probationEnd;
	}

	public void setProbationEnd(Date probationEnd) {
		this.probationEnd = probationEnd;
	}

	public String getSitePhone() {
		return sitePhone;
	}

	public void setSitePhone(String sitePhone) {
		this.sitePhone = sitePhone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getTerminationDate() {
		return terminationDate;
	}

	public void setTerminationDate(Date terminationDate) {
		this.terminationDate = terminationDate;
	}

	public Boolean getServiceAgency() {
		return serviceAgency;
	}

	public void setServiceAgency(Boolean serviceAgency) {
		this.serviceAgency = serviceAgency;
	}

	public Boolean getTemperary() {
		return temperary;
	}

	public void setTemperary(Boolean temperary) {
		this.temperary = temperary;
	}

	public Boolean getExpatriate() {
		return expatriate;
	}

	public void setExpatriate(Boolean expatriate) {
		this.expatriate = expatriate;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public Date getVisaExpire() {
		return visaExpire;
	}

	public void setVisaExpire(Date visaExpire) {
		this.visaExpire = visaExpire;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public Resource getPerson$15() {
		return person$15;
	}

	public void setPerson$15(Resource person$15) {
		this.person$15 = person$15;
	}

	public Resource getContext$3() {
		return context$3;
	}

	public void setContext$3(Resource context$3) {
		this.context$3 = context$3;
	}
	
	@Override
	public String getNodeIcon() {
		return ICON_PATH;
	}
	
	@Override
	public String getNodeOpenIcon() {
		return ICON_PATH;
	}
}
