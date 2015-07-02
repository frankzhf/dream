package net.frank.dede.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.frank.dede.bean.DedeMemberVhistory;

import org.springframework.jdbc.core.RowMapper;

public final class DedeMemberVhistoryRowMapper implements RowMapper<DedeMemberVhistory> {

	@Override
	public DedeMemberVhistory mapRow(ResultSet rs, int index)
			throws SQLException {
		DedeMemberVhistory to = new DedeMemberVhistory();
		to.setId(rs.getLong("id"));
		to.setMid(rs.getInt("mid"));
		to.setLoginid(rs.getString("loginid"));
		to.setVid(rs.getInt("vid"));
		to.setVloginid(rs.getString("vloginid"));
		to.setCount(rs.getInt("count"));
		to.setVip(rs.getString("vip"));
		to.setVtime(rs.getInt("vtime"));
		return to;
	}
}
