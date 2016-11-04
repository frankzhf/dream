package net.frank.dede.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.frank.dede.bean.DedeCoMediaurls;

import org.springframework.jdbc.core.RowMapper;

public final class DedeCoMediaurlsRowMapper implements RowMapper<DedeCoMediaurls> {

	@Override
	public DedeCoMediaurls mapRow(ResultSet rs, int index)
			throws SQLException {
		DedeCoMediaurls to = new DedeCoMediaurls();
		to.setNid(rs.getInt("nid"));
		to.setHash(rs.getString("hash"));
		to.setTofile(rs.getString("tofile"));
		return to;
	}
}
