package net.frank.android.alertdialog;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.view.View;

public abstract class PrepareAlertDialog extends Builder {
	
	private View myView;
	
	public void setMyView(View myView){
		this.myView = myView;
	}
	
	public View getMyView(){
		return myView;
	}
	
	public PrepareAlertDialog(Context context) {
		super(context);
	}
	
	public abstract void prepareView();
	
}
