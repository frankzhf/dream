package net.frank.dede.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.frank.dede.bean.DedeDownloads;

import org.springframework.jdbc.core.RowMapper;

public final class DedeDownloadsRowMapper implements RowMapper<DedeDownloads> {

	@Override
	public DedeDownloads mapRow(ResultSet rs, int index)
			throws SQLException {
		DedeDownloads to = new DedeDownloads();
		to.setHash(rs.getString("hash"));
		to.setId(rs.getLong("id"));
		to.setDownloads(rs.getInt("downloads"));
		return to;
	}
}
