package net.frank.framework.web.spring.converter;

import net.frank.commons.CommonConstants;
import net.frank.commons.util.Base64Util;

import org.springframework.core.convert.converter.Converter;

public final class ByteArray2String implements Converter<byte[],String>{

	@Override
	public String convert(byte[] source) {
		if(source==null){
			return CommonConstants.EMPTY_STRING;
		}else{
			return Base64Util.encodeToString(source,Base64Util.DEFAULT);
		}
		 
	}

}
