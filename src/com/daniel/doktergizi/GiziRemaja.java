package com.daniel.doktergizi;

import com.daniel.doktergizi.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class GiziRemaja extends Activity {

	String p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.giziremaja);

			
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
		
		String p1 = "Kebutuhan Gizi Remaja";
		String p2 = "    Energi:";
		String p3 = "Sangat diperlukan dalam jumlah banyak untuk pertumbuhan dan aktivitaas yang meningkat pada usia tersebut";
		String p4 = "Protein:";
		String p5 = "Kecukupan protein per kg BB relatif lbh rendah dibanding masa sebelumnya: 7-8 % dari total energi atau 45-72 g per hari.";
		String p6 = "    Dilihat secara total kebt protein meningkat, karena:";
		String p7 = "Peningkatan massa tubuh tak berlemak";
		String p8 = "Kebutuhan eritrosit dan myoglobin";
		String p9 = "Perubahan hormonal";
		String p10 = "Pada Perempuan yang diet energi maka protein akan digunakan untuk glukoneogenesis (menghasilkan energi)";
		String p11 = "Vitamin:";
		String p12 = "Vit B (tiamin, riboflavin, niasin) diperlukan dalam jumlah cukup karena memerlukan energi banyak";
		String p13 = "Vit D sangat penting untuk pembentukan tulang (rangka)";
		String p14 = "Kebutuhan Vit A, E, C, As.Folat & B6 sama dengan dewasa";
		String p15 = "Mineral:";
		String p16 = "Sejumlah mineral yang berpeluang defisiensi: besi, kalsium dan seng krn banyak dibutuhkan untuk materi pertumbuhan.";
		
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
		
	}	
}