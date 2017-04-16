package com.daniel.doktergizi;

import com.daniel.doktergizi.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class kalkulatorgizi3 extends Activity {
	private EditText txttinggibadan;
	private Button hitung;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.kalkulatorgizi3);
		txttinggibadan = (EditText) findViewById(R.id.txttinggibadan);
		hitung = (Button) findViewById(R.id.hitung);
	}

	public void hitung(View view) {
		try {

			int tinggibadan = Integer.parseInt(txttinggibadan.getText().toString());
			int hasil = (tinggibadan-100)*90/100;
			TextView ket = (TextView) findViewById(R.id.txthasil);
			ket.setText(String.valueOf("Berat Badan Ideal dengan tinggi badan " + tinggibadan + " cm adalah " +hasil+ " kg"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}