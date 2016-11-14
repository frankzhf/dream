package net.frank.yangtes.modules.cms.dao;

import java.util.List;

import net.frank.yangtes.commons.persistence.CrudDao;
import net.frank.yangtes.commons.persistence.annotation.MyBatisDao;
import net.frank.yangtes.modules.cms.entity.Article;
import net.frank.yangtes.modules.cms.entity.Category;

/**
 * 文章DAO接口
 */
@MyBatisDao
public interface ArticleDao extends CrudDao<Article> {

	public List<Article> findByIdIn(String[] ids);

	public int updateHitsAddOne(String id);

	public int updateExpiredWeight(Article article);

	public List<Category> findStats(Category category);

}
