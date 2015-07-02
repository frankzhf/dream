package net.frank.android.handle;

import java.io.Serializable;

import net.frank.android.hook.Hook;

public abstract class DropListHandle implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6166967073787724936L;

	private Integer id;
	
	private Hook hook;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Hook getHook() {
		return hook;
	}

	public void setHook(Hook hook) {
		this.hook = hook;
	}
}
