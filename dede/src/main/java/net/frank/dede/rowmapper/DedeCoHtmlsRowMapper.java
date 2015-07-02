package net.frank.dede.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.frank.dede.bean.DedeCoHtmls;

import org.springframework.jdbc.core.RowMapper;

public final class DedeCoHtmlsRowMapper implements RowMapper<DedeCoHtmls> {

	@Override
	public DedeCoHtmls mapRow(ResultSet rs, int index)
			throws SQLException {
		DedeCoHtmls to = new DedeCoHtmls();
		to.setAid(rs.getInt("aid"));
		to.setNid(rs.getInt("nid"));
		to.setTypeid(rs.getInt("typeid"));
		to.setTitle(rs.getString("title"));
		to.setLitpic(rs.getString("litpic"));
		to.setUrl(rs.getString("url"));
		to.setDtime(rs.getInt("dtime"));
		to.setIsdown(rs.getBoolean("isdown"));
		to.setIsexport(rs.getBoolean("isexport"));
		to.setResult(rs.getString("result").toCharArray());
		return to;
	}
}
