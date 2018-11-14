package com.example.joakk.aplicacion_test;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.joakk.aplicacion_test.utilidades.Utilidades;

import CtrlAndHelper.SqliteHelper;

public class Act3_ConsultProduct extends AppCompatActivity {

    EditText getName,campoName,  campoValorU, campoStock;

    SqliteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act3_consultprod);

        conn = new SqliteHelper(this, "BDProducts", null, 1);

        getName = findViewById(R.id.productName);

        campoName = findViewById(R.id.campoNombreProd);
        campoValorU = findViewById(R.id.campoValorUnitario);
        campoStock = findViewById(R.id.campoStock);
    }

    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btnSearch:
                consultar();
                break;
            case R.id.btnMod:
                actualizarProducto();
                break;
            case R.id.btnEliminar:
                eliminarProducto();
                break;
            case R.id.btnBack:
                onBackPressed();
                break;
        }
    }

    private void eliminarProducto() {
        SQLiteDatabase db = conn.getWritableDatabase();
        String[] params = {getName.getText().toString()};

        db.delete(Utilidades.TABLA_PRODUCTO, Utilidades.CAMPO_NOMBRE_PRODUCTO + "=?", params);
        Toast.makeText(this, "Se elimino el producto", Toast.LENGTH_SHORT).show();
        getName.setText("");
        limpiar();
        db.close();
    }

    private void actualizarProducto() {
        SQLiteDatabase db = conn.getWritableDatabase();
        String[] params = {getName.getText().toString()};

        ContentValues values = new ContentValues();
        values.put(Utilidades.CAMPO_NOMBRE_PRODUCTO, campoName.getText().toString());
        values.put(Utilidades.CAMPO_VALOR_UNITARIO, campoValorU.getText().toString());
        values.put(Utilidades.CAMPO_STOCK, campoStock.getText().toString());

        db.update(Utilidades.TABLA_PRODUCTO, values, Utilidades.CAMPO_NOMBRE_PRODUCTO+"=?", params);
        Toast.makeText(this, "Se modifico el producto", Toast.LENGTH_SHORT).show();
        db.close();
    }

    private void consultar() {
        SQLiteDatabase db = conn.getReadableDatabase();
        String[] params = {getName.getText().toString()};
        String[] campos = {Utilidades.CAMPO_NOMBRE_PRODUCTO, Utilidades.CAMPO_VALOR_UNITARIO, Utilidades.CAMPO_STOCK};

        try {
            Cursor cursor = db.query(Utilidades.TABLA_PRODUCTO, campos, Utilidades.CAMPO_NOMBRE_PRODUCTO + "=?", params, null, null, null);
            cursor.moveToFirst();
            campoName.setText(cursor.getString(0));
            campoValorU.setText(cursor.getString(1));
            campoStock.setText(cursor.getString(2));
            cursor.close();
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "El producto no existe", Toast.LENGTH_SHORT).show();
            limpiar();
        }
    }

    private void limpiar() {
        campoName.setText("");
        campoValorU.setText("");
        campoStock.setText("");
    }
}
