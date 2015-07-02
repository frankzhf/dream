package net.frank.framework.navigation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alex.Kwan
 * @version 1.0 Date 2002-8-1
 */
public class Menu {
	private String title;

	private String name;

	private String path;

	private boolean shortcut;

	private String image;
	
	private String permission;

	private Menu parent;

	private List<Menu> children;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getPath() {
		return path;
	}

	public boolean isShortcut() {
		return shortcut;
	}

	public void setShortcut(boolean shortcut) {
		this.shortcut = shortcut;
	}

	public void setParent(Menu parent) {
		this.parent = parent;
	}

	public Menu getParent() {
		return parent;
	}

	public void addChild(Menu child) {
		if (child != null) {
			ensureChildrenList();
			children.add(child);
			child.setParent(this);
		}
	}

	public List<Menu> getChildren() {
		ensureChildrenList();
		return children;
	}

	public boolean canUserView(String userName) {
		/**
		 * todo: cooperated with security syste to judge whether to show this
		 * menu to user;
		 */
		return true;
	}

	private void ensureChildrenList() {
		if (children == null) {
			children = new ArrayList<Menu>();
		}
	}

	/**
	 * Returns the image.
	 * 
	 * @return String
	 */
	public String getImage() {
		return image;
	}

	/**
	 * Sets the image.
	 * 
	 * @param image
	 *            The image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}

	/**
	 * @return Returns the title.
	 */
	public String getTitle() {
		if (title==null){
			return name;
		}
		return title;
	}

	/**
	 * @param title
	 *            The title to set.
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}
}