package net.frank.dede.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.frank.dede.bean.DedeAdvancedsearch;

import org.springframework.jdbc.core.RowMapper;

public final class DedeAdvancedsearchRowMapper implements RowMapper<DedeAdvancedsearch> {

	@Override
	public DedeAdvancedsearch mapRow(ResultSet rs, int index)
			throws SQLException {
		DedeAdvancedsearch to = new DedeAdvancedsearch();
		to.setMid(rs.getInt("mid"));
		to.setMaintable(rs.getString("maintable"));
		to.setMainfields(rs.getString("mainfields").toCharArray());
		to.setAddontable(rs.getString("addontable"));
		to.setAddonfields(rs.getString("addonfields").toCharArray());
		to.setForms(rs.getString("forms").toCharArray());
		to.setTemplate(rs.getString("template"));
		return to;
	}
}
