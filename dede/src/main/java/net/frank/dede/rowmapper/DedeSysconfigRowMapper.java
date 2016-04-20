package net.frank.dede.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.frank.dede.bean.DedeSysconfig;

import org.springframework.jdbc.core.RowMapper;

public final class DedeSysconfigRowMapper implements RowMapper<DedeSysconfig> {

	@Override
	public DedeSysconfig mapRow(ResultSet rs, int index)
			throws SQLException {
		DedeSysconfig to = new DedeSysconfig();
		to.setAid(rs.getInt("aid"));
		to.setVarname(rs.getString("varname"));
		to.setInfo(rs.getString("info"));
		to.setGroupid(rs.getInt("groupid"));
		to.setType(rs.getString("type"));
		to.setValue(rs.getString("value").toCharArray());
		return to;
	}
}
