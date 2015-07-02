package net.frank.dede.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.frank.dede.bean.DedeFlink;

import org.springframework.jdbc.core.RowMapper;

public final class DedeFlinkRowMapper implements RowMapper<DedeFlink> {

	@Override
	public DedeFlink mapRow(ResultSet rs, int index)
			throws SQLException {
		DedeFlink to = new DedeFlink();
		to.setId(rs.getLong("id"));
		to.setSortrank(rs.getInt("sortrank"));
		to.setUrl(rs.getString("url"));
		to.setWebname(rs.getString("webname"));
		to.setMsg(rs.getString("msg"));
		to.setEmail(rs.getString("email"));
		to.setLogo(rs.getString("logo"));
		to.setDtime(rs.getInt("dtime"));
		to.setTypeid(rs.getInt("typeid"));
		to.setIscheck(rs.getInt("ischeck"));
		return to;
	}
}
