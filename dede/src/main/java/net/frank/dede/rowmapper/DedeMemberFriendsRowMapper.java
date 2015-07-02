package net.frank.dede.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.frank.dede.bean.DedeMemberFriends;

import org.springframework.jdbc.core.RowMapper;

public final class DedeMemberFriendsRowMapper implements RowMapper<DedeMemberFriends> {

	@Override
	public DedeMemberFriends mapRow(ResultSet rs, int index)
			throws SQLException {
		DedeMemberFriends to = new DedeMemberFriends();
		to.setId(rs.getLong("id"));
		to.setFid(rs.getInt("fid"));
		to.setFloginid(rs.getString("floginid"));
		to.setFuname(rs.getString("funame"));
		to.setMid(rs.getInt("mid"));
		to.setAddtime(rs.getInt("addtime"));
		to.setFtype(rs.getByte("ftype"));
		to.setGroupid(rs.getInt("groupid"));
		to.setDescription(rs.getString("description"));
		return to;
	}
}
