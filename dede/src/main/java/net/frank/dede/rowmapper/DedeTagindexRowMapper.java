package net.frank.dede.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.frank.dede.bean.DedeTagindex;

import org.springframework.jdbc.core.RowMapper;

public final class DedeTagindexRowMapper implements RowMapper<DedeTagindex> {

	@Override
	public DedeTagindex mapRow(ResultSet rs, int index)
			throws SQLException {
		DedeTagindex to = new DedeTagindex();
		to.setId(rs.getLong("id"));
		to.setTag(rs.getString("tag"));
		to.setTypeid(rs.getInt("typeid"));
		to.setCount(rs.getInt("count"));
		to.setTotal(rs.getInt("total"));
		to.setWeekcc(rs.getInt("weekcc"));
		to.setMonthcc(rs.getInt("monthcc"));
		to.setWeekup(rs.getInt("weekup"));
		to.setMonthup(rs.getInt("monthup"));
		to.setAddtime(rs.getInt("addtime"));
		return to;
	}
}
