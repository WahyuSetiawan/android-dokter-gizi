package com.daniel.doktergizi;

import java.util.Calendar;

import com.daniel.doktergizi.R;
import com.daniel.doktergizi.database.DBProfileAnak;
import com.daniel.doktergizi.service.AlarmReceiver;
import com.daniel.doktergizi.service.NotificationService;
import com.daniel.doktergizi.service.ScheduleClient;
import com.daniel.doktergizi.view.profileanak.ProfileAnak;
import com.daniel.doktergizi.view.reminder.ReminderCalender;

import android.R.string;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class menu extends Activity {
	private int RESULT_LOAD_IMAGE = 1;
	private ImageView imageView;
	private DBProfileAnak database;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);
		
		AlarmReceiver alarmReceiver = new AlarmReceiver();
		alarmReceiver.setAlarm(this);
		
		/**
		 * Creating all buttons instances
		 * */
		database = new DBProfileAnak(this);
		
		imageView = (ImageView) findViewById(R.id.FotoImage);

		Button gizidaurhidup = (Button) findViewById(R.id.gizidaurgidup);

		Button kalkulator = (Button) findViewById(R.id.kalkulator);

		Button news = (Button) findViewById(R.id.news);

		Button catatan = (Button) findViewById(R.id.catatan);
		
		this.checkSaveImage();
		
		//AlarmReceiver alarmReceiver = new AlarmReceiver();
		//alarmReceiver.setAlarm(this);
		
		/**
		 * Handling all button click events
		 * */

		// Listening to News Feed button click
		gizidaurhidup.setOnClickListener(new View.OnClickListener() {

			public void onClick(View view) {
				// Launching News Feed Screen
				Intent i = new Intent(getApplicationContext(),
						gizidaurhidup.class);
				startActivity(i);
			}
		});

		// Listening Friends button click
		kalkulator.setOnClickListener(new View.OnClickListener() {

			public void onClick(View view) {
				// Launching News Feed Screen
				Intent i = new Intent(getApplicationContext(),
						kalkulatorgizi.class);
				startActivity(i);
			}
		});

		// Listening Messages button click
		news.setOnClickListener(new View.OnClickListener() {

			public void onClick(View view) {
				// Launching News Feed Screen
				//Intent i = new Intent(getApplicationContext(),
					//	artikelgizi.class);
				Intent i = new Intent(getApplicationContext(), ReminderList.class);
				startActivity(i);
			}
		});

		// Listening to Places button click
		catatan.setOnClickListener(new View.OnClickListener() {

			public void onClick(View view) {
				// Launching News Feed Screen
				Intent i = new Intent(getApplicationContext(),
						ReminderCalender.class);
				startActivity(i);
			}
		});
		
		findViewById(R.id.FotoImage).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
				startActivityForResult(intent, RESULT_LOAD_IMAGE);
			}
		});
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.opt_menu, menu);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.portal:
			startActivity(new Intent(this, help.class));
			return true;
		case R.id.tentang1:
			startActivity(new Intent(this, aboutme.class));
			return true;
		case R.id.profilanak:
			startActivity(new Intent(this, ProfileAnak.class));
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
	
	private void checkSaveImage() {
		try {
			imageView.setImageBitmap(BitmapFactory.decodeFile(database.getImage()));
		} catch (Exception e) {
			// TODO: handle exception
		}
			
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data){
			Uri selectedImage = data.getData();
			String[] filePathColumn = {MediaStore.Images.Media.DATA};
			Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
			cursor.moveToFirst();
			int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
			String picturePath = cursor.getString(columnIndex);
			cursor.close();
			imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));
			database.saveImage(picturePath);
		}
	}

}