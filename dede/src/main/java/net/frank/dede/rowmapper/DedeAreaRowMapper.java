package net.frank.dede.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.frank.dede.bean.DedeArea;

import org.springframework.jdbc.core.RowMapper;

public final class DedeAreaRowMapper implements RowMapper<DedeArea> {

	@Override
	public DedeArea mapRow(ResultSet rs, int index)
			throws SQLException {
		DedeArea to = new DedeArea();
		to.setId(rs.getLong("id"));
		to.setName(rs.getString("name"));
		to.setReid(rs.getInt("reid"));
		to.setDisorder(rs.getInt("disorder"));
		return to;
	}
}
