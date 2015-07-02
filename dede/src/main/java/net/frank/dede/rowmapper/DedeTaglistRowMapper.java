package net.frank.dede.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.frank.dede.bean.DedeTaglist;

import org.springframework.jdbc.core.RowMapper;

public final class DedeTaglistRowMapper implements RowMapper<DedeTaglist> {

	@Override
	public DedeTaglist mapRow(ResultSet rs, int index)
			throws SQLException {
		DedeTaglist to = new DedeTaglist();
		to.setTid(rs.getInt("tid"));
		to.setAid(rs.getInt("aid"));
		to.setArcrank(rs.getInt("arcrank"));
		to.setTypeid(rs.getInt("typeid"));
		to.setTag(rs.getString("tag"));
		return to;
	}
}
