package com.daniel.doktergizi.view.reminder;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.daniel.doktergizi.R;
import com.daniel.doktergizi.database.DBProfileAnak;
import com.daniel.doktergizi.util.Utility;

import android.R.integer;
import android.R.raw;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CalenderAdapter extends BaseAdapter {
	static final int FIRST_DAY_OF_WEEK = 0;
	private Context mContext;
	private DBProfileAnak database;

	private Calendar month;
	private Calendar selectedDate;
	private ArrayList<String> items;
	public String[] days;

	public CalenderAdapter(Context context, Calendar monthCalendar) {
		month = monthCalendar;
		selectedDate = (Calendar) monthCalendar.clone();
		mContext = context;
		month.set(Calendar.DAY_OF_MONTH, 1);
		this.items = new ArrayList<String>();
		refreshDays();

		database = new DBProfileAnak(context);
	}

	public void refreshDays() {
		items.clear();

		int lastDay = month.getActualMaximum(Calendar.DAY_OF_MONTH);
		int firstDay = (int) month.get(Calendar.DAY_OF_WEEK);

		// figure size of the array
		if (firstDay == 1) {
			days = new String[lastDay + (FIRST_DAY_OF_WEEK * 6)];
		} else {
			days = new String[lastDay + firstDay - (FIRST_DAY_OF_WEEK + 1)];
		}

		int j = FIRST_DAY_OF_WEEK;

		// populate empty days before first real day
		if (firstDay > 1) {
			for (j = 0; j < firstDay - FIRST_DAY_OF_WEEK; j++) {
				days[j] = "";
			}
		} else {
			for (j = 0; j < FIRST_DAY_OF_WEEK * 6; j++) {
				days[j] = "";
			}
			j = FIRST_DAY_OF_WEEK * 6 + 1; // sunday => 1, monday => 7
		}

		// populate days
		int dayNumber = 1;
		for (int i = j - 1; i < days.length; i++) {
			days[i] = "" + dayNumber;
			dayNumber++;
		}
	}

	// references to our items

	public void setItems(ArrayList<String> items) {
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).length() == 1) {
				items.set(i, "0" + items.get(i));
			}
		}

		this.items = items;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return days.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		Date date = month.getTime();

		if (days[position].equals("")) {
			return "";
		} else {
			date.setDate(Integer.valueOf(days[position]));
			
			return new Utility().getDateTime(date).toString();
		}
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View v = convertView;
		TextView dayView;
		if (convertView == null) { // if it's not recycled, initialize some
									// attributes
			LayoutInflater vi = (LayoutInflater) mContext
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v = vi.inflate(R.layout.calendar_item, null);
		}
		dayView = (TextView) v.findViewById(R.id.date);

		// disable empty days from the beginning
		if (days[position].equals("")) {
			dayView.setClickable(false);
			dayView.setFocusable(false);
		} else {
			// mark current day as focused
			if (month.get(Calendar.YEAR) == selectedDate.get(Calendar.YEAR)
					&& month.get(Calendar.MONTH) == selectedDate
							.get(Calendar.MONTH)
					&& days[position].equals(""
							+ selectedDate.get(Calendar.DAY_OF_MONTH))) {
				v.setBackgroundResource(R.drawable.item_background_focused);
				// v.setBackgroundColor(Color.WHITE);
			} else {
				v.setBackgroundResource(R.drawable.list_item_background);
				// v.setBackgroundColor(Color.WHITE);
			}
		}

		dayView.setText(days[position]);
		dayView.setTextColor(Color.BLACK);

		// create date string for comparison
		String date = days[position];

		if (date.length() == 1) {
			date = "0" + date;
		}
		String monthStr = "" + (month.get(Calendar.MONTH) + 1);
		if (monthStr.length() == 1) {
			monthStr = "0" + monthStr;
		}

		if (!days[position].equals("")) {
			// show icon if date is not empty and it exists in the items array
			ImageView iw = (ImageView) v.findViewById(R.id.date_icon);
			// f (date.length() > 0 && items != null && items.contains(date)) {
			Utility utility = new Utility();
			boolean activity = database.getActivityCalendar(utility
					.getDateTime(month.getTime()));

			if (activity) {
				iw.setVisibility(View.VISIBLE);
			} else {
				iw.setVisibility(View.INVISIBLE);
			}
		}else{
			ImageView iw = (ImageView) v.findViewById(R.id.date_icon);
			
			iw.setVisibility(View.INVISIBLE);			
		}
		return v;
	}

}
