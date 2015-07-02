package net.frank.dede.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.frank.dede.bean.DedeSgpage;

import org.springframework.jdbc.core.RowMapper;

public final class DedeSgpageRowMapper implements RowMapper<DedeSgpage> {

	@Override
	public DedeSgpage mapRow(ResultSet rs, int index)
			throws SQLException {
		DedeSgpage to = new DedeSgpage();
		to.setAid(rs.getInt("aid"));
		to.setTitle(rs.getString("title"));
		to.setIsmake(rs.getInt("ismake"));
		to.setFilename(rs.getString("filename"));
		to.setKeywords(rs.getString("keywords"));
		to.setTemplate(rs.getString("template"));
		to.setLikeid(rs.getString("likeid"));
		to.setDescription(rs.getString("description"));
		to.setUptime(rs.getInt("uptime"));
		to.setBody(rs.getString("body").toCharArray());
		return to;
	}
}
