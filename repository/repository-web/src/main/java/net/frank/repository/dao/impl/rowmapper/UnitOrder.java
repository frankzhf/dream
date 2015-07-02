package net.frank.repository.dao.impl.rowmapper;

import java.util.HashMap;
import java.util.Map;

public class UnitOrder implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4094332018154018620L;
	private Long resourceId;
	private Long id;
	private Long parentId;
	private Map<Long,UnitOrder> children = new HashMap<Long,UnitOrder>();
	
	public Long getResourceId() {
		return resourceId;
	}
	public void setResourceId(Long resourceId) {
		this.resourceId = resourceId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	public Map<Long,UnitOrder> getChildren(){
		return children;
	}
	
	public void addChild(UnitOrder child){
		children.put(child.getId(), child);
	}
}
