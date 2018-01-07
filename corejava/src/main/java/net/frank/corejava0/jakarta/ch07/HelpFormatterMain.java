package net.frank.corejava0.jakarta.ch07;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.OptionGroup;
import org.apache.commons.cli.Options;

public class HelpFormatterMain {
	
	private static final String USAGE = "[-h] [-v] [-f <file> | -m <email>]";
	private static final String HEADER = "HelpFormatter - a fancy and expensive program, Copyright 2017 @frank";
	private static final String FOOTER = "For more instructions, see our website at : http://www.frank.net";
	
	public static void main(String[] args) {
		CommandLineParser parser = new BasicParser();
		Options options = new Options();
		options.addOption("h","help",false, "Print this usage information");
		options.addOption("v","verbose",false, "Print this VERBOSE information");
		
		OptionGroup optionGroup = new OptionGroup();
		OptionBuilder.hasArg(true);
		OptionBuilder.withArgName("file");
		OptionBuilder.withLongOpt("file");
		optionGroup.addOption(OptionBuilder.create('f'));
		OptionBuilder.hasArg(true);
		OptionBuilder.withArgName("email");
		OptionBuilder.withLongOpt("email");
		optionGroup.addOption(OptionBuilder.create('m'));
		options.addOptionGroup(optionGroup);
		try {
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
		}catch(Exception e) {
			System.out.println("You provided had program arguments");
			printUsage(options);
			System.exit(1);
		}
	}

	private static void printUsage(Options options) {
		HelpFormatter helpFormatter = new HelpFormatter();
		helpFormatter.setWidth(80);
		helpFormatter.printHelp(USAGE, HEADER,options,FOOTER);
	}

}
