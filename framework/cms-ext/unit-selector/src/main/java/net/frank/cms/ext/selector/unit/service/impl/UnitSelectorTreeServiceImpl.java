package net.frank.cms.ext.selector.unit.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import net.frank.cms.ext.selector.unit.dao.UnitSelectorDao;
import net.frank.commons.CommonConstants;
import net.frank.commons.util.StringUtil;
import net.frank.framework.bo.Resource;
import net.frank.framework.bo.Unit;
import net.frank.framework.security.Session;
import net.frank.framework.service.CmsService;
import net.frank.framework.service.DialogTreeService;
import net.frank.framework.service.impl.QueryServiceImpl;

public final class UnitSelectorTreeServiceImpl extends QueryServiceImpl implements
		DialogTreeService {

	private static final String DEFAULT_UNIT_ROOT_PATH = CommonConstants.PATH_SYMBOL
			+ CommonConstants.RESOURCE_ALIAS.UNIT_ROOT;

	private String unitRootPath;
	
	private UnitSelectorDao unitSelectorDao;

	private CmsService cmsService;

	public void setUnitRootPath(String unitRootPath) {
		this.unitRootPath = unitRootPath;
	}

	public void setCmsService(CmsService cmsService) {
		this.cmsService = cmsService;
	}
	
	public void setUnitSelectorDao(UnitSelectorDao unitSelectorDao){
		this.unitSelectorDao = unitSelectorDao;
	}

	@Override
	public Resource getRoot(Resource currentNode, Session session) {
		Resource rt = null;
		if (currentNode == null) {
			rt = cmsService.getResource(getUnitRoot(), session);
		} else {
			rt = cmsService.getResource(currentNode, session);
		}
		return rt;
	}

	/***
	 * unit structure ${unit}[Unit] $.{unit}[Resource] |--children | |--
	 * ${childUnit} | |-- $.{childUnit} | | |--children
	 */
	@Override
	public List<Resource> getChildren(Resource currentNode, Session session) {
		List<Resource> rt = new ArrayList<Resource>();
		Unit currUnit = (Unit) getBo(currentNode);
		Resource resUnitContext = currUnit.getContext$3();
		Resource resChildrenFolder = getResource(resUnitContext.getId(),
				CommonConstants.CONTEXT.UNIT.CHILDREN);
		resChildrenFolder = cmsService.getResource(resChildrenFolder, session);
		if (resChildrenFolder != null
				&& CommonConstants.CMS_CODE.MESSAGE_OK.equals(resChildrenFolder
						.getCode()) && resChildrenFolder.getChildren() != null
				&& !resChildrenFolder.getChildren().isEmpty()) {
			for (Iterator<Resource> it = resChildrenFolder.getChildren()
					.iterator(); it.hasNext();) {
				Resource child = it.next();
				child = cmsService.getResource(child, session);
				if (child != null
						&& CommonConstants.CMS_CODE.MESSAGE_OK.equals(child
								.getCode())
						&& CommonConstants.TYPE.UNIT.equals(child.getTypeId())) {
					rt.add(child);
				}
			}
		}
		return rt;
	}

	/**
	 * 
	 * return String as below ['1','37','1000022']
	 */
	@Override
	public String getSelectedLinks(Resource selectedNode, Session session) {
		Resource resUnitRoot = getResourceAsPath(getUnitRoot());
		StringBuffer sb = new StringBuffer(
				CommonConstants.DEFAULT_STRING_BUFFER_LENGTH);
		Stack<Resource> tmpStack = new Stack<Resource>();
		tmpStack.add(selectedNode);
		Resource _selectNode = cmsService.getResource(selectedNode, session);
		Resource parent = new Resource();
		parent.setId(_selectNode.getParentId());
		parent = cmsService.getResource(parent, session);
		while (!parent.getId().equals(resUnitRoot.getId())) {
			if (CommonConstants.CONTEXT.UNIT.CHILDREN.equals(parent.getAlias())) {
				_selectNode = parent;
				parent = new Resource();
				parent.setId(_selectNode.getParentId());
				parent = cmsService.getResource(parent, session);
				Unit parentUnit = unitSelectorDao.retrieveUnitByContext(parent);
				_selectNode = parentUnit.getResource();
				tmpStack.add(_selectNode);
				parent = new Resource();
				parent.setId(_selectNode.getParentId());
				parent = cmsService.getResource(parent, session);
			} 
		}
		
		sb.append(CommonConstants.LEFT_MED_BRACKET);
		sb.append(CommonConstants.QUOT).append(resUnitRoot.getId()).append(CommonConstants.QUOT);
		sb.append(CommonConstants.COMMA);
		if (tmpStack != null) {
			while (!tmpStack.isEmpty()) {
				Resource r = tmpStack.pop();
				sb.append(CommonConstants.QUOT).append(r.getId()).append(CommonConstants.QUOT);
				if (!tmpStack.isEmpty()) {
					sb.append(CommonConstants.COMMA);
				}
			}
		}
		sb.append(CommonConstants.RIGHT_MED_BRACKET);
		return sb.toString();
	}

	private String getUnitRoot() {
		String _unitRootPath = null;
		if (StringUtil.isEmpty(unitRootPath)) {
			_unitRootPath = DEFAULT_UNIT_ROOT_PATH;
		} else {
			_unitRootPath = unitRootPath;
		}
		return _unitRootPath;
	}

}
