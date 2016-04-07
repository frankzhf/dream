package net.frank.yangtes.modules.gen.dao;

import net.frank.yangtes.commons.persistence.CrudDao;
import net.frank.yangtes.commons.persistence.annotation.MyBatisDao;
import net.frank.yangtes.modules.gen.entity.GenScheme;

/**
 * 生成方案DAO接口
 */
@MyBatisDao
public interface GenSchemeDao extends CrudDao<GenScheme> {
	
}