package net.frank.dede.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.frank.dede.bean.DedeSysSet;

import org.springframework.jdbc.core.RowMapper;

public final class DedeSysSetRowMapper implements RowMapper<DedeSysSet> {

	@Override
	public DedeSysSet mapRow(ResultSet rs, int index)
			throws SQLException {
		DedeSysSet to = new DedeSysSet();
		to.setId(rs.getLong("id"));
		to.setSname(rs.getString("sname"));
		to.setItems(rs.getString("items").toCharArray());
		return to;
	}
}
