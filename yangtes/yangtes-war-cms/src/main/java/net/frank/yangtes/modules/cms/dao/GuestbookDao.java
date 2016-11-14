package net.frank.yangtes.modules.cms.dao;

import net.frank.yangtes.commons.persistence.CrudDao;
import net.frank.yangtes.commons.persistence.annotation.MyBatisDao;
import net.frank.yangtes.modules.cms.entity.Guestbook;

/**
 * 留言DAO接口
 */
@MyBatisDao
public interface GuestbookDao extends CrudDao<Guestbook> {

}
