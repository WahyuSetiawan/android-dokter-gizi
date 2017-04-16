package com.daniel.doktergizi;

import com.phonegap.*;
import android.os.Bundle;

public class artikelgizi extends DroidGap {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.loadUrl("file:///android_asset/www/index.html");
	}
}