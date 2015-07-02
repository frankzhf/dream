package net.frank.commons.util;

public final class OsUtil {
	
	private static final String SYS_PROP_OS_KEY = "os.name";
	private static final String WIN_COMMAND_START = "cmd.exe";
	private static final String WIN_COMMAND_PARAM = "/c";
	
	private static final String UNIT_COMMAND_START = "/bin/sh";
	private static final String UNIT_COMMAND_PARAM = "-c";
	
	
	public static String[] getOsBatchCommand(String commandLine){
		String osName = System.getProperty(SYS_PROP_OS_KEY);
		if(osName != null){
			if(osName.startsWith("Windows")){
				return new String[]{
						WIN_COMMAND_START,
						WIN_COMMAND_PARAM,
						commandLine
				};
			}else{
				return new String[]{
						UNIT_COMMAND_START,
						UNIT_COMMAND_PARAM,
						commandLine
				};
			}
		}else{
			return new String[]{commandLine};
		}
	}
}
