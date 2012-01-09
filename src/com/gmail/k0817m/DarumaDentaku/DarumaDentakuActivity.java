package com.gmail.k0817m.DarumaDentaku;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;

public class DarumaDentakuActivity extends Activity implements OnClickListener {
	
			//ボタンの配列
			Button mButton[];
			
			//idの配列
			int mId[] = {R.id.button1,R.id.button2,R.id.button3,
					R.id.button4,R.id.button5,R.id.button6,R.id.button7,
					R.id.button8,R.id.button9,R.id.buttonKeisan,R.id.buttonReset
			};
			
			//キー
			private final int KEY_1 = 0;
			private final int KEY_2 = 1;
			private final int KEY_3 = 2;
			private final int KEY_4 = 3;
			private final int KEY_5 = 4;
			private final int KEY_6 = 5;
			private final int KEY_7 = 6;
			private final int KEY_8 = 7;
			private final int KEY_9 = 8;
			private final int KEY_KEISAN = 9;
			private final int KEY_RESET = 10;
			
			MyView mView;
			
			//右目
			public String migime = "";
			//左目
			public String hidarime = "";
			
			//前の処理
			int beforeStatus = 0;
			
			//合計
			int total = 0;
			
			//目の数字
			int migimeValue = 0;
			int hidarimeValue = 0;
			
			//目に数字が入っているか判別する変数
			int migimeNum = 0;
			int hidarimeNum = 0;
			
			MediaPlayer mMp01;
			MediaPlayer mMp02;
			MediaPlayer mMp03;
			MediaPlayer mMp04;
			MediaPlayer mMp05;
			MediaPlayer mMp06;
			MediaPlayer mMp07;
			MediaPlayer mMp08;
			MediaPlayer mMp09;
			MediaPlayer mMp10;
			MediaPlayer mMp12;
			MediaPlayer mMp14;
			MediaPlayer mMp15;
			MediaPlayer mMp16;
			MediaPlayer mMp18;
			MediaPlayer mMp20;
			MediaPlayer mMp21;
			MediaPlayer mMp24;
			MediaPlayer mMp25;
			MediaPlayer mMp27;
			MediaPlayer mMp28;
			MediaPlayer mMp30;
			MediaPlayer mMp32;
			MediaPlayer mMp35;
			MediaPlayer mMp36;
			MediaPlayer mMp40;
			MediaPlayer mMp42;
			MediaPlayer mMp45;
			MediaPlayer mMp48;
			MediaPlayer mMp49;
			MediaPlayer mMp54;
			MediaPlayer mMp56;
			MediaPlayer mMp63;
			MediaPlayer mMp64;
			MediaPlayer mMp72;
			MediaPlayer mMp81;

			
			
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setVolumeControlStream(AudioManager.STREAM_MUSIC);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main);
        
        //音声
        mMp01 = MediaPlayer.create(this, R.raw.sound01);
        mMp02 = MediaPlayer.create(this, R.raw.sound02);
        mMp03 = MediaPlayer.create(this, R.raw.sound03);
        mMp04 = MediaPlayer.create(this, R.raw.sound04);
        mMp05 = MediaPlayer.create(this, R.raw.sound05);
        mMp06 = MediaPlayer.create(this, R.raw.sound06);
        mMp07 = MediaPlayer.create(this, R.raw.sound07);
        mMp08 = MediaPlayer.create(this, R.raw.sound08);
        mMp09 = MediaPlayer.create(this, R.raw.sound09);
        mMp10 = MediaPlayer.create(this, R.raw.sound10);
        mMp12 = MediaPlayer.create(this, R.raw.sound12);
        mMp14 = MediaPlayer.create(this, R.raw.sound14);
        mMp15 = MediaPlayer.create(this, R.raw.sound15);
        mMp16 = MediaPlayer.create(this, R.raw.sound16);
        mMp18 = MediaPlayer.create(this, R.raw.sound18);
        mMp20 = MediaPlayer.create(this, R.raw.sound20);
        mMp21 = MediaPlayer.create(this, R.raw.sound21);
        mMp24 = MediaPlayer.create(this, R.raw.sound24);
        mMp25 = MediaPlayer.create(this, R.raw.sound25);
        mMp27 = MediaPlayer.create(this, R.raw.sound27);
        mMp28 = MediaPlayer.create(this, R.raw.sound28);
        mMp30 = MediaPlayer.create(this, R.raw.sound30);
        mMp32 = MediaPlayer.create(this, R.raw.sound32);
        mMp35 = MediaPlayer.create(this, R.raw.sound35);
        mMp36 = MediaPlayer.create(this, R.raw.sound36);
        mMp40 = MediaPlayer.create(this, R.raw.sound40);
        mMp42 = MediaPlayer.create(this, R.raw.sound42);
        mMp45 = MediaPlayer.create(this, R.raw.sound45);
        mMp48 = MediaPlayer.create(this, R.raw.sound48);
        mMp49 = MediaPlayer.create(this, R.raw.sound49);
        mMp54 = MediaPlayer.create(this, R.raw.sound54);
        mMp56 = MediaPlayer.create(this, R.raw.sound56);
        mMp63 = MediaPlayer.create(this, R.raw.sound63);
        mMp64 = MediaPlayer.create(this, R.raw.sound64);
        mMp72 = MediaPlayer.create(this, R.raw.sound72);
        mMp81 = MediaPlayer.create(this, R.raw.sound81);
        
        
        //ボタン
        mButton = new Button[mId.length];
        
        //ボタンの取り込みとイベントの貼付け
        for(int i = 0; i < mId.length; i++) {
        	//ボタンを取り込む
        	mButton[i] = (Button)findViewById(mId[i]);
        	//ボタンのイベント処理
        	mButton[i].setOnClickListener(this);
        }
        
        mView = new MyView(this);
        LinearLayout layout = (LinearLayout)findViewById(R.id.layout01);
        layout.addView(mView);
    }

	public void onClick(View v) {
		//どのボタンが押されたか判定
    	for(int i = 0; i < mId.length; i++) {
    		if(v.equals(mButton[i])) {
    			//RESET
    			if(i == KEY_RESET) {
    				mView.migime = ("");
    				mView.hidarime = ("");
    				total = 0;
    				migimeNum = 0;
    				hidarimeNum = 0;
    				beforeStatus = KEY_RESET;
    				mView.invalidate();
    				mView.changeNormal();
    			}
    			else if (i == KEY_KEISAN) {
   					Log.e("CHECK", "けいさん！="+hidarimeNum);
   					if (hidarimeNum == 1) {
    					total = migimeValue * hidarimeValue;

//   						switch(total){
//   						case 1:
//   					        mMp = MediaPlayer.create(this, R.raw.sound01);
//   							break;
//   						case 2:
//   					        mMp = MediaPlayer.create(this, R.raw.sound02);
//   							break;
//   						case 3:
//   					        mMp = MediaPlayer.create(this, R.raw.sound03);
//   							break;
//   						case 4:
//   					        mMp = MediaPlayer.create(this, R.raw.sound04);
//   							break;
//   						case 5:
//   					        mMp = MediaPlayer.create(this, R.raw.sound05);
//   							break;
//   						case 6:
//   					        mMp = MediaPlayer.create(this, R.raw.sound06);
//   							break;
//   						case 7:
//   					        mMp = MediaPlayer.create(this, R.raw.sound07);
//   							break;
//   						case 8:
//   					        mMp = MediaPlayer.create(this, R.raw.sound08);
//   							break;
//   						case 9:
//   					        mMp = MediaPlayer.create(this, R.raw.sound09);
//   							break;
//   						case 10:
//   					        mMp = MediaPlayer.create(this, R.raw.sound10);
//   							break;
//   						case 12:
//   					        mMp = MediaPlayer.create(this, R.raw.sound12);
//   							break;
//   						case 14:
//   					        mMp = MediaPlayer.create(this, R.raw.sound14);
//   							break;
//   						case 15:
//   					        mMp = MediaPlayer.create(this, R.raw.sound15);
//   							break;
//   						case 16:
//   					        mMp = MediaPlayer.create(this, R.raw.sound16);
//   							break;
//   						case 18:
//   					        mMp = MediaPlayer.create(this, R.raw.sound18);
//   							break;
//   						case 20:
//   					        mMp = MediaPlayer.create(this, R.raw.sound20);
//   							break;
//   						case 21:
//   					        mMp = MediaPlayer.create(this, R.raw.sound21);
//   							break;
//   						case 24:
//   					        mMp = MediaPlayer.create(this, R.raw.sound24);
//   							break;
//   						case 25:
//   					        mMp = MediaPlayer.create(this, R.raw.sound25);
//   							break;
//   						case 27:
//   					        mMp = MediaPlayer.create(this, R.raw.sound27);
//   							break;
//   						case 28:
//   					        mMp = MediaPlayer.create(this, R.raw.sound28);
//   							break;
//   						case 30:
//   					        mMp = MediaPlayer.create(this, R.raw.sound30);
//   							break;
//   						case 32:
//   					        mMp = MediaPlayer.create(this, R.raw.sound32);
//   							break;
//   						case 35:
//   					        mMp = MediaPlayer.create(this, R.raw.sound35);
//   							break;
//   						case 36:
//   					        mMp = MediaPlayer.create(this, R.raw.sound36);
//   							break;
//   						case 40:
//   					        mMp = MediaPlayer.create(this, R.raw.sound40);
//   							break;
//   						case 42:
//   					        mMp = MediaPlayer.create(this, R.raw.sound42);
//   							break;
//   						case 45:
//   					        mMp = MediaPlayer.create(this, R.raw.sound45);
//   							break;
//   						case 48:
//   					        mMp = MediaPlayer.create(this, R.raw.sound48);
//   							break;
//   						case 49:
//   					        mMp = MediaPlayer.create(this, R.raw.sound49);
//   							break;
//   						case 54:
//   					        mMp = MediaPlayer.create(this, R.raw.sound54);
//   							break;
//   						case 56:
//   					        mMp = MediaPlayer.create(this, R.raw.sound56);
//   							break;
//   						case 63:
//   					        mMp = MediaPlayer.create(this, R.raw.sound63);
//   							break;
//   						case 64:
//   					        mMp = MediaPlayer.create(this, R.raw.sound64);
//   							break;
//   						case 72:
//   					        mMp = MediaPlayer.create(this, R.raw.sound72);
//   							break;
//   						case 81:
//   					        mMp = MediaPlayer.create(this, R.raw.sound81);
//   							break;
//   						}
    					mView.migime = ("");
        				mView.hidarime = ("");
        				migimeNum = 0;
        				hidarimeNum = 0;
        				if(total == 1){
        					try{
	        					mMp01.prepare();
	        				}catch(Exception e){
	        					Log.d("CHECK", "Exception");
	        				}
	        				mMp01.seekTo(0);
	        				mMp01.start();
        				}else if(total == 2){
        					try{
	        					mMp02.prepare();
	        				}catch(Exception e){
	        					Log.d("CHECK", "Exception");
	        				}
	        				mMp02.seekTo(0);
	        				mMp02.start();
        				}else if(total == 3){
        					try{
	        					mMp03.prepare();
	        				}catch(Exception e){
	        					Log.d("CHECK", "Exception");
	        				}
	        				mMp03.seekTo(0);
	        				mMp03.start();
        				}else if(total == 4){
        					try{
	        					mMp04.prepare();
	        				}catch(Exception e){
	        					Log.d("CHECK", "Exception");
	        				}
	        				mMp04.seekTo(0);
	        				mMp04.start();
        				}else if(total == 5){
        					try{
	        					mMp05.prepare();
	        				}catch(Exception e){
	        					Log.d("CHECK", "Exception");
	        				}
	        				mMp05.seekTo(0);
	        				mMp05.start();
        				}else if(total == 6){
        					try{
	        					mMp06.prepare();
	        				}catch(Exception e){
	        					Log.d("CHECK", "Exception");
	        				}
	        				mMp06.seekTo(0);
	        				mMp06.start();
        				}else if(total == 7){
        					try{
	        					mMp07.prepare();
	        				}catch(Exception e){
	        					Log.d("CHECK", "Exception");
	        				}
	        				mMp07.seekTo(0);
	        				mMp07.start();
        				}else if(total == 8){
        					try{
	        					mMp08.prepare();
	        				}catch(Exception e){
	        					Log.d("CHECK", "Exception");
	        				}
	        				mMp08.seekTo(0);
	        				mMp08.start();
        				}else if(total == 2){
        					try{
	        					mMp09.prepare();
	        				}catch(Exception e){
	        					Log.d("CHECK", "Exception");
	        				}
	        				mMp09.seekTo(0);
	        				mMp09.start();
        				}else if(total == 10){
        					try{
	        					mMp10.prepare();
	        				}catch(Exception e){
	        					Log.d("CHECK", "Exception");
	        				}
	        				mMp10.seekTo(0);
	        				mMp10.start();
        				}else if(total == 12){
        					try{
	        					mMp12.prepare();
	        				}catch(Exception e){
	        					Log.d("CHECK", "Exception");
	        				}
	        				mMp12.seekTo(0);
	        				mMp12.start();
        				}else if(total == 14){
        					try{
	        					mMp14.prepare();
	        				}catch(Exception e){
	        					Log.d("CHECK", "Exception");
	        				}
	        				mMp14.seekTo(0);
	        				mMp14.start();
        				}else if(total == 15){
        					try{
	        					mMp15.prepare();
	        				}catch(Exception e){
	        					Log.d("CHECK", "Exception");
	        				}
	        				mMp15.seekTo(0);
	        				mMp15.start();
        				}else if(total == 16){
        					try{
	        					mMp16.prepare();
	        				}catch(Exception e){
	        					Log.d("CHECK", "Exception");
	        				}
	        				mMp16.seekTo(0);
	        				mMp16.start();
        				}else if(total == 18){
        					try{
	        					mMp18.prepare();
	        				}catch(Exception e){
	        					Log.d("CHECK", "Exception");
	        				}
	        				mMp18.seekTo(0);
	        				mMp18.start();
        				}else if(total == 20){
        					try{
	        					mMp20.prepare();
	        				}catch(Exception e){
	        					Log.d("CHECK", "Exception");
	        				}
	        				mMp20.seekTo(0);
	        				mMp20.start();
        				}else if(total == 21){
        					try{
	        					mMp21.prepare();
	        				}catch(Exception e){
	        					Log.d("CHECK", "Exception");
	        				}
	        				mMp21.seekTo(0);
	        				mMp21.start();
        				}else if(total == 24){
        					try{
	        					mMp24.prepare();
	        				}catch(Exception e){
	        					Log.d("CHECK", "Exception");
	        				}
	        				mMp24.seekTo(0);
	        				mMp24.start();
        				}else if(total == 25){
        					try{
	        					mMp25.prepare();
	        				}catch(Exception e){
	        					Log.d("CHECK", "Exception");
	        				}
	        				mMp25.seekTo(0);
	        				mMp25.start();
        				}else if(total == 27){
        					try{
	        					mMp27.prepare();
	        				}catch(Exception e){
	        					Log.d("CHECK", "Exception");
	        				}
	        				mMp27.seekTo(0);
	        				mMp27.start();
        				}else if(total == 28){
        					try{
	        					mMp28.prepare();
	        				}catch(Exception e){
	        					Log.d("CHECK", "Exception");
	        				}
	        				mMp28.seekTo(0);
	        				mMp28.start();
        				}else if(total == 30){
        					try{
	        					mMp30.prepare();
	        				}catch(Exception e){
	        					Log.d("CHECK", "Exception");
	        				}
	        				mMp30.seekTo(0);
	        				mMp30.start();
        				}else if(total == 32){
        					try{
	        					mMp32.prepare();
	        				}catch(Exception e){
	        					Log.d("CHECK", "Exception");
	        				}
	        				mMp32.seekTo(0);
	        				mMp32.start();
        				}else if(total == 35){
        					try{
	        					mMp35.prepare();
	        				}catch(Exception e){
	        					Log.d("CHECK", "Exception");
	        				}
	        				mMp35.seekTo(0);
	        				mMp35.start();
        				}else if(total == 36){
        					try{
	        					mMp36.prepare();
	        				}catch(Exception e){
	        					Log.d("CHECK", "Exception");
	        				}
	        				mMp36.seekTo(0);
	        				mMp36.start();
        				}else if(total == 40){
        					try{
	        					mMp40.prepare();
	        				}catch(Exception e){
	        					Log.d("CHECK", "Exception");
	        				}
	        				mMp40.seekTo(0);
	        				mMp40.start();
        				}else if(total == 42){
        					try{
	        					mMp42.prepare();
	        				}catch(Exception e){
	        					Log.d("CHECK", "Exception");
	        				}
	        				mMp42.seekTo(0);
	        				mMp42.start();
        				}else if(total == 45){
        					try{
	        					mMp45.prepare();
	        				}catch(Exception e){
	        					Log.d("CHECK", "Exception");
	        				}
	        				mMp45.seekTo(0);
	        				mMp45.start();
        				}else if(total == 48){
        					try{
	        					mMp48.prepare();
	        				}catch(Exception e){
	        					Log.d("CHECK", "Exception");
	        				}
	        				mMp48.seekTo(0);
	        				mMp48.start();
        				}else if(total == 49){
        					try{
	        					mMp49.prepare();
	        				}catch(Exception e){
	        					Log.d("CHECK", "Exception");
	        				}
	        				mMp49.seekTo(0);
	        				mMp49.start();
        				}else if(total == 54){
        					try{
	        					mMp54.prepare();
	        				}catch(Exception e){
	        					Log.d("CHECK", "Exception");
	        				}
	        				mMp54.seekTo(0);
	        				mMp54.start();
        				}else if(total == 56){
        					try{
	        					mMp56.prepare();
	        				}catch(Exception e){
	        					Log.d("CHECK", "Exception");
	        				}
	        				mMp56.seekTo(0);
	        				mMp56.start();
        				}else if(total == 63){
        					try{
	        					mMp63.prepare();
	        				}catch(Exception e){
	        					Log.d("CHECK", "Exception");
	        				}
	        				mMp63.seekTo(0);
	        				mMp63.start();
        				}else if(total == 64){
        					try{
	        					mMp64.prepare();
	        				}catch(Exception e){
	        					Log.d("CHECK", "Exception");
	        				}
	        				mMp64.seekTo(0);
	        				mMp64.start();
        				}else if(total == 72){
        					try{
	        					mMp72.prepare();
	        				}catch(Exception e){
	        					Log.d("CHECK", "Exception");
	        				}
	        				mMp72.seekTo(0);
	        				mMp72.start();
        				}else if(total == 81){
        					try{
	        					mMp81.prepare();
	        				}catch(Exception e){
	        					Log.d("CHECK", "Exception");
	        				}
	        				mMp81.seekTo(0);
	        				mMp81.start();
        				}
        				//mMp.seekTo(0);
//        				switch (total) {
//						case 1:
//							try{
//	        					mMp01.prepare();
//	        				}catch(Exception e){
//	        					Log.d("CHECK", "Exception");
//	        				}
//	        				mMp01.seekTo(0);
//	        				mMp01.start();
//							break;
//						case 2:
//							try{
//	        					mMp02.prepare();
//	        				}catch(Exception e){
//	        					Log.d("CHECK", "Exception");
//	        				}
//	        				mMp02.seekTo(0);
//	        				mMp02.start();
//							break;
//						case 3:
//							try{
//	        					mMp03.prepare();
//	        				}catch(Exception e){
//	        					Log.d("CHECK", "Exception");
//	        				}
//	        				mMp03.seekTo(0);
//	        				mMp03.start();
//							break;
//						case 4:
//							try{
//	        					mMp04.prepare();
//	        				}catch(Exception e){
//	        					Log.d("CHECK", "Exception");
//	        				}
//	        				mMp04.seekTo(0);
//	        				mMp04.start();
//							break;
//						case 5:
//							try{
//	        					mMp05.prepare();
//	        				}catch(Exception e){
//	        					Log.d("CHECK", "Exception");
//	        				}
//	        				mMp05.seekTo(0);
//	        				mMp05.start();
//							break;
//						case 6:
//							try{
//	        					mMp06.prepare();
//	        				}catch(Exception e){
//	        					Log.d("CHECK", "Exception");
//	        				}
//	        				mMp06.seekTo(0);
//	        				mMp06.start();
//							break;
//						case 7:
//							try{
//	        					mMp07.prepare();
//	        				}catch(Exception e){
//	        					Log.d("CHECK", "Exception");
//	        				}
//	        				mMp07.seekTo(0);
//	        				mMp07.start();
//							break;
//						case 8:
//							try{
//	        					mMp08.prepare();
//	        				}catch(Exception e){
//	        					Log.d("CHECK", "Exception");
//	        				}
//	        				mMp08.seekTo(0);
//	        				mMp08.start();
//							break;
//						case 9:
//							try{
//	        					mMp09.prepare();
//	        				}catch(Exception e){
//	        					Log.d("CHECK", "Exception");
//	        				}
//	        				mMp09.seekTo(0);
//	        				mMp09.start();
//							break;
//						case 10:
//							try{
//	        					mMp10.prepare();
//	        				}catch(Exception e){
//	        					Log.d("CHECK", "Exception");
//	        				}
//	        				mMp10.seekTo(0);
//	        				mMp10.start();
//							break;
//						case 12:
//							try{
//	        					mMp12.prepare();
//	        				}catch(Exception e){
//	        					Log.d("CHECK", "Exception");
//	        				}
//	        				mMp12.seekTo(0);
//	        				mMp12.start();
//							break;
//						case 14:
//							try{
//	        					mMp14.prepare();
//	        				}catch(Exception e){
//	        					Log.d("CHECK", "Exception");
//	        				}
//	        				mMp14.seekTo(0);
//	        				mMp14.start();
//							break;
//						case 15:
//							try{
//	        					mMp15.prepare();
//	        				}catch(Exception e){
//	        					Log.d("CHECK", "Exception");
//	        				}
//	        				mMp15.seekTo(0);
//	        				mMp15.start();
//							break;
//						case 16:
//							try{
//	        					mMp16.prepare();
//	        				}catch(Exception e){
//	        					Log.d("CHECK", "Exception");
//	        				}
//	        				mMp16.seekTo(0);
//	        				mMp16.start();
//							break;
//						case 18:
//							try{
//	        					mMp18.prepare();
//	        				}catch(Exception e){
//	        					Log.d("CHECK", "Exception");
//	        				}
//	        				mMp18.seekTo(0);
//	        				mMp18.start();
//							break;
//						case 20:
//							try{
//	        					mMp20.prepare();
//	        				}catch(Exception e){
//	        					Log.d("CHECK", "Exception");
//	        				}
//	        				mMp20.seekTo(0);
//	        				mMp20.start();
//							break;
//						case 21:
//							try{
//	        					mMp21.prepare();
//	        				}catch(Exception e){
//	        					Log.d("CHECK", "Exception");
//	        				}
//	        				mMp21.seekTo(0);
//	        				mMp21.start();
//							break;
//						case 24:
//							try{
//	        					mMp24.prepare();
//	        				}catch(Exception e){
//	        					Log.d("CHECK", "Exception");
//	        				}
//	        				mMp24.seekTo(0);
//	        				mMp24.start();
//							break;
//						case 25:
//							try{
//	        					mMp25.prepare();
//	        				}catch(Exception e){
//	        					Log.d("CHECK", "Exception");
//	        				}
//	        				mMp25.seekTo(0);
//	        				mMp25.start();
//							break;
//						case 27:
//							try{
//	        					mMp27.prepare();
//	        				}catch(Exception e){
//	        					Log.d("CHECK", "Exception");
//	        				}
//	        				mMp27.seekTo(0);
//	        				mMp27.start();
//							break;
//						case 28:
//							try{
//	        					mMp28.prepare();
//	        				}catch(Exception e){
//	        					Log.d("CHECK", "Exception");
//	        				}
//	        				mMp28.seekTo(0);
//	        				mMp28.start();
//							break;
//						case 30:
//							try{
//	        					mMp30.prepare();
//	        				}catch(Exception e){
//	        					Log.d("CHECK", "Exception");
//	        				}
//	        				mMp30.seekTo(0);
//	        				mMp30.start();
//							break;
//						case 32:
//							try{
//	        					mMp32.prepare();
//	        				}catch(Exception e){
//	        					Log.d("CHECK", "Exception");
//	        				}
//	        				mMp32.seekTo(0);
//	        				mMp32.start();
//							break;
//						case 35:
//							try{
//	        					mMp35.prepare();
//	        				}catch(Exception e){
//	        					Log.d("CHECK", "Exception");
//	        				}
//	        				mMp35.seekTo(0);
//	        				mMp35.start();
//							break;
//						case 36:
//							try{
//	        					mMp36.prepare();
//	        				}catch(Exception e){
//	        					Log.d("CHECK", "Exception");
//	        				}
//	        				mMp36.seekTo(0);
//	        				mMp36.start();
//							break;
//						case 40:
//							try{
//	        					mMp40.prepare();
//	        				}catch(Exception e){
//	        					Log.d("CHECK", "Exception");
//	        				}
//	        				mMp40.seekTo(0);
//	        				mMp40.start();
//							break;
//						case 42:
//							try{
//	        					mMp42.prepare();
//	        				}catch(Exception e){
//	        					Log.d("CHECK", "Exception");
//	        				}
//	        				mMp42.seekTo(0);
//	        				mMp42.start();
//							break;
//						case 45:
//							try{
//	        					mMp45.prepare();
//	        				}catch(Exception e){
//	        					Log.d("CHECK", "Exception");
//	        				}
//	        				mMp45.seekTo(0);
//	        				mMp45.start();
//							break;
//						case 48:
//							try{
//	        					mMp48.prepare();
//	        				}catch(Exception e){
//	        					Log.d("CHECK", "Exception");
//	        				}
//	        				mMp48.seekTo(0);
//	        				mMp48.start();
//							break;
//						case 49:
//							try{
//	        					mMp49.prepare();
//	        				}catch(Exception e){
//	        					Log.d("CHECK", "Exception");
//	        				}
//	        				mMp49.seekTo(0);
//	        				mMp49.start();
//							break;
//						case 54:
//							try{
//	        					mMp54.prepare();
//	        				}catch(Exception e){
//	        					Log.d("CHECK", "Exception");
//	        				}
//	        				mMp54.seekTo(0);
//	        				mMp54.start();
//							break;
//						case 56:
//							try{
//	        					mMp56.prepare();
//	        				}catch(Exception e){
//	        					Log.d("CHECK", "Exception");
//	        				}
//	        				mMp56.seekTo(0);
//	        				mMp56.start();
//							break;
//						case 63:
//							try{
//	        					mMp63.prepare();
//	        				}catch(Exception e){
//	        					Log.d("CHECK", "Exception");
//	        				}
//	        				mMp63.seekTo(0);
//	        				mMp63.start();
//							break;
//						case 64:
//							try{
//	        					mMp64.prepare();
//	        				}catch(Exception e){
//	        					Log.d("CHECK", "Exception");
//	        				}
//	        				mMp64.seekTo(0);
//	        				mMp64.start();
//							break;
//						case 72:
//							try{
//	        					mMp72.prepare();
//	        				}catch(Exception e){
//	        					Log.d("CHECK", "Exception");
//	        				}
//	        				mMp72.seekTo(0);
//	        				mMp72.start();
//							break;
//						case 81:
//							try{
//	        					mMp81.prepare();
//	        				}catch(Exception e){
//	        					Log.d("CHECK", "Exception");
//	        				}
//	        				mMp81.seekTo(0);
//	        				mMp81.start();
//							break;
//						
//						
//						}
//        				try{
//        					mMp.prepare();
//        				}catch(Exception e){
//        					Log.d("CHECK", "Exception");
//        				}
//        				mMp.seekTo(0);
//        				mMp.start();
        				total = 0;
    					mView.invalidate();
    					mView.changeShame();
    					Log.e("CHECK", "けいさん！");
    					Log.d("TOTAL", "total");
    				}
    			}
    			//数字
    			else if (migimeNum == 0) {
	    			if (i < 9) {
	    				mView.changeNormal();
	    				String nowValue = "";
	    				nowValue = nowValue + i;
	    				
	    				//配列が0スタートのため 1 足す
	    				int value = Integer.parseInt(nowValue); //Stringをint型に変換
	    				migimeValue = value + 1;
	    				String plusvalue = "";
	    				plusvalue = String.valueOf(migimeValue);  //intをStringに変換
	    				
	    				migime = plusvalue;
	    				beforeStatus = i;
	    				migimeNum = 1;
	    				Log.e("CHECK", "右目に入力！");
	    				mView.migime = migime;
	    				mView.invalidate();
					}
    			}
    			else if (migimeNum == 1) {
    				if (i < 9) {
    				String nowValue = "";
    				nowValue = nowValue + i;
    				
    				//配列が0スタートのため 1 足す
    				int value = Integer.parseInt(nowValue); //Stringをint型に変換
    				hidarimeValue = value + 1;
    				String plusvalue = "";
    				plusvalue = String.valueOf(hidarimeValue);  //intをStringに変換
    				
    				hidarime = plusvalue;
    				beforeStatus = i;
    				hidarimeNum = 1;
    				migimeNum = 0;
    				Log.e("CHECK", "左目に入力！");
    				mView.hidarime = hidarime;
    				mView.invalidate();
    				
    				}
    			}
    		
    			Log.d("CHECK", "[" + beforeStatus + "]");
    			Log.w("TOTAL", "[" + total + "]");
    			break;
    		}
    	}		
	}
}




