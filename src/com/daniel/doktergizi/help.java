package com.daniel.doktergizi;

import java.util.Calendar;

import com.daniel.doktergizi.R;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.os.Bundle;
import android.widget.TextView;

public class help extends Activity {

	String p1, p2, p3, p4;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gizianaksekolah);

			
		TextView p1tk = (TextView) findViewById(R.id.p1tk);
		TextView p2tk = (TextView) findViewById(R.id.p2tk);
		TextView p3tk = (TextView) findViewById(R.id.p3tk);
		TextView p4tk = (TextView) findViewById(R.id.p4tk);
		
		String p1 = "Bantuan";
		String p2 = "    DokterGizi adalah aplikasi mobile yang berkenaan dengan ilmu gizi. Sebenarnya seseorang yang ahli di bidang ilmu gizi disebut ahli gizi atau dalam bahasa Inggrisnya Nutritionis. Namun, saya lebih tertarik menggunakan nama DokterGizi dalam aplikasi ini.";
		String p3 = "	 Di Aplikasi ini anda dapat melihat informasi mengenai daur hidup gizi, menghitung berat badan ideal (BBI), memperbaharui informasi mengenai gizi, dan menuliskannya di bagian catatan. Catatan dapat digunakan dengan menekan tombol menu pada gadget Anda. Sebagian informasi yang terdapat di aplikasi ini disadur dari http://gizi.depkes.go.id dan sumber internet lainnya.";
		String p4 = "    Aplikasi ini tentu tidak lepas dari kekurangan. Oleh karena itu, saya menunggu kritik dan saran dari teman-teman sekalian di e-mail saya: danielsilalahi454@gmail.com";
		
		
		p1tk.setText(String.valueOf(p1));
		p2tk.setText(String.valueOf(p2));
		p3tk.setText(String.valueOf(p3));
		p4tk.setText(String.valueOf(p4));
	}	
}