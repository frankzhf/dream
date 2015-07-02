package net.frank.dede.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.frank.dede.bean.DedeFeedback;

import org.springframework.jdbc.core.RowMapper;

public final class DedeFeedbackRowMapper implements RowMapper<DedeFeedback> {

	@Override
	public DedeFeedback mapRow(ResultSet rs, int index)
			throws SQLException {
		DedeFeedback to = new DedeFeedback();
		to.setId(rs.getLong("id"));
		to.setAid(rs.getInt("aid"));
		to.setTypeid(rs.getInt("typeid"));
		to.setUsername(rs.getString("username"));
		to.setArctitle(rs.getString("arctitle"));
		to.setIp(rs.getString("ip"));
		to.setIscheck(rs.getInt("ischeck"));
		to.setDtime(rs.getInt("dtime"));
		to.setMid(rs.getInt("mid"));
		to.setBad(rs.getInt("bad"));
		to.setGood(rs.getInt("good"));
		to.setFtype(rs.getString("ftype"));
		to.setFace(rs.getInt("face"));
		to.setMsg(rs.getString("msg").toCharArray());
		return to;
	}
}
