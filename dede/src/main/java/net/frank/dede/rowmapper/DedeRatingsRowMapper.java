package net.frank.dede.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.frank.dede.bean.DedeRatings;

import org.springframework.jdbc.core.RowMapper;

public final class DedeRatingsRowMapper implements RowMapper<DedeRatings> {

	@Override
	public DedeRatings mapRow(ResultSet rs, int index)
			throws SQLException {
		DedeRatings to = new DedeRatings();
		to.setId(rs.getLong("id"));
		to.setTotalVotes(rs.getInt("total_votes"));
		to.setTotalValue(rs.getInt("total_value"));
		to.setUsedIps(rs.getString("used_ips").toCharArray());
		return to;
	}
}
