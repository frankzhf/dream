package net.frank.dede.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.frank.dede.bean.DedePurview;

import org.springframework.jdbc.core.RowMapper;

public final class DedePurviewRowMapper implements RowMapper<DedePurview> {

	@Override
	public DedePurview mapRow(ResultSet rs, int index)
			throws SQLException {
		DedePurview to = new DedePurview();
		to.setMid(rs.getInt("mid"));
		to.setTypeid(rs.getInt("typeid"));
		to.setRank(rs.getInt("rank"));
		to.setPkey(rs.getString("pkey"));
		to.setPvalue(rs.getString("pvalue").toCharArray());
		return to;
	}
}
