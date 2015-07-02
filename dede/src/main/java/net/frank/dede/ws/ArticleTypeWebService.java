package net.frank.dede.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

//import net.frank.framework.ws.process.BoXmlUtil;

@Path("/atws")
public class ArticleTypeWebService extends BaseJersey {
	//private BoXmlUtil boXmlUtil;
	
	public ArticleTypeWebService() {
		//this.boXmlUtil = (BoXmlUtil) getBean("boXmlUtil");
	}
	
	@GET
	@Path("/test")
	public String test() throws Exception {
		return "SUCCESS";
	}
	
}