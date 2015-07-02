package net.frank.framework.bsui.grid;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Iterator;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.frank.commons.CommonConstants;
import net.frank.framework.bo.Resource;
import net.frank.framework.security.Session;
import net.frank.framework.service.CmsService;

public class DataGenerator {
	
	private static final String NULL_DS = "{\"total\":0,\"data\":null}";
	
	private CmsService cmsService;

	public void setCmsService(CmsService cmsService) {
		this.cmsService = cmsService;
	}

	public String generate(String path, Session session) throws IOException {
		Resource parent = cmsService.getResource(path, session);
		
		if (parent != null && parent.getChildren() != null
				&& !parent.getChildren().isEmpty()) {
			StringBuffer sb = new StringBuffer(parent.getChildren().size()*CommonConstants.DEFAULT_STRING_BUFFER_LENGTH);
			sb.append("{\"total\":").append(parent.getChildren().size()).append(",\"data\":[");
			boolean isFirst = true;
			ObjectMapper om = new ObjectMapper();
			for (Iterator<Resource> it = parent.getChildren().iterator(); it
					.hasNext();) {
				Resource child = it.next();
				child = cmsService.getResource(child, session);
				if(CommonConstants.CMS_CODE.MESSAGE_OK.equals(child.getCode())){
					StringWriter sw = new StringWriter();
					om.writeValue(sw,child);
					if(isFirst){
						sb.append(sw.toString());
						isFirst = false;
					}else{
						sb.append(",").append(sw.toString());
					}
				}
			}
			sb.append("]}");
			return sb.toString();
		} else {
			return NULL_DS;
		}
	}

}
