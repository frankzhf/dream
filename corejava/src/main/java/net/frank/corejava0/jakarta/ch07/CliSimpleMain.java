package net.frank.corejava0.jakarta.ch07;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.OptionGroup;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class CliSimpleMain {

	public static void main(String[] args) throws ParseException {
		CommandLineParser parser = new BasicParser();
		Options options = new Options();
		options.addOption("h","help",false, "Print this usage information");
		options.addOption("v","verbose",false, "Print this VERBOSE information");
		options.addOption("f","file",true,"File to save program output to");
		CommandLine commandLine = parser.parse(options, args);
		boolean verbose = false;
		String file = "";
		if(commandLine.hasOption('h')) {
			System.out.println("Help Message");
			//qSystem.exit(0);
		}
		if(commandLine.hasOption('v')){
			verbose = true;
			System.out.println("verbose:" + verbose);
		}
		if(commandLine.hasOption('f')) {
			file = commandLine.getOptionValue('f');
			System.out.println("file:" + file);
		}
	}
}
