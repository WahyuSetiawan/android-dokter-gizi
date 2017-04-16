package com.daniel.doktergizi;

import com.daniel.doktergizi.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class GiziBayi extends Activity {

	String p1, p2, p3, p4, p5, p6, p7, p8, p9;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gizibayi);

			
		TextView p1tk = (TextView) findViewById(R.id.p1tk);
		TextView p2tk = (TextView) findViewById(R.id.p2tk);
		TextView p3tk = (TextView) findViewById(R.id.p3tk);
		TextView p4tk = (TextView) findViewById(R.id.p4tk);
		TextView p5tk = (TextView) findViewById(R.id.p5tk);
		TextView p6tk = (TextView) findViewById(R.id.p6tk);
		TextView p7tk = (TextView) findViewById(R.id.p7tk);
		TextView p8tk = (TextView) findViewById(R.id.p8tk);
		TextView p9tk = (TextView) findViewById(R.id.p9tk);
		
		String p1 = "GIZI BAYI";
		String p2 = "- Tahapan Bayi merupakan tahapan kehidupan pertama setelah manusia dilahirkan.";
		String p3 = "- Laju pertumbuhan selama sebelum lahir dan sewaktu bayi lebih cepat dari tahapan kehidupan lain setelahnya.";
		String p4 = "- Kehidupan yang pertama-tama adalah paling rawan untuk pertumbuhan dan perkembangan.";
		String p5 = "- Pertumbuhan adalah perubahan ukuran fisik dari waktu ke waktu, baik dari segi DIMENSI,PROPORSI, maupun KOMPOSISI tubuh.";
		String p6 = "- Pada manusia, ukuran fisik (tubuh) disebut juga dengan istilah ANTROPOMETRI.";
		String p7 = "- Bayi sesaat dilahirkan akan melakukan penyesuaian diri terhadap suhu, pernafasan, sirkulasi darah, pencernaan dan proses pengosongan (buang air kecil dan besar) sehingga berat badan turun.";
		String p8 = "- Pada waktu bayi berumur 10 hari sampai 14 hari berat badan waktu lahir tercapai kembali.";
		String p9 = "- Perkembangan adalah perubahan kemampuan anak dalam gerakan motorik kasar/halus,kecerdasan, mental,perilaku dari waktu ke waktu.";
		
		p1tk.setText(String.valueOf(p1));
		p2tk.setText(String.valueOf(p2));
		p3tk.setText(String.valueOf(p3));
		p4tk.setText(String.valueOf(p4));
		p5tk.setText(String.valueOf(p5));
		p6tk.setText(String.valueOf(p6));
		p7tk.setText(String.valueOf(p7));
		p8tk.setText(String.valueOf(p8));
		p9tk.setText(String.valueOf(p9));
	}	
}