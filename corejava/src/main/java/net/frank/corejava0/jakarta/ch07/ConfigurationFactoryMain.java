package net.frank.corejava0.jakarta.ch07;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationBuilder;
import org.apache.commons.configuration.DefaultConfigurationBuilder;

public class ConfigurationFactoryMain {

	public static void main(String[] args) throws Exception {
		ConfigurationBuilder builder = new DefaultConfigurationBuilder(
				Thread.currentThread().getContextClassLoader().getResource("net/frank/corejava0/jakarta/ch07/configuration.xml")
				);
		Configuration config = builder.getConfiguration();
		
		float timeout = config.getFloat("timeout");
		String threadsMax = config.getString("threads.max");
		String name = config.getString("name");
		int speed = config.getInt("speed");
		
		System.out.println("Variable [timeout] -> " + timeout);
		System.out.println("Variable [threadsMax] -> " + threadsMax);
		System.out.println("Variable [name] -> " + name);
		System.out.println("Variable [speed] -> " + speed);
		
	}

}
