package com.example.test;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.view.MotionEvent;

public class MainActivity extends Activity {
	
private FrameLayout parent_frame;
private FrameLayout child_frame;
private ImageView image;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		parent_frame = (FrameLayout) findViewById(R.id.parent_frame);
		child_frame = (FrameLayout) findViewById(R.id.child_frame);
		image = (ImageView) findViewById(R.id.image)
		
		child_frame.setOnTouchListener(new OnTouchListener() {
			float x;
			float y;
			float last_x;
			float last_y;
			float dx;
			float dy;
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				switch(event.getAction()){
				case MotionEvent.ACTION_DOWN:
					x = event.getX();
					y = event.getY();
					last_x = x;
					last_y = y;;
					break;
					
				case MotionEvent.ACTION_MOVE:
					x = event.getX();
					y = event.getY();
					dx = x - last_x;
					dy = y - last_y;
					//child_frame.setX(event.getX()-dx);
					//child_frame.setY(event.getY()-dy);
					child_frame.setX(child_frame.getX() + dx);
					child_frame.setY(child_frame.getY() + dy);
					//child_frame.setTranslationX(child_frame.getTranslationX() + dx);
					//child_frame.setTranslationY(child_frame.getTranslationY() + dy);
					last_x = x;
					last_y = y;
					Log.d("myApp", Float.toString(child_frame.getX()-dx));
					//Log.d("myApp", Float.toString(event.getY()-dy));
					break;
				}
				

				return true;
			}
		});
		
	}
	
	
}
