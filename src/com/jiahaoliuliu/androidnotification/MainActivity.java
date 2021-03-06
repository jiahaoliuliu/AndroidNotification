package com.jiahaoliuliu.androidnotification;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		PackageManager packageManager = getPackageManager();
		Intent intent = packageManager.getLaunchIntentForPackage("com.jiahaoliuliu.guesssongs");
		if (intent != null) {
			// Set it to launch app
			intent.addCategory(Intent.CATEGORY_LAUNCHER);
		} else {
			// If the app has not be found, do nothing
			intent = new Intent();
		}
		PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

		// build notification
		// the addAction re-use the same intent to keep the example short
		Notification n  = new NotificationCompat.Builder(this)
		        .setContentTitle("New mail from " + "test@gmail.com")
		        .setContentText("Subject")
		        .setSmallIcon(R.drawable.ic_launcher)
		        .setContentIntent(pIntent)
		        .setAutoCancel(true).build();

		NotificationManager notificationManager = 
		  (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

		notificationManager.notify(0, n); 
	}
}