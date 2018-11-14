package com.example.joakk.aplicacion_test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import CtrlAndHelper.SqliteHelper;

public class Act3_CtrlProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana_contrl);

        SqliteHelper admin = new SqliteHelper(this, "BDProducts", null, 1);
    }

    public void activityListProducts(View v){
        Intent intent = new Intent(this, Act3_ListProducts.class);
        startActivity(intent);
    }
    public void activityAddProducts(View v){
        Intent intent = new Intent(this, Act3_AddProduct.class);
        startActivity(intent);
    }

    public void activityConsultBalance(View view) {
        Intent intent = new Intent(this, Act3_ConsultProduct.class);
        startActivity(intent);
    }
}
