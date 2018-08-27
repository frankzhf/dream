package net.frank.framework.pdfbox;

import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.frank.commons.CommonConstants;
import net.frank.framework.pdfbox.model.PdfboxConfig;
import net.frank.framework.pdfbox.model.PdfboxPage;
import net.frank.framework.pdfbox.model.PdfboxRegion;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.util.PDFTextStripperByArea;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

public class IPdfboxTextReaderImpl implements IPdfboxTextReader,
		InitializingBean {

	protected transient Logger log = LoggerFactory.getLogger(getClass());

	private String config;

	protected PdfboxConfig _config;

	private static final String ELEMENT_ROOT = "pdfboxConfig";

	public String getConfig() {
		return config;
	}

	public void setConfig(String config) {
		this.config = config;
	}

	@Override
	public Map<String, String> parse(InputStream pdfIs) throws IOException {
		Map<String, String> rt = new HashMap<String, String>();
		PDDocument doc = PDDocument.loadNonSeq(pdfIs, null);
		@SuppressWarnings("unchecked")
		List<PDPage> pages = doc.getDocumentCatalog().getAllPages();
		PDFTextStripperByArea stripper = new PDFTextStripperByArea(
				_config.getCharsetName());
		boolean singlionPage = pages.size() == 1
				|| _config.getPdfboxPageMap().keySet().size() == 1;
		for (Iterator<Integer> it = _config.getPdfboxPageMap().keySet()
				.iterator(); it.hasNext();) {
			Integer key = it.next();
			if (key > pages.size() - 1) {
				throw new PdfboxParseException();
			}
			PdfboxPage pdfboxPage = _config.getPdfboxPageMap().get(key);
			for (Iterator<String> itt = pdfboxPage.getRegionMap().keySet()
					.iterator(); itt.hasNext();) {
				String key2 = itt.next();
				PdfboxRegion currRegion = pdfboxPage.getRegionMap().get(key2);
				Rectangle2D rect = new Rectangle2D.Float(currRegion.getPointX(),
						currRegion.getPointY(), currRegion.getWidth(),
						currRegion.getHeight());
				String regionKey = singlionPage ? currRegion.getName() : key+"_"+currRegion.getName();
				stripper.addRegion(regionKey, rect);
				rt.put(regionKey, null);
			}
			stripper.extractRegions(pages.get(key));
			for(Iterator<String> rtKeyIt=rt.keySet().iterator();rtKeyIt.hasNext();){
				String rtKey = rtKeyIt.next();
				if(rt.get(rtKey) == null){
					rt.put(rtKey, stripper.getTextForRegion(rtKey));
				}
			}
		}
		return rt;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		log.debug(this.getClass() + " begin afterPropertiesSet()");
		if (config != null && !CommonConstants.EMPTY_STRING.equals(config)) {
			log.debug("input config = " + config);
			InputStream in = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream(config);
			SAXReader reader = new SAXReader();
			Document document = reader.read(in);
			Element root = document.getRootElement();
			if (ELEMENT_ROOT.equals(root.getName())) {
				_config = new PdfboxConfig();
				_config.setCharsetName(root.attributeValue("charsetName"));
				_config.setPdfboxPageMap(new HashMap<Integer, PdfboxPage>());
				for (@SuppressWarnings("unchecked")
				Iterator<Element> it = root.elementIterator(); it
						.hasNext();) {
					Element page = it.next();
					PdfboxPage _page = new PdfboxPage();
					_page.setSeq(Integer.parseInt(page.attributeValue("seq")));
					_page.setRegionMap(new HashMap<String, PdfboxRegion>());
					for (@SuppressWarnings("unchecked")
					Iterator<Element> itt = page.elementIterator(); itt
							.hasNext();) {
						Element region = itt.next();
						PdfboxRegion pdfboxRegion = new PdfboxRegion();
						pdfboxRegion.setName(region.attributeValue("name"));
						pdfboxRegion.setPointX(Integer.parseInt(region
								.attributeValue("pointX")));
						pdfboxRegion.setPointY(Integer.parseInt(region
								.attributeValue("pointY")));
						pdfboxRegion.setWidth(Integer.parseInt(region
								.attributeValue("width")));
						pdfboxRegion.setHeight(Integer.parseInt(region
								.attributeValue("height")));
						_page.getRegionMap().put(pdfboxRegion.getName(),
								pdfboxRegion);
					}
					_config.getPdfboxPageMap().put(_page.getSeq(), _page);
				}
			} else {
				throw new Exception("Config is error");
			}
		} else {
			throw new Exception("Config is error");
		}
		log.debug(this.getClass() + " end afterPropertiesSet()");
	}
}
