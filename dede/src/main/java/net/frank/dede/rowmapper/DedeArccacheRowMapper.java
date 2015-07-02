package net.frank.dede.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.frank.dede.bean.DedeArccache;

import org.springframework.jdbc.core.RowMapper;

public final class DedeArccacheRowMapper implements RowMapper<DedeArccache> {

	@Override
	public DedeArccache mapRow(ResultSet rs, int index)
			throws SQLException {
		DedeArccache to = new DedeArccache();
		to.setMd5hash(rs.getString("md5hash"));
		to.setUptime(rs.getInt("uptime"));
		to.setCachedata(rs.getString("cachedata").toCharArray());
		return to;
	}
}
