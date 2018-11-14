package com.example.joakk.aplicacion_test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.startbtn);


    }

    public void sgteActividad(View v){
        Intent intent = new Intent(this, Act2_Start.class);
        startActivity(intent);
    }

}
