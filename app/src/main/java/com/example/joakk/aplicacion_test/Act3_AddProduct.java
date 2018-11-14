package com.example.joakk.aplicacion_test;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.joakk.aplicacion_test.utilidades.Utilidades;

import CtrlAndHelper.SqliteHelper;

public class Act3_AddProduct extends AppCompatActivity {


    EditText etName, edtVU, edtStock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__add_product);



        etName = findViewById(R.id.etAdd);
        edtVU = findViewById(R.id.etVU);
        edtStock = findViewById(R.id.etStock);
    }

    public void onClick(View v){
        //registrarProducto();
        registrarProductoSql();
    }

    private void registrarProductoSql() {
        SqliteHelper admin = new SqliteHelper(this, "BDProducts", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();


        //insert into productos (nombre, valor, stock) values ();
        String insert ="INSERT INTO " + Utilidades.TABLA_PRODUCTO
                + " ( "
                + Utilidades.CAMPO_NOMBRE_PRODUCTO + "," +Utilidades.CAMPO_VALOR_UNITARIO +"," + Utilidades.CAMPO_STOCK +
                ") VALUES ('" +etName.getText().toString()+"',"+edtVU.getText().toString()+","+edtStock.getText().toString()+ ")";
        db.execSQL(insert);

        db.close();
    }

    private void registrarProducto() {
        SqliteHelper admin = new SqliteHelper(this, "BDProducts", null, 1);

        SQLiteDatabase db = admin.getWritableDatabase();

        ContentValues registroproducto = new ContentValues();
        registroproducto.put(Utilidades.CAMPO_NOMBRE_PRODUCTO, etName.getText().toString());
        registroproducto.put(Utilidades.CAMPO_VALOR_UNITARIO, edtVU.getText().toString());
        registroproducto.put(Utilidades.CAMPO_STOCK, edtStock.getText().toString());

        long result = db.insert(Utilidades.TABLA_PRODUCTO, Utilidades.CAMPO_NOMBRE_PRODUCTO, registroproducto);

        Toast.makeText(getApplicationContext(), "Nombre del producto añadido: " +result, Toast.LENGTH_SHORT).show();

        db.close();
        
        etName.setText("");
        edtStock.setText("");
        edtVU.setText("");
    }
    


    public void backActivity(View view) {
        onBackPressed();
    }
}
