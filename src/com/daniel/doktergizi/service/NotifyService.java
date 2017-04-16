package com.daniel.doktergizi.service;

import com.daniel.doktergizi.MainActivity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class NotifyService extends Service {

	public class ServiceBinder extends Binder{
		NotifyService getService(){
			return NotifyService.this;
		}
	}
	
	private static final int NOTIFICATION = 123;
	public static final String INTENT_NOTIFY = "dalammasajaya";
	private NotificationManager mNM;
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		Log.i("NotifyService", "onCreate()");
		mNM = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		Log.i("LocalService", "Received start id " + startId + ": "+ intent);
		
		if (intent.getBooleanExtra(INTENT_NOTIFY, false)) {
			showNotification();
		}
		
		return START_NOT_STICKY;
	}
	

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return mBinder;
	}
	
	private final IBinder mBinder = new ServiceBinder();

	private void showNotification() {
		// TODO Auto-generated method stub
		CharSequence titleCharSequence = "Alarm!!";
		int icon = android.R.drawable.ic_dialog_alert;
		CharSequence text = "Your Notification not to much";
		long time = System.currentTimeMillis();
		
		Notification notification = new Notification(icon, text, time);
		
		PendingIntent contentIntent = PendingIntent.getActivity(this, 0, new Intent(this, MainActivity.class ), 0);
		notification.setLatestEventInfo(this, titleCharSequence, text, contentIntent);
		
		notification.flags  |= Notification.FLAG_AUTO_CANCEL;
		
		mNM.notify(NOTIFICATION, notification);
		stopSelf();
	}


}
