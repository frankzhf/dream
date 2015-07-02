package net.frank.framework.pdfbox.model;

import java.io.Serializable;
import java.util.Map;

public class PdfboxPage implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6823264469407560168L;
	private Integer seq;
	private Map<String,PdfboxRegion> regionMap;
	public Integer getSeq() {
		return seq;
	}
	public void setSeq(Integer seq) {
		this.seq = seq;
	}
	public Map<String, PdfboxRegion> getRegionMap() {
		return regionMap;
	}
	public void setRegionMap(Map<String, PdfboxRegion> regionMap) {
		this.regionMap = regionMap;
	}
	
	
}