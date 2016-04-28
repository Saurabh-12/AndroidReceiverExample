package com.example.androidtest;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

public class MessageService extends Service{

	private static final String TAG = "MessageService";

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		sendMessage();
		return super.onStartCommand(intent, flags, startId);
	}
	
	// Send an Intent with an action named "custom-event-name". The Intent
	// sent should
	// be received by the ReceiverActivity.
	private void sendMessage() {
		Log.d(TAG, "Broadcasting message");
		Intent intent = new Intent("custom-event-name");
		// You can also include some extra data.
		intent.putExtra("message", "This is my message!");
		LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
	}
	
	

}
