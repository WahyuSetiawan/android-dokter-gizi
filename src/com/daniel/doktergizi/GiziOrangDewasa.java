package com.daniel.doktergizi;

import com.daniel.doktergizi.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class GiziOrangDewasa extends Activity {

	String p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.giziorangdewasa);

			
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
		TextView p11tk = (TextView) findViewById(R.id.p11tk);
		TextView p12tk = (TextView) findViewById(R.id.p12tk);
		TextView p13tk = (TextView) findViewById(R.id.p13tk);
		
		String p1 = "Gizi Orang Dewasa";
		String p2 = "";
		String p3 = "    13 Pedoman Umum Gizi Seimbang";
		String p4 = "";
		String p5 = "	 1. Makanlah aneka ragam makanan";
		String p6 = "	 2. Makanlah pangan untuk memenuhi kecukupan energi";
		String p7 = "	 3. Makanlah sumber karobohidrat setengah dari kebutuhan energi. Konsumsi dibatasi antara 50-60 %, dg komposisi pangan. dari padi-padian 50 %, umbi2an 6 % dan gula 5 % (3-4 sdm)";
		String p8 = "	 4. Batasi konsumsi lemak dan minyak sampai seperempat dari kecukupan energi (Kisarannya 10 – 25 % atau 3-4 sdm minyak per hari)";
		String p9 =" 	 5. Gunakan ragam beryodium (6 g atau 1 sdm/hari)";
		String p10 ="     6.Makanlah sumber zat besi";
		String p11 ="	  7. Berikan ASI saja pada bayi sampai usia 4 bulan";
		String p12 ="	  8. Biasakan makan pagi";
		String p13 ="	  9. Minumlah air bersih, aman dan cukup jumlahnya Sekitar 2 lt atau 8 gelas";
		String p14 ="	  10. Lakukan kegiatan fisik dan olahraga secara teratur";
		String p15 ="	  11. Hindari minuman beralkohol";
		String p16 ="	  12. Makanlah pangan yang aman bagi kesehatan";
		String p17 ="	  13. Bacalah kandungan gizi pada label makanan kemasan";
		
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
		p11tk.setText(String.valueOf(p11));
		p12tk.setText(String.valueOf(p12));
		p13tk.setText(String.valueOf(p13));

	}	
}