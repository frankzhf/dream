package net.frank.dede.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.frank.dede.bean.DedeDiyforms;

import org.springframework.jdbc.core.RowMapper;

public final class DedeDiyformsRowMapper implements RowMapper<DedeDiyforms> {

	@Override
	public DedeDiyforms mapRow(ResultSet rs, int index)
			throws SQLException {
		DedeDiyforms to = new DedeDiyforms();
		to.setDiyid(rs.getInt("diyid"));
		to.setName(rs.getString("name"));
		to.setPosttemplate(rs.getString("posttemplate"));
		to.setViewtemplate(rs.getString("viewtemplate"));
		to.setListtemplate(rs.getString("listtemplate"));
		to.setTable(rs.getString("table"));
		to.setInfo(rs.getString("info").toCharArray());
		to.setPublic(rs.getBoolean("public"));
		return to;
	}
}
