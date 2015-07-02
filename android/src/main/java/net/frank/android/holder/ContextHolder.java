package net.frank.android.holder;

import android.content.Context;

public class ContextHolder {
	static ThreadLocal<Context> contextLocal = new ThreadLocal<Context>();
	static ThreadLocal<String> dbConfig = new ThreadLocal<String>();
	
	public static void setContext(Context context) {
		contextLocal.set(context);
	}

	public static Context getContext() {
		return contextLocal.get();
	}
	
	public static void setDbConfig(String dbString){
		dbConfig.set(dbString);
	}
	
	public static String getDbConfig(){
		return dbConfig.get();
	}
}
