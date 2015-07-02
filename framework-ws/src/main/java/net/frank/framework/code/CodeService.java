package net.frank.framework.code;

import java.util.List;

public interface CodeService{
	public String CODE_SERVICE_BEAN_ID = "codeService";
	public List<Code> getCodeList(String codeTypeId);
	public String getDesc(String codeTypeId,Long codeId);
	//public void reload();
}
