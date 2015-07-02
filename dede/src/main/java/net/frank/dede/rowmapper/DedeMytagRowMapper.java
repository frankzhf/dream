package net.frank.dede.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.frank.dede.bean.DedeMytag;

import org.springframework.jdbc.core.RowMapper;

public final class DedeMytagRowMapper implements RowMapper<DedeMytag> {

	@Override
	public DedeMytag mapRow(ResultSet rs, int index)
			throws SQLException {
		DedeMytag to = new DedeMytag();
		to.setAid(rs.getInt("aid"));
		to.setTypeid(rs.getInt("typeid"));
		to.setTagname(rs.getString("tagname"));
		to.setTimeset(rs.getInt("timeset"));
		to.setStarttime(rs.getInt("starttime"));
		to.setEndtime(rs.getInt("endtime"));
		to.setNormbody(rs.getString("normbody").toCharArray());
		to.setExpbody(rs.getString("expbody").toCharArray());
		return to;
	}
}
