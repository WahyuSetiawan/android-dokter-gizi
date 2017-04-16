package com.daniel.doktergizi;

import com.daniel.doktergizi.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class GiziBalita2 extends Activity {

	String p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, p19, p20, p21;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gizibalita2);
			
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
		TextView p14tk = (TextView) findViewById(R.id.p14tk);
		TextView p15tk = (TextView) findViewById(R.id.p15tk);
		TextView p16tk = (TextView) findViewById(R.id.p16tk);
		TextView p17tk = (TextView) findViewById(R.id.p17tk);
		TextView p18tk = (TextView) findViewById(R.id.p18tk);
		TextView p19tk = (TextView) findViewById(R.id.p19tk);
		TextView p20tk = (TextView) findViewById(R.id.p20tk);
		TextView p21tk = (TextView) findViewById(R.id.p21tk);
		
		
		String p1 = "MASALAH GIZI ANAK BALITA";
		String p2 = "1. Berat badan kurang";
		String p3 = "   - Mencerminkan kebiasaan makan yang buruk";
		String p4 = "   - Penanganannya difokuskan pada penyebab & alternatif pemecahannya";
		String p5 = "2. Berat badan berlebih";
		String p6 = "   - Penyebabnya terlalu banyak makan, kurang gerak / olahraga";
		String p7 = "   - Jika tidak cepat diatasi dapat berlanjut s/d dewasa";
		String p8 = "3. Karies gigi";
		String p9 = "   - Terjadi karena makan cemilan yg lengket & mengandung gula (permen, kue + krim, minuman manis, keripik kentang)";
		String p10 = "  - Makanan yang baik bagi gigi : buah segar, pop corn, yogurt, keju";
		String p11 = "4. Alergi makanan";
		String p12 = "   - Lebih berisiko dengan keluarga yang mempunyai riwayat alergi";
		String p13 = "	 - Dapat bersifat sementara / menetap";	
		String p14 = "	 - Alergi yang dapat reda sendiri :  telur, kacang-kacangan, terigu";
		String p15 = "	 - Alergi yang cenderung menetap: ikan, kerang";
		String p16 = "5. Anemia defisiensi gizi besi";	
		String p17 = "	 - Terutama pada anak yang banyak mengkonsumsi susu tetapi kurang minat menyantap makanan lain.";
		String p18 = "	 - Kurangi porsi susu, ganti dengan makanan/minuman yang banyak zat besi atau membantu penyerapan zat besi.";
		String p19 = "6. Pica";	
		String p20 = "	 - Mengkonsumsi sesuatu yang bukan makanan (perca, kertas, minyak, dll). Namun harus dihindari.";
		String p21 = "	 - Tidak berbahaya bagi kesehatan, kecuali menyantap zat toksik";
		
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
		p14tk.setText(String.valueOf(p14));
		p15tk.setText(String.valueOf(p15));
		p16tk.setText(String.valueOf(p16));
		p17tk.setText(String.valueOf(p17));
		p18tk.setText(String.valueOf(p18));
		p19tk.setText(String.valueOf(p19));
		p20tk.setText(String.valueOf(p20));
		p21tk.setText(String.valueOf(p21));
		
		
	}	
}