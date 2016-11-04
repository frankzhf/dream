package net.frank.dede.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.frank.dede.bean.DedeUploads;

import org.springframework.jdbc.core.RowMapper;

public final class DedeUploadsRowMapper implements RowMapper<DedeUploads> {

	@Override
	public DedeUploads mapRow(ResultSet rs, int index)
			throws SQLException {
		DedeUploads to = new DedeUploads();
		to.setAid(rs.getInt("aid"));
		to.setArcid(rs.getInt("arcid"));
		to.setTitle(rs.getString("title"));
		to.setUrl(rs.getString("url"));
		to.setMediatype(rs.getInt("mediatype"));
		to.setWidth(rs.getString("width"));
		to.setHeight(rs.getString("height"));
		to.setPlaytime(rs.getString("playtime"));
		to.setFilesize(rs.getInt("filesize"));
		to.setUptime(rs.getInt("uptime"));
		to.setMid(rs.getInt("mid"));
		return to;
	}
}
