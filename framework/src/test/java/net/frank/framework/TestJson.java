package net.frank.framework;

import java.io.StringWriter;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.frank.framework.bo.Resource;

public class TestJson {
	public static void main(String[] args)throws Exception{
		Resource resource = new Resource();
		StringWriter sw = new StringWriter();
		ObjectMapper om = new ObjectMapper();
		om.writeValue(sw, resource);
		System.out.println(sw.toString());
	}
}
