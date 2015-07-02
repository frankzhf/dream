package net.frank.framework.service.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

import net.frank.commons.CommonConstants;
import net.frank.framework.bo.Acl;
import net.frank.framework.bo.BusinessObject;
import net.frank.framework.bo.Resource;
import net.frank.framework.bo.SystemHistory;
import net.frank.framework.bo.Type;
import net.frank.framework.dao.AclDao;
import net.frank.framework.dao.ResourceDao;
import net.frank.framework.dao.SystemHistoryDao;
import net.frank.framework.dao.TypeDao;
import net.frank.framework.service.CacheService;
import net.frank.framework.service.QueryService;
import net.frank.framework.service.ResourceFilter;

public class QueryServiceImpl extends BaseServiceImpl implements QueryService {

	private ResourceDao resourceDao;

	private TypeDao typeDao;

	private SystemHistoryDao systemHistoryDao;

	private AclDao aclDao;

	private CacheService cacheService;

	public void setResourceDao(ResourceDao resourceDao) {
		this.resourceDao = resourceDao;
	}

	public void setTypeDao(TypeDao typeDao) {
		this.typeDao = typeDao;
	}

	public void setSystemHistoryDao(SystemHistoryDao systemHistoryDao) {
		this.systemHistoryDao = systemHistoryDao;
	}

	public void setAclDao(AclDao aclDao) {
		this.aclDao = aclDao;
	}

	public void setCacheService(CacheService cacheService) {
		this.cacheService = cacheService;
	}

	@Override
	public List<Type> retrieveListType() {
		return typeDao.retriveTypeList();
	}

	@Override
	public Resource getResource(Long resourceId) {
		Resource param = new Resource();
		param.setId(resourceId);
		Object obj = getObject(param);
		if (obj != null && obj instanceof Resource)
			return (Resource) obj;
		else
			return null;
	}

	@Override
	public BusinessObject getBo(Resource resource) {
		Map<Long, Type> typeContentMap = cacheService.getTypeContent();
		BusinessObject bo = getBaseDao().getBusinessObject(
				typeContentMap.get(resource.getTypeId()).getEntityClassName(),
				resource.getId());
		if (bo == null) {
			return null;
		}
		bo.setResource(resource);
		return bo;
	}

	@Override
	public BusinessObject getBo(Long resourceId) {
		Resource _resource = getResource(resourceId);
		if (_resource == null) {
			return null;
		}
		return getBo(_resource);
	}

	@Override
	public Resource getResource(Long resourceParentId, String alias) {
		return resourceDao.retrieveResource(resourceParentId, alias);
	}

	@Override
	public List<Resource> retrieveResourceByParent(Long resourceParentId) {
		return resourceDao.retrieveChildren(resourceParentId);
	}

	@Override
	public List<Resource> retrieveResourceByType(Long typeId) {
		return resourceDao.retrieveResourceByType(typeId);
	}

	@Override
	public String getResourcePath(Resource resource) {
		Stack<Resource> stack = getNodeStack(resource.getId(), null);
		if (stack != null && stack.size() > 0) {
			if (stack.size() == 1) {
				return CommonConstants.PATH_SYMBOL;
			} else {
				StringBuffer sb = new StringBuffer(256);
				while (!stack.isEmpty()) {
					Resource r = stack.pop();
					if (!CommonConstants.PATH_SYMBOL.equals(r.getAlias()))
						sb.append(CommonConstants.PATH_SYMBOL).append(
								r.getAlias());
				}
				return sb.toString();
			}
		}
		return CommonConstants.EMPTY_STRING;
	}

	@Override
	public String getNodePath(Resource resource) {
		Stack<Resource> stack = getNodeStack(resource.getId(), null);
		StringBuffer sb = new StringBuffer(CommonConstants.LEFT_MED_BRACKET);
		if (stack != null) {
			while (!stack.isEmpty()) {
				Resource r = stack.pop();
				sb.append(CommonConstants.QUOT).append(r.getId()).append(CommonConstants.QUOT);
				if (!stack.isEmpty()) {
					sb.append(CommonConstants.COMMA);
				}
			}
		}
		sb.append(CommonConstants.RIGHT_MED_BRACKET);
		return sb.toString();
	}

	@Override
	public Stack<Resource> getNodeStack(Long resourceId) {
		return getNodeStack(resourceId, null);
	}

	@Override
	public Stack<Resource> getNodeStack(Long resourceId,
			Stack<Resource> returnValue) {
		if (returnValue == null)
			returnValue = new Stack<Resource>();
		Resource resource = getResource(resourceId);
		if (resource != null) {
			returnValue.push(resource);
			if (resource.getParentId() != null) {
				getNodeStack(resource.getParentId(), returnValue);
			}
		}
		return returnValue;
	}

	@Override
	public Resource getResourceAsPath(String path) {
		if (CommonConstants.PATH_SYMBOL.equals(path)) {
			return getResource(CommonConstants.RESOURCE_ID.ROOT);
		}
		if (path.charAt(0) == CommonConstants.PATH_SYMBOL_CHAR) {
			Resource parent = getResource(CommonConstants.RESOURCE_ID.ROOT);
			String _path = path.substring(1);
			return getResourceAsPath(parent, _path);
		}
		return null;
	}

	@Override
	public Resource getResourceAsPath(Resource current, String path) {
		if (path.charAt(0) == CommonConstants.PATH_SYMBOL_CHAR) {
			return null;
		}
		Resource parent = current;
		StringTokenizer st = new StringTokenizer(path,
				CommonConstants.PATH_SYMBOL);
		while (st.hasMoreElements()) {
			String alias = st.nextToken();
			parent = getResource(parent.getId(), alias);
			if (parent == null) {
				return null;
			}
		}
		return parent;
	}

	@Override
	public Resource getResourceWithRecursive(Resource resource) {
		return getResourceWithRecursive(resource, false, null);
	}

	@Override
	public Resource getResourceWithRecursive(Resource resource,
			boolean includeObject) {
		return getResourceWithRecursive(resource, includeObject, null);
	}

	@Override
	public Resource getResourceWithRecursive(Resource resource,
			boolean includeObject, ResourceFilter resourceFilter) {
		if (resource == null || resource.getId() == null) {
			return null;
		}
		Resource returnValue = resource;
		if (CommonConstants.TYPE.RESOURCE.equals(returnValue.getTypeId())) {
			List<Resource> children = retrieveResourceByParent(returnValue
					.getId());
			if (children != null && !children.isEmpty()) {
				returnValue.setChildren(children);
				for (Iterator<Resource> it = children.iterator(); it.hasNext();) {
					Resource child = it.next();
					if (resourceFilter == null || resourceFilter.filter(child)) {
						child = getResourceWithRecursive(child, includeObject,
								resourceFilter);
					} else {
						it.remove();
					}
				}
			}
		} else {
			if (includeObject) {
				returnValue.setObject(getBo(returnValue.getId()));
			}
		}

		return returnValue;
	}

	@Override
	public List<Acl> listAcl(Long resourceId) {
		return aclDao.listAcl(resourceId);
	}

	@Override
	public List<SystemHistory> listSystemHistory(Long resourceId) {
		return systemHistoryDao.listHistory(resourceId);
	}

	@Override
	public SystemHistory getSystemHistory(Long id) {
		return systemHistoryDao.getSystemHistory(id);
	}

	@Override
	public Acl getAcl(Long aclId) {
		return aclDao.getAcl(aclId);
	}

}
