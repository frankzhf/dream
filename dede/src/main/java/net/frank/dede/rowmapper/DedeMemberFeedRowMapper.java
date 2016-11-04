package net.frank.dede.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.frank.dede.bean.DedeMemberFeed;

import org.springframework.jdbc.core.RowMapper;

public final class DedeMemberFeedRowMapper implements RowMapper<DedeMemberFeed> {

	@Override
	public DedeMemberFeed mapRow(ResultSet rs, int index)
			throws SQLException {
		DedeMemberFeed to = new DedeMemberFeed();
		to.setFid(rs.getInt("fid"));
		to.setMid(rs.getInt("mid"));
		to.setUserid(rs.getString("userid"));
		to.setUname(rs.getString("uname"));
		to.setType(rs.getString("type"));
		to.setAid(rs.getInt("aid"));
		to.setDtime(rs.getInt("dtime"));
		to.setTitle(rs.getString("title"));
		to.setNote(rs.getString("note"));
		to.setIscheck(rs.getInt("ischeck"));
		return to;
	}
}
