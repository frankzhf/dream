package net.frank.dede.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.frank.dede.bean.DedeScores;

import org.springframework.jdbc.core.RowMapper;

public final class DedeScoresRowMapper implements RowMapper<DedeScores> {

	@Override
	public DedeScores mapRow(ResultSet rs, int index)
			throws SQLException {
		DedeScores to = new DedeScores();
		to.setId(rs.getLong("id"));
		to.setTitles(rs.getString("titles"));
		to.setIcon(rs.getInt("icon"));
		to.setIntegral(rs.getInt("integral"));
		to.setIsdefault(rs.getBoolean("isdefault"));
		return to;
	}
}
