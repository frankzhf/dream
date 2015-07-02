package net.frank.framework.spring.i18n;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

public class PatternResolverResourceBundleMessageSource extends
		ResourceBundleMessageSource {
	
	private List<String> pathArray;
	
	public List<String> getPathArray() {
		return pathArray;
	}
	
	public void setPathArray(List<String> pathArray) {
		this.pathArray = pathArray;
		ResourcePatternResolver patternResolver = new PathMatchingResourcePatternResolver();
		if(getPathArray()!=null){
			List<String> basenames = new ArrayList<String>();
			for(Iterator<String> it = getPathArray().iterator();it.hasNext();){
				String path = it.next();
				try {
					String preffix = path.substring(path.indexOf(":")+1);
					preffix = preffix.substring(0,preffix.lastIndexOf("/")+1);
					Resource[] resources = patternResolver.getResources(path);
					if(resources!= null && resources.length>0){
						for(Resource resource : resources){
							String fullPath = preffix+resource.getFilename().substring(0, resource.getFilename().lastIndexOf("."));
							basenames.add(fullPath);
						}
					}
					
				}catch (IOException e) {
		            logger.error("Path:" + path + " is invalid");
		        }
			}
			if(basenames!=null && !basenames.isEmpty()){
				setBasenames(basenames.toArray(new String[basenames.size()]));
			}
		}
	}
	
	/***
	public static void main(String[] args){
		PatternResolverResourceBundleMessageSource test =  new PatternResolverResourceBundleMessageSource();
		List<String> pathArray = new ArrayList<String>();
		pathArray.add("classpath:messages/messages*.properties");
		pathArray.add("classpath:messages/extension/messages*.properties");
		test.setPathArray(pathArray);
	}
	***/
}