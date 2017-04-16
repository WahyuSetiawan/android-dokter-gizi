package com.daniel.doktergizi.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BootReceiver extends BroadcastReceiver {
	AlarmReceiver alarm  = new AlarmReceiver();
	
	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED")){
			alarm.setAlarm(context);
		}
	}

}
