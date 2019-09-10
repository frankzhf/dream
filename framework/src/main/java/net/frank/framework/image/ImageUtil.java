package net.frank.framework.image;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.frank.commons.CommonConstants;

import com.mortennobel.imagescaling.ResampleOp;

public final class ImageUtil {
	
	static transient Logger log = LoggerFactory.getLogger(ImageUtil.class);
	
	private static final String DEFAUTL_IMAGE_EXTENTION = "png";
	/**
	 * @param x1
	 * @param x2
	 * @param y1
	 * @param y2
	 * @param originPath
	 * @param savePath
	 * @throws IOException
	 *  x1y1 *******
	 *       *     *
	 *       *     *
	 *       *******x2y2
	 */

	public static void scissor(int x1, int y1, int x2, int y2,
			String originPath, String savePath) {
		
		try (FileInputStream is =new FileInputStream(originPath);
			ImageInputStream iis = ImageIO.createImageInputStream(is);
				){
			String extentionName = getExtention(originPath);
			Iterator<ImageReader> it = ImageIO
					.getImageReadersByFormatName(extentionName
							.toLowerCase());
			ImageReader reader = it.next();
			reader.setInput(iis, true);
			ImageReadParam param = reader.getDefaultReadParam();
			Rectangle rect = new Rectangle(x1, y1, x2 - x1, y2 - y1);
			param.setSourceRegion(rect);
			BufferedImage bi = reader.read(0, param);
			ImageIO.write(bi, extentionName.toLowerCase(), new File(
					savePath));
		} catch(IOException e) {
			log.error(e.getMessage(),e);
		} 
	}

	/**
	 * @param width
	 * @param height
	 * @param originPath
	 * @param savePath
	 * @throws IOException
	 */
	public static void scaleImage(int width, int height, String originPath,
			String savePath) throws IOException {
		BufferedImage sourceImage = readImage(originPath);
		ResampleOp resampleOp = new ResampleOp(width, height);
		BufferedImage rescaledTomato = resampleOp.filter(sourceImage, null);
		ImageIO.write(rescaledTomato, getExtention(originPath).toLowerCase(),
				new File(savePath));
	}

	private static BufferedImage readImage(String imagePath) throws IOException {
		return readImage(new File(imagePath));
	}

	private static BufferedImage readImage(File image) throws IOException {
		return ImageIO.read(image);
	}

	/**
	 * @param fileName
	 * @return
	 */
	private static String getExtention(String fileName) {
		int pos = fileName.lastIndexOf(CommonConstants.POINT);
		if(pos!=-1){
			return fileName.substring(pos + 1).toUpperCase();
		}else{
			return DEFAUTL_IMAGE_EXTENTION;
		}
	}
}
