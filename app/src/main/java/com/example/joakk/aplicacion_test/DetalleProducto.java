package com.example.joakk.aplicacion_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.joakk.aplicacion_test.entidades.productos;

public class DetalleProducto extends AppCompatActivity {

    TextView campoName, campoValor, campoStocker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_producto);

        campoName = findViewById(R.id.tvNombre);
        campoValor = findViewById(R.id.tvValorUnitario);
        campoStocker = findViewById(R.id.tvStock);

        Bundle objetoEnviado = getIntent().getExtras();

        productos product = null;

        if(objetoEnviado != null) {
            product = (productos) objetoEnviado.getSerializable("producto");
            campoName.setText(product.getNombre_producto().toString());
            campoValor.setText(String.valueOf(product.getValor_unitario()));
            campoStocker.setText(String.valueOf(product.getStock()) );
        }
    }


}
