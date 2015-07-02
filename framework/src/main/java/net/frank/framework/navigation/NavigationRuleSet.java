package net.frank.framework.navigation;

import org.apache.commons.digester.Digester;
import org.apache.commons.digester.Rule;
import org.apache.commons.digester.RuleSetBase;
import org.xml.sax.Attributes;

/**
 * @author Alex.Kwan
 * @version 1.0 Date 2002-8-2
 */
public class NavigationRuleSet extends RuleSetBase {
	private String instanceName;
	
	public NavigationRuleSet(String instanceName) {
		setInstanceName(instanceName);
	}
		
	public synchronized void setInstanceName(String instanceName) {
		if (instanceName == null || instanceName.length() == 0) {
			throw new IllegalArgumentException(
				"instanceName can not be null or zero length");
		}
		
		this.instanceName = instanceName;	
	}
	
	public synchronized String getInstanceName() {
		return instanceName;
	}
	
	public void addRuleInstances(Digester digester) {
		digester.addObjectCreate("*/menu", Menu.class);
		digester.addSetProperties("*/menu");
		digester.addRule("*/menu", new AddMenuRule());
	}


	final class AddMenuRule extends Rule {
		private String parentNameKey = null;

		public void begin(String arg0, String arg1, Attributes attributes){
			parentNameKey = attributes.getValue("parentNameKey");

			Digester digester = getDigester();
			Object obj = digester.peek(1);
			
			if (obj instanceof MenuRepository) {
				MenuRepository repository = (MenuRepository) obj;
				repository.addMenu((Menu) digester.peek(), parentNameKey);
			} else if (obj instanceof Menu) {
				String instanceName = getInstanceName();
				MenuRepository repository = 
					MenuRepository.getInstance(instanceName);
				repository.addMenu((Menu) digester.peek(), 
					((Menu) obj).getName());
			} else {
				throw new IllegalStateException(
					"stack can only contains Menu or MenuRepository");
			}
		}
		
		public void finish() {
			parentNameKey = null;
		}
	}
	
}
