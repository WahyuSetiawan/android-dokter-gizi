package com.daniel.doktergizi;

import com.daniel.doktergizi.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class kalkulatorgizi2 extends Activity {
	private EditText txtumur;
	private Button hitung;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.kalkulatorgizi2);
		txtumur = (EditText) findViewById(R.id.txtumur);
		hitung = (Button) findViewById(R.id.hitung);
	}

	public void hitung(View view) {
		try {

			int umur = Integer.parseInt(txtumur.getText().toString());
			int hasil = (umur*2)+8;
			TextView hasil2 = (TextView) findViewById(R.id.txthasil);
			hasil2.setText(String.valueOf("Berat Badan Ideal anak umur " + umur + " tahun adalah " + hasil + " kg"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}