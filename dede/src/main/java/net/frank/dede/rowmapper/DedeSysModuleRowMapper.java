package net.frank.dede.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.frank.dede.bean.DedeSysModule;

import org.springframework.jdbc.core.RowMapper;

public final class DedeSysModuleRowMapper implements RowMapper<DedeSysModule> {

	@Override
	public DedeSysModule mapRow(ResultSet rs, int index)
			throws SQLException {
		DedeSysModule to = new DedeSysModule();
		to.setId(rs.getLong("id"));
		to.setHashcode(rs.getString("hashcode"));
		to.setModname(rs.getString("modname"));
		to.setIndexname(rs.getString("indexname"));
		to.setIndexurl(rs.getString("indexurl"));
		to.setIsmember(rs.getByte("ismember"));
		to.setMenustring(rs.getString("menustring").toCharArray());
		return to;
	}
}
