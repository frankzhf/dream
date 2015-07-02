package net.frank.dede.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.frank.dede.bean.DedeStepselect;

import org.springframework.jdbc.core.RowMapper;

public final class DedeStepselectRowMapper implements RowMapper<DedeStepselect> {

	@Override
	public DedeStepselect mapRow(ResultSet rs, int index)
			throws SQLException {
		DedeStepselect to = new DedeStepselect();
		to.setId(rs.getLong("id"));
		to.setItemname(rs.getString("itemname"));
		to.setEgroup(rs.getString("egroup"));
		to.setIssign(rs.getBoolean("issign"));
		to.setIssystem(rs.getBoolean("issystem"));
		return to;
	}
}
