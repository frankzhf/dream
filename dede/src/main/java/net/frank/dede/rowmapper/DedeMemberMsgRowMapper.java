package net.frank.dede.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.frank.dede.bean.DedeMemberMsg;

import org.springframework.jdbc.core.RowMapper;

public final class DedeMemberMsgRowMapper implements RowMapper<DedeMemberMsg> {

	@Override
	public DedeMemberMsg mapRow(ResultSet rs, int index)
			throws SQLException {
		DedeMemberMsg to = new DedeMemberMsg();
		to.setId(rs.getLong("id"));
		to.setMid(rs.getInt("mid"));
		to.setUserid(rs.getString("userid"));
		to.setIp(rs.getString("ip"));
		to.setIscheck(rs.getInt("ischeck"));
		to.setDtime(rs.getInt("dtime"));
		to.setMsg(rs.getString("msg").toCharArray());
		return to;
	}
}
