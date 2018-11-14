package com.example.joakk.aplicacion_test;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.example.joakk.aplicacion_test.entidades.productos;
import com.example.joakk.aplicacion_test.utilidades.Utilidades;

import java.util.ArrayList;

import CtrlAndHelper.SqliteHelper;


public class Act3_ListProducts extends AppCompatActivity {

    ListView lvProductos;

    SqliteHelper conn;
    ArrayList<String> listaInformacion;
    ArrayList<productos> listaProductos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_prod);


        lvProductos = findViewById(R.id.lvProductos);


        conn = new SqliteHelper(this, "BDProducts", null, 1);

        consultarListaProductos();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.list_products, listaInformacion);
        lvProductos.setAdapter(adapter);

        lvProductos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                productos products = listaProductos.get(pos);

                Intent intent = new Intent(Act3_ListProducts.this, DetalleProducto.class);

                Bundle bundle = new Bundle();

                bundle.putSerializable("producto", products);

                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    private void consultarListaProductos() {
        SQLiteDatabase db = conn.getReadableDatabase();

        productos productos;

        listaProductos = new ArrayList<>();
        //select * from productos
        Cursor cursor = db.rawQuery("SELECT * FROM " + Utilidades.TABLA_PRODUCTO, null);

        while(cursor.moveToNext()){
            productos = new productos();
            productos.setNombre_producto(cursor.getString(0));
            productos.setValor_unitario(cursor.getInt(1));
            productos.setStock(cursor.getInt(2));

            listaProductos.add(productos);
        }
        obtenerLista();
    }

    private void obtenerLista() {
        listaInformacion = new ArrayList<String>();

        for(int i = 0; i<listaProductos.size();i++){
            listaInformacion.add(listaProductos.get(i).getNombre_producto());
        }
    }

    public void back(View v){
        onBackPressed();
    }
}
