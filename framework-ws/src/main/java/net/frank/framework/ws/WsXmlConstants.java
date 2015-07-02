package net.frank.framework.ws;

import net.frank.commons.CommonConstants;

public interface WsXmlConstants extends CommonConstants {
	
	public interface Property{
		public String BEGIN = "<property name=\"";
		public String BEGIN_2 = "\" class=\"";
		public String BEGIN_3 = "\">";
		public String BEGIN_4 = "\" locate=\"";
		public String BEGIN_RESOURCE_REF = "\" refId=\"";
		public String END = "</property>";
		public String EMPTY_END = " />";
		public String END_PROPERTY_EMPTY_END = "\" />";
		public String TAG = "property";
	}
	
	public interface Resource{
		public String BEGIN = "<resource>";
		public String END = "</resource>";
		public String REF_BEGIN = "<resourceRef id=\"";
		public String REF_END = "\" />";
		public String TAG = "resource";
		public interface PROPERTY{
			public String ID = "id";
			public String PARENT_ID ="parentId";
			public String ACTIVE = "active";
			public String SYSTEM_NODE = "systemNode";
			public String ALIAS = "alias";
			public String CREATED_DT = "createdDt";
			public String LAST_UPDATED_DT = "lastUpdatedDt";
			public String CURRENT_ACCOUNT_PERMISSION = "currentAccountPermission";
			public String CURRENT_GROUP_PERMISSION = "currentGroupPermission";
			public String OTHERS_PERMISSION = "othersPermission";
			public String TYPE_ID = "typeId";
			public String OWN_RESOURCE_ID = "ownResourceId";
			public String OWN_GROUP_RESOURCE_ID = "ownGroupResourceId";
			public String LAST_ACCOUNT_RESOURCE_ID = "lastAccountResourceId";
			public String OBJECT = "object";
			public String CHILDREN = "children";
		}
	}
	
	public interface Children{
		public String BEGIN = "<children>";
		public String END = "</children>";
		public String EMPTY = "<children />";
		public String TAG = "children";
	}
	
	public interface CDATA{
		public String BEGIN = "<![CDATA[";
		public String END = "]]>";
	}
}
