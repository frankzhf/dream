package net.frank.knowledge;

public interface CommonConstants extends net.frank.commons.CommonConstants {
	public String USER_WORKSPACE_ROOT_ALIAS = "knowledge";
	public String USER_WORKSPACE_DRAFT = "draft";
	public String USER_WORKSPACE_PUBLISHED = "published";
	
	public interface Context extends net.frank.commons.CommonConstants.CONTEXT{
		
		public interface ACCOUNT extends net.frank.commons.CommonConstants.CONTEXT.ACCOUNT{
			public String DRAFTS = USER_WORKSPACE_ROOT_ALIAS + "/" +USER_WORKSPACE_DRAFT;
			//public String PUBLISHED = "published";
			//public String RECYCLE_BIN="recycleBin";
		}
		
	}
}
