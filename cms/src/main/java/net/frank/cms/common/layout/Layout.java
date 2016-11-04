package net.frank.cms.common.layout;

public class Layout implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4791083258711929953L;
	private Section north;
	private Section south;
	private Section west;
	private Section east;
	private Section center;
	public Section getNorth() {
		return north;
	}
	public void setNorth(Section north) {
		this.north = north;
	}
	public Section getSouth() {
		return south;
	}
	public void setSouth(Section south) {
		this.south = south;
	}
	public Section getWest() {
		return west;
	}
	public void setWest(Section west) {
		this.west = west;
	}
	public Section getEast() {
		return east;
	}
	public void setEast(Section east) {
		this.east = east;
	}
	public Section getCenter() {
		return center;
	}
	public void setCenter(Section center) {
		this.center = center;
	}
	
	
	
}
