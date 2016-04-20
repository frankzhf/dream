package net.frank.dede.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.frank.dede.bean.DedeSearchCache;

import org.springframework.jdbc.core.RowMapper;

public final class DedeSearchCacheRowMapper implements RowMapper<DedeSearchCache> {

	@Override
	public DedeSearchCache mapRow(ResultSet rs, int index)
			throws SQLException {
		DedeSearchCache to = new DedeSearchCache();
		to.setHash(rs.getString("hash"));
		to.setLasttime(rs.getInt("lasttime"));
		to.setRsnum(rs.getInt("rsnum"));
		to.setIds(rs.getString("ids").toCharArray());
		return to;
	}
}
