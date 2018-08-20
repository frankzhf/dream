package net.frank.titian.base;


import org.slf4j.Logger;

import net.frank.titian.define.Ant;

public abstract class AbstractAnt implements Ant {

	protected Logger log;
	
	protected String workspace;
	
	@Override
	public void setLog(Logger log) {
		this.log = log;
	}
	
	@Override
	public void setWorkspace(String workspace){
		this.workspace = workspace;
	}
	
	

}
