package net.frank.framework.web.spring.converter;

import java.math.BigDecimal;

import net.frank.commons.CommonConstants;

import org.springframework.core.convert.converter.Converter;

public final class String2BigDecimal implements Converter<String, BigDecimal> {
	@Override
	public BigDecimal convert(String source) {
		if(source == null || CommonConstants.EMPTY_STRING.equals(source)){
			return null;
		}else{
			BigDecimal _value = new BigDecimal(source);
			return _value;
		}
	}
}
