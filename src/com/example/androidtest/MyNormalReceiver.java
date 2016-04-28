package com.example.androidtest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyNormalReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		String extraTxt = intent.getStringExtra("NormalBR");
		 // This method is called when this BroadcastReceiver receives an Intent broadcast.
        Toast.makeText(context, "Action: " + intent.getAction()+"\n"+extraTxt, Toast.LENGTH_SHORT).show();
		
	}
	
	
	

}
