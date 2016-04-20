package net.frank.dede.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.frank.dede.bean.DedeSearchKeywords;

import org.springframework.jdbc.core.RowMapper;

public final class DedeSearchKeywordsRowMapper implements RowMapper<DedeSearchKeywords> {

	@Override
	public DedeSearchKeywords mapRow(ResultSet rs, int index)
			throws SQLException {
		DedeSearchKeywords to = new DedeSearchKeywords();
		to.setAid(rs.getInt("aid"));
		to.setKeyword(rs.getString("keyword"));
		to.setSpwords(rs.getString("spwords"));
		to.setCount(rs.getInt("count"));
		to.setResult(rs.getInt("result"));
		to.setLasttime(rs.getInt("lasttime"));
		to.setChannelid(rs.getInt("channelid"));
		to.setTypeid(rs.getInt("typeid"));
		return to;
	}
}
