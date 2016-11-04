package net.frank.dede.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.frank.dede.bean.DedeSoftconfig;

import org.springframework.jdbc.core.RowMapper;

public final class DedeSoftconfigRowMapper implements RowMapper<DedeSoftconfig> {

	@Override
	public DedeSoftconfig mapRow(ResultSet rs, int index)
			throws SQLException {
		DedeSoftconfig to = new DedeSoftconfig();
		to.setDowntype(rs.getInt("downtype"));
		to.setIsmoresite(rs.getInt("ismoresite"));
		to.setGotojump(rs.getInt("gotojump"));
		to.setIslocal(rs.getInt("islocal"));
		to.setSites(rs.getString("sites").toCharArray());
		to.setDownmsg(rs.getString("downmsg").toCharArray());
		to.setMoresitedo(rs.getInt("moresitedo"));
		to.setDfrank(rs.getInt("dfrank"));
		to.setDfywboy(rs.getInt("dfywboy"));
		to.setArgrange(rs.getInt("argrange"));
		return to;
	}
}
