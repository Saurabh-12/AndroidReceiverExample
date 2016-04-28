package com.example.androidtest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class OrderedReceiverTwo extends BroadcastReceiver{

	private static final String TAG = "OrderedReceiverTwo";

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
	    // Get extra data included in the Intent
	    String message = intent.getStringExtra("message");
	    Log.d(TAG, "Got message: " + message);
	    Toast.makeText(context, message+" 2nd Receiver", Toast.LENGTH_SHORT).show();
		
	}
	
	/*	You can always abort the broadcast by calling abortBroadcast() in any receiver’s onReceive() 
	 * preventing further receivers from receiving the event.
	 *  Although the final receiver’s onReceive(), set in the sendOrderedBroadcast() will still be called.*/
}
