package com.example.emotions;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	// declare alarm class variables
	private AlarmManager alarmMgr;
	private PendingIntent alarmIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //call to alarm set method
       setAlarmInterval(120);
    }
    public void setAlarmInterval(int i)
    {
    	//create alarm Manager for pushing notifications on schedule
    	 alarmMgr = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
    	 //specific target class for alarm
 		Intent intent = new Intent(this, notification.class);
 		alarmIntent = PendingIntent.getBroadcast(this, 0, intent, 0);
 		//set alarm start time
 		Calendar calendar = Calendar.getInstance();
 		calendar.setTimeInMillis(System.currentTimeMillis());
 		calendar.set(Calendar.HOUR_OF_DAY, 9);
 		calendar.set(Calendar.MINUTE, 0);
 		calendar.set(Calendar.SECOND, 0);
 		// create alarm
 		long temp = 1000 * 60 * i;
 		alarmMgr.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),temp,alarmIntent);
 		//Log.d("ALC","main start");
    }
    public void temp(View v)
    {
    	//used for testing purposes only to be removed in final product
    	startActivity(new Intent(v.getContext(), StartScreen.class));
    }
    public void comingSoon(View v)
    {
    	//features to be added
    	Toast.makeText(getBaseContext(),"This Feature coming soon" , Toast.LENGTH_LONG).show();
    }
    public void interval(View v)
    {
    	//create input box for interval change
    	final EditText input = new EditText(this);
    	input.setInputType(InputType.TYPE_CLASS_NUMBER);
    	//create alert dialog for interval input
    	AlertDialog builder2 = new AlertDialog.Builder(MainActivity.this).create();
        builder2.setView(input);
    	builder2.setTitle("Set Interval in minutes");
    	//onclick for interval input
    	builder2.setButton(AlertDialog.BUTTON_POSITIVE, "Ok", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				//intake interval input, parse to int and set new alarm.
				String inputs = input.getText().toString();
				setAlarmInterval(Integer.parseInt(inputs));
			}
		});
    	builder2.show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
