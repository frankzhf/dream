package net.frank.dede.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.frank.dede.bean.DedeAdmin;

import org.springframework.jdbc.core.RowMapper;

public final class DedeAdminRowMapper implements RowMapper<DedeAdmin> {

	@Override
	public DedeAdmin mapRow(ResultSet rs, int index)
			throws SQLException {
		DedeAdmin to = new DedeAdmin();
		to.setId(rs.getLong("id"));
		to.setUsertype(rs.getFloat("usertype"));
		to.setUserid(rs.getString("userid"));
		to.setPwd(rs.getString("pwd"));
		to.setUname(rs.getString("uname"));
		to.setTname(rs.getString("tname"));
		to.setEmail(rs.getString("email"));
		to.setTypeid(rs.getString("typeid").toCharArray());
		to.setLogintime(rs.getInt("logintime"));
		to.setLoginip(rs.getString("loginip"));
		return to;
	}
}
