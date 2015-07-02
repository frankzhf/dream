package net.frank.framework.struts.message;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.StringTokenizer;

import org.apache.struts.util.MessageResourcesFactory;
import org.apache.struts.util.PropertyMessageResources;

public class MultiMessageResources extends PropertyMessageResources {

	private static final long serialVersionUID = -3853619998971720747L;

	public MultiMessageResources(MessageResourcesFactory factory, String config) {
		super(factory, config);
	}

	public MultiMessageResources(MessageResourcesFactory factory,
			String config, boolean returnNull) {
		super(factory, config, returnNull);
	}

	@SuppressWarnings("unchecked")
	protected synchronized void loadLocale(String localeKey) {
		if (config != null && config.indexOf(",") < 0) {
			super.loadLocale(localeKey);
			return;
		}
		if (log.isTraceEnabled()) {
			log.trace("loadLocale(" + localeKey + ")");
		}
		if (locales.get(localeKey) != null) {
			return;
		}
		locales.put(localeKey, localeKey);
		StringTokenizer t = new StringTokenizer(config, ",");
		InputStream is = null;
		String name = null;
		Properties props = new Properties();
		ClassLoader classLoader = Thread.currentThread()
				.getContextClassLoader();
		if (classLoader == null) {
			classLoader = this.getClass().getClassLoader();
		}
		while (t.hasMoreTokens()) {
			name = t.nextToken().replace('.', '/');
			if (localeKey.length() > 0) {
				name += "_" + localeKey;
			}
			name += ".properties";
			name = name.trim();
			if (log.isTraceEnabled()) {
				log.trace("  Loading resource '" + name + "'");
			}
			is = classLoader.getResourceAsStream(name);
			if (is != null) {
				try {
					props.load(is);
				} catch (IOException e) {
					log.error("loadLocale()", e);
				} finally {
					try {
						is.close();
					} catch (IOException e) {
						log.error("loadLocale()", e);
					}
				}
			}
		}
		if (log.isTraceEnabled()) {
			log.trace("  Loading resource completed");
		}
		if (props.size() < 1) {
			return;
		}
		synchronized (messages) {
			Iterator<Object> names = props.keySet().iterator();
			while (names.hasNext()) {
				String key = (String) names.next();
				if (log.isTraceEnabled()) {
					log.trace("  Saving message key '"
							+ messageKey(localeKey, key));
				}
				messages.put(messageKey(localeKey, key), props.getProperty(key));
			}
		}
	}
}
