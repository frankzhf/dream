package net.frank.framework.pdfbox;

public class PdfboxParseException extends ArrayIndexOutOfBoundsException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 533534995355088003L;

	public PdfboxParseException() {
		super("Page number define seq more than actual pdf document");
	}

	public PdfboxParseException(String message) {
		super(message);
	}

}
