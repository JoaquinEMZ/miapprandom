package com.example.joakk.aplicacion_test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Act2_Start extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana1__start);





    }




    public void ctrlActivity(View v){
        Intent intent = new Intent(this, Act3_CtrlProfile2.class);
        startActivity(intent);
    }


}
