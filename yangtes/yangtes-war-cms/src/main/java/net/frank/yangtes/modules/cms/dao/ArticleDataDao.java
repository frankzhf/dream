package net.frank.yangtes.modules.cms.dao;

import net.frank.yangtes.commons.persistence.CrudDao;
import net.frank.yangtes.commons.persistence.annotation.MyBatisDao;
import net.frank.yangtes.modules.cms.entity.ArticleData;

/**
 * 文章DAO接口
 */
@MyBatisDao
public interface ArticleDataDao extends CrudDao<ArticleData> {
	
}
