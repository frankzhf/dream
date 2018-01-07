package net.frank.corejava0.jakarta.ch07;

import java.util.List;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.XMLConfiguration;

public class ConfigurationXmlMain {

	public static void main(String[] args) throws Exception{
		
		String resource = "net/frank/corejava0/jakarta/ch07/global.xml";
		Configuration config = new XMLConfiguration(resource);
		
		List<?> startCriteria = config.getList("start-criteria.criteria");
		String firstCriteria = config.getString("start-criteria.criteria(0)");
		String firstCriteriaType = config.getString("start-criteria.criteria(0) [@type]");
		int horsePower = config.getInt("horsepower");
		
		System.out.println("Variable [startCriteria] -> " + startCriteria);
		System.out.println("Variable [firstCriteria] -> " + firstCriteria);
		System.out.println("Variable [firstCriteriaType] -> " + firstCriteriaType);
		System.out.println("Variable [horsePower] -> " + horsePower);
		
		
	}

}
