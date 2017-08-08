package net.frank.dduo.smart.core.entity;

import java.io.Serializable;

public class PoolConfig implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8956633396586957722L;
	private int numProcessThreads = 3;
	private int lowWaterMark = numProcessThreads * 10;
	public int getNumProcessThreads() {
		return numProcessThreads;
	}
	public void setNumProcessThreads(int numProcessThreads) {
		this.numProcessThreads = numProcessThreads;
	}
	public int getLowWaterMark() {
		return lowWaterMark;
	}
	public void setLowWaterMark(int lowWaterMark) {
		this.lowWaterMark = lowWaterMark;
	}
	@Override
	public String toString() {
		return "PoolConfig [numProcessThreads=" + numProcessThreads + ", lowWaterMark=" + lowWaterMark + "]";
	}
	
	
}