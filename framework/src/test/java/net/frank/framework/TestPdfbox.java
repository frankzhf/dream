package net.frank.framework;

import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

import javax.imageio.ImageIO;

import net.frank.framework.image.ImageUtil;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.util.PDFTextStripperByArea;

public class TestPdfbox {
	
	private static final Integer PAGE = 0;
	private static final Integer POINT_A_X = 100;
	private static final Integer POINT_A_Y = 100;
	
	private static final Integer POINT_B_X = 500;
	private static final Integer POINT_B_Y = 500;
	
	
	public static void main(String[] args)throws Exception{
		long currentTime = System.currentTimeMillis();
		PDDocument doc = PDDocument.loadNonSeq(new File("D:/java/test/zhaofeng.pdf"), null);
		@SuppressWarnings("unchecked")
		List<PDPage> pages = doc.getDocumentCatalog().getAllPages();
		PDPage page = pages.get(PAGE);
		BufferedImage image = page.convertToImage();
		String imageFile = "D:/java/test/image/zhaofeng.png";
		String rectImageFile = "D:/java/test/image/zhaofeng_rect.png";
		File outputFile = new File(imageFile);
		ImageIO.write(image, "png", outputFile);
		PDFTextStripperByArea stripper = new PDFTextStripperByArea();
		Rectangle2D region = new Rectangle2D.Double(100,100,600,600);
		stripper.addRegion("region", region);
		stripper.extractRegions(page);
		System.out.println(stripper.getTextForRegion("region"));
		
		
		doc.close();
		System.out.println(System.currentTimeMillis()-currentTime);
		ImageUtil.scissor(POINT_A_X, POINT_A_Y, POINT_B_X, POINT_B_Y, imageFile, rectImageFile);
		System.out.println(System.currentTimeMillis()-currentTime);
	}
}
