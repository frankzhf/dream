package net.frank.dede.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.frank.dede.bean.DedeCoOnepage;

import org.springframework.jdbc.core.RowMapper;

public final class DedeCoOnepageRowMapper implements RowMapper<DedeCoOnepage> {

	@Override
	public DedeCoOnepage mapRow(ResultSet rs, int index)
			throws SQLException {
		DedeCoOnepage to = new DedeCoOnepage();
		to.setId(rs.getLong("id"));
		to.setUrl(rs.getString("url"));
		to.setTitle(rs.getString("title"));
		to.setIssource(rs.getInt("issource"));
		to.setLang(rs.getString("lang"));
		to.setRule(rs.getString("rule").toCharArray());
		return to;
	}
}
