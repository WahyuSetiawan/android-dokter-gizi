package com.daniel.doktergizi.service;

import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import com.daniel.doktergizi.MainActivity;
import com.daniel.doktergizi.R;
import com.daniel.doktergizi.ReminderList;
import com.daniel.doktergizi.database.DBProfileAnak;
import com.daniel.doktergizi.model.entitas.Jadwal;
import com.daniel.doktergizi.view.alert.notification.NotificationAlert;
import com.daniel.doktergizi.view.reminder.CalenderAdapter;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.provider.CalendarContract.Reminders;
import android.provider.ContactsContract.CommonDataKinds.Event;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.widget.Toast;

public class AlarmReceiver extends WakefulBroadcastReceiver implements
		Serializable {

	private static final long serialVersionUID = 1L;
	private AlarmManager alarmManager;
	private PendingIntent pendingIntent;
	private SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	public class InstanceAlarm {
		AlarmReceiver instanAlarmReceiver() {
			return AlarmReceiver.this;
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		DBProfileAnak database = new DBProfileAnak(context);

		ArrayList<Jadwal> jadwals = database.selectAllJadwal();

		System.err.println("ketasothuso" + new java.util.Date().toString());
		
		boolean a = true;

		if (jadwals != null) {
			String message = "";

			for (Jadwal jadwal : jadwals) {
				if (new java.util.Date().after(jadwal.getTanggalMulai())
						&& new java.util.Date().before(jadwal
								.getTanggalBerakhir())
						&& jadwal.getStatus() != 1) {
					if (a) {
						message =  jadwal.getVaksin().getVaksin();
						a = !a;
					}else{
						message = message + ", " + jadwal.getVaksin().getVaksin();
					}
				}
			}

			if (!message.equals("")) {
				generateNotification(context, "Jadwal vaksin " + message);
			}
		}

		/*
		 * NotificationService notificationService = new NotificationService();
		 * Intent serviceIntent = new Intent(context,
		 * notificationService.getClass());
		 * 
		 * serviceIntent.putExtra("flag", intent.getIntExtra("flag", 1));
		 * serviceIntent.putExtra("id", intent.getIntExtra("id", 1));
		 * 
		 * startWakefulService(context, serviceIntent);
		 */

	}

	public void setAlarm(Context context) {
		int index_flag = 0;

		alarmManager = (AlarmManager) context
				.getSystemService(Context.ALARM_SERVICE);
		Intent intent = new Intent(context, AlarmReceiver.class);

		pendingIntent = PendingIntent.getBroadcast(context, 0, intent,
				PendingIntent.FLAG_UPDATE_CURRENT);

		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());
		calendar.set(Calendar.SECOND, calendar.getTime().getSeconds() + 4);

		alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
				calendar.getTimeInMillis(), 3 * 1000, pendingIntent);

		// alarmManager.set(0, calendar.getTimeInMillis(),
		// pendingIntent);

		ComponentName componentName = new ComponentName(context,
				BootReceiver.class);
		PackageManager pmManager = context.getPackageManager();

		pmManager.setComponentEnabledSetting(componentName,
				PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
				PackageManager.DONT_KILL_APP);
	}

	public boolean cancelAlarm(Context context) {
		if (alarmManager != null) {
			Toast.makeText(context, "sudah cancel alarm", Toast.LENGTH_LONG)
					.show();
			alarmManager.cancel(pendingIntent);
		}

		ComponentName componentName = new ComponentName(context,
				BootReceiver.class);
		PackageManager pmManager = context.getPackageManager();

		pmManager.setComponentEnabledSetting(componentName,
				PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
				PackageManager.DONT_KILL_APP);

		return false;
	}

	@SuppressWarnings("deprecation")
	private void generateNotification(Context context, String message) {
		System.out.println(message + "++++++++++2");
		int icon = R.drawable.ic_launcher;
		long when = System.currentTimeMillis();
		NotificationManager notificationManager = (NotificationManager) context
				.getSystemService(Context.NOTIFICATION_SERVICE);
		Notification notification = new Notification(icon, message, when);
		String title = context.getString(R.string.app_name);
		String subTitle = context.getString(R.string.app_name);
		/*
		 * Intent notificationIntent = new Intent(context, MainActivity.class);
		 * notificationIntent.putExtra("content", message);
		 */

		Intent notificationIntent = new Intent(context, ReminderList.class);

		PendingIntent intent = PendingIntent.getActivity(context, 0,
				notificationIntent, 0);

		notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
				| Intent.FLAG_ACTIVITY_SINGLE_TOP);

		notification.setLatestEventInfo(context, title, message, intent);
		// To play the default sound with your notification:
		notification.defaults |= Notification.DEFAULT_SOUND;
		notification.flags |= Notification.FLAG_AUTO_CANCEL;
		notification.defaults |= Notification.DEFAULT_VIBRATE;
		notificationManager.notify(0, notification);
	}
}
