package com.daniel.doktergizi;

import java.util.ArrayList;

import com.daniel.doktergizi.R.id;
import com.daniel.doktergizi.database.DBProfileAnak;
import com.daniel.doktergizi.model.entitas.Jadwal;

import android.R.color;
import android.R.integer;
import android.R.interpolator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RadioButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.ToggleButton;

public class ReminderList extends Activity {
	TableLayout tableStat;
	DBProfileAnak database = new DBProfileAnak(this);
	ArrayList<Object> id_checked = new ArrayList<Object>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.reminder_status);
		tableStat = (TableLayout) findViewById(R.id.tableStatus);
		
		fillTableStatus();
	}

	private void fillTableStatus() {
		// TODO Auto-generated method stub
		ArrayList<TableRow> tableRows = new ArrayList<TableRow>();

		TextView viewIDgejala = new TextView(this);
		viewIDgejala.setText("ID");

		TextView viewKetGejalaTextView = new TextView(this);
		viewKetGejalaTextView.setText("TANGGAL MULAI");
		
		TextView view1 = new TextView(this);
		view1.setText("TANGGAL BERAKHIR");

		TextView view2 = new TextView(this);
		view2.setText("KETERANGAN");

		TableRow rowTitle = new TableRow(this);
		rowTitle.addView(viewIDgejala);
		rowTitle.addView(viewKetGejalaTextView);
		rowTitle.addView(view1);
		rowTitle.addView(view2);

		tableRows.add(rowTitle);
		
		for (final Jadwal jadwal : database.selectAllJadwal()) {
			TextView column_id_gejala = new TextView(this);
			column_id_gejala.setText(jadwal.getVaksin().getVaksin());
			column_id_gejala.setWidth(100);
			TextView column_ket_gejala = new TextView(this);
			column_ket_gejala.setText(jadwal.getTanggalMulai().toString());
			column_ket_gejala.setWidth(260);
			TextView tanggalBerakhir = new TextView(this);
			tanggalBerakhir.setText(jadwal.getTanggalBerakhir().toString());
			tanggalBerakhir.setWidth(260);
			ToggleButton toggleButton  = new ToggleButton(this);
			if(jadwal.getStatus() == 1){
				toggleButton.setChecked(true);
			}else {
				toggleButton.setChecked(false);
			}
			toggleButton.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				
				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					// TODO Auto-generated method stub
					System.err.println(isChecked);
					if(isChecked){
						database.updateReminderSetTrue(jadwal.getId());
					}else{
						database.updateReminderSetFalse(jadwal.getId());
					}
				}
			});
			TableRow tableRow = new TableRow(this); 
			tableRow.addView(column_id_gejala);
			tableRow.addView(column_ket_gejala);
			tableRow.addView(tanggalBerakhir);
			tableRow.addView(toggleButton);
			tableRows.add(tableRow);
		}

		for (TableRow tableRow : tableRows) {
			tableStat.addView(tableRow);
		}
	}
	
	
}
