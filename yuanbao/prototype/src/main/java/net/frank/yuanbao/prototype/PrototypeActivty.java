package net.frank.yuanbao.prototype;

import net.frank.yuanbao.prototype.R;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import net.frank.android.activity.FrameActivity;

public class PrototypeActivty extends FrameActivity {

	@Override
	public void initDataBase() {
		
	}

	@Override
	public void handlerGoTo(int goTo) {

	}

	@Override
	public void setLogos() {
		logos = new Bitmap[2];
		logos[0] = BitmapFactory.decodeResource(getResources(),
				R.drawable.dukea);
		logos[1] = BitmapFactory.decodeResource(getResources(),
				R.drawable.dukeb);
	}

	@Override
	public int getSystemOutDialog() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getSystemMainView() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getDbConfig() {
		return "data/net.frank.yuanbao.prototype/db";
	}

	@Override
	public void prepareViews() {
		// TODO Auto-generated method stub
		
	}

}
