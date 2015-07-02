package net.frank.android.activity;

import net.frank.android.holder.ContextHolder;
import net.frank.android.view.WelcomeSurfaceView;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

public abstract class FrameActivity extends Activity {

	protected Bitmap[] logos;

	private FrameHandler frameHandler;

	private WelcomeSurfaceView welcomeSurfaceView;
	
	private Integer width;
	
	private Integer height;
	
	public Integer getWidth(){
		return width;
	}
	public Integer getHeight(){
		return height;
	}

	public FrameHandler getFrameHandler() {
		return frameHandler;
	}

	public void setFrameHandler(FrameHandler frameHandler) {
		this.frameHandler = frameHandler;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ContextHolder.setContext(this);
		ContextHolder.setDbConfig(getDbConfig());
		FrameHandler frameHandler = new FrameHandler(this);
		setFrameHandler(frameHandler);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		setLogos();
		DisplayMetrics dm = new DisplayMetrics();
		super.getWindowManager().getDefaultDisplay().getMetrics(dm);
		width = dm.widthPixels;
		height = dm.heightPixels;
		welcomeSurfaceView = new WelcomeSurfaceView(ContextHolder.getContext(),
				getWidth(), getHeight(), logos, getSystemMainView());
		initDataBase();
		prepareViews();
		setContentView(welcomeSurfaceView);
	}

	public void toastOut(String message) {
		Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
	}
	
	public void onBackPressed(){
		this.showDialog(getSystemOutDialog());
	}
	
	public abstract void initDataBase();
	public abstract void handlerGoTo(int goTo);
	public abstract void prepareViews();
	public abstract void setLogos();
	public abstract int getSystemOutDialog();
	public abstract int getSystemMainView();
	public abstract String getDbConfig();
}