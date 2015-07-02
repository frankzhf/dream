package net.frank.dede.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.frank.dede.bean.DedeVote;

import org.springframework.jdbc.core.RowMapper;

public final class DedeVoteRowMapper implements RowMapper<DedeVote> {

	@Override
	public DedeVote mapRow(ResultSet rs, int index)
			throws SQLException {
		DedeVote to = new DedeVote();
		to.setAid(rs.getInt("aid"));
		to.setVotename(rs.getString("votename"));
		to.setStarttime(rs.getInt("starttime"));
		to.setEndtime(rs.getInt("endtime"));
		to.setTotalcount(rs.getInt("totalcount"));
		to.setIsmore(rs.getByte("ismore"));
		to.setIsallow(rs.getByte("isallow"));
		to.setView(rs.getByte("view"));
		to.setSpec(rs.getInt("spec"));
		to.setIsenable(rs.getByte("isenable"));
		to.setVotenote(rs.getString("votenote").toCharArray());
		return to;
	}
}
