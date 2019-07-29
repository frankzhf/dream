package net.frank.llin.commons.utils;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.Base64Variants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {
	
	private static transient Logger log = LoggerFactory.getLogger(JsonUtils.class);

	private static ObjectMapper objectMapper = new ObjectMapper();

	static {
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		objectMapper.setBase64Variant(Base64Variants.getDefaultVariant());
	}
	
	public static String toJson(Object obj) {
		try {
			return objectMapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			log.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}
	
	public static <T> List<T> fromJsonList(String json, Class<T> classInst) {
		if (json == null) {
			return null;
		}
		try {
			return objectMapper.readValue(json, new TypeReference<List<T>>() {
			});
		} catch (IOException e) {
			log.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}

	public static <T> T fromJson(String json, Class<T> classInst) {
		if (json == null) {
			return null;
		}

		try {
			return objectMapper.readValue(json, classInst);
		} catch (IOException e) {
			log.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}

	public static byte[] toJsonByte(Object obj) {
		try {
			return objectMapper.writeValueAsBytes(obj);
		} catch (JsonProcessingException e) {
			log.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}

	public static <T> T fromJsonByte(byte[] json, Class<T> classInst) {
		try {
			return objectMapper.readValue(json, classInst);
		} catch (IOException e) {
			log.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}	
}