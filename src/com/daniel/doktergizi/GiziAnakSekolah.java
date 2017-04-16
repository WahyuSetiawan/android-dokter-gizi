package com.daniel.doktergizi;

import com.daniel.doktergizi.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class GiziAnakSekolah extends Activity {

	String p1, p2, p3, p4, p5, p6, p7, p8, p9, p10;
	
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
		TextView p8tk = (TextView) findViewById(R.id.p8tk);
		TextView p9tk = (TextView) findViewById(R.id.p9tk);
		TextView p10tk = (TextView) findViewById(R.id.p10tk);
		
		String p1 = "GIZI ANAK SEKOLAH";
		String p2 = "    Pertumbuhan dan Perkembangan anak usia Sekolah Dasar: :";
		String p3 = "1.  Jasmani";
		String p4 = "    Periode ini disebut periode memanjang secara fisik. Fungsi organ otak mulai terbentuk mantap sehingga perkembangan kecerdasannya cukup pesat. ";
		String p5 = "2.  Jiwani";
		String p6 = "    Anak mulai banyak melihat dan bertanya, fantasinya berkurang karena melihat kenyataan, ingatan kuat, daya kritis mulai tumbuh, ingin berinisiatif dan bertanggung jawab.";
		String p7 = "3.  Rohani";
		String p8 = "	 Anak mulai memasukkan dalam pikirannya tentang Tuhan mulai memisahkan konsep pikiran tentang Tuhan dengan orangtuanya.";
		String p9 = "4.  Sosial";
		String p10 =    "Kegiatan anak mulai berkelompok dan mengarah pada tujuan tetapi masih egosentris.";
		
		p1tk.setText(String.valueOf(p1));
		p2tk.setText(String.valueOf(p2));
		p3tk.setText(String.valueOf(p3));
		p4tk.setText(String.valueOf(p4));
		p5tk.setText(String.valueOf(p5));
		p6tk.setText(String.valueOf(p6));
		p7tk.setText(String.valueOf(p7));
		p8tk.setText(String.valueOf(p8));
		p9tk.setText(String.valueOf(p9));
		p10tk.setText(String.valueOf(p10));
	}	
}