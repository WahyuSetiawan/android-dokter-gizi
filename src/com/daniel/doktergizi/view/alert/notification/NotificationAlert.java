package com.daniel.doktergizi.view.alert.notification;

import java.util.Calendar;

import com.daniel.doktergizi.MainActivity;
import com.daniel.doktergizi.service.AlarmReceiver;
import com.daniel.doktergizi.service.BootReceiver;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.AlertDialog.Builder;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.inputmethodservice.ExtractEditText;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;

public class NotificationAlert extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		removeDialog(0);
		this.showDialog(0);
	}
	
	@Override
	protected Dialog onCreateDialog(int id) {
		// TODO Auto-generated method stub
		super.onCreateDialog(id);
		
		AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
		
		alertBuilder.setTitle("Alarm Reminder");
		alertBuilder.setMessage("Its time for the alarm");
		alertBuilder.setCancelable(false);
		
		System.out.println("extraextra " +this.getIntent().getIntExtra("flag", 7070));
		System.out.println("extraextra " +this.getIntent().getIntExtra("id", 7070));
		
		Bundle extras = getIntent().getExtras();
		
		if(extras != null){
			String data1 = extras.getString("flag");
			String data2 = extras.getString("id");
			System.out.println("extraextra Ddata1 : " + data1);
		}
		
		alertBuilder.setPositiveButton("Masuk Aplikasi", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
            	startActivity(new Intent(NotificationAlert.this, MainActivity.class));
                NotificationAlert.this.finish();
            }
        });
		
		alertBuilder.setNegativeButton("Batalkan", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				AlarmManager alarmManager = (AlarmManager) NotificationAlert.this
						.getSystemService(Context.ALARM_SERVICE);
				Intent intent = new Intent(NotificationAlert.this, AlarmReceiver.class);
				PendingIntent pendingIntent = PendingIntent.getBroadcast(NotificationAlert.this, NotificationAlert.this.getIntent().getIntExtra("id", 1), intent, NotificationAlert.this.getIntent().getIntExtra("flag", 1));
				
				Calendar calendar = Calendar.getInstance();
				calendar.setTimeInMillis(System.currentTimeMillis());
				calendar.set(Calendar.SECOND, calendar.getTime().getSeconds() + 20);

				alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
						calendar.getTimeInMillis(), 20 * 1000, pendingIntent);
				
				alarmManager.cancel(pendingIntent);
				
				ComponentName componentName = new ComponentName(NotificationAlert.this,
						BootReceiver.class);
				PackageManager pmManager = NotificationAlert.this.getPackageManager();

				pmManager.setComponentEnabledSetting(componentName,
						PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
						PackageManager.DONT_KILL_APP);
				NotificationAlert.this.finish();
			}
		});

		AlertDialog dlg = alertBuilder.create();
		return dlg;
	}

}
