package net.frank.framework.web.spring.converter;

import java.math.BigDecimal;

import net.frank.commons.CommonConstants;

import org.springframework.core.convert.converter.Converter;

public final class BigDecimal2String implements Converter<BigDecimal, String> {
	
	private static Integer BIGDECIMAL_SCALE = 2;
	
	@Override
	public String convert(BigDecimal source) {
		if(source ==null)
			return CommonConstants.EMPTY_STRING;
		else{
			source.setScale(BIGDECIMAL_SCALE, BigDecimal.ROUND_HALF_UP);
			return source.toString();
		}
	}

}
