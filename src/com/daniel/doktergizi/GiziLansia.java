package com.daniel.doktergizi;

import com.daniel.doktergizi.R;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class GiziLansia extends TabActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gizilansia);
        
        TabHost tabHost = getTabHost();
        
        TabSpec karakteristik = tabHost.newTabSpec("");
        karakteristik.setIndicator("Karakteristik", getResources().getDrawable(R.drawable.style_arch));
        Intent karakteristikIntent = new Intent(this, GiziLansia1.class);
        karakteristik.setContent(karakteristikIntent);
        
        
        TabSpec faktor = tabHost.newTabSpec("Faktor Gizi");
        faktor.setIndicator("Faktor Gizi", getResources().getDrawable(R.drawable.style_mandriva));
        Intent faktorIntent = new Intent(this, GiziLansia2.class);
        faktor.setContent(faktorIntent);
        
            
        tabHost.addTab(karakteristik);
        tabHost.addTab(faktor); 
        
    }
}