package com.example.androidtest;

import android.os.Bundle;
import android.app.Activity;
import android.content.IntentFilter;
import android.view.Menu;

public class NormalReceiverActivity extends Activity {
	MyNormalReceiver myReceiver;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_normal_receiver);
		
		
		
		
	}

	@Override
	protected void onResume() {
		super.onResume();
		
		IntentFilter filter = new IntentFilter("com.example.androidtest.DynamicBroadcastReceiver");
		myReceiver = new MyNormalReceiver();
		registerReceiver(myReceiver, filter);
		
	}
	
	
	@Override
	protected void onPause() {
		super.onPause();
		
		unregisterReceiver(myReceiver);
	}
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.normal_receiver, menu);
		return true;
	}
	
	
	

}
