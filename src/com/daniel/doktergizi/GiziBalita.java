package com.daniel.doktergizi;

import com.daniel.doktergizi.R;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class GiziBalita extends TabActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gizibalita);
        
        TabHost tabHost = getTabHost();
        
        TabSpec karakteristik = tabHost.newTabSpec("");
        karakteristik.setIndicator("Karakteristik", getResources().getDrawable(R.drawable.style_arch));
        Intent karakteristikIntent = new Intent(this, GiziBalita1.class);
        karakteristik.setContent(karakteristikIntent);
        
        
        TabSpec masalah = tabHost.newTabSpec("Masalah Gizi");
        masalah.setIndicator("Masalah Gizi", getResources().getDrawable(R.drawable.style_mandriva));
        Intent masalahIntent = new Intent(this, GiziBalita2.class);
        masalah.setContent(masalahIntent);
        
            
        tabHost.addTab(karakteristik);
        tabHost.addTab(masalah); 
        
    }
}