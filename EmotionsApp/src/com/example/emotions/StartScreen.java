package com.example.emotions;

import java.util.ArrayList;
import java.util.Calendar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class StartScreen extends Activity {
	ArrayList<EmoLog> currentLog = new ArrayList<EmoLog>();
	EmoLog EL;
	int forMomCount;
	int forFiveCount;
	int forTenCount;
	boolean a;
	boolean b;
	boolean c;
	boolean d;
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
		forMomCount = 0;
		forFiveCount = 0;
		forTenCount = 0;
		moments(-1,v);
		
    }
	public void saveIt(View v)
	{
		SqlLiteYouMeanIt db = new SqlLiteYouMeanIt(this);
		db.addResult(EL);
		Toast.makeText(getBaseContext(),"Thanks for Completing your Quiz!" , Toast.LENGTH_LONG).show();
	}
	public void moments(int i, final View v)
	{
		String momStr[] = {getResources().getString(R.string.happy)
		, getResources().getString(R.string.relaxed)
	    , getResources().getString(R.string.angry)
	    , getResources().getString(R.string.stressed)
	    , getResources().getString(R.string.anxious)
	    , getResources().getString(R.string.depressed)};
		if (i != -1)
		{
			EL.mom[(forMomCount-1)] = i;
		}
		
			if((forMomCount-1) == 5)
			{
				sinceFive(-1,v);
			}
			else
			{
				String tempstr = getResources().getString(R.string.moment) + " " + momStr[forMomCount];
				AlertDialog.Builder builder = new AlertDialog.Builder(StartScreen.this);
				builder.setTitle(tempstr);
				builder.setItems(R.array.choices , new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int choice) {
						//Toast.makeText(getBaseContext(),"" +  choice , Toast.LENGTH_LONG).show();
						forMomCount++;
						moments(choice, v);
	            	}
				}); 
				builder.create();
				builder.show();
			}
			 
	}
	public void sinceFive(int i, final View v)
	{
		String FiveStr[] = {getResources().getString(R.string.accept)
		, getResources().getString(R.string.reprise)
	    , getResources().getString(R.string.critisim)
	    , getResources().getString(R.string.rumination)
	    , getResources().getString(R.string.sharing)
	    , getResources().getString(R.string.expsup)
	    , getResources().getString(R.string.distraction)
	    , getResources().getString(R.string.problem)
	    , getResources().getString(R.string.felsup)};
		if (i != -1)
		{
			EL.sf[(forFiveCount-1)] = i;
		}
		
			if((forFiveCount-1) == 8)
			{
				sinceTen(-1,v);
			}
			else
			{
			 
			AlertDialog.Builder builder = new AlertDialog.Builder(StartScreen.this);
			String tempstr = getResources().getString(R.string.since) + " " + FiveStr[forFiveCount];
			builder.setTitle(tempstr);
			builder.setItems(R.array.choices , new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int choice) {
					//Toast.makeText(getBaseContext(),"" +  choice , Toast.LENGTH_LONG).show();
					forFiveCount++;
					sinceFive(choice, v);
            	}
			});
				builder.create();
				builder.show();
			}
	}
	public void sinceTen(int i, final View v)
	{
		String TenStr[] = {getResources().getString(R.string.wantu)
	    , getResources().getString(R.string.wantc)
	    , getResources().getString(R.string.wantp)};
		if (i != -1)
		{
			EL.st[(forTenCount-1)] = i;
		}
		
			if((forTenCount-1) == 2)
			{
				saveIt(v);
			}
			else
			{
			AlertDialog.Builder builder = new AlertDialog.Builder(StartScreen.this);
			String tempstr = getResources().getString(R.string.since) + " " + TenStr[forTenCount];
			builder.setTitle(tempstr);
			builder.setItems(R.array.choicesTen , new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int choice) {
					//Toast.makeText(getBaseContext(),"" +  choice , Toast.LENGTH_LONG).show();
					forTenCount++;
					sinceTen(choice, v);
            	}
			});
				builder.create();
				builder.show();
			}
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
