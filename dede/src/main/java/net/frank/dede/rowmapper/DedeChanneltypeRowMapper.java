package net.frank.dede.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.frank.dede.bean.DedeChanneltype;

import org.springframework.jdbc.core.RowMapper;

public final class DedeChanneltypeRowMapper implements RowMapper<DedeChanneltype> {

	@Override
	public DedeChanneltype mapRow(ResultSet rs, int index)
			throws SQLException {
		DedeChanneltype to = new DedeChanneltype();
		to.setId(rs.getLong("id"));
		to.setNid(rs.getString("nid"));
		to.setTypename(rs.getString("typename"));
		to.setMaintable(rs.getString("maintable"));
		to.setAddtable(rs.getString("addtable"));
		to.setAddcon(rs.getString("addcon"));
		to.setMancon(rs.getString("mancon"));
		to.setEditcon(rs.getString("editcon"));
		to.setUseraddcon(rs.getString("useraddcon"));
		to.setUsermancon(rs.getString("usermancon"));
		to.setUsereditcon(rs.getString("usereditcon"));
		to.setFieldset(rs.getString("fieldset").toCharArray());
		to.setListfields(rs.getString("listfields").toCharArray());
		to.setAllfields(rs.getString("allfields").toCharArray());
		to.setIssystem(rs.getInt("issystem"));
		to.setIsshow(rs.getInt("isshow"));
		to.setIssend(rs.getInt("issend"));
		to.setArcsta(rs.getInt("arcsta"));
		to.setUsertype(rs.getString("usertype"));
		to.setSendrank(rs.getInt("sendrank"));
		to.setIsdefault(rs.getInt("isdefault"));
		to.setNeeddes(rs.getBoolean("needdes"));
		to.setNeedpic(rs.getBoolean("needpic"));
		to.setTitlename(rs.getString("titlename"));
		to.setOnlyone(rs.getInt("onlyone"));
		to.setDfcid(rs.getInt("dfcid"));
		return to;
	}
}
