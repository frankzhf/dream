package net.frank.yangtes.modules.cms.dao;

import java.util.List;
import java.util.Map;

import net.frank.yangtes.commons.persistence.TreeDao;
import net.frank.yangtes.commons.persistence.annotation.MyBatisDao;
import net.frank.yangtes.modules.cms.entity.Category;

/**
 * 栏目DAO接口
 */
@MyBatisDao
public interface CategoryDao extends TreeDao<Category> {
	
	public List<Category> findModule(Category category);

	public List<Category> findByModule(String module);
	
	public List<Category> findByParentId(String parentId, String isMenu);

	public List<Category> findByParentIdAndSiteId(Category entity);
	
	public List<Map<String, Object>> findStats(String sql);

	
}
