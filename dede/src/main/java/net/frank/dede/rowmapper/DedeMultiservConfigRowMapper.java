package net.frank.dede.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.frank.dede.bean.DedeMultiservConfig;

import org.springframework.jdbc.core.RowMapper;

public final class DedeMultiservConfigRowMapper implements RowMapper<DedeMultiservConfig> {

	@Override
	public DedeMultiservConfig mapRow(ResultSet rs, int index)
			throws SQLException {
		DedeMultiservConfig to = new DedeMultiservConfig();
		to.setRemoteuploads(rs.getInt("remoteuploads"));
		to.setRemoteupurl(rs.getString("remoteupUrl").toCharArray());
		to.setRminfo(rs.getString("rminfo").toCharArray());
		to.setServinfo(rs.getString("servinfo").toCharArray());
		return to;
	}
}
