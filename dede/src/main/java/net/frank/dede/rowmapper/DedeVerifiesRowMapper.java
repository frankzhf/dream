package net.frank.dede.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.frank.dede.bean.DedeVerifies;

import org.springframework.jdbc.core.RowMapper;

public final class DedeVerifiesRowMapper implements RowMapper<DedeVerifies> {

	@Override
	public DedeVerifies mapRow(ResultSet rs, int index)
			throws SQLException {
		DedeVerifies to = new DedeVerifies();
		to.setNameid(rs.getString("nameid"));
		to.setCthash(rs.getString("cthash"));
		to.setMethod(rs.getString("method"));
		to.setFilename(rs.getString("filename"));
		return to;
	}
}
