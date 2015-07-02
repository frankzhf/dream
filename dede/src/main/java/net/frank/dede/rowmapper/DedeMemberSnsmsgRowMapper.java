package net.frank.dede.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.frank.dede.bean.DedeMemberSnsmsg;

import org.springframework.jdbc.core.RowMapper;

public final class DedeMemberSnsmsgRowMapper implements RowMapper<DedeMemberSnsmsg> {

	@Override
	public DedeMemberSnsmsg mapRow(ResultSet rs, int index)
			throws SQLException {
		DedeMemberSnsmsg to = new DedeMemberSnsmsg();
		to.setId(rs.getLong("id"));
		to.setMid(rs.getInt("mid"));
		to.setUserid(rs.getString("userid"));
		to.setSendtime(rs.getInt("sendtime"));
		to.setMsg(rs.getString("msg"));
		return to;
	}
}
