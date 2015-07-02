package net.frank.framework.pdfbox;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import net.frank.commons.CommonConstants;
import net.frank.framework.image.ImageUtil;
import net.frank.framework.pdfbox.model.PdfboxPage;
import net.frank.framework.pdfbox.model.PdfboxRegion;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

public class IPdfboxOcrTextReaderImpl extends IPdfboxTextReaderImpl {
	
	private String ocrWorkFolder;
	
	
	public void setOcrWorkFolder(String ocrWorkFolder) {
		this.ocrWorkFolder = ocrWorkFolder;
	}
	
	@Override
	public Map<String, String> parse(InputStream pdfIs) throws IOException {
		Map<String, String> rt = new HashMap<String, String>();
		PDDocument doc = PDDocument.loadNonSeq(pdfIs, null);
		@SuppressWarnings("unchecked")
		List<PDPage> pages = doc.getDocumentCatalog().getAllPages();
		boolean singlionPage = pages.size() == 1
				|| _config.getPdfboxPageMap().keySet().size() == 1;
		for (Iterator<Integer> it = _config.getPdfboxPageMap().keySet()
				.iterator(); it.hasNext();) {
			Integer key = it.next();
			if (key > pages.size() - 1) {
				throw new PdfboxParseException();
			}
			PdfboxPage pdfboxPage = _config.getPdfboxPageMap().get(key);
			PDPage page = pages.get(key);
			BufferedImage pageImage = page.convertToImage();
			String pageFileName = ocrWorkFolder + key + ".png";
			File outputFile = new File(pageFileName);
			ImageIO.write(pageImage, "png", outputFile);
			for (Iterator<String> itt = pdfboxPage.getRegionMap().keySet()
					.iterator(); itt.hasNext();) {
				String key2 = itt.next();
				PdfboxRegion currRegion = pdfboxPage.getRegionMap().get(key2);
				String regionKey = singlionPage ? currRegion.getName() : key
						+ "_" + currRegion.getName();
				String rectImageFile = ocrWorkFolder + key + "_" + regionKey
						+ ".png";
				ImageUtil.scissor(currRegion.getPointX(),
						currRegion.getPointY(), currRegion.getPointX()
								+ currRegion.getWidth(), currRegion.getPointY()
								+ currRegion.getHeight(), pageFileName,
						rectImageFile);
				rt.put(regionKey, rectImageFile);
			}
		}
		for(Iterator<String> it=rt.keySet().iterator();it.hasNext();){
			String key = it.next();
			String imageFile = rt.get(key);
			String textFile = imageFile.substring(0,imageFile.indexOf(".png"));
			String cmd =  "tesseract "+imageFile + " "+textFile;
			Process process = Runtime.getRuntime().exec(cmd);
			BufferedReader cmdReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			boolean consoleOutputFlag = false;
			String line = null;
			while((line = cmdReader.readLine())!=null){
				if(!consoleOutputFlag){
					log.info("Console output as below");
					consoleOutputFlag = true;
				}
				log.info(line);
			}
			
			BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
			String errorLine = null;
			while((errorLine = errorReader.readLine())!=null){
				log.error(errorLine);
			}
			int status = process.exitValue();
			if(status == 0){
				FileReader fr = new FileReader(textFile+".txt");
				log.debug(fr);
				char[] charBuffer = new char[1024];
				StringBuffer sb = new StringBuffer(CommonConstants.DEFAULT_STRING_BUFFER_LENGTH);
				int readFlag = 0;
				while((readFlag = fr.read(charBuffer)) !=-1){
					sb.append(charBuffer,0,readFlag);
				}
				rt.put(key, sb.toString());
			
			}
		
		}
		return rt;
	}
}
