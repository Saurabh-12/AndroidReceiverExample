package com.example.androidtest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyPIReceiver extends BroadcastReceiver{
	

	private static final String TAG = "MyPIReceiver";

	@Override
	public void onReceive(Context context, Intent arg1) {
		// TODO Auto-generated method stub
		int time = arg1.getIntExtra("time", 0);
		Log.d(TAG, "Received Time "+time);
		Toast.makeText(context, "Times Up!!!! ( "+time+" seconds)", Toast.LENGTH_LONG).show();
		
	}
	
	
	
	

}
