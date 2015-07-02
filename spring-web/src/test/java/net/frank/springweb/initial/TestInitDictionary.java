package net.frank.springweb.initial;

import net.frank.dictionary.sex.bo.Sex;
import net.frank.dictionary.subject.bo.Subject;
import net.frank.framework.bo.Resource;
import net.frank.framework.service.ResourceService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestInitDictionary extends TestInitCase {
	protected ApplicationContext context = new ClassPathXmlApplicationContext(
			new String[] { "/applicationContext-datasource.xml",
					"/applicationContext-base.xml",
					"/applicationContext-dao.xml",
					"/applicationContext-service.xml" });

	private static final Byte ACCOUNT_PERMISSION = 7;

	private static final Byte GROUP_PERMISSION = 7;

	private static final Byte OTHERS_PERMISSION = 4;

	protected ResourceService resourceService;

	@Override
	public void setUp() {
		super.setUp();
		resourceService = (ResourceService) context.getBean("resourceService");
	}

	public void testSexDictionary() {
		Resource dictionaryRes = queryService.getResourceAsPath("/dictionary");
		Resource own = getRootAccount();
		Resource group = getAdminGroup();
		Resource sexRoot = resourceService.newResource("sex", dictionaryRes, 3L,
				true, own, group, ACCOUNT_PERMISSION, GROUP_PERMISSION,
				OTHERS_PERMISSION);
		resourceService.saveObject(sexRoot);
		createSex(sexRoot,"0","未知项");
		createSex(sexRoot,"1","男性");
		createSex(sexRoot,"2","女性");
		createSex(sexRoot,"3","女改男，男性");
		createSex(sexRoot,"4","男改女，女性");
		createSex(sexRoot,"9","未规定项");
	}

	public void testSubjectDictionary() {
		Resource dictionaryRes = queryService.getResourceAsPath("/dictionary");
		Resource own = getRootAccount();
		Resource group = getAdminGroup();
		Resource subjectRoot = resourceService.newResource("subject", dictionaryRes, 3L,
				true, own, group, ACCOUNT_PERMISSION, GROUP_PERMISSION,
				OTHERS_PERMISSION);
		resourceService.saveObject(subjectRoot);
		createSubject(subjectRoot,"01","语文");
		createSubject(subjectRoot,"02","数学");
		createSubject(subjectRoot,"03","英语");
		createSubject(subjectRoot,"04","物理");
		createSubject(subjectRoot,"05","化学");
		createSubject(subjectRoot,"06","政治");
		createSubject(subjectRoot,"07","体育");
		createSubject(subjectRoot,"08","历史");
		createSubject(subjectRoot,"09","地理");
	}
	
	private void createSex(Resource parent,String codeId,String codeDesc){
		Resource own = getRootAccount();
		Resource group = getAdminGroup();
		Resource sexRes =  resourceService.newResource(codeId, parent, 41L,
				true, own, group, ACCOUNT_PERMISSION, GROUP_PERMISSION,
				OTHERS_PERMISSION);
		resourceService.saveObject(sexRes);
		Sex sex = new Sex();
		sex.setResource(sexRes);
		sex.setChildren$3(null);
		sex.setCodeId(codeId);
		sex.setCodeDesc(codeDesc);
		resourceService.saveObject(sex);
	}
	
	private void createSubject(Resource parent,String codeId,String codeDesc){
		Resource own = getRootAccount();
		Resource group = getAdminGroup();
		Resource subjectRes =  resourceService.newResource(codeId, parent, 42L,
				true, own, group, ACCOUNT_PERMISSION, GROUP_PERMISSION,
				OTHERS_PERMISSION);
		resourceService.saveObject(subjectRes);
		Subject subject = new Subject();
		subject.setResource(subjectRes);
		subject.setChildren$3(null);
		subject.setCodeId(codeId);
		subject.setCodeDesc(codeDesc);
		resourceService.saveObject(subject);
	}

}