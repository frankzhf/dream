package net.frank.titian.define;

public interface Constants {
	
	public interface MAIL {
		public static final String RECEIVE_USERS = "mail.receive.users";
	    public static final String SMTP_HOST = "mail.smtp.host";
	    public static final String SMTP_PORT = "mail.smtp.port";
	    public static final String SENDER_USERNAME = "mail.sender.username";
	    public static final String SENDER_PASSWORD = "mail.sender.password";
	    public static final String SSL = "mail.ssl";
	    public static final String AUTH = "mail.auth";
	}
	
	public interface ACTION_RESULT{
		int SUCCESS = 200;
		int SKIP = 299;	//Current step execute failure, but the PullExecutor need to goon
		int FAILURE = 500;
	}
	
	public interface PHASE{
		String CREEP = "creep";
		String MAP = "map";
		String REDUCE = "reduce";
	}
	
	
	
}