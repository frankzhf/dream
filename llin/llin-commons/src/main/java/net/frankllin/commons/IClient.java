package net.frankllin.commons;

public interface IClient {
	/**
	 * 通道状态
	 * @return
	 */
	int statusCode();
	
	interface STATUS_CODE{
		int INIT = 0;
		int ON_LINE = 1;
		int OFF_LINE = -1;
	}
}
