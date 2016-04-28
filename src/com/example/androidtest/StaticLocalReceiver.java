package com.example.androidtest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class StaticLocalReceiver extends BroadcastReceiver{

	private static final String TAG = "StaticLocalReceiver";

	@Override
	public void onReceive(Context arg0, Intent intent) {
		// TODO Auto-generated method stub
	    // Get extra data included in the Intent
	    String message = intent.getStringExtra("message");
	    Log.d(TAG, "Got message: " + message);
	    Toast.makeText(arg0, message, Toast.LENGTH_SHORT).show();
	}
	
	

}
