package com.daniel.doktergizi.service;

import java.util.Calendar;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

public class AlarmTask implements Runnable{

	private final Calendar date;
	private final AlarmManager am;
	private final Context context;
	
	public AlarmTask(Context context, Calendar calendar){
		this.date = calendar;
		this.am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
		this.context = context;
		System.out.println("AlarmTask.AlarmTask()" + " kesalahan");
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Intent intent = new Intent(context, NotifyService.class);
		intent.putExtra(NotifyService.INTENT_NOTIFY, true);
		PendingIntent pendingIntent = PendingIntent.getService(context, 0, intent, 0);
		
		am.set(AlarmManager.RTC, date.getTimeInMillis(), pendingIntent);
	}
}
