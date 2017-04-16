package com.daniel.doktergizi;

import com.daniel.doktergizi.R;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class giziatas extends TabActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.giziatas);
        
        TabHost tabHost = getTabHost();
        
        TabSpec gizibayi = tabHost.newTabSpec("Gizi Bayi");
        gizibayi.setIndicator("Gizi Bayi", getResources().getDrawable(R.drawable.style_arch));
        Intent gizibayiIntent = new Intent(this, GiziBayi.class);
        gizibayi.setContent(gizibayiIntent);
        
        
        TabSpec giziasi = tabHost.newTabSpec("Gizi dan ASI");
        giziasi.setIndicator("Gizi dan ASI", getResources().getDrawable(R.drawable.style_mandriva));
        Intent giziasiIntent = new Intent(this, GizidanASI.class);
        giziasi.setContent(giziasiIntent);
        
            
        tabHost.addTab(gizibayi);
        tabHost.addTab(giziasi); 
        
    }
}