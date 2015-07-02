package org.activiti.engine.impl.persistence.bean;

import java.io.Serializable;

public class Lane implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1113472910325448450L;

	private String id;

	private String name;

	protected int x = -1;
	protected int y = -1;
	protected int width = -1;
	protected int height = -1;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	
	
}
