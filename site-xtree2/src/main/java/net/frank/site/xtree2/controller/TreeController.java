package net.frank.site.xtree2.controller;

import java.util.List;

import net.frank.commons.CommonConstants;
import net.frank.framework.bo.Resource;
import net.frank.framework.service.QueryService;
import net.frank.framework.service.ServiceNames;
import net.frank.framework.web.spring.controller.ControllerBaseSupport;
import net.frank.framework.ws.define.WsResponse;
import net.frank.framework.ws.process.BoXmlUtil;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;

@Controller
@RequestMapping(value = "/tree")
public class TreeController extends ControllerBaseSupport {
	
	private static final String VIEW_TREE_CONFIG = "commons/xtree2/webFXTreeConfig";
	private static final String VIEW_TEST_TREE_TAG = "commons/testTreeTag";
	
	@RequestMapping(value = "/config",method={RequestMethod.GET,RequestMethod.POST})
	public String config(){
		return VIEW_TREE_CONFIG;
	}
	
	@RequestMapping(value = "/testTag",method=RequestMethod.GET)
	public String testTreeTag(){
		return VIEW_TEST_TREE_TAG;
	}
	
	@RequestMapping(value = "/getChildren/{resourceId}",method=RequestMethod.GET)
	@ResponseBody
	public String getResourceDetails(@PathVariable("resourceId") Long resourceId) throws JsonProcessingException{
		logger.debug("resourceId =>" + resourceId );
		QueryService queryService = (QueryService) getBean(ServiceNames.QUERY_SERVICE);
		Resource currentResource = queryService.getResource(resourceId);
		if(CommonConstants.TYPE.RESOURCE.equals(currentResource.getTypeId())){
			List<Resource> children = queryService
					.retrieveResourceByParent(resourceId);
			currentResource.setChildren(children);
		}else{
			currentResource.setObject(queryService.getBo(resourceId));
		}
		BoXmlUtil boXmlUtil = (BoXmlUtil)getBean("boXmlUtil");
		WsResponse wsResponse = new WsResponse();
		wsResponse.setResource(currentResource);
		String rt = boXmlUtil.wsResponse2Xml(wsResponse);
		return rt;
	}	
}
