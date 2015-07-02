package net.frank.repository.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.core.RowMapper;

import net.frank.repository.dao.RepositoryDao;
import net.frank.repository.dao.impl.rowmapper.UnitOrder;

public class RepositoryDaoImpl extends JdbcDaoSupport implements RepositoryDao {
	
	
	private final static String RETRIEVE_ALL_UNIT_RESORUCE_ID = "SELECT A.RESOURCE_,B.ID,C.PARENT_ID FROM TB_UNIT A LEFT JOIN TB_RESOURCE B ON B.PARENT_ID = A.CONTEXT AND B.ALIAS='children' LEFT JOIN TB_RESOURCE C ON A.RESOURCE_ = C.ID";
	
	@Override
	public List<UnitOrder> listAllUnit() {
		List<UnitOrder> rt = getJdbcTemplate().query(RETRIEVE_ALL_UNIT_RESORUCE_ID, new RowMapper<UnitOrder>(){
			@Override
			public UnitOrder mapRow(ResultSet rs, int rowNum) throws SQLException {
				UnitOrder unitOrder = new UnitOrder();
				unitOrder.setResourceId(rs.getLong("RESOURCE_"));
				unitOrder.setId(rs.getLong("ID"));
				unitOrder.setParentId(rs.getLong("PARENT_ID"));
				return unitOrder;
			}
			
		});
		return rt;
	}

}
