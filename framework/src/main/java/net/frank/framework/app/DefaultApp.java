package net.frank.framework.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import net.frank.commons.CommonConstants;
import net.frank.framework.bo.Account;
import net.frank.framework.bo.Account2Group;
import net.frank.framework.bo.Application;
import net.frank.framework.bo.Group;
import net.frank.framework.bo.MenuItem;
import net.frank.framework.bo.Privilege;
import net.frank.framework.bo.Resource;
import net.frank.framework.bo.Type;
import net.frank.framework.security.RootSessionHolder;
import net.frank.framework.security.Session;
import net.frank.framework.service.CmsService;

public class DefaultApp implements ApplicationTemplate {

	private static final String PATHS_SPLIT = ";";

	private static Application _applciation = null;

	private static Session _session = null;

	private static Resource _groupRepository = null;

	private static Resource _menuRepository = null;

	private CmsService cmsService;

	private String appPath;

	private static Map<Long, Type> typeMap;

	public void setCmsService(CmsService cmsService) {
		this.cmsService = cmsService;
	}

	public void setAppPath(String appPath) {
		this.appPath = appPath;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		Session rootSession = RootSessionHolder.getDefaultRootSession();
		Resource app = cmsService.getResource(appPath, rootSession);
		if (!CommonConstants.TYPE.APPLICATION.equals(app.getTypeId())) {
			throw new ApplicationException("appPath is error");
		}
		_applciation = (Application) app.getObject();
		_applciation.setResource(app);
		app.setObject(null);
		String typePaths = new String(_applciation.getTypePaths());
		typeMap = new HashMap<Long, Type>();
		if (typePaths.indexOf(PATHS_SPLIT) > -1) {
			StringTokenizer st = new StringTokenizer(typePaths, PATHS_SPLIT);
			while (st.hasMoreElements()) {
				String currentPath = st.nextToken();
				Resource typeRoot = cmsService.getResource(currentPath,
						rootSession);
				if (!CommonConstants.TYPE.RESOURCE.equals(typeRoot.getTypeId())
						|| typeRoot.getChildren()==null ||typeRoot.getChildren().isEmpty()) {
					break;
				}
				for (Iterator<Resource> it = typeRoot.getChildren().iterator(); it
						.hasNext();) {
					Resource child = it.next();
					child = cmsService.getResource(child, rootSession);
					if (CommonConstants.TYPE.TYPE.equals(child.getTypeId())) {
						Type type = (Type) child.getObject().clone();
						typeMap.put(child.getId(), type);
					}
				}
			}

		} else {
			Resource typeRoot = cmsService.getResource(typePaths, rootSession);
			if (!CommonConstants.TYPE.RESOURCE.equals(typeRoot.getTypeId())
					|| typeRoot.getChildren().isEmpty()) {
				throw new ApplicationException("Type Path is error");
			}
			for (Iterator<Resource> it = typeRoot.getChildren().iterator(); it
					.hasNext();) {
				Resource child = it.next();
				child = cmsService.getResource(child, rootSession);
				if (CommonConstants.TYPE.TYPE.equals(child.getTypeId())) {
					Type type = (Type) child.getObject().clone();
					typeMap.put(child.getId(), type);
				}
			}
		}
		// reset its ClientSession
		Resource suRes = _applciation.getSuperAccount$5();
		suRes = cmsService.getResource(suRes, rootSession);
		if (suRes == null
				|| !CommonConstants.TYPE.ACCOUNT.equals(suRes.getTypeId())) {
			throw new ApplicationException("Application's su set error");
		}
		Resource appContextRes = _applciation.getContext$3();
		appContextRes = cmsService.getResource(appContextRes, rootSession);
		final Account su = (Account) suRes.getObject();
		
		final List<Privilege> privilegeList = new ArrayList<Privilege>();
		Privilege privilege = new Privilege();
		privilege.setDomain$3(appContextRes);
		privilegeList.add(privilege);
		
		final List<Resource> groupsList = new ArrayList<Resource>();
		
		Resource groupFolder = cmsService.getResource(su.getHome$3(),".group", rootSession);
		if(groupFolder!=null && groupFolder.getChildren()!=null 
				&& !groupFolder.getChildren().isEmpty()){
			for(int i=0;i<groupFolder.getChildren().size();i++){
				Resource child = groupFolder.getChildren().get(i);
				child = cmsService.getResource(child, rootSession);
				groupsList.add(((Account2Group)child.getObject()).getGroup$6().clone());
			}
		}
		
		_session = new Session() {
			@Override
			public String getLocalCd() {
				return null;
			}

			@Override
			public void setLocalCd(String localCd) {

			}

			@Override
			public Integer getLoginType() {
				return Session.LOGIN_TYPE_DEFAULT;
			}

			@Override
			public Integer getStatus() {
				return Session.STATUS_LOGINED;
			}

			@Override
			public void setStatus(Integer status) {

			}

			@Override
			public String getLoginName() {
				return su.getLoginName();
			}

			@Override
			public Account getAccount() {
				return su;
			}

			@Override
			public Group getCurrentGroup() {
				return null;
			}

			@Override
			public List<Resource> getGroups() {
				return groupsList;
			}

			@Override
			public List<Privilege> getPrivileges() {
				return privilegeList;
			}

			@Override
			public Map<Long, Type> getUserTypeMap() {
				return null;
			}

			@Override
			public void setAccount(Account account) {

			}

			@Override
			public void setCurrentGroup(Group currentGroup) {

			}

			@Override
			public void setAttributes(Map<String, Object> attributes) {

			}

			@Override
			public Map<String, Object> getAttributes() {
				return null;
			}

			@Override
			public void setAttribute(String key, Object value) {

			}

			@Override
			public Object getAttribute(String key) {
				return null;
			}

		};
		_session.setAttribute(Session.CS_ATTRIBLE_PRIVILEGES_KEY, privilegeList);
	}

	@Override
	public Application getApplication() {
		return _applciation;
	}

	@Override
	public Session getSuperUserClientSession() {
		return _session;
	}

	@Override
	public Resource getApplicationContext() {
		return getApplication().getContext$3();
	}

	private static final String GROUP_ALIAS = "group";

	@Override
	public Resource getGroupRepository() {
		if (_groupRepository == null) {
			Resource appContextRes = getApplicationContext();
			_groupRepository = cmsService.getResource(appContextRes,
					GROUP_ALIAS, getSuperUserClientSession());
			if (_groupRepository != null
					&& !_groupRepository.getChildren().isEmpty()) {
				for (Iterator<Resource> it = _groupRepository.getChildren()
						.iterator(); it.hasNext();) {
					Resource child = it.next();
					child = cmsService.getResource(child,
							getSuperUserClientSession());
					if (!child.getActive()
							|| !CommonConstants.TYPE.GROUP.equals(child
									.getTypeId())) {
						it.remove();
					}
				}
			}
		}
		return _groupRepository;
	}

	private static final String MENU_ALIAS = "menu";

	@Override
	public Resource getMenuRepository() {
		if (_menuRepository == null) {
			Resource appContextRes = getApplicationContext();
			_menuRepository = cmsService.getResource(appContextRes, MENU_ALIAS,
					getSuperUserClientSession());
			if (_menuRepository != null
					&& _menuRepository.getChildren() != null
					&& !_menuRepository.getChildren().isEmpty()) {
				int i = 0;
				for (Iterator<Resource> it = _menuRepository.getChildren()
						.iterator(); it.hasNext();) {
					Resource child = it.next();
					child = cmsService.getResource(child,
							getSuperUserClientSession());
					if (!child.getActive()
							|| !CommonConstants.TYPE.MENUITEM.equals(child
									.getTypeId())) {
						it.remove();
					} else {
						_menuRepository.addChild(i++, child);
						MenuItem menuItem = (MenuItem) child.getObject();
						Resource nextRoot = menuItem.getChildren$3();
						nextRoot = cmsService.getResource(nextRoot,
								getSuperUserClientSession());
						int ii = 0;
						for (Iterator<Resource> itt = nextRoot.getChildren()
								.iterator(); itt.hasNext();) {
							Resource menu = itt.next();
							menu = cmsService.getResource(menu,
									getSuperUserClientSession());
							if (!menu.getActive()
									|| !CommonConstants.TYPE.MENUITEM
											.equals(menu.getTypeId())) {
								itt.remove();
							} else {
								child.addChild(ii++, menu);
							}
						}
					}
				}
			}
		}
		return _menuRepository;
	}

	@Override
	public Map<Long, Type> getTypeMap() {
		return typeMap;
	}

	@Override
	public void reload() {

	}
}