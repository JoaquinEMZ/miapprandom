package com.example.joakk.aplicacion_test;

import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.Toast;



public class Act3_CtrlProfile2 extends FragmentActivity{

    private FragmentTabHost tabHost;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act3__ctrl_profile2);

        Resources res = getResources();

        tabHost = (FragmentTabHost) findViewById(R.id.tabhost);

        tabHost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);

        tabHost.addTab(tabHost.newTabSpec("CtrlProfile").setIndicator("", res.getDrawable(R.drawable.icon_settings)), Act3_CtrlProfile.class, null);
        tabHost.addTab(tabHost.newTabSpec("tablaVentas").setIndicator("", res.getDrawable(R.drawable.icon_plus)), Act3_Balance.class, null);

        /*final TabHost tabs = findViewById(android.R.id.tabhost);
        tabs.setup();

        spec = tabHost.newTabSpec("tablaProfile");
        spec.setContent(R.id.CtrolProfile);
        spec.setIndicator("",res.getDrawable(R.drawable.icon_settings));
        tabHost.addTab(spec);

        spec = tabHost.newTabSpec("tablaVentas");
        spec.setContent(R.id.CtrolVentas);
        spec.setIndicator("",res.getDrawable(R.drawable.icon_plus));
        tabHost.addTab(spec);

        tabHost.setCurrentTab(0);

        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                Toast.makeText(getApplicationContext(), "Pulsada pestaña: " + tabId, Toast.LENGTH_SHORT).show();
            }
        });*/


    }


}
