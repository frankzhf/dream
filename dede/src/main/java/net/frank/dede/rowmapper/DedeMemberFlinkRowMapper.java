package net.frank.dede.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.frank.dede.bean.DedeMemberFlink;

import org.springframework.jdbc.core.RowMapper;

public final class DedeMemberFlinkRowMapper implements RowMapper<DedeMemberFlink> {

	@Override
	public DedeMemberFlink mapRow(ResultSet rs, int index)
			throws SQLException {
		DedeMemberFlink to = new DedeMemberFlink();
		to.setAid(rs.getInt("aid"));
		to.setMid(rs.getInt("mid"));
		to.setTitle(rs.getString("title"));
		to.setUrl(rs.getString("url"));
		return to;
	}
}
