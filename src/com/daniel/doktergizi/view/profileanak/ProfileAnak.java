package com.daniel.doktergizi.view.profileanak;

import com.daniel.doktergizi.R;
import com.daniel.doktergizi.database.DBProfileAnak;
import com.daniel.doktergizi.model.entitas.Profile;
import com.daniel.doktergizi.util.UtilityReminder;
import com.daniel.doktergizi.util.Utility;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

public class ProfileAnak extends Activity {
	private DBProfileAnak database;

	private TextView textNama;
	private DatePicker textTanggal;
	private Spinner spinerJenisKelamin;
	
	public UtilityReminder util;
	public Utility utility;

	private String selectedSpinner;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.profileanak);

		// instance variable
		database = new DBProfileAnak(this);
		spinerJenisKelamin = (Spinner) findViewById(R.id.SpinnerJenisKelamin);
		textNama = (TextView) findViewById(R.id.profiletextNama);
		textTanggal = (DatePicker) findViewById(R.id.datePicker1);
		
		util = new UtilityReminder(this);
		utility = new Utility();

		// set adapter to adapter into spinner

		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
				this, R.array.jenisKelamin,
				android.R.layout.simple_spinner_item);
		spinerJenisKelamin.setAdapter(adapter);

		// register action Listener
		findViewById(R.id.buttonprofileSimpan).setOnClickListener(simpanButton);
		findViewById(R.id.buttonProfileBatal).setOnClickListener(batalButton);
		spinerJenisKelamin.setOnItemSelectedListener(spinnerListener);
	}
	
	// listerner adapter
	
	OnClickListener batalButton = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			finish();
		}
	};

	OnClickListener simpanButton = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			database.saveProfile(new Profile(textNama.getText().toString(),
					utility.getDateFromDatePicker(textTanggal).getTime(), selectedSpinner
							.toString()));
			util.resetReminder(utility.getDateFromDatePicker(textTanggal));
			finish();
		}
	};

	OnItemSelectedListener spinnerListener = new OnItemSelectedListener() {

		@Override
		public void onItemSelected(AdapterView<?> parent, View view,
				int position, long id) {
			// TODO Auto-generated method stub
			selectedSpinner = parent.getItemAtPosition(position).toString();
		}

		@Override
		public void onNothingSelected(AdapterView<?> parent) {
			// TODO Auto-generated method stub
			selectedSpinner = "";
		}

	};
}
