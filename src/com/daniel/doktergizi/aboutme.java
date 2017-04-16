package com.daniel.doktergizi;

import com.daniel.doktergizi.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class aboutme extends Activity {

	String p1, p2, p3, p4, p5, p6, p7;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gizianaksekolah);

			
		TextView p1tk = (TextView) findViewById(R.id.p1tk);
		TextView p2tk = (TextView) findViewById(R.id.p2tk);
		TextView p3tk = (TextView) findViewById(R.id.p3tk);
		TextView p4tk = (TextView) findViewById(R.id.p4tk);
		TextView p5tk = (TextView) findViewById(R.id.p5tk);
		TextView p6tk = (TextView) findViewById(R.id.p6tk);
		TextView p7tk = (TextView) findViewById(R.id.p7tk);
		
		String p1 = "Tentang Saya";
		String p2 = "   Aplikasi DokterGizi ini dibuat oleh Daniel Frederik Silalahi, Mahasiswa Jurusan Tekhnik Informatika UPN YOgyakarta.";
		String p3 = " ";
		String p4 = "	Facebook : Daniel Silalahi";
		String p5 = "	Twitter   : @legate_daniel";
		String p6 = "	Blog	  : niel-neil.blogspot.com";
		String p7 = "      HP		: 0812 6481 908"; 
		
		p1tk.setText(String.valueOf(p1));
		p2tk.setText(String.valueOf(p2));
		p3tk.setText(String.valueOf(p3));
		p4tk.setText(String.valueOf(p4));
		p5tk.setText(String.valueOf(p5));
		p6tk.setText(String.valueOf(p6));
		p7tk.setText(String.valueOf(p7));
	}	
}