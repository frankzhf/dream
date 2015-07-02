package net.frank.dictionary.sex.render;

import java.util.Iterator;
import java.util.List;

import net.frank.dictionary.sex.bo.Sex;
import net.frank.framework.bo.Resource;
import net.frank.framework.bsui.content.type.BsRadioGroupRenderImpl;

public class SexRenderImpl extends BsRadioGroupRenderImpl {

	private static final String SEX_PATH = "/dictionary/sex";
	
	private static final Long TYPE = 41L;
	
	@Override
	public List<Resource> generateData() {
		Resource parent = getQueryService().getResourceAsPath(SEX_PATH);
		List<Resource> rt = getQueryService().retrieveResourceByParent(
				parent.getId());
		for (Iterator<Resource> it = rt.iterator(); it.hasNext();) {
			Resource child = it.next();
			Sex sex = (Sex) getQueryService().getBo(child);
			child.setObject(sex);
		}
		return rt;
	}

	@Override
	public Resource getSelectedData(Long resourceId) {
		Resource rt = getQueryService().getResource(resourceId);
		Sex sex = (Sex) getQueryService().getBo(rt.getId());
		rt.setObject(sex);
		return rt;
	}

	@Override
	public Long getTypeId() {
		return TYPE;
	}

}
