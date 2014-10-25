package com.example.emotions;

import java.util.ArrayList;
import java.util.Calendar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class StartScreen extends Activity {
	ArrayList<EmoLog> currentLog = new ArrayList<EmoLog>();
	EmoLog EL;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start_screen);
	};
	public void start(View v)
	{
		Calendar calendar = Calendar.getInstance();
	    int day = calendar.get(Calendar.DAY_OF_MONTH);
		int aInterval = 0;
		EL = new EmoLog(day, aInterval);
		moments(v);
		sinceFive(v);
		sinceTen(v);
		SqlLiteYouMeanIt db = new SqlLiteYouMeanIt(this);
		db.addResult(EL);
    }
	public void moments(View v)
	{
		String momStr[] = {getResources().getString(R.string.happy)
		, getResources().getString(R.string.relaxed)
	    , getResources().getString(R.string.angry)
	    , getResources().getString(R.string.stressed)
	    , getResources().getString(R.string.anxious)
	    , getResources().getString(R.string.depressed)};
		int tmp[] = new int[6];
		for(int i=0; i != 6; i++)
		{
			TextView TV = new TextView(StartScreen.this);
			TV.setText(momStr[i]);
			AlertDialog.Builder builder = new AlertDialog.Builder(StartScreen.this);
			builder.setTitle(R.string.moment);
			builder.setView(TV);
			builder.setItems(R.array.choices , new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int choice) {
					Toast.makeText(getBaseContext(),"" +  choice , Toast.LENGTH_LONG).show();
					tmp[i] = choice;
            	}
				
			});
    	
    	builder.create();
		builder.show();
		}
		EL.mom = tmp;
		
	}
	public void sinceFive(View v)
	{
		
	}
	public void sinceTen(View v)
	{
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.start_screen, menu);
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
