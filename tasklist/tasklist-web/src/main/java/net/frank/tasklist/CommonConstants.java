package net.frank.tasklist;

public interface CommonConstants extends net.frank.commons.CommonConstants {
	
	public String USER_WORKSPACE_ROOT_ALIAS = "tasklist";
	public String USER_WORKSPACE_DRAFT = "draft";
	public String USER_WORKSPACE_MY_TASK = "myTask";
	public String USER_WORKSPACE_PENDING_TASK = "pendingTask";
	
	
	public interface TYPE extends net.frank.commons.CommonConstants.TYPE{
		public Long TASK = 50002L;
		public Long TASKTOKEN = 50003L;
	}
	
	public interface CONTEXT extends net.frank.commons.CommonConstants.CONTEXT{
		public interface UNIT extends net.frank.commons.CommonConstants.CONTEXT.UNIT{
			public String TASKLIST = "tasklist";
		}
		
		public interface ACCOUNT extends net.frank.commons.CommonConstants.CONTEXT.ACCOUNT{
			public String TASKLIST = "tasklist";
		}
		
		public interface TASK{
			public String CHILDREN = "children";
			public String TOKEN="token";
		}
		
		public interface TASKTOKEN{
			public String ATTACH = "attach";
			public String SCREENSHOT="screenshot";
			public String COMMENT="comment";
		}
	}
}
