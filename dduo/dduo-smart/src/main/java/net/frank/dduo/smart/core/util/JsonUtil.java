package net.frank.dduo.smart.core.util;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.frank.dduo.smart.core.exception.DsBizExpt;

public final class JsonUtil {
	private static ObjectMapper objectMapper = new ObjectMapper();
	static {
		objectMapper.setSerializationInclusion(Include.NON_NULL);
	}

	public static String toJson(Object obj) {
		try {
			return objectMapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			throw new DsBizExpt(e.getMessage());
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
			throw new DsBizExpt(e.getMessage());
		}

	}

	public static <T> T fromJson(String json, Class<T> classInst) {
		if (json == null) {
			return null;
		}
		try {
			return objectMapper.readValue(json, classInst);
		} catch (IOException e) {
			throw new DsBizExpt("Parse error for: json=" + json + ", clazz=" + classInst.getName());
		}
	}

	public static byte[] toJsonByte(Object obj) {
		try {
			return objectMapper.writeValueAsBytes(obj);
		} catch (JsonProcessingException e) {
			throw new DsBizExpt(e.getMessage());
		}
	}

	public static <T> T fromJsonByte(byte[] json, Class<T> classInst) {
		try {
			return objectMapper.readValue(json, classInst);
		} catch (IOException e) {
			throw new DsBizExpt(e.getMessage());
		}
	}

	public static <K, V> Map<K, V> fromJsonFileMap(String fileName, TypeReference<?> valueTypeRef) {
		try {
			return objectMapper.readValue(new File(fileName), valueTypeRef);
		} catch (IOException e) {
			String msg = "Unable to read json file " + fileName;
			throw new DsBizExpt(msg);
		}

	}
}