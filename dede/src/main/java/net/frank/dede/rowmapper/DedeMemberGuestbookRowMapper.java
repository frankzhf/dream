package net.frank.dede.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.frank.dede.bean.DedeMemberGuestbook;

import org.springframework.jdbc.core.RowMapper;

public final class DedeMemberGuestbookRowMapper implements RowMapper<DedeMemberGuestbook> {

	@Override
	public DedeMemberGuestbook mapRow(ResultSet rs, int index)
			throws SQLException {
		DedeMemberGuestbook to = new DedeMemberGuestbook();
		to.setAid(rs.getInt("aid"));
		to.setMid(rs.getInt("mid"));
		to.setGid(rs.getString("gid"));
		to.setTitle(rs.getString("title"));
		to.setUname(rs.getString("uname"));
		to.setEmail(rs.getString("email"));
		to.setQq(rs.getString("qq"));
		to.setTel(rs.getString("tel"));
		to.setIp(rs.getString("ip"));
		to.setDtime(rs.getInt("dtime"));
		to.setMsg(rs.getString("msg").toCharArray());
		return to;
	}
}
