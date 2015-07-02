package net.frank.dede.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.frank.dede.bean.DedeCoNote;

import org.springframework.jdbc.core.RowMapper;

public final class DedeCoNoteRowMapper implements RowMapper<DedeCoNote> {

	@Override
	public DedeCoNote mapRow(ResultSet rs, int index)
			throws SQLException {
		DedeCoNote to = new DedeCoNote();
		to.setNid(rs.getInt("nid"));
		to.setChannelid(rs.getInt("channelid"));
		to.setNotename(rs.getString("notename"));
		to.setSourcelang(rs.getString("sourcelang"));
		to.setUptime(rs.getInt("uptime"));
		to.setCotime(rs.getInt("cotime"));
		to.setPnum(rs.getInt("pnum"));
		to.setIsok(rs.getBoolean("isok"));
		to.setUsemore(rs.getBoolean("usemore"));
		to.setListconfig(rs.getString("listconfig").toCharArray());
		to.setItemconfig(rs.getString("itemconfig").toCharArray());
		return to;
	}
}
