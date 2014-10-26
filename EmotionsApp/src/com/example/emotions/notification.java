package com.example.emotions;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.text.format.Time;
import android.util.Log;

public class notification extends BroadcastReceiver {
	Time now = new Time();
		
	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
	if(now.hour < 17)
	{
		Log.d("ALC","Notif");
		NotificationCompat.Builder mBuilder =
	        new NotificationCompat.Builder(context)
	        .setSmallIcon(R.drawable.ic_launcher)
	        .setContentTitle("Time for Emotions")
	        .setContentText("Don't Worry, be Happy");
	
	
	// Creates an explicit intent for an Activity in your app
	Intent resultIntent = new Intent(context, StartScreen.class);
	
	PendingIntent resultPendingIntent =
	        PendingIntent.getActivity(context,0,resultIntent,
	            PendingIntent.FLAG_UPDATE_CURRENT);
	mBuilder.setContentIntent(resultPendingIntent);
	NotificationManager mNotificationManager =
	    (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
	// mId allows you to update the notification later on.
	
	int mId = now.hour;
	mNotificationManager.notify(mId, mBuilder.build());
	}
	else
	{
		//do nothing
	}
		
	}
}
	
