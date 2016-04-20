package net.frank.cms.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;

import net.frank.cms.dao.TypeRegistrationDao;
import net.frank.framework.bo.Resource;
import net.frank.framework.bo.Type;
import net.frank.framework.dao.impl.BaseJdbcDaoImpl;

public class TypeRegistrationDaoImpl extends BaseJdbcDaoImpl implements
		TypeRegistrationDao {
	
	private static final String INSERT_RESOURCE = 
			"INSERT INTO TB_RESOURCE(" +
				"ID,ACTIVE,SYSTEMNODE,ALIAS,CREATEDDT,"+
				"LASTUPDATEDT,CUR_ACC_PER,CUR_GRP_PER,OTHERS_PER,PARENT_ID,"+
				"TYPE_ID,OWN_RES_ID,OWN_GROUP_RES_ID,LAST_ACC_RES_ID)"+
			"VALUES ("+
				"?,?,?,?,?,"+
				"?,?,?,?,?,"+
				"?,?,?,?)";
	
	private static final String INSERT_TYPE = 
			"INSERT INTO TB_TYPE(" +
				"TYPE_KEY,DESCRIPTION,ENTITY_CLASS_NAME,RESOURCE_)" +
			"VALUES("+
				"?,?,?,?)";
	
	@Override
	public void insertResource(final Resource resource) {
		final Date currentTime = new Date();
		getJdbcTemplate().execute(INSERT_RESOURCE,new PreparedStatementCallback<Object>(){
			@Override
			public Object doInPreparedStatement(PreparedStatement ps)
					throws SQLException, DataAccessException {
				ps.setLong(1, resource.getId());
				ps.setBoolean(2, resource.getActive());
				ps.setBoolean(3, resource.getSystemNode());
				ps.setString(4, resource.getAlias());
				ps.setObject(5,currentTime);
				ps.setObject(6,currentTime);
				ps.setByte(7, resource.getCurrentAccountPermission());
				ps.setByte(8, resource.getCurrentGroupPermission());
				ps.setByte(9, resource.getOthersPermission());
				ps.setLong(10,resource.getParentId());
				ps.setLong(11, resource.getTypeId());
				ps.setLong(12, resource.getOwnResourceId());
				ps.setLong(13, resource.getOwnGroupResourceId());
				ps.setLong(14, resource.getLastAccountResourceId());
				ps.execute();
				return null;
			}
		});
	}
		
	@Override
	public void insertType(final Type type) {
		getJdbcTemplate().execute(INSERT_TYPE,new PreparedStatementCallback<Object>(){
			@Override
			public Object doInPreparedStatement(PreparedStatement ps)
					throws SQLException, DataAccessException {
				ps.setString(1, type.getTypeKey());
				ps.setString(2, type.getDescription());
				ps.setString(3, type.getEntityClassName());
				ps.setLong(4, type.getResource().getId());
				ps.execute();
				return null;
			}
		});
	}

}
