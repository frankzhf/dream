package net.frank.dictionary.subject.render;

import java.util.Iterator;
import java.util.List;

import net.frank.dictionary.subject.bo.Subject;
import net.frank.framework.bo.Resource;
import net.frank.framework.bsui.content.type.BsSelectGroupRenderImpl;

public class SubjectRenderImpl extends BsSelectGroupRenderImpl {
	
	private static final String SUBJECT_PATH = "/dictionary/subject";
	
	private static final Long TYPE = 42L;
	
	@Override
	public List<Resource> generateData() {
		Resource parent = getQueryService().getResourceAsPath(SUBJECT_PATH);
		List<Resource> rt = getQueryService().retrieveResourceByParent(
				parent.getId());
		for (Iterator<Resource> it = rt.iterator(); it.hasNext();) {
			Resource child = it.next();
			Subject Subject = (Subject) getQueryService().getBo(child);
			child.setObject(Subject);
		}
		return rt;
	}

	@Override
	public Resource getSelectedData(Long resourceId) {
		Resource rt = getQueryService().getResource(resourceId);
		Subject subject = (Subject) getQueryService().getBo(rt.getId());
		rt.setObject(subject);
		return rt;
	}

	@Override
	public Long getTypeId() {
		return TYPE;
	}

}
