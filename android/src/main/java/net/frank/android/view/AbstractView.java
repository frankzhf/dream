package net.frank.android.view;

import android.view.Menu;
import android.view.MenuItem;
import net.frank.android.activity.FrameActivity;

public abstract class AbstractView {
	
	private FrameActivity main;
	
	private int viewId;
	
	public AbstractView(FrameActivity main,int viewId){
		this.main = main;
		this.viewId = viewId;
	}
	
	public FrameActivity getMain(){
		return this.main;
	}
	
	public int getViewId(){
		return this.viewId;
	}
	
	public abstract void loadView();
	
	public abstract boolean onPrepareOptionsMenu(Menu menu);
	
	public abstract boolean onMenuItemSelected(int featureId, MenuItem item);
}
