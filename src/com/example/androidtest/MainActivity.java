package com.example.androidtest;

import java.util.Timer;
import java.util.TimerTask;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //Setting Example 
        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "Setting Clicked", Toast.LENGTH_SHORT).show();
				Intent i = new Intent(MainActivity.this, MyPreferencesActivity.class);
				startActivity(i);
				
			}
		});
        
        //Local Broadcast Example
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(MainActivity.this, ReceiverActivity.class);
				startActivity(i);
				Timer t = new Timer();
				t.schedule(new TimerTask() {
					@Override
					public void run() {
						//broadcast local Receiver msg
						sendMessage();
						/***
						 * Broadcast using service example **/
						//startService(new Intent(MainActivity.this, MessageService.class));
					}
				}, 3000);
			}
		});
        
        //Normal Broadcast Example
        findViewById(R.id.button5).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				
				/**
				 *  Normal static Broadcast example
				 *  For Static B.R. Example, Please comment below Dynamic B.R. Example
				 */
/*				Intent intent = new Intent();
				intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
				intent.setAction("com.example.androidtest.StaticBroadcastReceiver");
				intent.putExtra("NormalBR", "Received Normal B. R.");
				sendBroadcast(intent);*/
				
				/**
				 *Dynamically registered Broadcast Example
				 *In NormalReceiverActivity Receiver get registered Dynamically inside onResume() method
				 *After 3 sec. Broadcast will happen..so that Dynamic Ragister catch it.
				 */
				Intent i = new Intent(MainActivity.this, NormalReceiverActivity.class);
				startActivity(i);
				Timer t = new Timer();
				t.schedule(new TimerTask() {
					@Override
					public void run() {
						//Dynamic Broadcast Example
						Intent intent1 = new Intent();
						intent1.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
						intent1.setAction("com.example.androidtest.DynamicBroadcastReceiver");
						intent1.putExtra("NormalBR", "Received Normal B. R.");
						sendBroadcast(intent1);
					}
				}, 3000);

			}
		});
        
        // Ordered Broadcast Example
        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(MainActivity.this, SendOrderedBroadcastActivity.class);
				startActivity(i);
			}
		});
        
        //Pending Intent Example
        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(MainActivity.this, PendingIntentExampleActivity.class);
				startActivity(i);
			}
		});
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
 // Send an Intent with an action named "custom-event-name". The Intent sent should 
 // be received by the ReceiverActivity.
 private void sendMessage() {
   Log.d(TAG, "CodeFlow Broadcasting message");
   Intent intent = new Intent("custom-event-name");
   // You can also include some extra data.
   intent.putExtra("message", "This is my message!");
   LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
 }
    
}
