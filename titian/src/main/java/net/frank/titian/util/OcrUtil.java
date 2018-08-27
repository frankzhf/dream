package net.frank.titian.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.frank.commons.util.OsUtil;
import net.frank.commons.util.OsUtil.CommandReturn;
import net.frank.commons.util.OsUtil.RETURN_TYPE;

public final class OcrUtil {
	
	private static Logger log = LoggerFactory.getLogger(OcrUtil.class);
	
	private static final String OCR_CHAR = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	
	private static String filtString(String org){
		String result = "";
		for(char c : org.toCharArray()){
			if(OCR_CHAR.indexOf(c) >= 0){
				result += c;
			}
		}
		return result;
	}
	
	
	public static String recognizeText(String imageFile, String outputName, boolean isDigits) {
		StringBuffer command = new StringBuffer(256);
		command.append("tesseract ").append(imageFile).append(" ").append(outputName);
		if(isDigits){
			command.append(" digits");
		}else{
			command.append(" -l eng");
		}
		String executeCmd = command.toString();
		log.debug("Execute command: " + executeCmd);
		CommandReturn rt = OsUtil.execute(executeCmd);
		if(RETURN_TYPE.SUCCESS == rt.getType()){
			StringBuffer strB = new StringBuffer();
			try{
				BufferedReader in = new BufferedReader(new InputStreamReader(
						new FileInputStream(outputName + ".txt"), "UTF-8"));
				String str;
				while ((str = in.readLine()) != null) {
					strB.append(str);
				}
				in.close();
				String recognizeStr = strB.toString();
				log.debug("Ocr result: " + recognizeStr);
				return filtString(recognizeStr);
			}catch(UnsupportedEncodingException  e){
				throw new RuntimeException(e.getMessage(),e);
			}catch(FileNotFoundException  e){
				throw new RuntimeException(e.getMessage(),e);
			}catch(IOException e){
				throw new RuntimeException(e.getMessage(),e);
			}
		}else{
			throw new RuntimeException(rt.getValue());
		}	
	}
	
	public static void main(String[] args){
		System.out.println(OcrUtil.recognizeText("D:/validcode.jpeg", "D:/validcode", true));
	}
	
}
