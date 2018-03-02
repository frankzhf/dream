package net.frank.yangtes.quartz.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import net.frank.yangtes.commons.persistence.CrudDao;
import net.frank.yangtes.commons.persistence.annotation.MyBatisDao;
import net.frank.yangtes.quartz.web.entity.Task;


@MyBatisDao
public interface TaskDao extends CrudDao<Task> {
	void changeStatus(@Param("id") String id,@Param("status") Byte status);
	
	List<Task> findRunningJobs();
	
	void touch(@Param("id") String id);
}
