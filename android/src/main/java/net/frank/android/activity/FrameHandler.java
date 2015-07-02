package net.frank.android.activity;

import android.os.Handler;
import android.os.Message;

public class FrameHandler extends Handler{
	
	public FrameActivity frameActivity;

	public FrameHandler(FrameActivity frameActivity) {
		this.frameActivity = frameActivity;
	}
	
	public void handleMessage(Message msg){
		frameActivity.handlerGoTo(msg.what);
	}
	
}
