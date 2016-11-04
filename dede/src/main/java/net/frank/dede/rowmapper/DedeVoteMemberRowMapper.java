package net.frank.dede.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.frank.dede.bean.DedeVoteMember;

import org.springframework.jdbc.core.RowMapper;

public final class DedeVoteMemberRowMapper implements RowMapper<DedeVoteMember> {

	@Override
	public DedeVoteMember mapRow(ResultSet rs, int index)
			throws SQLException {
		DedeVoteMember to = new DedeVoteMember();
		to.setId(rs.getLong("id"));
		to.setVoteid(rs.getInt("voteid"));
		to.setUserid(rs.getString("userid"));
		to.setUptime(rs.getInt("uptime"));
		return to;
	}
}
