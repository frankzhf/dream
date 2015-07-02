package net.frank.cms.common;

import net.frank.framework.struts.StrutsConstants;

public interface CmsCommonConstants extends StrutsConstants{
	
	public interface FORWARD{
		public String SUCCESS = "success";
		public String FAILURE = "failure";
	}
	
	public interface PAGE_MODE{
		public String EDIT = "edit";
		public String VIEW = "view";
	}
	
	public interface CHECK_PERMISSION{
		public String REQUEST_ATTRIBLE_KEY = "checkPermission";
		public String SUCCESS = "success";
		public String FAILURE = "failure";
	}
	
	public interface HTML_DEF {
		public String SPACE = "&nbsp;";
		public String READONLY_VALUE = "readonly";
		public String BUTTON_DEFAULT_LABEL = "...";
		public interface INPUT_TYPE{
			public String TEXT = "text";
			public String BUTTON = "button";
		}
	}
}
