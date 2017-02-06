package net.frank.yangtes.modules.ckfinder;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Element;

import com.ckfinder.connector.configuration.IConfiguration;
import com.ckfinder.connector.data.AfterFileUploadEventArgs;
import com.ckfinder.connector.data.EventArgs;
import com.ckfinder.connector.data.IEventHandler;
import com.ckfinder.connector.errors.ConnectorException;
import com.ckfinder.connector.handlers.command.XMLCommand;
import net.frank.commons.util.OsUtil;
import net.frank.commons.util.OsUtil.CommandReturn;
import net.frank.commons.util.OsUtil.RETURN_TYPE;

public class Mp4ConverteM3u8Command extends XMLCommand implements IEventHandler {
	private transient Logger log = LoggerFactory.getLogger(getClass());
	
	private static final String TEMP_FILE_NAME_SUFFIX = ".m3u8_temp";
	
	private static final String FF_MPEG_CLOSE_PARAMS = " -loglevel quiet ";
	private static final String FF_MPEG_CMD_PARAMS = " -c:v libx264 -c:a aac -strict -2 -f hls ";

	@Override
	public boolean runEventHandler(EventArgs eventArgs, IConfiguration configuration)
			throws ConnectorException {
		log.debug("Mp4ConverteM3u8Command.runEventHandler()");
		AfterFileUploadEventArgs args = (AfterFileUploadEventArgs) eventArgs;
		log.debug("Varrible [CurrentFolder] -> " + args.getCurrentFolder());
		log.debug("Varrible [File] -> " + args.getFile());
		
		final File operatorFile = args.getFile();
		if(operatorFile.getName().endsWith(".mp4")){
			Thread t = new Thread(new Runnable() {
				@Override
				public void run() {
					if(operatorFile.exists()){
						File tempFile = new File(operatorFile.getParent() + File.separator +operatorFile.getName()+TEMP_FILE_NAME_SUFFIX);
						if(operatorFile.renameTo(tempFile)){
							String commandLine = null;
							if(OsUtil.isWin()){
								commandLine = M3u8ConnectorServlet.WIN_FFMPEG_COMMAND + FF_MPEG_CLOSE_PARAMS +
										" -i "+ tempFile.getPath() + FF_MPEG_CMD_PARAMS + operatorFile.getPath();
							}else{
								commandLine = "ffmpeg " + FF_MPEG_CLOSE_PARAMS + " -i " + tempFile.getPath() + FF_MPEG_CMD_PARAMS + operatorFile.getPath();
							}
							CommandReturn rt= OsUtil.execute(commandLine);
							if(RETURN_TYPE.SUCCESS == rt.getType()){
								tempFile.delete();
							}
						}
					}
				}
			});
			t.start();
		}
		return false;
	}

	@Override
	protected void createXMLChildNodes(int paramInt, 
			Element paramElement) throws ConnectorException {
		log.debug("Mp4ConverteM3u8Command.createXMLChildNodes()");
	}

	@Override
	protected int getDataForXml() {
		log.debug("Mp4ConverteM3u8Command.getDataForXml()");
		return 0;
	}
	
}