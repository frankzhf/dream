package net.frank.yangtes.modules.ckfinder;

import javax.servlet.ServletException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ckfinder.connector.configuration.ConfigurationFactory;
import com.ckfinder.connector.configuration.Events.EventTypes;
import net.frank.yangtes.commons.web.CKFinderConnectorServlet;

public class M3u8ConnectorServlet extends CKFinderConnectorServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1938208234350296345L;
	private transient Logger log = LoggerFactory.getLogger(getClass());
	
	public static String WIN_FFMPEG_COMMAND;
	
	@Override
	public void init() throws ServletException {
		log.debug("M3u8ConnectorServlet.init(");
		super.init();
		WIN_FFMPEG_COMMAND = getServletContext().getRealPath("/resources/ffmpeg/win/ffmpeg");
		try{
			ConfigurationFactory.getInstace().getConfiguration().getEvents().
				addEventHandler(EventTypes.AfterFileUpload, 
						Mp4ConverteM3u8Command.class);
		}catch(Exception e){
			log.error(e.getMessage(),e);
		}
	}
	
}
