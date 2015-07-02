package net.frank.dede.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.frank.dede.bean.DedeArcrank;

import org.springframework.jdbc.core.RowMapper;

public final class DedeArcrankRowMapper implements RowMapper<DedeArcrank> {

	@Override
	public DedeArcrank mapRow(ResultSet rs, int index)
			throws SQLException {
		DedeArcrank to = new DedeArcrank();
		to.setId(rs.getLong("id"));
		to.setRank(rs.getInt("rank"));
		to.setMembername(rs.getString("membername"));
		to.setAdminrank(rs.getInt("adminrank"));
		to.setMoney(rs.getInt("money"));
		to.setScores(rs.getInt("scores"));
		to.setPurviews(rs.getString("purviews").toCharArray());
		return to;
	}
}
