package net.frank.framework.navigation;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.digester.Digester;
import org.springframework.core.io.Resource;
import org.xml.sax.SAXException;

/**
 * @author Alex.Kwan
 * @version 1.0 Date 2002-8-2
 */
public class MenuRepository {
	private static Map<String,MenuRepository> instances = new HashMap<String,MenuRepository>();
	private List<Menu> topMenuList;
	private List<Menu> shortcutList;
	private Map<String,Menu> menuIndex;
	private Digester digester;
	private String instanceName;
	private String prefix;
	private NavigationRuleSet ruleSet;
	
	public synchronized static MenuRepository getInstance(String instanceName) {
		if (instanceName == null || instanceName.length() == 0) {
			throw new IllegalArgumentException(
				"instanceName can not be null or zero length");
		}
		
		MenuRepository instance = (MenuRepository) instances.get(instanceName);
		
		if (instance == null) {
			instance = new MenuRepository(instanceName);
			instances.put(instanceName, instance);
		}
		
		return instance;	
	}
	
	public void addMenuConfig(InputStream input) 
		throws SAXException, IOException {
		
		Digester dig = getNavigationDigester();
		dig.parse(input);
	}

	public void destroy() {
		if (digester != null) {
			digester.clear();
			digester = null;
		}
		
		if (topMenuList != null) {
			topMenuList.clear();
			topMenuList = null;
		}
		
		if (menuIndex != null) {
			menuIndex.clear();
			menuIndex = null;
		}
		
		if (shortcutList != null) {
			shortcutList.clear();
			shortcutList = null;
		}
		
		if (ruleSet != null) {
			ruleSet = null;
		}
		
		instances.remove(this.instanceName);
		
		if (instances.size() == 0) {
			instances.clear();
		}		
	}
	
	public void addMenu(Menu menu, String parentNameKey) {
		ensureTopMenuList();
		ensureShortcutList();
		ensureMenuIndex();
		
		if (menu == null) {
			return;
		}
		
		menu.setPath(prefix+menu.getPath());
//		if (menu.getPath().endsWith(".do")){
//		    menu.setPath(menu.getPath().substring(0,menu.getPath().length()-3));
//		}

		
		if (parentNameKey != null) {
			Menu parentMenu = getMenuByNameKey(parentNameKey);
			
			if (parentMenu != null) {
				parentMenu.addChild(menu);
				menuIndex.put(menu.getPath(), menu);
				
				if (menu.isShortcut()) {
					shortcutList.add(menu);
				}
				return;
			}
		}
		
		topMenuList.add(menu);
		
		menuIndex.put(menu.getPath(), menu);
		
		if (menu.isShortcut()) {
			shortcutList.add(menu);
		}
	}
	
	public List<Menu> getTopMenus() {
		ensureTopMenuList();
		return topMenuList;
	}
	
	public List<Menu> getShortcuts() {
		ensureShortcutList();
		return shortcutList;
	}
	
	public Menu getClosestMatchedMenu(String path) {
		if (path==null || path.length()==0){
			path="/";
		}
		
		
		Menu menu = null;
		
		if (path != null) {
			ensureMenuIndex();
			
			
			menu = (Menu) menuIndex.get(path);
	
			if (menu != null) {
				return menu;
			}
			
			int slashIndex = path.lastIndexOf("/");
			
			
			while (slashIndex > 0) {
				path = path.substring(0, slashIndex);
				List<Menu> topMenus = getTopMenus();
				
				for (Iterator<Menu> iter = topMenus.iterator(); iter.hasNext();) {
					menu = iter.next();
					Menu m = matchMenu(menu, path);
					
					if (m != null) {
						return m;
					}
				}

				slashIndex = path.lastIndexOf("/");				
			}	
		}	
		if (getTopMenus().size()>0){	
			return (Menu) getTopMenus().get(0);
		}
		return null;
	}
	
	public Menu getMenuByNameKey(String nameKey) {
		if (nameKey == null) {
			return null;
		}
		
		return getMenu(getTopMenus(), nameKey);
	}
	
	private Menu getMenu(List<Menu> menus, String nameKey) {
		Iterator<Menu> menuIterator = menus.iterator();
		while (menuIterator.hasNext()) {
			Menu menu = (Menu) menuIterator.next();
			
			if (menu.getName().equals(nameKey)) {
				return menu;
			} else {
				menu = getMenu(menu.getChildren(), nameKey);
				
				if (menu == null) {
					continue;
				} else {
					return menu;
				}
			}
		}

		return null;
	}
	
	private Menu matchMenu(Menu menu, String path) {
		if (menu.getPath().startsWith(path)) {
			return menu;
		}
		
		for (Iterator<Menu> itor = menu.getChildren().iterator();itor.hasNext();) {
			Menu m = matchMenu(itor.next(), path);
			
			if (m != null) {
				return m;
			}
		}
		
		return null;
	}
		
	private void ensureTopMenuList() {
		if (topMenuList == null) {
			topMenuList = new ArrayList<Menu>();
		}
	}
	
	private void ensureShortcutList() {
		if (shortcutList == null) {
			shortcutList = new ArrayList<Menu>();
		}
	}
	
	private void ensureMenuIndex() {
		if (menuIndex == null) {
			menuIndex = new HashMap<String,Menu>();
		}
	}
	
	private Digester getNavigationDigester() {
		if (digester == null) {
			digester = new Digester();
			ruleSet = new NavigationRuleSet(this.instanceName);
			digester.setValidating(false);
			digester.setNamespaceAware(true);
			digester.setUseContextClassLoader(true);
			digester.addRuleSet(ruleSet);
		}
		
		digester.clear();
		digester.push(this);
		return digester;
	}
	
	private MenuRepository(String instanceName) {
		this.instanceName = instanceName;
	}
	
	public static void main(String[] args) {
		MenuRepository repo = new MenuRepository("");
		Digester digester = repo.getNavigationDigester();
		try {
			digester.parse(new File("c:/work/forex/admin/web/WEB-INF/configs/admin/navigation.xml"));
			System.out.println(repo.getTopMenus());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param configFile
	 */
	public static MenuRepository loadConfig(String prefix, Resource configFile) {
		if (instances.containsKey(configFile.getFilename())){
			return (MenuRepository)instances.get(configFile.getFilename());
		}
		
		MenuRepository repo = getInstance(configFile.getFilename());
		repo.prefix = prefix;
		Digester digester = repo.getNavigationDigester();
		try {
			digester.parse(configFile.getInputStream());
		} catch (IOException e) {
			
		} catch (SAXException e) {
		}
		
		return repo;
	}
	
}
