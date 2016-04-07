package net.frank.yangtes.modules.gen.dao;

import net.frank.yangtes.commons.persistence.CrudDao;
import net.frank.yangtes.commons.persistence.annotation.MyBatisDao;
import net.frank.yangtes.modules.gen.entity.GenTableColumn;

/**
 * 业务表字段DAO接口
 */
@MyBatisDao
public interface GenTableColumnDao extends CrudDao<GenTableColumn> {
	
	public void deleteByGenTableId(String genTableId);
}
