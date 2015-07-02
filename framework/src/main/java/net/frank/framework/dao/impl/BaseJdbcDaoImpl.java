package net.frank.framework.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import net.frank.commons.CommonConstants;
import net.frank.framework.dao.BaseJdbcDao;

public class BaseJdbcDaoImpl extends JdbcDaoSupport implements BaseJdbcDao{
		
	
	private static final String sql0="SELECT ";
	
	private static final String sql1=".NEXTVAL FROM DUAL";
	
	
	public Long getSeqNext(String seqName){
		StringBuffer sql = new StringBuffer(CommonConstants.SHORT_STRING_BUFFER_LENGTH);
		sql.append(sql0).append(seqName).append(sql1);
		return getJdbcTemplate().query(sql.toString(), new ResultSetExtractor<Long>(){
			@Override
			public Long extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if(rs!=null && rs.next()){
					return rs.getLong(1);
				}else{
					return 0L;
				}
			}		
		});
	}
	
	public void executeSql(String sql){
		getJdbcTemplate().execute(sql);
	}

	@Override
	public Object executeQuery(String sql) {
		return getJdbcTemplate().queryForObject(sql,Object.class);
	}
	
}
