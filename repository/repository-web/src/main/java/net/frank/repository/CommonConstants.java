package net.frank.repository;

public interface CommonConstants extends net.frank.commons.CommonConstants {
	public interface TYPE extends net.frank.commons.CommonConstants.TYPE{
		public Long FILE = 50000L;
		public Long SHAREDREQUEST = 50001L;
	}
	
	public interface PERMISSION_GROUP extends net.frank.commons.CommonConstants.PERMISSION_GROUP{
		public interface PUBLISHER{
			Byte CURRENT_ACCOUNT = 0;
			Byte CURRENT_GROUP = 7;
			Byte OTHERS = 0;
		}
	}
	
	public interface CMS_CODE extends net.frank.commons.CommonConstants.CMS_CODE{
		public Integer MESSAGE_LIMIT_MAX_CAPACITY = -101;
	}
	
	public interface CMS_MESSAGE extends net.frank.commons.CommonConstants.CMS_MESSAGE{
		public String MESSAGE_LIMIT_MAX_CAPACITY = "repository.errors.limit.max.capacity";
	}
	
	public interface CONTEXT extends net.frank.commons.CommonConstants.CONTEXT{
		public interface ACCOUNT extends net.frank.commons.CommonConstants.CONTEXT.ACCOUNT{
			public String REPOSITORY = "repository";
			public String MY_DOCUMENT="repository/myDocument";
			public String RECYCLE_BIN="repository/recycleBin";
		}
		public interface UNIT extends net.frank.commons.CommonConstants.CONTEXT.UNIT{
			public String REPOSITORY = "repository";
		}
	}
}
