package net.frank.dede.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.frank.dede.bean.DedeAddonimages;

import org.springframework.jdbc.core.RowMapper;

public final class DedeAddonimagesRowMapper implements RowMapper<DedeAddonimages> {

	@Override
	public DedeAddonimages mapRow(ResultSet rs, int index)
			throws SQLException {
		DedeAddonimages to = new DedeAddonimages();
		to.setAid(rs.getInt("aid"));
		to.setTypeid(rs.getInt("typeid"));
		to.setPagestyle(rs.getInt("pagestyle"));
		to.setMaxwidth(rs.getInt("maxwidth"));
		to.setImgurls(rs.getString("imgurls").toCharArray());
		to.setRow(rs.getInt("row"));
		to.setCol(rs.getInt("col"));
		to.setIsrm(rs.getInt("isrm"));
		to.setDdmaxwidth(rs.getInt("ddmaxwidth"));
		to.setPagepicnum(rs.getInt("pagepicnum"));
		to.setTemplet(rs.getString("templet"));
		to.setUserip(rs.getString("userip"));
		to.setRedirecturl(rs.getString("redirecturl"));
		to.setBody(rs.getString("body").toCharArray());
		return to;
	}
}
