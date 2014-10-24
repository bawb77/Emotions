package com.example.emotions;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class StartScreen extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start_screen);
	}
	//Toast.makeText(getBaseContext(),"" , Toast.LENGTH_LONG).show();
	public void start(View v)
	{
		AlertDialog.Builder builder = new AlertDialog.Builder(StartScreen.this);

    	builder.setTitle(R.string.since);
    	builder.setItems(R.array.choices , new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int choice) {
            	
            }
        });
    	
    	builder.create();
		builder.show();
		
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
