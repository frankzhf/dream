package net.frank.dede.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.frank.dede.bean.DedeMemberSpace;

import org.springframework.jdbc.core.RowMapper;

public final class DedeMemberSpaceRowMapper implements RowMapper<DedeMemberSpace> {

	@Override
	public DedeMemberSpace mapRow(ResultSet rs, int index)
			throws SQLException {
		DedeMemberSpace to = new DedeMemberSpace();
		to.setMid(rs.getInt("mid"));
		to.setPagesize(rs.getInt("pagesize"));
		to.setMatt(rs.getInt("matt"));
		to.setSpacename(rs.getString("spacename"));
		to.setSpacelogo(rs.getString("spacelogo"));
		to.setSpacestyle(rs.getString("spacestyle"));
		to.setSign(rs.getString("sign"));
		to.setSpacenews(rs.getString("spacenews").toCharArray());
		return to;
	}
}
