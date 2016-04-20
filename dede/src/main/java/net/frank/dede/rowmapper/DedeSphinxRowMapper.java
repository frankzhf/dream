package net.frank.dede.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.frank.dede.bean.DedeSphinx;

import org.springframework.jdbc.core.RowMapper;

public final class DedeSphinxRowMapper implements RowMapper<DedeSphinx> {

	@Override
	public DedeSphinx mapRow(ResultSet rs, int index)
			throws SQLException {
		DedeSphinx to = new DedeSphinx();
		to.setCountid(rs.getInt("countid"));
		to.setMaxaid(rs.getInt("maxaid"));
		return to;
	}
}
