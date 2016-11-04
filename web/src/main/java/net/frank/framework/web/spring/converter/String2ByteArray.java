package net.frank.framework.web.spring.converter;

import net.frank.commons.CommonConstants;
import net.frank.commons.util.Base64Util;

import org.springframework.core.convert.converter.Converter;

public final class String2ByteArray implements Converter<String, byte[]> {

	@Override
	public byte[] convert(String source) {
		if (source == null || CommonConstants.EMPTY_STRING.equals(source))
			return null;
		else {
			return Base64Util.decode(source, Base64Util.DEFAULT);
		}
	}
}