package com.daniel.doktergizi.service;

import java.util.Calendar;

import com.daniel.doktergizi.MainActivity;
import com.daniel.doktergizi.R;
import com.daniel.doktergizi.view.alert.notification.NotificationAlert;

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

public class NotificationService extends IntentService {
	AlarmReceiver alarmReceiver;
	private int a = 0;
	
	public NotificationService() {
		super("SechedulingService");
	}

	public static final int NOTIFICATION_ID = 2;
	private NotificationManager mNotificationManager;
	NotificationCompat.Builder builder;
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		Uri sound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
		
		mNotificationManager = (NotificationManager) this
				.getSystemService(Context.NOTIFICATION_SERVICE);
		
		Intent intent2 = new Intent(this, NotificationAlert.class);
		intent2.putExtra("flag", intent.getIntExtra("flag", 1));
		intent2.putExtra("id", intent.getIntExtra("id", 1));
		
		PendingIntent contentIntent = PendingIntent.getActivity(this, 0,
				intent2, 0);

		NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(
				this)
				.setSmallIcon(R.drawable.ic_launcher)
				.setContentTitle("oaeuaoeu")
				.setStyle(
						new NotificationCompat.BigTextStyle()
								.bigText("aoeuaoeu"))
				.setContentText("aoeuaoeu").setSound(sound);
		
		

		mBuilder.setContentIntent(contentIntent);
		
		//if (){
			mNotificationManager.notify(NOTIFICATION_ID, mBuilder.build());
		//}
			
		System.err.println(Calendar.getInstance().getTimeInMillis() + "aoeuaoeu");
		System.out.println(intent.getIntExtra("month", 0) + " tanggal");
			
		//cancelalarm(0, 0);
	}
	
	private void cancelalarm(int id, int flags) {
		// TODO Auto-generated method stub
		AlarmManager alarmManager = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
		Intent intent1 = new Intent(NotificationService.this, AlarmReceiver.class);
		PendingIntent pendingIntent = PendingIntent.getBroadcast(NotificationService.this, id, intent1, flags);
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());
		calendar.set(Calendar.SECOND, calendar.getTime().getSeconds() + 20);

		alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
				calendar.getTimeInMillis(), 20 * 1000, pendingIntent);
		
		alarmManager.cancel(pendingIntent);
		
		ComponentName componentName = new ComponentName(NotificationService.this,
				BootReceiver.class);
		PackageManager pmManager = NotificationService.this.getPackageManager();

		pmManager.setComponentEnabledSetting(componentName,
				PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
				PackageManager.DONT_KILL_APP);
	}
	
	
}
 