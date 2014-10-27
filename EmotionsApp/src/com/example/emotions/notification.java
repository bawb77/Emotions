package com.example.emotions;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.text.format.Time;
import android.util.Log;

public class notification extends BroadcastReceiver {
	Time now = new Time();
		
	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
	//If statement to exclude 9pm to 9am from notification
		int temp = now.hour;
		
		Log.d("ALC",temp + "");
	if(temp < 17)
	{
		//constructor
		//Log.d("ALC","Notif");
		NotificationCompat.Builder mBuilder =
	        new NotificationCompat.Builder(context)
	        .setSmallIcon(R.drawable.ic_launcher)
	        .setContentTitle("Time for Emotions")
	        .setContentText("Don't Worry, Be Happy");
	
	mBuilder.setAutoCancel(true);
	Uri as = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
	mBuilder.setSound(as);
	// Creates an explicit intent for StartScreen
	Intent resultIntent = new Intent(context, StartScreen.class);
	//build intent pending actions
	PendingIntent resultPendingIntent =
	        PendingIntent.getActivity(context,0,resultIntent,
	            PendingIntent.FLAG_UPDATE_CURRENT);
	//assign PendingIntents to the builder
	mBuilder.setContentIntent(resultPendingIntent);
	//Create notifications manager
	NotificationManager mNotificationManager =
	    (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
	int day = now.monthDay;
	int hour = now.hour;
	int mId = day + hour;
	mNotificationManager.notify(mId, mBuilder.build());
	}
	else
	{
		//do nothing
	}
		
	}
}
	
