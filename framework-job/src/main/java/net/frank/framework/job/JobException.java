package net.frank.framework.job;

public final class JobException extends Exception {
	
	private static final long serialVersionUID = 7062072712155270112L;
	public JobException(){
		super();
	}
	public JobException(String message){
		super(message);
	}
	public JobException(String message,Throwable cause){
		super(message,cause);
	}
	public JobException(Throwable cause){
		super(cause);
	}
}
