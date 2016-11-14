package net.frank.yangtes.modules.cms.dao;

import java.util.List;

import net.frank.yangtes.commons.persistence.CrudDao;
import net.frank.yangtes.commons.persistence.annotation.MyBatisDao;
import net.frank.yangtes.modules.cms.entity.Link;

/**
 * 链接DAO接口
 */
@MyBatisDao
public interface LinkDao extends CrudDao<Link> {
	
	public List<Link> findByIdIn(String[] ids);
	
	public int updateExpiredWeight(Link link);
}
