package net.frank.android.view;

import net.frank.android.activity.FrameActivity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class WelcomeSurfaceView extends SurfaceView implements
		SurfaceHolder.Callback, Runnable {
	Paint paint;
	static int currentAlpha = 0;
	static int sleepSpan = 50;

	private int screenWidth;
	private int screenHeight;
	private Bitmap[] logos;
	Bitmap currentLogo;
	int currentX;
	int currentY;
	int activityMain;
	
	public void setLogos(Bitmap[] logos){
		this.logos = logos;
	}

	public WelcomeSurfaceView(Context context, int screenWidth,
			int screenHeight,Bitmap[] logos,int activityMain) {
		super(context);
		this.screenWidth = screenWidth;
		this.screenHeight = screenWidth;
		this.logos = logos;
		this.activityMain = activityMain;
		getHolder().addCallback(this);
		paint = new Paint();
		paint.setAntiAlias(true);
	}

	@Override
	public void draw(Canvas canvas) {
		paint.setColor(Color.BLACK);
		paint.setAlpha(255);
		canvas.drawRect(0, 0, screenWidth, screenHeight, paint);
		if (currentLogo == null)
			return;
		paint.setAlpha(currentAlpha);
		canvas.drawBitmap(currentLogo, currentX, currentY, paint);
	}

	@Override
	public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {

	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		new Thread(this).start();
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder arg0) {

	}

	@Override
	public void run() {
		for (Bitmap bm : logos) {
			currentLogo = bm;
			currentX = screenWidth / 2 - bm.getWidth() / 2;
			currentY = screenHeight / 2 - bm.getHeight() / 2;
			for (int i = 255; i > -10; i = i - 10) {
				currentAlpha = i;
				if (currentAlpha < 0) {
					currentAlpha = 0;
				}
				SurfaceHolder myholder = WelcomeSurfaceView.this.getHolder();
				Canvas canvas = myholder.lockCanvas();
				try {
					synchronized (myholder) {
						draw(canvas);
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					if (canvas != null) {
						myholder.unlockCanvasAndPost(canvas);
					}
				}
				try {
					if (i == 255) {
						Thread.sleep(1000);
					}
					Thread.sleep(sleepSpan);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		((FrameActivity) this.getContext()).getFrameHandler().sendEmptyMessage(activityMain);
	}
}