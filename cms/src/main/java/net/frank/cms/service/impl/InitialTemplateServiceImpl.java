package net.frank.cms.service.impl;

import org.apache.log4j.Logger;

import net.frank.commons.CommonConstants;
import net.frank.framework.app.InitialService;
import net.frank.framework.bo.Resource;
import net.frank.framework.initial.QingMaker;
import net.frank.framework.security.Session;
import net.frank.framework.service.QueryService;

public class InitialTemplateServiceImpl implements InitialService {
	
	private transient Logger log = Logger.getLogger(getClass());
	
	private QueryService queryService;
	
	private QingMaker qingMaker;
	
	public void setQueryService(QueryService queryService){
		this.queryService = queryService;
	}
	
	public void setQingMaker(QingMaker qingMaker){
		this.qingMaker = qingMaker;
	}
	
	@Override
	public boolean checkAppInitial() {
		return false;
	}

	@Override
	public boolean checkUserWorkspace(Session session) {
		return false;
	}

	@Override
	public void initialApp() {
		log.debug("Init Start");
		Resource templateRoot = queryService.getResource(
				CommonConstants.RESOURCE_ID.ROOT,
				CommonConstants.RESOURCE_ALIAS.CONTEXT_TEMPLATES_ROOT);
		Resource account_root = queryService.getResourceAsPath(CommonConstants.PATH.ROOT_ACCOUNT);
		Resource group_admin = queryService.getResourceAsPath(CommonConstants.PATH.ADMIN_GROUP);
		Resource accountTemplate = qingMaker.createResource("account", templateRoot, true, 
				CommonConstants.TYPE.RESOURCE, account_root, group_admin);
		Resource res = qingMaker.createResource(".group", accountTemplate, true,
				CommonConstants.TYPE.RESOURCE, account_root, group_admin);
		res = qingMaker.createResource(".privilege", accountTemplate, true,
				CommonConstants.TYPE.RESOURCE, account_root, group_admin);
		res = qingMaker.createResource(".config", accountTemplate, true,
				CommonConstants.TYPE.RESOURCE, account_root, group_admin);
		
		Resource unitTemplate = qingMaker.createResource("unit", templateRoot,true,
				CommonConstants.TYPE.RESOURCE, account_root, group_admin);
		res = qingMaker.createResource("children", unitTemplate, true,
				CommonConstants.TYPE.RESOURCE, account_root, group_admin);
		res = qingMaker.createResource("group", unitTemplate, true,
				CommonConstants.TYPE.RESOURCE, account_root, group_admin);
		res = qingMaker.createResource("grant", unitTemplate, true,
				CommonConstants.TYPE.RESOURCE, account_root, group_admin);
		
		
		Resource applicationTemplate = qingMaker.createResource("application", templateRoot,true,
				CommonConstants.TYPE.RESOURCE, account_root, group_admin);
		res = qingMaker.createResource("menu", applicationTemplate,true,
				CommonConstants.TYPE.RESOURCE, account_root, group_admin);
		res = qingMaker.createResource("group", applicationTemplate,true,
				CommonConstants.TYPE.RESOURCE, account_root, group_admin);
		res = qingMaker.createResource("grant", applicationTemplate,true,
				CommonConstants.TYPE.RESOURCE, account_root, group_admin);
		res = qingMaker.createResource("contextTemplate", applicationTemplate,true,
				CommonConstants.TYPE.RESOURCE, account_root, group_admin);
		res = qingMaker.createResource("type", applicationTemplate,true,
				CommonConstants.TYPE.RESOURCE, account_root, group_admin);
		
		Resource articleTempleate = qingMaker.createResource("article", templateRoot,true,
				CommonConstants.TYPE.RESOURCE, account_root, group_admin);
		res = qingMaker.createResource("image", articleTempleate,true,
				CommonConstants.TYPE.RESOURCE, account_root, group_admin);
		res = qingMaker.createResource("media", articleTempleate,true,
				CommonConstants.TYPE.RESOURCE, account_root, group_admin);
		log.debug(res);
		log.debug("Init End");
	}

	@Override
	public void initialUserWorkspace(Session session) {

	}

}
