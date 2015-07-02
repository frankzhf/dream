package net.frank.repository.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.frank.framework.bo.Account;
import net.frank.framework.bo.Acl;
import net.frank.framework.bo.Resource;
import net.frank.framework.bo.Unit;
import net.frank.framework.dao.AccountDao;
import net.frank.framework.dao.AclDao;
import net.frank.framework.service.QueryService;
import net.frank.repository.dao.RepositoryDao;
import net.frank.repository.dao.impl.rowmapper.UnitOrder;
import net.frank.repository.service.RepositoryQueryService;

public class RepositoryQueryServiceImpl implements RepositoryQueryService {

	private final static String UNIT_GROUP_FOLDER = "group";
	private final static String UNIT_PUBLISHER_SUFFIX = "-User-Publisher";
	
	private final static String PUBLISHED_FOLDER = "repository/published";
	private final static String PENDING_FOLDER = "repository/pending";
	private final static String ARCHIVE_FOLDER = "repository/archive";
	

	private RepositoryDao repositoryDao;
	private AclDao aclDao;
	private AccountDao accountDao;
	private QueryService queryService;

	public void setRepositoryDao(RepositoryDao repositoryDao) {
		this.repositoryDao = repositoryDao;
	}

	public void setAclDao(AclDao aclDao) {
		this.aclDao = aclDao;
	}

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	public void setQueryService(QueryService queryService) {
		this.queryService = queryService;
	}

	/***
	 * 
	 * 
	 ORDER BY TREE ASC RESOURCE_ ID PARENT_ID 1000149 1000146 33 1000177
	 * 1000174 1000146 1000205 1000202 1000146 1000233 1000230 1000202
	 * 
	 * RESULT [1000233, 1000205, 1000177, 1000149] 1000233 1000230 1000202
	 * 1000205 1000202 1000146 1000177 1000174 1000146 1000149 1000146 33
	 * 
	 * 
	 */

	@Override
	public List<Long> listAllUnit() {
		List<Long> rt = new ArrayList<Long>();
		List<UnitOrder> queryList = repositoryDao.listAllUnit();
		if (queryList != null && !queryList.isEmpty()) {
			Map<Long, UnitOrder> unitOrderMap = new HashMap<Long, UnitOrder>();
			for (int i = 0; i < queryList.size(); i++) {
				UnitOrder currOrder = queryList.get(i);
				unitOrderMap.put(currOrder.getId(), currOrder);
			}
			for (Iterator<UnitOrder> it = queryList.iterator(); it.hasNext();) {
				UnitOrder currOrder = it.next();
				if (unitOrderMap.get(currOrder.getParentId()) != null) {
					unitOrderMap.get(currOrder.getParentId()).addChild(
							currOrder);
					it.remove();
				}
			}
		}
		if (queryList != null && !queryList.isEmpty()) {
			for (int i = 0; i < queryList.size(); i++) {
				UnitOrder currOrder = queryList.get(i);
				rt = orderTreeAsc(currOrder, rt);
			}
		}
		return rt;
	}

	private List<Long> orderTreeAsc(UnitOrder unitOrder, List<Long> rt) {
		if (unitOrder.getChildren() != null
				&& !unitOrder.getChildren().isEmpty()) {
			for (Iterator<UnitOrder> it = unitOrder.getChildren().values()
					.iterator(); it.hasNext();) {
				UnitOrder child = it.next();
				orderTreeAsc(child, rt);
			}
		}
		rt.add(unitOrder.getResourceId());
		return rt;
	}

	@Override
	public List<Acl> listAcl(Long resourceId) {
		return aclDao.listAcl(resourceId);
	}

	@Override
	public List<Acl> listAcl(Long resourceId, Long staffId) {
		Account account = accountDao.retrieveAccountByStaff(staffId);
		return aclDao.listAclByResourceIdAndOwnId(resourceId, account
				.getResource().getId());
	}

	@Override
	public List<Acl> listAclByOwn(Long accountResourceId) {
		return aclDao.listAclByOwnId(accountResourceId);
	}

	@Override
	public Unit getUnitForResource(Resource resource) {
		List<Long> unitResourceList = listAllUnit();
		if (unitResourceList != null && !unitResourceList.isEmpty()) {
			for (int i = 0; i < unitResourceList.size(); i++) {
				Long resourceId = unitResourceList.get(i);
				Unit currUnit = (Unit) queryService.getBo(resourceId);
				Resource unitContext = currUnit.getContext$3();
				Long currResourceId = resource.getId();
				do {
					Resource currResource = queryService
							.getResource(currResourceId);
					if (currResource.getId().equals(unitContext.getId())) {
						return currUnit;
					}
					currResourceId = currResource.getParentId();
				} while (currResourceId != null);
			}
		}
		return null;
	}

	@Override
	public Resource getUnitPublisher(Unit unit) {
		String unitCode = unit.getUnitCode();
		Resource context = unit.getContext$3();
		Resource group = queryService.getResource(context.getId(),
				UNIT_GROUP_FOLDER);
		Resource publisherGroup = queryService.getResource(group.getId(),
				unitCode + UNIT_PUBLISHER_SUFFIX);
		return publisherGroup;
	}

	@Override
	public Resource getPendingFolder(Unit unit) {
		Resource context = unit.getContext$3();
		return queryService.getResourceAsPath(context,PENDING_FOLDER);
	}

	@Override
	public Resource getPublishedFolder(Unit unit) {
		Resource context = unit.getContext$3();
		return queryService.getResourceAsPath(context,PUBLISHED_FOLDER);
	}

	@Override
	public Resource getArchiveFolder(Unit unit) {
		Resource context = unit.getContext$3();
		return queryService.getResourceAsPath(context,ARCHIVE_FOLDER);
	}

}
