package com.example.androidtest;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class PendingIntentExampleActivity extends Activity {

	private static final String TAG = "PendingIntentExampleActivity";




	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pending_intent_example);

		findViewById(R.id.start_pending_intent_btn).setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startAlert(v);
			}
		});



	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pending_intent_example, menu);
		return true;
	}




	public void startAlert(View view) {
		EditText text = (EditText) findViewById(R.id.put_delay_etv);
		int time = 0;
		try {
			time = Integer.parseInt(text.getText().toString());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Toast.makeText(this, "Put Integer value only!!!", Toast.LENGTH_LONG).show();
			time = 1;
		}
		Log.d(TAG, " Time Entered "+time);
		Intent intent = new Intent(this, MyPIReceiver.class);
		intent.putExtra("time", time);
		PendingIntent pend_intent = PendingIntent.getBroadcast(this.getApplicationContext(), 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
		//calls the alarm
		AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
		alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+ (time * 1000), pend_intent);
	}



}
