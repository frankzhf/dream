package net.frank.dede.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.frank.dede.bean.DedeMember;

import org.springframework.jdbc.core.RowMapper;

public final class DedeMemberRowMapper implements RowMapper<DedeMember> {

	@Override
	public DedeMember mapRow(ResultSet rs, int index)
			throws SQLException {
		DedeMember to = new DedeMember();
		to.setMid(rs.getInt("mid"));
		to.setMtype(rs.getString("mtype"));
		to.setUserid(rs.getString("userid"));
		to.setPwd(rs.getString("pwd"));
		to.setUname(rs.getString("uname"));
		to.setSex(rs.getString("sex"));
		to.setRank(rs.getInt("rank"));
		to.setUptime(rs.getInt("uptime"));
		to.setExptime(rs.getInt("exptime"));
		to.setMoney(rs.getInt("money"));
		to.setEmail(rs.getString("email"));
		to.setScores(rs.getInt("scores"));
		to.setMatt(rs.getInt("matt"));
		to.setSpacesta(rs.getInt("spacesta"));
		to.setFace(rs.getString("face"));
		to.setSafequestion(rs.getInt("safequestion"));
		to.setSafeanswer(rs.getString("safeanswer"));
		to.setJointime(rs.getInt("jointime"));
		to.setJoinip(rs.getString("joinip"));
		to.setLogintime(rs.getInt("logintime"));
		to.setLoginip(rs.getString("loginip"));
		to.setCheckmail(rs.getInt("checkmail"));
		return to;
	}
}
