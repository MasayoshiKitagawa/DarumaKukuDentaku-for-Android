package com.gmail.k0817m.DarumaDentaku;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;

public class MyView extends View {
	
	private Bitmap myBitmap;
	private Bitmap kotaeBitmap;
	private boolean shame;
	
	public String hidarime = "";
	public String migime = "";
	
	public MyView (Context c) {
		super(c);
		

		setFocusable(true);
		
		Resources res = this.getContext().getResources();
		
		myBitmap = BitmapFactory.decodeResource(res, R.drawable.normal);
		kotaeBitmap = BitmapFactory.decodeResource(res, R.drawable.over);
		shame = false;

	}
	
	
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		
		Log.w("CHECK", "onDraw");
	
		//viewサイズの取得
		int width = getMeasuredWidth();
		int height = getMeasuredHeight();
		//画像サイズの取得
		int darumaWidth = myBitmap.getWidth();
		int darumaHeight = myBitmap.getHeight();
		//pxをdipに変換
		final float scale = getContext().getResources().getDisplayMetrics().density;

		//画像を入れる四角形
        Rect src = new Rect(0,0,darumaWidth,darumaHeight);
        Rect dst = new Rect(0,0,width,height);

		
		Log.w("CHECK", "[" + width + "]");
		Log.w("CHECK", "[" + height + "]");
		Log.w("CHECK", "[" + darumaWidth + "]");
		Log.w("CHECK", "[" + darumaHeight + "]");
		Log.w("CHECK", "[" + scale + "]");
		
		//canvas.drawColor(Color.BLUE);
		
		Paint mainPaint = new Paint();
		mainPaint.setStyle(Paint.Style.FILL);
		mainPaint.setARGB(255, 203, 226, 165);
		
		
		if(!shame) {
			canvas.drawBitmap(myBitmap, src, dst, mainPaint);
		}else {
			canvas.drawBitmap(kotaeBitmap, src, dst, mainPaint);
		}
		
		
		canvas.drawText(migime, (width / 2) - (60 / scale), (height / 2) + (15 / scale), mainPaint);
		canvas.drawText(hidarime, (width / 2) + (47 / scale), (height / 2) + (15 / scale), mainPaint);
		

	}
	public void changeNormal(){
		//Log.d(TAG, "changeNormal");
		shame = false;
		invalidate();
	}
	
	public void changeShame(){
		//Log.d(TAG, "changeShame");
		shame = true;
		invalidate();
	}
}

