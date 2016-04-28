package com.example.androidtest;

import android.os.Bundle;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import android.view.Menu;
import android.widget.Toast;

public class SendOrderedBroadcastActivity extends Activity {

	private static String TAG = "SendOrderedBroadcastActivity";
	private static String Action = "com.example.androidtest.OrderedBroadcast";



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_send_ordered_broadcast);


		IntentFilter filter = new IntentFilter(Action);
		// filter.setPriority(10); // could do this if you want to
		registerReceiver(orderedReceiver, filter);
		
		
		
		//Broadcasting Ordered Receiver
		Intent intent = new Intent(Action);
		// You can also include some extra data.
		intent.putExtra("message", "This is my message!");
		sendOrderedBroadcast(intent, null, new BroadcastReceiver() {
			@Override
			public void onReceive(Context context, Intent intent) {
				// TODO Auto-generated method stub
			    String message = intent.getStringExtra("message");
			    Log.d(TAG, "Got message: " + message);
			    Toast.makeText(SendOrderedBroadcastActivity.this," final result after all the BroadcastReceivers ", Toast.LENGTH_SHORT).show();
			    
			    /*	You can always abort the broadcast by calling abortBroadcast() in any receiver’s onReceive() 
			     * preventing further receivers from receiving the event.
			     *  Although the final receiver’s onReceive(), set in the sendOrderedBroadcast() will still be called.*/
				
			}
		}, null,Activity.RESULT_OK, null, null);


	}







	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.send_ordered_broadcast, menu);
		return true;
	}
	
	
	private BroadcastReceiver orderedReceiver = new BroadcastReceiver() {
		  @Override
		  public void onReceive(Context context, Intent intent) {
		    // Get extra data included in the Intent
		    String message = intent.getStringExtra("message");
		    Log.d(TAG, "Got message: " + message);
		    Toast.makeText(SendOrderedBroadcastActivity.this, message+" 3rd", Toast.LENGTH_SHORT).show();
		  }
		};

}
