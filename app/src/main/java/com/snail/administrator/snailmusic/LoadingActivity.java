package com.snail.administrator.snailmusic;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * 闪屏页
 */
public class LoadingActivity extends Activity {
	
	private ImageView mImageView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN
				,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.show_loading);

		mImageView = (ImageView) findViewById(R.id.loading_anim);
		((AnimationDrawable)mImageView.getBackground()).start();
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						Thread.sleep(5000);
						Intent intent = new Intent(LoadingActivity.this, MainActivity.class);
						startActivity(intent);
						finish();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}).start();

	}
}
