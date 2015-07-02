package net.frank.dede.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.frank.dede.bean.DedeArcatt;

import org.springframework.jdbc.core.RowMapper;

public final class DedeArcattRowMapper implements RowMapper<DedeArcatt> {

	@Override
	public DedeArcatt mapRow(ResultSet rs, int index)
			throws SQLException {
		DedeArcatt to = new DedeArcatt();
		to.setSortid(rs.getInt("sortid"));
		to.setAtt(rs.getString("att"));
		to.setAttname(rs.getString("attname"));
		return to;
	}
}
