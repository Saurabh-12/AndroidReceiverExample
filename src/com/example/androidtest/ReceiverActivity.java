package com.example.androidtest;

import android.os.Bundle;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.Menu;
import android.widget.Toast;

public class ReceiverActivity extends Activity {

	protected static final String TAG = "ReceiverActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_receiver);
		
		
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		  // Register to receive messages.
		  // We are registering an observer (mMessageReceiver) to receive Intents
		  // with actions named "custom-event-name".
		  LocalBroadcastManager.getInstance(this).registerReceiver(mMessageReceiver,new IntentFilter("custom-event-name"));
		
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		 // Unregister since the activity is about to be closed.
		  LocalBroadcastManager.getInstance(this).unregisterReceiver(mMessageReceiver);
		  super.onDestroy();
		
	}
	
	@Override
	protected void onStop() {
		super.onStop();
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.receiver, menu);
		return true;
	}
	
	// Our handler for received Intents. This will be called whenever an Intent
	// with an action named "custom-event-name" is broadcasted.
	private BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
	  @Override
	  public void onReceive(Context context, Intent intent) {
	    // Get extra data included in the Intent
	    String message = intent.getStringExtra("message");
	    Log.d(TAG, "Got message: " + message);
	    Toast.makeText(ReceiverActivity.this, message, Toast.LENGTH_SHORT).show();
	  }
	};
	
	

}
