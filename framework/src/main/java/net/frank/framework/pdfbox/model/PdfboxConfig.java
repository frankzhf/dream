package net.frank.framework.pdfbox.model;

import java.io.Serializable;
import java.util.Map;

public class PdfboxConfig implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3345747420230279658L;
	private String charsetName;
	private Map<Integer,PdfboxPage>  pdfboxPageMap;
	public String getCharsetName() {
		return charsetName;
	}
	public void setCharsetName(String charsetName) {
		this.charsetName = charsetName;
	}
	public Map<Integer, PdfboxPage> getPdfboxPageMap() {
		return pdfboxPageMap;
	}
	public void setPdfboxPageMap(Map<Integer, PdfboxPage> pdfboxPageMap) {
		this.pdfboxPageMap = pdfboxPageMap;
	}
}