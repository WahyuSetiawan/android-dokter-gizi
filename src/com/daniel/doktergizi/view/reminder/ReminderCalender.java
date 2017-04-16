package com.daniel.doktergizi.view.reminder;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.Random;
import java.util.TimeZone;

import android.R.color;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.provider.CalendarContract.Instances;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.daniel.doktergizi.R;
import com.daniel.doktergizi.database.DBProfileAnak;
import com.daniel.doktergizi.model.entitas.Jadwal;

@SuppressLint({ "NewApi", "ShowToast" })
public class ReminderCalender extends Activity {
	public static final String[] INSTANCE_PROJECTION = new String[] {
			Instances.EVENT_ID, // 0
			Instances.BEGIN, // 1
			Instances.TITLE // 2
	};

	// The indices for the projection array above.

	private GridView calendar;
	private DBProfileAnak database;

	public Calendar month;
	public CalenderAdapter adapter;
	public Handler handler;
	public ArrayList<String> items;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.calendar);

		database = new DBProfileAnak(this);

		java.util.Date date = new java.util.Date();
		month = Calendar.getInstance();
		month.set(date.getYear(), date.getMonth(), date.getDate());
		onNewIntent(getIntent());

		items = new ArrayList<String>();
		adapter = new CalenderAdapter(this, this.month);

		calendar = (GridView) findViewById(R.id.gridView1);
		calendar.setAdapter(adapter);
		calendar.setOnItemClickListener(gridviewClickListener);

		handler = new Handler();
		handler.post(calendarUpdaterRunnable);

		TextView previous = (TextView) findViewById(R.id.previous);

		previous.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (month.get(Calendar.MONTH) == month
						.getActualMinimum(Calendar.MONTH)) {
					month.set((month.get(Calendar.YEAR) - 1),
							month.getActualMaximum(Calendar.MONTH), 1);
				} else {
					month.set(Calendar.MONTH, month.get(Calendar.MONTH) - 1);
				}
				refreshCalendar();
			}
		});

		TextView next = (TextView) findViewById(R.id.Next);

		next.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (month.get(Calendar.MONTH) == month
						.getActualMaximum(Calendar.MONTH)) {
					month.set((month.get(Calendar.YEAR) + 1),
							month.getActualMinimum(Calendar.MONTH), 1);
				} else {
					month.set(Calendar.MONTH, month.get(Calendar.MONTH) + 1);
				}
				refreshCalendar();
			}
		});
	}

	private void refreshCalendar() {
		// TODO Auto-generated method stub
		TextView title = (TextView) findViewById(R.id.monthyear);

		adapter.refreshDays();
		adapter.notifyDataSetChanged();
		handler.post(calendarUpdaterRunnable);

		title.setText(android.text.format.DateFormat.format("MMMM yyyy", month));
	}

	public void onNewIntent(Intent intent) {
		Calendar calendar = Calendar.getInstance();
		String date = calendar.get(Calendar.YEAR) + "-"
				+ calendar.get(Calendar.MONTH) + "-"
				+ calendar.get(Calendar.DATE);
		TextView title = (TextView) findViewById(R.id.monthyear);
		String[] dateArr = date.split("-");
		month.set(Integer.parseInt(dateArr[0]), Integer.parseInt(dateArr[1]),
				Integer.parseInt(dateArr[2]));

		title.setText(android.text.format.DateFormat.format("MMMM yyyy", month));
	}

	// listener

	OnItemClickListener gridviewClickListener = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// TODO Auto-generated method stub

			LinearLayout linearLayout = (LinearLayout) findViewById(com.daniel.doktergizi.R.id.text_field);
			linearLayout.removeAllViews();

			if (!adapter.getItem(position).toString().equals("")) {
				ArrayList<Jadwal> jadwals = database.getImunisasi(adapter
						.getItem(position).toString());

				for (Jadwal jadwal : jadwals) {
					
					TextView textView = new TextView(ReminderCalender.this);
					textView.setText(jadwal.getVaksin().getVaksin());
					
					FrameLayout frameLayout = new FrameLayout(ReminderCalender.this);
					frameLayout.addView(textView);
									
					linearLayout.addView(frameLayout);
					
					TextView text2 = new TextView(ReminderCalender.this);
					text2.setText("Keterangan = "
							+ jadwal.getVaksin().getKeterangan());
					
					linearLayout.addView(text2);
				}
			} else {
				TextView text = new TextView(ReminderCalender.this);
				text.setText("Tidak dapat menampilkan data");
				linearLayout.addView(text);
			}
		}
	};

	public Runnable calendarUpdaterRunnable = new Runnable() {
		public void run() {
			items.clear();

			for (int i = 0; i < 31; i++) {
				Random random = new Random();

				if (random.nextInt(10) > 6) {
					items.add(Integer.toString(i));
				}
			}

			adapter.setItems(items);
			adapter.notifyDataSetChanged();
		}
	};
}
