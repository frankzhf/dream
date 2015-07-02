package net.frank.dede.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.frank.dede.bean.DedeMtypes;

import org.springframework.jdbc.core.RowMapper;

public final class DedeMtypesRowMapper implements RowMapper<DedeMtypes> {

	@Override
	public DedeMtypes mapRow(ResultSet rs, int index)
			throws SQLException {
		DedeMtypes to = new DedeMtypes();
		to.setMtypeid(rs.getInt("mtypeid"));
		to.setMtypename(rs.getString("mtypename"));
		to.setChannelid(rs.getInt("channelid"));
		to.setMid(rs.getInt("mid"));
		return to;
	}
}
