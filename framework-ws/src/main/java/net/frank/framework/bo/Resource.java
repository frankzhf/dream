package net.frank.framework.bo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.frank.framework.bo.BaseEntity;
import net.frank.framework.bo.BusinessObject;

public class Resource extends BaseEntity implements Cloneable {
	
	public static final Long RESOURCE_TYPE_ID = 3L;
	/**
	 * 
	 */
	private static final long serialVersionUID = -2418303372195756907L;

	private Long parentId;

	private String alias;

	private Long typeId;

	private Boolean active = Boolean.FALSE;

	private Boolean systemNode = Boolean.FALSE;

	private Long ownResourceId;

	private Long ownGroupResourceId;

	private Date createdDt;

	private Long lastAccountResourceId;

	private Date lastUpdatedDt;

	private Byte currentAccountPermission;

	private Byte currentGroupPermission;

	private Byte othersPermission;

	// none ORM field
	private BusinessObject object;
	private List<Resource> children;
	private Boolean privilege  = Boolean.FALSE;
	private Integer code;
	
	public Resource(){
		
	}
	
	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Boolean getSystemNode() {
		return systemNode;
	}

	public void setSystemNode(Boolean systemNode) {
		this.systemNode = systemNode;
	}

	public Long getOwnResourceId() {
		return ownResourceId;
	}

	public void setOwnResourceId(Long ownResourceId) {
		this.ownResourceId = ownResourceId;
	}

	public Long getOwnGroupResourceId() {
		return ownGroupResourceId;
	}

	public void setOwnGroupResourceId(Long ownGroupResourceId) {
		this.ownGroupResourceId = ownGroupResourceId;
	}

	public Date getCreatedDt() {
		return createdDt;
	}

	public void setCreatedDt(Date createdDt) {
		this.createdDt = createdDt;
	}

	public Long getLastAccountResourceId() {
		return lastAccountResourceId;
	}

	public void setLastAccountResourceId(Long lastAccountResourceId) {
		this.lastAccountResourceId = lastAccountResourceId;
	}

	public Date getLastUpdatedDt() {
		return lastUpdatedDt;
	}

	public void setLastUpdatedDt(Date lastUpdatedDt) {
		this.lastUpdatedDt = lastUpdatedDt;
	}

	public Byte getCurrentAccountPermission() {
		return currentAccountPermission;
	}

	public void setCurrentAccountPermission(Byte currentAccountPermission) {
		this.currentAccountPermission = currentAccountPermission;
	}

	public Byte getCurrentGroupPermission() {
		return currentGroupPermission;
	}

	public void setCurrentGroupPermission(Byte currentGroupPermission) {
		this.currentGroupPermission = currentGroupPermission;
	}

	public Byte getOthersPermission() {
		return othersPermission;
	}

	public void setOthersPermission(Byte othersPermission) {
		this.othersPermission = othersPermission;
	}

	public BusinessObject getObject() {
		return object;
	}

	public void setObject(BusinessObject object) {
		this.object = object;
	}

	public List<Resource> getChildren() {
		return children;
	}

	public void setChildren(List<Resource> children) {
		this.children = children;
	}
	
	public void addChild(int index,Resource child){
		if(children == null){
			children = new ArrayList<Resource>();
		}
		while(children.size()<=index){
			children.add(new Resource());
		}
		children.set(index, child);
	}
	

	@Override
	public Resource clone() {
		Object cloneObject =null;
		try {
			cloneObject= super.clone();
		} catch (CloneNotSupportedException e) {
			log.debug("Resource.clone error.");
			e.printStackTrace();
		}
		return cloneObject instanceof Resource ? (Resource)cloneObject : null;
	}

	public Boolean getPrivilege() {
		return privilege;
	}

	public void setPrivilege(Boolean privilege) {
		this.privilege = privilege;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}

}
