package net.frank.dede.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.frank.dede.bean.DedeMyad;

import org.springframework.jdbc.core.RowMapper;

public final class DedeMyadRowMapper implements RowMapper<DedeMyad> {

	@Override
	public DedeMyad mapRow(ResultSet rs, int index)
			throws SQLException {
		DedeMyad to = new DedeMyad();
		to.setAid(rs.getInt("aid"));
		to.setClsid(rs.getInt("clsid"));
		to.setTypeid(rs.getInt("typeid"));
		to.setTagname(rs.getString("tagname"));
		to.setAdname(rs.getString("adname"));
		to.setTimeset(rs.getInt("timeset"));
		to.setStarttime(rs.getInt("starttime"));
		to.setEndtime(rs.getInt("endtime"));
		to.setNormbody(rs.getString("normbody").toCharArray());
		to.setExpbody(rs.getString("expbody").toCharArray());
		return to;
	}
}
