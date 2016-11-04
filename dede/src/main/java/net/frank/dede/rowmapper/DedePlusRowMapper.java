package net.frank.dede.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.frank.dede.bean.DedePlus;

import org.springframework.jdbc.core.RowMapper;

public final class DedePlusRowMapper implements RowMapper<DedePlus> {

	@Override
	public DedePlus mapRow(ResultSet rs, int index)
			throws SQLException {
		DedePlus to = new DedePlus();
		to.setAid(rs.getInt("aid"));
		to.setPlusname(rs.getString("plusname"));
		to.setMenustring(rs.getString("menustring"));
		to.setMainurl(rs.getString("mainurl"));
		to.setWriter(rs.getString("writer"));
		to.setIsshow(rs.getInt("isshow"));
		to.setFilelist(rs.getString("filelist").toCharArray());
		return to;
	}
}
