package net.frank.dede.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.frank.dede.bean.DedeCoUrls;

import org.springframework.jdbc.core.RowMapper;

public final class DedeCoUrlsRowMapper implements RowMapper<DedeCoUrls> {

	@Override
	public DedeCoUrls mapRow(ResultSet rs, int index)
			throws SQLException {
		DedeCoUrls to = new DedeCoUrls();
		to.setId(rs.getLong("id"));
		to.setHash(rs.getString("hash"));
		to.setNid(rs.getInt("nid"));
		return to;
	}
}
