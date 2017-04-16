package com.daniel.doktergizi;

import com.daniel.doktergizi.R;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class kalkulatorgizi extends TabActivity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.kalkulatorgizi);

		TabHost tabHost = getTabHost();

		TabSpec bayi = tabHost.newTabSpec(" BBI untuk umur 0-12 bulan");
		bayi.setIndicator(" BBI untuk umur 0-12 bulan", getResources()
				.getDrawable(R.drawable.style_arch));
		Intent bayiIntent = new Intent(this, kalkulatorgizi1.class);
		bayi.setContent(bayiIntent);

		TabSpec balita = tabHost.newTabSpec(" BBI untuk umur 1-10 tahun");
		balita.setIndicator(" BBI untuk umur 1-10 tahun", getResources()
				.getDrawable(R.drawable.style_mandriva));
		Intent balitaIntent = new Intent(this, kalkulatorgizi2.class);
		balita.setContent(balitaIntent);

		TabSpec remaja = tabHost.newTabSpec(" BBI untuk remaja & dewasa");
		remaja.setIndicator(" BBI untuk remaja & dewasa", getResources()
				.getDrawable(R.drawable.style_mandriva));
		Intent remajaIntent = new Intent(this, kalkulatorgizi3.class);
		remaja.setContent(remajaIntent);

		tabHost.addTab(bayi);
		tabHost.addTab(balita);
		tabHost.addTab(remaja);
	}
}