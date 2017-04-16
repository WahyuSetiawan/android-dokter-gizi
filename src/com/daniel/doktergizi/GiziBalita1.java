package com.daniel.doktergizi;

import com.daniel.doktergizi.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class GiziBalita1 extends Activity {

	String p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gizibalita1);

			
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
		
		String p1 = "KARAKTERISTIK GIZI BALITA";
		String p2 = "";
		String p3 = "- Disebut juga usia : pra - sekolah";
		String p4 = "- Batasan umur 3 – 5 tahun";
		String p5 = "- Mampu mengatakan “tidak” terhadap makanan yang ditawarkan";
		String p6 = "- Saat tepat ditanamkan kebiasaan makan yang baik";
		String p7 = "PENATALAKSANAAN GIZI";
		String p8 = "1. Kembangkan kebiasaan makan yang baik anak sejak dini diperkenalkan dengan makanan beragam kebiasaan makan orang tua sangat mempengaruhi anak";
		String p9 = "2. Hindari pengucapan ketidaksenangan terhadap makanan di hadapan anak";
		String p10 = "3. Hormati kesukaan anak terhadap makanan tertentu pelan-pelan ubah ke arah kebiasaan makan yang baik";
		String p11 = "4. Biarkan anak mencoba makan sendiri";
		String p12 = "5. Minimumkan risiko obesitas dengan menghindari makanan yang melebihi kebutuhan";
		String p13 = "6. Jika anak masih terasa lapar dapat diberi buah yang memberi rasa kenyang";	
		String p14 = "7. Promosikan kesehatan gigi";
				
		
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
		
	}	
}