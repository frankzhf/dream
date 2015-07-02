package net.frank.framework.bo;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public interface IForm {
	public InputStream convertInputStream(String fieldName) throws IOException;
	
	public Map<Integer, Boolean> getPermissionMap();
	
	public void setPermissionMap( Map<Integer, Boolean> permissionMap);
	
	public Boolean getPermission(String key) ;

	public void setPermission(String key, Boolean obj);
}
