package net.frank.dede.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.frank.dede.bean.DedeArctiny;

import org.springframework.jdbc.core.RowMapper;

public final class DedeArctinyRowMapper implements RowMapper<DedeArctiny> {

	@Override
	public DedeArctiny mapRow(ResultSet rs, int index)
			throws SQLException {
		DedeArctiny to = new DedeArctiny();
		to.setId(rs.getLong("id"));
		to.setTypeid(rs.getInt("typeid"));
		to.setTypeid2(rs.getString("typeid2"));
		to.setArcrank(rs.getInt("arcrank"));
		to.setChannel(rs.getInt("channel"));
		to.setSenddate(rs.getInt("senddate"));
		to.setSortrank(rs.getInt("sortrank"));
		to.setMid(rs.getInt("mid"));
		return to;
	}
}
