package net.frank.dede.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.frank.dede.bean.DedeAddonsoft;

import org.springframework.jdbc.core.RowMapper;

public final class DedeAddonsoftRowMapper implements RowMapper<DedeAddonsoft> {

	@Override
	public DedeAddonsoft mapRow(ResultSet rs, int index)
			throws SQLException {
		DedeAddonsoft to = new DedeAddonsoft();
		to.setAid(rs.getInt("aid"));
		to.setTypeid(rs.getInt("typeid"));
		to.setFiletype(rs.getString("filetype"));
		to.setLanguage(rs.getString("language"));
		to.setSofttype(rs.getString("softtype"));
		to.setAccredit(rs.getString("accredit"));
		to.setOs(rs.getString("os"));
		to.setSoftrank(rs.getInt("softrank"));
		to.setOfficialurl(rs.getString("officialUrl"));
		to.setOfficialdemo(rs.getString("officialDemo"));
		to.setSoftsize(rs.getString("softsize"));
		to.setSoftlinks(rs.getString("softlinks").toCharArray());
		to.setIntroduce(rs.getString("introduce").toCharArray());
		to.setDaccess(rs.getInt("daccess"));
		to.setNeedmoney(rs.getInt("needmoney"));
		to.setTemplet(rs.getString("templet"));
		to.setUserip(rs.getString("userip"));
		to.setRedirecturl(rs.getString("redirecturl"));
		return to;
	}
}
