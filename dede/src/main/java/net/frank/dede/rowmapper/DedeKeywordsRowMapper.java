package net.frank.dede.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.frank.dede.bean.DedeKeywords;

import org.springframework.jdbc.core.RowMapper;

public final class DedeKeywordsRowMapper implements RowMapper<DedeKeywords> {

	@Override
	public DedeKeywords mapRow(ResultSet rs, int index)
			throws SQLException {
		DedeKeywords to = new DedeKeywords();
		to.setAid(rs.getInt("aid"));
		to.setKeyword(rs.getString("keyword"));
		to.setRank(rs.getInt("rank"));
		to.setSta(rs.getInt("sta"));
		to.setRpurl(rs.getString("rpurl"));
		return to;
	}
}
