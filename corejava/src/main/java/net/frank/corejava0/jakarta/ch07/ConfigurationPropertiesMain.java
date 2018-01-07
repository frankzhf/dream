package net.frank.corejava0.jakarta.ch07;

import java.util.List;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.PropertiesConfiguration;

public class ConfigurationPropertiesMain {
	
	public static void main(String[] args) throws Exception{
		Configuration config = new PropertiesConfiguration("net/frank/corejava0/jakarta/ch07/test.properties");
		
		float speed = config.getFloat("speed");
		List<?> names = config.getList("names");
		boolean correct = config.getBoolean("correct");
		
		System.out.println("Variable [speed] -> " + speed);
		System.out.println("Variable [names] -> " + names);
		System.out.println("Variable [correct] -> " + correct);
	}
	
	
}
